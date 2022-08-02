package io.meeds.qa.ui.pages.page.factory.administration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class AddUserPage extends GenericPage {
  public AddUserPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//button[contains(@class,'addNewUserButton')]")
  private BaseElementFacade    addUserButton;

  @FindBy(xpath = "//*[contains(@class,'selectUsersFilter')]")
  private BaseElementFacade    pullDownFilterUserStatus;

  @FindBy(xpath = "//input[@placeholder='Filter by name or email']")
  private TextBoxElementFacade searchUsersField;

  @FindBy(xpath = "//aside[@id='userFormDrawer']//button[contains(@class,'btn-primary')]")
  private BaseElementFacade    saveAddUserButton;

  @FindBy(xpath = "//*[@id='userFormDrawer']//*[contains(@class,'drawerTitle ')]")
  private BaseElementFacade    addUserDrawer;

  @FindBy(xpath = "//div[contains(@class,'userNameField')]//input")
  private TextBoxElementFacade userNameField;

  @FindBy(xpath = "//div[contains(@class,'firstNameField')]//input")
  private TextBoxElementFacade firstNameField;

  @FindBy(xpath = "//div[contains(@class,'lastNameField')]//input")
  private TextBoxElementFacade lastNameField;

  @FindBy(xpath = "//div[contains(@class,'emailField')]//input")
  private TextBoxElementFacade emailField;

  @FindBy(xpath = "//div[contains(@class,'newPasswordField')]//input")
  private TextBoxElementFacade newPasswordField;

  @FindBy(xpath = "//div[contains(@class,'confirmPasswordField')]//input")
  private TextBoxElementFacade confirmPasswordField;

  @FindBy(xpath = "//*[@class='uiIconTrash trashIconColor']")
  private TextBoxElementFacade deleteUserIcon;

  @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
  private TextBoxElementFacade deleteConfirmationButton;

  @FindBy(xpath = "//div[contains(text(), 'You can’t delete your user account while being logged in with it.')]")
  private TextBoxElementFacade popupCantDeleteLoggedUser;

  private TextBoxElementFacade getUserField(String classField) {
    return findTextBoxElementByXpath(String.format("//div[contains(@class,'%s')]//input", classField));
  }

  public BaseElementFacade disableEnableStatusButton(String user) {
    return findByXpath(String
                             .format("(//*[@class='text-center' and contains(text(),'%s')]//following::*[@class='switch']//*[@class='slider round'])[1]",
                                     user));
  }

  public BaseElementFacade userNameDisplayed(String user) {
    return findByXpath(String
                             .format("//*[@class='v-data-table__wrapper']//*[@class='text-center' and contains(text(),'%s')][1]",
                                     user));
  }

  public void isUserNameDisplayed(String user) {
    userNameDisplayed(user).isVisibleAfterWaiting();
  }

  Map<String, TextBoxElementFacade> MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH =
                                                                                      new HashMap<String, TextBoxElementFacade>() {
                                                                                        {
                                                                                          put("UserName", userNameField);
                                                                                          put("FirstName", firstNameField);
                                                                                          put("LastName", lastNameField);
                                                                                          put("Mail", emailField);
                                                                                          put("Password", newPasswordField);
                                                                                          put("Password Confirmation",
                                                                                              confirmPasswordField);

                                                                                        }
                                                                                      };

  public void checkThatAddUserDrawerIsDisplayed() {
    addUserDrawer.waitUntilVisible();
  }

  public void searchForUsersByStatus(String status) {
    pullDownFilterUserStatus.waitUntilVisible();
    pullDownFilterUserStatus.selectByValue(status);
  }

  public void searchForUsersByName(String fullName) {
    searchUsersField.waitUntilVisible();
    searchUsersField.setTextValue(fullName);
  }

  public void clickAddUserButton() {
    addUserButton.clickOnElement();
  }

  public void setUserDetails(String userDetails, String fieldValue) {
    MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.get(userDetails).setTextValue(fieldValue);
  }

  public void setRandomUserDetails(String userName, String firstName, String lastName, String mail, String password) {
    userNameField.setTextValue(userName);
    firstNameField.setTextValue(firstName);
    lastNameField.setTextValue(lastName);
    emailField.setTextValue(mail);
    newPasswordField.setTextValue(password);
    confirmPasswordField.setTextValue(password);
  }

  public void saveAddUserButton() {
    saveAddUserButton.clickOnElement();
  }

  public void enableDisableUser(String user) throws InterruptedException {
//    Thread.sleep(5000);
    disableEnableStatusButton(user).waitUntilVisible();
    disableEnableStatusButton(user).clickOnElement();
  }

  public void deleteUser() {
    deleteUserIcon.clickOnElement();
    deleteConfirmationButton.clickOnElement();
  }

  public void checkUserIsDeleted(String fullName) {
    searchUsersField.waitUntilVisible();
    searchUsersField.setTextValue(fullName);
    deleteConfirmationButton.isNotVisibleAfterWaiting();
  }

  public void clickToDeleteUser() {
    deleteUserIcon.clickOnElement();
  }

  public void checkPopupCantDeleteLoggedUser() {
    popupCantDeleteLoggedUser.isVisibleAfterWaiting();
  }

}
