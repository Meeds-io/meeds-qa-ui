package io.meeds.qa.ui.pages.page.factory;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.ButtonElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.markers.IsHidden;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://baseUrl/")
public class LoginPage extends GenericPage implements IsHidden {

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void login(String login, String password) {
    TextBoxElementFacade loginTextBox = findTextBoxElementByXpath("//*[@id='username']");
    loginTextBox.setTextValue(login);
    TextBoxElementFacade passwordTextbox = findTextBoxElementByXpath("//*[@id='password']");
    passwordTextbox.setTextValue(password);
    BaseElementFacade loginButton = findByXpathOrCSS("//*[contains(@class, 'loginButton')]//button");
    clickOnElement(loginButton);
  }

  public void clearCookies() {
    try {
      driver.switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
      // Normal Behavior
    }
    driver.manage().deleteAllCookies();
  }

}
