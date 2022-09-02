package io.meeds.qa.ui.pages.page.factory.people;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class UserProfilePage extends GenericPage {
  @FindBy(xpath = "//aside[contains(@class,'achievementsDrawer')]")
  private BaseElementFacade      achievementsDrawer;

  @FindBy(xpath = "//aside[contains(@class,'achievementsDrawer')]//div[contains(text(),'Points')]")
  private BaseElementFacade      achievementsWeeklyPointInDrawer;

  @FindBy(xpath = "//*[@id='ProfileWorkExperience']//button[@class='v-icon notranslate my-auto v-icon--link mdi mdi-plus theme--light']")
  public BaseElementFacade       addWorkExperiences;

  @FindBy(xpath = "//div[@id='badgesOverview']//div[contains(@class,'BadgeItemAvatar')]")
  private BaseElementFacade      badgePortlet;

  @FindBy(xpath = "//aside[contains(@class,'badgesDrawer')]")
  private BaseElementFacade      badgesDrawer;

  @FindBy(xpath = "//*[contains(@class,'achievementsDrawer')]//button[contains(@class,'mdi-close')]")
  private BaseElementFacade      closeAchievementsDrawerButton;

  @FindBy(xpath = "//*[contains(@class,'drawerParent profileWorkExperiencesDrawer')]//*[contains(@class,'mdi mdi-close')]")
  public BaseElementFacade       closeWorkExperiencesDrawerBtn;

  @FindBy(xpath = "//button[contains(@class,'acceptToConnectButton')]")
  private BaseElementFacade      confirmConnection;

  @FindBy(xpath = "//*[@id='ProfileWorkExperience']//button[contains(@class,'v-btn--outlined')]//span//i")
  public BaseElementFacade       editWorkExperiences;

  @FindBy(xpath = "(//*[@class='v-card__text d-flex positionField py-0']//input)[2]")
  private BaseElementFacade      ELEMENT_CONTACT_COMPANY_TITLE_EDIT_BTN;

  @FindBy(xpath = "(//*[@class='layout column']//*[@class='d-flex']//button)[5]")
  private BaseElementFacade      ELEMENT_CONTACT_EDIT_SAVE_BTN;

  @FindBy(xpath = "(//*[@class='v-card__text d-flex emailField py-0']//input)[1]")
  private BaseElementFacade      ELEMENT_CONTACT_EMAIL_EDIT_BTN;

  @FindBy(xpath = "(//*[@class='v-card__text d-flex fullnameFields py-0']//input)[1]")
  private BaseElementFacade      ELEMENT_CONTACT_FIRST_NAME_EDIT_BTN;

  @FindBy(xpath = "(//*[@id='WalletOverview']//div)[8]")
  private BaseElementFacade      ELEMENT_CONTACT_GAINED_CAURIS;

  @FindBy(xpath = "//*[@id='ProfileContactInformation']//*[@class='uiIconEdit uiIconLightBlue pb-2']")
  private BaseElementFacade      ELEMENT_CONTACT_INFORMATIONS_EDIT_BTN;

  @FindBy(xpath = "//*[@class='v-card__text d-flex positionField py-0'][8]/following::input[2]")
  private BaseElementFacade      ELEMENT_CONTACT_INSTANT_MESSAGING_TITLE_EDIT_BTN;

  @FindBy(xpath = "//*[@class='v-card__text d-flex positionField py-0'][8]/following::select[2]")
  private BaseElementFacade      ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN;

  @FindBy(xpath = "(//*[@class='v-card__text d-flex positionField py-0']//input)[1]")
  private BaseElementFacade      ELEMENT_CONTACT_JOB_TITLE_EDIT_BTN;

  @FindBy(xpath = "(//*[@class='v-card__text d-flex fullnameFields py-0']//input)[2]")
  private BaseElementFacade      ELEMENT_CONTACT_LAST_NAME_EDIT_BTN;

  @FindBy(xpath = "//*[@class='v-card__text d-flex positionField py-0'][8]/following::input[1]")
  private BaseElementFacade      ELEMENT_CONTACT_PHONE_TITLE_EDIT_BTN;

  @FindBy(xpath = "//*[@class='v-card__text d-flex positionField py-0'][8]/following::select[1]")
  private BaseElementFacade      ELEMENT_CONTACT_PHONE_TYPE_SELECT_EDIT_BTN;

  @FindBy(xpath = "//*[@id='kudosOverviewCardsParent']//*[@class='kudosOverviewCard col'][1]/div/div[2]")
  private BaseElementFacade      ELEMENT_CONTACT_RECEIVED_KUDOS;

  @FindBy(xpath = "//*[@id='kudosOverviewCardsParent']//*[@class='kudosOverviewCard col'][2]/div/div[2]")
  private BaseElementFacade      ELEMENT_CONTACT_SENT_KUDOS;

  @FindBy(xpath = "//*[@class='v-card__text d-flex positionField py-0'][8]/following::input[3]")
  private BaseElementFacade      ELEMENT_CONTACT_URL_TITLE_EDIT_BTN;

  @FindBy(xpath = "(//*[@id='ProfileHeader']//*[@class='v-image__image v-image__image--cover'])[2]")
  public BaseElementFacade       ELEMENT_PROFILE_AVATAR;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[4]")
  private BaseElementFacade      ELEMENT_PROFILE_CONTACT_INFORMATION_COMPANY;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[2]")
  public BaseElementFacade       ELEMENT_PROFILE_CONTACT_INFORMATION_EMAIL;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[1]")
  public BaseElementFacade       ELEMENT_PROFILE_CONTACT_INFORMATION_FULLNAME;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[6]")
  private BaseElementFacade      ELEMENT_PROFILE_CONTACT_INFORMATION_INSTANT_MESSAGING;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[3]")
  public BaseElementFacade       ELEMENT_PROFILE_CONTACT_INFORMATION_JOBTITLE;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[5]")
  private BaseElementFacade      ELEMENT_PROFILE_CONTACT_INFORMATION_PHONE;

  @FindBy(xpath = "//*[@id='ProfileContactInformation']//*[@class='text-header-title text-sub-title']")
  public BaseElementFacade       ELEMENT_PROFILE_CONTACT_INFORMATION_TITLE;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[7]")
  private BaseElementFacade      ELEMENT_PROFILE_CONTACT_INFORMATION_URL;

  @FindBy(xpath = "(//*[@id='ProfileHeader']//*[@class='v-image__image v-image__image--cover'])[1]")
  public BaseElementFacade       ELEMENT_PROFILE_COVER;

  @FindBy(xpath = "(//*[@class='profileHeader']/div/div/div)[1]")
  public BaseElementFacade       ELEMENT_PROFILE_FULLNAME;

  @FindBy(xpath = "(//*[@class='profileHeader']/div/div/div)[2]")
  public BaseElementFacade       ELEMENT_PROFILE_JOB;

  @FindBy(xpath = "//*[contains(@class,'uiIconTrash')]")
  private BaseElementFacade      ELEMENT_REMOVE_WORK_EXPERIENCE;

  @FindBy(xpath = "//*[@class='v-expansion-panel-content']//textarea")
  private TextBoxElementFacade   elementWorkExperiencesJobDetails;

  @FindBy(xpath = "(//*[@class='v-expansion-panel-content']//input)[2]")
  private TextBoxElementFacade   elementWorkExperiencesJobTitle;

  @FindBy(xpath = "(//*[@class='v-expansion-panel-content']//input)[1]")
  private TextBoxElementFacade   elementWorkExperiencesOrganization;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[1]//input")
  private TextBoxElementFacade   elementWorkExperiencesStartDate;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[2]//input")
  private TextBoxElementFacade   elementWorkExperiencesEndDate;

  @FindBy(xpath = "(//*[contains(@class, 'profileWorkExperiencesDates')]//*[contains(@class, 'datePickerComponent')])[1]//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-header')]//button[1]")
  private TextBoxElementFacade   elementWorkExperiencesStartDateGoToPreviousMonth;

  @FindBy(xpath = "((//*[contains(@class, 'profileWorkExperiencesDates')]//*[contains(@class, 'datePickerComponent')])[1]//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table')]//td)[1]//button")
  private TextBoxElementFacade   elementWorkExperiencesStartDateFirstMonthDay;

  @FindBy(xpath = "(//*[contains(@class, 'profileWorkExperiencesDates')]//*[contains(@class, 'datePickerComponent')])[2]//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-date-picker-table__current')]")
  private TextBoxElementFacade   elementWorkExperiencesEndDateToday;

  @FindBy(xpath = "(//*[@class='v-expansion-panel-content']//input)[3]")
  private TextBoxElementFacade   elementWorkExperiencesUsedSkills;

  @FindBy(xpath = "//*[@id='GamificationEarnPoints']//*[@id='uiHowEarnPoint']//*[contains(text(),'How can I earn points?')]")
  public BaseElementFacade       howToEarnPointsPage;

  @FindBy(id = "kudosMessage")
  private TextBoxElementFacade   kudosMessage;

  Map<String, BaseElementFacade> MAPPING_FIELD_NAME_TO_TEXTELEMENT_XPATH = new HashMap<>() {
                                                                           {
                                                                             put("Weekly points", getUserStat("Points"));
                                                                             put("Weekly rank", getUserStat("Rank"));
                                                                             put("Achievements", achievementsDrawer);
                                                                             put("badge details", badgesDrawer);
                                                                             put("Total point achievement",
                                                                                 achievementsWeeklyPointInDrawer);
                                                                           }
                                                                         };

  @FindBy(xpath = "//div[@id='profile-stats-portlet']//span[contains(text(),'Points')]//preceding::span[1]")
  private BaseElementFacade      myWeeklyPoint;

  @FindBy(xpath = "//*[@id='ProfileHeader']")
  private BaseElementFacade      profilePage;

  @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  public BaseElementFacade       saveWorkExperiences;

  @FindBy(xpath = "//*[contains(@class,'drawerFooter ')]//*[contains(text(),'Send')]")
  private BaseElementFacade      sendKudosButton;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade   sendKudosMessageContent;

  @FindBy(xpath = "//i[contains(@class,'uiIconKudos')]")
  private BaseElementFacade      uiIconKudos;

  @FindBy(xpath = "//*[@class='v-image v-responsive theme--light']//*[@class='v-responsive__content']")
  private BaseElementFacade      uploadedProfileAvatar;

  @FindBy(xpath = "//*[@class='v-image v-responsive theme--light']//*[@class='v-responsive__content' and @style='width: 860px;']")
  private BaseElementFacade      uploadedProfileAvatarWidth;

  @FindBy(xpath = "(//*[contains(@class,'v-input__icon--prepend')]//button)[1]")
  private BaseElementFacade      uploadProfileAvatarBtn;

  @FindBy(xpath = "//*[contains(@class,'changeAvatarButton')]//*[@class='v-input__prepend-outer']//button/following::input[1]")
  private BaseElementFacade      uploadProfileAvatarInput;

  @FindBy(xpath = "//*[@id='echartUserPoints']")
  private BaseElementFacade      weeklyChart;

  public UserProfilePage(WebDriver driver) {
    super(driver);
  }

  public void checkAchievementsDrawer() {
    assertWebElementVisible(achievementsDrawer);
  }

  public void checkWeeklyPointChart() {
    assertWebElementVisible(weeklyChart);
  }

  public void checkWorkExperiencesSection(String jobTitle, String organization, String jobDetails, String usedSkills) {
    assertWebElementVisible(getJobTitleWorkExperience(jobTitle));
    assertWebElementVisible(getOrganizationWorkExperience(organization));
    assertWebElementVisible(getJobDetailsWorkExperience(jobDetails));
    assertWebElementVisible(getUsedSkillsWorkExperience(usedSkills));
  }

  public void clickConfirmConnect() {
    confirmConnection.clickOnElement();
  }

  public void clickOnSendKudosBtn() {
    uiIconKudos.waitUntilVisible();
    uiIconKudos.clickOnElement();
    waitForDrawerToOpen();
    waitCKEditorLoading();
  }

  private BaseElementFacade getJobDetailsWorkExperience(String jobDetails) {
    return findByXPathOrCSS(String.format("//*[@class='v-timeline-item__body']//*[contains(@class,'font-weight-light') and contains(text(),'%s')]",
                                          jobDetails));
  }

  private BaseElementFacade getJobTitleWorkExperience(String jobTitle) {
    return findByXPathOrCSS(String.format("//*[@class='v-timeline-item__body']//*[@class='text-color' and contains(text(),'%s')]",
                                          jobTitle));
  }

  public int getMyWeeklyPoint() {
    return Integer.valueOf(myWeeklyPoint.getText());
  }

  private BaseElementFacade getOrganizationWorkExperience(String organization) {
    return findByXPathOrCSS(String.format("//*[@class='v-timeline-item__body']//*[@class='text-sub-title' and contains(text(),'%s')]",
                                          organization));
  }

  private BaseElementFacade getReceivedKudosNumber(String kudosNumber) {
    return findByXPathOrCSS(String.format("//*[@id='kudosOverviewCardsParent']//*[contains(@class,'kudosReceivedOverviewPeriod')]//*[contains(@class,'kudosOverviewCount') and contains(text(),'%s')]",
                                          kudosNumber));
  }

  private BaseElementFacade getReceivedKudosUsers(String user) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'kudosOverviewDrawer')]//*[contains(@class,'drawerTitle') and contains(text(),'Kudos Received')]/following::*[contains(@id,'avatar') and contains(text(),'%s')]",
                                          user));
  }

  private BaseElementFacade getSentKudosNumber(String kudosNumber) {
    return findByXPathOrCSS(String.format("//*[@id='kudosOverviewCardsParent']//*[contains(@class,'kudosSentOverviewPeriod')]//*[contains(@class,'kudosOverviewCount') and contains(text(),'%s')]",
                                          kudosNumber));
  }

  private BaseElementFacade getSentKudosUsers(String user) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'kudosOverviewDrawer')]//*[contains(@class,'drawerTitle') and contains(text(),'Kudos Sent')]/following::*[contains(@id,'avatar') and contains(text(),'%s')]",
                                          user));
  }

  private BaseElementFacade getUsedSkillsWorkExperience(String UsedSkill) {
    return findByXPathOrCSS(String.format("//*[@class='v-timeline-item__body']//*[contains(@class,'font-weight-bold') and contains(text(),'%s')]",
                                          UsedSkill));
  }

  private BaseElementFacade getUserStat(String statType) {
    return findByXPathOrCSS(String.format("//div[@id='profile-stats-portlet']//span[contains(text(),'%s')]", statType));
  }

  public void goToReceivedKudos() {
    ELEMENT_CONTACT_RECEIVED_KUDOS.clickOnElement();
  }

  public void goToSentKudos() {
    driver.navigate().refresh();
    ELEMENT_CONTACT_SENT_KUDOS.clickOnElement();
  }

  public void howToEarnPointsPageIsDisplayed() {
    assertWebElementVisible(howToEarnPointsPage);
  }

  public void isAvatarVisible() {
    // Check That User Avatar is displayed in Profile Page
    assertWebElementVisible(ELEMENT_PROFILE_AVATAR);
  }

  public void isCoverVisible() {
    // Check That User Cover is displayed in Profile Page
    assertWebElementVisible(ELEMENT_PROFILE_COVER);
  }

  public boolean isFieldVisible(String fieldName) {
    return MAPPING_FIELD_NAME_TO_TEXTELEMENT_XPATH.get(fieldName).isVisibleAfterWaiting();
  }

  public void isGainedCaurisVisible() {
    assertWebElementVisible(ELEMENT_CONTACT_GAINED_CAURIS);
  }

  public void isProfileAvatarUploaded() {
    uploadedProfileAvatarWidth.waitUntilVisible();
    Assert.assertEquals(uploadedProfileAvatar.getAttribute("style"), "width: 860px;");
  }

  public void isProfileContactCompanyVisible(String company) {
    // Check That Profile Contact Company is displayed
    ELEMENT_PROFILE_CONTACT_INFORMATION_COMPANY.waitUntilVisible();
    assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_COMPANY.getText(), company);
  }

  public void isProfileContactEmailVisible(String mail) {
    assertWebElementVisible(ELEMENT_PROFILE_CONTACT_INFORMATION_EMAIL);
    // Check That Profile Contact Email is displayed
    Assert.assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_EMAIL.getText(), mail);
  }

  public void isProfileContactFullNameVisible(String title, String fullName) {
    // Check That Profile Contact Fullname is displayed
    Assert.assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_TITLE.getText(), title);
    Assert.assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_FULLNAME.getText(), fullName);
  }

  public void isProfileContactInstantMessagingVisible(String instantMessaging) {
    // Check That Profile Contact Instant Messaging is displayed
    Assert.assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_INSTANT_MESSAGING.getText(), instantMessaging);
  }

  public void isProfileContactPhoneVisible(String phone) {
    // Check That Profile Contact Phone is displayed" + phone);
    assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_PHONE.getText(), phone);
  }

  public void isProfileContactUrlVisible(String profileUrl) {
    // Check That Profile Contact Url is displayed
    Assert.assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_URL.getText(), profileUrl);
  }

  public void isReceivedKudosVisible() {
    assertWebElementVisible(ELEMENT_CONTACT_RECEIVED_KUDOS);
  }

  public void isSentKudosVisible() {
    assertWebElementVisible(ELEMENT_CONTACT_SENT_KUDOS);
  }

  public void openAchivementTab() {
    getUserStat("Points").clickOnElement();
    waitFor(2).seconds(); // Wait until card is displayed
    BaseElementFacade iconProfile = findByXPathOrCSS("#profile-stats-portlet .uiIconInformation");
    clickOnElement(iconProfile);
  }

  public void openBadgeDetails() {
    closeAchievementsDrawerButton.clickOnElement();
    badgePortlet.clickOnElement();
  }

  public void openHowToEarnPointPage() {
    waitFor(2).seconds(); // Wait until drawer is displayed
    BaseElementFacade achievementIconInfo = findByXPathOrCSS(".achievementsDrawer .drawerHeader .uiIconInformation");
    clickOnElement(achievementIconInfo);
  }

  public void openWeeklyPointsChart() {
    getUserStat("Points").clickOnElement();
  }

  private BaseElementFacade openWorkExperience(String jobTitle) {
    return findByXPathOrCSS(String.format("//button//*[@class='truncate-text']//*[contains(text(),'%s')]", jobTitle));
  }

  public void profilePageIsDisplayed() {
    assertWebElementVisible(profilePage);
  }

  public void receivedKudosSectionIsDisplayed(String kudosNumber) {
    assertWebElementVisible(getReceivedKudosNumber(kudosNumber));
  }

  public void receivedKudosUsersSectionIsDisplayed(String user) {
    assertWebElementVisible(getReceivedKudosUsers(user));
  }

  public void removeWorkExperience(String jobTitle) {
    // Remove Work Experience
    editWorkExperiences.waitUntilVisible();
    editWorkExperiences.clickOnElement();
    openWorkExperience(jobTitle).clickOnElement();
    ELEMENT_REMOVE_WORK_EXPERIENCE.clickOnElement();
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", saveWorkExperiences);
    saveWorkExperiences.waitUntilNotVisible();
  }

  public void selectInstantMessagingType(String instantMessagingType, String... option) {
    switch (instantMessagingType) {
    case "SKYPE":
      // Select SKYPE option
      ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN.selectByValue("skype");
      break;
    case "MSN":
      // Select MSN option
      ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN.selectByValue("msn");
      break;
    case "GITHUB":
      // Select GITHUB option
      ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN.selectByValue("github");
      break;
    case "FACEBOOK":
      // Select FACEBOOK option
      ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN.selectByValue("facebook");
      break;
    case "OTHER":
      // Select OTHER option
      ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN.selectByValue("other");
      break;

    default:
      // No option in the list.Please select correct option.
      break;
    }
  }

  public void selectPhoneType(String phoneType, String... option) {
    switch (phoneType) {
    case "WORK":
      // Select WORK option
      ELEMENT_CONTACT_PHONE_TYPE_SELECT_EDIT_BTN.selectByValue("work");
      break;
    case "HOME":
      // Select HOME option
      ELEMENT_CONTACT_PHONE_TYPE_SELECT_EDIT_BTN.selectByValue("home");
      break;
    case "OTHER":
      // Select OTHER option
      ELEMENT_CONTACT_PHONE_TYPE_SELECT_EDIT_BTN.selectByValue("other");
      break;

    default:
      // No option in the list.Please select correct option.
      break;
    }
  }

  public void sentKudosSectionIsDisplayed(String kudosNumber) {
    assertWebElementVisible(getSentKudosNumber(kudosNumber));
  }

  public void sentKudosUsersSectionIsDisplayed(String user) {
    assertWebElementVisible(getSentKudosUsers(user));
  }

  public void updateBasicInformation(String firstName, String lastName, String email, String job) {
    // Update basic information

    ELEMENT_CONTACT_INFORMATIONS_EDIT_BTN.clickOnElement();

    if (firstName != "" && firstName != null) {
      // update firstname
      $(ELEMENT_CONTACT_FIRST_NAME_EDIT_BTN).clear();
      $(ELEMENT_CONTACT_FIRST_NAME_EDIT_BTN).sendKeys(firstName);
    }
    if (lastName != "" && lastName != null) {
      // update lastName
      $(ELEMENT_CONTACT_LAST_NAME_EDIT_BTN).clear();
      $(ELEMENT_CONTACT_LAST_NAME_EDIT_BTN).sendKeys(lastName);
    }
    if (email != "" && email != null) {
      // update email
      $(ELEMENT_CONTACT_EMAIL_EDIT_BTN).clear();
      $(ELEMENT_CONTACT_EMAIL_EDIT_BTN).sendKeys(email);
    }
    if (job != "" && job != null) {
      // update job
      $(ELEMENT_CONTACT_JOB_TITLE_EDIT_BTN).clear();
      $(ELEMENT_CONTACT_JOB_TITLE_EDIT_BTN).sendKeys(job);
    }
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", ELEMENT_CONTACT_EDIT_SAVE_BTN);
    ELEMENT_CONTACT_EDIT_SAVE_BTN.waitUntilNotVisible();
  }

  public void updateContactOtherInformations(String company,
                                             String phoneType,
                                             String phone,
                                             String instantMessagingType,
                                             String instantMessaging,
                                             String url) {
    // Update other informations

    ELEMENT_CONTACT_INFORMATIONS_EDIT_BTN.clickOnElement();

    if (company != "" && company != null) {
      // update company
      ELEMENT_CONTACT_COMPANY_TITLE_EDIT_BTN.clear();
      ELEMENT_CONTACT_COMPANY_TITLE_EDIT_BTN.sendKeys(company);
    }

    if (phone != "" && phone != null) {
      // update phone
      // Select Phone Type
      selectPhoneType(phoneType);
      // Enter Phone Number
      ELEMENT_CONTACT_PHONE_TITLE_EDIT_BTN.clear();
      ELEMENT_CONTACT_PHONE_TITLE_EDIT_BTN.sendKeys(phone);
    }
    if (instantMessaging != "" && instantMessaging != null) {
      // update instantMessaging
      // Select instantMessaging Type
      selectInstantMessagingType(instantMessagingType);
      // Enter instantMessaging information
      ELEMENT_CONTACT_INSTANT_MESSAGING_TITLE_EDIT_BTN.clear();
      ELEMENT_CONTACT_INSTANT_MESSAGING_TITLE_EDIT_BTN.sendKeys(instantMessaging);
    }
    if (url != "" && url != null) {
      // update url
      ELEMENT_CONTACT_URL_TITLE_EDIT_BTN.clear();
      ELEMENT_CONTACT_URL_TITLE_EDIT_BTN.sendKeys(url);
    }

    ELEMENT_CONTACT_EDIT_SAVE_BTN.clickOnElement();

  }

  public void updateWorkExperiences(String organization, String jobTitle, String jobDetails, String usedSkills) {
    // Add work experience
    editWorkExperiences.clickOnElement();
    waitForDrawerToOpen(".profileWorkExperiencesDrawer.v-navigation-drawer--open", true);
    if (!addWorkExperiences.isCurrentlyVisible()) {
      closeWorkExperiencesDrawerBtn.clickOnElement();
      editWorkExperiences.clickOnElement();
    }
    addWorkExperiences.clickOnElement();
    elementWorkExperiencesOrganization.setTextValue(organization);
    elementWorkExperiencesJobTitle.setTextValue(jobTitle);
    elementWorkExperiencesJobDetails.setTextValue(jobDetails);
    elementWorkExperiencesUsedSkills.setTextValue(usedSkills);

    elementWorkExperiencesStartDate.clickOnElement();
    elementWorkExperiencesStartDateGoToPreviousMonth.clickOnElement();
    elementWorkExperiencesStartDateFirstMonthDay.clickOnElement();

    elementWorkExperiencesEndDate.clickOnElement();
    elementWorkExperiencesEndDateToday.clickOnElement();

    saveWorkExperiences.clickOnElement();
    waitForDrawerToClose(".profileWorkExperiencesDrawer.v-navigation-drawer--open", true);
  }

  public void uploadProfileAvatar(String fileName) {
    ELEMENT_PROFILE_AVATAR.waitUntilVisible();
    Actions builder = new Actions(driver);
    builder.moveToElement(ELEMENT_PROFILE_AVATAR).build().perform();
    uploadProfileAvatarBtn.waitUntilVisible();
    WebElement elem =
                    getDriver().findElement(org.openqa.selenium.By.xpath("//*[contains(@class,'changeAvatarButton')]//*[@class='v-input__prepend-outer']//button/following::input[1]"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(elem);
  }

}
