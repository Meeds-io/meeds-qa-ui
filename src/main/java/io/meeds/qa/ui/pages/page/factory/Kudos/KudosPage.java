package io.meeds.qa.ui.pages.page.factory.Kudos;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;

public class KudosPage extends GenericPage {
  public KudosPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[contains(@class,'HamburgerNavigationMenuLink')]")
  public BaseElementFacade        menuBtn;

  @FindBy(xpath = "//i[contains(@class,'uiAdministrationIcon')]")
  private BaseElementFacade       addministrationMenu;

  @FindBy(xpath = "//i[contains(@class,'uiIcon uiIconToolbarNavItem uiAdministrationIcon')]")
  private BaseElementFacade       adminBtn;

  @FindBy(xpath = "//a[@href='/portal/g/:platform:rewarding/rewardAdministration/kudosAdministration']")
  private BaseElementFacade       kudosLink;

  @FindBy(xpath = "//input[@name='kudosPerPeriod']")
  private TextBoxElementFacade    kudosNumber;

  @FindBy(xpath = "//i[@class='v-icon notranslate mdi mdi-menu-down theme--light']")
  private BaseElementFacade       periodType;

  @FindBy(xpath = "//*[contains(text(),'Semester')]")
  private BaseElementFacade       semesterPeriod;

  @FindBy(xpath = "//button[@class='btn btn-primary ignore-vuetify-classes mb-3']")
  private BaseElementFacade       saveBtn;

  @FindBy(xpath = "(//*[@class='v-select__selections'])[1]")
  private BaseElementFacade       displayedPeriodType;

  @FindBy(xpath = "//*[@id=\"kudosMessage\"]")
  private TextBoxElementFacade    kudosMessage;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade    kudosField;

  @FindBy(xpath = "//span[@class='v-btn__content' and contains(text(),'Send')]")
  private BaseElementFacade       kudosButtonInDrawer;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[@class='v-btn__content'])[3]")
  private BaseElementFacade       closeKudosDrawer;

  @FindBy(xpath = "//*[@class='v-list-item__title peopleActionItem']")
  public static BaseElementFacade sendKudosMenu;

  @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
  private TextBoxElementFacade    searchUsersField;

  @FindBy(xpath = "(//i[@class='v-icon notranslate icon-default-color fas fa-ellipsis-v theme--light'])[1]")
  private TextBoxElementFacade    dotsMenu;

  @FindBy(xpath = "//i[@class='v-icon notranslate dark-grey-color fa fa-edit theme--light']")
  public static BaseElementFacade editButton;

  @FindBy(xpath = "//*[contains(@class, 'v-navigation-drawer--open')]//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade       ckEditorFrameKudos;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade    KudosField;

  @FindBy(xpath = "//*[@data-cke-title='Rich Text Editor, kudosContent']/following::*[contains(@class,'cke_editable_themed')][1]")
  private TextBoxElementFacade    kudosFieldFromDrawer;

  @FindBy(xpath = "//*[contains(@class,'v-navigation-drawer--open')]//button[@aria-label='Update']")
  public BaseElementFacade        updateKudosButon;

  @FindBy(xpath = "//button[@class='ignore-vuetify-classes btn btn-primary me-3']")
  private BaseElementFacade       sendKudosBtn;

  private BaseElementFacade getKudosActivityText(String message) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'activity-detail')]//descendant::*[contains(text(),'%s')]",
                                          message));
  }

  @FindBy(
      xpath = "(//*[@class='flex-grow-1 flex-shrink-1 overflow-hidden']//*[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[2]"
  )
  private BaseElementFacade threedotsKudosComment;

  @FindBy(xpath = "//*[@class='v-list-item__title pl-3' and contains(text(),'Edit')]")
  private BaseElementFacade editKudosComment;

  @FindBy(xpath = "//*[@class='cke_inner cke_reset']")
  private BaseElementFacade kudosCommentFilled;

  @FindBy(xpath = "//*[@class='v-btn__content' and contains(text(),'Update')]")
  private BaseElementFacade updateKudosComment;

  @FindBy(
      xpath = "(//*[@class='flex-grow-1 flex-shrink-1 overflow-hidden']//*[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[3]"
  )
  private BaseElementFacade threedotsKudosReplyComment;

  private BaseElementFacade getKudosLink(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'activity-detail')]//child::button[contains(@id, 'KudosActivity')]", activity));
  }

  @SwitchToWindow
  public void addActivityKudos(String activity, String comment) {
    getKudosLink(activity).clickOnElement();
    waitForDrawerToOpen();
    waitCKEditorLoading();
    retryOnCondition(() -> {
      ckEditorFrameKudos.waitUntilVisible();
      ckEditorFrameKudos.clickOnElement();
      driver.switchTo().frame(ckEditorFrameKudos);
    }, driver.switchTo()::defaultContent);
    try {
      kudosField.waitUntilVisible();
      kudosField.setTextValue(comment);
    } finally {
      driver.switchTo().defaultContent();
    }
    driver.switchTo().defaultContent();
    assertTrue(kudosButtonInDrawer.isVisibleAfterWaiting());
    kudosButtonInDrawer.clickOnElement();
    verifyPageLoaded();
  }

  public void goToKudosMenu() {
    menuBtn.clickOnElement();
    addministrationMenu.clickOnElement();
    kudosLink.clickOnElement();
  }

  public void enterKudosNumber(String val) {
    kudosNumber.clickOnElement();
    kudosNumber.clear();
    kudosNumber.setTextValue(val);
  }

  public void selectType() {
    periodType.waitUntilVisible();
    periodType.clickOnElement();
    semesterPeriod.clickOnElement();

  }

  public void saveChange() {
    saveBtn.clickOnElement();
  }

  public void checkKudosSettings(String kudosNbr, String period) {

    assertTrue(kudosNumber.getTextValue().contains(kudosNbr));
    assertTrue(displayedPeriodType.getTextValue().contains(period));
  }

  public void sendMessage(String txt) {

    kudosMessage.setTextValue(txt);
    sendKudosBtn.clickOnElement();
  }

  public void checkKudosIconDisabled(String activityId) {
    getKudosLink(activityId).isDisabled();
  }

  public void threeDotsMenuSendKudos() {
    assertTrue(sendKudosMenu.isVisibleAfterWaiting());
    sendKudosMenu.clickOnElement();

  }

  public void searchForUsersByName(String fullName) {
    searchUsersField.waitUntilVisible();
    searchUsersField.setTextValue(fullName);
  }

  public void editKudos() {
    dotsMenu.clickOnElement();
    editButton.clickOnElement();

  }

  @SwitchToWindow
  public void updateKudosMessage(String comment) {
    waitCKEditorLoading();
    retryOnCondition(() -> {
      ckEditorFrameKudos.waitUntilVisible();
      ckEditorFrameKudos.clickOnElement();
      driver.switchTo().frame(ckEditorFrameKudos);
    }, driver.switchTo()::defaultContent);
    try {
      KudosField.waitUntilVisible();
      KudosField.clear();
      KudosField.setTextValue(comment);
    } finally {
      driver.switchTo().defaultContent();
    }
    updateKudosButon.clickOnElement();
    verifyPageLoaded();
  }

  public void checkKudosActivityVisible(String message) {
    assertWebElementVisible(getKudosActivityText(message));
  }

  @SwitchToWindow
  public void addActivityCommentKudos(String comment) {
    waitCKEditorLoading();
    retryOnCondition(() -> {
      ckEditorFrameKudos.waitUntilVisible();
      ckEditorFrameKudos.clickOnElement();
      driver.switchTo().frame(ckEditorFrameKudos);
    }, driver.switchTo()::defaultContent);
    try {
      kudosField.waitUntilVisible();
      kudosField.setTextValue(comment);
    } finally {
      driver.switchTo().defaultContent();
    }
    assertTrue(kudosButtonInDrawer.isVisibleAfterWaiting());
    kudosButtonInDrawer.clickOnElement();
    verifyPageLoaded();
  }

  @SwitchToWindow
  public void addActivityCommentKudosFromDrawer(String comment) {
    waitCKEditorLoading();
    retryOnCondition(() -> {
      ckEditorFrameKudos.waitUntilVisible();
      ckEditorFrameKudos.clickOnElement();
      driver.switchTo().frame(ckEditorFrameKudos);
    }, driver.switchTo()::defaultContent);
    try {
      kudosFieldFromDrawer.waitUntilVisible();
      kudosFieldFromDrawer.setTextValue(comment);
    } finally {
      driver.switchTo().defaultContent();
    }
    assertTrue(kudosButtonInDrawer.isVisibleAfterWaiting());
    kudosButtonInDrawer.clickOnElement();
    verifyPageLoaded();
  }

  public void clickEditKudos() {
    threedotsKudosComment.clickOnElement();
    editKudosComment.clickOnElement();
  }

  public void clickEditKudosFromReply() {
    threedotsKudosReplyComment.clickOnElement();
    editKudosComment.clickOnElement();
  }

  @SwitchToWindow
  public void updateKudosCommentMessage(String comment) {
    waitCKEditorLoading();
    retryOnCondition(() -> {
      ckEditorFrameKudos.waitUntilVisible();
      ckEditorFrameKudos.clickOnElement();
      driver.switchTo().frame(ckEditorFrameKudos);
    }, driver.switchTo()::defaultContent);
    try {
      KudosField.waitUntilVisible();
      KudosField.clear();
      KudosField.setTextValue(comment);
    } finally {
      driver.switchTo().defaultContent();
    }
    updateKudosComment.clickOnElement();
    verifyPageLoaded();
  }

}
