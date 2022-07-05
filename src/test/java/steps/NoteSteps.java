package steps;

import static steps.GenericSteps.switchToTabByIndex;

import net.serenitybdd.core.Serenity;
import pages.page.factory.Notes.NotePage;

public class NoteSteps {

  private NotePage notePage;

  public void clickAddNote() {
    notePage.clickAddNotePageIcon();
  }

  public void checkNoteCreateForm() {
    notePage.checkNoteCreateFormOpened();
  }

  public void addNote(String noteTitle, String noteContent) {
    notePage.addNote(noteTitle, noteContent);
  }

  public void saveNote() {
    notePage.saveNote();
  }

  public void saveAndPostNote() {
    notePage.saveAndPostNote();
  }

  public void checkNoteDetailsDisplay(String noteTitle, String noteContent) {
    notePage.checkNoteDetailsDisplay(noteTitle, noteContent);
  }

  public void createNotePage(String noteTitle, String noteContent) {
    notePage.createNotePage(noteTitle, noteContent);
  }

  public void clickEditNote() {
    notePage.clickEditNotePage();
  }

  public void checkNoteEditForm() {
    notePage.checkNoteEditFormOpened();
  }

  public void closeTheThirdWindow() {
    switchToTabByIndex(2);
    Serenity.getWebdriverManager().getCurrentDriver().close();
    switchToTabByIndex(1);
  }

  public void editNotePage(String noteTitleEdited, String noteContentEdited) {
    notePage.editNotePage(noteTitleEdited, noteContentEdited);
  }

  public void checkEditedNote(String noteTitleEdited, String noteContentEdited) {
    notePage.checkNoteEditedDetails(noteTitleEdited, noteContentEdited);
  }

  public void clickThreeDotsIcon() {
    notePage.clickThreeDotsIcon();
  }

  public void deleteNote() {
    notePage.deleteNote();
  }

  public void checkDeletedNote(String noteTitle) {
    notePage.checkDeletedNote(noteTitle);
  }

  public void noteActivityDisplay(String noteTitle) {
    notePage.isNoteActivityDisplayed(noteTitle);
  }

  public void accessNoteActivity(String noteTitle) {
    notePage.clickNoteActivity(noteTitle);
  }

  public void favoriteNote() {
    notePage.favoriteNote();
  }

  public void checkColorStarIcon() {
    notePage.checkColorStarIcon();
  }

  public void checkColorFavIcon() {
    notePage.checkColorFavIcon();
  }

  public void unfavoriteNotePage() {
    notePage.unfavoriteNotePage();
  }

}
