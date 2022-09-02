package io.meeds.qa.ui.pages.page.factory;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.markers.IsHidden;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://baseUrl/")
public class LoginPage extends GenericPage implements IsHidden {

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void clearCookies() {
    try {
      driver.switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
      // Normal Behavior
    }
    driver.manage().deleteAllCookies();
  }

  public void login(String login, String password) {
    openLoginPage();
    retryOnCondition(() -> tryLogin(login, password), this::refreshPage);
  }

  public void openLoginPage() {
    while (!StringUtils.contains(driver.getCurrentUrl(), "/portal/login")) {
      clearCookies();
      open();
    }
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

}
