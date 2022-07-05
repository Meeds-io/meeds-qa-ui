package steps;

import java.util.Map;

import pages.page.factory.HomePage;
import pages.page.factory.administration.AddUserPage;

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
