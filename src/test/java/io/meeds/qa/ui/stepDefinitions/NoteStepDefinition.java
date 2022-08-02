package io.meeds.qa.ui.stepDefinitions;

import static io.meeds.qa.ui.stepDefinitions.ManageSpaceStepDefinitions.getRandomNumber;
import static io.meeds.qa.ui.steps.GenericSteps.switchToTabByIndex;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.NoteSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class NoteStepDefinition {

  @Steps
  NoteSteps noteSteps;

  @When("^I click to add note")
  public void clickAddNote() {
    noteSteps.clickAddNote();
  }

  @Then("^Create note form is opened successfully in new tab")
  public void checkNoteCreateForm() {
    switchToTabByIndex(1);
    noteSteps.checkNoteCreateForm();
  }

  @When("^I add note with title '(.*)' and content '(.*)'$")
  public void addNote(String noteTitle, String noteContent) {
    noteSteps.addNote(noteTitle, noteContent);
  }

  @When("^I save Note")
  public void saveNote() {
    noteSteps.saveNote();
  }

  @When("^I save and post Note")
  public void saveAndPostNote() {
    noteSteps.saveAndPostNote();
  }

  @Then("^Note tile '(.*)' and content '(.*)' are displayed successfully$")
  public void checkNoteDetailsDisplay(String noteTitle, String noteContent) {
    noteSteps.checkNoteDetailsDisplay(noteTitle, noteContent);
  }

  @When("^I create note page with title '(.*)' and content '(.*)'$")
  public void createNotePage(String noteTitle, String noteContent) {
    switchToTabByIndex(1);
    noteSteps.createNotePage(noteTitle, noteContent);
  }

  @When("^I click to edit note")
  public void clickeditNote() {
    noteSteps.clickEditNote();
  }

  @Then("^Edit note form is opened successfully in new tab")
  public void checkNoteEditForm() {
    switchToTabByIndex(2);
    noteSteps.checkNoteEditForm();
  }

  @And("^I close the third window")
  public void closeTheThirdWindow() {
    noteSteps.closeTheThirdWindow();
  }

  @When("^I edit note page with random title and random content")
  public void editRandomNote() {
    switchToTabByIndex(2);
    String noteTitleEdited = "noteTitle" + getRandomNumber();
    String noteContentEdited = "notecontent" + getRandomNumber();
    Serenity.setSessionVariable("noteTitle").to(noteTitleEdited);
    Serenity.setSessionVariable("noteContent").to(noteContentEdited);
    noteSteps.editNotePage(noteTitleEdited, noteContentEdited);
  }

  @Then("^Note page title and content are edited successfully$")
  public void checkRandomEditedNote() {
    String noteTitle = Serenity.sessionVariableCalled("noteTitle");
    String noteContent = Serenity.sessionVariableCalled("noteContent");
    noteSteps.checkEditedNote(noteTitle, noteContent);
  }

  @When("^I click on three dots icon$")
  public void clickThreeDotsIcon() {
    noteSteps.clickThreeDotsIcon();
  }

  @And("^I delete Note$")
  public void deleteNote() {
    noteSteps.deleteNote();
  }

  @Then("^Note '(.*)' is deleted successfully$")
  public void checkDeletedProject(String noteTitle) {
    noteSteps.checkDeletedNote(noteTitle);
  }

  @Then("Note activity with title '(.*)' is displayed")
  public void checkNoteActivityDisplay(String noteTitle) {
    noteSteps.noteActivityDisplay(noteTitle);
  }

  @When("^I access note '(.*)' activity$")
  public void accessNoteActivity(String noteTitle) {
    noteSteps.accessNoteActivity(noteTitle);
  }

  @When("^I favorite the note from it's details page$")
  public void favoriteNote() {
    noteSteps.favoriteNote();
  }

  @And("^The star icon of the note details page should be yellow$")
  @Then("^The star icon of note activity should be yellow$")
  public void checkColorStarIcon() {
    noteSteps.checkColorStarIcon();
  }

  @Then("^The star icon of the note page should be grey$")
  @And("^The star icon of note activity should be grey$")
  public void checkColorFavIcon() {
    noteSteps.checkColorFavIcon();
  }

  @And("^I unfavorite the note from its details page$")
  public void unfavoriteNotePage() {
    noteSteps.unfavoriteNotePage();
  }

}
