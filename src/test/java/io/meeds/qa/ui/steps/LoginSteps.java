package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.HomePage;
import io.meeds.qa.ui.pages.page.factory.LoginPage;
import net.serenitybdd.core.Serenity;

public class LoginSteps {

  private LoginPage loginPage;

  private HomePage  homePage;

  public void authenticate(String username) {
    loginPage.open();
    String password = Serenity.sessionVariableCalled(username + "-password");
    loginPage.login(username, password);
  }

  public boolean isHomePageDisplayed() {
    return homePage.isHomePageDisplayed();
  }

  public void logoutLogin(String username) {
    Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    homePage.logout();
    String password = Serenity.sessionVariableCalled(username + "-password");
    loginPage.login(username, password);
  }

}
