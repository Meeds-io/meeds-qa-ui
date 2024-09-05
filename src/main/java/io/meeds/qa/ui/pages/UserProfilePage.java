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

import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForPageLoading;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.utils.Utils;

public class UserProfilePage extends GenericPage {

  private static final String PROFILE_CONTACT_INFORMATION_FORM_INPUTS = "(//*[contains(@class, 'profileContactInformationDrawer') and contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'drawerContent')]//input)";

  public UserProfilePage(WebDriver driver) {
    super(driver);
  }

  public void addWorkExperiences(String organization, String jobTitle, String jobDetails, String usedSkills) {
    // Add work experience
    ElementFacade addWorkExperiencesElement = addWorkExperiencesElement();
    addWorkExperiencesElement.click();
    waitForDrawerToOpen(".profileWorkExperiencesDrawer.v-navigation-drawer--open", true);
    if (!addWorkExperiencesElement.isCurrentlyVisible()) {
      closeWorkExperiencesDrawerBtnElement().click();
      editWorkExperiencesElement().click();
    }
    elementWorkExperiencesOrganizationElement().setTextValue(organization);
    elementWorkExperiencesJobTitleElement().setTextValue(jobTitle);
    elementWorkExperiencesJobDetailsElement().setTextValue(jobDetails);
    elementWorkExperiencesUsedSkillsElement().setTextValue(usedSkills);

    elementWorkExperiencesStartDateElement().click();
    elementWorkExperiencesStartDateGoToPreviousMonthElement().click();
    waitFor(200).milliseconds(); // Wait until animation finishes
    ElementFacade elementWorkExperiencesStartDateFirstMonthDay =
                                                               findByXPathOrCSS("(//*[contains(@class, 'profileWorkExperiencesDates')]//*[contains(@class, 'datePickerComponent')])[1]//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table')]//td//*[text() = '1']//ancestor::button");
    elementWorkExperiencesStartDateFirstMonthDay.click();
    waitFor(200).milliseconds(); // Wait until animation finishes

    elementWorkExperiencesEndDateElement().click();
    elementWorkExperiencesEndDateTodayElement().click();

    saveWorkExperiencesElement().click();
    waitForDrawerToClose(".profileWorkExperiencesDrawer.v-navigation-drawer--open", true);
  }

  public void checkAvatarVisible() {
    // Check That User Avatar is displayed in Profile Page
    profileAvatarElement().assertVisible();
  }

  public void checkCoverVisible() {
    // Check That User Cover is displayed in Profile Page
    profileCoverElement().assertVisible();
  }

  public void checkGainedCaurisVisible() {
    contactWalletOverviewRewardElement().assertVisible();
  }

  public void checkProfileAvatarUploaded() {
    uploadedProfileAvatarWidthElement().waitUntilVisible();
    Assert.assertEquals(uploadedProfileAvatarElement().getAttribute("style"), "width: 860px;");
  }

  public void checkProfileContactCompanyVisible(String company) {
    // Check That Profile Contact Company is displayed
    profileContactInformationCompanyElement(company).waitUntilVisible();
  }

  public void checkProfileContactEmailVisible(String mail) {
    profileContactInformationEmailElement(mail).assertVisible();
  }

  public void checkProfileContactFullNameVisible(String title, String fullName) {
    // Check That Profile Contact Fullname is displayed
    profileContactInformationTitleElement(title).assertVisible();
    profileContactInformationFullnameElement(fullName).assertVisible();
  }

  public void checkProfileContactInstantMessagingVisible(String instantMessagingType, String instantMessaging) {
    // Check That Profile Contact Instant Messaging is displayed
    profileContactInformationIMElement(instantMessagingType, instantMessaging).assertVisible();
  }

  public void checkProfileContactJobTitleVisible(String job) {
    profileJobElement(job).assertVisible();
  }

  public void checkProfileContactPhoneVisible(String phoneType, String phone) {
    profileContactInformationPhoneElement(phoneType, phone).assertVisible();
  }

  public void checkProfileContactUrlVisible(String profileUrl) {
    // Check That Profile Contact Url is displayed
    profileContactInformationURLElement(profileUrl).assertVisible();
  }

  public void checkWorkExperiencesSection(String jobTitle, String organization, String jobDetails, String usedSkills) {
    getJobDetailElement(jobTitle).assertVisible();
    getJobDetailElement(organization).assertVisible();
    getJobDetailElement(jobDetails).assertVisible();
    getJobDetailElement(usedSkills).assertVisible();
  }

  public void clickOnSendKudosBtn() {
    ElementFacade uiIconKudosElement = uiIconKudosElement();
    uiIconKudosElement.assertVisible();
    uiIconKudosElement.click();
    waitForDrawerToOpen();
    waitCKEditorLoading();
  }

  public int getMyWeeklyPoint() {
    if (myWeeklyPointElement().isVisible()) {
      return Integer.valueOf(myWeeklyPointElement().getText());
    } else {
      return 0;
    }
  }

  public void goToReceivedKudos() {
    contactReceivedKudosElement().click();
  }

  public void goToSentKudos() {
    refreshPage();
    contactSentKudosElement().click();
  }

  public void howToEarnPointsPageIsDisplayed() {
    howToEarnPointsPageElement().assertVisible();
  }

  public void receivedKudosSectionIsDisplayed(String kudosNumber) {
    getReceivedKudosNumber(kudosNumber).assertVisible();
  }
  
  public void checkNoSentKudos() {
    ElementFacade sentKudosNumber = getSentKudosNumber();
    if (sentKudosNumber.isCurrentlyVisible()) {
      String text = sentKudosNumber.getText();
      int count = Integer.parseInt(text.trim());
      assertThat(count).isZero().as("Sent Kudos seems to be greated than 0: " + count);
    }
  }

  public void checkNoReceivedKudos() {
    ElementFacade receivedKudosNumber = getReceivedKudosNumber();
    if (receivedKudosNumber.isCurrentlyVisible()) {
      String text = receivedKudosNumber.getText();
      int count = Integer.parseInt(text.trim());
      assertThat(count).isZero().as("Received Kudos seems to be greated than 0: " + count);
    }
  }

  public void receivedKudosUsersSectionIsDisplayed(String user) {
    getReceivedKudosUsers(user).assertVisible();
  }

  public void removeWorkExperience(String jobTitle) {
    // Remove Work Experience
    editWorkExperiencesElement().click();
    openWorkExperience(jobTitle).click();
    removeWorkExperienceElement(jobTitle).click();
    JavascriptExecutor executor = (JavascriptExecutor) getDriver();
    executor.executeScript("arguments[0].click();", saveWorkExperiencesElement());
    saveWorkExperiencesElement().waitUntilNotVisible();
  }

  public void selectInstantMessagingType(String instantMessagingType) {
    switch (instantMessagingType) {
    case "SKYPE":
      // Select SKYPE option
      contactIMTypeSelectButtonElement().selectByValue("skype");
      break;
    case "MSN":
      // Select MSN option
      contactIMTypeSelectButtonElement().selectByValue("msn");
      break;
    case "GITHUB":
      // Select GITHUB option
      contactIMTypeSelectButtonElement().selectByValue("github");
      break;
    case "FACEBOOK":
      // Select FACEBOOK option
      contactIMTypeSelectButtonElement().selectByValue("facebook");
      break;
    case "OTHER":
      // Select OTHER option
      contactIMTypeSelectButtonElement().selectByValue("other");
      break;

    default:
      // No option in the list.Please select correct option.
      break;
    }
  }

  public void selectPhoneType(String phoneType) {
    switch (phoneType) {
    case "WORK":
      // Select WORK option
      contactPhoneTypeSelectButtonElement().selectByValue("work");
      break;
    case "HOME":
      // Select HOME option
      contactPhoneTypeSelectButtonElement().selectByValue("home");
      break;
    case "OTHER":
      // Select OTHER option
      contactPhoneTypeSelectButtonElement().selectByValue("other");
      break;

    default:
      // No option in the list.Please select correct option.
      break;
    }
  }

  public void sentKudosSectionIsDisplayed(String kudosNumber) {
    getSentKudosNumber(kudosNumber).assertVisible();
  }

  public void sentKudosUsersSectionIsDisplayed(String user) {
    getSentKudosUsers(user).assertVisible();
  }

  public void updateBasicInformation(String firstName, String lastName, String email, String job) {
    // Update basic information

    contactInformationButtonElement().click();
    waitForDrawerToOpen();

    if (StringUtils.isNotBlank(firstName)) {
      // update firstname
      ElementFacade contactFirstNameButtonElement = contactFirstNameButtonElement();
      $(contactFirstNameButtonElement).clear();
      $(contactFirstNameButtonElement).sendKeys(firstName);
    }
    if (StringUtils.isNotBlank(lastName)) {
      // update lastName
      ElementFacade contactLastNameButtonElement = contactLastNameButtonElement();
      $(contactLastNameButtonElement).clear();
      $(contactLastNameButtonElement).sendKeys(lastName);
    }
    if (StringUtils.isNotBlank(email)) {
      // update email
      ElementFacade contactEmailButtonElement = contactEmailButtonElement();
      $(contactEmailButtonElement).clear();
      $(contactEmailButtonElement).sendKeys(email);
    }
    if (StringUtils.isNotBlank(job)) {
      // update job
      ElementFacade contactJobTitleButtonElement = contactJobTitleButtonElement();
      $(contactJobTitleButtonElement).clear();
      $(contactJobTitleButtonElement).sendKeys(job);
    }
    contactEditSaveButtonElement().click();
    waitForDrawerToClose();
  }

  public void updateContactOtherInformations(String company,
                                             String phoneType,
                                             String phone,
                                             String instantMessagingType,
                                             String instantMessaging,
                                             String url) {
    // Update other informations

    ElementFacade contactInformationButtonElement = contactInformationButtonElement();
    contactInformationButtonElement.click();

    if (StringUtils.isNotBlank(company)) {
      // update company
      ElementFacade contactCompanyTitleEditButtonElement = contactCompanyTitleEditButtonElement();
      contactCompanyTitleEditButtonElement.clear();
      contactCompanyTitleEditButtonElement.sendKeys(company);
    }

    if (StringUtils.isNotBlank(phone)) {
      // update phone
      // Select Phone Type
      selectPhoneType(phoneType);
      // Enter Phone Number
      ElementFacade contactPhoneTitleButtonElement = contactPhoneTitleButtonElement();
      contactPhoneTitleButtonElement.clear();
      contactPhoneTitleButtonElement.sendKeys(phone);
    }
    if (StringUtils.isNotBlank(instantMessaging)) {
      // update instantMessaging
      // Select instantMessaging Type
      selectInstantMessagingType(instantMessagingType);
      // Enter instantMessaging information
      ElementFacade contactIMTitleButtonElement = contactIMTitleButtonElement();
      contactIMTitleButtonElement.clear();
      contactIMTitleButtonElement.sendKeys(instantMessaging);
    }
    if (StringUtils.isNotBlank(url)) {
      // update url
      ElementFacade contactUrlTitleButtonElement = contactUrlTitleButtonElement();
      contactUrlTitleButtonElement.clear();
      contactUrlTitleButtonElement.sendKeys(url);
    }

    contactEditSaveButtonElement().click();
  }

  public void uploadProfileAvatar(String fileName) {
    Actions builder = new Actions(getDriver());
    builder.moveToElement(profileAvatarElement()).build().perform();
    uploadProfileAvatarBtnElement().waitUntilVisible();
    WebElement elem =
                    getDriver().findElement(org.openqa.selenium.By.xpath("//*[contains(@class,'changeAvatarButton')]//*[@class='v-input__prepend-outer']//button/following::input[1]"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(elem);
  }

  public void checkMyPointIncrease(int originalWeeklyPoint) {
    waitForPageLoading();
    retryOnCondition(() -> {
      int myWeeklyPoint = getMyWeeklyPoint();
      if (myWeeklyPoint <= originalWeeklyPoint) {
        throw new IllegalStateException(String.format("Weekly points %s wasn't increased, original points = %s",
                                                      myWeeklyPoint,
                                                      originalWeeklyPoint));
      }
    }, () -> {
      waitFor(2).seconds();
      Utils.refreshPage(true);
    }, 10);
  }

  private ElementFacade addWorkExperiencesElement() {
    return findByXPathOrCSS("//*[@id='ProfileWorkExperience']//*[contains(@class,' fa-plus')]");
  }

  private ElementFacade closeWorkExperiencesDrawerBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'drawerParent profileWorkExperiencesDrawer')]//*[contains(@class,'mdi mdi-close')]");
  }

  private ElementFacade contactCompanyTitleEditButtonElement() {
    return findByXPathOrCSS("(//*[@class='v-card__text d-flex positionField py-0']//input)[2]");
  }

  private ElementFacade contactEditSaveButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'btn-primary')]");
  }

  private ElementFacade contactFirstNameButtonElement() {
    return findByXPathOrCSS(PROFILE_CONTACT_INFORMATION_FORM_INPUTS + "[1]");
  }

  private ElementFacade contactLastNameButtonElement() {
    return findByXPathOrCSS(PROFILE_CONTACT_INFORMATION_FORM_INPUTS + "[2]");
  }

  private ElementFacade contactEmailButtonElement() {
    return findByXPathOrCSS(PROFILE_CONTACT_INFORMATION_FORM_INPUTS + "[3]");
  }

  private ElementFacade contactJobTitleButtonElement() {
    return findByXPathOrCSS(PROFILE_CONTACT_INFORMATION_FORM_INPUTS + "[4]");
  }

  private ElementFacade contactIMTitleButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__text d-flex positionField py-0'][8]/following::input[2]");
  }

  private ElementFacade contactIMTypeSelectButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__text d-flex positionField py-0'][8]/following::select[2]");
  }

  private ElementFacade contactInformationButtonElement() {
    return findByXPathOrCSS("//*[@id='profileContactEditButton']");
  }

  private ElementFacade contactPhoneTitleButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__text d-flex positionField py-0'][8]/following::input[1]");
  }

  private ElementFacade contactPhoneTypeSelectButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__text d-flex positionField py-0'][8]/following::select[1]");
  }

  private ElementFacade contactReceivedKudosElement() {
    return findByXPathOrCSS("//*[@id='kudosOverviewCardsParent']//*[contains(@class, 'kudosOverviewCard')][1]//*[contains(@class, 'kudosOverviewCount')]");
  }

  private ElementFacade contactSentKudosElement() {
    return findByXPathOrCSS("//*[@id='kudosOverviewCardsParent']//*[contains(@class, 'kudosOverviewCard')][2]//*[contains(@class, 'kudosOverviewCount')]");
  }

  private ElementFacade contactUrlTitleButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__text d-flex positionField py-0'][8]/following::input[3]");
  }

  private ElementFacade contactWalletOverviewRewardElement() {
    return findByXPathOrCSS("(//*[@id='WalletOverview']//div)[8]");
  }

  private ElementFacade editWorkExperiencesElement() {
    return findByXPathOrCSS("//*[@id='ProfileWorkExperience']//*[contains(@class,'fa-edit')]");
  }

  private TextBoxElementFacade elementWorkExperiencesEndDateElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@id,'DatePicker')])[2]//input");
  }

  private TextBoxElementFacade elementWorkExperiencesEndDateTodayElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@class, 'profileWorkExperiencesDates')]//*[contains(@class, 'datePickerComponent')])[2]//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table__current')]");
  }

  private TextBoxElementFacade elementWorkExperiencesJobDetailsElement() {
    return findTextBoxByXPathOrCSS("//*[@class='v-expansion-panel-content']//textarea");
  }

  private TextBoxElementFacade elementWorkExperiencesJobTitleElement() {
    return findTextBoxByXPathOrCSS("(//*[@class='v-expansion-panel-content']//input)[2]");
  }

  private TextBoxElementFacade elementWorkExperiencesOrganizationElement() {
    return findTextBoxByXPathOrCSS("(//*[@class='v-expansion-panel-content']//input)[1]");
  }

  private TextBoxElementFacade elementWorkExperiencesStartDateElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@id,'DatePicker')])[1]//input");
  }

  private TextBoxElementFacade elementWorkExperiencesStartDateGoToPreviousMonthElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@class, 'profileWorkExperiencesDates')]//*[contains(@class, 'datePickerComponent')])[1]//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-header')]//button[1]");
  }

  private TextBoxElementFacade elementWorkExperiencesUsedSkillsElement() {
    return findTextBoxByXPathOrCSS("(//*[@class='v-expansion-panel-content']//input)[3]");
  }

  private ElementFacade getJobDetailElement(String jobDetails) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-timeline-item')]//*[contains (text(),'%s')]",
                                          jobDetails));
  }

  private ElementFacade getReceivedKudosNumber() {
    return findByXPathOrCSS("//*[@id='kudosOverviewCardsParent']//*[contains(@class,'kudosReceivedOverviewPeriod')]//*[contains(@class,'kudosOverviewCount')]");
  }

  private ElementFacade getReceivedKudosNumber(String kudosNumber) {
    return findByXPathOrCSS(String.format("//*[@id='kudosOverviewCardsParent']//*[contains(@class,'kudosReceivedOverviewPeriod')]//*[contains(@class,'kudosOverviewCount') and contains(text(),'%s')]",
                                          kudosNumber));
  }

  private ElementFacade getReceivedKudosUsers(String user) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'kudosOverviewDrawer')]//*[contains(text(),'%s')]",
                                          user));
  }

  private ElementFacade getSentKudosNumber() {
    return findByXPathOrCSS("//*[@id='kudosOverviewCardsParent']//*[contains(@class,'kudosSentOverviewPeriod')]//*[contains(@class,'kudosOverviewCount')]");
  }

  private ElementFacade getSentKudosNumber(String kudosNumber) {
    return findByXPathOrCSS(String.format("//*[@id='kudosOverviewCardsParent']//*[contains(@class,'kudosSentOverviewPeriod')]//*[contains(@class,'kudosOverviewCount') and contains(text(),'%s')]",
                                          kudosNumber));
  }

  private ElementFacade getSentKudosUsers(String user) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'kudosOverviewDrawer')]//*[contains(text(),'%s')]",
                                          user));
  }

  private ElementFacade howToEarnPointsPageElement() {
    return findByXPathOrCSS("//*[@id='GamificationEarnPoints']//*[@id='uiHowEarnPoint']//*[contains(text(),'How can I earn points?')]");
  }

  private ElementFacade myWeeklyPointElement() {
    return findByXPathOrCSS("//div[@id='profile-stats-portlet']//span[contains(text(),'points') or contains(text(),'Points')]//preceding::span[1]");
  }

  private ElementFacade openWorkExperience(String jobTitle) {
    return findByXPathOrCSS(String.format("//button//*[@class='truncate-text']//*[contains(text(),'%s')]", jobTitle));
  }

  private ElementFacade profileAvatarElement() {
    return findByXPathOrCSS("//*[@id='profileAvatar']");
  }

  private ElementFacade profileContactInformationTitleElement(String title) {
    return findByXPathOrCSS("//*[@id='ProfileContactInformation']/parent::*//*[contains(text(), '" + title + "')]");
  }

  private ElementFacade profileContactInformationCompanyElement(String company) {
    return profileContactInformationElement("company", company);
  }

  private ElementFacade profileContactInformationEmailElement(String email) {
    return profileContactInformationElement("email", email);
  }

  private ElementFacade profileContactInformationFullnameElement(String fullName) {
    return profileContactInformationElement("fullName", fullName);
  }

  private ElementFacade profileContactInformationIMElement(String instantMessagingType, String instantMessaging) {
    return profileContactInformationElement("ims", instantMessagingType, instantMessaging);
  }

  private ElementFacade profileContactInformationPhoneElement(String phoneType, String phone) {
    return profileContactInformationElement("phones", phoneType, phone);
  }

  private ElementFacade profileContactInformationURLElement(String profileUrl) {
    return profileContactInformationElement("urls", profileUrl);
  }

  private ElementFacade profileJobElement(String jobTitle) {
    return profileContactInformationElement("position", jobTitle);
  }

  private ElementFacade profileContactInformationElement(String name, String value) {
    return findByXPathOrCSS(String.format("//*[@id='profileContactInformation-%s']/parent::*//*[contains(text(), '%s')]",
                                          name,
                                          value));
  }

  private ElementFacade profileContactInformationElement(String name, String multiFieldName, String multiFieldValue) {
    return findByXPathOrCSS(String.format("//*[@id='profileContactInformation-%s']/parent::*//*[contains(text(), '%s')]/parent::*//*[contains(text(), '%s')]",
                                          name,
                                          multiFieldValue,
                                          multiFieldName));
  }

  private ElementFacade profileCoverElement() {
    return findByXPathOrCSS("(//*[@id='ProfileHeader']//*[@class='v-image__image v-image__image--cover'])[1]");
  }

  private WebElement removeWorkExperienceElement(String jobTitle) {
    return findButtonByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'profileWorkExperiencesEditItem')]//*[contains(@class,'uiIconTrash')]//ancestor::button",
                                                jobTitle));
  }

  private ElementFacade saveWorkExperiencesElement() {
    return findByXPathOrCSS("//*[contains(@class,'drawerFooter')]//button[contains(@class,'btn-primary')]");
  }

  private ElementFacade uiIconKudosElement() {
    return findByXPathOrCSS("//*[contains(@class,'profileHeaderOtherActions')]//button//i[contains(@class,'uiIconKudos')]");
  }

  private ElementFacade uploadedProfileAvatarElement() {
    return findByXPathOrCSS("//*[@class='v-image v-responsive theme--light']//*[@class='v-responsive__content']");
  }

  private ElementFacade uploadedProfileAvatarWidthElement() {
    return findByXPathOrCSS("//*[@class='v-image v-responsive theme--light']//*[@class='v-responsive__content' and @style='width: 860px;']");
  }

  private ElementFacade uploadProfileAvatarBtnElement() {
    return findByXPathOrCSS("(//*[contains(@class,'v-input__icon--prepend')]//button)[1]");
  }

}
