package io.meeds.qa.ui.pages.page.factory.engagement;

import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

public class ProgramsPage extends GenericPage {

  public ProgramsPage(WebDriver driver) {
    super(driver);
  }

  public void addDisabledProgramWithRandomDescription(String disabledProgramDescription) {
    ElementFacade ckEditorFrameProgramElement = ckEditorFrameProgramElement();
    ckEditorFrameProgramElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameProgramElement);
    try {
      TextBoxElementFacade programDescriptionFieldElement = programDescriptionFieldElement();
      programDescriptionFieldElement.waitUntilVisible();
      programDescriptionFieldElement.setTextValue(disabledProgramDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    selectStatusSwitcher();
  }

  public void addProgramWithRandomDescription(String programDescription) {
    ElementFacade ckEditorFrameProgramElement = ckEditorFrameProgramElement();
    ckEditorFrameProgramElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameProgramElement);
    try {
      TextBoxElementFacade programDescriptionFieldElement = programDescriptionFieldElement();
      programDescriptionFieldElement.waitUntilVisible();
      programDescriptionFieldElement.setTextValue(programDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void addSpaceAudience(String randomSpaceName) {
    mentionInField(audienceSpaceFieldElement(), randomSpaceName, 5);
    clickCreateProgramButton();
  }

  public void checkProgramCardDisplay(String title) {
    assertWebElementNotVisible(getProgramCardTitle(title));
  }

  public void checkProgramCardTitle(String title) {
    assertWebElementVisible(getProgramCardTitle(title));
  }

  public void checkProgramDrawerDisplay() {
    assertWebElementVisible(headerProgramDrawerElement());
  }

  public void checkProgramTitleDisplayOnCard(String title) {
    assertWebElementVisible(getProgramCardTitle(title));
  }

  public void checkProgramTitleUpdateOnCard(String title) {
    assertWebElementVisible(getProgramCardTitle(title));
  }

  public void clickAddProgramBtn() {
    clickOnElement(addProgramBtnElement());
  }

  public void clickCreateProgramButton() {
    createButtonElement().clickOnElement();
  }

  public void deleteCreatedProgram(String programName) {
    assertWebElementVisible(getProgramCard(programName));
    programThreeDotsButtonElement().clickOnElement();
    deleteProgramButtonElement().clickOnElement();
    yesConfirmButtonElement().clickOnElement();
  }

  public void editProgramWithDescription(String programName, String newProgramName, String newProgramDescription) {
    assertWebElementVisible(getProgramCard(programName));
    programThreeDotsButtonElement().clickOnElement();
    editProgramButtonElement().clickOnElement();
    programTitleFieldElement().setTextValue(newProgramName);
    waitCKEditorLoading();
    ElementFacade ckEditorFrameProgramElement = ckEditorFrameProgramElement();
    ckEditorFrameProgramElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameProgramElement);
    try {
      TextBoxElementFacade programDescriptionFieldElement = programDescriptionFieldElement();
      programDescriptionFieldElement.waitUntilVisible();
      programDescriptionFieldElement.setTextValue(newProgramDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    saveButtonElement().clickOnElement();
  }

  public void enterProgramRandomTitle(String programTitle) {
    programTitleFieldElement().setTextValue(programTitle);
  }

  public void enterProgramTitle(String programTitle) {
    programTitleFieldElement().setTextValue(programTitle);
  }

  public void selectProgramsFilter(String value) {
    ElementFacade programQuickFilterSelectBoxElement = programQuickFilterSelectBoxElement();
    programQuickFilterSelectBoxElement.clickOnElement();
    programQuickFilterSelectBoxElement.selectByValue(value);
    programQuickFilterSelectBoxElement.clickOnElement();
    waitForLoading();
  }

  public void selectStatusSwitcher() {
    WebElement checkbox = getDriver().findElement(By.xpath("//*[@class='v-input--selection-controls__ripple primary--text']"));
    checkbox.click();
  }

  public void checkEngagementAppOpened() {
    assertWebElementVisible(findByXPathOrCSS("//*[@id='EngagementCenterApplication']"));
  }

  public void selectEngagementTab(String tab) {
    clickOnElement(getEngagementTab(tab));
    waitForLoading();
    waitFor(300).milliseconds(); // Wait for Tab switch
  }

  private ElementFacade addProgramBtnElement() {
    return findByXPathOrCSS("//*[@id='engagementCenterAddProgramBtn']");
  }

  private TextBoxElementFacade audienceSpaceFieldElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@class, 'v-navigation-drawer--open')]//*[@name='programSpaceAutocomplete']//input)[01]");
  }

  private ElementFacade ckEditorFrameProgramElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open iframe.cke_wysiwyg_frame");
  }

  private ElementFacade createButtonElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open .drawerFooter button.btn-primary");
  }

  private ElementFacade deleteProgramButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'fas fa-trash-alt')]");
  }

  private ElementFacade editProgramButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'fas fa-edit')]");
  }

  private ElementFacade getProgramCard(String programName) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'engagement-center-card')]",
                                          programName));
  }

  private ElementFacade getProgramCardTitle(String title) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'engagement-center-card')]",
                                          title));
  }

  private ElementFacade headerProgramDrawerElement() {
    return findByXPathOrCSS("//*[@id='EngagementCenterProgramDrawerForm']");
  }

  private TextBoxElementFacade programDescriptionFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade programQuickFilterSelectBoxElement() {
    return findByXPathOrCSS("//*[@id='EngagementCenterApplicationCProgramsQuickFilter']");
  }

  private ElementFacade programThreeDotsButtonElement() {
    return findByXPathOrCSS("//button[contains(@class,'pull-right')]");
  }

  private TextBoxElementFacade programTitleFieldElement() {
    return findTextBoxByXPathOrCSS("//*[@id='EngagementCenterProgramDrawerTitleTextArea']");
  }

  private ElementFacade saveButtonElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open .drawerFooter button.btn-primary");
  }

  private ElementFacade yesConfirmButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__actions']//button[contains(@class,'btn btn-primary')]");
  }

  private ElementFacade getEngagementTab(String tab) {
    return findByXPathOrCSS(String.format("//*[@id='engagementCenterTabs']//*[contains(text(),'%s')]", tab));
  }

}
