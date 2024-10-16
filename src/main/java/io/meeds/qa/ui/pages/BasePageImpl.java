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
import java.util.concurrent.atomic.AtomicInteger;

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

  private static final String CAN_T_WAIT_FOR_PROGRESS_BAR_TO_FINISH_LOADING = "Can't wait for progress bar to finish loading";

  protected static final Logger LOGGER                     = LoggerFactory.getLogger(BasePageImpl.class);

  public static final String    OPENED_DRAWER_XPATH        = "//*[contains(@class, 'v-navigation-drawer--open')]";

  public static final String    OPENED_DRAWER_CSS_SELECTOR = ".v-navigation-drawer--open";

  public static final String    UPLOAD_DIRECTORY_PATH      =
                                                      GenericPage.class.getResource(File.separator + "DataFiles" + File.separator)
                                                                       .getFile();

  public static final String    USER_AVATAR_PNG            = "cap02.png";

  public static final String    GIF_IMAGE                  = "cap04.gif";

  public static final String    PUBLIC_SITE_URL            = "/portal/public";

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

  public void closeToastNotification(boolean waitElement) {
    ElementFacade closeAlertButton = findByXPathOrCSS(".v-snack--active .v-alert .fa-times");
    if (waitElement ? closeAlertButton.isVisible() : closeAlertButton.isCurrentlyVisible()) {
      try {
        closeAlertButton.click();
        closeAlertButton.waitUntilNotVisible();
      } catch (Exception e) {
        // It can be already closed by timeout
      }
    } else {
      closeAlertButton = findByXPathOrCSS(".v-alert .fa-times");
      if (waitElement ? closeAlertButton.isVisible() : closeAlertButton.isCurrentlyVisible()) {
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
      if (dialogCloseIcon().isCurrentlyVisible()) {
        dialogCloseIcon().click();
      } else {
        pressEscape();
      }
      try {
        waitOverlayToClose();
      } catch (Exception e) {
        LOGGER.debug("Dialog seems not displayed", e);
      }
    }
    if (i == 0) {
      openedDialogElement().checkNotVisible();
    }
  }

  public void closeMenu() {
    pressEscape();
    waitFor(300).milliseconds(); // Wait for animation to finish
  }

  public boolean isMenuDisplayed() {
    return activeMenuElement().isCurrentlyVisible();
  }

  public void waitMenuToDisplay() {
    activeMenuElement().waitUntilVisible();
  }

  public void closeAllDrawers() {
    int i = MAX_WAIT_RETRIES * 2;
    while (openedDrawerElement().isCurrentlyVisible() && i-- > 0) {
      if (i > MAX_WAIT_RETRIES) {
        pressEscape();
      } else {
        ElementFacade drawerCloseIcon = drawerCloseIcon();
        if (drawerCloseIcon.isCurrentlyVisible()) {
          drawerCloseIcon.click();
        } else {
          return;
        }
      }
      closeAlertIfOpened();
      closeConfirmDialogIfDisplayed();
      waitFor(200).milliseconds(); // Animation duration
    }
    waitForDrawerToClose();
    if (i == 0) {
      openedDrawerElement().checkNotVisible();
    }
  }

  private ElementFacade drawerCloseIcon() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'drawerIcons')]//*[contains(@class, 'close') or contains(@class, 'times')])[last()]");
  }

  private ElementFacade dialogCloseIcon() {
    return findByXPathOrCSS("(//*[contains(@class, 'v-dialog--active')]//*[contains(@class, 'close') or contains(@class, 'times')])[last()]");
  }

  public void closeDrawerIfDisplayed() {
    if (openedDrawerElement().isCurrentlyVisible()) {
      closeDrawer();
      closeAlertIfOpened();
      waitForDrawerToClose();
    }
  }

  public void expandDrawer() {
    expandDrawerButton().checkVisible();
    expandDrawerButton().click();
  }

  public void clickOnGoBack() {
    goBackButton().click();
  }

  public void clickOnGoBackInDrawer() {
    goBackButtonInDrawer().click();
  }

  public void clickButton(String buttonText, int index) {
    ElementFacade button = getButton(buttonText, index);
    button.checkVisible();
    button.checkEnabled();
    button.click();
    waitForLoading();
  }

  public void clickButton(String buttonText) {
    ElementFacade button = getButton(buttonText);
    button.checkEnabled();
    button.click();
    waitForLoading();
  }

  public void clickMenuItem(String menuItemText) {
    ElementFacade menuItem = getMenuItem(menuItemText);
    menuItem.checkVisible();
    menuItem.click();
    waitForLoading();
  }

  public void clickLink(String linkText) {
    ElementFacade button = getLink(linkText);
    button.checkEnabled();
    button.click();
    waitForLoading();
  }

  public void clickOnText(String text) {
    ElementFacade textElement = getText(text);
    textElement.checkEnabled();
    textElement.click();
    waitForLoading();
  }

  public void clickDrawerButton(String buttonText) {
    ElementFacade button = getDrawerButton(buttonText);
    button.checkVisible();
    button.checkEnabled();
    button.click();
    waitForLoading();
  }

  public void clickSelecdLevelDrawerButton(String buttonText) {
    AtomicInteger index = new AtomicInteger();
    retryOnCondition(() -> {
      ElementFacade button = getSelecdLevelDrawerButton(buttonText, index.getAndIncrement());
      button.checkEnabled();
      button.click();
    });
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
    if (!inputField.getTagName().equals("input")) {
      inputField = inputField.findBy("input");
      inputField.checkVisible();
    }
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
    return findByXPathOrCSS(OPENED_DRAWER_CSS_SELECTOR);
  }

  public ElementFacade expandDrawerButton() {
    return findByXPathOrCSS(OPENED_DRAWER_CSS_SELECTOR + " .mdi-arrow-expand");
  }

  public ElementFacade notificationContentElement(String message) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(@id, 'notifItem-')]//*[contains(text(),'%s')]/parent::*",
                                          message));
  }

  public ElementFacade notificationContentElement(String message, String content) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(@id, 'notifItem-')]//*[contains(text(),'%s')]//ancestor::*[contains(@id, 'notifItem-')]//*[contains(text(),'%s')]/parent::*",
                                          message,
                                          content));
  }

  @WhenPageOpens
  public void verifyPageLoaded() {
    waitForLoading(DEFAULT_WAIT_PAGE_LOADING, false);
  }

  public void waitCKEditorLoading() {
    waitCKEditorLoading("");
  }

  public void waitDrawerCKEditorLoading() {
    waitCKEditorLoading(OPENED_DRAWER_XPATH);
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
      LOGGER.warn(CAN_T_WAIT_FOR_PROGRESS_BAR_TO_FINISH_LOADING, e);
    }
  }

  public void waitForDrawerToClose() {
    waitForDrawerToClose(null, true);
  }

  public void waitForDrawerToClose(String drawerId, boolean withOverlay) {
    closeAlertIfOpened();
    String drawerSelector = StringUtils.isBlank(drawerId) ? OPENED_DRAWER_CSS_SELECTOR : drawerId;
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
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState === 'complete' " +
        " && (!document.getElementById('TopbarLoadingContainer') || !!document.querySelector('.TopbarLoadingContainer.hidden'))" +
        " && !!document.querySelector('.v-navigation-drawer--open')" +
        " && !document.querySelector('.v-navigation-drawer--open .v-progress-linear')").toString().equals("true"));
  }

  public void waitForDrawerToOpen() {
    waitForDrawerToOpen(null, true);
  }

  public void waitForDrawerToOpen(String drawerId, boolean withOverlay) {
    String drawerSelector = StringUtils.isBlank(drawerId) ? OPENED_DRAWER_CSS_SELECTOR : drawerId;
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
    waitForProgressBar(false);
  }

  public void waitForProgressBar(boolean waitForProgress) {
    if (waitForProgress) {
      try {
        pageProgressBar().waitUntilVisible();
      } catch (Exception e) {
        LOGGER.warn("Can't wait for progress bar to appear", e);
      }
    }
    try {
      ElementFacade progressBar = pageProgressBar();
      if (progressBar.isCurrentlyVisible()) {
        progressBar.waitUntilNotVisible();
      }
    } catch (Exception e) {
      LOGGER.warn(CAN_T_WAIT_FOR_PROGRESS_BAR_TO_FINISH_LOADING, e);
    }
  }

  public ElementFacade pageProgressBar() {
    return findByXPathOrCSS(".UISiteBody .v-progress-linear");
  }

  public void waitForMenuToOpen(String contentClass) {
    try {
      ElementFacade menu = findByXPathOrCSS(String.format("//*[contains(@class, 'menuable__content__active') and contains(@class, '%s')]", contentClass));
      menu.waitUntilVisible();
    } catch (Exception e) {
      LOGGER.warn(CAN_T_WAIT_FOR_PROGRESS_BAR_TO_FINISH_LOADING, e);
    }
  }

  public void waitForMenuToClose(String contentClass) {
    try {
      ElementFacade menu = findByXPathOrCSS(String.format("//*[contains(@class, 'menuable__content__active') and contains(@class, '%s')]", contentClass));
      menu.waitUntilNotVisible();
    } catch (Exception e) {
      LOGGER.warn(CAN_T_WAIT_FOR_PROGRESS_BAR_TO_FINISH_LOADING, e);
    }
  }

  public ElementFacade getButton(String buttonText) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::button", buttonText));
  }

  public ElementFacade getButton(String buttonText, int index) {
    return findByXPathOrCSS(String.format("(//*[contains(text(),'%s')]//ancestor-or-self::button)[%s]", buttonText, index + 1));
  }

  public ElementFacade getMenuItem(String menuItemText) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@role, 'menuitem')]",
                                          menuItemText));
  }

  public ElementFacade getLink(String linkText) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::a", linkText));
  }

  public ElementFacade getText(String text) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]", text));
  }

  public ElementFacade getDrawerButton(String buttonName) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'%s')]//ancestor-or-self::button)[last()]",
                                          buttonName));
  }

  public ElementFacade getSelecdLevelDrawerButton(String buttonName, int index) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'%s')]//ancestor-or-self::button)[%s]",
                                          buttonName,
                                          index));
  }

  public void attachImageToOpenedDrawer() {
    attachImageToFileInput(OPENED_DRAWER_CSS_SELECTOR + " input[type=file]", USER_AVATAR_PNG);
    waitFor(200).milliseconds();
    AtomicInteger index = new AtomicInteger();
    retryOnCondition(() -> clickButton("Apply", index.getAndIncrement()),
                     () -> waitFor(200).milliseconds());
  }

  public void attachGifImageToCKeditor() {
    attachImageToCKeditor(GIF_IMAGE);
  }

  public void attachImageToCKeditor() {
    attachImageToCKeditor(USER_AVATAR_PNG);
  }

  public void attachImageToCKeditor(String fileName) {
    int i = -1;
    while (++i < 5) {
      if (ckEditorAttachImageButton(i).isCurrentlyVisible()) {
        break;
      }
    }
    AtomicInteger index = i < 5 && i > 0 ? new AtomicInteger(--i) : new AtomicInteger();
    retryOnCondition(() -> ckEditorAttachImageButton(index.incrementAndGet()).checkCurrentlyVisible());
    int initialImagesCount = ckEditorAttachImageCount(index.get());
    retryOnCondition(() -> {
      if (ckEditorAttachImageCount(index.get()) == initialImagesCount) {
        ElementFacade fileInput = ckEditorAttachImageInput(index.get());
        fileInput.checkEnabled();
        waitFor(1).seconds();
        attachImageToFileInput(fileInput, fileName);
        ckEditorImageAttachmentProgressElement(index.get()).checkVisible();
        retryOnCondition(() -> ckEditorImageAttachmentProgressElement(index.get()).waitUntilNotVisible());
        retryOnCondition(() -> ckEditorImageAttachmentEditButton(index.get()).waitUntilVisible());

        ckEditorImageAttachmentCarousel(index.get()).checkVisible();
        ckEditorImageAttachmentPlusIcon(index.get()).checkVisible();
        ckEditorAttachImageInputParent(index.get()).checkVisible();
      }
    });
  }

  public ElementFacade attachFileInput(boolean secondLevel) {
    String fileInputXPath = (secondLevel ? OPENED_DRAWER_XPATH : "") +
        "//*[contains(@class, 'v-navigation-drawer--open')]//*[@type='file']";
    return findByXPathOrCSS(fileInputXPath);
  }

  public void attachImageToFileInput(String xPathOrCss, String fileName) {
    retryOnCondition(() -> {
      ElementFacade fileInput = findByXPathOrCSS(xPathOrCss);
      fileInput.waitUntilEnabled();
      upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine()
                                              .to(fileInput.getElement());
    }, () -> waitFor(500).milliseconds());
    waitForProgressBar();
  }

  public void attachImageToFileInput(ElementFacade fileInput, String fileName) {
    retryOnCondition(() -> upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine()
                                                                   .to(fileInput.getElement()),
                     () -> waitFor(500).milliseconds());
    waitForProgressBar();
  }

  private void closeDrawer() {
    closeDrawer(MAX_WAIT_RETRIES);
  }

  private void closeDrawer(int i) {
    if (i == 0) {
      throw new IllegalStateException("Drawer can't be closed");
    }
    if (drawerCloseIcon().isClickable()) {
      try {
        drawerCloseIcon().click();
      } catch (Throwable e) { // NOSONAR
        pressEscape();
      }
    } else {
      pressEscape();
    }
  }

  private void pressEscape() {
    findByXPathOrCSS("//body").sendKeys(Keys.ESCAPE);
  }

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
    return findByXPathOrCSS(OPENED_DRAWER_CSS_SELECTOR + " .fa-arrow-left");
  }

  private void waitOverlayToClose() {
    findByXPathOrCSS(".v-overlay").waitUntilNotVisible();
  }

  private ElementFacade activeMenuElement() {
    return findByXPathOrCSS(".menuable__content__active");
  }

  private ElementFacade ckEditorAttachImageInput(int index) {
    return findByXPathOrCSS(String.format("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')])[%s]/parent::*//input[@type='file']",
                                          index));
  }

  private ElementFacade ckEditorAttachImageInputParent(int index) {
    return findByXPathOrCSS(String.format("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')])[%s]/parent::*//input[@type='file']/ancestor::*[contains(@class, 'v-input')]/parent::*",
                                          index));
  }

  private int ckEditorAttachImageCount(int index) {
    return findAll(String.format("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')])[%s]/parent::*//input[@type='file']/ancestor::*[contains(@class, 'v-input')]/parent::*//*[contains(@class, 'v-image')]/parent::*[contains(@class,'v-card')]",
                                 index)).size();
  }

  private ElementFacade ckEditorAttachImageButton(int index) {
    return findByXPathOrCSS(String.format("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')])[%s]//a[contains(@class, 'cke_button__attachimage')]",
                                          index));
  }

  private ElementFacade ckEditorImageAttachmentCarousel(int index) {
    return findByXPathOrCSS(String.format("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')])[%s]/parent::*//*[contains(@class, 'carousel-top-parent')]",
                                          index));
  }

  private ElementFacade ckEditorImageAttachmentPlusIcon(int index) {
    return findByXPathOrCSS(String.format("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')])[%s]/parent::*//*[contains(@class, 'carousel-top-parent')]//*[contains(@class, 'fa-plus')]",
                                          index));
  }

  private ElementFacade ckEditorImageAttachmentProgressElement(int index) {
    return findByXPathOrCSS(String.format("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')])[%s]/parent::*//*[contains(@class, 'v-progress-circular')]",
                                          index));
  }

  private ElementFacade ckEditorImageAttachmentEditButton(int index) {
    return findByXPathOrCSS(String.format("(//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'richEditor')])[%s]/parent::*//*[contains(@class, 'fa-edit')]",
                                          index));
  }

}
