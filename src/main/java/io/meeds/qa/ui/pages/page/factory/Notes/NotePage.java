package io.meeds.qa.ui.pages.page.factory.Notes;

import org.junit.Assert;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class NotePage extends GenericPage {

  @FindBy(xpath = "(//*[@class='v-icon notranslate clickable add-note-click fas fa-plus theme--light'])[1]")
  private ElementFacade addNotePageIcon;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private ElementFacade    ckEditorFrameNote;

  @FindBy(xpath = "//*[contains(@class,'fa-star theme--light yellow--text')]")
  private ElementFacade colorStarIcon;

  @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
  private ElementFacade confirmationPopupDeleteButton;

  @FindBy(xpath = "//*[@id='notesEditor']")
  public ElementFacade  createNoteTab;

  @FindBy(xpath = "//*[contains(@class,'mdi mdi-trash-can-outline')]")
  private ElementFacade deleteNoteOption;

  @FindBy(xpath = "//*[contains(@class,'notes-application-content')]")
  private TextBoxElementFacade displayedNoteContent;

  @FindBy(xpath = "//*[contains(@class,'notes-title')]/span")
  private TextBoxElementFacade displayedNoteTitle;

  @FindBy(xpath = "//*[@class='v-icon notranslate clickable edit-note-click fas fa-edit theme--light']")
  private ElementFacade editNotePageIcon;

  @FindBy(xpath = "//i[contains(@class,'v-icon notranslate mx-auto')]")
  private ElementFacade favoriteIconNote;

  @FindBy(xpath = "//div[@class='d-flex flex-lg-row flex-column']//i[contains(@class,'v-icon notranslate mx-auto far fa-star')]")
  private ElementFacade greyFavStar;

  @FindBy(xpath = "//body[contains(@class,'notesContent')]")
  private TextBoxElementFacade noteContentTextBox;

  @FindBy(id = "notesTitle")
  private TextBoxElementFacade noteTileTextBox;

  @FindBy(id = "notesPublichAndPost")
  private TextBoxElementFacade pulldownSaveButton;

  @FindBy(xpath = "//*[contains(@class,'body-2 text-color')]")
  private TextBoxElementFacade saveAndPostButton;

  @FindBy(id = "notesUpdateAndPost")
  private TextBoxElementFacade saveButton;

  @FindBy(xpath = "//*[@class='v-icon notranslate clickable fas fa-ellipsis-v theme--light']")
  private ElementFacade threeDotsIcon;

  public void addNote(String noteTitle, String noteContent) {
    noteTileTextBox.setTextValue(noteTitle);
    ckEditorFrameNote.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameNote);
    try {
      noteContentTextBox.waitUntilVisible();
      noteContentTextBox.setTextValue(noteContent);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void checkColorFavIcon() {
    greyFavStar.shouldBeVisible();
  }

  public void checkColorStarIcon() {
    colorStarIcon.waitUntilVisible();
    colorStarIcon.shouldBeVisible();
  }

  public void checkDeletedNote(String title) {
    assertWebElementNotVisible(noteTitleField(title));
  }

  public void checkNoteCreateFormOpened() {
    assertWebElementVisible(createNoteTab);
  }

  public void checkNoteDetailsDisplay(String noteTitle, String noteContent) {
    displayedNoteContent.waitUntilVisible();
    displayedNoteTitle.waitUntilVisible();
    Assert.assertTrue(displayedNoteTitle.getText().contains(noteTitle));
    Assert.assertTrue(displayedNoteContent.getText().contains(noteContent));
  }

  public void checkNoteEditedDetails(String noteTitleEdited, String noteContentEdited) {
    Assert.assertTrue(displayedNoteTitle.getText().contains(noteTitleEdited));
    Assert.assertTrue(displayedNoteContent.getText().contains(noteContentEdited));
  }

  public void checkNoteEditFormOpened() {
    assertWebElementVisible(createNoteTab);
  }

  public void clickAddNotePageIcon() {
    addNotePageIcon.clickOnElement();
  }

  public void clickEditNotePage() {
    editNotePageIcon.clickOnElement();
  }

  public void clickNoteActivity(String noteTitle) {
    getNoteActivityTitle(noteTitle).clickOnElement();
  }

  public void clickThreeDotsIcon() {
    threeDotsIcon.clickOnElement();
  }

  public void createNotePage(String noteTitle, String noteContent) {
    noteTileTextBox.setTextValue(noteTitle);
    ckEditorFrameNote.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameNote);
    try {
      noteContentTextBox.waitUntilVisible();
      noteContentTextBox.setTextValue(noteContent);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    saveButton.waitUntilVisible();
    saveButton.waitUntilClickable();
    saveButton.waitUntilEnabled();
    saveButton.clickOnElement();
  }

  public void deleteNote() {
    deleteNoteOption.clickOnElement();
    confirmationPopupDeleteButton.clickOnElement();
    assertWebElementNotVisible(confirmationPopupDeleteButton);
  }

  public void editNotePage(String noteTitleEdited, String noteContentEdited) {
    noteTileTextBox.setTextValue(noteTitleEdited);
    ckEditorFrameNote.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameNote);
    try {
      noteContentTextBox.waitUntilVisible();
      noteContentTextBox.setTextValue(noteContentEdited);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    saveButton.waitUntilVisible();
    saveButton.waitUntilClickable();
    saveButton.waitUntilEnabled();
    saveButton.clickOnElement();
  }

  public void favoriteNote() {
    favoriteIconNote.clickOnElement();
  }

  private ElementFacade getNoteActivityTitle(String noteTitle) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'font-weight-bold')]//div[contains(text(),'%s')]", noteTitle));
  }

  public void isNoteActivityDisplayed(String noteTitle) {
    assertWebElementVisible(getNoteActivityTitle(noteTitle));
  }

  private ElementFacade noteTitleField(String title) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'notes-title')]/span[ contains(text(),'%s')]", title));
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

  public void saveNote() {
    saveButton.waitUntilVisible();
    saveButton.waitUntilClickable();
    saveButton.waitUntilEnabled();
    saveButton.clickOnElement();
  }

  public void unfavoriteNotePage() {
    colorStarIcon.clickOnElement();
  }

}
