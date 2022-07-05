package stepDefinitions;

import java.util.Map;
import java.util.Random;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import steps.AddUserSteps;
import steps.HomeSteps;

public class AddUserStepDefinition {
  @Steps
  HomeSteps    homeSteps;

  @Steps
  AddUserSteps addUserSteps;

  String       firstUserName        = "user1" + getRandomString();

  String       firstUserFirstName   = getRandomString();

  String       firstUserLastName    = getRandomString();

  String       firstUserMail        = firstUserFirstName + "." + firstUserLastName + "@aa.bb";

  String       firstUserPassword    = "123456nBm";

  String       secondUserName       = "user2" + getRandomString();

  String       secondUserFirstName  = getRandomString();

  String       secondUserLastName   = getRandomString();

  String       secondUserMail       = secondUserFirstName + "." + secondUserLastName + "@aa.bb";

  String       secondUserPassword   = "123456nBm";

  String       thirdUserName        = "user3" + getRandomString();

  String       thirdUserFirstName   = getRandomString();

  String       thirdUserLastName    = getRandomString();

  String       thirdUserMail        = thirdUserFirstName + "." + thirdUserLastName + "@aa.bb";

  String       thirdUserPassword    = "123456nBm";

  String       fourthUserName       = "user4" + getRandomString();

  String       fourthUserFirstName  = getRandomString();

  String       fourthUserLastName   = getRandomString();

  String       fourthUserMail       = fourthUserFirstName + "." + fourthUserLastName + "@aa.bb";

  String       fourthUserPassword   = "123456nBm";

  String       fifthUserName        = "user5" + getRandomString();

  String       fifthUserFirstName   = getRandomString();

  String       fifthUserLastName    = getRandomString();

  String       fifthUserMail        = fifthUserFirstName + "." + fifthUserLastName + "@aa.bb";

  String       fifthUserPassword    = "123456nBm";

  String       sixthUserName        = "user6" + getRandomString();

  String       sixthUserFirstName   = getRandomString();

  String       sixthUserLastName    = getRandomString();

  String       sixthUserMail        = sixthUserFirstName + "." + sixthUserLastName + "@aa.bb";

  String       sixthUserPassword    = "123456nBm";

  String       firstAdminName       = "admin1" + getRandomString();

  String       firstAdminFirstName  = getRandomString();

  String       firstAdminLastName   = getRandomString();

  String       firstAdminMail       = firstAdminFirstName + "." + firstAdminLastName + "@aa.bb";

  String       firstAdminPassword   = "123456nBm";

  String       firstUserSuggestion  = firstUserFirstName + " " + firstUserLastName;

  String       secondUserSuggestion = secondUserFirstName + " " + secondUserLastName;

  public static String getRandomString() {
    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 6; i++) {
      char c = chars[random.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  public static String getTheRandomNumber() {
    char[] chars = "0123456789".toCharArray();
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      char c = chars[random.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  @Given("^I create a dedicated user to be an administrator$")
  public void addRandomAdminUser() {
    homeSteps.goToAddUser();
    addUserSteps.addRandomUser(firstAdminName, firstAdminFirstName, firstAdminLastName, firstAdminMail, firstAdminPassword);
    Serenity.setSessionVariable("firstAdminName").to(firstAdminName);
    Serenity.setSessionVariable("firstAdminFirstName").to(firstAdminFirstName);
    Serenity.setSessionVariable("firstAdminLastName").to(firstAdminLastName);
    Serenity.setSessionVariable("firstAdminPassword").to(firstAdminPassword);

  }

  @Given("^I create the first random user$")
  public void addRandomUser() {
    homeSteps.goToAddUser();
    addUserSteps.addRandomUser(firstUserName, firstUserFirstName, firstUserLastName, firstUserMail, firstUserPassword);
    Serenity.setSessionVariable("firstUserName").to(firstUserName);
    Serenity.setSessionVariable("firstUserFirstName").to(firstUserFirstName);
    Serenity.setSessionVariable("firstUserLastName").to(firstUserLastName);
    Serenity.setSessionVariable("firstUserPassword").to(firstUserPassword);

  }

  @Given("^I create the second random user$")
  public void addSecondRandomUser() {
    homeSteps.goToAddUser();
    addUserSteps.addRandomUser(secondUserName, secondUserFirstName, secondUserLastName, secondUserMail, secondUserPassword);
    Serenity.setSessionVariable("secondUserName").to(secondUserName);
    Serenity.setSessionVariable("secondUserFirstName").to(secondUserFirstName);
    Serenity.setSessionVariable("secondUserLastName").to(secondUserLastName);
    Serenity.setSessionVariable("secondUserPassword").to(secondUserPassword);

  }

  @Given("^I create the third random user$")
  public void addThirdRandomUser() {
    homeSteps.goToAddUser();
    addUserSteps.addRandomUser(thirdUserName, thirdUserFirstName, thirdUserLastName, thirdUserMail, thirdUserPassword);
    Serenity.setSessionVariable("thirdUserName").to(thirdUserName);
    Serenity.setSessionVariable("thirdUserFirstName").to(thirdUserFirstName);
    Serenity.setSessionVariable("thirdUserLastName").to(thirdUserLastName);
    Serenity.setSessionVariable("thirdUserPassword").to(thirdUserPassword);

  }

  @Given("^I create the fourth random user$")
  public void addFourthRandomUser() {
    homeSteps.goToAddUser();
    addUserSteps.addRandomUser(fourthUserName, fourthUserFirstName, fourthUserLastName, fourthUserMail, fourthUserPassword);
    Serenity.setSessionVariable("fourthUserName").to(fourthUserName);
    Serenity.setSessionVariable("fourthUserFirstName").to(fourthUserFirstName);
    Serenity.setSessionVariable("fourthUserLastName").to(fourthUserLastName);
    Serenity.setSessionVariable("fourthUserPassword").to(fourthUserPassword);
  }

  @Given("^I create the fifth random user$")
  public void addFifthRandomUser() {
    homeSteps.goToAddUser();
    addUserSteps.addRandomUser(fifthUserName, fifthUserFirstName, fifthUserLastName, fifthUserMail, fifthUserPassword);
    Serenity.setSessionVariable("fifthUserName").to(fifthUserName);
    Serenity.setSessionVariable("fifthUserFirstName").to(fifthUserFirstName);
    Serenity.setSessionVariable("fifthUserLastName").to(fifthUserLastName);
    Serenity.setSessionVariable("fifthUserPassword").to(fifthUserPassword);
  }

  @Given("^I create the sixth random user$")
  public void addSixthRandomUser() {
    homeSteps.goToAddUser();
    addUserSteps.addRandomUser(sixthUserName, sixthUserFirstName, sixthUserLastName, sixthUserMail, sixthUserPassword);
    Serenity.setSessionVariable("sixthUserName").to(sixthUserName);
    Serenity.setSessionVariable("sixthUserFirstName").to(sixthUserFirstName);
    Serenity.setSessionVariable("sixthUserLastName").to(sixthUserLastName);
    Serenity.setSessionVariable("sixthUserPassword").to(sixthUserPassword);
  }

  @Given("^The following user is created$")
  public void adduser(Map<String, String> userDetails) {
    homeSteps.goToAddUser();
    addUserSteps.addUser(userDetails);
  }

  @And("^I disable the second created User Status$")
  public void enableDisableSecondUser() throws InterruptedException {
    addUserSteps.enableDisableUser(secondUserName);
  }

  @Given("^I search for user '(.*)'$")
  public void searchForUsersByName(String fullName) {
    addUserSteps.searchForUsersByName(fullName);
  }

  @Given("^I search for second created user$")
  public void searchForSecondCreatedUser() {
    addUserSteps.searchForUsersByName(secondUserFirstName + ' ' + secondUserLastName);
  }

  @Given("^I enter the user's informations$")
  public void enterUserInformations(Map<String, String> userDetails) {
    homeSteps.goToAddUser();
    addUserSteps.enterUserInformations(userDetails);
  }

  @Given("^I create a random user with last name Smith$")
  public void addRandomUserWithSameLastName() {
    homeSteps.goToAddUser();
    addUserSteps.addRandomUser(firstUserName, firstUserFirstName, "Smith", firstUserMail, firstUserPassword);
    Serenity.setSessionVariable("randomUserName").to(firstUserName);
    Serenity.setSessionVariable("randomUserFirstName").to(firstUserFirstName);
    Serenity.setSessionVariable("randomUserLastName").to("Smith");
    Serenity.setSessionVariable("randomUserPassword").to(firstUserPassword);

  }

  @Given("^I enable User Status '(.*)'$")
  @And("^I disable User Status '(.*)'$")
  public void enableDisableUser(String user) throws InterruptedException {
    addUserSteps.enableDisableUser(user);
  }

  @Given("^I search for '(.*)' Users$")
  public void searchForUsersByStatus(String status) {
    addUserSteps.searchForUsersByStatus(status);
  }

  @Given("^The user '(.*)' is displayed$")
  public void isUserNameDisplayed(String user) {
    addUserSteps.isUserNameDisplayed(user);
  }

  @Given("^The first created user is displayed$")
  public void isFirstUserNameDisplayed() {
    addUserSteps.isUserNameDisplayed(firstUserName);
  }

  @Given("^The second created user is displayed$")
  public void isSecondUserNameDisplayed() {
    addUserSteps.isUserNameDisplayed(secondUserName);
  }

  @Given("^I add the user$")
  public void saveAddingUser() {
    addUserSteps.saveAddingUser();
  }

  @Given("^I go to Add Users page$")
  public void goToAddUser() {
    homeSteps.goToAddUser();
  }

  @Given("^Add Users drawer is opened$")
  public void checkThatAddUserDrawerIsDisplayed() {
    addUserSteps.checkThatAddUserDrawerIsDisplayed();
  }

  @Given("^I search for created user '(.*)'")
  public void searchForUser(String fullName) {
    addUserSteps.searchForUsersByName(fullName);
  }

  @Given("^I search for the created random user")
  public void searchForCreatedUser() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    addUserSteps.searchForUsersByName(firstUserName);
  }

  @Given("^I delete user$")
  public void deleteUser() {
    addUserSteps.deleteUser();
  }

  @Given("^I check that '(.*)' is deleted'")
  public void checkUserIsDeleted(String fullName) {
    addUserSteps.checkUserIsDeleted(fullName);
  }

  @Given("^I check that the created user is deleted")
  public void checkCreatedUserIsDeleted() {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String firstUserFullName = firstUserFirstName + " " + firstUserLastName;
    addUserSteps.checkUserIsDeleted(firstUserFullName);
  }

  @Given("^I click to delete user$")
  public void clickToDeleteUser() {
    addUserSteps.clickToDeleteUser();
  }

  @Given("^Popup is displayed to inform user that we can't delete your user account while being logged in with it$")
  public void checkPopupCantDeleteLoggedUser() {
    addUserSteps.checkPopupCantDeleteLoggedUser();
  }

  @Given("^I create a dedicated user to attribute role$")
  public void addRandomRoleUser() {
    homeSteps.goToAddUser();
    addUserSteps.addRandomUser(firstAdminName, firstAdminFirstName, firstAdminLastName, firstAdminMail, firstAdminPassword);
    Serenity.setSessionVariable("firstAdminName").to(firstAdminName);
    Serenity.setSessionVariable("firstAdminFirstName").to(firstAdminFirstName);
    Serenity.setSessionVariable("firstAdminLastName").to(firstAdminLastName);
    Serenity.setSessionVariable("firstAdminPassword").to(firstAdminPassword);
  }
}
