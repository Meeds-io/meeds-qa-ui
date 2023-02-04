package io.meeds.qa.ui.pages.page.factory;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.markers.IsHidden;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://baseUrl/")
public class LoginPage extends GenericPage implements IsHidden {

  private static final String LAST_LOGGED_IN_USER_COOKIE_NAME = "lastLoggedInUser";

  private String              lastLoggedInUser                = null;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void clearCookies() {
    closeAlertIfOpened();
    getDriver().manage().deleteAllCookies();
  }

  public void login(String login, String password) {
    if (StringUtils.equals(getLastLoggedInUser(), login)) {
      closeAllDrawers();
    } else {
      openLoginPage();
      retryOnCondition(() -> tryLogin(login, password), this::refreshPage);
      getDriver().manage().addCookie(new Cookie(LAST_LOGGED_IN_USER_COOKIE_NAME, login, "/"));
      lastLoggedInUser = login;
    }
  }

  public void openLoginPage() {
    int maxRetries = 3;
    int i = 0;
    while (!StringUtils.contains(getDriver().getCurrentUrl(), "/portal/login") && i++ < maxRetries) {
      clearCookies();
      open();
    }
    lastLoggedInUser = null;
    if (i >= maxRetries) {
      throw new IllegalStateException("Can't display login page after 3 retries");
    }
  }

  public String getLastLoggedInUser() {
    if (lastLoggedInUser != null) {
      return lastLoggedInUser;
    }
    Cookie cookie = getDriver().manage().getCookieNamed(LAST_LOGGED_IN_USER_COOKIE_NAME);
    return cookie == null ? null : cookie.getValue();
  }

  private void tryLogin(String login, String password) {
    verifyPageLoaded();
    TextBoxElementFacade loginTextBox = findTextBoxElementByXpath("//*[@id='username']");
    loginTextBox.setTextValue(login);
    TextBoxElementFacade passwordTextbox = findTextBoxElementByXpath("//*[@id='password']");
    passwordTextbox.setTextValue(password);
    BaseElementFacade loginButton = findByXPathOrCSS("//*[contains(@class, 'loginButton')]//button");
    clickOnElement(loginButton);
  }

  public void logout() {
    openLoginPage();
  }

}
