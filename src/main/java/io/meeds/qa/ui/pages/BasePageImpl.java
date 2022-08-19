package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.decorateDriver;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoaded;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

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
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.selectors.Selectors;
import net.thucydides.core.pages.PageObject;

public class BasePageImpl extends PageObject implements BasePage {

  private static final String   XPATH_FORMAT_ERROR_MESSAGE  = "The format for the xpath [%s] is not correct.";

  private static final Duration DEFAULT_SHORT_WAIT_DURATION = Duration.ofMillis(200);

  static final Logger           LOGGER                      = LoggerFactory.getLogger(BasePageImpl.class);

  protected String              url;

  protected WebDriver           driver;

  public BasePageImpl() {
    this(null);
  }

  public BasePageImpl(WebDriver driver) {
    super(decorateDriver(driver));
    this.driver = getDriver();
  }

  @Override
  public void verifyPageLoaded() {
    waitForPageLoaded();
  }

  public void waitForDrawerToLoad() {
    WebDriverWait wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(30));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState === 'complete' "
        + " && (!document.getElementById('TopbarLoadingContainer') || !!document.querySelector('.TopbarLoadingContainer.hidden'))"
        + " && !!document.querySelector('.v-navigation-drawer--open')"
        + " && !document.querySelector('.v-navigation-drawer--open .v-progress-linear')")
                                                            .toString()
                                                            .equals("true"));
  }

  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

  public void refreshPage() {
    driver.navigate().refresh();
    try {
      driver.switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
      // Normal Behavior
    }
    verifyPageLoaded();
  }

  public void clickOnElement(BaseElementFacade element) {
    element.clickOnElement();
  }

  /**********************************************************
   * Methods for finding element facade in the page
   **********************************************************/

  private WebElementFacade getWebElementFacadeByXpathOrCSS(String xpath) {
    verifyPageLoaded();
    return findBy(xpath);
  }

  public <T extends BaseElementFacade> T findByXPathOrCSS(String xpathOrCSSSelector) {
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpathOrCSSSelector);

    return BaseElementFacadeImpl.wrapWebElementFacade(getDriver(),
                                                      nestedElement,
                                                      getImplicitWaitTimeout().toMillis(),
                                                      getWaitForTimeout().toMillis());
  }

  public <T extends TextBoxElementFacade> T findTextBoxElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      ExceptionLauncher.throwSerenityExeption(new Exception(),
                                              String.format(XPATH_FORMAT_ERROR_MESSAGE, xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return TextBoxElementFacadeImpl.wrapWebElementFacadeInTextBoxElement(getDriver(),
                                                                         nestedElement,
                                                                         getImplicitWaitTimeout().toMillis(),
                                                                         getWaitForTimeout().toMillis());
  }

  public <T extends ButtonElementFacade> T findButtonElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      ExceptionLauncher.throwSerenityExeption(new Exception(),
                                              String.format(XPATH_FORMAT_ERROR_MESSAGE, xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return ButtonElementFacadeImpl.wrapWebElementFacadeInButtonElement(getDriver(),
                                                                       nestedElement,
                                                                       getImplicitWaitTimeout().toMillis(),
                                                                       getWaitForTimeout().toMillis());
  }

  public <T extends TextElementFacade> T findTextElementByXpath(String xpath) {
    if (!Selectors.isXPath(xpath)) {
      ExceptionLauncher.throwSerenityExeption(new Exception(),
                                              String.format(XPATH_FORMAT_ERROR_MESSAGE, xpath));
    }
    WebElementFacade nestedElement = getWebElementFacadeByXpathOrCSS(xpath);

    return TextElementFacadeImpl.wrapWebElementFacadeInTextElement(getDriver(),
                                                                   nestedElement,
                                                                   getImplicitWaitTimeout().toMillis(),
                                                                   getWaitForTimeout().toMillis());
  }

  public void waitCKEditorLoading() {
    BaseElementFacade richTextLoadingElement = findByXPathOrCSS("//*[contains(@class, 'loadingRing')]");
    richTextLoadingElement.setImplicitTimeout(Duration.ofSeconds(0));
    if (richTextLoadingElement.isDisplayed()) {
      richTextLoadingElement.setImplicitTimeout(Duration.ofSeconds(5));
      richTextLoadingElement.waitUntilNotVisible();
    }
  }

  public void waitForProgressBar() {
    try {
      BaseElementFacade progressBar = findByXPathOrCSS(".UISiteBody .v-progress-linear");
      progressBar.waitUntilVisible();
      progressBar.waitUntilNotVisible();
    } catch (Exception e) {
      ExceptionLauncher.LOGGER.debug("Can't wait for progress bar to finish loading", e);
    }
  }

  public void mentionUserWithContent(BaseElementFacade ckEditorFrame,
                                     TextBoxElementFacade ckEditorBody,
                                     String content,
                                     String user) {
    waitCKEditorLoading();
    ckEditorFrame.waitUntilVisible();
    ckEditorFrame.clickOnElement();
    driver.switchTo().frame(ckEditorFrame);
    try {
      ckEditorBody.waitUntilVisible();
      ckEditorBody.setTextValue(content + ' ' + '@' + user + "x");
      ckEditorBody.sendKeys(Keys.BACK_SPACE);

      boolean visible = false;
      int retry = 0;
      do {
        waitFor(500).milliseconds();
        ckEditorBody.sendKeys(Keys.BACK_SPACE);
        driver.switchTo().defaultContent();
        BaseElementFacade suggesterElement =
                                           findByXPathOrCSS(String.format("//*[contains(@class, 'atwho-view')]//*[contains(text(), '%s')]",
                                                                          user.substring(0, user.length() - retry - 1)));
        suggesterElement.setImplicitTimeout(Duration.ofSeconds(1));
        visible = suggesterElement.isVisibleAfterWaiting();
        driver.switchTo().frame(ckEditorFrame);
      } while (!visible && retry++ < 5);
      ckEditorBody.sendKeys(Keys.ENTER);
    } finally {
      driver.switchTo().defaultContent();
    }
  }

  public void assertWebElementNotVisible(BaseElementFacade element) {
    assertTrue(isWebElementNotVisible(element)); // NOSONAR
  }

  public void assertWebElementVisible(BaseElementFacade element) {
    assertTrue(isWebElementVisible(element)); // NOSONAR
  }

  public boolean isVisible(String xpathOrCss) {
    return isWebElementVisible(findByXPathOrCSS(xpathOrCss));
  }

  public boolean isNotVisible(String xpathOrCss) {
    return isWebElementNotVisible(findByXPathOrCSS(xpathOrCss));
  }

  public boolean isWebElementVisible(BaseElementFacade element) {
    verifyPageLoaded();
    element.setImplicitTimeout(DEFAULT_SHORT_WAIT_DURATION);
    boolean visible = false;
    int retry = 0;
    do {
      visible = element.isVisibleAfterWaiting();
    } while (!visible && retry++ < 5);
    return visible;
  }

  public boolean isWebElementNotVisible(BaseElementFacade element) {
    verifyPageLoaded();
    element.setImplicitTimeout(DEFAULT_SHORT_WAIT_DURATION);
    boolean notVisible = false;
    int retry = 0;
    do {
      notVisible = element.isNotVisibleAfterWaiting();
    } while (!notVisible && retry++ < 5);
    return notVisible;
  }

}
