package io.meeds.qa.ui.pages.page.factory.people;

import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

public class UserProfilePage extends GenericPage {

  public UserProfilePage(WebDriver driver) {
    super(driver);
  }

  public void addWorkExperiences(String organization, String jobTitle, String jobDetails, String usedSkills) {
    // Add work experience
    ElementFacade addWorkExperiencesElement = addWorkExperiencesElement();
    addWorkExperiencesElement.clickOnElement();
    waitForDrawerToOpen(".profileWorkExperiencesDrawer.v-navigation-drawer--open", true);
    if (!addWorkExperiencesElement.isCurrentlyVisible()) {
      closeWorkExperiencesDrawerBtnElement().clickOnElement();
      editWorkExperiencesElement().clickOnElement();
    }
    elementWorkExperiencesOrganizationElement().setTextValue(organization);
    elementWorkExperiencesJobTitleElement().setTextValue(jobTitle);
    elementWorkExperiencesJobDetailsElement().setTextValue(jobDetails);
    elementWorkExperiencesUsedSkillsElement().setTextValue(usedSkills);

    elementWorkExperiencesStartDateElement().clickOnElement();
    elementWorkExperiencesStartDateGoToPreviousMonthElement().clickOnElement();
    waitFor(200).milliseconds(); // Wait until animation finishes
    ElementFacade elementWorkExperiencesStartDateFirstMonthDay =
                                                               findByXPathOrCSS("(//*[contains(@class, 'profileWorkExperiencesDates')]//*[contains(@class, 'datePickerComponent')])[1]//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table')]//td//*[text() = '1']//ancestor::button");
    elementWorkExperiencesStartDateFirstMonthDay.clickOnElement();
    waitFor(200).milliseconds(); // Wait until animation finishes

    elementWorkExperiencesEndDateElement().clickOnElement();
    elementWorkExperiencesEndDateTodayElement().clickOnElement();

    saveWorkExperiencesElement().clickOnElement();
    waitForDrawerToClose(".profileWorkExperiencesDrawer.v-navigation-drawer--open", true);
  }

  public void checkAchievementsDrawer() {
    achievementsDrawerElement().assertVisible();
  }

  public void checkWeeklyPointChart() {
    weeklyChartElement().assertVisible();
  }

  public void checkWorkExperiencesSection(String jobTitle, String organization, String jobDetails, String usedSkills) {
    getJobTitleWorkExperience(jobTitle).assertVisible();
    getOrganizationWorkExperience(organization).assertVisible();
    getJobDetailsWorkExperience(jobDetails).assertVisible();
    getUsedSkillsWorkExperience(usedSkills).assertVisible();
  }

  public void clickConfirmConnect() {
    confirmConnectionElement().clickOnElement();
  }

  public void clickOnSendKudosBtn() {
    uiIconKudosElement().clickOnElement();
    waitForDrawerToOpen();
    waitCKEditorLoading();
  }

  public int getMyWeeklyPoint() {
    return Integer.valueOf(myWeeklyPointElement().getText());
  }

  public void goToReceivedKudos() {
    contactReceivedKudosElement().clickOnElement();
  }

  public void goToSentKudos() {
    refreshPage();
    contactSentKudosElement().clickOnElement();
  }

  public void howToEarnPointsPageIsDisplayed() {
    howToEarnPointsPageElement().assertVisible();
  }

  public void isAvatarVisible() {
    // Check That User Avatar is displayed in Profile Page
    profileAvatarElement().assertVisible();
  }

  public void isCoverVisible() {
    // Check That User Cover is displayed in Profile Page
    profileCoverElement().assertVisible();
  }

  public boolean isFieldVisible(String fieldName) {
    switch (fieldName) {
    case "Weekly points":
      return getUserStatElement("Points").isVisibleAfterWaiting();
    case "Weekly rank":
      return getUserStatElement("Rank").isVisibleAfterWaiting();
    case "Achievements":
      return achievementsDrawerElement().isVisibleAfterWaiting();
    case "badge details":
      return badgesDrawerElement().isVisibleAfterWaiting();
    case "Total point achievement":
      return achievementsWeeklyPointInDrawerElement().isVisibleAfterWaiting();
    default:
      return false;
    }
  }

  public void isGainedCaurisVisible() {
    contactWalletOverviewRewardElement().assertVisible();
  }

  public void isProfileAvatarUploaded() {
    uploadedProfileAvatarWidthElement().waitUntilVisible();
    Assert.assertEquals(uploadedProfileAvatarElement().getAttribute("style"), "width: 860px;");
  }

  public void isProfileContactCompanyVisible(String company) {
    // Check That Profile Contact Company is displayed
    profileContactInformationCompanyElement().waitUntilVisible();
    assertEquals(profileContactInformationCompanyElement().getText(), company);
  }

  public void isProfileContactEmailVisible(String mail) {
    profileContactInformationEmailElement().assertVisible();
    // Check That Profile Contact Email is displayed
    Assert.assertEquals(profileContactInformationEmailElement().getText(), mail);
  }

  public void isProfileContactFullNameVisible(String title, String fullName) {
    // Check That Profile Contact Fullname is displayed
    Assert.assertEquals(profileContactInformationTitleElement().getText(), title);
    Assert.assertEquals(profileContactInformationFullnameElement().getText(), fullName);
  }

  public void isProfileContactInstantMessagingVisible(String instantMessaging) {
    // Check That Profile Contact Instant Messaging is displayed
    Assert.assertEquals(profileContactInformationIMElement().getText(), instantMessaging);
  }

  public void isProfileContactPhoneVisible(String phone) {
    assertEquals(profileContactInformationPhoneElement().getText(), phone);
  }

  public void isProfileContactUrlVisible(String profileUrl) {
    // Check That Profile Contact Url is displayed
    assertTrue(profileContactInformationURLElement().getText().contains(profileUrl));
  }

  public void isReceivedKudosVisible() {
    contactReceivedKudosElement().assertVisible();
  }

  public void isSentKudosVisible() {
    contactSentKudosElement().assertVisible();
  }

  public void isUserJobVisible(String job) {
    Assert.assertEquals(profileJobElement().getText(), job);
  }

  public void openAchivementTab() {
    getUserStatElement("Points").clickOnElement();
    waitFor(2).seconds(); // Wait until card is displayed
    ElementFacade iconProfile = findByXPathOrCSS("#profile-stats-portlet .uiIconInformation");
    clickOnElement(iconProfile);
  }

  public void openBadgeDetails() {
    closeAchievementsDrawerButtonElement().clickOnElement();
    badgePortletElement().clickOnElement();
  }

  public void openHowToEarnPointPage() {
    waitFor(2).seconds(); // Wait until drawer is displayed
    ElementFacade achievementIconInfo = findByXPathOrCSS(".achievementsDrawer .drawerHeader .uiIconInformation");
    clickOnElement(achievementIconInfo);
  }

  public void openWeeklyPointsChart() {
    getUserStatElement("Points").clickOnElement();
  }

  public void profilePageIsDisplayed() {
    profilePageElement().assertVisible();
  }

  public void receivedKudosSectionIsDisplayed(String kudosNumber) {
    getReceivedKudosNumber(kudosNumber).assertVisible();
  }

  public void receivedKudosUsersSectionIsDisplayed(String user) {
    getReceivedKudosUsers(user).assertVisible();
  }

  public void removeWorkExperience(String jobTitle) {
    // Remove Work Experience
    editWorkExperiencesElement().clickOnElement();
    openWorkExperience(jobTitle).clickOnElement();
    removeWorkExperienceElement().clickOnElement();
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

    contactInformationButtonElement().clickOnElement();

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
    contactEditSaveButtonElement().clickOnElement();
  }

  public void updateContactOtherInformations(String company,
                                             String phoneType,
                                             String phone,
                                             String instantMessagingType,
                                             String instantMessaging,
                                             String url) {
    // Update other informations

    ElementFacade contactInformationButtonElement = contactInformationButtonElement();
    contactInformationButtonElement.clickOnElement();

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

    contactEditSaveButtonElement().clickOnElement();
  }

  public void updateWorkExperiences(String organization, String jobTitle, String jobDetails, String usedSkills) {
    // Add work experience
    ElementFacade editWorkExperiencesElement = editWorkExperiencesElement();
    editWorkExperiencesElement.clickOnElement();
    waitForDrawerToOpen(".profileWorkExperiencesDrawer.v-navigation-drawer--open", true);
    ElementFacade addWorkExperiencesElement = addWorkExperiencesElement();
    if (!addWorkExperiencesElement.isCurrentlyVisible()) {
      closeWorkExperiencesDrawerBtnElement().clickOnElement();
      editWorkExperiencesElement.clickOnElement();
    }
    addWorkExperiencesElement.clickOnElement();
    elementWorkExperiencesOrganizationElement().setTextValue(organization);
    elementWorkExperiencesJobTitleElement().setTextValue(jobTitle);
    elementWorkExperiencesJobDetailsElement().setTextValue(jobDetails);
    elementWorkExperiencesUsedSkillsElement().setTextValue(usedSkills);

    elementWorkExperiencesStartDateElement().clickOnElement();
    elementWorkExperiencesStartDateGoToPreviousMonthElement().clickOnElement();
    waitFor(200).milliseconds(); // Wait until animation finishes
    ElementFacade elementWorkExperiencesStartDateFirstMonthDay =
                                                               findByXPathOrCSS("(//*[contains(@class, 'profileWorkExperiencesDates')]//*[contains(@class, 'datePickerComponent')])[1]//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table')]//td//*[text() = '1']//ancestor::button");
    elementWorkExperiencesStartDateFirstMonthDay.clickOnElement();
    waitFor(200).milliseconds(); // Wait until animation finishes

    elementWorkExperiencesEndDateElement().clickOnElement();
    elementWorkExperiencesEndDateTodayElement().clickOnElement();

    saveWorkExperiencesElement().clickOnElement();
    waitForDrawerToClose(".profileWorkExperiencesDrawer.v-navigation-drawer--open", true);
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

  private ElementFacade achievementsDrawerElement() {
    return findByXPathOrCSS("//aside[contains(@class,'achievementsDrawer')]");
  }

  private ElementFacade achievementsWeeklyPointInDrawerElement() {
    return findByXPathOrCSS("//aside[contains(@class,'achievementsDrawer')]//div[contains(text(),'Points')]");
  }

  private ElementFacade addWorkExperiencesElement() {
    return findByXPathOrCSS("//*[@id='ProfileWorkExperience']//*[contains(@class,' fa-plus')]");
  }

  private ElementFacade badgePortletElement() {
    return findByXPathOrCSS("//div[@id='badgesOverview']//div[contains(@class,'BadgeItemAvatar')]");
  }

  private ElementFacade badgesDrawerElement() {
    return findByXPathOrCSS("//aside[contains(@class,'badgesDrawer')]");
  }

  private ElementFacade closeAchievementsDrawerButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'achievementsDrawer')]//button[contains(@class,'mdi-close')]");
  }

  private ElementFacade closeWorkExperiencesDrawerBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'drawerParent profileWorkExperiencesDrawer')]//*[contains(@class,'mdi mdi-close')]");
  }

  private ElementFacade confirmConnectionElement() {
    return findByXPathOrCSS("//button[contains(@class,'acceptToConnectButton')]");
  }

  private ElementFacade contactCompanyTitleEditButtonElement() {
    return findByXPathOrCSS("(//*[@class='v-card__text d-flex positionField py-0']//input)[2]");
  }

  private ElementFacade contactEditSaveButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'btn-primary')]");
  }

  private ElementFacade contactEmailButtonElement() {
    return findByXPathOrCSS("(//*[@class='v-card__text d-flex emailField py-0']//input)[1]");
  }

  private ElementFacade contactFirstNameButtonElement() {
    return findByXPathOrCSS("(//*[@class='v-card__text d-flex fullnameFields py-0']//input)[1]");
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

  private ElementFacade contactJobTitleButtonElement() {
    return findByXPathOrCSS("(//*[@class='v-card__text d-flex positionField py-0']//input)[1]");
  }

  private ElementFacade contactLastNameButtonElement() {
    return findByXPathOrCSS("(//*[@class='v-card__text d-flex fullnameFields py-0']//input)[2]");
  }

  private ElementFacade contactPhoneTitleButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__text d-flex positionField py-0'][8]/following::input[1]");
  }

  private ElementFacade contactPhoneTypeSelectButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__text d-flex positionField py-0'][8]/following::select[1]");
  }

  private ElementFacade contactReceivedKudosElement() {
    return findByXPathOrCSS("//*[@id='kudosOverviewCardsParent']//*[@class='kudosOverviewCard col'][1]//*[contains(@class, 'kudosOverviewCount')]");
  }

  private ElementFacade contactSentKudosElement() {
    return findByXPathOrCSS("//*[@id='kudosOverviewCardsParent']//*[@class='kudosOverviewCard col'][2]//*[contains(@class, 'kudosOverviewCount')]");
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

  private ElementFacade getJobDetailsWorkExperience(String jobDetails) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-timeline-item')]//*[contains (text(),'%s')]", jobDetails));
  }

  private ElementFacade getJobTitleWorkExperience(String jobTitle) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-timeline-item')]//*[contains (text(),'%s')]",
                                          jobTitle));
  }

  private ElementFacade getOrganizationWorkExperience(String organization) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-timeline-item')]//*[contains (text(),'%s')]",
                                          organization));
  }

  private ElementFacade getReceivedKudosNumber(String kudosNumber) {
    return findByXPathOrCSS(String.format("//*[@id='kudosOverviewCardsParent']//*[contains(@class,'kudosReceivedOverviewPeriod')]//*[contains(@class,'kudosOverviewCount') and contains(text(),'%s')]",
                                          kudosNumber));
  }

  private ElementFacade getReceivedKudosUsers(String user) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'kudosOverviewDrawer')]//*[contains(@class,'drawerTitle') and contains(text(),'Kudos Received')]/following::*[contains(@id,'avatar') and contains(text(),'%s')]",
                                          user));
  }

  private ElementFacade getSentKudosNumber(String kudosNumber) {
    return findByXPathOrCSS(String.format("//*[@id='kudosOverviewCardsParent']//*[contains(@class,'kudosSentOverviewPeriod')]//*[contains(@class,'kudosOverviewCount') and contains(text(),'%s')]",
                                          kudosNumber));
  }

  private ElementFacade getSentKudosUsers(String user) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'kudosOverviewDrawer')]//*[contains(@class,'drawerTitle') and contains(text(),'Kudos Sent')]/following::*[contains(@id,'avatar') and contains(text(),'%s')]",
                                          user));
  }

  private ElementFacade getUsedSkillsWorkExperience(String usedSkill) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-timeline-item')]//*[contains (text(),'%s')]",
                                          usedSkill));
  }

  private ElementFacade getUserStatElement(String statType) {
    return findByXPathOrCSS(String.format("//div[@id='profile-stats-portlet']//span[contains(text(),'%s')]", statType));
  }

  private ElementFacade howToEarnPointsPageElement() {
    return findByXPathOrCSS("//*[@id='GamificationEarnPoints']//*[@id='uiHowEarnPoint']//*[contains(text(),'How can I earn points?')]");
  }

  private ElementFacade myWeeklyPointElement() {
    return findByXPathOrCSS("//div[@id='profile-stats-portlet']//span[contains(text(),'Points')]//preceding::span[1]");
  }

  private ElementFacade openWorkExperience(String jobTitle) {
    return findByXPathOrCSS(String.format("//button//*[@class='truncate-text']//*[contains(text(),'%s')]", jobTitle));
  }

  private ElementFacade profileAvatarElement() {
    return findByXPathOrCSS("//*[@id='profileAvatar']");
  }

  private ElementFacade profileContactInformationCompanyElement() {
    return findByXPathOrCSS("//*[@id='profileContactUserCompany']");
  }

  private ElementFacade profileContactInformationEmailElement() {
    return findByXPathOrCSS("//*[@id='profileContactUserEmail']");
  }

  private ElementFacade profileContactInformationFullnameElement() {
    return findByXPathOrCSS("//*[@id='profileContactUserFullname']");
  }

  private ElementFacade profileContactInformationIMElement() {
    return findByXPathOrCSS("//*[contains(@class,'profileContactIm')]");
  }

  private ElementFacade profileContactInformationPhoneElement() {
    return findByXPathOrCSS("//*[contains(@class,'profileContactPhone')]");
  }

  private ElementFacade profileContactInformationTitleElement() {
    return findByXPathOrCSS("//*[@id='ProfileContactInformation']//*[contains(@class,'profileContactTitle')]");
  }

  private ElementFacade profileContactInformationURLElement() {
    return findByXPathOrCSS("//*[contains(@class,'profileContactUrl')]");
  }

  private ElementFacade profileCoverElement() {
    return findByXPathOrCSS("(//*[@id='ProfileHeader']//*[@class='v-image__image v-image__image--cover'])[1]");
  }

  private ElementFacade profileJobElement() {
    return findByXPathOrCSS("//*[@id='profileHeaderUserPosition']");
  }

  private ElementFacade profilePageElement() {
    return findByXPathOrCSS("//*[@id='ProfileHeader']");
  }

  private ElementFacade removeWorkExperienceElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiIconTrash')]");
  }

  private ElementFacade saveWorkExperiencesElement() {
    return findByXPathOrCSS("//*[contains(@class,'drawerFooter')]//button[contains(@class,'btn-primary')]");
  }

  private ElementFacade uiIconKudosElement() {
    return findByXPathOrCSS("//i[contains(@class,'uiIconKudos')]");
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

  private ElementFacade weeklyChartElement() {
    return findByXPathOrCSS("//*[@id='echartUserPoints']");
  }

}
