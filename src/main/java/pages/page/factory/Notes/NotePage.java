package pages.page.factory.Notes;

import net.serenitybdd.core.Serenity;
import org.junit.Assert;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

import static org.aspectj.bridge.MessageUtil.info;

public class NotePage extends GenericPage {

    @FindBy(xpath = "(//*[@class='v-icon notranslate clickable add-note-click fas fa-plus theme--light'])[1]")
    private BaseElementFacade addNotePageIcon;

    @FindBy(xpath = "//*[@id='notesEditor']")
    public BaseElementFacade createNoteTab;


    public void clickAddNotePageIcon() {
        addNotePageIcon.clickOnElement();
    }

    public void checkNoteCreateFormOpened() {
        createNoteTab.isVisibleAfterWaiting();
    }

    @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
    private BaseElementFacade ckEditorFrameNote;

    @FindBy(id = "notesTitle")
    private TextBoxElementFacade noteTileTextBox;

    @FindBy(xpath = "//body[contains(@class,'notesContent')]")
    private TextBoxElementFacade noteContentTextBox;

    @FindBy(id = "notesUpdateAndPost")
    private TextBoxElementFacade saveButton;

    @FindBy(xpath = "//*[contains(@class,'notes-title')]/span")
    private TextBoxElementFacade displayedNoteTitle;

    @FindBy(xpath = "//*[contains(@class,'notes-application-content')]/p")
    private TextBoxElementFacade displayedNoteContent;

    @FindBy(id = "notesPublichAndPost")
    private TextBoxElementFacade pulldownSaveButton;

    @FindBy(xpath = "//*[contains(@class,'body-2 text-color')]")
    private TextBoxElementFacade saveAndPostButton;


    public void addNote(String noteTitle, String noteContent) {
        noteTileTextBox.setTextValue(noteTitle);
        ckEditorFrameNote.waitUntilVisible();
        ckEditorFrameNote.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameNote);

        noteContentTextBox.waitUntilVisible();
        noteContentTextBox.setTextValue(noteContent);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    }

    public void saveNote() {
        saveButton.waitUntilVisible();
        saveButton.clickOnElement();
    }

    public void checkNoteDetailsDisplay(String noteTitle, String noteContent) {
        Assert.assertTrue(displayedNoteTitle.getText().contains(noteTitle));
        Assert.assertTrue(displayedNoteContent.getText().contains(noteContent));
    }

    public void saveAndPostNote() {
        pulldownSaveButton.clickOnElement();
        saveAndPostButton.waitUntilVisible();
        saveAndPostButton.clickOnElement();
    }

    @FindBy(xpath = "//*[@class='v-icon notranslate clickable edit-note-click fas fa-edit theme--light']")
    private BaseElementFacade editNotePageIcon;


    public void createNotePage(String noteTitle, String noteContent) {
        noteTileTextBox.setTextValue(noteTitle);
        ckEditorFrameNote.waitUntilVisible();
        ckEditorFrameNote.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameNote);

        noteContentTextBox.waitUntilVisible();
        noteContentTextBox.setTextValue(noteContent);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();

        saveButton.waitUntilVisible();
        saveButton.clickOnElement();
    }

    public void clickEditNotePage() {
        editNotePageIcon.clickOnElement();
    }

    public void checkNoteEditFormOpened() {
        createNoteTab.isVisibleAfterWaiting();
    }

    public void editNotePage(String noteTitleEdited, String noteContentEdited) {
        noteTileTextBox.setTextValue(noteTitleEdited);
        ckEditorFrameNote.waitUntilVisible();
        ckEditorFrameNote.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameNote);
        noteContentTextBox.waitUntilVisible();
        noteContentTextBox.setTextValue(noteContentEdited);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();

        saveButton.waitUntilVisible();
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
        return findByXpath(String.format("//*[contains(@class,'notes-title')]/span[ contains(text(),'%s')]", title));
    }

    public void deleteNote() {
        deleteNoteOption.clickOnElement();
        confirmationPopupDeleteButton.clickOnElement();
        confirmationPopupDeleteButton.isNotVisibleAfterWaiting();
    }

    public void checkDeletedNote(String title) {
        noteTitleField(title).isNotVisibleAfterWaiting();
    }

    private BaseElementFacade getNoteActivityTitle(String noteTitle) {
        return findByXpath(String.format("//*[contains(@class,'font-weight-bold')]//div[contains(text(),'%s')]", noteTitle));
    }

    public void isNoteActivityDisplayed(String noteTitle) {
        getNoteActivityTitle(noteTitle).isVisibleAfterWaiting();
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
