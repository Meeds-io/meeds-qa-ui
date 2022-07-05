package pages.page.factory.people;

import static org.aspectj.bridge.MessageUtil.info;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class UserProfile extends GenericPage {
  public UserProfile(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id='kudosOverviewCardsParent']//*[@class='kudosOverviewCard col'][1]/div/div[2]")
  private BaseElementFacade    ELEMENT_CONTACT_RECEIVED_KUDOS_DW;

  @FindBy(xpath = "(//*[@class='profileHeader']/div/div/div)[2]")
  public BaseElementFacade     ELEMENT_PROFILE_JOB_DW;

  @FindBy(xpath = "//*[@id='ProfileHeader']")
  private BaseElementFacade    profilePage;

  @FindBy(xpath = "//*[@id='GamificationEarnPoints']//*[@id='uiHowEarnPoint']//*[contains(text(),'How can I earn points?')]")
  public BaseElementFacade     howToEarnPointsPage;

  @FindBy(xpath = "//aside[contains(@class,'achievementsDrawer')]//i[contains(@class,'uiIconInformation ')]")
  private BaseElementFacade    achievementIconInfo;

  @FindBy(xpath = "//aside[contains(@class,'achievementsDrawer')]")
  private BaseElementFacade    achievementsDrawer;

  @FindBy(xpath = "(//*[@class='profileHeader']/div/div/div)[1]")
  public BaseElementFacade     ELEMENT_PROFILE_FULLNAME_DW;

  @FindBy(xpath = "//aside[contains(@class,'achievementsDrawer')]//div[contains(text(),'Points')]")
  private BaseElementFacade    achievementsWeeklyPointInDrawer;

  @FindBy(xpath = "(//*[@id='ProfileHeader']//*[@class='v-image__image v-image__image--cover'])[1]")
  public BaseElementFacade     ELEMENT_PROFILE_COVER_DW;

  @FindBy(xpath = "//aside[contains(@class,'badgesDrawer')]")
  private BaseElementFacade    badgesDrawer;

  @FindBy(xpath = "//div[@id='badgesOverview']//div[contains(@class,'BadgeItemAvatar')]")
  private BaseElementFacade    badgePortlet;

  @FindBy(xpath = "//*[contains(@class,'achievementsDrawer')]//button[contains(@class,'mdi-close')]")
  private BaseElementFacade    closeAchievementsDrawerButton;

  @FindBy(xpath = "//div[@id='profile-stats-portlet']//span[contains(text(),'Points')]//preceding::span[1]")
  private BaseElementFacade    myWeeklyPoint;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade    ckEditorFrameSendKudosDrawer;

  @FindBy(xpath = "(//*[contains(@class,'v-input__icon--prepend')]//button)[1]")
  private BaseElementFacade    uploadProfileAvatarBtn;

  @FindBy(xpath = "//*[contains(@class,'changeAvatarButton')]//*[@class='v-input__prepend-outer']//button/following::input[1]")
  private BaseElementFacade    uploadProfileAvatarInput;

  @FindBy(xpath = "//*[@class='v-image v-responsive theme--light']//*[@class='v-responsive__content']")
  private BaseElementFacade    uploadedProfileAvatar;

  @FindBy(xpath = "//*[@class='v-image v-responsive theme--light']//*[@class='v-responsive__content' and @style='width: 860px;']")
  private BaseElementFacade    uploadedProfileAvatarWidth;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade sendKudosMessageContent;

  @FindBy(xpath = "//i[contains(@class,'uiIconKudos')]")
  private BaseElementFacade    uiIconKudos;

  @FindBy(id = "kudosMessage")
  private TextBoxElementFacade kudosMessage;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[2]")
  public BaseElementFacade     ELEMENT_PROFILE_CONTACT_INFORMATION_EMAIL_DW;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[3]")
  public BaseElementFacade     ELEMENT_PROFILE_CONTACT_INFORMATION_JOBTITLE_DW;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[1]")
  public BaseElementFacade     ELEMENT_PROFILE_CONTACT_INFORMATION_FULLNAME_DW;

  @FindBy(xpath = "//*[@id='ProfileContactInformation']//*[@class='text-header-title text-sub-title']")
  public BaseElementFacade     ELEMENT_PROFILE_CONTACT_INFORMATION_TITLE_DW;

  @FindBy(xpath = "(//*[@id='ProfileHeader']//*[@class='v-image__image v-image__image--cover'])[2]")
  public BaseElementFacade     ELEMENT_PROFILE_AVATAR_DW;

  @FindBy(xpath = "//*[@id='ProfileWorkExperience']//button[contains(@class,'v-btn--outlined')]//span//i")
  public BaseElementFacade     EDIT_WORK_EXPERIENCES;

  @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  public BaseElementFacade     SAVE_WORK_EXPERIENCES;

  @FindBy(
      xpath = "//*[@id='ProfileWorkExperience']//button[@class='v-icon notranslate my-auto v-icon--link mdi mdi-plus theme--light']"
  )
  public BaseElementFacade     ADD_WORK_EXPERIENCES;

  @FindBy(xpath = "//*[@id='kudosOverviewCardsParent']//*[@class='kudosOverviewCard col'][2]/div/div[2]")
  private BaseElementFacade    ELEMENT_CONTACT_SENT_KUDOS_DW;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[1]//input")
  private TextBoxElementFacade ELEMENT_WORK_EXPERIENCES_START_DATE;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[2]//input")
  private TextBoxElementFacade ELEMENT_WORK_EXPERIENCES_END_DATE;

  @FindBy(
      xpath = "(//*[contains(@class,'v-date-picker-table__current v-btn--active ')])[1]/preceding::*[@class='v-btn__content'][1]"
  )
  private TextBoxElementFacade ELEMENT_WORK_EXPERIENCES_END_DATE_TOMORROW_DAY;

  @FindBy(
      xpath = "(//*[contains(@class,'v-date-picker-table__current v-btn--active ')])[1]/preceding::*[@class='v-btn__content'][2]"
  )
  private TextBoxElementFacade ELEMENT_WORK_EXPERIENCES_START_DATE_TOMORROW_DAY;

  @FindBy(xpath = "(//*[@class='v-expansion-panel-content']//input)[1]")
  private TextBoxElementFacade ELEMENT_WORK_EXPERIENCES_ORGANIZATION;

  @FindBy(xpath = "(//*[@class='v-expansion-panel-content']//input)[2]")
  private TextBoxElementFacade ELEMENT_WORK_EXPERIENCES_JOB_TITLE;

  @FindBy(xpath = "(//*[@class='v-expansion-panel-content']//input)[3]")
  private TextBoxElementFacade ELEMENT_WORK_EXPERIENCES_USED_SKILLS;

  @FindBy(xpath = "//*[@class='v-expansion-panel-content']//textarea")
  private TextBoxElementFacade ELEMENT_WORK_EXPERIENCES_JOB_DETAILS;

  @FindBy(xpath = "(//*[@id='WalletOverview']//div)[8]")
  private BaseElementFacade    ELEMENT_CONTACT_GAINED_CAURIS_DW;

  @FindBy(xpath = "//*[contains(@class,'drawerFooter ')]//*[contains(text(),'Send')]")
  private BaseElementFacade    sendKudosButton;

  @FindBy(xpath = "//button[contains(@class,'acceptToConnectButton')]")
  private BaseElementFacade    confirmConnection;

  @FindBy(xpath = "//*[contains(@class,'drawerParent profileWorkExperiencesDrawer')]//*[contains(@class,'mdi mdi-close')]")
  public BaseElementFacade     closeWorkExperiencesDrawerBtn;

  @FindBy(xpath = "//*[@id='ProfileContactInformation']//*[@class='uiIconEdit uiIconLightBlue pb-2']")
  private BaseElementFacade    ELEMENT_CONTACT_INFORMATIONS_EDIT_BTN_DW;

  @FindBy(xpath = "(//*[@class='v-card__text d-flex fullnameFields py-0']//input)[1]")
  private BaseElementFacade    ELEMENT_CONTACT_FIRST_NAME_EDIT_BTN_DW;

  @FindBy(xpath = "(//*[@class='v-card__text d-flex fullnameFields py-0']//input)[2]")
  private BaseElementFacade    ELEMENT_CONTACT_LAST_NAME_EDIT_BTN_DW;

  @FindBy(xpath = "(//*[@class='v-card__text d-flex emailField py-0']//input)[1]")
  private BaseElementFacade    ELEMENT_CONTACT_EMAIL_EDIT_BTN_DW;

  @FindBy(xpath = "(//*[@class='v-card__text d-flex positionField py-0']//input)[1]")
  private BaseElementFacade    ELEMENT_CONTACT_JOB_TITLE_EDIT_BTN_DW;

  @FindBy(xpath = "(//*[@class='layout column']//*[@class='d-flex']//button)[5]")
  private BaseElementFacade    ELEMENT_CONTACT_EDIT_SAVE_BTN_DW;

  @FindBy(xpath = "(//*[@class='v-card__text d-flex positionField py-0']//input)[2]")
  private BaseElementFacade    ELEMENT_CONTACT_COMPANY_TITLE_EDIT_BTN_DW;

  @FindBy(xpath = "//*[@class='v-card__text d-flex positionField py-0'][8]/following::input[1]")
  private BaseElementFacade    ELEMENT_CONTACT_PHONE_TITLE_EDIT_BTN_DW;

  @FindBy(xpath = "//*[@class='v-card__text d-flex positionField py-0'][8]/following::input[2]")
  private BaseElementFacade    ELEMENT_CONTACT_INSTANT_MESSAGING_TITLE_EDIT_BTN_DW;

  @FindBy(xpath = "//*[@class='v-card__text d-flex positionField py-0'][8]/following::input[3]")
  private BaseElementFacade    ELEMENT_CONTACT_URL_TITLE_EDIT_BTN_DW;

  @FindBy(xpath = "//*[@class='v-card__text d-flex positionField py-0'][8]/following::select[1]")
  private BaseElementFacade    ELEMENT_CONTACT_PHONE_TYPE_SELECT_EDIT_BTN_DW;

  @FindBy(xpath = "//*[@class='v-card__text d-flex positionField py-0'][8]/following::select[2]")
  private BaseElementFacade    ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN_DW;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[4]")
  private BaseElementFacade    ELEMENT_PROFILE_CONTACT_INFORMATION_COMPANY_DW;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[5]")
  private BaseElementFacade    ELEMENT_PROFILE_CONTACT_INFORMATION_PHONE_DW;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[6]")
  private BaseElementFacade    ELEMENT_PROFILE_CONTACT_INFORMATION_INSTANT_MESSAGING_DW;

  @FindBy(xpath = "(//*[@id='ProfileContactInformation']//*[@class='flex d-flex']//div[2])[7]")
  private BaseElementFacade    ELEMENT_PROFILE_CONTACT_INFORMATION_URL_DW;

  @FindBy(xpath = "//*[contains(@class,'uiIconTrash')]")
  private BaseElementFacade    ELEMENT_REMOVE_WORK_EXPERIENCE;

  private BaseElementFacade openWorkExperience(String jobTitle) {
    return findByXpath(String.format("//button//*[@class='truncate-text']//*[contains(text(),'%s')]", jobTitle));
  }

  private BaseElementFacade getJobTitleWorkExperience(String jobTitle) {
    return findByXpath(String.format("//*[@class='v-timeline-item__body']//*[@class='text-color' and contains(text(),'%s')]",
                                     jobTitle));
  }

  private BaseElementFacade getOrganizationWorkExperience(String organization) {
    return findByXpath(String.format("//*[@class='v-timeline-item__body']//*[@class='text-sub-title' and contains(text(),'%s')]",
                                     organization));
  }

  private BaseElementFacade getJobDetailsWorkExperience(String jobDetails) {
    return findByXpath(String.format("//*[@class='v-timeline-item__body']//*[contains(@class,'font-weight-light') and contains(text(),'%s')]",
                                     jobDetails));
  }

  private BaseElementFacade getUsedSkillsWorkExperience(String UsedSkill) {
    return findByXpath(String.format("//*[@class='v-timeline-item__body']//*[contains(@class,'font-weight-bold') and contains(text(),'%s')]",
                                     UsedSkill));
  }

  private BaseElementFacade getReceivedKudosNumber(String kudosNumber) {
    return findByXpath(String.format("//*[@id='kudosOverviewCardsParent']//*[contains(@class,'kudosReceivedOverviewPeriod')]//*[contains(@class,'kudosOverviewCount') and contains(text(),'%s')]",
                                     kudosNumber));
  }

  private BaseElementFacade getSentKudosNumber(String kudosNumber) {
    return findByXpath(String.format("//*[@id='kudosOverviewCardsParent']//*[contains(@class,'kudosSentOverviewPeriod')]//*[contains(@class,'kudosOverviewCount') and contains(text(),'%s')]",
                                     kudosNumber));
  }

  private BaseElementFacade getSentKudosUsers(String user) {
    return findByXpath(String.format("//*[contains(@class,'kudosOverviewDrawer')]//*[contains(@class,'drawerTitle') and contains(text(),'Kudos Sent')]/following::*[contains(@id,'avatar') and contains(text(),'%s')]",
                                     user));
  }

  private BaseElementFacade getReceivedKudosUsers(String user) {
    return findByXpath(String.format("//*[contains(@class,'kudosOverviewDrawer')]//*[contains(@class,'drawerTitle') and contains(text(),'Kudos Received')]/following::*[contains(@id,'avatar') and contains(text(),'%s')]",
                                     user));
  }

  Map<String, BaseElementFacade> MAPPING_FIELD_NAME_TO_TEXTELEMENT_XPATH = new HashMap<String, BaseElementFacade>() {
    {
      put("Weekly points", getUserStat("Points"));
      put("Weekly rank", getUserStat("Rank"));
      put("Achievements", achievementsDrawer);
      put("badge details", badgesDrawer);
      put("Total point achievement", achievementsWeeklyPointInDrawer);

    }
  };

  public boolean isFieldVisible(String fieldName) {
    return MAPPING_FIELD_NAME_TO_TEXTELEMENT_XPATH.get(fieldName).isVisibleAfterWaiting();
  }

  public void sentKudosUsersSectionIsDisplayed(String user) {
    getSentKudosUsers(user).isVisibleAfterWaiting();
  }

  public void receivedKudosUsersSectionIsDisplayed(String user) {
    getReceivedKudosUsers(user).isVisibleAfterWaiting();
  }

  public void removeWorkExperience(String jobTitle) {
    info("Remove Work Experience");
    EDIT_WORK_EXPERIENCES.waitUntilVisible();
    EDIT_WORK_EXPERIENCES.clickOnElement();
    openWorkExperience(jobTitle).clickOnElement();
    ELEMENT_REMOVE_WORK_EXPERIENCE.clickOnElement();
    JavascriptExecutor executor = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
    executor.executeScript("arguments[0].click();", SAVE_WORK_EXPERIENCES);
    SAVE_WORK_EXPERIENCES.waitUntilNotVisible();
  }

  public void checkWorkExperiencesSection(String jobTitle, String organization, String jobDetails, String usedSkills) {
    getJobTitleWorkExperience(jobTitle).isVisibleAfterWaiting();
    getOrganizationWorkExperience(organization).isVisibleAfterWaiting();
    getJobDetailsWorkExperience(jobDetails).isVisibleAfterWaiting();
    getUsedSkillsWorkExperience(usedSkills).isVisibleAfterWaiting();
  }

  public void openAchivementTab() {
    getUserStat("Points").clickOnElement();
    iconProfileStatInfo.clickOnElement();
  }

  public void openBadgeDetails() {
    closeAchievementsDrawerButton.clickOnElement();
    badgePortlet.clickOnElement();
  }

  public void profilePageIsDisplayed() {
    profilePage.isVisibleAfterWaiting();
  }

  public void howToEarnPointsPageIsDisplayed() {
    howToEarnPointsPage.isVisibleAfterWaiting();
  }

  public void sentKudosSectionIsDisplayed(String kudosNumber) {
    getSentKudosNumber(kudosNumber).isVisibleAfterWaiting();
  }

  public void receivedKudosSectionIsDisplayed(String kudosNumber) {
    getReceivedKudosNumber(kudosNumber).isVisibleAfterWaiting();
  }

  public void isProfileContactCompanyVisible(String company) {
    info("Check That Profile Contact Company is displayed");
    ELEMENT_PROFILE_CONTACT_INFORMATION_COMPANY_DW.waitUntilVisible();
    Assert.assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_COMPANY_DW.getText(), company);
  }

  public void isProfileContactPhoneVisible(String phone) {
    info("Check That Profile Contact Phone is displayed" + phone);
    Assert.assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_PHONE_DW.getText(), phone);
  }

  public void openHowToEarnPointPage() {
    achievementIconInfo.clickOnElement();
  }

  public void isProfileContactInstantMessagingVisible(String instantMessaging) {
    info("Check That Profile Contact Instant Messaging is displayed");
    Assert.assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_INSTANT_MESSAGING_DW.getText(), instantMessaging);
  }

  public void isProfileContactUrlVisible(String profileUrl) {
    info("Check That Profile Contact Url is displayed");
    Assert.assertEquals(ELEMENT_PROFILE_CONTACT_INFORMATION_URL_DW.getText(), profileUrl);
  }

  public int getMyWeeklyPoint() {
    return Integer.valueOf(myWeeklyPoint.getText());
  }

  public void clickOnSendKudosBtn() {
    uiIconKudos.waitUntilVisible();
    uiIconKudos.clickOnElement();
  }

  public void sendKudos(String comment) {
    ckEditorFrameSendKudosDrawer.waitUntilVisible();
    ckEditorFrameSendKudosDrawer.clickOnElement();
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameSendKudosDrawer);
    sendKudosMessageContent.waitUntilVisible();
    sendKudosMessageContent.setTextValue(comment);
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    sendKudosButton.clickOnElement();
  }

  public void updateContactOtherInformations(String company,
                                             String phoneType,
                                             String phone,
                                             String instantMessagingType,
                                             String instantMessaging,
                                             String url) {
    info("Update other informations");

    ELEMENT_CONTACT_INFORMATIONS_EDIT_BTN_DW.clickOnElement();

    if (company != "" && company != null) {
      info("update company");
      ELEMENT_CONTACT_COMPANY_TITLE_EDIT_BTN_DW.clear();
      ELEMENT_CONTACT_COMPANY_TITLE_EDIT_BTN_DW.sendKeys(company);
    }

    if (phone != "" && phone != null) {
      info("update phone");
      info("Select Phone Type");
      selectPhoneType(phoneType);
      info("Enter Phone Number");
      ELEMENT_CONTACT_PHONE_TITLE_EDIT_BTN_DW.clear();
      ELEMENT_CONTACT_PHONE_TITLE_EDIT_BTN_DW.sendKeys(phone);
    }
    if (instantMessaging != "" && instantMessaging != null) {
      info("update instantMessaging");
      info("Select instantMessaging Type");
      selectInstantMessagingType(instantMessagingType);
      info("Enter instantMessaging information");
      ELEMENT_CONTACT_INSTANT_MESSAGING_TITLE_EDIT_BTN_DW.clear();
      ELEMENT_CONTACT_INSTANT_MESSAGING_TITLE_EDIT_BTN_DW.sendKeys(instantMessaging);
    }
    if (url != "" && url != null) {
      info("update url");
      ELEMENT_CONTACT_URL_TITLE_EDIT_BTN_DW.clear();
      ELEMENT_CONTACT_URL_TITLE_EDIT_BTN_DW.sendKeys(url);
    }

    ELEMENT_CONTACT_EDIT_SAVE_BTN_DW.clickOnElement();

  }

  public void selectPhoneType(String phoneType,
                              String... option) {
    switch (phoneType) {
      case "WORK":
        info("Select WORK option");
        ELEMENT_CONTACT_PHONE_TYPE_SELECT_EDIT_BTN_DW.selectByValue("work");
        break;
      case "HOME":
        info("Select HOME option");
        ELEMENT_CONTACT_PHONE_TYPE_SELECT_EDIT_BTN_DW.selectByValue("home");
        break;
      case "OTHER":
        info("Select OTHER option");
        ELEMENT_CONTACT_PHONE_TYPE_SELECT_EDIT_BTN_DW.selectByValue("other");
        break;

      default:
        info("No option in the list.Please select correct option.");
        break;
    }
  }

  public void selectInstantMessagingType(String instantMessagingType,
                                         String... option) {
    switch (instantMessagingType) {
      case "SKYPE":
        info("Select SKYPE option");
        ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN_DW.selectByValue("skype");
        break;
      case "MSN":
        info("Select MSN option");
        ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN_DW.selectByValue("msn");
        break;
      case "GITHUB":
        info("Select GITHUB option");
        ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN_DW.selectByValue("github");
        break;
      case "FACEBOOK":
        info("Select FACEBOOK option");
        ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN_DW.selectByValue("facebook");
        break;
      case "OTHER":
        info("Select OTHER option");
        ELEMENT_CONTACT_INSTANT_MESSAGING_TYPE_SELECT_EDIT_BTN_DW.selectByValue("other");
        break;

      default:
        info("No option in the list.Please select correct option.");
        break;
    }
  }

  public void updateWorkExperiences(String organization,
                                    String jobTitle,
                                    String jobDetails,
                                    String usedSkills) throws InterruptedException {
    info("Add work experience");
    Thread.sleep(3000);
    EDIT_WORK_EXPERIENCES.waitUntilVisible();
    EDIT_WORK_EXPERIENCES.clickOnElement();
    if (ADD_WORK_EXPERIENCES.isNotVisibleAfterWaiting()) {
      closeWorkExperiencesDrawerBtn.waitUntilVisible();
      closeWorkExperiencesDrawerBtn.clickOnElement();
      EDIT_WORK_EXPERIENCES.waitUntilVisible();
      EDIT_WORK_EXPERIENCES.clickOnElement();
    }
    ADD_WORK_EXPERIENCES.waitUntilVisible();
    ADD_WORK_EXPERIENCES.clickOnElement();
    ELEMENT_WORK_EXPERIENCES_ORGANIZATION.waitUntilVisible();
    ELEMENT_WORK_EXPERIENCES_ORGANIZATION.sendKeys(organization);
    ELEMENT_WORK_EXPERIENCES_JOB_TITLE.sendKeys(jobTitle);
    ELEMENT_WORK_EXPERIENCES_JOB_DETAILS.sendKeys(jobDetails);
    ELEMENT_WORK_EXPERIENCES_USED_SKILLS.sendKeys(usedSkills);

    ELEMENT_WORK_EXPERIENCES_START_DATE.waitUntilVisible();
    ELEMENT_WORK_EXPERIENCES_START_DATE.clickOnElement();
    ELEMENT_WORK_EXPERIENCES_START_DATE_TOMORROW_DAY.clickOnElement();

    ELEMENT_WORK_EXPERIENCES_END_DATE.waitUntilVisible();
    ELEMENT_WORK_EXPERIENCES_END_DATE.clickOnElement();
    ELEMENT_WORK_EXPERIENCES_END_DATE_TOMORROW_DAY.clickOnElement();

    Thread.sleep(3000);
    SAVE_WORK_EXPERIENCES.waitUntilVisible();
    JavascriptExecutor executor = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
    executor.executeScript("arguments[0].click();", SAVE_WORK_EXPERIENCES);
    SAVE_WORK_EXPERIENCES.waitUntilNotVisible();
  }

  private BaseElementFacade getUserStat(String statType) {
    return findByXpath(String.format("//div[@id='profile-stats-portlet']//span[contains(text(),'%s')]", statType));
  }

  @FindBy(xpath = "//div[@id='profile-stats-portlet']//i[contains(@class,'uiIconInformation ')]")
  private BaseElementFacade iconProfileStatInfo;

  public void openWeeklyPointsChart() {
    getUserStat("Points").clickOnElement();
  }

  public void openAchievementsTab() {
    iconProfileStatInfo.clickOnElement();
  }

  public void updateBasicInformation(String firstName, String lastName, String email, String job) {
    info("Update basic information");

    ELEMENT_CONTACT_INFORMATIONS_EDIT_BTN_DW.clickOnElement();

    if (firstName != "" && firstName != null) {
      info("update firstname");
      $(ELEMENT_CONTACT_FIRST_NAME_EDIT_BTN_DW).clear();
      $(ELEMENT_CONTACT_FIRST_NAME_EDIT_BTN_DW).sendKeys(firstName);
    }
    if (lastName != "" && lastName != null) {
      info("update lastName");
      $(ELEMENT_CONTACT_LAST_NAME_EDIT_BTN_DW).clear();
      $(ELEMENT_CONTACT_LAST_NAME_EDIT_BTN_DW).sendKeys(lastName);
    }
    if (email != "" && email != null) {
      info("update email");
      $(ELEMENT_CONTACT_EMAIL_EDIT_BTN_DW).clear();
      $(ELEMENT_CONTACT_EMAIL_EDIT_BTN_DW).sendKeys(email);
    }
    if (job != "" && job != null) {
      info("update job");
      $(ELEMENT_CONTACT_JOB_TITLE_EDIT_BTN_DW).clear();
      $(ELEMENT_CONTACT_JOB_TITLE_EDIT_BTN_DW).sendKeys(job);
    }
    JavascriptExecutor executor = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
    executor.executeScript("arguments[0].click();", ELEMENT_CONTACT_EDIT_SAVE_BTN_DW);
    ELEMENT_CONTACT_EDIT_SAVE_BTN_DW.waitUntilNotVisible();
  }

  public void isSentKudosVisible() {
    ELEMENT_CONTACT_SENT_KUDOS_DW.isVisibleAfterWaiting();
  }

  public void isReceivedKudosVisible() {
    ELEMENT_CONTACT_RECEIVED_KUDOS_DW.isVisibleAfterWaiting();
  }

  public void goToReceivedKudos() {
    ELEMENT_CONTACT_RECEIVED_KUDOS_DW.clickOnElement();
  }

  public void goToSentKudos() {
    Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
    ELEMENT_CONTACT_SENT_KUDOS_DW.clickOnElement();
  }

  public void uploadProfileAvatar(String fileName) {
    ELEMENT_PROFILE_AVATAR_DW.waitUntilVisible();
    Actions builder = new Actions(driver);
    builder.moveToElement(ELEMENT_PROFILE_AVATAR_DW).build().perform();
    uploadProfileAvatarBtn.waitUntilVisible();
    WebElement elem =
                    getDriver().findElement(By.xpath("//*[contains(@class,'changeAvatarButton')]//*[@class='v-input__prepend-outer']//button/following::input[1]"));
    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
    ((JavascriptExecutor) getDriver()).executeScript(js, elem);
    upload(UPLOAD_DIRECTORY_PATH + fileName).fromLocalMachine().to(elem);
  }

  public void isProfileAvatarUploaded() {
    uploadedProfileAvatarWidth.waitUntilVisible();
    Assert.assertEquals(uploadedProfileAvatar.getAttribute("style"), "width: 860px;");
  }

  public void isGainedCaurisVisible() {
    ELEMENT_CONTACT_GAINED_CAURIS_DW.isVisibleAfterWaiting();
  }

  public void clickConfirmConnect() {
    confirmConnection.clickOnElement();
  }

}
