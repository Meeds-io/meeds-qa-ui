package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.Notes.NotePage;
import io.meeds.qa.ui.utils.Utils;

public class NoteSteps {

  private NotePage notePage;

  public void accessNoteActivity(String noteTitle) {
    notePage.clickNoteActivity(noteTitle);
  }

  public void addNote(String noteTitle, String noteContent) {
    notePage.addNote(noteTitle, noteContent);
  }

  public void checkColorFavIcon() {
    notePage.checkColorFavIcon();
  }

  public void checkColorStarIcon() {
    notePage.checkColorStarIcon();
  }

  public void checkDeletedNote(String noteTitle) {
    notePage.checkDeletedNote(noteTitle);
  }

  public void checkEditedNote(String noteTitleEdited, String noteContentEdited) {
    notePage.checkNoteEditedDetails(noteTitleEdited, noteContentEdited);
  }

  public void checkNoteCreateForm() {
    switchToTabByIndex(1);
    notePage.checkNoteCreateFormOpened();
  }

  public void checkNoteDetailsDisplay(String noteTitle, String noteContent) {
    notePage.checkNoteDetailsDisplay(noteTitle, noteContent);
  }

  public void checkNoteEditForm() {
    switchToTabByIndex(2);
    notePage.checkNoteEditFormOpened();
  }

  public void clickAddNote() {
    notePage.clickAddNotePageIcon();
  }

  public void clickEditNote() {
    notePage.clickEditNotePage();
  }

  public void clickThreeDotsIcon() {
    notePage.clickThreeDotsIcon();
  }

  public void closeTheThirdWindow() {
    switchToTabByIndex(2);
    notePage.getDriver().close();
    switchToTabByIndex(1);
  }

  public void createNotePage(String noteTitle, String noteContent) {
    switchToTabByIndex(1);
    notePage.createNotePage(noteTitle, noteContent);
  }

  public void deleteNote() {
    notePage.deleteNote();
  }

  public void editNotePage(String noteTitleEdited, String noteContentEdited) {
    notePage.editNotePage(noteTitleEdited, noteContentEdited);
  }

  public void favoriteNote() {
    notePage.favoriteNote();
  }

  public void noteActivityDisplay(String noteTitle) {
    notePage.isNoteActivityDisplayed(noteTitle);
  }

  public void saveAndPostNote() {
    notePage.saveAndPostNote();
  }

  public void saveNote() {
    notePage.saveNote();
  }

  public void switchToTabByIndex(int i) {
    Utils.switchToTabByIndex(notePage.getDriver(), 1);
  }

  public void unfavoriteNotePage() {
    notePage.unfavoriteNotePage();
  }

}
