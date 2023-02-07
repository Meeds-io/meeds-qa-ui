package io.meeds.qa.ui.pages.page.factory.kudos;

import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

public class KudosAdministrationPage extends GenericPage {

  public KudosAdministrationPage(WebDriver driver) {
    super(driver);
  }

  public void addActivityKudos(String activity, String comment) {
    getKudosLink(activity).clickOnElement();
    sendKudosMessageFromOpenedDrawer(comment);
  }

  public void addActivityKudosToSomeoneDifferent(String activity, String message, String user) {
    getKudosLink(activity).clickOnElement();
    findByXPathOrCSS("//*[contains (@class, 'v-icon notranslate v-chip')]").clickOnElement();
    ElementFacade suggesterContentElement = findByXPathOrCSS("//*[contains(@content-class,'identitySuggesterContent')]");
    suggesterContentElement.assertVisible();

    suggesterContentElement.clickOnElement();
    suggesterContentElement.sendKeys(user);
    chooseAnotherUser(user).clickOnElement();
    sendKudosMessageFromOpenedDrawer(message);
  }

  public void addKudosToSomeoneDifferent(String activity, String user, String message) {
    getKudosLink(activity).clickOnElement();
    findByXPathOrCSS("//*[contains (@class, 'v-icon notranslate v-chip')]").clickOnElement();
    ElementFacade suggesterContentElement = findByXPathOrCSS("//*[contains(@content-class,'identitySuggesterContent')]");
    suggesterContentElement.assertVisible();
    suggesterContentElement.clickOnElement();
    suggesterContentElement.sendKeys(user);
    getNotFoundUserInSpaceMessage(message).assertVisible();
  }

  public void checkKudosActivityVisible(String message) {
    getKudosActivityText(message).assertVisible();
  }

  public void checkKudosIconDisabled(String activityId) {
    getKudosLink(activityId).isDisabled();
  }

  public void checkKudosSettings(String kudosNbr, String period) {

    assertTrue(kudosNumberElement().getTextValue().contains(kudosNbr));
    assertTrue(displayedPeriodTypeElement().getTextValue().contains(period));
  }

  public void clickEditKudos() {
    threedotsKudosCommentElement().clickOnElement();
    editKudosCommentElement().clickOnElement();
  }

  public void clickEditKudosFromReply() {
    threedotsKudosReplyCommentElement().clickOnElement();
    editKudosCommentElement().clickOnElement();
  }

  public void editKudos() {
    dotsMenuElement().clickOnElement();
    editButtonElement().clickOnElement();
  }

  public void enterKudosNumber(String val) {
    TextBoxElementFacade kudosNumberElement = kudosNumberElement();
    kudosNumberElement.clickOnElement();
    kudosNumberElement.clear();
    kudosNumberElement.setTextValue(val);
  }

  public void goToKudosMenu() {
    menuBtnElement().clickOnElement();
    administrationIconElement().hover();
    addministrationMenuElement().clickOnElement();
    kudosLinkElement().clickOnElement();
  }

  public void saveChange() {
    saveBtnElement().clickOnElement();
  }

  public void searchForUsersByName(String fullName) {
    searchUsersFieldElement().setTextValue(fullName);
  }

  public void selectType() {
    periodTypeElement().clickOnElement();
    semesterPeriodElement().clickOnElement();
  }

  public void sendKudosMessageFromOpenedDrawer(String kudosMessage) {
    waitForDrawerToOpen("#activityKudosDrawer", false);
    waitCKEditorLoading();
    retryOnCondition(() -> {
      ElementFacade ckEditorFrameKudos = getCkEditorFrameKudos();
      ckEditorFrameKudos.waitUntilVisible();
      getDriver().switchTo().frame(ckEditorFrameKudos);
    }, () -> {
      getDriver().switchTo().defaultContent();
      waitFor(500).milliseconds(); // Kudos Iframe seems very slow
    });
    try {
      TextBoxElementFacade kudosFieldElement = kudosFieldElement();
      kudosFieldElement.waitUntilVisible();
      kudosFieldElement.setTextValue(kudosMessage);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    getDriver().switchTo().defaultContent();
    ElementFacade kudosButtonInDrawerElement = kudosButtonInDrawerElement();
    kudosButtonInDrawerElement.assertVisible();
    kudosButtonInDrawerElement.clickOnElement();
    kudosButtonInDrawerElement.waitUntilNotVisible();
    refreshPage();
  }

  public void sendMessage(String txt) {
    kudosMessageElement().setTextValue(txt);
    sendKudosBtnElement().clickOnElement();
  }

  public void threeDotsMenuSendKudos() {
    ElementFacade sendKudosMenuElement = sendKudosMenuElement();
    sendKudosMenuElement.assertVisible();
    sendKudosMenuElement.clickOnElement();
  }

  private ElementFacade addministrationMenuElement() {
    return findByXPathOrCSS("//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'fa fa-arrow')]");
  }

  private ElementFacade administrationIconElement() {
    return findByXPathOrCSS("//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'titleIcon')]");
  }

  private ElementFacade chooseAnotherUser(String user) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                                          user));
  }

  private ElementFacade displayedPeriodTypeElement() {
    return findByXPathOrCSS("(//*[@class='v-select__selections'])[1]");
  }

  private TextBoxElementFacade dotsMenuElement() {
    return findTextBoxByXPathOrCSS("(//i[@class='v-icon notranslate icon-default-color fas fa-ellipsis-v theme--light'])[1]");
  }

  private ElementFacade editButtonElement() {
    return findByXPathOrCSS("//i[@class='v-icon notranslate dark-grey-color fa fa-edit theme--light']");
  }

  private ElementFacade editKudosCommentElement() {
    return findByXPathOrCSS("//*[@class='v-list-item__title pl-3' and contains(text(),'Edit')]");
  }

  private ElementFacade getCkEditorFrameKudos() {
    return findByXPathOrCSS("//*[@id='activityKudosDrawer']//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private ElementFacade getKudosActivityText(String message) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'activity-detail')]//descendant::*[contains(text(),'%s')]",
                                          message));
  }

  private ElementFacade getKudosLink(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'activity-detail')]//child::button[contains(@id, 'KudosActivity')]",
                                          activity));
  }

  private ElementFacade getNotFoundUserInSpaceMessage(String message) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-select-list')]//*[contains(text() ,'%s')]", message));
  }

  private ElementFacade kudosButtonInDrawerElement() {
    return findByXPathOrCSS("//*[@id = 'activityKudosDrawer']//*[contains(@class, 'drawerFooter')]//button[contains(@class, 'btn-primary')]");
  }

  private TextBoxElementFacade kudosFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable')]");
  }

  private ElementFacade kudosLinkElement() {
    return findByXPathOrCSS("//a[@href='/portal/g/:platform:rewarding/rewardAdministration/kudosAdministration']");
  }

  private TextBoxElementFacade kudosMessageElement() {
    return findTextBoxByXPathOrCSS("]");
  }

  private TextBoxElementFacade kudosNumberElement() {
    return findTextBoxByXPathOrCSS("//input[@name='kudosPerPeriod']");
  }

  private ElementFacade menuBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'HamburgerNavigationMenuLink')]");
  }

  private ElementFacade periodTypeElement() {
    return findByXPathOrCSS("//i[@class='v-icon notranslate mdi mdi-menu-down theme--light']");
  }

  private ElementFacade saveBtnElement() {
    return findByXPathOrCSS("//button[@class='btn btn-primary ignore-vuetify-classes mb-3']");
  }

  private TextBoxElementFacade searchUsersFieldElement() {
    return findTextBoxByXPathOrCSS("//header[@id='peopleListToolbar']//input");
  }

  private ElementFacade semesterPeriodElement() {
    return findByXPathOrCSS("//*[contains(text(),'Semester')]");
  }

  private ElementFacade sendKudosBtnElement() {
    return findByXPathOrCSS("//button[@class='ignore-vuetify-classes btn btn-primary me-3']");
  }

  private ElementFacade sendKudosMenuElement() {
    return findByXPathOrCSS("//*[@class='v-list-item__title peopleActionItem']");
  }

  private ElementFacade threedotsKudosCommentElement() {
    return findByXPathOrCSS("(//*[@class='flex-grow-1 flex-shrink-1 overflow-hidden']//*[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[2]");
  }

  private ElementFacade threedotsKudosReplyCommentElement() {
    return findByXPathOrCSS("(//*[@class='flex-grow-1 flex-shrink-1 overflow-hidden']//*[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[3]");
  }
}
