package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION;
import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoaded;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.BaseElementFacadeImpl;
import io.meeds.qa.ui.elements.ButtonElementFacadeImpl;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacadeImpl;
import io.meeds.qa.ui.elements.TextElementFacadeImpl;
import io.meeds.qa.ui.utils.ExceptionLauncher;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.selectors.Selectors;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;

public class BasePageImpl extends PageObject implements BasePage {

  private static final Logger LOGGER                      = LoggerFactory.getLogger(BasePageImpl.class);

  private static final String OPNENED_DRAWER_CSS_SELECTOR = ".v-navigation-drawer--open";

  private static final String XPATH_FORMAT_ERROR_MESSAGE  = "The format for the xpath [%s] is not correct.";

  protected String            url;

  public BasePageImpl() {
    this(null);
  }

  public BasePageImpl(WebDriver driver) {
    super(driver);
  }

  public void assertWebElementNotVisible(BaseElementFacade element) {
    assertTrue(String.format("Element %s is still visible after waiting", // NOSONAR
                             element),
               isWebElementNotVisible(element));
  }

  public void assertWebElementNotVisible(BaseElementFacade element, int maxRetries) {
    assertTrue(String.format("Element %s is still visible after waiting", element), isWebElementNotVisible(element, maxRetries));
  }

  public void assertWebElementVisible(BaseElementFacade element) {
    assertTrue(String.format("Unable to locate a visible element %s", element), isWebElementVisible(element));
  }

  public void assertWebElementVisible(BaseElementFacade element, int maxRetries) {
    assertTrue(String.format("Unable to locate a visible element %s", element), isWebElementVisible(element, maxRetries));
  }

  public void clickOnElement(BaseElementFacade element) {
    element.clickOnElement();
  }

  public void closeDrawer() {
    BaseElementFacade closeIcon = findByXPathOrCSS(".v-navigation-drawer--open .drawerHeader button.mdi-close");
    try {
      if (closeIcon.isDisplayedNoWait()) {
        closeIcon.clickOnElement();
      }
    } catch (Exception e) {
      LOGGER.debug("Error when closing task drawer by button, it may be already closed", e);
    }
    waitForDrawerToClose();
  }

  public void closeDrawerIfDisplayed() {
    if (findByXPathOrCSS(OPNENED_DRAWER_CSS_SELECTOR).isDisplayedNoWait()) {
      closeDrawer();
    }
  }

  public ButtonElementFacadeImpl findButtonElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      ExceptionLauncher.throwSerenityExeption(new Exception(), String.format(XPATH_FORMAT_ERROR_MESSAGE, xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return ButtonElementFacadeImpl.wrapWebElementFacadeInButtonElement(getDriver(),
                                                                       nestedElement,
                                                                       null,
                                                                       xpath,
                                                                       getImplicitWaitTimeout().toMillis(),
                                                                       getWaitForTimeout().toMillis());
  }

  @Override
  @SuppressWarnings("unchecked")
  public BaseElementFacadeImpl findByXPathOrCSS(String xpathOrCSSSelector) {
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpathOrCSSSelector);

    return BaseElementFacadeImpl.wrapWebElementFacade(getDriver(),
                                                      nestedElement,
                                                      null,
                                                      xpathOrCSSSelector,
                                                      getImplicitWaitTimeout().toMillis(),
                                                      getWaitForTimeout().toMillis());
  }

  public TextBoxElementFacadeImpl findTextBoxElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      ExceptionLauncher.throwSerenityExeption(new Exception(), String.format(XPATH_FORMAT_ERROR_MESSAGE, xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return TextBoxElementFacadeImpl.wrapWebElementFacadeInTextBoxElement(getDriver(),
                                                                         nestedElement,
                                                                         null,
                                                                         xpath,
                                                                         getImplicitWaitTimeout().toMillis(),
                                                                         getWaitForTimeout().toMillis());
  }

  public TextElementFacadeImpl findTextElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      ExceptionLauncher.throwSerenityExeption(new Exception(), String.format(XPATH_FORMAT_ERROR_MESSAGE, xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return TextElementFacadeImpl.wrapWebElementFacadeInTextElement(getDriver(),
                                                                   nestedElement,
                                                                   null,
                                                                   xpath,
                                                                   getImplicitWaitTimeout().toMillis(),
                                                                   getWaitForTimeout().toMillis());
  }

  public String getCurrentUrl() {
    return getDriver().getCurrentUrl();
  }

  /**********************************************************
   * Methods for finding element facade in the page
   **********************************************************/

  private WebElementFacade getWebElementFacadeByXpathOrCSS(String xpath) {
    verifyPageLoaded();
    return findBy(xpath);
  }

  public boolean isNotVisible(String xpathOrCss) {
    return isWebElementNotVisible(findByXPathOrCSS(xpathOrCss));
  }

  public boolean isVisible(String xpathOrCss) {
    return isWebElementVisible(findByXPathOrCSS(xpathOrCss));
  }

  public boolean isWebElementNotVisible(BaseElementFacade element) {
    return isWebElementNotVisible(element, MAX_WAIT_RETRIES);
  }

  public boolean isWebElementNotVisible(BaseElementFacade element, long maxRetries) {
    verifyPageLoaded();
    element.setImplicitTimeout(SHORT_WAIT_DURATION);
    boolean notVisible = false;
    int retry = 0;
    do {
      notVisible = !element.isDisplayed(SHORT_WAIT_DURATION_MILLIS);
    } while (!notVisible && retry++ < maxRetries);
    return notVisible || element.isNotVisibleAfterWaiting();
  }

  public boolean isWebElementVisible(BaseElementFacade element) {
    return isWebElementVisible(element, MAX_WAIT_RETRIES);
  }

  public boolean isWebElementVisible(BaseElementFacade element, long maxRetries) {
    verifyPageLoaded();
    boolean visible = false;
    int retry = 0;
    do {
      element.setImplicitTimeout(SHORT_WAIT_DURATION);
      visible = element.isDisplayed(SHORT_WAIT_DURATION_MILLIS);
      if (visible) {
        return true;
      } else {
        String selector = element.getXPathOrCSSSelector();
        if (StringUtils.isNotBlank(selector)) {
          element = findByXPathOrCSS(selector);
        } else if (element instanceof BaseElementFacadeImpl && ((BaseElementFacadeImpl) element).getFoundBy() != null) {
          element = findByXPathOrCSS(((BaseElementFacadeImpl) element).getFoundBy());
        }
      }
    } while (retry++ < maxRetries);
    return element.isVisibleAfterWaiting();
  }

  public boolean mentionUserInCKEditor(BaseElementFacade ckEditorFrame,
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
          BaseElementFacade suggesterElement =
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

  public boolean mentionInField(TextBoxElementFacade inputField, String user, int maxRetries) {
    inputField.waitUntilVisible();
    inputField.setTextValue(user + "x");
    inputField.sendKeys(Keys.BACK_SPACE);

    boolean visible = false;
    int retry = 0;
    Duration retryWaitTime = Duration.ofSeconds(1);
    BaseElementFacade suggesterElement;
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

  public void refreshPage() {
    getDriver().get(getCurrentUrl());
    try {
      getDriver().switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
      // Normal Behavior
    }
    verifyPageLoaded();
  }

  @Override
  @WhenPageOpens
  public void verifyPageLoaded() {
    waitForPageLoaded();
  }

  public void waitCKEditorLoading() {
    try {
      BaseElementFacade iframeElement = findByXPathOrCSS("//iframe");
      if (!iframeElement.isDisplayedNoWait()) {
        BaseElementFacade richTextLoadingElement = findByXPathOrCSS("//*[contains(@class, 'loadingRing')]");
        if (richTextLoadingElement.isDisplayedNoWait()) {
          richTextLoadingElement.waitUntilNotVisible();
        }
      }
    } catch (Exception e) {
      ExceptionLauncher.LOGGER.debug("Can't wait for progress bar to finish loading", e);
    }
  }

  public void waitForDrawerToClose() {
    waitForDrawerToClose(null, true);
  }

  public void waitForDrawerToClose(String drawerId, boolean withOverlay) {
    String drawerSelector = StringUtils.isBlank(drawerId) ? OPNENED_DRAWER_CSS_SELECTOR : drawerId;
    BaseElementFacade drawerElement = findByXPathOrCSS(drawerSelector);
    if (drawerElement.isDisplayedNoWait()) {
      try {
        drawerElement.waitUntilNotVisible();
        if (withOverlay) {
          findByXPathOrCSS(".v-overlay").waitUntilNotVisible();
        }
      } catch (Exception e) {
        LOGGER.debug("Overlay seems not displayed", e);
      }
    }
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
      BaseElementFacade progressBar = findByXPathOrCSS(".UISiteBody .v-progress-linear");
      if (!progressBar.isDisplayed(SHORT_WAIT_DURATION_MILLIS)) {
        try { // NOSONAR
          progressBar.waitUntilVisible();
        } catch (Exception e) {
          ExceptionLauncher.LOGGER.debug("Can't wait for progress bar to start loading", e);
        }
      }
      progressBar.waitUntilNotVisible();
    } catch (Exception e) {
      ExceptionLauncher.LOGGER.debug("Can't wait for progress bar to finish loading", e);
    }
  }

  private void waitSuggesterToLoad() {
    try {
      BaseElementFacade progressBar = findByXPathOrCSS(".identitySuggester .v-progress-linear");
      if (progressBar.isDisplayedNoWait()) {
        progressBar.waitUntilNotVisible();
      }
    } catch (Exception e) {
      LOGGER.debug("Error while waiting for suggester progressbar", e);
    }
  }

}
