package io.meeds.qa.ui.steps;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.pages.page.factory.HomePage;
import io.meeds.qa.ui.pages.page.factory.LoginPage;
import net.serenitybdd.core.Serenity;

public class LoginSteps {

  private HomePage  homePage;

  private LoginPage loginPage;

  public void authenticate(String username) {
    String password = Serenity.sessionVariableCalled(username + "-password");
    loginPage.login(username, password);
  }

  public void authenticateIfRandomSpaceAndUsersNotExists(String username, String spacePrefix, List<String> userPrefixes) {
    boolean spaceDoesntExist = StringUtils.isBlank(spacePrefix) || StringUtils.isBlank(sessionVariableCalled(spacePrefix));
    boolean userDoesntExist = userPrefixes.stream()
                                          .anyMatch(userPrefix -> StringUtils.isBlank(sessionVariableCalled(userPrefix
                                              + "UserName")));
    if (userDoesntExist || spaceDoesntExist) {
      authenticate(username);
    }
  }

  public void authenticateIfUsersNotExists(String username, List<String> userPrefixes) {
    authenticateIfRandomSpaceAndUsersNotExists(username, null, userPrefixes);
  }

  public boolean isHamburgerNavigationDisplayed() {
    return homePage.isHamburgerNavigationDisplayed();
  }

  public boolean isLoggedIn() {
    String currentUrl = loginPage.getCurrentUrl();
    return StringUtils.contains(currentUrl, "/portal") && !StringUtils.contains(currentUrl, "/login");
  }

  public void logout() {
    try {
      homePage.logout();
    } finally {
      loginPage.logout();
    }
  }

  public void deleteCookies() {
    loginPage.deleteCookies();
  }

}
