package io.meeds.qa.ui.pages.page.factory;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
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

  public void login(String login, String password) {
    verifyPageLoaded();
    try {
      TextBoxElementFacade loginTextBox = findTextBoxElementByXpath("//*[@id='username']");
      loginTextBox.setTextValue(login);
      TextBoxElementFacade passwordTextbox = findTextBoxElementByXpath("//*[@id='password']");
      passwordTextbox.setTextValue(password);
      BaseElementFacade loginButton = findByXPathOrCSS("//*[contains(@class, 'loginButton')]//button");
      clickOnElement(loginButton);
    } catch (RuntimeException e) {
      if (e instanceof StaleElementReferenceException || e.getCause() instanceof StaleElementReferenceException) {
        login(login, password); // Retry by refreshing elements
      }
    }
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
