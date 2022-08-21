package io.meeds.qa.ui.pages.page.factory.Notes;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;

public class NotePage extends GenericPage {

  @FindBy(xpath = "(//*[@class='v-icon notranslate clickable add-note-click fas fa-plus theme--light'])[1]")
  private BaseElementFacade addNotePageIcon;

  @FindBy(xpath = "//*[@id='notesEditor']")
  public BaseElementFacade  createNoteTab;

  public void clickAddNotePageIcon() {
    addNotePageIcon.clickOnElement();
  }

  public void checkNoteCreateFormOpened() {
    assertWebElementVisible(createNoteTab);
  }

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade    ckEditorFrameNote;

  @FindBy(id = "notesTitle")
  private TextBoxElementFacade noteTileTextBox;

  @FindBy(xpath = "//body[contains(@class,'notesContent')]")
  private TextBoxElementFacade noteContentTextBox;

  @FindBy(id = "notesUpdateAndPost")
  private TextBoxElementFacade saveButton;

  @FindBy(xpath = "//*[contains(@class,'notes-title')]/span")
  private TextBoxElementFacade displayedNoteTitle;

  @FindBy(xpath = "//*[contains(@class,'notes-application-content')]")
  private TextBoxElementFacade displayedNoteContent;

  @FindBy(id = "notesPublichAndPost")
  private TextBoxElementFacade pulldownSaveButton;

  @FindBy(xpath = "//*[contains(@class,'body-2 text-color')]")
  private TextBoxElementFacade saveAndPostButton;

  @SwitchToWindow
  public void addNote(String noteTitle, String noteContent) {
    noteTileTextBox.setTextValue(noteTitle);
    ckEditorFrameNote.waitUntilVisible();
    ckEditorFrameNote.clickOnElement();
    driver.switchTo().frame(ckEditorFrameNote);
    try {
      noteContentTextBox.waitUntilVisible();
      noteContentTextBox.setTextValue(noteContent);
    } finally {
      driver.switchTo().defaultContent();
    }
  }

  public void saveNote() {
    saveButton.waitUntilVisible();
    saveButton.waitUntilClickable();
    saveButton.waitUntilEnabled();
    saveButton.clickOnElement();
  }

  public void checkNoteDetailsDisplay(String noteTitle, String noteContent) {
    displayedNoteContent.waitUntilVisible();
    displayedNoteTitle.waitUntilVisible();
    Assert.assertTrue(displayedNoteTitle.getText().contains(noteTitle));
    Assert.assertTrue(displayedNoteContent.getText().contains(noteContent));
  }

  public void saveAndPostNote() {
    pulldownSaveButton.waitUntilVisible();
    pulldownSaveButton.waitUntilClickable();
    pulldownSaveButton.waitUntilEnabled();
    pulldownSaveButton.clickOnElement();
    saveAndPostButton.waitUntilVisible();
    saveAndPostButton.waitUntilClickable();
    saveAndPostButton.waitUntilEnabled();
    saveAndPostButton.clickOnElement();
  }

  @FindBy(xpath = "//*[@class='v-icon notranslate clickable edit-note-click fas fa-edit theme--light']")
  private BaseElementFacade editNotePageIcon;

  @SwitchToWindow
  public void createNotePage(String noteTitle, String noteContent) {
    noteTileTextBox.setTextValue(noteTitle);
    ckEditorFrameNote.waitUntilVisible();
    ckEditorFrameNote.clickOnElement();
    driver.switchTo().frame(ckEditorFrameNote);
    try {
      noteContentTextBox.waitUntilVisible();
      noteContentTextBox.setTextValue(noteContent);
    } finally {
      driver.switchTo().defaultContent();
    }

    saveButton.waitUntilVisible();
    saveButton.waitUntilClickable();
    saveButton.waitUntilEnabled();
    saveButton.clickOnElement();
  }

  public void clickEditNotePage() {
    editNotePageIcon.clickOnElement();
  }

  public void checkNoteEditFormOpened() {
    assertWebElementVisible(createNoteTab);
  }

  @SwitchToWindow
  public void editNotePage(String noteTitleEdited, String noteContentEdited) {
    noteTileTextBox.setTextValue(noteTitleEdited);
    ckEditorFrameNote.waitUntilVisible();
    ckEditorFrameNote.clickOnElement();
    driver.switchTo().frame(ckEditorFrameNote);
    try {
      noteContentTextBox.waitUntilVisible();
      noteContentTextBox.setTextValue(noteContentEdited);
    } finally {
      driver.switchTo().defaultContent();
    }

    saveButton.waitUntilVisible();
    saveButton.waitUntilClickable();
    saveButton.waitUntilEnabled();
    saveButton.clickOnElement();
  }

  public void checkNoteEditedDetails(String noteTitleEdited, String noteContentEdited) {
    Assert.assertTrue(displayedNoteTitle.getText().contains(noteTitleEdited));
    Assert.assertTrue(displayedNoteContent.getText().contains(noteContentEdited));
  }

  @FindBy(xpath = "//*[@class='v-icon notranslate clickable fas fa-ellipsis-v theme--light']")
  private BaseElementFacade threeDotsIcon;

  public void clickThreeDotsIcon() {
    threeDotsIcon.clickOnElement();
  }

  @FindBy(xpath = "//*[contains(@class,'mdi mdi-trash-can-outline')]")
  private BaseElementFacade deleteNoteOption;

  @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
  private BaseElementFacade confirmationPopupDeleteButton;

  private BaseElementFacade noteTitleField(String title) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'notes-title')]/span[ contains(text(),'%s')]", title));
  }

  public void deleteNote() {
    deleteNoteOption.clickOnElement();
    confirmationPopupDeleteButton.clickOnElement();
    assertWebElementNotVisible(confirmationPopupDeleteButton);
  }

  public void checkDeletedNote(String title) {
    assertWebElementNotVisible(noteTitleField(title));
  }

  private BaseElementFacade getNoteActivityTitle(String noteTitle) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'font-weight-bold')]//div[contains(text(),'%s')]", noteTitle));
  }

  public void isNoteActivityDisplayed(String noteTitle) {
    assertWebElementVisible(getNoteActivityTitle(noteTitle));
  }

  public void clickNoteActivity(String noteTitle) {
    getNoteActivityTitle(noteTitle).clickOnElement();
  }

  @FindBy(xpath = "//i[contains(@class,'v-icon notranslate mx-auto')]")
  private BaseElementFacade favoriteIconNote;

  public void favoriteNote() {
    favoriteIconNote.clickOnElement();
  }

  @FindBy(xpath = "//*[contains(@class,'fa-star theme--light yellow--text')]")
  private BaseElementFacade colorStarIcon;

  public void checkColorStarIcon() {
    colorStarIcon.waitUntilVisible();
    colorStarIcon.shouldBeVisible();
  }

  @FindBy(xpath = "//div[@class='d-flex flex-lg-row flex-column']//i[contains(@class,'v-icon notranslate mx-auto far fa-star')]")
  private BaseElementFacade greyFavStar;

  public void checkColorFavIcon() {
    greyFavStar.shouldBeVisible();
  }

  public void unfavoriteNotePage() {
    colorStarIcon.clickOnElement();
  }

}
