/*
 * This file is part of the Meeds project (https://meeds.io/).
 * 
 * Copyright (C) 2020 - 2023 Meeds Association contact@meeds.io
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package io.meeds.qa.ui.pages;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class AddUserPage extends GenericPage {

  public AddUserPage(WebDriver driver) {
    super(driver);
  }

  public void checkPopupCantDeleteLoggedUser() {
    popupCantDeleteLoggedUserElement().assertVisible();
  }

  public void checkThatAddUserDrawerIsDisplayed() {
    addUserDrawerElement().assertVisible();
  }

  public void checkUserIsDeleted(String fullName) {
    searchForUserByName(fullName);
    deleteConfirmationButtonElement().assertNotVisible();
  }

  public void clickAddUserButton() {
    clickOnElement(findByXPathOrCSS(".addNewUserButton"));
  }

  public void clickToDeleteUser() {
    deleteUserIconElement().click();
  }

  public void deleteUser() {
    deleteUserIconElement().click();
    deleteConfirmationButtonElement().click();
  }

  public ElementFacade disableEnableStatusButton(String user) {
    return findByXPathOrCSS(String.format("//*[@class='text-center' and contains(text(),'%s')]/following::*[@class='switch']",
                                          user));
  }

  public void enableDisableUser(String user) {
    disableEnableStatusButton(user).click();
    waitForProgressBar();
  }

  public ElementFacade getUserElement(String user) {
    return findByXPathOrCSS(String.format("//*[@class='v-data-table__wrapper']//*[@class='text-center' and contains(text(),'%s')][1]",
                                          user));
  }

  public void isUserNameDisplayed(String user) {
    getUserElement(user).assertVisible();
  }

  public void saveAddUserButton() {
    saveAddUserButtonElement().click();
  }

  public void searchForUserByName(String userName) {
    searchForUserByName(userName, 1);
  }

  public void searchForUserByName(String userName, int tentatives) {
    int retry = 0;
    do {
      TextBoxElementFacade searchUsersFieldElement = searchUsersFieldElement();
      searchUsersFieldElement.setTextValue(userName);
      waitForProgressBar();
    } while (++retry < tentatives && !getUserElement(userName).isCurrentlyVisible());
  }

  public void searchForUsersByStatus(String status) {
    ElementFacade pullDownFilterUserStatusElement = pullDownFilterUserStatusElement();
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
