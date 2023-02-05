package io.meeds.qa.ui.pages.page.factory.administration;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

public class AddUserPage extends GenericPage {

  public AddUserPage(WebDriver driver) {
    super(driver);
  }

  public void checkPopupCantDeleteLoggedUser() {
    assertWebElementVisible(popupCantDeleteLoggedUserElement());
  }

  public void checkThatAddUserDrawerIsDisplayed() {
    addUserDrawerElement().waitUntilVisible();
  }

  public void checkUserIsDeleted(String fullName) {
    searchForUserByName(fullName);
    assertWebElementNotVisible(deleteConfirmationButtonElement());
  }

  public void clickAddUserButton() {
    clickOnElement(findByXPathOrCSS(".addNewUserButton"));
  }

  public void clickToDeleteUser() {
    deleteUserIconElement().clickOnElement();
  }

  public void deleteUser() {
    deleteUserIconElement().clickOnElement();
    deleteConfirmationButtonElement().clickOnElement();
  }

  public ElementFacade disableEnableStatusButton(String user) {
    return findByXPathOrCSS(String.format("//*[@class='text-center' and contains(text(),'%s')]/following::*[@class='switch']",
                                          user));
  }

  public void enableDisableUser(String user) {
    ElementFacade element = disableEnableStatusButton(user);
    element.waitUntilVisible();
    element.clickOnElement();
    waitForProgressBar();
  }

  public ElementFacade getUserElement(String user) {
    return findByXPathOrCSS(String.format("//*[@class='v-data-table__wrapper']//*[@class='text-center' and contains(text(),'%s')][1]",
                                          user));
  }

  public void isUserNameDisplayed(String user) {
    assertWebElementVisible(getUserElement(user));
  }

  public void saveAddUserButton() {
    saveAddUserButtonElement().clickOnElement();
  }

  public void searchForUserByName(String userName) {
    searchForUserByName(userName, 1);
  }

  public void searchForUserByName(String userName, int tentatives) {
    int retry = 0;
    do {
      TextBoxElementFacade searchUsersFieldElement = searchUsersFieldElement();
      searchUsersFieldElement.waitUntilVisible();
      searchUsersFieldElement.setTextValue(userName);
      waitForProgressBar();
    } while (++retry < tentatives && !getUserElement(userName).isDisplayedNoWait());
  }

  public void searchForUsersByStatus(String status) {
    ElementFacade pullDownFilterUserStatusElement = pullDownFilterUserStatusElement();
    pullDownFilterUserStatusElement.waitUntilVisible();
    pullDownFilterUserStatusElement.selectByValue(status);
    waitForProgressBar();
  }

  public void setRandomUserDetails(String userName, String firstName, String lastName, String mail, String password) {
    userNameFieldElement().setTextValue(userName);
    firstNameFieldElement().setTextValue(firstName);
    lastNameFieldElement().setTextValue(lastName);
    emailFieldElement().setTextValue(mail);
    newPasswordFieldElement().setTextValue(password);
    confirmPasswordFieldElement().setTextValue(password);
  }

  public void setUserDetails(String fieldName, String fieldValue) {
    switch (fieldName) {
    case "UserName":
      userNameFieldElement().setTextValue(fieldValue);
      break;
    case "FirstName":
      firstNameFieldElement().setTextValue(fieldValue);
      break;
    case "LastName":
      lastNameFieldElement().setTextValue(fieldValue);
      break;
    case "Mail":
      emailFieldElement().setTextValue(fieldValue);
      break;
    case "Password":
      newPasswordFieldElement().setTextValue(fieldValue);
      break;
    case "Password Confirmation":
      confirmPasswordFieldElement().setTextValue(fieldValue);
      break;
    default:
      break;
    }
  }

  private ElementFacade addUserDrawerElement() {
    return findByXPathOrCSS("//*[@id='userFormDrawer']//*[contains(@class,'drawerTitle ')]");
  }

  private TextBoxElementFacade confirmPasswordFieldElement() {
    return findTextBoxByXPathOrCSS("//div[contains(@class,'confirmPasswordField')]//input");
  }

  private TextBoxElementFacade deleteConfirmationButtonElement() {
    return findTextBoxByXPathOrCSS("//*[@class='ignore-vuetify-classes btn btn-primary me-2']");
  }

  private TextBoxElementFacade deleteUserIconElement() {
    return findTextBoxByXPathOrCSS("//*[@class='uiIconTrash trashIconColor']");
  }

  private TextBoxElementFacade emailFieldElement() {
    return findTextBoxByXPathOrCSS("//div[contains(@class,'emailField')]//input");
  }

  private TextBoxElementFacade firstNameFieldElement() {
    return findTextBoxByXPathOrCSS("//div[contains(@class,'firstNameField')]//input");
  }

  private TextBoxElementFacade lastNameFieldElement() {
    return findTextBoxByXPathOrCSS("//div[contains(@class,'lastNameField')]//input");
  }

  private TextBoxElementFacade newPasswordFieldElement() {
    return findTextBoxByXPathOrCSS("//div[contains(@class,'newPasswordField')]//input");
  }

  private TextBoxElementFacade popupCantDeleteLoggedUserElement() {
    return findTextBoxByXPathOrCSS("//div[contains(text(), 'You can’t delete your user account while being logged in with it.')]");
  }

  private ElementFacade pullDownFilterUserStatusElement() {
    return findByXPathOrCSS("//*[contains(@class,'selectUsersFilter')]");
  }

  private ElementFacade saveAddUserButtonElement() {
    return findByXPathOrCSS("//aside[@id='userFormDrawer']//button[contains(@class,'btn-primary')]");
  }

  private TextBoxElementFacade searchUsersFieldElement() {
    return findTextBoxByXPathOrCSS("//input[@placeholder='Filter by name or email']");
  }

  private TextBoxElementFacade userNameFieldElement() {
    return findTextBoxByXPathOrCSS("//div[contains(@class,'userNameField')]//input");
  }

}
