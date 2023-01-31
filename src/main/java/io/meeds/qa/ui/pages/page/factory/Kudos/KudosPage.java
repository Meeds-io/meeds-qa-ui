package io.meeds.qa.ui.pages.page.factory.Kudos;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class KudosPage extends GenericPage {
  @FindBy(xpath = "//i[@class='v-icon notranslate dark-grey-color fa fa-edit theme--light']")
  public static BaseElementFacade editButton;

  @FindBy(xpath = "//*[@class='v-list-item__title peopleActionItem']")
  public static BaseElementFacade sendKudosMenu;

  @FindBy(xpath = "//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'fa fa-arrow')]")
  private BaseElementFacade       addministrationMenu;

  @FindBy(xpath = "//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'titleIcon')]")
  private BaseElementFacade      administrationIcon ;

  @FindBy(xpath = "//i[contains(@class,'uiIcon uiIconToolbarNavItem uiAdministrationIcon')]")
  private BaseElementFacade       adminBtn;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[@class='v-btn__content'])[3]")
  private BaseElementFacade       closeKudosDrawer;

  @FindBy(xpath = "(//*[@class='v-select__selections'])[1]")
  private BaseElementFacade       displayedPeriodType;

  @FindBy(xpath = "(//i[@class='v-icon notranslate icon-default-color fas fa-ellipsis-v theme--light'])[1]")
  private TextBoxElementFacade    dotsMenu;

  @FindBy(xpath = "//*[@class='v-list-item__title pl-3' and contains(text(),'Edit')]")
  private BaseElementFacade editKudosComment;

  @FindBy(xpath = "//*[@id = 'activityKudosDrawer']//*[contains(@class, 'drawerFooter')]//button[contains(@class, 'btn-primary')]")
  private BaseElementFacade       kudosButtonInDrawer;

  @FindBy(xpath = "//*[@class='cke_inner cke_reset']")
  private BaseElementFacade kudosCommentFilled;

  @FindBy(xpath = "//body[contains(@class,'cke_editable')]")
  private TextBoxElementFacade    kudosField;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:rewarding/rewardAdministration/kudosAdministration']")
  private BaseElementFacade       kudosLink;

  @FindBy(xpath = "//*[@id=\"kudosMessage\"]")
  private TextBoxElementFacade    kudosMessage;

  @FindBy(xpath = "//input[@name='kudosPerPeriod']")
  private TextBoxElementFacade    kudosNumber;

  @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
  public BaseElementFacade        menuBtn;

  @FindBy(xpath = "//i[@class='v-icon notranslate mdi mdi-menu-down theme--light']")
  private BaseElementFacade       periodType;

  @FindBy(xpath = "//button[@class='btn btn-primary ignore-vuetify-classes mb-3']")
  private BaseElementFacade       saveBtn;

  @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
  private TextBoxElementFacade    searchUsersField;

  @FindBy(xpath = "//*[contains(text(),'Semester')]")
  private BaseElementFacade       semesterPeriod;

  @FindBy(xpath = "//button[@class='ignore-vuetify-classes btn btn-primary me-3']")
  private BaseElementFacade       sendKudosBtn;

  @FindBy(
      xpath = "(//*[@class='flex-grow-1 flex-shrink-1 overflow-hidden']//*[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[2]"
  )
  private BaseElementFacade threedotsKudosComment;

  @FindBy(
      xpath = "(//*[@class='flex-grow-1 flex-shrink-1 overflow-hidden']//*[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[3]"
  )
  private BaseElementFacade threedotsKudosReplyComment;

  private BaseElementFacade chooseAnotherUser(String user)
  {
    return findByXPathOrCSS(String.format("//*[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]", user));
  }

  private BaseElementFacade getNotFoundUserInSpaceMessage(String message) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-select-list')]//*[contains(text() ,'%s')]", message));
  }

  public KudosPage(WebDriver driver) {
    super(driver);
  }

  public void sendKudosMessageFromOpenedDrawer(String kudosMessage) {
    waitForDrawerToOpen("#activityKudosDrawer", false);
    waitCKEditorLoading();
    retryOnCondition(() -> {
      BaseElementFacade ckEditorFrameKudos = getCkEditorFrameKudos();
      ckEditorFrameKudos.waitUntilVisible();
      getDriver().switchTo().frame(ckEditorFrameKudos);
    }, () -> {
      getDriver().switchTo().defaultContent();
      waitFor(500).milliseconds(); // Kudos Iframe seems very slow
    });
    try {
      kudosField.waitUntilVisible();
      kudosField.setTextValue(kudosMessage);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    getDriver().switchTo().defaultContent();
    assertWebElementVisible(kudosButtonInDrawer);
    kudosButtonInDrawer.clickOnElement();
    verifyPageLoaded();
    waitForDrawerToClose("#activityKudosDrawer", false);
  }

  public void addActivityKudos(String activity, String comment) {
    getKudosLink(activity).clickOnElement();
    sendKudosMessageFromOpenedDrawer(comment);
  }

  public void checkKudosActivityVisible(String message) {
    assertWebElementVisible(getKudosActivityText(message));
  }

  public void checkKudosIconDisabled(String activityId) {
    getKudosLink(activityId).isDisabled();
  }

  public void checkKudosSettings(String kudosNbr, String period) {

    assertTrue(kudosNumber.getTextValue().contains(kudosNbr));
    assertTrue(displayedPeriodType.getTextValue().contains(period));
  }

  public void clickEditKudos() {
    threedotsKudosComment.clickOnElement();
    editKudosComment.clickOnElement();
  }

  public void clickEditKudosFromReply() {
    threedotsKudosReplyComment.clickOnElement();
    editKudosComment.clickOnElement();
  }

  public void editKudos() {
    dotsMenu.clickOnElement();
    editButton.clickOnElement();
  }

  public void enterKudosNumber(String val) {
    kudosNumber.clickOnElement();
    kudosNumber.clear();
    kudosNumber.setTextValue(val);
  }

  private BaseElementFacade getCkEditorFrameKudos() {
    return findByXPathOrCSS("//*[@id='activityKudosDrawer']//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private BaseElementFacade getKudosActivityText(String message) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'activity-detail')]//descendant::*[contains(text(),'%s')]",
                                          message));
  }

  private BaseElementFacade getKudosLink(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'activity-detail')]//child::button[contains(@id, 'KudosActivity')]",
                                          activity));
  }

  public void goToKudosMenu() {
    menuBtn.clickOnElement();
    administrationIcon.hover();
    addministrationMenu.waitUntilVisible();
    addministrationMenu.clickOnElement();
    kudosLink.clickOnElement();
  }

  public void saveChange() {
    saveBtn.clickOnElement();
  }

  public void searchForUsersByName(String fullName) {
    searchUsersField.waitUntilVisible();
    searchUsersField.setTextValue(fullName);
  }

  public void selectType() {
    periodType.waitUntilVisible();
    periodType.clickOnElement();
    semesterPeriod.clickOnElement();

  }

  public void sendMessage(String txt) {

    kudosMessage.setTextValue(txt);
    sendKudosBtn.clickOnElement();
  }

  public void threeDotsMenuSendKudos() {
    assertWebElementVisible(sendKudosMenu);
    sendKudosMenu.clickOnElement();
  }

  public void addActivityKudosToSomeoneDifferent(String activity, String message, String user) {
    getKudosLink(activity).clickOnElement();
    findByXPathOrCSS("//*[contains (@class, 'v-icon notranslate v-chip')]").clickOnElement();
    assertWebElementVisible(findByXPathOrCSS("//*[contains(@content-class,'identitySuggesterContent')]"));
    findByXPathOrCSS("//*[contains(@content-class,'identitySuggesterContent')]").clickOnElement();
    findByXPathOrCSS("//*[contains(@content-class,'identitySuggesterContent')]").sendKeys(user);
    chooseAnotherUser(user).clickOnElement();
    sendKudosMessageFromOpenedDrawer(message);
  }

  public void addKudosToSomeoneDifferent(String activity, String user, String message) {
    getKudosLink(activity).clickOnElement();
    findByXPathOrCSS("//*[contains (@class, 'v-icon notranslate v-chip')]").clickOnElement();
    assertWebElementVisible(findByXPathOrCSS("//*[contains(@content-class,'identitySuggesterContent')]"));
    findByXPathOrCSS("//*[contains(@content-class,'identitySuggesterContent')]").clickOnElement();
    findByXPathOrCSS("//*[contains(@content-class,'identitySuggesterContent')]").sendKeys(user);
    assertWebElementVisible(getNotFoundUserInSpaceMessage(message));
  }
}
