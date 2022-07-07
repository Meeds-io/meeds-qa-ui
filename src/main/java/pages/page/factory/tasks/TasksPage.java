package pages.page.factory.tasks;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class TasksPage extends GenericPage {
    public TasksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//*[@id='TasksListToolbar']//button)[1]")
    private BaseElementFacade addTaskButton;

    @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
    private BaseElementFacade ckEditorFrameTask;

    @FindBy(xpath = "(//iframe[contains(@class,'cke_wysiwyg_frame')])[2]")
    private BaseElementFacade ckEditorFrameTaskMentioningUser;

    @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
    private TextBoxElementFacade taskDescriptionFieldIframe;

    @FindBy(xpath = "(//iframe[contains(@class,'cke_wysiwyg_frame')])[2]")
    private BaseElementFacade switchToFrameTask;

    @FindBy(xpath = "(//iframe[contains(@class,'cke_wysiwyg_frame')])")
    private BaseElementFacade switchToFrameTaskUser;

    @FindBy(xpath = "//*[@class='taskTabBoard v-tab v-tab--active']")
    private BaseElementFacade projectActiveBoardView;

    @FindBy(xpath = "(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconSocSimplePlus')][1])[1]")
    private BaseElementFacade addTaskInProjectButton;

    @org.openqa.selenium.support.FindBy(xpath = "//div[@id='projectBoardToolbar']//input")
    private TextBoxElementFacade searchProjectInput;

    @FindBy(xpath = "//*[@class='taskTitleAndMark d-flex']//textarea")
    private TextBoxElementFacade taskNameField;

    @FindBy(xpath = "//*[@id='taskDescriptionId']")
    private TextBoxElementFacade taskDescriptionField;

    @FindBy(xpath = "//*[contains(@class,'cke_editable cke_editabl')]")
    private TextBoxElementFacade settaskDescription;

    @FindBy(xpath = "//*[@class='cke_wysiwyg_frame cke_reset']")
    private BaseElementFacade ckEditorFrameDescription;

    @FindBy(xpath = "(//*[@class='d-flex']//button[2])")
    private BaseElementFacade SaveButtonTaskSpaceProject;

    @FindBy(xpath = "//*[@id='saveDescriptionButton']")
    private BaseElementFacade upDateButtonDescription;

    @FindBy(xpath = "//*[contains(@class,'uiThreeDotsIcon')]")
    private BaseElementFacade threeDotsIconInEditTask;

    @FindBy(xpath = "//*[contains (@class, 'uiIconCloneNode')]")
    private BaseElementFacade cloneoption;

    @FindBy(xpath = "//*[contains(@class,'taskCompleted')]//textarea")
    private TextBoxElementFacade taskMarkedAsCompletedInDrawer;

    @FindBy(xpath = "//*[@class='d-flex']//button[2]")
    private BaseElementFacade saveAddingTaskButton;

    @FindBy(xpath = "//*[@class='uiIcon uiIconPlus']")
    private BaseElementFacade addProject;

    @FindBy(xpath = "//*[@id='labelInput']")
    private TextBoxElementFacade labelTask;

    @FindBy(xpath = "//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Confirm')]")
    private BaseElementFacade confirmFilterButton;

    @FindBy(css = "#TasksManagementPortlet .taskCard .taskTitleId .taskTitle")
    private BaseElementFacade taskTooltip;

    @FindBy(xpath = "//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Cancel')][1]")
    private BaseElementFacade cancelFilterButton;

    @FindBy(xpath = "//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Reset')]")
    private BaseElementFacade resetFilterButton;

    @FindBy(xpath = "//button[@id='check_btn']")
    private BaseElementFacade markTaskCompletedInDrawer;

    @FindBy(xpath = "//*[contains(@class,'uiIconVerticalDots')]")
    private BaseElementFacade projectThreeDotsButton;

    @FindBy(xpath = "//*[contains(@class,'uiIconEdit ')]")
    private BaseElementFacade editProjectButton;

    @FindBy(xpath = "//*[@placeholder='Project title']")
    private TextBoxElementFacade projectTitle;

    @FindBy(xpath = "//*[@class='editParticipant']//i[@class='fas fa-plus']")
    private TextBoxElementFacade addParticipantBtn;

    @FindBy(xpath = "//*[@class='editManager']//*[@class='editManager']//i[contains(@class,'uiIconProject')]")
    private TextBoxElementFacade addManagerBtn;

    @FindBy(xpath = "//*[@class='editParticipant']//input[@content-class='identitySuggesterContent']")
    private TextBoxElementFacade inviteProjectParticipantInput;

    @FindBy(xpath = "//*[@class='editManager']//input[@content-class='identitySuggesterContent']")
    private TextBoxElementFacade inviteProjectManagerInput;

    @FindBy(xpath = "//*[@class='tasksListItem']//*[@class='taskCheckBox']")
    private BaseElementFacade markTaskCompleted;

    @FindBy(xpath = "//*[@id='task-Drawer']//*[@id='task-name']")
    private BaseElementFacade ELEMENT_DRAWER_TASK_NAME;

    @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
    private TextBoxElementFacade taskCommentContentTextBox;

    @FindBy(xpath = "//body[contains(@class,'cke_editable_themed') and contains(text(),\"Please don't exceed 1250 characters\")]")
    private TextBoxElementFacade commentTaskMaxCharsMsg;

    @FindBy(xpath = "//*[contains(@class,'newCommentEditor')]//button")
    private BaseElementFacade commentTaskButton;

    @FindBy(xpath = "//*[contains(@class,'editorContent commentEditorContainer')]//button")
    private BaseElementFacade replyTaskCommentButton;

    @FindBy(xpath = "//*[@class='activityCharsCount' and contains(text(),'0 / 1250')]")
    private BaseElementFacade maxCharsCountInfo;

    @FindBy(xpath = "//*[@class='activityCharsCount tooManyChars']")
    private BaseElementFacade more1250CharsCountInfo;

    @FindBy(xpath = "//*[@class='uiIconMessageLength']")
    private BaseElementFacade informationIcon;

    @FindBy(xpath = "//input[@placeholder='Filter by task']")
    private TextBoxElementFacade filterByTask;

    @FindBy(xpath = "//*[contains(@class,'drawerParent taskDrawer')]//*[@class='v-btn__content']//button")
    private BaseElementFacade closeTaskDrawerButton;

    @FindBy(xpath = "//*[@class='uiIcon uiArrowBAckIcon']")
    private BaseElementFacade goBackToTaskDrawerFromComments;

    @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab--active') and @aria-selected='true']")
    private BaseElementFacade activeTabFilterDrawer;

    @FindBy(xpath = "//*[@class='ViewAllCommentText']")
    private BaseElementFacade addNewCommentInTask;

    @FindBy(xpath = "//*[@class='v-btn__content']//button")
    private BaseElementFacade closeProjectDrawerBtn;

    @FindBy(xpath = "//button[contains(@class,'addCommentBtn')]")
    private BaseElementFacade addOtherCommentInTask;

    @FindBy(xpath = "//*[@class='ViewAllCommentLabel']")
    private BaseElementFacade viewAllCommentsTaskButton;

    @FindBy(xpath = "//*[@id='TasksListToolbar']//*[@class='v-text-field__slot']//input")
    private BaseElementFacade searchTaskName;

    @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
    private TextBoxElementFacade projectDescriptionField;

    @FindBy(xpath = "//*[contains(@class,'uiIconTrash ')]")
    private BaseElementFacade deleteProjectButton;

    @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
    private BaseElementFacade confirmationPopupDeleteButton;

    @FindBy(
            xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully created')]"
    )
    private TextBoxElementFacade alertMessageAfterProjectCreation;

    @FindBy(xpath = "//*[@placeholder='Display name']")
    private TextBoxElementFacade spaceNameTitle;

    @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
    private BaseElementFacade updateNameSpaceButton;

    @FindBy(
            xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully deleted')]"
    )
    private TextBoxElementFacade alertMessageAfterProjectDeletion;

    @FindBy(
            xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully updated')]"
    )
    private TextBoxElementFacade alertMessageAfterProjectUpdate;

    @FindBy(xpath = "//*[@class='uiIcon uiBackIcon']")
    private BaseElementFacade arrowBackButton;

    @FindBy(xpath = "//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following::*[@class='taskTitleEllipsis']")
    private BaseElementFacade tasksNameToDo;

    @FindBy(xpath = "//*[contains(@class,'drawerTitle') and contains(text(),'Edit Project')]")
    private TextBoxElementFacade editProjectDrawer;

    @FindBy(xpath = "//*[@class='ignore-vuetify-classes btn btn-primary me-2']")
    private BaseElementFacade confirmationPopupCloneButton;

    @FindBy(xpath = "//button[contains(@class,'filterTasksSetting')]//span[contains(@class,'d-sm-inline')]")
    private BaseElementFacade filterDrawerButton;

    @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Group and Sort')]")
    private BaseElementFacade groupAndSortTab;

    @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Labels')]")
    private BaseElementFacade labelsTab;

    @FindBy(xpath = "//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Filter')]")
    private BaseElementFacade filterTab;

    @FindBy(xpath = "//*[contains(@class,'uiIconCloneNode ')]")
    private BaseElementFacade cloneProjectButton;

    @FindBy(xpath = "//*[contains(@class,'projectColorPicker')]")
    private BaseElementFacade colorPalette;

    @FindBy(
            xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully cloned')]"
    )
    private TextBoxElementFacade alertMessageAfterProjectClone;

    @FindBy(
            xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Status successfully deleted')]"
    )
    private TextBoxElementFacade alertMessageAfterStatusDeletion;

    @FindBy(
            xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Status successfully moved')]"
    )
    private TextBoxElementFacade alertMessageAfterStatusMoved;

    @FindBy(
            xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Task successfully deleted')] "
    )
    private TextBoxElementFacade alertMessageAfterTaskDeleted;

    @FindBy(xpath = "(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[1]")
    private BaseElementFacade threeDotsIcon;

    @FindBy(xpath = "(//*[contains(@class,'uiIconRotateLeft')])[1]")
    private BaseElementFacade addStatusBeforeoption;

    @FindBy(xpath = "//*[@placeholder='Enter a name for this status']")
    private BaseElementFacade statusField;

    @FindBy(xpath = " //*[contains(@class,'uiIcon40x40TickBlue')]")
    private BaseElementFacade ValidateStatusName;

    @FindBy(xpath = "(//*[@title='Add Task'])[1]")
    private BaseElementFacade PlusButtonToAddTask;

    @FindBy(xpath = "//*[@placeholder='Enter a title for this task']")
    private BaseElementFacade TileForTaskField;

    @FindBy(xpath = "(//*[@class='d-flex']//button[2])[2]")
    private BaseElementFacade SaveButtonTask;

    private BaseElementFacade getTaskStatusColumn(String status) {
        return findByXpath(String.format("(//*[contains(@class,'taskStatusName')]//*[@title='%s']/following::*[@class='taskTitleEllipsis'])[1]",
                status));
    }

    @FindBy(xpath = "(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[5]")
    private BaseElementFacade fifthColumnThreeDotsIcon;

    @FindBy(xpath = "(//*[contains(@class,'uiIcon uiIconRotateRight')])[2]")
    private BaseElementFacade addStatusafteroption;

    @FindBy(xpath = "(//*[@title='Add Task'])[6]")
    private BaseElementFacade PlusButtonToAddTaskOfTheSixthStatusColumn;

    @FindBy(xpath = "//*[@class='uiIcon uiIconList']")
    private BaseElementFacade projectDetailsListButton;

    @FindBy(xpath = "//*[@class='drawerTitleAndProject d-flex']//span[contains(text(),'Edit task')]")
    private BaseElementFacade editTaskDrawerSection;

    @FindBy(xpath = "//*[contains(@class,'v-list-item__content drawerTitle')]//span[contains(text(),'Comments')]")
    private BaseElementFacade commentsDrawerSection;

    @FindBy(xpath = "//*[contains(@class,'uiIconDelete')]")
    private BaseElementFacade deleteStatusIcon;

    @FindBy(xpath = "//*[contains(@class,'uiIconArrowRight ')]")
    private BaseElementFacade moveStatusAfterIcon;

    @FindBy(xpath = "//*[contains(@class,'uiIconArrowLeft ')]")
    private BaseElementFacade moveStatusBeforeIcon;

    @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[2]")
    private BaseElementFacade secondStatusColumn;

    @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[1]")
    private BaseElementFacade firstStatusColumn;

    @FindBy(xpath = "(//*[@class='d-flex']//button[2])[2]")
    private BaseElementFacade saveAddingTaskSimpleProject;

    @FindBy(xpath = "(//div[@class='v-list-item__action drawerIcons align-end d-flex flex-row']//button[@title='Close'])[3]")
    private BaseElementFacade closeButtonDrawerSimpleProject;

    @FindBy(xpath = "(//div[@class='pe-0 v-list-item theme--light']//button[@type='button'])[7]")
    private BaseElementFacade plusIcon;

    @FindBy(xpath = "(//div[contains(@class,'v-list-item__action drawerIcons')]//button)[7]")
    private BaseElementFacade plusIconProject;

    @FindBy(xpath = "//i[contains(@class,'uiIconEcmsOnlyOfficeOpen ')]")
    private BaseElementFacade editIcon;

    @FindBy(xpath = "//div[@title='Detach file']")
    private BaseElementFacade detachIcon;

    @FindBy(xpath = "//div[@class='drawerTitle']/button[@type='button']")
    private BaseElementFacade goBackIcon;

    @FindBy(xpath = "//a[@title='Change location']")
    private BaseElementFacade changeLocationLink;

    @FindBy(xpath = "//span[contains(text(),'Select Folder')]")
    private BaseElementFacade drawerTitle;

    @FindBy(xpath = "//i[@class='uiIconFolder mr-1']")
    private BaseElementFacade driveIcon;

    @FindBy(xpath = "//button[@type='button']/span[contains(text(),'Select')] ")
    private BaseElementFacade selectButton;

    @FindBy(xpath = "(//div[@class='v-list-item__action drawerIcons align-end d-flex flex-row']//button[@title='Close'])[01]")
    private BaseElementFacade closeEditTaskDrawer;

    @FindBy(xpath = "(//div[@class='v-list-item__action drawerIcons align-end d-flex flex-row']//button[@title='Close'])[02]")
    private BaseElementFacade closeEditTaskDrawerSimpleProject;

    @FindBy(xpath = "//a[@id='driveAction']")
    private BaseElementFacade showDrives;

    private BaseElementFacade selectDriveName(String driveName) {
        return findByXpath(
                String.format("//div[@class='rowDrives rowDrivesGroups clearfix']//a[@data-original-title='%s']",
                        driveName));
    }

    private BaseElementFacade getOthersDriveTitle(String othersDriveTitle) {
        return findByXpath(
                String.format("(//div[@class='selectionBox px-5 d-flex flex-wrap'])[3]//div[@title='%s']",
                        othersDriveTitle));
    }

    private BaseElementFacade getTaskCommentReplyBtn(String comment) {
        return findByXpath(
                String.format("//*[contains(@class,'taskCommentDrawer')]//*[@class='taskContentComment']/p[contains(text(),'%s')]/following::button[@id='reply_btn'][1]",
                        comment));
    }

    private BaseElementFacade getDriveNameInShipForm(String driveName) {
        return findByXpath(
                String.format("//span[@class='v-chip__content' and contains(text(),'%s')]", driveName));
    }

    private BaseElementFacade getSpaceDriveTitle(String spaceDriveTitle) {
        return findByXpath(
                String.format("(//div[@class='selectionBox px-5 d-flex flex-wrap'])[2]//div[@title='%s']",
                        spaceDriveTitle));
    }

    private BaseElementFacade getAttachmentName(String attachmentName) {
        return findByXpath(
                String.format("(//div[@class='v-list-item__content']//div[@title='%s'])[2]", attachmentName));
    }

    private BaseElementFacade getTitleDoc(String titleDoc) {
        return findByXpath(
                String.format("//div[@class='lr-separator']//label[contains(text(),'%s')]", titleDoc));
    }

    private BaseElementFacade getUsername(String userName) {
        return findByXpath(
                String.format("//label[@id='title-user-name' and contains(text(),'%s')]", userName));
    }

    private BaseElementFacade getTaskName(String taskName) {
        return findByXpath(
                String.format("//div[@class='taskTitle pe-14 d-lg-block d-md-none']//a[@title='%s']", taskName));
    }

    private BaseElementFacade getTaskToMarkAsCompleted(String taskName) {
        return findByXpath(String.format("//*[@class='taskTitleEllipsis' and contains(text(),'%s')]/preceding::*[@class='uiIconCircle'][1]",
                taskName));
    }

    @FindBy(xpath = "(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[4]")
    private BaseElementFacade lastColumnThreeDotsIcon;

    @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[3]")
    private BaseElementFacade thirdStatusColumn;

    @FindBy(
            xpath = "(//*[contains(@class,'profile-popover')]//a[contains(@id,'userAvatar')]/following::div[contains(@class,'ms-2')])[2]"
    )
    private BaseElementFacade projectCardUserFullName;

    @FindBy(xpath = "(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[4]")
    private BaseElementFacade lastStatusColumn;

    @FindBy(xpath = "//div[@id='attachmentIntegration']//button[contains(@class,'v-btn v-btn--flat')]")
    private BaseElementFacade addAttachmentLink;

    @FindBy(xpath = "//div[@class='bar']")
    private TextBoxElementFacade progressDownloadBar;

    @FindBy(xpath = "//*[contains(@class,'drawerParent attachmentsListDrawer')]/following::*[@class='v-alert__content'][1]//span")
    private TextBoxElementFacade successMessage;

    @FindBy(xpath = "(//div[@class='v-list-item__action drawerIcons align-end d-flex flex-row']//button[@title='Close'])[02]")
    private BaseElementFacade closeUploadDocButton;

    @FindBy(
            xpath = "//div[@class='attachmentsList']//a[@class='viewAllAttachments primary--text font-weight-bold text-decoration-underline']"
    )
    private BaseElementFacade viewAttachmentsLink;

    @FindBy(xpath = "//*[contains(@class ,'flex document-timeline-header ')]//button[contains(@class,'v-btn v-btn--flat')]")
    private BaseElementFacade documentButton;

    @FindBy(xpath = "//div[@class='v-list-item__action drawerIcons align-end d-flex flex-row']//button[@title='Close']")
    private BaseElementFacade closeUploadDocButtonSnapshot;

    @FindBy(xpath = "//*[contains(@class,'taskViewCard')]//*[@class='taskCheckBox']")
    private BaseElementFacade markTaskCompletedOnTaskCard;

    @FindBy(
            xpath = "//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Task successfully marked as completed')]"
    )
    private TextBoxElementFacade alertMessageAfterMarkTaskAsCompleted;

    @FindBy(xpath = "//*[@id='ProjectListToolbar']//button[contains(@class,' mdi-close theme')]")
    private TextBoxElementFacade clearButtonInFilterByProject;

    @FindBy(xpath = "//input[@placeholder='Filter by project']")
    private TextBoxElementFacade filterByProject;

    @FindBy(xpath = "//*[@id='TasksListToolbar']//button[contains(@class,' mdi-close theme')]")
    private TextBoxElementFacade clearButtonInFilterByTask;

    private BaseElementFacade getTaskAlert(String message) {
        return findByXpath(
                String.format("//*[@class='v-alert__content' and contains(text(),'%s')]", message));
    }

    private BaseElementFacade getProjectParticipant(String fullName) {
        return findByXpath(
                String.format("//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                        fullName));
    }

    private BaseElementFacade getProjectCardUserAvatar(String userName) {
        return findByXpath(
                String.format("//*[contains(@id,'userAvatar') and contains(@href,'%s')]", userName));
    }

    private BaseElementFacade getStatusColumn(String statusColumn) {
        return findByXpath(String.format("(//*[@class='d-flex tasksViewHeaderLeft']//*[contains(text(),'%s')][1])[1]",
                statusColumn));
    }

    public void goToProjectDetailsList() {
        projectDetailsListButton.clickOnElement();
    }

    private BaseElementFacade getProjectManager(String fullName) {
        return findByXpath(
                String.format("//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                        fullName));
    }

    public void clickAddTaskButton() {
        addTaskButton.clickOnElement();
    }

    public void clickAddTaskInProjectButton() {
        addTaskInProjectButton.clickOnElement();
    }

    private BaseElementFacade getTabByName(String name) {
        return findByXpath(String.format("//a[contains(text(),'%s')]", name));
    }

    private BaseElementFacade getFilterOption(String option) {
        return findByXpath(String.format("//*[@class='v-label theme--light' and text()='%s']", option));
    }

    private BaseElementFacade projectNameInProjectDetails(String projectName) {
        return findByXpath(String.format("//*[@id='projectListApplication']//*[contains(@class,'taskViewBreadcrumb')]//span[contains(text(),'%s')]",
                projectName));
    }

    private BaseElementFacade taskNameInProjectDetails(String taskName) {
        return findByXpath(String.format("//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following::*[@class='taskTitleEllipsis' and contains(text(),'%s')]",
                taskName));
    }

    private BaseElementFacade getLabelInEditProjectDrawer(String label) {
        return findByXpath(
                String.format("//*[contains(@class,'v-chip__content')]//*[contains(@class,'pr-2') and contains(text(),'%s')]",
                        label));
    }

    private BaseElementFacade getCompletedTask(String taskName) {
        return findByXpath(String.format("//*[@class='nameGroup' and text()='Archived']//following::*[@class='taskCardViewTitle text-color strikethrough']//span[@class='taskTitleEllipsis' and contains(text(),'%s')]",
                taskName));
    }

    private BaseElementFacade getUncompletedTask(String taskName) {
        return findByXpath(String.format("//*[@class='nameGroup' and text()='Uncompleted']//following::*[@class='taskCardViewTitle text-color']//span[@class='taskTitleEllipsis' and contains(text(),'%s')]",
                taskName));
    }

    private BaseElementFacade getTasksNumberToDo(String tasksNumber) {
        return findByXpath(String.format("//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following ::*[@class='uiTaskNumber' and text()='%s']",
                tasksNumber));
    }

    private BaseElementFacade taskNameAndLabelAndNumberInProjectDetails(String taskName) {
        return findByXpath(String.format("(//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following::*[@class='taskTitleEllipsis' and contains(text(),'%s')]/following::*[contains(@class,'taskLabels')]//span[@class='text-truncate'])[1]",
                taskName));
    }

    private BaseElementFacade getTaskCommentWithUser(String user, String comment) {
        return findByXpath(String.format("//*[@class='TaskCommentContent']//*[contains(text(),'%s')]/following::*[@class='taskContentComment']//p[contains(text(),'%s')]",
                user,
                comment));
    }

    private BaseElementFacade getProjectCard(String projectName) {
        return findByXpath(
                String.format("//span[contains(@class,'projectCardTitle') and contains(text(),'%s')]", projectName));
    }

    private BaseElementFacade getTaskOrder(String number) {
        return findByXpath(
                String.format("(//*[@id='projectListApplication']//*[contains(@id,'taskView')]//*[contains(@class,'taskTitle')]//a)[%s]",
                        number));
    }

    private BaseElementFacade getDisplayedLabel(String label, String times) {
        return findByXpath(
                String.format("//*[@class='nameGroup' and contains(text(),'%s')]//following::*[@class='amount-item' and contains(text(),'%s')][1]",
                        label,
                        times));
    }

    private BaseElementFacade getAddLabelToTask(String label) {
        return findByXpath(
                String.format("//*[contains(@class,'v-list')]//*[contains(@class,'v-chip v-chip--label')]//*[contains(@class,'v-chip__content') and contains(text(),'%s')]",
                        label));
    }

    private BaseElementFacade getLabelInEditTaskDrawer(String label) {
        return findByXpath(
                String.format("//*[contains(@class,'v-chip__content')]//*[contains(@class,'pe-2') and contains(text(),'%s')]",
                        label));
    }

    private BaseElementFacade getDescriptionForTask(String description) {
        return findByXpath(String.format("//*[@class='py-1 px-2 taskDescriptionToShow']//*[contains(text(),'%s')]", description));
    }

    private BaseElementFacade getProjectCardDescription(String description) {
        return findByXpath(
                String.format("//*[@class='taskItemDescription largeDescriptionArea']//*[contains(text(),'%s')]",
                        description));
    }

    private BaseElementFacade openTask(String projectName) {
        return findByXpath(
                String.format("//span[contains(@class,'taskTitleEllipsis') and contains(text(),'%s')]", projectName));
    }

    private BaseElementFacade getTaskTitle(String taskName) {
        return findByXpath(
                String.format("//span[contains(@class,'taskTitleEllipsis') and contains(text(),'%s')]", taskName));
    }

    private BaseElementFacade getRemoveLabelButton(String label) {
        return findByXpath(
                String.format("//*[contains(@class,'v-chip__content')]//*[contains(@class,'pr-2') and contains(text(),'%s')]/following::button[2]",
                        label));
    }

    private BaseElementFacade getRemoveLabelTaskButton(String label) {
        return findByXpath(
                String.format("//*[contains(@class,'v-chip__content')]//*[contains(@class,'pe-2') and contains(text(),'%s')]/following::button[1]",
                        label));
    }

    private BaseElementFacade getTaskTitleInTasksTab(String taskName) {
        return findByXpath(
                String.format("//*[contains(@class,'v-application tasksList')]//*[contains(@class,'taskTitle pe-14')]/a[contains(text(),'%s')]",
                        taskName));
    }

    @FindBy(xpath = "(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[1]")
    private BaseElementFacade firstNotificationContent;

    public void completeTask() {
        markTaskCompleted.clickOnElement();
    }

    public void setTaskCompletedInDrawer() {
        markTaskCompletedInDrawer.clickOnElement();
        closeTaskDrawerButton.clickOnElement();
    }

    public void taskOrderInProjectDetails(String task, String number) {
        Assert.assertTrue(getTaskOrder(number).getTextContent().contains(task));
    }

    public void isLabelDisplayedInProjectDetails(String label, String times) {
        getDisplayedLabel(label, times).isVisibleAfterWaiting();
    }

    public void setTaskCompletedInDrawerWithoutClosingIt() {
        markTaskCompletedInDrawer.clickOnElement();
    }

    public void commentTaskWithUser(String user, String comment) {
        getTaskCommentWithUser(user, comment);
    }

    public void searchTask(String taskName) {
        searchTaskName.sendKeys(taskName);
    }

    public void saveAddTaskButton() {
        saveAddingTaskButton.clickOnElement();
    }

    public void enterLabelTask(String label) {
        labelTask.setTextValue(label);
        labelTask.sendKeys(Keys.ENTER);
    }

    public void selectFilterOption(String label) {
        getFilterOption(label).clickOnElement();
    }

    public void addProject(String projectName) {
        addProject.clickOnElement();
        projectTitle.setTextValue(projectName);
        saveAddingTaskButton.clickOnElement();
    }

    public void checkProjectIsCreated() {
        alertMessageAfterProjectCreation.isVisibleAfterWaiting();
    }

    public void projectIsDisplayedInTasksAppCenter(String projectName) {
        getProjectCard(projectName).isVisibleAfterWaiting();
    }

    public void editSpaceName(String spaceName) {
        spaceNameTitle.setTextValue(spaceName);
        updateNameSpaceButton.clickOnElement();
    }

    public void addProjectWithParticipant(String projectName, String fullName) {
        addProject.clickOnElement();
        projectTitle.setTextValue(projectName);
        addParticipantBtn.clickOnElement();
        inviteProjectParticipantInput.setTextValue(fullName + " ");
        inviteProjectParticipantInput.sendKeys(Keys.BACK_SPACE);
        getProjectParticipant(fullName).clickOnElement();
        saveAddingTaskButton.clickOnElement();
    }

    public void addProjectWithManager(String projectName, String fullName) {
        addProject.clickOnElement();
        projectTitle.setTextValue(projectName);
        addManagerBtn.clickOnElement();
        inviteProjectManagerInput.setTextValue(fullName);
        getProjectManager(fullName).clickOnElement();
        saveAddingTaskButton.clickOnElement();
    }

    public void addProjectWithFirstCreatedUserAsManger(String projectName, String fullName) {
        addProject.clickOnElement();
        projectTitle.setTextValue(projectName);
        addManagerBtn.clickOnElement();
        inviteProjectManagerInput.setTextValue(fullName + " ");
        inviteProjectManagerInput.sendKeys(Keys.BACK_SPACE);
        getProjectManager(fullName).clickOnElement();
        saveAddingTaskButton.clickOnElement();
    }

    public void addProjectWithManagerAndParticipant(String projectName, String manager, String participant) {
        addProject.clickOnElement();
        projectTitle.setTextValue(projectName);
        addManagerBtn.clickOnElement();
        inviteProjectManagerInput.setTextValue(manager + " ");
        inviteProjectManagerInput.sendKeys(Keys.BACK_SPACE);
        getProjectManager(manager).clickOnElement();
        addParticipantBtn.clickOnElement();
        inviteProjectParticipantInput.setTextValue(participant + " ");
        inviteProjectParticipantInput.sendKeys(Keys.BACK_SPACE);
        getProjectParticipant(participant).clickOnElement();
        saveAddingTaskButton.clickOnElement();
    }

    public void closeProjectDrawer() {
        closeProjectDrawerBtn.waitUntilVisible();
        closeProjectDrawerBtn.clickOnElement();
    }

    public void projectDrawerNotClosing() {
        closeProjectDrawerBtn.isVisibleAfterWaiting();
    }

    public void projectNameIsDisplayedInProjectDetails(String projectName) {
        projectNameInProjectDetails(projectName).isVisibleAfterWaiting();
    }

    public void hoverOnTaskName(String task) {
        Actions oAction = new Actions(driver);
        oAction.contextClick(taskNameInProjectDetails(task)).build().perform();
    }

    public void taskTooltipIsDisplayed(String task) {
        Assert.assertEquals(taskTooltip.getText(), task);
    }

    public void taskMarkedAsCompletedIsDisplayedInDrawer() {
        taskMarkedAsCompletedInDrawer.isVisibleAfterWaiting();
    }

    public void taskNameIsDisplayedInProjectDetails(String taskName) {
        Assert.assertEquals(taskNameInProjectDetails(taskName).getText(), taskName);
    }

    public void taskNameIsNotDisplayedInProjectDetails(String taskName) {
        if (tasksNameToDo.isVisibleAfterWaiting()) {
            Assert.assertFalse(tasksNameToDo.getText().contains(taskName));
        } else {
            tasksNameToDo.isNotVisibleAfterWaiting();
        }
    }

    public void removeLabelToProject(String label) {
        getLabelInEditProjectDrawer(label).isDisplayed();
        getRemoveLabelButton(label).clickOnElement();
    }

    public void labelIsNotDisplayedInProjectDrawer(String label) {
        getLabelInEditProjectDrawer(label).isNotVisibleAfterWaiting();
    }

    public void addSecondUserToProject(String fullName) {
        addParticipantBtn.clickOnElement();
        inviteProjectParticipantInput.setTextValue(fullName + " ");
        inviteProjectParticipantInput.sendKeys(Keys.BACK_SPACE);
        getProjectParticipant(fullName).clickOnElement();
    }

    public void addLabelToTask(String label) {
        labelTask.clickOnElement();
        getAddLabelToTask(label).clickOnElement();
    }

    public void labelIsDisplayedInTaskDrawer(String label) {
        getLabelInEditTaskDrawer(label).isDisplayed();
        getRemoveLabelTaskButton(label).isNotVisibleAfterWaiting();
    }

    public void addSixLabelToProject(String label1, String label2, String label3, String label4, String label5, String label6) {
        labelTask.sendKeys(label1 + Keys.ENTER + label2 + Keys.ENTER + label3 + Keys.ENTER + label4 + Keys.ENTER + label5 + Keys.ENTER
                + label6 + Keys.ENTER);
    }

    public void taskIsMarkedAndDisplayedInCompletedSection(String taskName) {
        Assert.assertEquals(getCompletedTask(taskName).getText(), taskName);
    }

    public void taskIsNotMarkedAndDisplayedInUncompletedSection(String taskName) {
        Assert.assertEquals(getUncompletedTask(taskName).getText(), taskName);
    }

    public void tasksNumberToDo(String tasksNumber) {
        getTasksNumberToDo(tasksNumber).isVisibleAfterWaiting();
    }

    public void markTaskAsCompletedInProjectDetails(String taskName) {
        getTaskToMarkAsCompleted(taskName).clickOnElement();
    }

    public void taskNameAndLabelIsDisplayedInProjectDetails(String label, String taskName) {
        Assert.assertTrue(taskNameAndLabelAndNumberInProjectDetails(taskName).getText().contains(label));
    }

    public void editProjectName(String projectName) {
        projectThreeDotsButton.clickOnElement();
        editProjectButton.clickOnElement();
        projectTitle.setTextValue(projectName);
        saveAddingTaskButton.clickOnElement();
    }

    public void goToTab(String tab) {
        getTabByName(tab).clickOnElement();
    }

    Map<String, TextBoxElementFacade> ADD_TASK_MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH =
            new HashMap<String, TextBoxElementFacade>() {
                {
                    put("taskName", taskNameField);
                }
            };

    public void clickStatusName(String statusColumn) {
        getStatusColumn(statusColumn).waitUntilVisible();
        getStatusColumn(statusColumn).clickOnElement();
    }

    public boolean isStatusEditModeDisplayed(String statusColumn) {
        return getStatusColumn(statusColumn).isNotVisibleAfterWaiting();
    }

    public void openProject(String project) {
        getProjectCard(project).clickOnElement();
    }

    public void openTaskCard(String task) {
        openTask(task).clickOnElement();
    }

    public void boardViewIsDisplayedByDefault() {
        projectActiveBoardView.isVisibleAfterWaiting();
    }

    public void setInSearchProjectField(String project) {
        searchProjectInput.setTextValue(project);
    }

    public void isSearchedTaskDisplayed(String taskName) {
        Assert.assertEquals(ELEMENT_DRAWER_TASK_NAME.getValue(), taskName);
    }

    public void commentTask(String comment) {
        ckEditorFrameTask.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameTask);
        taskCommentContentTextBox.waitUntilVisible();
        taskCommentContentTextBox.setTextValue(comment);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
        commentTaskButton.waitUntilVisible();
        commentTaskButton.clickOnElement();
        goBackToTaskDrawerFromComments.waitUntilVisible();
        goBackToTaskDrawerFromComments.clickOnElement();
        closeTaskDrawerButton.waitUntilVisible();
        closeTaskDrawerButton.clickOnElement();
    }

    public void addNewCommentInTaskWithMentioningTheFirstUserInTask(String comment, String user) {
        ckEditorFrameTaskMentioningUser.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameTaskMentioningUser);
        taskCommentContentTextBox.waitUntilVisible();
        taskCommentContentTextBox.clear();
        taskCommentContentTextBox.setTextValue(comment + ' ' + '@' + user);
        taskCommentContentTextBox.sendKeys(Keys.ENTER);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
        commentTaskButton.waitUntilVisible();
        commentTaskButton.clickOnElement();
        goBackToTaskDrawerFromComments.waitUntilVisible();
        goBackToTaskDrawerFromComments.clickOnElement();
        closeTaskDrawerButton.waitUntilVisible();
        closeTaskDrawerButton.clickOnElement();
    }

    public void closetaskCommentsDrawer() {
        goBackToTaskDrawerFromComments.waitUntilVisible();
        goBackToTaskDrawerFromComments.clickOnElement();
    }

    public void maxCharsCount1250InformationIsDisplayed() {
        maxCharsCountInfo.isVisibleAfterWaiting();
    }

    public void more1250CharsInformationIsDisplayed() {
        more1250CharsCountInfo.isVisibleAfterWaiting();
        Assert.assertEquals(more1250CharsCountInfo.getCssValue("color"), "rgba(188, 67, 67, 1)");
    }

    public void closetaskDrawer() {
        closeTaskDrawerButton.waitUntilVisible();
        closeTaskDrawerButton.clickOnElement();
    }

    public void confirmFilter() {
        confirmFilterButton.clickOnElement();
    }

    public void isFilterDrawerTabDisplayed(String tab) {
        Assert.assertEquals(activeTabFilterDrawer.getText(), tab);
    }

    public void goToLabelsTab() {
        labelsTab.clickOnElement();
    }

    public void goToFilterTab() {
        filterTab.clickOnElement();
    }

    public void goToGroupAndSortTab() {
        groupAndSortTab.clickOnElement();
    }

    public void confirmFilterButtonIsDisplayed() {
        confirmFilterButton.isVisibleAfterWaiting();
    }

    public void cancelFilterButtonIsDisplayed() {
        cancelFilterButton.isVisibleAfterWaiting();
    }

    public void resetFilterButtonIsDisplayed() {
        resetFilterButton.isVisibleAfterWaiting();
    }

    public void addNewCommentInTask() {
        addNewCommentInTask.waitUntilVisible();
        addNewCommentInTask.clickOnElement();
    }

    public void addOtherCommentInTask() {
        addOtherCommentInTask.waitUntilVisible();
        addOtherCommentInTask.clickOnElement();
    }

    public void editTaskDrawerIsDisplayed() {
        editTaskDrawerSection.isVisibleAfterWaiting();
    }

    public void commentsDrawerIsDisplayed() {
        commentsDrawerSection.isVisibleAfterWaiting();
    }

    public void viewAllCommentsTaskButton() {
        viewAllCommentsTaskButton.waitUntilVisible();
        viewAllCommentsTaskButton.clickOnElement();
    }

    public void taskAlertIsDisplayed(String message) {
        getTaskAlert(message).isVisibleAfterWaiting();
    }

    public void setTaskDetails(String taskDetails, String fieldValue) {
        ADD_TASK_MAPPING_CONTAINER_NAME_TO_BASEELEMENTFACADE_XPATH.get(taskDetails).setTextValue(fieldValue);
    }

    public void openFilterDrawer() {
        Serenity.getWebdriverManager().getCurrentDriver().navigate().refresh();
        filterDrawerButton.waitUntilVisible();
        filterDrawerButton.clickOnElement();
    }

    public void greenInformationIconIsDisplayed() {
        informationIcon.isVisibleAfterWaiting();
        Assert.assertEquals(informationIcon.getCssValue("color"), "rgba(46, 181, 140, 1)");
    }

    public void addProjectWithDescription(String projectName, String description) {
        addProject.clickOnElement();
        projectTitle.setTextValue(projectName);
        ckEditorFrameTask.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameTask);
        projectDescriptionField.waitUntilVisible();
        projectDescriptionField.setTextValue(description);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
        saveAddingTaskButton.clickOnElement();
    }

    public void saveAddingProject() {
        saveAddingTaskButton.clickOnElement();
    }

    public void enterProjectTitleAndDescription(String projectName, String description) {
        addProject.clickOnElement();
        projectTitle.setTextValue(projectName);
        ckEditorFrameTask.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameTask);
        projectDescriptionField.waitUntilVisible();
        projectDescriptionField.setTextValue(description);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    }

    public void enterProjectDescriptionWithoutTheTitle(String description) {
        addProject.clickOnElement();
        ckEditorFrameTask.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameTask);
        projectDescriptionField.waitUntilVisible();
        projectDescriptionField.setTextValue(description);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    }

    public void checkProject(String projectName) {
        getProjectCard(projectName).isVisibleAfterWaiting();
        alertMessageAfterProjectCreation.isVisibleAfterWaiting();
    }

    public void checkProjectNotDisplayed(String projectName) {
        getProjectCard(projectName).isNotVisibleAfterWaiting();
        alertMessageAfterProjectCreation.isNotVisibleAfterWaiting();
    }

    public void clickOnProjectThreeDotsButton() {
        projectThreeDotsButton.clickOnElement();
    }

    public void deleteProject(String projectName) {
        getProjectCard(projectName).isVisibleAfterWaiting();
        projectThreeDotsButton.clickOnElement();
        deleteProjectButton.clickOnElement();
        confirmationPopupDeleteButton.clickOnElement();
        confirmationPopupDeleteButton.isNotVisibleAfterWaiting();

    }

    public void checkDeletedProject(String projectName) {
        getProjectCard(projectName).isNotVisibleAfterWaiting();
        alertMessageAfterProjectDeletion.isVisibleAfterWaiting();
    }

    public void editProjectNameWithDescription(String projectName, String newProjectName, String newDescription) {
        getProjectCard(projectName).isVisibleAfterWaiting();
        projectThreeDotsButton.clickOnElement();
        editProjectButton.clickOnElement();
        projectTitle.setTextValue(newProjectName);
        ckEditorFrameTask.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameTask);
        projectDescriptionField.waitUntilVisible();
        projectDescriptionField.setTextValue(newDescription);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
        saveAddingTaskButton.clickOnElement();
    }

    public void checkUpdatedProject(String projectName, String description) {
        getProjectCard(projectName).isVisibleAfterWaiting();
        getProjectCardDescription(description).isVisibleAfterWaiting();
        alertMessageAfterProjectUpdate.isVisibleAfterWaiting();
    }

    public void addLabelToProject(String label) {
        labelTask.setTextValue(label);
        labelTask.sendKeys(Keys.ENTER);
    }

    public void labelIsDisplayedInProjectDrawer(String label) {
        getLabelInEditProjectDrawer(label).isDisplayed();
    }

    public void addFourLabelToProject(String label1, String label2, String label3, String label4) {
        labelTask.sendKeys(label1 + Keys.ENTER + label2 + Keys.ENTER + label3 + Keys.ENTER + label4 + Keys.ENTER);
    }

    public void clickOnEditProjectButton() {
        editProjectButton.clickOnElement();
    }

    public void openTaskInTasksTab(String taskName) {
        getTaskTitleInTasksTab(taskName).waitUntilVisible();
        getTaskTitleInTasksTab(taskName).clickOnElement();
    }

    public void checkProjectNameIsDisplayedInProjectCard(String projectName, String description) {
        getProjectCard(projectName).isVisibleAfterWaiting();
        getProjectCardDescription(description).isVisibleAfterWaiting();
    }

    public void userFullNameIsDisplayedInProjectCard(String name) {
        Assert.assertEquals(projectCardUserFullName.getText(), name);
    }

    public void userFullNameIsNotDisplayedInProjectCard(String name) {
        Assert.assertNotEquals(projectCardUserFullName.getText(), name);
    }

    public void redInformationIconIsDisplayed() {
        informationIcon.isVisibleAfterWaiting();
        Assert.assertEquals(informationIcon.getCssValue("color"), "rgba(188, 67, 67, 1)");
    }

    public void userAvatarIsDisplayedInProjectCard(String userName) {
        getProjectCardUserAvatar(userName).isVisibleAfterWaiting();
    }

    public void enterTaskComment(String comment) {
        ckEditorFrameTask.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameTask);
        taskCommentContentTextBox.waitUntilVisible();
        taskCommentContentTextBox.setTextValue(comment);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    }

    public void commentButtonIsDisabled() {
        commentTaskButton.isDisabledAfterWaiting();
    }

    public void replyTaskCommentButtonIsDisabled() {
        replyTaskCommentButton.isDisabledAfterWaiting();
    }

    public void clickOnCommentReply(String comment) {
        getTaskCommentReplyBtn(comment).isVisibleAfterWaiting();
        getTaskCommentReplyBtn(comment).clickOnElement();
    }

    public void userAvatarIsNotDisplayedInProjectCard(String userName) {
        getProjectCardUserAvatar(userName).isNotVisibleAfterWaiting();
    }

    public void maxCharsNumberMessageIsDisplayed() {
        commentsDrawerSection.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameTask);
        commentTaskMaxCharsMsg.isVisibleAfterWaiting();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    }

    public void cloneProject(String projectName) {
        getProjectCard(projectName).isVisibleAfterWaiting();
        projectThreeDotsButton.clickOnElement();
        cloneProjectButton.clickOnElement();
        confirmationPopupCloneButton.clickOnElement();
        confirmationPopupCloneButton.isNotVisibleAfterWaiting();

    }

    public void cloneProjectButtonIsDisplayed() {
        cloneProjectButton.isVisibleAfterWaiting();
    }

    public void colorPaletteIsDisplayed() {
        colorPalette.isVisibleAfterWaiting();
    }

    public void editProjectButtonIsDisplayed() {
        editProjectButton.isVisibleAfterWaiting();
    }

    public void deleteProjectButtonIsDisplayed() {
        deleteProjectButton.isVisibleAfterWaiting();
    }

    public void checkClonedProject(String projectName) {
        getProjectCard(projectName).isVisibleAfterWaiting();
        alertMessageAfterProjectClone.isVisibleAfterWaiting();
    }

    public void checkClonedTask(String taskName) {
        getTaskTitle(taskName).isVisibleAfterWaiting();
    }

    public void returnToProjectsTab() {
        arrowBackButton.clickOnElement();
    }

    public void clickOnThreeDotsIcon() {
        threeDotsIcon.clickOnElement();
    }

    public void clickOnAddStatusBeforeOption() {
        addStatusBeforeoption.clickOnElement();
    }

    public void enterStatusText(String status) {
        statusField.sendKeys(status);
    }

    public void clickOnValidateStatusName() {
        ValidateStatusName.clickOnElement();
    }

    public void ClickOnPlusButtonToAddTask() {
        PlusButtonToAddTask.clickOnElement();
    }

    public void enterTileForTask(String title) {
        TileForTaskField.waitUntilVisible();
        TileForTaskField.sendKeys(title);
    }

    public void ClickOnSaveButtonToAddTask() {
        SaveButtonTask.clickOnElement();
    }

    public void taskNameIsDisplayedInDesiredColumn(String status, String taskName) {
        Assert.assertTrue(getTaskStatusColumn(status).getText().contains(taskName));
    }

    public void clickOnFifthColumnThreeDotsIcon() {
        fifthColumnThreeDotsIcon.clickOnElement();
    }

    public void clickOnAddStatusAfterOptionOfTheFifthStatusColumn() {
        addStatusafteroption.clickOnElement();
    }

    public void ClickOnPlusButtonToAddTaskOfTheSixthStatusColumn() {
        PlusButtonToAddTaskOfTheSixthStatusColumn.clickOnElement();
    }

    public void clickOnDeleteStatusIcon() {
        deleteStatusIcon.clickOnElement();
    }

    public void confirmDeleteStatusColumn() {
        confirmationPopupDeleteButton.clickOnElement();
        confirmationPopupDeleteButton.isNotVisibleAfterWaiting();
    }

    public void checkDeletedStatus(String statusColumn) {
        getStatusColumn(statusColumn).isNotVisibleAfterWaiting();
        alertMessageAfterStatusDeletion.isVisibleAfterWaiting();
    }

    public void checkMoveStatusBeforeIconIsNotDisplayed() {
        moveStatusBeforeIcon.isNotVisibleAfterWaiting();
    }

    public void clickOnMoveStatusAfterIcon() {
        moveStatusAfterIcon.clickOnElement();
    }

    public void checkAlertMessageMoveStatusAfter() {
        alertMessageAfterStatusMoved.isVisibleAfterWaiting();
    }

    public void checkSecondStatusColumn(String columnStatus) {
        Assert.assertEquals(secondStatusColumn.getText(), columnStatus);
    }

    public void checkFirstStatusColumn(String columnStatus) {
        Assert.assertEquals(firstStatusColumn.getText(), columnStatus);
    }

    public void clickOnLastColumnThreeDotsIcon() {
        lastColumnThreeDotsIcon.clickOnElement();
    }

    public void checkMoveStatusAfterIconIsNotDisplayed() {
        moveStatusAfterIcon.isNotVisibleAfterWaiting();
    }

    public void clickOnMoveStatusBeforeIcon() {
        moveStatusBeforeIcon.clickOnElement();
    }

    public void checkThirdStatusColumn(String columnStatus) {
        Assert.assertEquals(thirdStatusColumn.getText(), columnStatus);
    }

    public void checkLastStatusColumn(String columnStatus) {
        Assert.assertEquals(lastStatusColumn.getText(), columnStatus);
    }

    public void clickOnAddAttachmentLink() {
        addAttachmentLink.waitUntilVisible();
        addAttachmentLink.clickOnElement();
    }

    public void checkSuccessMessage(String message) {
        Assert.assertTrue(successMessage.getText().contains(message));
    }

    public void closeUploadDocDrawer() {
        closeUploadDocButton.waitUntilVisible();
        closeUploadDocButton.clickOnElement();
    }

    public void checkViewLinkAttachments() {
        viewAttachmentsLink.isVisibleAfterWaiting();
    }

    public void clickDocButton() {
        documentButton.clickOnElement();
    }

    public void closeUploadDocDrawerSnapshot() {
        closeUploadDocButtonSnapshot.waitUntilVisible();
        closeUploadDocButtonSnapshot.clickOnElement();
    }

    public void markTaskAsCompletedFromTaskCard() {
        markTaskCompletedOnTaskCard.clickOnElement();
    }

    public void checkAlertMessageAfterMarkTaskAsCompleted() {
        alertMessageAfterMarkTaskAsCompleted.isVisibleAfterWaiting();
    }

    public void clearButtonIsVisible() {
        clearButtonInFilterByProject.isVisibleAfterWaiting();
    }

    public void clickOnClearButton() {
        clearButtonInFilterByProject.clickOnElement();
    }

    public void checkDisplayOfFilterByProject() {
        filterByProject.isVisibleAfterWaiting();
    }

    public void clearButtonIsNotVisible() {
        clearButtonInFilterByProject.isNotVisibleAfterWaiting();
    }

    public void checkTypedProjectIsRemoved(String typedProject) {
        Assert.assertFalse(filterByProject.getText().contains(typedProject));
    }

    public void saveAddTaskSimpleProject() {
        saveAddingTaskSimpleProject.clickOnElement();
    }

    public void closeUploadDocDrawerSimpleProject() {
        closeButtonDrawerSimpleProject.waitUntilVisible();
        closeButtonDrawerSimpleProject.clickOnElement();
    }

    public void openTaskDrawer(String taskName) {
        getTaskName(taskName).clickOnElement();
    }

    public void clickViewAttachmentLink() {
        viewAttachmentsLink.isVisibleAfterWaiting();
        viewAttachmentsLink.clickOnElement();
    }

    public void clickPlusIcon() {
        plusIcon.clickOnElement();
    }

    public void clickPlusIconProject() {
        plusIconProject.clickOnElement();
    }

    public void clearButtonInFilterByTaskIsVisible() {
        clearButtonInFilterByTask.isVisibleAfterWaiting();
    }

    public void clickOnClearButtonInFilterByTask() {
        clearButtonInFilterByTask.clickOnElement();
    }

    public void checkDisplayOfFilterByTask() {
        filterByTask.isVisibleAfterWaiting();
    }

    public void checkTypedTaskIsRemoved(String typedTask) {
        Assert.assertFalse(filterByTask.getText().contains(typedTask));
    }

    public void clearButtonInFilterByTaskIsNotVisible() {
        clearButtonInFilterByTask.isNotVisibleAfterWaiting();
    }

    @FindBy(xpath = "//*[contains(@class,'uiThreeDotsIcon')]")
    private BaseElementFacade taskThreeDotsOption;

    @FindBy(xpath = "//*[contains(@class,'uiIconTrash ')]")
    private BaseElementFacade deleteTaskOption;

    public void clickOnTaskThreeDotsOption() {

        taskThreeDotsOption.clickOnElement();
    }

    public void deleteTaskOptionIsDisplayed() {
        deleteTaskOption.isVisibleAfterWaiting();
    }

    public void clickOnDeleteTaskOption() {
        deleteTaskOption.clickOnElement();
    }

    public void confirmDeleteTaskFromTasksBord() {
        confirmationPopupDeleteButton.clickOnElement();
        confirmationPopupDeleteButton.isNotVisibleAfterWaiting();
    }

    public void checkDeletedTaskIsNotDisplayed(String taskName) {
        getTaskName(taskName).isNotVisibleAfterWaiting();
    }

    public void checkAttachmentDisplay(String attachmentName) {
        getAttachmentName(attachmentName).isNotVisibleAfterWaiting();
    }

    public void goBack() {
        goBackIcon.clickOnElement();
    }

    public void verifyViewLinkAttachments() {
        viewAttachmentsLink.isNotVisibleAfterWaiting();
    }

    public void clickAddProjectButton() {
        addProject.clickOnElement();
    }

    public void clickSaveProjectButton() {
        saveAddingTaskButton.clickOnElement();
    }

    public void checkMessageEmptyProjectDisplay() {
        Assert.assertEquals(projectTitle.getText(), "");
    }

    public void checkAlertMessageAfterDeleteTask() {
        alertMessageAfterTaskDeleted.isVisibleAfterWaiting();
    }

    public void clickChangeLocation() {
        changeLocationLink.clickOnElement();
    }

    public void checkDrawerDisplay() {
        drawerTitle.isVisibleAfterWaiting();
    }

    public void changeLocation(String spaceDriveTitle) {
        driveIcon.clickOnElement();
        getSpaceDriveTitle(spaceDriveTitle).clickOnElement();
        selectButton.clickOnElement();
    }

    public void checkSelectedLocation(String driveName) {
        getDriveNameInShipForm(driveName).isVisibleAfterWaiting();
    }

    public void closeEditTaskDrawer() {
        closeEditTaskDrawer.clickOnElement();
    }

    public void changePlacement(String othersDriveTitle) {
        driveIcon.clickOnElement();
        getOthersDriveTitle(othersDriveTitle).clickOnElement();
        selectButton.clickOnElement();
    }

    public void closeEditTaskDrawerSimpleProject() {
        closeEditTaskDrawerSimpleProject.waitUntilVisible();
        closeEditTaskDrawerSimpleProject.clickOnElement();
    }

    public void accessDrivesInterface() {
        showDrives.waitUntilVisible();
        showDrives.clickOnElement();
    }

    public void selectDrive(String driveName) {
        selectDriveName(driveName).clickOnElement();
    }

    @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[2]//input")
    private TextBoxElementFacade ELEMENT_TASK_DUE_DATE;

    @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[2]")
    private TextBoxElementFacade ELEMENT_TASK_DUE_DATE_TODAY;

    @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[2]/following::td[1]")
    private TextBoxElementFacade ELEMENT_TASK_DUE_DATE_TOMORROW;

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

    @FindBy(id = "tasks")
    private BaseElementFacade tasksContainer;

    public void checkTaskWidgetDisplay() {
        tasksContainer.isVisibleAfterWaiting();
    }

    private BaseElementFacade getTaskTitleDateFromWidget(String taskName) {
        return findByXpath(String.format("(//*[@id='TasksContainer']//div[@class='v-list-item__title' and text()='%s'])[1]",
                taskName));
    }

    public void checkTaskFromWidget(String taskName) {
        getTaskTitleDateFromWidget(taskName).isVisibleAfterWaiting();
    }

    public void openTaskFromWidget(String taskName) {
        getTaskTitleDateFromWidget(taskName).isVisibleAfterWaiting();
        getTaskTitleDateFromWidget(taskName).clickOnElement();
    }

    @FindBy(xpath = "(//*[@class='taskAssignBtn mt-n1'])")
    private BaseElementFacade taskAssignLink;

    @FindBy(xpath = "(//*[@class='ms-4'])[1]")
    private BaseElementFacade taskAssignMe;

    public void assignTaskToMe() {
        taskAssignLink.isVisibleAfterWaiting();
        taskAssignLink.clickOnElement();
        taskAssignMe.clickOnElement();
    }

    @FindBy(
            xpath = "//*[@class='v-input__control']//i[@class='v-icon notranslate mdi mdi-flag-variant theme--light nonePriorityColor']"
    )
    private BaseElementFacade taskPrioritySelector;

    private BaseElementFacade getTaskPriority(String taskPriority) {
        return findByXpath(
                String.format("//*[@class='taskPriority']//*[@class='v-select__selections']/div[contains(text(),'%s')]",
                        taskPriority));
    }

    private BaseElementFacade selectTaskPriority(String taskPriority) {
        return findByXpath(
                String.format("//*[@class='body-2' and contains(text(),'%s')]", taskPriority));
    }

    public void setTaskPriority(String taskPriority) {
        taskPrioritySelector.isVisibleAfterWaiting();
        taskPrioritySelector.clickOnElement();
        selectTaskPriority(taskPriority).clickOnElement();
    }

    @FindBy(xpath = "//*[@role='button']//*[@class='v-input__icon v-input__icon--append']")
    private BaseElementFacade selectStatusSelector;

    private BaseElementFacade getTaskStatus(String taskStatus) {
        return findByXpath(
                String.format("//*[@class='taskStatus']//*[contains(@class,'v-select__selection--comma') and contains(text(),'%s')]",
                        taskStatus));
    }

    private BaseElementFacade selectTaskStatus(String taskStatus) {
        return findByXpath(
                String.format("//*[@role='listbox']//*[@class='v-list-item__title' and contains(text(),'%s')]",
                        taskStatus));
    }

    public void setTaskStatus(String taskStatus) {
        selectStatusSelector.isVisibleAfterWaiting();
        selectStatusSelector.clickOnElement();
        selectTaskStatus(taskStatus).isVisibleAfterWaiting();
        selectTaskStatus(taskStatus).clickOnElement();
    }

    public void checkTaskStatus(String taskStatus) {
        getTaskStatus(taskStatus).isVisibleAfterWaiting();
    }

    public void checkTaskPriority(String taskPriority) {
        getTaskPriority(taskPriority).isVisibleAfterWaiting();
    }

    private BaseElementFacade getSelectUserInDropDown(String firstUserName) {
        return findByXpath(String.format(
                "//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                firstUserName));
    }

    @FindBy(xpath = "(//div[@name='taskAssignee']//input)[1]")
    private TextBoxElementFacade taskAssignUserInput;

    public void assignTaskToUser(String user) {
        taskAssignLink.isVisibleAfterWaiting();
        taskAssignLink.clickOnElement();
        taskAssignUserInput.setTextValue(user + " ");
        taskAssignUserInput.sendKeys(Keys.BACK_SPACE);
        getSelectUserInDropDown(user).clickOnElement();
    }

    @FindBy(xpath = "(//*[contains(@id,'DatePicker')])[1]//input")
    private TextBoxElementFacade ELEMENT_TASK_START_DATE;

    @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[1]")
    private TextBoxElementFacade ELEMENT_TASK_START_DATE_TODAY;

    @FindBy(xpath = "(//*[contains(@class,'v-date-picker-table__current')])[1]/following::td[1]")
    private TextBoxElementFacade ELEMENT_TASK_START_DATE_TOMORROW;

    @FindBy(
            xpath = "((//div[@class='v-picker__actions v-card__actions']//div[contains(@class,'d-flex flex-wrap')])[02]//button)[03]"
    )
    private TextBoxElementFacade ELEMENT_TASK_DUE_DATE_NEXT_WEEK;

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

    public void setTaskDueDateNextWeek() {
        ELEMENT_TASK_DUE_DATE.waitUntilVisible();
        ELEMENT_TASK_DUE_DATE.clickOnElement();
        ELEMENT_TASK_DUE_DATE_NEXT_WEEK.clickOnElement();
    }

    @FindBy(xpath = "//a[@class='taskTabGantt v-tab']")
    private BaseElementFacade planView;

    public void goToPLanView() {
        planView.waitUntilVisible();
        planView.clickOnElement();
    }

    private BaseElementFacade getTaskNamePlanView(String taskName) {
        return findByXpath(String.format(
                "//*[@class='bar-group']//*[contains(text(),'%s')]",
                taskName));
    }

    public void taskNamePLanView(String taskName) {
        getTaskNamePlanView(taskName).shouldBeVisible();
    }

    public void clickOnTheNotificationThatMentioneFirstUserInATaskInProject(String message, String ProjectName) {
        Assert.assertTrue(firstNotificationContent.getText().contains(message));
        Assert.assertTrue(firstNotificationContent.getText().contains(ProjectName));
        firstNotificationContent.clickOnElement();
    }

    @FindBy(xpath = "//button[contains(@class,'filterTasksSetting v-btn')]")
    private BaseElementFacade filterButton;

    @FindBy(xpath = "//*[@class='nameGroup' and contains (text(), 'Unassigned')]")
    private BaseElementFacade textAssignee;

    @FindBy(xpath = "//*[@class='v-label theme--light'and text()='Assignee']")
    private static BaseElementFacade assigneeRadioButton;

    @FindBy(xpath = "//clearinput[@value='assignee' and @aria-checked='true']")
    private static BaseElementFacade checkAssigneeRadioSelected;

    @FindBy(xpath = "//input[@value='assignee' and @aria-checked='false']")
    private static BaseElementFacade checkAssigneeRadioNotSelected;

    @FindBy(xpath = "//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']")
    private BaseElementFacade confirmButtonDrawer;

    @FindBy(xpath = "//*[@class='uiIcon uiBackIcon']")
    private BaseElementFacade backButtonProject;

    @FindBy(xpath = "//*[@class='v-list-item__action drawerIcons align-end d-flex flex-row']")
    private BaseElementFacade closeDrawerFilter;

    public void clickFilterButton() {
        filterButton.clickOnElement();
    }

    public void clickOnAssigneeRadioButton() {
        assigneeRadioButton.clickOnElement();
    }

    public void clickOnConfirmButton() {
        confirmButtonDrawer.waitUntilVisible();
        confirmButtonDrawer.clickOnElement();
    }

    public void exitFromTheFirstProject() {
        backButtonProject.waitUntilVisible();
        backButtonProject.clickOnElement();
    }

    public void checkRadioButtonSelected() {
        checkAssigneeRadioSelected.isVisibleAfterWaiting();
    }

    public void closeSortAndFilterDrawer() {
        closeDrawerFilter.waitUntilVisible();
        closeDrawerFilter.clickOnElement();
    }

    public void checkRadioButtonNotSelected() {
        checkAssigneeRadioNotSelected.isVisibleAfterWaiting();
    }

    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    public void checkThatTasksAreGroupedByAssignee() {
        textAssignee.shouldBeVisible();
    }

    public void enterDescriptionForTask(String description) {
        taskDescriptionField.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(switchToFrameTask);
        taskDescriptionFieldIframe.waitUntilVisible();
        taskDescriptionFieldIframe.setTextValue(description);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
        TileForTaskField.clickOnElement();
    }

    public void checkDescriptionDisplay(String description) {
        getDescriptionForTask(description).isDisplayed();
    }

    public void editDescriptionForTask(String newDescription) {
        taskDescriptionField.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(switchToFrameTaskUser);
        taskDescriptionFieldIframe.clickOnElement();
        taskDescriptionFieldIframe.waitUntilVisible();
        taskDescriptionFieldIframe.clear();
        taskDescriptionFieldIframe.setTextValue(newDescription);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
        TileForTaskField.clickOnElement();
    }

    @FindBy(xpath = "//*[contains(text(),'Edit task')]")
    private BaseElementFacade checkEditTaskDrawer;

    @FindBy(xpath = "//*[@class='pe-2' and contains(text(),'Last Update')]")
    private BaseElementFacade timesTamp;

    @FindBy(xpath = "//*[@class='lastUpdatedTask pb-3']")
    private BaseElementFacade toolTip;

    @FindBy(xpath = "//*[@class='ps-2' and text()='Changes']")
    private BaseElementFacade checkChangesDrawer;

    @FindBy(xpath = "//*[@class='uiIcon uiArrowBAckIcon']")
    private BaseElementFacade backDrawer;

    public void checkThatEditTaskDrawerIsDisplayed() {
        String checkEditTaskDrawerText = checkEditTaskDrawer.getText();
        Assert.assertEquals("Edit task", checkEditTaskDrawerText);
    }

    public void checkTheTimestampUpdate() {
        String timestampText = timesTamp.getText();
        Assert.assertTrue(timestampText.contains("Last Update"));
    }

    public void hoverOnTheChangesTimestamp() {
        Actions actions = new Actions(driver);
        actions.moveToElement(timesTamp).perform();
    }

    public void checkTooltipIsDisplayed() {
        String toolText = toolTip.getAttribute("title");
        Assert.assertEquals("Click to view all changes", toolText);
    }

    public void clickOnTheTimestamp() {
        timesTamp.clickOnElement();
    }

    public void checkThatSecondLevelDrawerChangesIsOpened() {
        String checkChangesDrawerText = checkChangesDrawer.getText();
        Assert.assertEquals("Changes", checkChangesDrawerText);
    }

    public void switchToTASKSTab() {
        backDrawer.clickOnElement();
    }

    public void setTaskDescription(String Description) {
        taskDescriptionField.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameDescription);
        settaskDescription.sendKeys(Description);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    }

    public void clickOnSaveButtonToAddTaskSpaceProject() {
        SaveButtonTaskSpaceProject.clickOnElement();
    }

    public void updateTaskDescription(String Description) {
        taskDescriptionField.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameDescription);
        settaskDescription.sendKeys(" " + Description);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    }

    public void clickOnUpDateButton() {
        upDateButtonDescription.clickOnElement();
    }

    public void clonetaskinspaceproject() {
        threeDotsIconInEditTask.clickOnElement();
        cloneoption.clickOnElement();
    }

    public void checkUpdatedDescription(String Description) {
        taskDescriptionField.clickOnElement();
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameDescription);
        Assert.assertEquals(settaskDescription.getText(), Description);
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();
    }

    public void hoverOnProjectManagerIcon() {
        projectCardUserFullName.hover("//div[@style='height: 28px; min-width: 28px; width: 28px;']//img[contains(@src,'/portal/rest/v1/social/users/default-image/avatar')]");
    }

}
