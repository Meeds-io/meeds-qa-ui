package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.MAX_WAIT_RETRIES;
import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION;
import static io.meeds.qa.ui.utils.Utils.SHORT_WAIT_DURATION_MILLIS;
import static io.meeds.qa.ui.utils.Utils.decorateDriver;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoaded;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.BaseElementFacadeImpl;
import io.meeds.qa.ui.elements.ButtonElementFacade;
import io.meeds.qa.ui.elements.ButtonElementFacadeImpl;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacadeImpl;
import io.meeds.qa.ui.elements.TextElementFacade;
import io.meeds.qa.ui.elements.TextElementFacadeImpl;
import io.meeds.qa.ui.utils.ExceptionLauncher;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.selectors.Selectors;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;

public class BasePageImpl extends PageObject implements BasePage {

  static final Logger          LOGGER                     = LoggerFactory.getLogger(BasePageImpl.class);

  private static final String  XPATH_FORMAT_ERROR_MESSAGE = "The format for the xpath [%s] is not correct.";

  protected WebDriver          driver;

  protected String             url;

  public BasePageImpl() {
    this(null);
  }

  public BasePageImpl(WebDriver driver) {
    super(decorateDriver(driver));
    this.driver = getDriver();
  }

  @SwitchToWindow
  public void assertWebElementNotVisible(BaseElementFacade element) {
    assertTrue(String.format("Element %s is still visible after waiting", // NOSONAR
                             element),
               isWebElementNotVisible(element));
  }

  @SwitchToWindow
  public void assertWebElementNotVisible(BaseElementFacade element, int maxRetries) {
    assertTrue(String.format("Element %s is still visible after waiting", element), isWebElementNotVisible(element, maxRetries));
  }

  @SwitchToWindow
  public void assertWebElementVisible(BaseElementFacade element) {
    assertTrue(String.format("Unable to locate a visible element %s", element), isWebElementVisible(element));
  }

  @SwitchToWindow
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
    if (findByXPathOrCSS(".v-navigation-drawer--open").isDisplayedNoWait()) {
      closeDrawer();
    }
  }

  public <T extends ButtonElementFacade> T findButtonElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      ExceptionLauncher.throwSerenityExeption(new Exception(), String.format(XPATH_FORMAT_ERROR_MESSAGE, xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return ButtonElementFacadeImpl.wrapWebElementFacadeInButtonElement(getDriver(),
                                                                       nestedElement,
                                                                       getImplicitWaitTimeout().toMillis(),
                                                                       getWaitForTimeout().toMillis());
  }

  @Override
  public <T extends BaseElementFacade> T findByXPathOrCSS(String xpathOrCSSSelector) {
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpathOrCSSSelector);

    return BaseElementFacadeImpl.wrapWebElementFacade(getDriver(),
                                                      nestedElement,
                                                      getImplicitWaitTimeout().toMillis(),
                                                      getWaitForTimeout().toMillis());
  }

  public <T extends TextBoxElementFacade> T findTextBoxElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      ExceptionLauncher.throwSerenityExeption(new Exception(), String.format(XPATH_FORMAT_ERROR_MESSAGE, xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return TextBoxElementFacadeImpl.wrapWebElementFacadeInTextBoxElement(getDriver(),
                                                                         nestedElement,
                                                                         getImplicitWaitTimeout().toMillis(),
                                                                         getWaitForTimeout().toMillis());
  }

  public <T extends TextElementFacade> T findTextElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      ExceptionLauncher.throwSerenityExeption(new Exception(), String.format(XPATH_FORMAT_ERROR_MESSAGE, xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return TextElementFacadeImpl.wrapWebElementFacadeInTextElement(getDriver(),
                                                                   nestedElement,
                                                                   getImplicitWaitTimeout().toMillis(),
                                                                   getWaitForTimeout().toMillis());
  }

  public String getCurrentUrl() {
    return driver.getCurrentUrl();
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

  @SwitchToWindow
  public boolean isWebElementVisible(BaseElementFacade element, long maxRetries) {
    verifyPageLoaded();
    element.setImplicitTimeout(SHORT_WAIT_DURATION);
    boolean visible = false;
    int retry = 0;
    do {
      visible = element.isDisplayed(SHORT_WAIT_DURATION_MILLIS);
    } while (!visible && retry++ < maxRetries);
    return visible || element.isCurrentlyVisible();
  }

  @SwitchToWindow
  public boolean mentionUserInCKEditor(BaseElementFacade ckEditorFrame,
                                       TextBoxElementFacade ckEditorBody,
                                       String content,
                                       String user,
                                       boolean shouldExists) {
    waitCKEditorLoading();
    retryOnCondition(() -> {
      ckEditorFrame.waitUntilVisible();
      driver.switchTo().frame(ckEditorFrame);
    }, driver.switchTo()::defaultContent);
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
        driver.switchTo().defaultContent();
        try {
          BaseElementFacade suggesterElement =
                                             findByXPathOrCSS(String.format("//*[contains(@class, 'atwho-view')]//*[contains(text(), '%s')]",
                                                                            user.substring(0, user.length() - retry - 1)));
          suggesterElement.setImplicitTimeout(retryWaitTime);
          visible = suggesterElement.isVisibleAfterWaiting();
        } finally {
          driver.switchTo().frame(ckEditorFrame);
        }
      } while (!visible && retry++ < maxRetries);
      if (visible) {
        ckEditorBody.sendKeys(Keys.ENTER);
      }
      return visible;
    } finally {
      driver.switchTo().defaultContent();
    }
  }

  @SwitchToWindow
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
    driver.get(getCurrentUrl());
    try {
      driver.switchTo().alert().accept();
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
      BaseElementFacade richTextLoadingElement = findByXPathOrCSS("//*[contains(@class, 'loadingRing')]");
      if (richTextLoadingElement.isDisplayed(200)) {
        richTextLoadingElement.waitUntilNotVisible();
      }
    } catch (Exception e) {
      ExceptionLauncher.LOGGER.debug("Can't wait for progress bar to finish loading", e);
    }
  }

  public void waitForDrawerToClose() {
    waitForDrawerToClose(null, true);
  }

  public void waitForDrawerToClose(String drawerId, boolean withOverlay) {
    String drawerSelector = StringUtils.isBlank(drawerId) ? ".v-navigation-drawer--open" : drawerId;
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

  public void waitForDrawerToLoad() {
    WebDriverWait wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(30));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState === 'complete' "
        + " && (!document.getElementById('TopbarLoadingContainer') || !!document.querySelector('.TopbarLoadingContainer.hidden'))"
        + " && !!document.querySelector('.v-navigation-drawer--open')"
        + " && !document.querySelector('.v-navigation-drawer--open .v-progress-linear')").toString().equals("true"));
  }

  public void waitForDrawerToOpen() {
    waitForDrawerToOpen(null, true);
  }

  public void waitForDrawerToOpen(String drawerId, boolean withOverlay) {
    String drawerSelector = StringUtils.isBlank(drawerId) ? ".v-navigation-drawer--open" : drawerId;
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
