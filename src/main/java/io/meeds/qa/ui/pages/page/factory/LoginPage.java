package io.meeds.qa.ui.pages.page.factory;

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
  public LoginPage() {
    url = "firstPage";
  }

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "username")
  private TextBoxElementFacade loginTextBox;

  @FindBy(id = "password")
  private TextBoxElementFacade passwordTextbox;

  @FindBy(tagName = "button")
  private ButtonElementFacade  loginButton;

  @FindBy(xpath = "//button[@value='skipform']")
  private BaseElementFacade    skipButton;

  public void login(String login, String password) {
    if (skipButton.isVisible())
      skipButton.clickOnElement();

    loginTextBox.waitUntilVisible();
    loginTextBox.setTextValue(login);
    passwordTextbox.setTextValue(password);
    loginButton.clickOnElement();
  }

}
