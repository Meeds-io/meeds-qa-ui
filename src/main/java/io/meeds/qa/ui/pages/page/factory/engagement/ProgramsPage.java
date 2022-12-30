package io.meeds.qa.ui.pages.page.factory.engagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class ProgramsPage extends GenericPage {
  public ProgramsPage(WebDriver driver) {
    super(driver);
  }

  private static final String  programCardTitle = "//*[contains(text(),'%s')]"
      + "//ancestor::*[contains(@class,'engagement-center-card')]";

  @FindBy(xpath = "//*[@id='engagementCenterAddProgramBtn']")
  private BaseElementFacade    addProgramBtn;

  @FindBy(xpath = "//*[@id='EngagementCenterProgramDrawerForm']")
  private BaseElementFacade    headerProgramDrawer;

  @FindBy(xpath = "//*[@id='EngagementCenterProgramDrawerTitleTextArea']")
  private TextBoxElementFacade programTitleField;

  @FindBy(css = ".v-navigation-drawer--open iframe.cke_wysiwyg_frame")
  private BaseElementFacade    ckEditorFrameProgram;

  @FindBy(css = "body.cke_editable_themed")
  private TextBoxElementFacade programDescriptionField;

  @FindBy(css = ".v-navigation-drawer--open .drawerFooter button.btn-primary")
  private BaseElementFacade    createButton;

  @FindBy(xpath = "//button[contains(@class,'pull-right')]")
  private BaseElementFacade    programThreeDotsButton;

  @FindBy(xpath = "//*[contains(@class,'fas fa-edit')]")
  private BaseElementFacade    editProgramButton;

  @FindBy(css = ".v-navigation-drawer--open .drawerFooter button.btn-primary")
  private BaseElementFacade    saveButton;

  @FindBy(xpath = "//*[contains(@class,'fas fa-trash-alt')]")
  private BaseElementFacade    deleteProgramButton;

  @FindBy(xpath = "//*[@class='v-card__actions']//button[contains(@class,'btn btn-primary')]")
  private BaseElementFacade    yesConfirmButton;

  @FindBy(xpath = "//*[@id='EngagementCenterApplicationCProgramsQuickFilter']")
  private BaseElementFacade    programQuickFilterSelectBox;

  @FindBy(xpath = "(//*[contains(@class, 'v-navigation-drawer--open')]//*[@name='programSpaceAutocomplete']//input)[01]")
  private TextBoxElementFacade audienceSpaceField;

  public void clickAddProgramBtn() {
    clickOnElement(addProgramBtn);
  }

  public void checkProgramDrawerDisplay() {
    assertWebElementVisible(headerProgramDrawer);
  }

  public void clickCreateProgramButton() {
    createButton.clickOnElement();
  }

  public void enterProgramRandomTitle(String programTitle) {
    programTitleField.setTextValue(programTitle);
  }

  @SwitchToWindow
  public void addProgramWithRandomDescription(String programDescription) {
    ckEditorFrameProgram.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameProgram);
    try {
      programDescriptionField.waitUntilVisible();
      programDescriptionField.setTextValue(programDescription);
    } finally {
      driver.switchTo().defaultContent();
    }
  }

  public void selectStatusSwitcher() {
    WebElement checkbox = driver.findElement(By.xpath("//*[@class='v-input--selection-controls__ripple primary--text']"));
    checkbox.click();
  }

  @SwitchToWindow
  public void addDisabledProgramWithRandomDescription(String disabledProgramDescription) {
    ckEditorFrameProgram.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameProgram);
    try {
      programDescriptionField.waitUntilVisible();
      programDescriptionField.setTextValue(disabledProgramDescription);
    } finally {
      driver.switchTo().defaultContent();
    }
    selectStatusSwitcher();
  }

  public void checkProgramTitleDisplayOnCard(String title) {
    assertWebElementVisible(getProgramCardTitle(title));
  }

  public void checkProgramCardDisplay(String title) {
    assertWebElementNotVisible(getProgramCardTitle(title));
  }

  public void editProgramWithDescription(String programName, String newProgramName, String newProgramDescription) {
    assertWebElementVisible(getProgramCard(programName));
    programThreeDotsButton.clickOnElement();
    editProgramButton.clickOnElement();
    programTitleField.setTextValue(newProgramName);
    waitCKEditorLoading();
    ckEditorFrameProgram.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameProgram);
    try {
      programDescriptionField.waitUntilVisible();
      programDescriptionField.setTextValue(newProgramDescription);
    } finally {
      driver.switchTo().defaultContent();
    }

    saveButton.clickOnElement();
  }

  public void checkProgramTitleUpdateOnCard(String title) {
    assertWebElementVisible(getProgramCardTitle(title));
  }

  public void deleteCreatedProgram(String programName) {
    assertWebElementVisible(getProgramCard(programName));
    programThreeDotsButton.clickOnElement();
    deleteProgramButton.clickOnElement();
    yesConfirmButton.clickOnElement();
  }

  @SwitchToWindow
  public void selectProgramsFilter(String value) {
    programQuickFilterSelectBox.clickOnElement();
    programQuickFilterSelectBox.selectByValue(value);
    programQuickFilterSelectBox.clickOnElement();
    verifyPageLoaded();
  }

  @SwitchToWindow
  public void addSpaceAudience(String randomSpaceName) {
    mentionInField(audienceSpaceField, randomSpaceName, 5);
    clickCreateProgramButton();
  }

  public void enterProgramTitle(String programTitle) {
    programTitleField.setTextValue(programTitle);
  }

  public void checkProgramCardTitle(String title) {
    assertWebElementVisible(getProgramCardTitle(title));
  }

  private BaseElementFacade getProgramCardTitle(String title) {
    return findByXPathOrCSS(String.format(programCardTitle, title));
  }

  private BaseElementFacade getProgramCard(String programName) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'engagement-center-card')]",
                                          programName));
  }

}