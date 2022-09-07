package io.meeds.qa.ui.pages.page.factory.administration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class AddUserPage extends GenericPage {
  @FindBy(xpath = "//*[@id='userFormDrawer']//*[contains(@class,'drawerTitle ')]")
  private BaseElementFacade                 addUserDrawer;

  @FindBy(xpath = "//div[contains(@class,'confirmPasswordField')]//input")
  private TextBoxElementFacade              confirmPasswordField;

  @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
  private TextBoxElementFacade              deleteConfirmationButton;

  @FindBy(xpath = "//*[@class='uiIconTrash trashIconColor']")
  private TextBoxElementFacade              deleteUserIcon;

  @FindBy(xpath = "//div[contains(@class,'emailField')]//input")
  private TextBoxElementFacade              emailField;

  @FindBy(xpath = "//div[contains(@class,'firstNameField')]//input")
  private TextBoxElementFacade              firstNameField;

  @FindBy(xpath = "//div[contains(@class,'lastNameField')]//input")
  private TextBoxElementFacade              lastNameField;

  @FindBy(xpath = "//div[contains(@class,'newPasswordField')]//input")
  private TextBoxElementFacade              newPasswordField;

  @FindBy(xpath = "//div[contains(text(), 'You can’t delete your user account while being logged in with it.')]")
  private TextBoxElementFacade              popupCantDeleteLoggedUser;

  @FindBy(xpath = "//*[contains(@class,'selectUsersFilter')]")
  private BaseElementFacade                 pullDownFilterUserStatus;

  @FindBy(xpath = "//aside[@id='userFormDrawer']//button[contains(@class,'btn-primary')]")
  private BaseElementFacade                 saveAddUserButton;

  @FindBy(xpath = "//input[@placeholder='Filter by name or email']")
  private TextBoxElementFacade              searchUsersField;

  @FindBy(xpath = "//div[contains(@class,'userNameField')]//input")
  private TextBoxElementFacade              userNameField;

  private Map<String, TextBoxElementFacade> mappingBaseElementXPath = new HashMap<>();

  public AddUserPage(WebDriver driver) {
    super(driver);

    mappingBaseElementXPath.put("UserName", userNameField);
    mappingBaseElementXPath.put("FirstName", firstNameField);
    mappingBaseElementXPath.put("LastName", lastNameField);
    mappingBaseElementXPath.put("Mail", emailField);
    mappingBaseElementXPath.put("Password", newPasswordField);
    mappingBaseElementXPath.put("Password Confirmation", confirmPasswordField);
  }

  public void checkPopupCantDeleteLoggedUser() {
    assertWebElementVisible(popupCantDeleteLoggedUser);
  }

  public void checkThatAddUserDrawerIsDisplayed() {
    addUserDrawer.waitUntilVisible();
  }

  public void checkUserIsDeleted(String fullName) {
    searchForUserByName(fullName);
    assertWebElementNotVisible(deleteConfirmationButton);
  }

  public void clickAddUserButton() {
    clickOnElement(findByXPathOrCSS(".addNewUserButton"));
  }

  public void clickToDeleteUser() {
    deleteUserIcon.clickOnElement();
  }

  public void deleteUser() {
    deleteUserIcon.clickOnElement();
    deleteConfirmationButton.clickOnElement();
  }

  public BaseElementFacade disableEnableStatusButton(String user) {
    return findByXPathOrCSS(String.format("//*[@class='text-center' and contains(text(),'%s')]/following::*[@class='switch']",
                                          user));
  }

  public void enableDisableUser(String user) {
    BaseElementFacade element = disableEnableStatusButton(user);
    element.waitUntilVisible();
    element.clickOnElement();
    waitForProgressBar();
  }

  public void isUserNameDisplayed(String user) {
    assertWebElementVisible(getUserElement(user));
  }

  public void saveAddUserButton() {
    saveAddUserButton.clickOnElement();
  }

  public void searchForUserByName(String userName) {
    searchForUserByName(userName, 1);
  }

  public void searchForUserByName(String userName, int tentatives) {
    int retry = 0;
    do {
      searchUsersField.waitUntilVisible();
      searchUsersField.setTextValue(userName);
      waitForProgressBar();
    } while (++retry < tentatives && !getUserElement(userName).isDisplayedNoWait());
  }

  public void searchForUsersByStatus(String status) {
    pullDownFilterUserStatus.waitUntilVisible();
    pullDownFilterUserStatus.selectByValue(status);
    waitForProgressBar();
  }

  public void setRandomUserDetails(String userName, String firstName, String lastName, String mail, String password) {
    userNameField.setTextValue(userName);
    firstNameField.setTextValue(firstName);
    lastNameField.setTextValue(lastName);
    emailField.setTextValue(mail);
    newPasswordField.setTextValue(password);
    confirmPasswordField.setTextValue(password);
  }

  public void setUserDetails(String userDetails, String fieldValue) {
    mappingBaseElementXPath.get(userDetails).setTextValue(fieldValue);
  }

  public BaseElementFacade getUserElement(String user) {
    return findByXPathOrCSS(String.format("//*[@class='v-data-table__wrapper']//*[@class='text-center' and contains(text(),'%s')][1]",
                                          user));
  }

}
