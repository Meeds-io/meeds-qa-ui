package io.meeds.qa.ui.pages.page.factory.tasks;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class TasksPage extends GenericPage {

  @FindBy(xpath = "//*[@class='v-label theme--light'and text()='Assignee']")
  private static ElementFacade assigneeRadioButton;

  @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab--active') and @aria-selected='true']")
  private ElementFacade        activeTabFilterDrawer;

  @FindBy(xpath = "//div[@id='attachmentIntegration']//button[contains(@class,'v-btn v-btn--flat')]")
  private ElementFacade        addAttachmentLink;

  @FindBy(xpath = "//*[@class='editManager']//*[@class='editManager']//i[contains(@class,'uiIconProject')]")
  private TextBoxElementFacade     addManagerBtn;

  @FindBy(xpath = "//*[@class='ViewAllCommentText']")
  private ElementFacade        addNewCommentInTask;

  @FindBy(xpath = "//button[contains(@class,'addCommentBtn')]")
  private ElementFacade        addOtherCommentInTask;

  @FindBy(xpath = "//*[@class='editParticipant']//i[@class='fas fa-plus']")
  private TextBoxElementFacade     addParticipantBtn;

  @FindBy(xpath = "//*[contains(@class, 'tasksToolbar')]//button[contains(@class, 'btn-primary')]")
  private ElementFacade        addProjectOrTask;

  @FindBy(xpath = "(//*[contains(@class,'uiIcon uiIconRotateRight')])[2]")
  private ElementFacade        addStatusafteroption;

  @FindBy(xpath = "(//*[contains(@class,'uiIconRotateLeft')])[1]")
  private ElementFacade        addStatusBeforeoption;

  @FindBy(css = ".tasksViewBoardRowContainer .tasksViewHeader .uiIconSocSimplePlus")
  private ElementFacade        addTaskInProjectButton;

  @FindBy(xpath = "//*[contains(text(),'Task successfully marked as archived')]")
  private TextBoxElementFacade     alertMessageAfterMarkTaskAsCompleted;

  @FindBy(
      xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully cloned')]"
  )
  private TextBoxElementFacade     alertMessageAfterProjectClone;

  @FindBy(
      xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully created')]"
  )
  private TextBoxElementFacade     alertMessageAfterProjectCreation;

  @FindBy(
      xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully deleted')]"
  )
  private TextBoxElementFacade     alertMessageAfterProjectDeletion;

  @FindBy(
      xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully updated')]"
  )
  private TextBoxElementFacade     alertMessageAfterProjectUpdate;

  @FindBy(
      xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Status successfully deleted')]"
  )
  private TextBoxElementFacade     alertMessageAfterStatusDeletion;

  @FindBy(
      xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Status successfully moved')]"
  )
  private TextBoxElementFacade     alertMessageAfterStatusMoved;

  @FindBy(xpath = "//*[@class='uiIcon uiBackIcon']")
  private ElementFacade        arrowBackButton;

  @FindBy(xpath = "//*[@class='uiIcon uiBackIcon']")
  private ElementFacade        backButtonProject;

  @FindBy(xpath = "//*[@class='uiIcon uiArrowBAckIcon']")
  private ElementFacade        backDrawer;

  @FindBy(xpath = "//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Cancel')][1]")
  private ElementFacade        cancelFilterButton;

  @FindBy(xpath = "//a[@title='Change location']")
  private ElementFacade        changeLocationLink;

  @FindBy(xpath = "//*[@class='ps-2' and text()='Changes']")
  private ElementFacade        checkChangesDrawer;

  @FindBy(xpath = "//*[contains(text(),'Edit task')]")
  private ElementFacade        checkEditTaskDrawer;

  @FindBy(xpath = "//*[@class='cke_wysiwyg_frame cke_reset']")
  private ElementFacade        ckEditorFrameDescription;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private ElementFacade        ckEditorFrameTask;

  @FindBy(xpath = "(//iframe[contains(@class,'cke_wysiwyg_frame')])[2]")
  private ElementFacade        ckEditorFrameTaskMentioningUser;

  @FindBy(xpath = "//*[@id='ProjectListToolbar']//button[contains(@class,' mdi-close theme')]")
  private TextBoxElementFacade     clearButtonInFilterByProject;

  @FindBy(xpath = "//*[@id='TasksListToolbar']//button[contains(@class,' mdi-close theme')]")
  private TextBoxElementFacade     clearButtonInFilterByTask;

  @FindBy(xpath = "//*[contains (@class, 'uiIconCloneNode')]")
  private ElementFacade        cloneoption;

  @FindBy(xpath = "//*[contains(@class,'uiIconCloneNode ')]")
  private ElementFacade        cloneProjectButton;

  @FindBy(xpath = "//*[contains(@class,'projectColorPicker')]")
  private ElementFacade        colorPalette;

  @FindBy(xpath = "//*[contains(@class,'v-list-item__content drawerTitle')]//span[contains(text(),'Comments')]")
  private ElementFacade        commentsDrawerSection;

  @FindBy(xpath = "//*[contains(@class,'newCommentEditor')]//button")
  private ElementFacade        commentTaskButton;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed') and contains(text(),\"Please don't exceed 1250 characters\")]")
  private TextBoxElementFacade     commentTaskMaxCharsMsg;

  @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
  private ElementFacade        confirmationPopupCloneButton;

  @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
  private ElementFacade        confirmationPopupDeleteButton;

  @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  private ElementFacade        confirmButtonDrawer;

  @FindBy(xpath = "//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Confirm')]")
  private ElementFacade        confirmFilterButton;

  @FindBy(xpath = "//*[contains(@class,'uiIconTrash ')]")
  private ElementFacade        deleteProjectButton;

  @FindBy(xpath = "//*[contains(@class,'uiIconDelete')]")
  private ElementFacade        deleteStatusIcon;

  @FindBy(xpath = "//*[contains(@class,'uiIconTrash ')]")
  private ElementFacade        deleteTaskOption;

  @FindBy(xpath = "//*[contains(@class ,'flex document-timeline-header ')]//button[contains(@class,'v-btn v-btn--flat')]")
  private ElementFacade        documentButton;

  @FindBy(xpath = "//span[contains(text(),'Select Folder')]")
  private ElementFacade        drawerTitle;

  @FindBy(xpath = "//i[contains(@class,'uiIconEcmsOnlyOfficeOpen ')]")
  private ElementFacade        editIcon;

  @FindBy(xpath = "//*[contains(@class,'uiIconEdit ')]")
  private ElementFacade        editProjectButton;

  @FindBy(xpath = "//*[contains(@class,'drawerTitle') and contains(text(),'Edit Project')]")
  private TextBoxElementFacade     editProjectDrawer;

  @FindBy(xpath = "//*[@class='drawerTitleAndProject d-flex']//span[contains(text(),'Edit task')]")
  private ElementFacade        editTaskDrawerSection;

  @FindBy(xpath = "//*[@id='task-Drawer']//*[@id='task-name']")
  private ElementFacade        ELEMENT_DRAWER_TASK_NAME;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[2]//input")
  private TextBoxElementFacade     ELEMENT_TASK_DUE_DATE;

  @FindBy(
      xpath = "((//div[@class='v-picker__actions v-card__actions']//div[contains(@class,'d-flex flex-wrap')])[02]//button)[03]"
  )
  private TextBoxElementFacade     ELEMENT_TASK_DUE_DATE_NEXT_WEEK;

  @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[2]")
  private TextBoxElementFacade     ELEMENT_TASK_DUE_DATE_TODAY;

  @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[2]/following::td[1]")
  private TextBoxElementFacade     ELEMENT_TASK_DUE_DATE_TOMORROW;

  @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[1]//input")
  private TextBoxElementFacade     ELEMENT_TASK_START_DATE;

  @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[1]")
  private TextBoxElementFacade     ELEMENT_TASK_START_DATE_TODAY;

  @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[1]/following::td[1]")
  private TextBoxElementFacade     ELEMENT_TASK_START_DATE_TOMORROW;

  @FindBy(xpath = "(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[5]")
  private ElementFacade        fifthColumnThreeDotsIcon;

  @FindBy(xpath = "//button[contains(@class,'filterTasksSetting v-btn')]")
  private ElementFacade        filterButton;

  @FindBy(xpath = "//input[@placeholder='Filter by project']")
  private TextBoxElementFacade     filterByProject;

  @FindBy(xpath = "//input[@placeholder='Filter by task']")
  private TextBoxElementFacade     filterByTask;

  @FindBy(xpath = "//button[contains(@class,'filterTasksSetting')]//span[contains(@class,'d-sm-inline')]")
  private ElementFacade        filterDrawerButton;

  @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Filter')]")
  private ElementFacade        filterTab;

  @FindBy(xpath = "(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[1]")
  private ElementFacade        firstNotificationContent;

  @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[1]")
  private ElementFacade        firstStatusColumn;

  @FindBy(xpath = "//div[@class='drawerTitle']/button[@type='button']")
  private ElementFacade        goBackIcon;

  @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Group and Sort')]")
  private ElementFacade        groupAndSortTab;

  @FindBy(xpath = "//*[@class='uiIconMessageLength']")
  private ElementFacade        informationIcon;

  @FindBy(xpath = "//*[@class='editManager']//input[@content-class='identitySuggesterContent']")
  private TextBoxElementFacade     inviteProjectManagerInput;

  @FindBy(xpath = "//*[@class='editParticipant']//input[@content-class='identitySuggesterContent']")
  private TextBoxElementFacade     inviteProjectParticipantInput;

  @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Labels')]")
  private ElementFacade        labelsTab;

  @FindBy(xpath = "//*[@id='labelInput']")
  private TextBoxElementFacade     labelTask;

  @FindBy(xpath = "(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[4]")
  private ElementFacade        lastColumnThreeDotsIcon;

  @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[4]")
  private ElementFacade        lastStatusColumn;

  @FindBy(xpath = "//*[@class='tasksListItem']//*[@class='taskCheckBox']")
  private ElementFacade        markTaskCompleted;

  @FindBy(xpath = "//button[@id='check_btn']")
  private ElementFacade        markTaskCompletedInDrawer;

  @FindBy(xpath = "//*[contains(@class,'taskViewCard')]//*[@class='taskCheckBox']")
  private ElementFacade        markTaskCompletedOnTaskCard;

  @FindBy(xpath = "//*[@class='activityCharsCount' and contains(text(),'0 / 1250')]")
  private ElementFacade        maxCharsCountInfo;

  @FindBy(xpath = "//*[@class='activityCharsCount tooManyChars']")
  private ElementFacade        more1250CharsCountInfo;

  @FindBy(xpath = "//*[contains(@class,'uiIconArrowRight ')]")
  private ElementFacade        moveStatusAfterIcon;

  @FindBy(xpath = "//*[contains(@class,'uiIconArrowLeft ')]")
  private ElementFacade        moveStatusBeforeIcon;

  @FindBy(xpath = "//a[@class='taskTabGantt v-tab']")
  private ElementFacade        planView;

  @FindBy(xpath = "(//*[@title='Add Task'])[1]")
  private ElementFacade        plusButtonToAddTask;

  @FindBy(xpath = "(//*[@title='Add Task'])[6]")
  private ElementFacade        PlusButtonToAddTaskOfTheSixthStatusColumn;

  @FindBy(xpath = "(//div[@class='pe-0 v-list-item theme--light']//button[@type='button'])[7]")
  private ElementFacade        plusIcon;

  @FindBy(xpath = "(//div[contains(@class,'v-list-item__action drawerIcons')]//button)[7]")
  private ElementFacade        plusIconProject;

  @FindBy(xpath = "//div[@class='bar']")
  private TextBoxElementFacade     progressDownloadBar;

  @FindBy(xpath = "//*[@class='taskTabBoard v-tab v-tab--active']")
  private ElementFacade        projectActiveBoardView;

  @FindBy(
      xpath = "(//*[contains(@class,'profile-popover')]//a[contains(@id,'userAvatar')]/following::div[contains(@class,'ms-2')])[2]"
  )
  private ElementFacade        projectCardUserFullName;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade     projectDescriptionField;

  @FindBy(xpath = "//*[@class='uiIcon uiIconList']")
  private ElementFacade        projectDetailsListButton;

  @FindBy(xpath = "//*[contains(@class,'uiIconVerticalDots')]")
  private ElementFacade        projectThreeDotsButton;

  @FindBy(xpath = "//*[contains(@class, 'projectInputTitle')]")
  private TextBoxElementFacade     projectTitle;

  @FindBy(xpath = "//*[contains(@class,'addProjectTitle ')]//input")
  private TextBoxElementFacade     projectTitleInput;

  @FindBy(css = "button.quickAddNewTaskButton")
  private ElementFacade        quickAddTaskInProjectButton;

  @FindBy(xpath = "//*[contains(@class,'editorContent commentEditorContainer')]//button")
  private ElementFacade        replyTaskCommentButton;

  @FindBy(xpath = "//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Reset')]")
  private ElementFacade        resetFilterButton;

  @FindBy(xpath = "//*[@class='d-flex']//button[2]")
  private ElementFacade        saveButton;

  @FindBy(xpath = "(//*[@class='d-flex']//button[2])[2]")
  private ElementFacade        saveButtonTask;

  @FindBy(xpath = "(//*[@class='d-flex']//button[2])")
  private ElementFacade        saveButtonTaskSpaceProject;

  @FindBy(xpath = "//*[contains(@class, 'v-navigation-drawer--open')]//button[@id='saveDescriptionButton']")
  private ElementFacade        saveDescriptionButton;

  @FindBy(xpath = "//div[@id='projectBoardToolbar']//input")
  private TextBoxElementFacade     searchProjectInput;

  @FindBy(xpath = "//*[@id='TasksListToolbar']//*[@class='v-text-field__slot']//input")
  private ElementFacade        searchTaskName;

  @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[2]")
  private ElementFacade        secondStatusColumn;

  @FindBy(xpath = "//*[@role='button']//*[@class='v-input__icon v-input__icon--append']")
  private ElementFacade        selectStatusSelector;

  @FindBy(xpath = "//*[contains(@class,'cke_editable cke_editabl')]")
  private TextBoxElementFacade     settaskDescription;

  @FindBy(xpath = "//*[@placeholder='Display name']")
  private TextBoxElementFacade     spaceNameTitle;

  @FindBy(xpath = "//*[@placeholder='Enter a name for this status']")
  private ElementFacade        statusField;

  @FindBy(xpath = "//*[contains(@class,'drawerParent attachmentsListDrawer')]/following::*[@class='v-alert__content'][1]//span")
  private TextBoxElementFacade     successMessage;

  @FindBy(xpath = "(//iframe[contains(@class,'cke_wysiwyg_frame')])[2]")
  private ElementFacade        switchToFrameTask;

  @FindBy(xpath = "(//iframe[contains(@class,'cke_wysiwyg_frame')])")
  private ElementFacade        switchToFrameTaskUser;

  @FindBy(xpath = "(//*[@class='taskAssignBtn mt-n1'])")
  private ElementFacade        taskAssignLink;

  @FindBy(xpath = "(//*[@class='ms-4'])[1]")
  private ElementFacade        taskAssignMe;

  @FindBy(xpath = "(//div[@name='taskAssignee']//input)[1]")
  private TextBoxElementFacade     taskAssignUserInput;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade     taskCommentContentTextBox;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade     taskDescriptionBodyField;

  @FindBy(xpath = "//*[@id='taskDescriptionId']")
  private TextBoxElementFacade     taskDescriptionField;

  @FindBy(xpath = "//*[contains(@class,'taskCompleted')]//textarea")
  private TextBoxElementFacade     taskMarkedAsCompletedInDrawer;

  @FindBy(xpath = "//*[contains(@class, 'taskTitleAndMark')]//textarea")
  private TextBoxElementFacade     taskNameField;

  @FindBy(
      xpath = "//*[@class='v-input__control']//i[@class='v-icon notranslate mdi mdi-flag-variant theme--light nonePriorityColor']"
  )
  private ElementFacade        taskPrioritySelector;

  @FindBy(xpath = "//*[contains(@class, 'task-name')]//input")
  private TextBoxElementFacade     taskQuickNameField;

  @FindBy(xpath = "//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following::*[@class='taskTitleEllipsis']")
  private ElementFacade        tasksNameToDo;

  @FindBy(xpath = "//*[contains(@class,'uiThreeDotsIcon')]")
  private ElementFacade        taskThreeDotsOption;

  @FindBy(css = "#TasksManagementPortlet .taskCard .taskTitleId .taskTitle")
  private ElementFacade        taskTooltip;

  @FindBy(xpath = "//*[@class='nameGroup' and contains (text(), 'Unassigned')]")
  private ElementFacade        textAssignee;

  @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[3]")
  private ElementFacade        thirdStatusColumn;

  @FindBy(xpath = "(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[1]")
  private ElementFacade        threeDotsIcon;

  @FindBy(xpath = "//*[contains(@class,'uiThreeDotsIcon')]")
  private ElementFacade        threeDotsIconInEditTask;

  @FindBy(xpath = "//*[@class='pe-2' and contains(text(),'Last Update')]")
  private ElementFacade        timesTamp;

  @FindBy(xpath = "//*[@placeholder='Enter a title for this task']")
  private ElementFacade        titleForTaskField;

  @FindBy(xpath = "//*[@class='lastUpdatedTask pb-3']")
  private ElementFacade        toolTip;

  @FindBy(xpath = "//*[@id='saveDescriptionButton']")
  private ElementFacade        updateButtonDescription;

  @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  private ElementFacade        updateNameSpaceButton;

  @FindBy(xpath = " //*[contains(@class,'uiIcon40x40TickBlue')]")
  private ElementFacade        validateStatusName;

  @FindBy(xpath = "//*[@class='ViewAllCommentLabel']")
  private ElementFacade        viewAllCommentsTaskButton;

  @FindBy(xpath = "//*[@class='v-card__actions']//button[contains(@class,'btn ms-2')]")
  private TextBoxElementFacade cancelButton;

  @FindBy(xpath = "//*[@class='v-card__actions']//button[contains(@class,'btn btn-primary')]")
  private ElementFacade deleteButton;

  @FindBy(
      xpath = "//div[@class='attachmentsList']//a[@class='viewAllAttachments primary--text font-weight-bold text-decoration-underline']"
  )
  private ElementFacade        viewAttachmentsLink;

  public TasksPage(WebDriver driver) {
    super(driver);
  }

  public void addFourLabelToProject(String label1, String label2, String label3, String label4) {
    labelTask.sendKeys(label1 + Keys.ENTER + label2 + Keys.ENTER + label3 + Keys.ENTER + label4 + Keys.ENTER);
  }

  public void addLabelToProject(String label) {
    labelTask.setTextValue(label);
    labelTask.sendKeys(Keys.ENTER);
  }

  public void addLabelToTask(String label) {
    retryOnCondition(() -> {
      labelTask.clickOnElement();
      getAddLabelToTask(label).clickOnElement();
    });
  }

  public void addNewCommentInTask() {
    addNewCommentInTask.waitUntilVisible();
    addNewCommentInTask.clickOnElement();
  }

  public void addNewCommentInTaskWithMentioningTheFirstUserInTask(String comment, String user) {
    mentionUserInCKEditor(ckEditorFrameTaskMentioningUser, taskCommentContentTextBox, comment, user, true);
    commentTaskButton.waitUntilVisible();
    commentTaskButton.clickOnElement();
    closeDrawerIfDisplayed();
  }

  public void addOtherCommentInTask() {
    addOtherCommentInTask.waitUntilVisible();
    addOtherCommentInTask.clickOnElement();
  }

  public void addProject(String projectName) {
    addProjectOrTask.clickOnElement();
    projectTitle.setTextValue(projectName);
    saveButton.clickOnElement();
  }

  public void addProjectManagerInput(String manager) {
    addManagerBtn.clickOnElement();
    mentionInField(inviteProjectManagerInput, manager, 5);
  }

  public void addProjectParticipantInput(String participant) {
    addParticipantBtn.clickOnElement();
    mentionInField(inviteProjectParticipantInput, participant, 5);
  }

  public void addProjectWithDescription(String projectName, String description) {
    addProjectOrTask.clickOnElement();
    projectTitle.setTextValue(projectName);

    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTask);
    try {
      projectDescriptionField.waitUntilVisible();
      projectDescriptionField.setTextValue(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    saveButton.clickOnElement();
  }

  public void addProjectWithFirstCreatedUserAsManger(String projectName, String fullName) {
    addProjectOrTask.clickOnElement();
    projectTitle.setTextValue(projectName);
    addProjectManagerInput(fullName);
    saveButton.clickOnElement();
  }

  public void addProjectWithManager(String projectName, String fullName) {
    addProjectOrTask.clickOnElement();
    projectTitle.setTextValue(projectName);
    addManagerBtn.clickOnElement();
    mentionInField(inviteProjectManagerInput, fullName, 5);
    saveButton.clickOnElement();
  }

  public void addProjectWithManagerAndParticipant(String projectName, String manager, String participant) {
    addProjectOrTask.clickOnElement();
    projectTitle.setTextValue(projectName);
    addProjectManagerInput(manager);
    addProjectParticipantInput(participant);
    saveButton.clickOnElement();
  }

  public void addProjectWithParticipant(String projectName, String lastName) {
    addProjectOrTask.clickOnElement();
    projectTitle.setTextValue(projectName);
    addProjectParticipantInput(lastName);
    saveButton.clickOnElement();
  }

  public void addSecondUserToProject(String lastName) {
    addProjectParticipantInput(lastName);
  }

  public void addSixLabelToProject(String label1, String label2, String label3, String label4, String label5, String label6) {
    labelTask.sendKeys(label1 + Keys.ENTER + label2 + Keys.ENTER + label3 + Keys.ENTER + label4 + Keys.ENTER + label5 + Keys.ENTER
        + label6 + Keys.ENTER);
  }

  public void assignTaskToMe() {
    assertWebElementVisible(taskAssignLink);
    taskAssignLink.clickOnElement();
    taskAssignMe.clickOnElement();
  }

  public void assignTaskToUser(String user) {
    assertWebElementVisible(taskAssignLink);
    taskAssignLink.clickOnElement();
    mentionInField(taskAssignUserInput, user, 5);
  }

  public void boardViewIsDisplayedByDefault() {
    assertWebElementVisible(projectActiveBoardView);
  }

  public void cancelFilterButtonIsDisplayed() {
    assertWebElementVisible(cancelFilterButton);
  }

  public void checkAlertMessageAfterDeleteTask() {
    assertWebElementVisible(findByXPathOrCSS("//*[contains(@class, 'v-alert')]//*[contains(text(),'Task successfully deleted')]"));
  }

  public void checkAlertMessageAfterMarkTaskAsCompleted() {
    assertWebElementVisible(alertMessageAfterMarkTaskAsCompleted);
  }

  public void checkAlertMessageMoveStatusAfter() {
    assertWebElementVisible(alertMessageAfterStatusMoved);
  }

  public void checkAttachmentDisplay(String attachmentName) {
    assertWebElementNotVisible(getAttachmentName(attachmentName));
  }

  public void checkClonedProject(String projectName) {
    assertWebElementVisible(getProjectCard(projectName));
    assertWebElementVisible(alertMessageAfterProjectClone);
  }

  public void checkClonedTask(String taskName) {
    assertWebElementVisible(getTaskTitle(taskName));
  }

  public void checkDeletedProject(String projectName) {
    assertWebElementNotVisible(getProjectCard(projectName));
    assertWebElementVisible(alertMessageAfterProjectDeletion);
  }

  public void checkDeletedStatus(String statusColumn) {
    assertWebElementNotVisible(getStatusColumn(statusColumn));
  }

  public void checkDeletedTaskIsNotDisplayed(String taskName) {
    assertWebElementNotVisible(getTaskName(taskName));
  }

  public void checkDescriptionDisplay(String description) {
    assertWebElementVisible(getDescriptionForTask(description));
  }

  public void checkDisplayOfFilterByProject() {
    assertWebElementVisible(filterByProject);
  }

  public void checkDisplayOfFilterByTask() {
    assertWebElementVisible(filterByTask);
  }

  public void checkDrawerDisplay() {
    assertWebElementVisible(drawerTitle);
  }

  public void checkFirstStatusColumn(String columnStatus) {
    assertEquals(firstStatusColumn.getText(), columnStatus);
  }

  public void checkGroupingSelected(String groupingValue) {
    assertTrue(findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//input[@aria-checked='true' and @value='%s']//ancestor::*[contains(@class, 'v-radio')]",
                                              groupingValue)).isVisibleAfterWaiting());
  }

  public void checkLastStatusColumn(String columnStatus) {
    Assert.assertEquals(lastStatusColumn.getText(), columnStatus);
  }

  public void checkMessageEmptyProjectDisplay() {
    assertEquals(projectTitle.getText(), "");
  }

  public void checkMoveStatusAfterIconIsNotDisplayed() {
    assertWebElementNotVisible(moveStatusAfterIcon);
  }

  public void checkMoveStatusBeforeIconIsNotDisplayed() {
    assertWebElementNotVisible(moveStatusBeforeIcon);
  }

  public void checkProject(String projectName) {
    assertWebElementVisible(getProjectCard(projectName));
    assertWebElementVisible(alertMessageAfterProjectCreation);
  }

  public void checkProjectIsCreated() {
    assertWebElementVisible(alertMessageAfterProjectCreation);
  }

  public void checkProjectNameIsDisplayedInProjectCard(String projectName, String description) {
    assertWebElementVisible(getProjectCard(projectName));
    assertWebElementVisible(getProjectCardDescription(description));
  }

  public void checkProjectNotDisplayed(String projectName) {
    assertWebElementNotVisible(getProjectCard(projectName));
    assertWebElementNotVisible(alertMessageAfterProjectCreation);
  }

  public void checkSecondStatusColumn(String columnStatus) {
    assertEquals(secondStatusColumn.getText(), columnStatus);
  }

  public void checkSuccessMessage(String message) {
    assertTrue(successMessage.getText().contains(message));
  }

  public void checkTaskPriority(String taskPriority) {
    assertWebElementVisible(getTaskPriority(taskPriority));
  }

  public void checkTaskStatus(String taskStatus) {
    assertWebElementVisible(getTaskStatus(taskStatus));
  }

  public void checkThatEditTaskDrawerIsDisplayed() {
    String checkEditTaskDrawerText = checkEditTaskDrawer.getText();
    assertEquals("Edit task", checkEditTaskDrawerText);
  }

  public void checkThatSecondLevelDrawerChangesIsOpened() {
    String checkChangesDrawerText = checkChangesDrawer.getText();
    assertEquals("Changes", checkChangesDrawerText);
  }

  public void checkThatTasksAreGroupedByAssignee() {
    assertWebElementVisible(textAssignee);
  }

  public void checkTheTimestampUpdate() {
    String timestampText = timesTamp.getText();
    assertTrue(timestampText.contains("Last Update"));
  }

  public void checkThirdStatusColumn(String columnStatus) {
    Assert.assertEquals(thirdStatusColumn.getText(), columnStatus);
  }

  public void checkTooltipIsDisplayed() {
    String toolText = toolTip.getAttribute("title");
    assertEquals("Click to view all changes", toolText);
  }

  public void checkTypedProjectIsRemoved(String typedProject) {
    assertFalse(filterByProject.getText().contains(typedProject));
  }

  public void checkTypedTaskIsRemoved(String typedTask) {
    assertFalse(filterByTask.getText().contains(typedTask));
  }

  public void checkUpdatedDescription(String Description) {
    taskDescriptionField.clickOnElement();

    waitCKEditorLoading();
    ckEditorFrameDescription.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameDescription);
    try {
      assertEquals(settaskDescription.getText(), Description);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void checkUpdatedProject(String projectName, String description) {
    assertWebElementVisible(getProjectCard(projectName));
    assertWebElementVisible(getProjectCardDescription(description));
    assertWebElementVisible(alertMessageAfterProjectUpdate);
  }

  public void checkViewLinkAttachments() {
    assertWebElementVisible(viewAttachmentsLink);
  }

  public void clearButtonInFilterByTaskIsNotVisible() {
    assertWebElementNotVisible(clearButtonInFilterByTask);
  }

  public void clearButtonInFilterByTaskIsVisible() {
    assertWebElementVisible(clearButtonInFilterByTask);
  }

  public void clearButtonIsNotVisible() {
    assertWebElementNotVisible(clearButtonInFilterByProject);
  }

  public void clearButtonIsVisible() {
    assertWebElementVisible(clearButtonInFilterByProject);
  }

  public void clickAddProjectButton() {
    addProjectOrTask.clickOnElement();
  }

  public void clickAddTaskButton() {
    ElementFacade addTaskButton = findByXPathOrCSS(".tasksToolbar button.btn-primary");
    if (addTaskButton.isCurrentlyVisible() && addTaskButton.isVisibleAfterWaiting() && addTaskButton.isClickable()) {
      addTaskButton.clickOnElement();
    } else {
      addTaskInProjectButton.clickOnElement();
    }
  }

  public void clickChangeLocation() {
    changeLocationLink.clickOnElement();
  }

  public void clickDocButton() {
    documentButton.clickOnElement();
  }

  public void clickFilterButton() {
    filterButton.clickOnElement();
    waitForDrawerToOpen();
  }

  public void clickOnAddAttachmentLink() {
    addAttachmentLink.waitUntilVisible();
    addAttachmentLink.clickOnElement();
  }

  public void clickOnAddStatusAfterOptionOfTheFifthStatusColumn() {
    addStatusafteroption.clickOnElement();
  }

  public void clickOnAddStatusBeforeOption() {
    addStatusBeforeoption.clickOnElement();
  }

  public void clickOnAssigneeRadioButton() {
    assigneeRadioButton.clickOnElement();
  }

  public void clickOnClearButton() {
    clearButtonInFilterByProject.clickOnElement();
  }

  public void clickOnClearButtonInFilterByTask() {
    clearButtonInFilterByTask.clickOnElement();
  }

  public void clickOnCommentReply(String comment) {
    assertWebElementVisible(getTaskCommentReplyBtn(comment));
    getTaskCommentReplyBtn(comment).clickOnElement();
  }

  public void clickOnConfirmButton() {
    confirmButtonDrawer.waitUntilVisible();
    confirmButtonDrawer.clickOnElement();
  }

  public void clickOnDeleteStatusIcon() {
    deleteStatusIcon.clickOnElement();
  }

  public void clickOnDeleteTaskOption() {
    deleteTaskOption.clickOnElement();
  }

  public void clickOnEditProjectButton() {
    editProjectButton.clickOnElement();
  }

  public void clickOnFifthColumnThreeDotsIcon() {
    fifthColumnThreeDotsIcon.clickOnElement();
  }

  public void clickOnLastColumnThreeDotsIcon() {
    lastColumnThreeDotsIcon.clickOnElement();
  }

  public void clickOnMoveStatusAfterIcon() {
    moveStatusAfterIcon.clickOnElement();
  }

  public void clickOnMoveStatusBeforeIcon() {
    moveStatusBeforeIcon.clickOnElement();
  }

  public void ClickOnPlusButtonToAddTask() {
    plusButtonToAddTask.clickOnElement();
  }

  public void ClickOnPlusButtonToAddTaskOfTheSixthStatusColumn() {
    PlusButtonToAddTaskOfTheSixthStatusColumn.clickOnElement();
  }

  public void clickOnProjectThreeDotsButton() {
    projectThreeDotsButton.clickOnElement();
  }

  public void ClickOnSaveButtonToAddTask() {
    saveButtonTask.clickOnElement();
  }

  public void clickOnSaveButtonToAddTaskSpaceProject() {
    saveButtonTaskSpaceProject.clickOnElement();
  }

  public void clickOnTaskThreeDotsOption() {

    taskThreeDotsOption.clickOnElement();
  }

  public void clickOnTheNotificationThatMentioneFirstUserInATaskInProject(String message, String ProjectName) {
    firstNotificationContent.waitUntilVisible();
    Assert.assertTrue(firstNotificationContent.getText().contains(message));
    Assert.assertTrue(firstNotificationContent.getText().contains(ProjectName));
    firstNotificationContent.clickOnElement();
  }

  public void clickOnTheTimestamp() {
    timesTamp.clickOnElement();
  }

  public void clickOnThreeDotsIcon() {
    threeDotsIcon.clickOnElement();
  }

  public void clickOnUpDateButton() {
    updateButtonDescription.clickOnElement();
  }

  public void clickOnValidateStatusName() {
    String currentStatusName = statusField.getValue();
    validateStatusName.clickOnElement();
    // Wait until column is added
    retryOnCondition(() -> getStatusColumn(currentStatusName).waitUntilVisible(),
                     () -> waitFor(2).seconds());
  }

  public void clickPlusIcon() {
    plusIcon.clickOnElement();
  }

  public void clickPlusIconProject() {
    plusIconProject.clickOnElement();
  }

  public void clickQuickAddTaskButton() {
    quickAddTaskInProjectButton.clickOnElement();
  }

  public void clickSaveProjectButton() {
    saveButton.clickOnElement();
  }

  public void clickStatusName(String statusColumn) {
    getStatusColumn(statusColumn).waitUntilVisible();
    getStatusColumn(statusColumn).clickOnElement();
  }

  public void clickViewAttachmentLink() {
    assertWebElementVisible(viewAttachmentsLink);
    viewAttachmentsLink.clickOnElement();
  }

  public void cloneProject(String projectName) {
    assertWebElementVisible(getProjectCard(projectName));
    projectThreeDotsButton.clickOnElement();
    cloneProjectButton.clickOnElement();
    confirmationPopupCloneButton.clickOnElement();
    assertWebElementNotVisible(confirmationPopupCloneButton);

  }

  public void cloneProjectButtonIsDisplayed() {
    assertWebElementVisible(cloneProjectButton);
  }

  public void clonetaskinspaceproject() {
    threeDotsIconInEditTask.clickOnElement();
    cloneoption.clickOnElement();
  }

  public void colorPaletteIsDisplayed() {
    assertWebElementVisible(colorPalette);
  }

  public void commentButtonIsDisabled() {
    commentTaskButton.isDisabledAfterWaiting();
  }

  public void commentsDrawerIsDisplayed() {
    assertWebElementVisible(commentsDrawerSection);
  }

  public void commentTask(String comment) {
    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTask);
    try {
      taskCommentContentTextBox.waitUntilVisible();
      taskCommentContentTextBox.setTextValue(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    commentTaskButton.waitUntilVisible();
    commentTaskButton.clickOnElement();
    closeDrawerIfDisplayed();
  }

  public void commentTaskWithUser(String user, String comment) {
    getTaskCommentWithUser(user, comment);
  }

  public void completeTask() {
    markTaskCompleted.clickOnElement();
  }

  public void confirmDeleteStatusColumn() {
    confirmationPopupDeleteButton.clickOnElement();
    assertWebElementNotVisible(confirmationPopupDeleteButton);
  }

  public void confirmDeleteTaskFromTasksBord() {
    confirmationPopupDeleteButton.clickOnElement();
  }

  public void confirmFilter() {
    confirmFilterButton.clickOnElement();
  }

  public void confirmFilterButtonIsDisplayed() {
    assertWebElementVisible(confirmFilterButton);
  }

  public void deleteCookies() {
    getDriver().manage().deleteAllCookies();
  }

  public void deleteProject(String projectName) {
    assertWebElementVisible(getProjectCard(projectName));
    projectThreeDotsButton.clickOnElement();
    deleteProjectButton.clickOnElement();
    confirmationPopupDeleteButton.clickOnElement();
    assertWebElementNotVisible(confirmationPopupDeleteButton);
  }

  public void deleteProjectButtonIsDisplayed() {
    assertWebElementVisible(deleteProjectButton);
  }

  public void deleteTaskOptionIsDisplayed() {
    assertWebElementVisible(deleteTaskOption);
  }

  public void editDescriptionForTask(String newDescription) {
    taskDescriptionField.clickOnElement();

    waitCKEditorLoading();
    switchToFrameTaskUser.waitUntilVisible();
    getDriver().switchTo().frame(switchToFrameTaskUser);
    try {
      taskDescriptionBodyField.waitUntilVisible();
      taskDescriptionBodyField.setTextValue(newDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    updateButtonDescription.clickOnElement();
    verifyPageLoaded();
  }

  public void editProjectButtonIsDisplayed() {
    assertWebElementVisible(editProjectButton);
  }

  public void editProjectName(String projectName) {
    projectThreeDotsButton.clickOnElement();
    editProjectButton.clickOnElement();
    projectTitle.setTextValue(projectName);
    saveButton.clickOnElement();
  }

  public void editProjectNameWithDescription(String projectName, String newProjectName, String newDescription) {
    assertWebElementVisible(getProjectCard(projectName));
    projectThreeDotsButton.clickOnElement();
    editProjectButton.clickOnElement();
    projectTitle.setTextValue(newProjectName);

    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTask);
    try {
      projectDescriptionField.waitUntilVisible();
      projectDescriptionField.setTextValue(newDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    saveButton.clickOnElement();
  }

  public void editSpaceName(String spaceName) {
    spaceNameTitle.setTextValue(spaceName);
    updateNameSpaceButton.clickOnElement();
  }

  public void editTaskDrawerIsDisplayed() {
    assertWebElementVisible(editTaskDrawerSection);
  }

  public void enterDescriptionForTask(String description) {
    taskDescriptionField.clickOnElement();

    waitCKEditorLoading();
    switchToFrameTask.waitUntilVisible();
    getDriver().switchTo().frame(switchToFrameTask);
    try {
      taskDescriptionBodyField.waitUntilVisible();
      taskDescriptionBodyField.setTextValue(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void enterLabelTask(String label) {
    labelTask.setTextValue(label);
    labelTask.sendKeys(Keys.ENTER);
  }

  public void enterProjectDescriptionWithoutTheTitle(String description) {
    addProjectOrTask.clickOnElement();

    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTask);
    try {
      projectDescriptionField.waitUntilVisible();
      projectDescriptionField.setTextValue(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void enterProjectTitleAndDescription(String projectName, String description) {
    addProjectOrTask.clickOnElement();
    projectTitle.setTextValue(projectName);

    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTask);
    try {
      projectDescriptionField.waitUntilVisible();
      projectDescriptionField.setTextValue(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void enterStatusText(String status) {
    statusField.sendKeys(status);
  }

  public void enterTaskComment(String comment) {
    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTask);
    try {
      taskCommentContentTextBox.waitUntilVisible();
      taskCommentContentTextBox.setTextValue(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void enterTitleForTask(String title) {
    titleForTaskField.waitUntilVisible();
    titleForTaskField.sendKeys(title);
  }

  public void exitFromTheFirstProject() {
    backButtonProject.waitUntilVisible();
    backButtonProject.clickOnElement();
  }

  private ElementFacade getAddLabelToTask(String label) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-list')]//*[contains(text(), '%s')]//ancestor::*[contains(@class,'v-chip')]",
                                          label));
  }

  private ElementFacade getAttachmentName(String attachmentName) {
    return findByXPathOrCSS(
                            String.format("(//div[@class='v-list-item__content']//div[@title='%s'])[2]", attachmentName));
  }

  private ElementFacade getCompletedTask(String taskName) {
    return findByXPathOrCSS(String.format("//*[@class='nameGroup' and text()='Archived']//following::*[@class='taskCardViewTitle text-color strikethrough']//span[@class='taskTitleEllipsis' and contains(text(),'%s')]",
                                          taskName));
  }

  private ElementFacade getDescriptionForTask(String description) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'taskDescription')]//*[contains(text(), '%s')]",
                                          description));
  }

  private ElementFacade getDisplayedLabel(String label, String times) {
    return findByXPathOrCSS(
                            String.format("//*[@class='nameGroup' and contains(text(),'%s')]//following::*[@class='amount-item' and contains(text(),'%s')][1]",
                                          label,
                                          times));
  }

  private ElementFacade getFilterOption(String option) {
    return findByXPathOrCSS(String.format("//*[@class='v-label theme--light' and text()='%s']", option));
  }

  private ElementFacade getLabelInEditProjectDrawer(String label) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'projectLabelsName')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-chip')]",
                                          label));
  }

  private ElementFacade getLabelInEditTaskDrawer(String label) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-chip')]",
                                          label));
  }

  private ElementFacade getProjectCard(String projectName) {
    return findByXPathOrCSS(
                            String.format("//span[contains(@class,'projectCardTitle') and contains(text(),'%s')]", projectName));
  }

  private ElementFacade getProjectCardDescription(String description) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@class, 'taskItemDescription')]//*[contains(text(),'%s')]",
                                          description));
  }

  private ElementFacade getProjectCardUserAvatar(String userName) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@id,'userAvatar') and contains(@href,'%s')]", userName));
  }

  private ElementFacade getRemoveLabelButton(String label) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'projectLabelsName')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-chip')]//button[contains(text(), 'close')]",
                                          label));
  }

  private ElementFacade getRemoveLabelTaskButton(String label) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-chip')]//button",
                                          label));
  }

  private ElementFacade getStatusColumn(String statusColumn) {
    return findByXPathOrCSS(String.format("(//*[@class='d-flex tasksViewHeaderLeft']//*[contains(text(),'%s')][1])[1]",
                                          statusColumn));
  }

  private ElementFacade getTaskAlert(String message) {
    return findByXPathOrCSS(
                            String.format("//*[@class='v-alert__content' and contains(text(),'%s')]", message));
  }

  private ElementFacade getTaskCommentReplyBtn(String comment) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@class,'taskCommentDrawer')]//*[@class='taskContentComment']/p[contains(text(),'%s')]/following::button[@id='reply_btn'][1]",
                                          comment));
  }

  private ElementFacade getTaskCommentWithUser(String user, String comment) {
    return findByXPathOrCSS(String.format("//*[@class='TaskCommentContent']//*[contains(text(),'%s')]/following::*[@class='taskContentComment']//p[contains(text(),'%s')]",
                                          user,
                                          comment));
  }

  private ElementFacade getTaskName(String taskName) {
    ElementFacade taskInListView =
                                     findByXPathOrCSS(String.format("//*[contains(@class, 'v-window-item--active')]//*[contains(@class, 'taskListItemView ')]/*[contains(@class, 'taskTitle ')]//*[contains(text(), '%s')]",
                                                                    taskName));
    if (taskInListView.isCurrentlyVisible()) {
      return taskInListView;
    } else {
      return findByXPathOrCSS(String.format("//*[contains(@class, 'v-window-item--active')]//*[contains(@class, 'taskViewCard ')]//*[contains(text(), '%s')]",
                                            taskName));
    }
  }

  private ElementFacade getTaskNamePlanView(String taskName) {
    return findByXPathOrCSS(String.format(
                                          "//*[@class='bar-group']//*[contains(text(),'%s')]",
                                          taskName));
  }

  private ElementFacade getTaskOrder(String number) {
    return findByXPathOrCSS(
                            String.format("(//*[@id='projectListApplication']//*[contains(@id,'taskView')]//*[contains(@class,'taskTitle')]//a)[%s]",
                                          number));
  }

  private ElementFacade getTaskPriority(String taskPriority) {
    return findByXPathOrCSS(
                            String.format("//*[@class='taskPriority']//*[@class='v-select__selections']/div[contains(text(),'%s')]",
                                          taskPriority));
  }

  private ElementFacade getTasksNumberToDo(String tasksNumber) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following ::*[@class='uiTaskNumber' and text()='%s']",
                                          tasksNumber));
  }

  private ElementFacade getTaskStatus(String taskStatus) {
    return findByXPathOrCSS(
                            String.format("//*[@class='taskStatus']//*[contains(@class,'v-select__selection--comma') and contains(text(),'%s')]",
                                          taskStatus));
  }

  private ElementFacade getTaskStatusColumn(String status) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'taskStatusName')]//*[@title='%s']/following::*[@class='taskTitleEllipsis'])[1]",
                                          status));
  }

  private ElementFacade getTaskTitle(String taskName) {
    return findByXPathOrCSS(
                            String.format("//span[contains(@class,'taskTitleEllipsis') and contains(text(),'%s')]", taskName));
  }

  private ElementFacade getTaskTitleInTasksTab(String taskName) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@class,'v-application tasksList')]//*[contains(@class,'taskTitle pe-14')]/a[contains(text(),'%s')]",
                                          taskName));
  }

  private ElementFacade getTaskToMarkAsCompleted(String taskName) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'taskCard')]//*[contains(@class, 'uiIconCircle')]",
                                          taskName));
  }

  private ElementFacade getUncompletedTask(String taskName) {
    return findByXPathOrCSS(String.format("//*[@class='nameGroup' and text()='Uncompleted']//following::*[@class='taskCardViewTitle text-color']//span[@class='taskTitleEllipsis' and contains(text(),'%s')]",
                                          taskName));
  }

  public void goBack() {
    goBackIcon.clickOnElement();
  }

  public void goToFilterTab() {
    filterTab.clickOnElement();
  }

  public void goToGroupAndSortTab() {
    groupAndSortTab.clickOnElement();
  }

  public void goToLabelsTab() {
    labelsTab.clickOnElement();
  }

  public void goToPLanView() {
    planView.waitUntilVisible();
    planView.clickOnElement();
  }

  public void goToProjectDetailsList() {
    projectDetailsListButton.clickOnElement();
  }

  public void goToProjectsTab() {
    goToTab(1);
  }

  public void goToTasksTab() {
    goToTab(2);
  }

  public void greenInformationIconIsDisplayed() {
    assertWebElementVisible(informationIcon);
    Assert.assertEquals(informationIcon.getCssValue("color"), "rgba(46, 181, 140, 1)");
  }

  public void hoverOnProjectManagerIcon() {
    projectCardUserFullName.hover("//*[contains(@class, 'spaceAdminContainer')]//*[contains(@class, 'profile-popover')]");
  }

  public void hoverOnTaskName(String task) {
    taskNameInProjectDetails(task).hover();
  }

  public void hoverOnTheChangesTimestamp() {
    Actions actions = new Actions(getDriver());
    actions.moveToElement(timesTamp).perform();
  }

  public void isFilterDrawerTabDisplayed(String tab) {
    Assert.assertEquals(activeTabFilterDrawer.getText(), tab);
  }

  public void isLabelDisplayedInProjectDetails(String label, String times) {
    assertWebElementVisible(getDisplayedLabel(label, times));
  }

  public void isSearchedTaskDisplayed(String taskName) {
    Assert.assertEquals(ELEMENT_DRAWER_TASK_NAME.getValue(), taskName);
  }

  public boolean isStatusEditModeDisplayed(String statusColumn) {
    return getStatusColumn(statusColumn).isNotVisibleAfterWaiting();
  }

  public void labelIsDisplayedInProjectDrawer(String label) {
    assertWebElementVisible(getLabelInEditProjectDrawer(label));
  }

  public void labelIsDisplayedInTaskDrawer(String label) {
    assertWebElementVisible(getLabelInEditTaskDrawer(label));
    assertWebElementNotVisible(getRemoveLabelTaskButton(label));
  }

  public void labelIsNotDisplayedInProjectDrawer(String label) {
    assertWebElementNotVisible(getLabelInEditProjectDrawer(label));
  }

  public void markTaskAsCompletedFromTaskCard() {
    markTaskCompletedOnTaskCard.clickOnElement();
  }

  public void markTaskAsCompletedInProjectDetails(String taskName) {
    getTaskToMarkAsCompleted(taskName).clickOnElement();
  }

  public void maxCharsCount1250InformationIsDisplayed() {
    assertWebElementVisible(maxCharsCountInfo);
  }

  public void maxCharsNumberMessageIsDisplayed() {
    commentsDrawerSection.clickOnElement();

    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTask);
    try {
      assertWebElementVisible(commentTaskMaxCharsMsg);
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void more1250CharsInformationIsDisplayed() {
    assertWebElementVisible(more1250CharsCountInfo);
    Assert.assertEquals(more1250CharsCountInfo.getCssValue("color"), "rgba(188, 67, 67, 1)");
  }

  public void openFilterDrawer() {
    getDriver().navigate().refresh();
    filterDrawerButton.waitUntilVisible();
    filterDrawerButton.clickOnElement();
  }

  public void openProject(String project) {
    getProjectCard(project).clickOnElement();
  }

  private void goToTab(int tabIndex) {
    ElementFacade tabLink =
        findByXPathOrCSS(String.format("//*[contains(@class, 'tasksMenuParent')]//*[@role='tab'][%s]",
                                       tabIndex));
    clickOnElement(tabLink);
    verifyPageLoaded();
    waitFor(300).milliseconds(); // Wait for Tab switch
  }

  private ElementFacade openTask(String projectName) {
    return findByXPathOrCSS(
                            String.format("//span[contains(@class,'taskTitleEllipsis') and contains(text(),'%s')]", projectName));
  }

  public void openTaskCard(String task) {
    closeDrawerIfDisplayed();
    openTask(task).clickOnElement();
    waitForDrawerToOpen();
  }

  public void openTaskDrawer(String taskName) {
    closeDrawerIfDisplayed();
    getTaskName(taskName).clickOnElement();
    waitForDrawerToOpen();
  }

  public void openTaskInTasksTab(String taskName) {
    getTaskTitleInTasksTab(taskName).waitUntilVisible();
    getTaskTitleInTasksTab(taskName).clickOnElement();
  }

  public void projectDrawerNotClosing() {
    assertTrue(findByXPathOrCSS(".v-navigation-drawer--open").isVisible());
  }

  public void projectIsDisplayedInTasksAppCenter(String projectName) {
    assertWebElementVisible(getProjectCard(projectName));
  }

  private ElementFacade projectNameInProjectDetails(String projectName) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class, 'projectTasksDashboard')]",
                                          projectName));
  }

  public void projectNameIsDisplayedInProjectDetails(String projectName) {
    assertWebElementVisible(projectNameInProjectDetails(projectName));
  }

  public void redInformationIconIsDisplayed() {
    assertWebElementVisible(informationIcon);
    Assert.assertEquals(informationIcon.getCssValue("color"), "rgba(188, 67, 67, 1)");
  }

  public void removeLabelToProject(String label) {
    // Labels are retrieved from Server, thus we should wait until it's loaded,
    // in addition, no loading effect is visible in project drawer
    retryOnCondition(() -> findByXPathOrCSS(".projectLabelsName .v-chip").waitUntilVisible());
    getRemoveLabelButton(label).clickOnElement();
  }

  public void replyTaskCommentButtonIsDisabled() {
    replyTaskCommentButton.isDisabledAfterWaiting();
  }

  public void resetFilterButtonIsDisplayed() {
    assertWebElementVisible(resetFilterButton);
  }

  public void returnToProjectsTab() {
    arrowBackButton.clickOnElement();
  }

  public void saveAddingProject() {
    saveButton.clickOnElement();
  }

  public void saveAddTaskButton() {
    saveButton.clickOnElement();
  }

  public void saveQuickTask() {
    taskQuickNameField.sendKeys(Keys.ENTER);
  }

  public void searchTask(String taskName) {
    searchTaskName.sendKeys(taskName);
  }

  public void selectFilterOption(String label) {
    getFilterOption(label).clickOnElement();
  }

  private ElementFacade selectTaskPriority(String taskPriority) {
    return findByXPathOrCSS(
                            String.format("//*[@class='body-2' and contains(text(),'%s')]", taskPriority));
  }

  private ElementFacade selectTaskStatus(String taskStatus) {
    return findByXPathOrCSS(
                            String.format("//*[@role='listbox']//*[@class='v-list-item__title' and contains(text(),'%s')]",
                                          taskStatus));
  }

  public void setInSearchProjectField(String project) {
    searchProjectInput.setTextValue(project);
    waitFor(1).seconds();
    verifyPageLoaded();
  }

  public void setProjectTitle(String projectTitle) {
    projectTitleInput.setTextValue(projectTitle);
  }

  public void setQuickTaskName(String taskName) {
    taskQuickNameField.setTextValue(taskName);
  }

  public void setTaskCompletedInDrawer() {
    markTaskCompletedInDrawer.clickOnElement();
    closeDrawerIfDisplayed();
  }

  public void setTaskCompletedInDrawerWithoutClosingIt() {
    markTaskCompletedInDrawer.clickOnElement();
  }

  public void setTaskDescription(String description) {
    taskDescriptionField.clickOnElement();

    waitCKEditorLoading();
    ckEditorFrameDescription.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameDescription);
    try {
      settaskDescription.sendKeys(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void setTaskDueDateNextWeek() {
    ELEMENT_TASK_DUE_DATE.waitUntilVisible();
    ELEMENT_TASK_DUE_DATE.clickOnElement();
    ELEMENT_TASK_DUE_DATE_NEXT_WEEK.clickOnElement();
  }

  public void setTaskDueDateToday() {
    ELEMENT_TASK_DUE_DATE.waitUntilVisible();
    ELEMENT_TASK_DUE_DATE.clickOnElement();
    ELEMENT_TASK_DUE_DATE_TODAY.clickOnElement();
  }

  public void setTaskDueDateTomorrow() {
    ELEMENT_TASK_DUE_DATE.waitUntilVisible();
    ELEMENT_TASK_DUE_DATE.clickOnElement();
    ELEMENT_TASK_DUE_DATE_TOMORROW.clickOnElement();
  }

  public void setTaskName(String taskName) {
    taskNameField.setTextValue(taskName);
  }

  public void setTaskPriority(String taskPriority) {
    assertWebElementVisible(taskPrioritySelector);
    taskPrioritySelector.clickOnElement();
    selectTaskPriority(taskPriority).clickOnElement();
  }

  public void setTaskStartDateToday() {
    ELEMENT_TASK_START_DATE.waitUntilVisible();
    ELEMENT_TASK_START_DATE.clickOnElement();
    ELEMENT_TASK_START_DATE_TODAY.clickOnElement();
  }

  public void setTaskStartDateTomorrow() {
    ELEMENT_TASK_START_DATE.waitUntilVisible();
    ELEMENT_TASK_START_DATE.clickOnElement();
    ELEMENT_TASK_START_DATE_TOMORROW.clickOnElement();
  }

  public void setTaskStatus(String taskStatus) {
    assertWebElementVisible(selectStatusSelector);
    selectStatusSelector.clickOnElement();
    assertWebElementVisible(selectTaskStatus(taskStatus));
    selectTaskStatus(taskStatus).clickOnElement();
  }

  public void switchToTASKSTab() {
    backDrawer.clickOnElement();
  }

  public void taskAlertIsDisplayed(String message) {
    assertWebElementVisible(getTaskAlert(message));
  }

  public void taskIsMarkedAndDisplayedInCompletedSection(String taskName) {
    Assert.assertEquals(getCompletedTask(taskName).getText(), taskName);
  }

  public void taskIsNotMarkedAndDisplayedInUncompletedSection(String taskName) {
    Assert.assertEquals(getUncompletedTask(taskName).getText(), taskName);
  }

  public void taskMarkedAsCompletedIsDisplayedInDrawer() {
    assertWebElementVisible(taskMarkedAsCompletedInDrawer);
  }

  private ElementFacade taskNameAndLabelAndNumberInProjectDetails(String taskName) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following::*[@class='taskTitleEllipsis' and contains(text(),'%s')]/following::*[contains(@class,'taskLabels')]//span[@class='text-truncate'])[1]",
                                          taskName));
  }

  public void taskNameAndLabelIsDisplayedInProjectDetails(String label, String taskName) {
    Assert.assertTrue(taskNameAndLabelAndNumberInProjectDetails(taskName).getText().contains(label));
  }

  private ElementFacade taskNameInProjectDetails(String taskName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'taskTitle')]//*[@title = '%s']",
                                          taskName));
  }

  public void taskNameIsDisplayedInDesiredColumn(String status, String taskName) {
    Assert.assertTrue(getTaskStatusColumn(status).getText().contains(taskName));
  }

  public void taskNameIsDisplayedInProjectDetails(String taskName) {
    ElementFacade taskElement = taskNameInProjectDetails(taskName);
    assertWebElementVisible(taskElement);
    Assert.assertEquals(taskElement.getText(), taskName);
  }

  public void taskNameIsNotDisplayedInProjectDetails(String taskName) {
    ElementFacade taskElement = taskNameInProjectDetails(taskName);
    assertWebElementNotVisible(taskElement);
  }

  public void taskNamePLanView(String taskName) {
    getTaskNamePlanView(taskName).shouldBeVisible();
  }

  public void taskOrderInProjectDetails(String task, String number) {
    Assert.assertTrue(getTaskOrder(number).getTextContent().contains(task));
  }

  public void tasksNumberToDo(String tasksNumber) {
    assertWebElementVisible(getTasksNumberToDo(tasksNumber));
  }

  public void taskTooltipIsDisplayed(String task) {
    Assert.assertEquals(taskTooltip.getText(), task);
  }

  public void updateTaskDescription(String description) {
    taskDescriptionField.clickOnElement();

    waitCKEditorLoading();
    ckEditorFrameDescription.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameDescription);
    try {
      settaskDescription.sendKeys(" " + description);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void userAvatarIsDisplayedInProjectCard(String userName) {
    assertWebElementVisible(getProjectCardUserAvatar(userName));
  }

  public void userAvatarIsNotDisplayedInProjectCard(String userName) {
    assertWebElementNotVisible(getProjectCardUserAvatar(userName));
  }

  public void userFullNameIsDisplayedInProjectCard(String name) {
    Assert.assertEquals(projectCardUserFullName.getText(), name);
  }

  public void userFullNameIsNotDisplayedInProjectCard(String name) {
    Assert.assertNotEquals(projectCardUserFullName.getText(), name);
  }

  public void verifyViewLinkAttachments() {
    assertWebElementNotVisible(viewAttachmentsLink);
  }

  public void viewAllCommentsTaskButton() {
    viewAllCommentsTaskButton.waitUntilVisible();
    viewAllCommentsTaskButton.clickOnElement();
  }

  public void addProjectWithFirstUserAsParticipant(String projectName, String participant) {
    addProjectOrTask.clickOnElement();
    projectTitle.setTextValue(projectName);
    addProjectParticipantInput(participant);
    saveButton.clickOnElement();
  }

  public void clickDeleteProjectButton()  {
    deleteProjectButton.clickOnElement();
  }

  public void clickDelete() {
    deleteButton.clickOnElement();
  }

  public void clickCancel() {
    cancelButton.clickOnElement();
  }
}
