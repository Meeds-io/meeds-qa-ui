package io.meeds.qa.ui.steps;

import static io.meeds.qa.ui.utils.Utils.*;
import static net.serenitybdd.core.Serenity.*;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.meeds.qa.ui.hook.TestHooks;
import io.meeds.qa.ui.pages.page.factory.HomePage;
import io.meeds.qa.ui.pages.page.factory.administration.AddUserPage;

public class AddUserSteps {

  private AddUserPage addUserPage;

  private HomePage    homePage;

  public void addUser(Map<String, String> userDetails) {
    addUserPage.clickAddUserButton();
    for (String fieldsName : userDetails.keySet()) {
      addUserPage.setUserDetails(fieldsName, userDetails.get(fieldsName));
    }
    addUserPage.saveAddUserButton();
  }

  public void addRandomUser(String userName, String firstName, String lastName, String mail, String password) {
    addUserPage.clickAddUserButton();
    addUserPage.setRandomUserDetails(userName, firstName, lastName, mail, password);
    addUserPage.saveAddUserButton();
  }

  public void addRandomUser(String userPrefix) {
    if (StringUtils.isBlank(sessionVariableCalled(userPrefix + "UserName"))) {
      String userName = "user" + userPrefix + getRandomString();
      String firstName = getRandomString("FN " + userPrefix);
      String lastName = getRandomString("LN " + userPrefix);
      String email = userName + "@aa.bb";
      String password = "123456nBm";

      homePage.goToAddUser();
      addRandomUser(userName, firstName, lastName, email, password);

      setSessionVariable(userPrefix + "UserName").to(userName);
      setSessionVariable(userPrefix + "UserFirstName").to(firstName);
      setSessionVariable(userPrefix + "UserLastName").to(lastName);
      setSessionVariable(userPrefix + "UserPassword").to(password);
      setSessionVariable(userName + "-password").to(password);
      TestHooks.userWithPrefixCreated(userPrefix, userName, firstName, lastName, email, password);
    }
  }

  public void enterUserInformations(Map<String, String> userDetails) {
    addUserPage.clickAddUserButton();
    for (String fieldsName : userDetails.keySet()) {
      addUserPage.setUserDetails(fieldsName, userDetails.get(fieldsName));
    }
  }

  public void saveAddingUser() {
    addUserPage.saveAddUserButton();
  }

  public void enableDisableUser(String user) throws InterruptedException {
    addUserPage.enableDisableUser(user);
  }

  public void searchForUsersByName(String fullName) {
    addUserPage.searchForUsersByName(fullName);
  }

  public void searchForUsersByStatus(String status) {
    addUserPage.searchForUsersByStatus(status);
  }

  public void isUserNameDisplayed(String user) {
    addUserPage.isUserNameDisplayed(user);
  }

  public void checkThatAddUserDrawerIsDisplayed() {
    addUserPage.clickAddUserButton();
    addUserPage.checkThatAddUserDrawerIsDisplayed();
  }

  public void deleteUser() {
    addUserPage.deleteUser();
  }

  public void checkUserIsDeleted(String fullName) {
    addUserPage.checkUserIsDeleted(fullName);
  }

  public void clickToDeleteUser() {
    addUserPage.clickToDeleteUser();
  }

  public void checkPopupCantDeleteLoggedUser() {
    addUserPage.checkPopupCantDeleteLoggedUser();
  }

}
