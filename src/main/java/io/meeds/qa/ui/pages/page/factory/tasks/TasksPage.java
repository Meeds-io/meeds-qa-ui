package io.meeds.qa.ui.pages.page.factory.tasks;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;

public class TasksPage extends GenericPage {

  @FindBy(xpath = "//*[@class='v-label theme--light'and text()='Assignee']")
  private static BaseElementFacade assigneeRadioButton;

  @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab--active') and @aria-selected='true']")
  private BaseElementFacade        activeTabFilterDrawer;

  @FindBy(xpath = "//div[@id='attachmentIntegration']//button[contains(@class,'v-btn v-btn--flat')]")
  private BaseElementFacade        addAttachmentLink;

  @FindBy(xpath = "//*[@class='editManager']//*[@class='editManager']//i[contains(@class,'uiIconProject')]")
  private TextBoxElementFacade     addManagerBtn;

  @FindBy(xpath = "//*[@class='ViewAllCommentText']")
  private BaseElementFacade        addNewCommentInTask;

  @FindBy(xpath = "//button[contains(@class,'addCommentBtn')]")
  private BaseElementFacade        addOtherCommentInTask;

  @FindBy(xpath = "//*[@class='editParticipant']//i[@class='fas fa-plus']")
  private TextBoxElementFacade     addParticipantBtn;

  @FindBy(xpath = "//*[contains(@class, 'tasksToolbar')]//button[contains(@class, 'btn-primary')]")
  private BaseElementFacade        addProjectOrTask;

  @FindBy(xpath = "(//*[contains(@class,'uiIcon uiIconRotateRight')])[2]")
  private BaseElementFacade        addStatusafteroption;

  @FindBy(xpath = "(//*[contains(@class,'uiIconRotateLeft')])[1]")
  private BaseElementFacade        addStatusBeforeoption;

  @FindBy(css = ".tasksViewBoardRowContainer .tasksViewHeader .uiIconSocSimplePlus")
  private BaseElementFacade        addTaskInProjectButton;

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
  private BaseElementFacade        arrowBackButton;

  @FindBy(xpath = "//*[@class='uiIcon uiBackIcon']")
  private BaseElementFacade        backButtonProject;

  @FindBy(xpath = "//*[@class='uiIcon uiArrowBAckIcon']")
  private BaseElementFacade        backDrawer;

  @FindBy(xpath = "//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Cancel')][1]")
  private BaseElementFacade        cancelFilterButton;

  @FindBy(xpath = "//a[@title='Change location']")
  private BaseElementFacade        changeLocationLink;

  @FindBy(xpath = "//*[@class='ps-2' and text()='Changes']")
  private BaseElementFacade        checkChangesDrawer;

  @FindBy(xpath = "//*[contains(text(),'Edit task')]")
  private BaseElementFacade        checkEditTaskDrawer;

  @FindBy(xpath = "//*[@class='cke_wysiwyg_frame cke_reset']")
  private BaseElementFacade        ckEditorFrameDescription;

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade        ckEditorFrameTask;

  @FindBy(xpath = "(//iframe[contains(@class,'cke_wysiwyg_frame')])[2]")
  private BaseElementFacade        ckEditorFrameTaskMentioningUser;

  @FindBy(xpath = "//*[@id='ProjectListToolbar']//button[contains(@class,' mdi-close theme')]")
  private TextBoxElementFacade     clearButtonInFilterByProject;

  @FindBy(xpath = "//*[@id='TasksListToolbar']//button[contains(@class,' mdi-close theme')]")
  private TextBoxElementFacade     clearButtonInFilterByTask;

  @FindBy(xpath = "//*[contains (@class, 'uiIconCloneNode')]")
  private BaseElementFacade        cloneoption;

  @FindBy(xpath = "//*[contains(@class,'uiIconCloneNode ')]")
  private BaseElementFacade        cloneProjectButton;

  @FindBy(xpath = "//*[contains(@class,'projectColorPicker')]")
  private BaseElementFacade        colorPalette;

  @FindBy(xpath = "//*[contains(@class,'v-list-item__content drawerTitle')]//span[contains(text(),'Comments')]")
  private BaseElementFacade        commentsDrawerSection;

  @FindBy(xpath = "//*[contains(@class,'newCommentEditor')]//button")
  private BaseElementFacade        commentTaskButton;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed') and contains(text(),\"Please don't exceed 1250 characters\")]")
  private TextBoxElementFacade     commentTaskMaxCharsMsg;

  @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
  private BaseElementFacade        confirmationPopupCloneButton;

  @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
  private BaseElementFacade        confirmationPopupDeleteButton;

  @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  private BaseElementFacade        confirmButtonDrawer;

  @FindBy(xpath = "//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Confirm')]")
  private BaseElementFacade        confirmFilterButton;

  @FindBy(xpath = "//*[contains(@class,'uiIconTrash ')]")
  private BaseElementFacade        deleteProjectButton;

  @FindBy(xpath = "//*[contains(@class,'uiIconDelete')]")
  private BaseElementFacade        deleteStatusIcon;

  @FindBy(xpath = "//*[contains(@class,'uiIconTrash ')]")
  private BaseElementFacade        deleteTaskOption;

  @FindBy(xpath = "//*[contains(@class ,'flex document-timeline-header ')]//button[contains(@class,'v-btn v-btn--flat')]")
  private BaseElementFacade        documentButton;

  @FindBy(xpath = "//span[contains(text(),'Select Folder')]")
  private BaseElementFacade        drawerTitle;

  @FindBy(xpath = "//i[contains(@class,'uiIconEcmsOnlyOfficeOpen ')]")
  private BaseElementFacade        editIcon;

  @FindBy(xpath = "//*[contains(@class,'uiIconEdit ')]")
  private BaseElementFacade        editProjectButton;

  @FindBy(xpath = "//*[contains(@class,'drawerTitle') and contains(text(),'Edit Project')]")
  private TextBoxElementFacade     editProjectDrawer;

  @FindBy(xpath = "//*[@class='drawerTitleAndProject d-flex']//span[contains(text(),'Edit task')]")
  private BaseElementFacade        editTaskDrawerSection;

  @FindBy(xpath = "//*[@id='task-Drawer']//*[@id='task-name']")
  private BaseElementFacade        ELEMENT_DRAWER_TASK_NAME;

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
  private BaseElementFacade        fifthColumnThreeDotsIcon;

  @FindBy(xpath = "//button[contains(@class,'filterTasksSetting v-btn')]")
  private BaseElementFacade        filterButton;

  @FindBy(xpath = "//input[@placeholder='Filter by project']")
  private TextBoxElementFacade     filterByProject;

  @FindBy(xpath = "//input[@placeholder='Filter by task']")
  private TextBoxElementFacade     filterByTask;

  @FindBy(xpath = "//button[contains(@class,'filterTasksSetting')]//span[contains(@class,'d-sm-inline')]")
  private BaseElementFacade        filterDrawerButton;

  @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Filter')]")
  private BaseElementFacade        filterTab;

  @FindBy(xpath = "(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[1]")
  private BaseElementFacade        firstNotificationContent;

  @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[1]")
  private BaseElementFacade        firstStatusColumn;

  @FindBy(xpath = "//div[@class='drawerTitle']/button[@type='button']")
  private BaseElementFacade        goBackIcon;

  @FindBy(xpath = "//*[@class='uiIcon uiArrowBAckIcon']")
  private BaseElementFacade        goBackToTaskDrawerFromComments;

  @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Group and Sort')]")
  private BaseElementFacade        groupAndSortTab;

  @FindBy(xpath = "//*[@class='uiIconMessageLength']")
  private BaseElementFacade        informationIcon;

  @FindBy(xpath = "//*[@class='editManager']//input[@content-class='identitySuggesterContent']")
  private TextBoxElementFacade     inviteProjectManagerInput;

  @FindBy(xpath = "//*[@class='editParticipant']//input[@content-class='identitySuggesterContent']")
  private TextBoxElementFacade     inviteProjectParticipantInput;

  @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Labels')]")
  private BaseElementFacade        labelsTab;

  @FindBy(xpath = "//*[@id='labelInput']")
  private TextBoxElementFacade     labelTask;

  @FindBy(xpath = "(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[4]")
  private BaseElementFacade        lastColumnThreeDotsIcon;

  @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[4]")
  private BaseElementFacade        lastStatusColumn;

  @FindBy(xpath = "//*[@class='tasksListItem']//*[@class='taskCheckBox']")
  private BaseElementFacade        markTaskCompleted;

  @FindBy(xpath = "//button[@id='check_btn']")
  private BaseElementFacade        markTaskCompletedInDrawer;

  @FindBy(xpath = "//*[contains(@class,'taskViewCard')]//*[@class='taskCheckBox']")
  private BaseElementFacade        markTaskCompletedOnTaskCard;

  @FindBy(xpath = "//*[@class='activityCharsCount' and contains(text(),'0 / 1250')]")
  private BaseElementFacade        maxCharsCountInfo;

  @FindBy(xpath = "//*[@class='activityCharsCount tooManyChars']")
  private BaseElementFacade        more1250CharsCountInfo;

  @FindBy(xpath = "//*[contains(@class,'uiIconArrowRight ')]")
  private BaseElementFacade        moveStatusAfterIcon;

  @FindBy(xpath = "//*[contains(@class,'uiIconArrowLeft ')]")
  private BaseElementFacade        moveStatusBeforeIcon;

  @FindBy(xpath = "//a[@class='taskTabGantt v-tab']")
  private BaseElementFacade        planView;

  @FindBy(xpath = "(//*[@title='Add Task'])[1]")
  private BaseElementFacade        plusButtonToAddTask;

  @FindBy(xpath = "(//*[@title='Add Task'])[6]")
  private BaseElementFacade        PlusButtonToAddTaskOfTheSixthStatusColumn;

  @FindBy(xpath = "(//div[@class='pe-0 v-list-item theme--light']//button[@type='button'])[7]")
  private BaseElementFacade        plusIcon;

  @FindBy(xpath = "(//div[contains(@class,'v-list-item__action drawerIcons')]//button)[7]")
  private BaseElementFacade        plusIconProject;

  @FindBy(xpath = "//div[@class='bar']")
  private TextBoxElementFacade     progressDownloadBar;

  @FindBy(xpath = "//*[@class='taskTabBoard v-tab v-tab--active']")
  private BaseElementFacade        projectActiveBoardView;

  @FindBy(
      xpath = "(//*[contains(@class,'profile-popover')]//a[contains(@id,'userAvatar')]/following::div[contains(@class,'ms-2')])[2]"
  )
  private BaseElementFacade        projectCardUserFullName;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade     projectDescriptionField;

  @FindBy(xpath = "//*[@class='uiIcon uiIconList']")
  private BaseElementFacade        projectDetailsListButton;

  @FindBy(xpath = "//*[contains(@class,'uiIconVerticalDots')]")
  private BaseElementFacade        projectThreeDotsButton;

  @FindBy(xpath = "//*[@placeholder='Project title']")
  private TextBoxElementFacade     projectTitle;

  @FindBy(xpath = "//*[contains(@class,'addProjectTitle ')]//input")
  private TextBoxElementFacade     projectTitleInput;

  @FindBy(css = "button.quickAddNewTaskButton")
  private BaseElementFacade        quickAddTaskInProjectButton;

  @FindBy(xpath = "//*[contains(@class,'editorContent commentEditorContainer')]//button")
  private BaseElementFacade        replyTaskCommentButton;

  @FindBy(xpath = "//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Reset')]")
  private BaseElementFacade        resetFilterButton;

  @FindBy(xpath = "//*[@class='d-flex']//button[2]")
  private BaseElementFacade        saveButton;

  @FindBy(xpath = "(//*[@class='d-flex']//button[2])[2]")
  private BaseElementFacade        saveButtonTask;

  @FindBy(xpath = "(//*[@class='d-flex']//button[2])")
  private BaseElementFacade        saveButtonTaskSpaceProject;

  @FindBy(xpath = "//*[contains(@class, 'v-navigation-drawer--open')]//button[@id='saveDescriptionButton']")
  private BaseElementFacade        saveDescriptionButton;

  @FindBy(xpath = "//div[@id='projectBoardToolbar']//input")
  private TextBoxElementFacade     searchProjectInput;

  @FindBy(xpath = "//*[@class='v-toolbar__content']//*[@placeholder='Filter by name or description']")
  private TextBoxElementFacade     searchSpaceInput;

  @FindBy(xpath = "//*[@id='TasksListToolbar']//*[@class='v-text-field__slot']//input")
  private BaseElementFacade        searchTaskName;

  @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[2]")
  private BaseElementFacade        secondStatusColumn;

  @FindBy(xpath = "//*[@role='button']//*[@class='v-input__icon v-input__icon--append']")
  private BaseElementFacade        selectStatusSelector;

  @FindBy(xpath = "//*[contains(@class,'cke_editable cke_editabl')]")
  private TextBoxElementFacade     settaskDescription;

  @FindBy(xpath = "//*[@placeholder='Display name']")
  private TextBoxElementFacade     spaceNameTitle;

  @FindBy(xpath = "//*[@placeholder='Enter a name for this status']")
  private BaseElementFacade        statusField;

  @FindBy(xpath = "//*[contains(@class,'drawerParent attachmentsListDrawer')]/following::*[@class='v-alert__content'][1]//span")
  private TextBoxElementFacade     successMessage;

  @FindBy(xpath = "(//iframe[contains(@class,'cke_wysiwyg_frame')])[2]")
  private BaseElementFacade        switchToFrameTask;

  @FindBy(xpath = "(//iframe[contains(@class,'cke_wysiwyg_frame')])")
  private BaseElementFacade        switchToFrameTaskUser;

  @FindBy(xpath = "(//*[@class='taskAssignBtn mt-n1'])")
  private BaseElementFacade        taskAssignLink;

  @FindBy(xpath = "(//*[@class='ms-4'])[1]")
  private BaseElementFacade        taskAssignMe;

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
  private BaseElementFacade        taskPrioritySelector;

  @FindBy(xpath = "//*[contains(@class, 'task-name')]//input")
  private TextBoxElementFacade     taskQuickNameField;

  @FindBy(xpath = "//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following::*[@class='taskTitleEllipsis']")
  private BaseElementFacade        tasksNameToDo;

  @FindBy(xpath = "//*[contains(@class,'uiThreeDotsIcon')]")
  private BaseElementFacade        taskThreeDotsOption;

  @FindBy(css = "#TasksManagementPortlet .taskCard .taskTitleId .taskTitle")
  private BaseElementFacade        taskTooltip;

  @FindBy(xpath = "//*[@class='nameGroup' and contains (text(), 'Unassigned')]")
  private BaseElementFacade        textAssignee;

  @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[3]")
  private BaseElementFacade        thirdStatusColumn;

  @FindBy(xpath = "(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[1]")
  private BaseElementFacade        threeDotsIcon;

  @FindBy(xpath = "//*[contains(@class,'uiThreeDotsIcon')]")
  private BaseElementFacade        threeDotsIconInEditTask;

  @FindBy(xpath = "//*[@class='pe-2' and contains(text(),'Last Update')]")
  private BaseElementFacade        timesTamp;

  @FindBy(xpath = "//*[@placeholder='Enter a title for this task']")
  private BaseElementFacade        titleForTaskField;

  @FindBy(xpath = "//*[@class='lastUpdatedTask pb-3']")
  private BaseElementFacade        toolTip;

  @FindBy(xpath = "//*[@id='saveDescriptionButton']")
  private BaseElementFacade        updateButtonDescription;

  @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
  private BaseElementFacade        updateNameSpaceButton;

  @FindBy(xpath = " //*[contains(@class,'uiIcon40x40TickBlue')]")
  private BaseElementFacade        validateStatusName;

  @FindBy(xpath = "//*[@class='ViewAllCommentLabel']")
  private BaseElementFacade        viewAllCommentsTaskButton;

  @FindBy(
      xpath = "//div[@class='attachmentsList']//a[@class='viewAllAttachments primary--text font-weight-bold text-decoration-underline']"
  )
  private BaseElementFacade        viewAttachmentsLink;

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

  @SwitchToWindow
  public void addNewCommentInTaskWithMentioningTheFirstUserInTask(String comment, String user) {
    mentionUserInCKEditor(ckEditorFrameTaskMentioningUser, taskCommentContentTextBox, comment, user, true);
    commentTaskButton.waitUntilVisible();
    commentTaskButton.clickOnElement();
    goBackToTaskDrawerFromComments.waitUntilVisible();
    goBackToTaskDrawerFromComments.clickOnElement();
    closeDrawer();
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

  @SwitchToWindow
  public void addProjectManagerInput(String manager) {
    addManagerBtn.clickOnElement();
    mentionInField(inviteProjectManagerInput, manager, 5);
  }

  @SwitchToWindow
  public void addProjectParticipantInput(String participant) {
    addParticipantBtn.clickOnElement();
    mentionInField(inviteProjectParticipantInput, participant, 5);
  }

  @SwitchToWindow
  public void addProjectWithDescription(String projectName, String description) {
    addProjectOrTask.clickOnElement();
    projectTitle.setTextValue(projectName);

    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameTask);
    try {
      projectDescriptionField.waitUntilVisible();
      projectDescriptionField.setTextValue(description);
    } finally {
      driver.switchTo().defaultContent();
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

  @SwitchToWindow
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

  @SwitchToWindow
  public void checkUpdatedDescription(String Description) {
    taskDescriptionField.clickOnElement();

    waitCKEditorLoading();
    ckEditorFrameDescription.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameDescription);
    try {
      assertEquals(settaskDescription.getText(), Description);
    } finally {
      driver.switchTo().defaultContent();
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
    BaseElementFacade addTaskButton = findByXPathOrCSS(".tasksToolbar button.btn-primary");
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

  public void closeEditTaskDrawer() {
    closeDrawer();
  }

  public void closeEditTaskDrawerSimpleProject() {
    closeDrawer();
  }

  public void closeProjectDrawer() {
    closeDrawer();
  }

  public void closeSortAndFilterDrawer() {
    closeDrawer();
  }

  public void closeTaskCommentsDrawer() {
    goBackToTaskDrawerFromComments.waitUntilVisible();
    goBackToTaskDrawerFromComments.clickOnElement();
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

  @SwitchToWindow
  public void commentTask(String comment) {
    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameTask);
    try {
      taskCommentContentTextBox.waitUntilVisible();
      taskCommentContentTextBox.setTextValue(comment);
    } finally {
      driver.switchTo().defaultContent();
    }

    commentTaskButton.waitUntilVisible();
    commentTaskButton.clickOnElement();
    goBackToTaskDrawerFromComments.waitUntilVisible();
    goBackToTaskDrawerFromComments.clickOnElement();
    closeDrawer();
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
    assertWebElementNotVisible(confirmationPopupDeleteButton);
  }

  public void confirmFilter() {
    confirmFilterButton.clickOnElement();
  }

  public void confirmFilterButtonIsDisplayed() {
    assertWebElementVisible(confirmFilterButton);
  }

  public void deleteCookies() {
    driver.manage().deleteAllCookies();
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

  @SwitchToWindow
  public void editDescriptionForTask(String newDescription) {
    taskDescriptionField.clickOnElement();

    waitCKEditorLoading();
    switchToFrameTaskUser.waitUntilVisible();
    driver.switchTo().frame(switchToFrameTaskUser);
    try {
      taskDescriptionBodyField.waitUntilVisible();
      taskDescriptionBodyField.setTextValue(newDescription);
    } finally {
      driver.switchTo().defaultContent();
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

  @SwitchToWindow
  public void editProjectNameWithDescription(String projectName, String newProjectName, String newDescription) {
    assertWebElementVisible(getProjectCard(projectName));
    projectThreeDotsButton.clickOnElement();
    editProjectButton.clickOnElement();
    projectTitle.setTextValue(newProjectName);

    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameTask);
    try {
      projectDescriptionField.waitUntilVisible();
      projectDescriptionField.setTextValue(newDescription);
    } finally {
      driver.switchTo().defaultContent();
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

  @SwitchToWindow
  public void enterDescriptionForTask(String description) {
    taskDescriptionField.clickOnElement();

    waitCKEditorLoading();
    switchToFrameTask.waitUntilVisible();
    driver.switchTo().frame(switchToFrameTask);
    try {
      taskDescriptionBodyField.waitUntilVisible();
      taskDescriptionBodyField.setTextValue(description);
    } finally {
      driver.switchTo().defaultContent();
    }
  }

  public void enterLabelTask(String label) {
    labelTask.setTextValue(label);
    labelTask.sendKeys(Keys.ENTER);
  }

  @SwitchToWindow
  public void enterProjectDescriptionWithoutTheTitle(String description) {
    addProjectOrTask.clickOnElement();

    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameTask);
    try {
      projectDescriptionField.waitUntilVisible();
      projectDescriptionField.setTextValue(description);
    } finally {
      driver.switchTo().defaultContent();
    }

  }

  @SwitchToWindow
  public void enterProjectTitleAndDescription(String projectName, String description) {
    addProjectOrTask.clickOnElement();
    projectTitle.setTextValue(projectName);

    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameTask);
    try {
      projectDescriptionField.waitUntilVisible();
      projectDescriptionField.setTextValue(description);
    } finally {
      driver.switchTo().defaultContent();
    }

  }

  public void enterStatusText(String status) {
    statusField.sendKeys(status);
  }

  @SwitchToWindow
  public void enterTaskComment(String comment) {
    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameTask);
    try {
      taskCommentContentTextBox.waitUntilVisible();
      taskCommentContentTextBox.setTextValue(comment);
    } finally {
      driver.switchTo().defaultContent();
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

  private BaseElementFacade getAddLabelToTask(String label) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-list')]//*[contains(text(), '%s')]//ancestor::*[contains(@class,'v-chip')]",
                                          label));
  }

  private BaseElementFacade getAttachmentName(String attachmentName) {
    return findByXPathOrCSS(
                            String.format("(//div[@class='v-list-item__content']//div[@title='%s'])[2]", attachmentName));
  }

  private BaseElementFacade getCompletedTask(String taskName) {
    return findByXPathOrCSS(String.format("//*[@class='nameGroup' and text()='Archived']//following::*[@class='taskCardViewTitle text-color strikethrough']//span[@class='taskTitleEllipsis' and contains(text(),'%s')]",
                                          taskName));
  }

  private BaseElementFacade getDescriptionForTask(String description) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'taskDescription')]//*[contains(text(), '%s')]",
                                          description));
  }

  private BaseElementFacade getDisplayedLabel(String label, String times) {
    return findByXPathOrCSS(
                            String.format("//*[@class='nameGroup' and contains(text(),'%s')]//following::*[@class='amount-item' and contains(text(),'%s')][1]",
                                          label,
                                          times));
  }

  private BaseElementFacade getFilterOption(String option) {
    return findByXPathOrCSS(String.format("//*[@class='v-label theme--light' and text()='%s']", option));
  }

  private BaseElementFacade getLabelInEditProjectDrawer(String label) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'projectLabelsName')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-chip')]",
                                          label));
  }

  private BaseElementFacade getLabelInEditTaskDrawer(String label) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-chip')]",
                                          label));
  }

  private BaseElementFacade getProjectCard(String projectName) {
    return findByXPathOrCSS(
                            String.format("//span[contains(@class,'projectCardTitle') and contains(text(),'%s')]", projectName));
  }

  private BaseElementFacade getProjectCardDescription(String description) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@class, 'taskItemDescription')]//*[contains(text(),'%s')]",
                                          description));
  }

  private BaseElementFacade getProjectCardUserAvatar(String userName) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@id,'userAvatar') and contains(@href,'%s')]", userName));
  }

  private BaseElementFacade getRemoveLabelButton(String label) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'projectLabelsName')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-chip')]//button[contains(text(), 'close')]",
                                          label));
  }

  private BaseElementFacade getRemoveLabelTaskButton(String label) {
    return findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(text(),'%s')]//ancestor::*[contains(@class, 'v-chip')]//button",
                                          label));
  }

  private BaseElementFacade getStatusColumn(String statusColumn) {
    return findByXPathOrCSS(String.format("(//*[@class='d-flex tasksViewHeaderLeft']//*[contains(text(),'%s')][1])[1]",
                                          statusColumn));
  }

  private BaseElementFacade getTaskAlert(String message) {
    return findByXPathOrCSS(
                            String.format("//*[@class='v-alert__content' and contains(text(),'%s')]", message));
  }

  private BaseElementFacade getTaskCommentReplyBtn(String comment) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@class,'taskCommentDrawer')]//*[@class='taskContentComment']/p[contains(text(),'%s')]/following::button[@id='reply_btn'][1]",
                                          comment));
  }

  private BaseElementFacade getTaskCommentWithUser(String user, String comment) {
    return findByXPathOrCSS(String.format("//*[@class='TaskCommentContent']//*[contains(text(),'%s')]/following::*[@class='taskContentComment']//p[contains(text(),'%s')]",
                                          user,
                                          comment));
  }

  private BaseElementFacade getTaskName(String taskName) {
    BaseElementFacade taskInListView =
                                     findByXPathOrCSS(String.format("//*[contains(@class, 'v-window-item--active')]//*[contains(@class, 'taskListItemView ')]/*[contains(@class, 'taskTitle ')]//*[contains(text(), '%s')]",
                                                                    taskName));
    if (taskInListView.isCurrentlyVisible()) {
      return taskInListView;
    } else {
      return findByXPathOrCSS(String.format("//*[contains(@class, 'v-window-item--active')]//*[contains(@class, 'taskViewCard ')]//*[contains(text(), '%s')]",
                                            taskName));
    }
  }

  private BaseElementFacade getTaskNamePlanView(String taskName) {
    return findByXPathOrCSS(String.format(
                                          "//*[@class='bar-group']//*[contains(text(),'%s')]",
                                          taskName));
  }

  private BaseElementFacade getTaskOrder(String number) {
    return findByXPathOrCSS(
                            String.format("(//*[@id='projectListApplication']//*[contains(@id,'taskView')]//*[contains(@class,'taskTitle')]//a)[%s]",
                                          number));
  }

  private BaseElementFacade getTaskPriority(String taskPriority) {
    return findByXPathOrCSS(
                            String.format("//*[@class='taskPriority']//*[@class='v-select__selections']/div[contains(text(),'%s')]",
                                          taskPriority));
  }

  private BaseElementFacade getTasksNumberToDo(String tasksNumber) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following ::*[@class='uiTaskNumber' and text()='%s']",
                                          tasksNumber));
  }

  private BaseElementFacade getTaskStatus(String taskStatus) {
    return findByXPathOrCSS(
                            String.format("//*[@class='taskStatus']//*[contains(@class,'v-select__selection--comma') and contains(text(),'%s')]",
                                          taskStatus));
  }

  private BaseElementFacade getTaskStatusColumn(String status) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'taskStatusName')]//*[@title='%s']/following::*[@class='taskTitleEllipsis'])[1]",
                                          status));
  }

  private BaseElementFacade getTaskTitle(String taskName) {
    return findByXPathOrCSS(
                            String.format("//span[contains(@class,'taskTitleEllipsis') and contains(text(),'%s')]", taskName));
  }

  private BaseElementFacade getTaskTitleInTasksTab(String taskName) {
    return findByXPathOrCSS(
                            String.format("//*[contains(@class,'v-application tasksList')]//*[contains(@class,'taskTitle pe-14')]/a[contains(text(),'%s')]",
                                          taskName));
  }

  private BaseElementFacade getTaskToMarkAsCompleted(String taskName) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'taskCard')]//*[contains(@class, 'uiIconCircle')]",
                                          taskName));
  }

  private BaseElementFacade getUncompletedTask(String taskName) {
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

  public void goToTab(String tab) {
    BaseElementFacade tabLink =
                              findByXPathOrCSS(String.format("//*[contains(@class, 'tasksMenuParent')]//a[contains(text(), '%s')]",
                                                             tab));
    clickOnElement(tabLink);
    verifyPageLoaded();
    waitFor(300).milliseconds(); // Wait for Tab switch
  }

  public void greenInformationIconIsDisplayed() {
    assertWebElementVisible(informationIcon);
    Assert.assertEquals(informationIcon.getCssValue("color"), "rgba(46, 181, 140, 1)");
  }

  public void hoverOnProjectManagerIcon() {
    projectCardUserFullName.hover("//div[@style='height: 28px; min-width: 28px; width: 28px;']//img[contains(@src,'/portal/rest/v1/social/users/default-image/avatar')]");
  }

  public void hoverOnTaskName(String task) {
    taskNameInProjectDetails(task).hover();
  }

  public void hoverOnTheChangesTimestamp() {
    Actions actions = new Actions(driver);
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

  @SwitchToWindow
  public void maxCharsNumberMessageIsDisplayed() {
    commentsDrawerSection.clickOnElement();

    waitCKEditorLoading();
    ckEditorFrameTask.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameTask);
    try {
      assertWebElementVisible(commentTaskMaxCharsMsg);
    } finally {
      driver.switchTo().defaultContent();
    }

  }

  public void more1250CharsInformationIsDisplayed() {
    assertWebElementVisible(more1250CharsCountInfo);
    Assert.assertEquals(more1250CharsCountInfo.getCssValue("color"), "rgba(188, 67, 67, 1)");
  }

  public void openFilterDrawer() {
    driver.navigate().refresh();
    filterDrawerButton.waitUntilVisible();
    filterDrawerButton.clickOnElement();
  }

  public void openProject(String project) {
    getProjectCard(project).clickOnElement();
  }

  private BaseElementFacade openTask(String projectName) {
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

  private BaseElementFacade projectNameInProjectDetails(String projectName) {
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

  private BaseElementFacade selectTaskPriority(String taskPriority) {
    return findByXPathOrCSS(
                            String.format("//*[@class='body-2' and contains(text(),'%s')]", taskPriority));
  }

  private BaseElementFacade selectTaskStatus(String taskStatus) {
    return findByXPathOrCSS(
                            String.format("//*[@role='listbox']//*[@class='v-list-item__title' and contains(text(),'%s')]",
                                          taskStatus));
  }

  public void setInSearchProjectField(String project) {
    searchProjectInput.setTextValue(project);
    waitFor(1).seconds();
    verifyPageLoaded();
  }

  public void setInSearchSpaceField(String space) {
    searchSpaceInput.setTextValue(space);
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
    closeDrawer();
  }

  public void setTaskCompletedInDrawerWithoutClosingIt() {
    markTaskCompletedInDrawer.clickOnElement();
  }

  @SwitchToWindow
  public void setTaskDescription(String Description) {
    taskDescriptionField.clickOnElement();

    waitCKEditorLoading();
    ckEditorFrameDescription.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameDescription);
    try {
      settaskDescription.sendKeys(Description);
    } finally {
      driver.switchTo().defaultContent();
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

  private BaseElementFacade taskNameAndLabelAndNumberInProjectDetails(String taskName) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following::*[@class='taskTitleEllipsis' and contains(text(),'%s')]/following::*[contains(@class,'taskLabels')]//span[@class='text-truncate'])[1]",
                                          taskName));
  }

  public void taskNameAndLabelIsDisplayedInProjectDetails(String label, String taskName) {
    Assert.assertTrue(taskNameAndLabelAndNumberInProjectDetails(taskName).getText().contains(label));
  }

  private BaseElementFacade taskNameInProjectDetails(String taskName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'taskTitle')]//*[@title = '%s']",
                                          taskName));
  }

  public void taskNameIsDisplayedInDesiredColumn(String status, String taskName) {
    Assert.assertTrue(getTaskStatusColumn(status).getText().contains(taskName));
  }

  public void taskNameIsDisplayedInProjectDetails(String taskName) {
    BaseElementFacade taskElement = taskNameInProjectDetails(taskName);
    assertWebElementVisible(taskElement);
    Assert.assertEquals(taskElement.getText(), taskName);
  }

  public void taskNameIsNotDisplayedInProjectDetails(String taskName) {
    BaseElementFacade taskElement = taskNameInProjectDetails(taskName);
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

  @SwitchToWindow
  public void updateTaskDescription(String description) {
    taskDescriptionField.clickOnElement();

    waitCKEditorLoading();
    ckEditorFrameDescription.waitUntilVisible();
    driver.switchTo().frame(ckEditorFrameDescription);
    try {
      settaskDescription.sendKeys(" " + description);
    } finally {
      driver.switchTo().defaultContent();
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
}
