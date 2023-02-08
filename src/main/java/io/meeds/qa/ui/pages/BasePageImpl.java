package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.DEFAULT_IMPLICIT_WAIT_FOR_TIMEOUT;
import static io.meeds.qa.ui.utils.Utils.DEFAULT_WAIT_FOR_TIMEOUT;
import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;

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

  private static final Logger LOGGER                      = LoggerFactory.getLogger(BasePageImpl.class);

  private static final String OPNENED_DRAWER_CSS_SELECTOR = ".v-navigation-drawer--open";

  protected String            url;

  public BasePageImpl() {
    this(null);
  }

  public BasePageImpl(WebDriver driver) {
    super(driver);
  }

  public void clickOnElement(ElementFacade element) {
    element.clickOnElement();
  }

  public void closeAlertIfOpened() {
    try {
      getDriver().switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
      // Normal Behavior
    }
  }

  public void closeAllDrawers() {
    ElementFacade openedDrawerElement = openedDrawerElement();
    while (openedDrawerElement.isDisplayedNoWait()) {
      findByXPathOrCSS("//body").sendKeys(Keys.ESCAPE);
      closeAlertIfOpened();
      waitForDrawerToClose();
    }
  }

  public void closeAllDialogs() {
    ElementFacade openedDialogElement = openedDialogElement();
    while (openedDialogElement.isDisplayedNoWait()) {
      findByXPathOrCSS("//body").sendKeys(Keys.ESCAPE);
      try {
        waitOverlayToClose();
      } catch (Exception e) {
        LOGGER.debug("Overlay seems not displayed", e);
      }
    }
  }

  public void closeDrawerIfDisplayed() {
    ElementFacade openedDrawerElement = openedDrawerElement();
    if (openedDrawerElement.isDisplayedNoWait()) {
      findByXPathOrCSS("//body").sendKeys(Keys.ESCAPE);
      closeAlertIfOpened();
      waitForDrawerToClose();
    }
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

  public boolean isNotVisible(String xpathOrCss) {
    return isWebElementNotVisible(findByXPathOrCSS(xpathOrCss), MAX_WAIT_RETRIES);
  }

  public boolean isVisible(String xpathOrCss) {
    return isWebElementVisible(findByXPathOrCSS(xpathOrCss), MAX_WAIT_RETRIES);
  }

  public boolean isWebElementNotVisible(ElementFacade element, int maxRetries) {
    return element.isNotVisible(maxRetries);
  }

  public boolean isWebElementVisible(ElementFacade element, int maxRetries) {
    return element.isVisible(maxRetries);
  }

  public boolean mentionInField(TextBoxElementFacade inputField, String user, int maxRetries) {
    inputField.waitUntilVisible();
    inputField.setTextValue(user + "x");
    inputField.sendKeys(Keys.BACK_SPACE);

    boolean visible = false;
    int retry = 0;
    Duration retryWaitTime = Duration.ofSeconds(1);
    ElementFacade suggesterElement;
    do {
      inputField.sendKeys(Keys.BACK_SPACE);
      waitFor(300).milliseconds();
      waitSuggesterToLoad();
      suggesterElement =
                       findByXPathOrCSS(String.format("//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                                                      user.substring(0, user.length() - retry - 1)));
      suggesterElement.setImplicitTimeout(retryWaitTime);
      visible = suggesterElement.isVisibleAfterWaiting();
    } while (!visible && retry++ < maxRetries);
    if (visible) {
      suggesterElement.clickOnElement();
    }
    return visible;
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
          visible = suggesterElement.isVisibleAfterWaiting();
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

  @WhenPageOpens
  public void verifyPageLoaded() {
    waitForPageLoading();
    waitFor(50).milliseconds();
  }

  public void waitCKEditorLoading() {
    try {
      ElementFacade iframeElement = findByXPathOrCSS("//iframe");
      if (!iframeElement.isDisplayedNoWait()) {
        ElementFacade richTextLoadingElement = findByXPathOrCSS("//*[contains(@class, 'loadingRing')]");
        if (richTextLoadingElement.isDisplayedNoWait()) {
          richTextLoadingElement.waitUntilNotVisible();
        }
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
    if (drawerElement.isDisplayedNoWait()) {
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
      if (progressBar.isDisplayed(SHORT_WAIT_DURATION_MILLIS)) {
        progressBar.waitUntilNotVisible();
      }
    } catch (Exception e) {
      LOGGER.warn("Can't wait for progress bar to finish loading", e);
    }
  }

  public ElementFacade openedDrawerElement() {
    return findByXPathOrCSS(OPNENED_DRAWER_CSS_SELECTOR);
  }

  public ElementFacade openedDialogElement() {
    return findByXPathOrCSS(".v-dialog--active");
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

  private void waitSuggesterToLoad() {
    try {
      ElementFacade progressBar = findByXPathOrCSS(".identitySuggester .v-progress-linear");
      if (progressBar.isDisplayedNoWait()) {
        progressBar.waitUntilNotVisible();
      }
    } catch (Exception e) {
      LOGGER.debug("Error while waiting for suggester progressbar", e);
    }
  }

  private void waitOverlayToClose() {
    findByXPathOrCSS(".v-overlay").waitUntilNotVisible();
  }

}
