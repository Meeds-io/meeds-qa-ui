/*
 * This file is part of the Meeds project (https://meeds.io/).
 * 
 * Copyright (C) 2020 - 2023 Meeds Association contact@meeds.io
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT;
import static io.meeds.qa.ui.utils.Utils.DEFAULT_WAIT_FOR_TIMEOUT;
import static io.meeds.qa.ui.utils.Utils.DEFAULT_WAIT_PAGE_LOADING;
import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import java.io.File;
import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.meeds.qa.ui.elements.ButtonElementFacade;
import io.meeds.qa.ui.elements.ButtonElementFacadeImpl;
import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.ElementFacadeImpl;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacadeImpl;
import io.meeds.qa.ui.elements.TextElementFacade;
import io.meeds.qa.ui.elements.TextElementFacadeImpl;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;

public class BasePageImpl extends PageObject implements BasePage {

  protected static final Logger LOGGER                      = LoggerFactory.getLogger(BasePageImpl.class);

  private static final String   OPNENED_DRAWER_CSS_SELECTOR = ".v-navigation-drawer--open";

  public static final String    UPLOAD_DIRECTORY_PATH       =
                                                      GenericPage.class.getResource(File.separator + "DataFiles" + File.separator)
                                                                       .getFile();

  public static final String    USER_AVATAR_PNG             = "cap02.png";

  protected String              url;

  public BasePageImpl() {
    this(null);
  }

  public BasePageImpl(WebDriver driver) {
    super(driver);
  }

  public void clickOnElement(ElementFacade element) {
    element.click();
  }

  public void closeAlertIfOpened() {
    try {
      getDriver().switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
      // Normal Behavior
    }
  }

  public void clickToConfirmDialog() {
    ElementFacade okButton = findByXPathOrCSS("//*[contains(@class, 'v-dialog--active')]//button[contains(@class, 'primary')]");
    if (okButton.isVisible()) {
      okButton.click();
      okButton.waitUntilNotVisible();
    }
  }

  public void closeConfirmDialogIfDisplayed() {
    ElementFacade okButton = findByXPathOrCSS("//*[contains(@class, 'v-dialog--active')]//button[contains(@class, 'primary')]");
    if (okButton.isCurrentlyVisible()) {
      okButton.click();
      okButton.waitUntilNotVisible();
    }
  }

  public void clickToCancelDialog() {
    ElementFacade cancelButton =
                               findByXPathOrCSS("//*[contains(@class, 'v-dialog--active')]//button[not(contains(@class, 'primary'))]");
    cancelButton.click();
    cancelButton.waitUntilNotVisible();
  }

  public void closeDisplayedAlert() {
    ElementFacade closeAlertButton = findByXPathOrCSS(".v-snack--active .v-alert .v-alert__dismissible");
    if (closeAlertButton.isVisible()) {
      try {
        closeAlertButton.click();
        closeAlertButton.waitUntilNotVisible();
      } catch (Exception e) {
        // It can be already closed by timeout
      }
    } else {
      closeAlertButton = findByXPathOrCSS(".v-alert .v-alert__dismissible");
      if (closeAlertButton.isVisible()) {
        try {
          closeAlertButton.click();
          closeAlertButton.waitUntilNotVisible();
        } catch (Exception e) {
          // It can be already closed by timeout
        }
      }
    }
  }

  public void closeAlert() {
    ElementFacade closeAlertButton = findByXPathOrCSS(".v-snack--active .v-alert .v-alert__dismissible");
    if (closeAlertButton.isCurrentlyVisible()) {
      try {
        closeAlertButton.click();
        closeAlertButton.waitUntilNotVisible();
      } catch (Exception e) {
        // It can be already closed by timeout
      }
    } else {
      closeAlertButton = findByXPathOrCSS(".v-alert .v-alert__dismissible");
      if (closeAlertButton.isCurrentlyVisible()) {
        try {
          closeAlertButton.click();
          closeAlertButton.waitUntilNotVisible();
        } catch (Exception e) {
          // It can be already closed by timeout
        }
      }
    }
  }

  public void closeAllDialogs() {
    int i = MAX_WAIT_RETRIES * 2;
    while (openedDialogElement().isCurrentlyVisible() && i-- > 0) {
      try {
        findByXPathOrCSS(".v-dialog--active .uiIconClose").click();
      } catch (Exception e) {
        LOGGER.warn("Can't find dialog close button, try to use escape key", e);
        findByXPathOrCSS("//body").sendKeys(Keys.ESCAPE);
      }
      try {
        waitOverlayToClose();
      } catch (Exception e) {
        LOGGER.debug("Dialog seems not displayed", e);
      }
    }
    if (i == 0) {
      openedDialogElement().assertNotVisible();
    }
  }

  public void closeAllDrawers() {
    int i = MAX_WAIT_RETRIES * 2;
    while (openedDrawerElement().isCurrentlyVisible() && i-- > 0) {
      findByXPathOrCSS("//body").sendKeys(Keys.ESCAPE);
      closeAlertIfOpened();
      closeConfirmDialogIfDisplayed();
      waitForDrawerToClose();
    }
    if (i == 0) {
      openedDrawerElement().assertNotVisible();
    }
  }

  public void closeDrawerIfDisplayed() {
    if (openedDrawerElement().isCurrentlyVisible()) {
      findByXPathOrCSS("//body").sendKeys(Keys.ESCAPE);
      closeAlertIfOpened();
      waitForDrawerToClose();
    }
  }

  public void expandDrawer() {
    expandDrawerButton().assertVisible();
    expandDrawerButton().click();
  }

  public void clickOnGoBack() {
    goBackButton().click();
  }

  public void clickOnGoBackInDrawer() {
    goBackButtonInDrawer().click();
  }

  public void clickButton(String buttonText) {
    ElementFacade button = getButton(buttonText);
    button.assertEnabled();
    button.click();
    waitForLoading();
  }

  public void clickMenuItem(String menuItemText) {
    ElementFacade menuItem = getMenuItem(menuItemText);
    menuItem.assertVisible();
    menuItem.click();
    waitForLoading();
  }

  public void clickLink(String linkText) {
    ElementFacade button = getLink(linkText);
    button.assertEnabled();
    button.click();
    waitForLoading();
  }

  public void clickOnText(String text) {
    ElementFacade textElement = getText(text);
    textElement.assertEnabled();
    textElement.click();
    waitForLoading();
  }

  public void clickDrawerButton(String buttonText) {
    ElementFacade button = getDrawerButton(buttonText);
    button.assertEnabled();
    button.click();
    waitForLoading();
  }

  public void clickSelecdLevelDrawerButton(String buttonText) {
    ElementFacade button = getSelecdLevelDrawerButton(buttonText);
    button.assertEnabled();
    button.click();
    waitForLoading();
  }

  public void buttonIsDisabled(String buttonText) {
    getButton(buttonText).assertDisabled();
  }

  public void buttonIsEnabled(String buttonText) {
    getButton(buttonText).assertEnabled();
  }

  public void buttonInDrawerIsDisabled(String buttonText) {
    getDrawerButton(buttonText).assertDisabled();
  }

  public void buttonInDrawerIsEnabled(String buttonText) {
    getDrawerButton(buttonText).assertEnabled();
  }

  public void buttonInDrawerIsNotDisplayed(String buttonText) {
    getDrawerButton(buttonText).assertNotVisible();
  }

  public void buttonInDrawerIsDisplayed(String buttonText) {
    getDrawerButton(buttonText).assertVisible();
  }

  public ButtonElementFacade findButtonByXPathOrCSS(String xpath) {
    WebElementFacade nestedElement = getWebElementFacadeByXPathOrCSS(xpath);
    return ButtonElementFacadeImpl.wrapWebElementFacadeInButtonElement(getDriver(),
                                                                       nestedElement,
                                                                       null,
                                                                       xpath,
                                                                       DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT,
                                                                       DEFAULT_WAIT_FOR_TIMEOUT);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ElementFacade findByXPathOrCSS(String xpathOrCSSSelector) {
    WebElementFacade nestedElement = getWebElementFacadeByXPathOrCSS(xpathOrCSSSelector);

    return ElementFacadeImpl.wrapWebElementFacade(getDriver(),
                                                  nestedElement,
                                                  null,
                                                  xpathOrCSSSelector,
                                                  DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT,
                                                  DEFAULT_WAIT_FOR_TIMEOUT);
  }

  public TextBoxElementFacade findTextBoxByXPathOrCSS(String xpathOrCSSSelector) {
    WebElementFacade nestedElement = getWebElementFacadeByXPathOrCSS(xpathOrCSSSelector);

    return TextBoxElementFacadeImpl.wrapWebElementFacadeInTextBoxElement(getDriver(),
                                                                         nestedElement,
                                                                         null,
                                                                         xpathOrCSSSelector,
                                                                         DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT,
                                                                         DEFAULT_WAIT_FOR_TIMEOUT);
  }

  public TextElementFacade findTextByXPathOrCSS(String xpath) {
    WebElementFacade nestedElement = getWebElementFacadeByXPathOrCSS(xpath);

    return TextElementFacadeImpl.wrapWebElementFacadeInTextElement(getDriver(),
                                                                   nestedElement,
                                                                   null,
                                                                   xpath,
                                                                   DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT,
                                                                   DEFAULT_WAIT_FOR_TIMEOUT);
  }

  public String getCurrentUrl() {
    return getDriver().getCurrentUrl();
  }

  public boolean mentionInField(TextBoxElementFacade inputField, String user, int maxRetries) {
    inputField.waitUntilVisible();
    inputField.setTextValue(user + "x");

    boolean visible = false;
    int retry = 0;
    Duration retryWaitTime = Duration.ofSeconds(1);
    ElementFacade suggesterElement;
    do {
      inputField.sendKeys(Keys.BACK_SPACE);
      waitFor(300).milliseconds();
      suggesterElement =
                       findByXPathOrCSS(String.format("//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                                                      user.substring(0, user.length() - retry - 1)));
      suggesterElement.setImplicitTimeout(retryWaitTime);
      visible = suggesterElement.isVisible();
      if (visible) {
        suggesterElement.click();
        return true;
      }
    } while (!visible && retry++ < maxRetries); // NOSONAR
    return false;
  }

  public boolean mentionUserInCKEditor(ElementFacade ckEditorFrame,
                                       TextBoxElementFacade ckEditorBody,
                                       String content,
                                       String user,
                                       boolean shouldExists) {
    waitCKEditorLoading();
    retryOnCondition(() -> {
      ckEditorFrame.waitUntilVisible();
      getDriver().switchTo().frame(ckEditorFrame);
    }, getDriver().switchTo()::defaultContent);
    try {
      ckEditorBody.waitUntilVisible();
      ckEditorBody.setTextValue(content + ' ' + '@' + user + "x");
      ckEditorBody.sendKeys(Keys.BACK_SPACE);

      boolean visible = false;
      int retry = 0;
      int maxRetries = shouldExists ? 5 : 3;
      Duration retryWaitTime = shouldExists ? Duration.ofSeconds(1) : Duration.ofMillis(300);
      do {
        ckEditorBody.sendKeys(Keys.BACK_SPACE);
        if (shouldExists) {
          waitFor(1).seconds();
        }
        getDriver().switchTo().defaultContent();
        try {
          ElementFacade suggesterElement =
                                         findByXPathOrCSS(String.format("//*[contains(@class, 'atwho-view')]//*[contains(text(), '%s')]",
                                                                        user.substring(0, user.length() - retry - 1)));
          suggesterElement.setImplicitTimeout(retryWaitTime);
          visible = suggesterElement.isVisible();
        } finally {
          getDriver().switchTo().frame(ckEditorFrame);
        }
      } while (!visible && retry++ < maxRetries);
      if (visible) {
        ckEditorBody.sendKeys(Keys.ENTER);
      }
      return visible;
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public ElementFacade openedDialogElement() {
    return findByXPathOrCSS(".v-dialog--active");
  }

  public ElementFacade openedDrawerElement() {
    return findByXPathOrCSS(OPNENED_DRAWER_CSS_SELECTOR);
  }

  public ElementFacade expandDrawerButton() {
    return findByXPathOrCSS(OPNENED_DRAWER_CSS_SELECTOR + " .mdi-arrow-expand");
  }

  @WhenPageOpens
  public void verifyPageLoaded() {
    waitForLoading(DEFAULT_WAIT_PAGE_LOADING, false);
  }

  public void waitCKEditorLoading() {
    waitCKEditorLoading("");
  }

  public void waitDrawerCKEditorLoading() {
    waitCKEditorLoading("//*[contains(@class, 'v-navigation-drawer--open')]");
  }

  public void waitCKEditorLoading(String parentXPath) {
    try {
      getDriver().switchTo().defaultContent();
      ElementFacade iframeElement = findByXPathOrCSS(parentXPath + "//iframe[contains(@class,'cke_wysiwyg_frame')]");
      if (!iframeElement.isCurrentlyVisible()) {
        retryOnCondition(() -> {
          ElementFacade richTextLoadingElement = findByXPathOrCSS(parentXPath + "//*[contains(@class, 'loadingRing')]");
          if (richTextLoadingElement.isCurrentlyVisible()) {
            richTextLoadingElement.waitUntilNotVisible();
          }
          iframeElement.setImplicitTimeout(getImplicitWaitTimeout().multipliedBy(3));
          iframeElement.waitUntilVisible();
        }, () -> getDriver().switchTo().defaultContent());
      }
    } catch (Exception e) {
      LOGGER.warn("Can't wait for progress bar to finish loading", e);
    }
  }

  public void waitForDrawerToClose() {
    waitForDrawerToClose(null, true);
  }

  public void waitForDrawerToClose(String drawerId, boolean withOverlay) {
    closeAlertIfOpened();
    String drawerSelector = StringUtils.isBlank(drawerId) ? OPNENED_DRAWER_CSS_SELECTOR : drawerId;
    ElementFacade drawerElement = findByXPathOrCSS(drawerSelector);
    if (drawerElement.isCurrentlyVisible()) {
      try {
        drawerElement.waitUntilNotVisible();
        if (withOverlay) {
          waitOverlayToClose();
        }
      } catch (Exception e) {
        LOGGER.debug("Overlay seems not displayed", e);
      }
    }
  }

  public void waitForDrawerToLoad() {
    WebDriverWait wait = new WebDriverWait(Serenity.getDriver(),
                                           Duration.ofSeconds(30),
                                           Duration.ofMillis(SHORT_WAIT_DURATION_MILLIS));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState === 'complete' "
        + " && (!document.getElementById('TopbarLoadingContainer') || !!document.querySelector('.TopbarLoadingContainer.hidden'))"
        + " && !!document.querySelector('.v-navigation-drawer--open')"
        + " && !document.querySelector('.v-navigation-drawer--open .v-progress-linear')").toString().equals("true"));
  }

  public void waitForDrawerToOpen() {
    waitForDrawerToOpen(null, true);
  }

  public void waitForDrawerToOpen(String drawerId, boolean withOverlay) {
    String drawerSelector = StringUtils.isBlank(drawerId) ? OPNENED_DRAWER_CSS_SELECTOR : drawerId;
    try {
      findByXPathOrCSS(drawerSelector).waitUntilVisible();
      if (withOverlay) {
        findByXPathOrCSS(".v-overlay").waitUntilVisible();
      }
    } catch (Exception e) {
      LOGGER.debug("Overlay seems not displayed", e);
    }
  }

  public void waitForProgressBar() {
    try {
      ElementFacade progressBar = findByXPathOrCSS(".UISiteBody .v-progress-linear");
      if (progressBar.isCurrentlyVisible()) {
        progressBar.waitUntilNotVisible();
      }
    } catch (Exception e) {
      LOGGER.warn("Can't wait for progress bar to finish loading", e);
    }
  }

  public void waitForMenuToOpen() {
    try {
      ElementFacade menu = findByXPathOrCSS(".menuable__content__active");
      menu.waitUntilVisible();
    } catch (Exception e) {
      LOGGER.warn("Can't wait for progress bar to finish loading", e);
    }
  }

  public void waitForMenuToClose() {
    try {
      ElementFacade menu = findByXPathOrCSS(".menuable__content__active");
      menu.waitUntilNotVisible();
    } catch (Exception e) {
      LOGGER.warn("Can't wait for progress bar to finish loading", e);
    }
  }

  public ElementFacade getButton(String buttonText) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::button", buttonText));
  }

  public ElementFacade getMenuItem(String menuItemText) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@role, 'menuitem')]", menuItemText));
  }

  public ElementFacade getLink(String linkText) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::a", linkText));
  }

  public ElementFacade getText(String text) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]", text));
  }

  public ElementFacade getDrawerButton(String buttonName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'%s')]//ancestor-or-self::button",
                                          buttonName));
  }

  public ElementFacade getSelecdLevelDrawerButton(String buttonName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'%s')]//ancestor-or-self::button",
                                          buttonName));
  }

  public void attachImageToOpenedDrawer(boolean secondLevel) {
    ElementFacade fileInput = findByXPathOrCSS((secondLevel ? OPNENED_DRAWER_CSS_SELECTOR : "") + " "
        + OPNENED_DRAWER_CSS_SELECTOR + " input[type=file]");
    fileInput.assertEnabled();
    attachImageToFileInput(fileInput);
    clickButton("Apply");
  }

  public ElementFacade attachFileInput(boolean secondLevel) {
    String fileInputXPath = (secondLevel ? "//*[contains(@class, 'v-navigation-drawer--open')]" : "")
        + "//*[contains(@class, 'v-navigation-drawer--open')]//*[@type='file']";
    return findByXPathOrCSS(fileInputXPath);
  }

  public void attachImageToFileInput(ElementFacade fileInput) {
    upload(UPLOAD_DIRECTORY_PATH + USER_AVATAR_PNG).fromLocalMachine().to(fileInput.getElement());
    waitForProgressBar();
  }

  /**********************************************************
   * Methods for finding element facade in the page
   **********************************************************/

  private WebElementFacade getWebElementFacadeByXPathOrCSS(String xpathOrCss) {
    if (StringUtils.contains(xpathOrCss, "//")) {
      return find(By.xpath(xpathOrCss));
    } else {
      return find(By.cssSelector(xpathOrCss));
    }
  }

  private ElementFacade goBackButton() {
    return findByXPathOrCSS("#UIPage .fa-arrow-left");
  }

  private ElementFacade goBackButtonInDrawer() {
    return findByXPathOrCSS(OPNENED_DRAWER_CSS_SELECTOR + " .fa-arrow-left");
  }

  private void waitOverlayToClose() {
    findByXPathOrCSS(".v-overlay").waitUntilNotVisible();
  }

}
