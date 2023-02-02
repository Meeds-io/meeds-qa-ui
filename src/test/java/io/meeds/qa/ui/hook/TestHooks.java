package io.meeds.qa.ui.hook;

import static net.serenitybdd.core.Serenity.setSessionVariable;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.meeds.qa.ui.steps.AdminApplicationSteps;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.LoginSteps;
import io.meeds.qa.ui.steps.ManageBadgesSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;
import io.meeds.qa.ui.steps.definition.ManageSpaceStepDefinitions;
import io.meeds.qa.ui.utils.ExceptionLauncher;
import io.meeds.qa.ui.utils.Utils;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;

public class TestHooks {

  private static final int                   CONSOLE_ERRORS_COUNT_FAIL = 5;

  protected static final Map<String, String> SPACES                    = new HashMap<>();

  protected static final Map<String, String> SPACES_URLS               = new HashMap<>();

  protected static final Map<String, String> USERS                     = new HashMap<>();

  public static void spaceWithPrefixCreated(String spaceNamePrefix, String spaceName, String spaceUrl) {
    SPACES.put(spaceNamePrefix, spaceName);
    SPACES_URLS.put(spaceNamePrefix, spaceUrl);
    setSessionVariable(spaceNamePrefix).to(spaceName);
    setSessionVariable(spaceNamePrefix + "-url").to(spaceUrl);
  }

  public static void spaceWithPrefixDeleted(String spaceNamePrefix) {
    SPACES.remove(spaceNamePrefix);
    SPACES_URLS.remove(spaceNamePrefix);
  }

  public static void userWithPrefixCreated(String userPrefix,
                                           String userName,
                                           String firstName,
                                           String lastName,
                                           String email,
                                           String password) {
    USERS.put(userPrefix + "UserName", userName);
    USERS.put(userPrefix + "UserFirstName", firstName);
    USERS.put(userPrefix + "UserLastName", lastName);
    USERS.put(userPrefix + "UserPassword", password);
    USERS.put(userPrefix + "UserEmail", email);
    USERS.put(userName + "-password", password);
  }

  @Steps
  private AdminApplicationSteps      adminApplicationSteps;

  private boolean                    adminLoggedIn;

  @Steps
  private HomeSteps                  homeSteps;

  @Steps
  private LoginSteps                 loginSteps;

  @Steps
  private ManageBadgesSteps          manageBadgesSteps;

  @Steps
  private ManageSpaceStepDefinitions manageSpaceStepDefinitions;

  @Steps
  private ManageSpaceSteps           manageSpaceSteps;

  @Before
  public void initDatas() { // NOSONAR
    String adminPassword = System.getProperty("adminPassword");
    Serenity.setSessionVariable("admin-password").to(adminPassword);
    adminLoggedIn = false;

    WebDriver driver = Serenity.getDriver();

    checkPageState(driver);

    SPACES.entrySet().forEach(entry -> {
      if (StringUtils.isNotBlank(entry.getValue())) {
        Serenity.setSessionVariable(entry.getKey()).to(entry.getValue());
      }
    });
    SPACES_URLS.entrySet().forEach(entry -> {
      if (StringUtils.isNotBlank(entry.getValue())) {
        Serenity.setSessionVariable(entry.getKey() + "-url").to(entry.getValue());
      }
    });
    USERS.entrySet().forEach(entry -> {
      if (StringUtils.isNotBlank(entry.getValue())) {
        Serenity.setSessionVariable(entry.getKey()).to(entry.getValue());
      }
    });
  }

  @After
  public void deleteDatas() {
    try {
      deleteGamificationBadges();
      deleteAppCenterApplications();
    } catch (Exception e) {
      ExceptionLauncher.LOGGER.warn("Error while deleting previously created data", e);
    }
    cleanupBrowser();
  }

  private void deleteAppCenterApplications() {
    // cleanup created AppCenter applications
    List<String> appNames = Serenity.sessionVariableCalled("appCenterAppName");
    if (CollectionUtils.isNotEmpty(appNames)) {
      loginAsAdmin();
      homeSteps.goToAppCenterAdminSetupPage();
      for (String appName : appNames) {
        if (adminApplicationSteps.isAppExists(appName)) {
          adminApplicationSteps.deleteApp(appName, true);
        }
      }
    }
  }

  private void deleteGamificationBadges() {
    String badgeName = Serenity.sessionVariableCalled("badgeName");
    String updatedBadgeName = Serenity.sessionVariableCalled("updatedBadgeName");

    if (badgeName != null && !badgeName.isEmpty()) {
      loginAsAdmin();
      manageBadgesSteps.goToManageBadgesMenu();
      manageBadgesSteps.clickOnDeleteBadge(badgeName);
      manageBadgesSteps.confirmDeletionBadge();
    }

    if (updatedBadgeName != null && !updatedBadgeName.isEmpty()) {
      loginAsAdmin();
      manageBadgesSteps.goToManageBadgesMenu();
      manageBadgesSteps.clickOnDeleteBadge(updatedBadgeName);
      manageBadgesSteps.confirmDeletionBadge();
    }
  }

  private void cleanupBrowser() {
    try {
      Serenity.getDriver().manage().deleteAllCookies();
    } catch (Throwable e) { // NOSONAR
      ExceptionLauncher.LOGGER.warn("Error while cleaning browser", e);
    }
  }

  private void loginAsAdmin() {
    if (!adminLoggedIn) {
      loginSteps.logoutLogin("admin");
      adminLoggedIn = true;
    }
  }

  private void checkPageState(WebDriver driver) {
    try {
      driver.switchTo().alert().accept();
      driver.navigate().refresh();
    } catch (Throwable e) { // NOSONAR
      // Normal Behavior
    }
    // Check wether the page has been loaded for the first time or not
    String currentUrl = driver.getCurrentUrl();
    if (StringUtils.contains(currentUrl, "/portal")) {
      List<String> errors = getJavascriptConsoleErrors(driver);
      if (errors.size() > CONSOLE_ERRORS_COUNT_FAIL) {
        // force refresh CSS and Javascript content when a timeout happens
        // while loading the page such as Nginx timeout when the page has been
        // loaded for the whole first time. This will avoid opening a new
        // window on each test scenario execution
        JavascriptExecutorFacade javascriptExecutorFacade = new JavascriptExecutorFacade(driver);
        reloadPageJavascript(javascriptExecutorFacade);
        reloadPageCSS(javascriptExecutorFacade);

        // Wait 2 seconds for assets to reload
        Utils.waitForInMillis(2000);

        // Refresh the page
        goToHomePage(driver);

        // Get the JS console errors again and make the test fails when multiple
        // errors
        errors = getJavascriptConsoleErrors(driver);
        assertTrue(errors.size() < (CONSOLE_ERRORS_COUNT_FAIL * 2),
                   "It Seems that web page " + driver.getCurrentUrl() + " has " + errors.size() + " errors in JS console: \n"
                       + StringUtils.join(errors, "\n- Console Error: "));
      }
    }
  }

  private void goToHomePage(WebDriver driver) {
    driver.navigate().to(driver.getCurrentUrl().split("/portal")[0]);
    try {
      driver.switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
      // Normal Behavior
    }
    driver.navigate().refresh();
  }

  private void reloadPageJavascript(JavascriptExecutorFacade javascriptExecutorFacade) {
    javascriptExecutorFacade.executeScript("const elements = document.getElementsByTagName('script');"
        + "for (let i = 0; i < elements.length; i++) {"
        + "  if(elements[i].src) {"
        + "    elements[i].src = elements[i].src.indexOf('?') > 0 ? `${elements[i].src}&update=${Date.now()}`:`${elements[i].src}?update=${Date.now()}`"
        + "  }"
        + "}");
  }

  private void reloadPageCSS(JavascriptExecutorFacade javascriptExecutorFacade) {
    javascriptExecutorFacade.executeScript("const elements = document.getElementsByTagName('link');"
        + "for (let i = 0; i < elements.length; i++) {"
        + "  if(elements[i].href) {"
        + "    elements[i].href = elements[i].href.indexOf('?') > 0 ? `${elements[i].href}&update=${Date.now()}`:`${elements[i].href}?update=${Date.now()}`"
        + "  }"
        + "}");
  }

  private List<String> getJavascriptConsoleErrors(WebDriver driver) {
    List<String> errors = null;
    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
    if (logEntries != null) {
      Iterator<LogEntry> logEntryIterator = logEntries.iterator();
      while (logEntryIterator.hasNext()) {
        LogEntry logEntry = logEntryIterator.next();
        if (logEntry.getLevel() == Level.SEVERE
            && logEntry.getTimestamp() > (System.currentTimeMillis() - 10000)
            && !StringUtils.contains(logEntry.getMessage(), "?update=")
            && !StringUtils.contains(logEntry.getMessage(), "/rest")) {
          if (errors == null) {
            errors = new ArrayList<>();
          }
          errors.add(logEntry.getMessage());
        }
      }
    }
    return errors == null ? Collections.emptyList() : errors;
  }

}
