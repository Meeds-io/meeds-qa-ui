package io.meeds.qa.ui.pages.page.factory.tasks;

import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
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

public class TasksPage extends GenericPage {

  public TasksPage(WebDriver driver) {
    super(driver);
  }

  public void addFourLabelToProject(String label1, String label2, String label3, String label4) {
    labelTaskElement().sendKeys(label1 + Keys.ENTER + label2 + Keys.ENTER + label3 + Keys.ENTER + label4 + Keys.ENTER);
  }

  public void addLabel(String label) {
    TextBoxElementFacade labelTaskElement = labelTaskElement();
    labelTaskElement.setTextValue(label);
    labelTaskElement.sendKeys(Keys.ENTER);
  }

  public void addLabelToTask(String label) {
    retryOnCondition(() -> {
      labelTaskElement().clickOnElement();
      getAddLabelToTask(label).clickOnElement();
    });
  }

  public void addNewCommentInTask() {
    addNewCommentInTaskElement().clickOnElement();
  }

  public void addNewCommentInTaskWithMentioningTheFirstUserInTask(String comment, String user) {
    mentionUserInCKEditor(ckEditorFrameTaskMentioningUserElement(), taskCommentContentTextBoxElement(), comment, user, true);
    commentTaskButtonElement().clickOnElement();
    closeDrawerIfDisplayed();
  }

  public void addOtherCommentInTask() {
    addOtherCommentInTaskElement().clickOnElement();
  }

  public void addProject(String projectName) {
    addProjectOrTaskElement().clickOnElement();
    projectTitleElement().setTextValue(projectName);
    saveButtonElement().clickOnElement();
  }

  public void addProjectManagerInput(String manager) {
    addManagerBtnElement().clickOnElement();
    mentionInField(inviteProjectManagerInputElement(), manager, 5);
  }

  public void addProjectParticipantInput(String participant) {
    addParticipantBtnElement().clickOnElement();
    mentionInField(inviteProjectParticipantInputElement(), participant, 5);
  }

  public void addProjectWithDescription(String projectName, String description) {
    addProjectOrTaskElement().clickOnElement();
    projectTitleElement().setTextValue(projectName);

    waitCKEditorLoading();
    ElementFacade ckEditorFrameTaskElement = ckEditorFrameTaskElement();
    ckEditorFrameTaskElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTaskElement);
    try {
      TextBoxElementFacade projectDescriptionFieldElement = projectDescriptionFieldElement();
      projectDescriptionFieldElement.waitUntilVisible();
      projectDescriptionFieldElement.setTextValue(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    saveButtonElement().clickOnElement();
  }

  public void addProjectWithFirstCreatedUserAsManger(String projectName, String fullName) {
    addProjectOrTaskElement().clickOnElement();
    projectTitleElement().setTextValue(projectName);
    addProjectManagerInput(fullName);
    saveButtonElement().clickOnElement();
  }

  public void addProjectWithFirstUserAsParticipant(String projectName, String participant) {
    addProjectOrTaskElement().clickOnElement();
    projectTitleElement().setTextValue(projectName);
    addProjectParticipantInput(participant);
    saveButtonElement().clickOnElement();
  }

  public void addProjectWithManager(String projectName, String fullName) {
    addProjectOrTaskElement().clickOnElement();
    projectTitleElement().setTextValue(projectName);
    addManagerBtnElement().clickOnElement();
    mentionInField(inviteProjectManagerInputElement(), fullName, 5);
    saveButtonElement().clickOnElement();
  }

  public void addProjectWithManagerAndParticipant(String projectName, String manager, String participant) {
    addProjectOrTaskElement().clickOnElement();
    projectTitleElement().setTextValue(projectName);
    addProjectManagerInput(manager);
    addProjectParticipantInput(participant);
    saveButtonElement().clickOnElement();
  }

  public void addProjectWithParticipant(String projectName, String lastName) {
    addProjectOrTaskElement().clickOnElement();
    projectTitleElement().setTextValue(projectName);
    addProjectParticipantInput(lastName);
    saveButtonElement().clickOnElement();
  }

  public void addSecondUserToProject(String lastName) {
    addProjectParticipantInput(lastName);
  }

  public void addSixLabelToProject(String label1, String label2, String label3, String label4, String label5, String label6) {
    labelTaskElement().sendKeys(label1 + Keys.ENTER + label2 + Keys.ENTER + label3 + Keys.ENTER + label4 + Keys.ENTER + label5
        + Keys.ENTER
        + label6 + Keys.ENTER);
  }

  public void assignTaskToMe() {
    assertWebElementVisible(taskAssignLinkElement());
    taskAssignLinkElement().clickOnElement();
    taskAssignMeElement().clickOnElement();
  }

  public void assignTaskToUser(String user) {
    assertWebElementVisible(taskAssignLinkElement());
    taskAssignLinkElement().clickOnElement();
    mentionInField(taskAssignUserInputElement(), user, 5);
  }

  public void boardViewIsDisplayedByDefault() {
    assertWebElementVisible(projectActiveBoardViewElement());
  }

  public void cancelFilterButtonIsDisplayed() {
    assertWebElementVisible(cancelFilterButtonElement());
  }

  public void checkAlertMessageAfterDeleteTask() {
    assertWebElementVisible(findByXPathOrCSS("//*[contains(@class, 'v-alert')]//*[contains(text(),'Task successfully deleted')]"));
  }

  public void checkAlertMessageAfterMarkTaskAsCompleted() {
    assertWebElementVisible(alertMessageAfterMarkTaskAsCompletedElement());
  }

  public void checkAlertMessageMoveStatusAfter() {
    assertWebElementVisible(alertMessageAfterStatusMovedElement());
  }

  public void checkAttachmentDisplay(String attachmentName) {
    assertWebElementNotVisible(getAttachmentName(attachmentName));
  }

  public void checkClonedProject(String projectName) {
    assertWebElementVisible(getProjectCard(projectName));
    assertWebElementVisible(alertMessageAfterProjectCloneElement());
  }

  public void checkClonedTask(String taskName) {
    assertWebElementVisible(getTaskTitle(taskName));
  }

  public void checkDeletedProject(String projectName) {
    assertWebElementNotVisible(getProjectCard(projectName));
    assertWebElementVisible(alertMessageAfterProjectDeletionElement());
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
    assertWebElementVisible(filterByProjectElement());
  }

  public void checkDisplayOfFilterByTask() {
    assertWebElementVisible(filterByTaskElement());
  }

  public void checkDrawerDisplay() {
    assertWebElementVisible(drawerTitleElement());
  }

  public void checkFirstStatusColumn(String columnStatus) {
    assertEquals(firstStatusColumnElement().getText(), columnStatus);
  }

  public void checkGroupingSelected(String groupingValue) {
    assertTrue(findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//input[@aria-checked='true' and @value='%s']//ancestor::*[contains(@class, 'v-radio')]",
                                              groupingValue)).isVisibleAfterWaiting());
  }

  public void checkLastStatusColumn(String columnStatus) {
    Assert.assertEquals(lastStatusColumnElement().getText(), columnStatus);
  }

  public void checkMessageEmptyProjectDisplay() {
    assertEquals(projectTitleElement().getText(), "");
  }

  public void checkMoveStatusAfterIconIsNotDisplayed() {
    assertWebElementNotVisible(moveStatusAfterIconElement());
  }

  public void checkMoveStatusBeforeIconIsNotDisplayed() {
    assertWebElementNotVisible(moveStatusBeforeIconElement());
  }

  public void checkProject(String projectName) {
    assertWebElementVisible(getProjectCard(projectName));
    assertWebElementVisible(alertMessageAfterProjectCreationElement());
  }

  public void checkProjectIsCreated() {
    assertWebElementVisible(alertMessageAfterProjectCreationElement());
  }

  public void checkProjectNameIsDisplayedInProjectCard(String projectName, String description) {
    assertWebElementVisible(getProjectCard(projectName));
    assertWebElementVisible(getProjectCardDescription(description));
  }

  public void checkProjectNotDisplayed(String projectName) {
    assertWebElementNotVisible(getProjectCard(projectName));
    assertWebElementNotVisible(alertMessageAfterProjectCreationElement());
  }

  public void checkSecondStatusColumn(String columnStatus) {
    assertEquals(secondStatusColumnElement().getText(), columnStatus);
  }

  public void checkSuccessMessage(String message) {
    assertTrue(successMessageElement().getText().contains(message));
  }

  public void checkTaskPriority(String taskPriority) {
    assertWebElementVisible(getTaskPriority(taskPriority));
  }

  public void checkTaskStatus(String taskStatus) {
    assertWebElementVisible(getTaskStatus(taskStatus));
  }

  public void checkThatEditTaskDrawerIsDisplayed() {
    String checkEditTaskDrawerText = checkEditTaskDrawerElement().getText();
    assertEquals("Edit task", checkEditTaskDrawerText);
  }

  public void checkThatSecondLevelDrawerChangesIsOpened() {
    String checkChangesDrawerText = checkChangesDrawerElement().getText();
    assertEquals("Changes", checkChangesDrawerText);
  }

  public void checkThatTasksAreGroupedByAssignee() {
    assertWebElementVisible(textAssigneeElement());
  }

  public void checkTheTimestampUpdate() {
    String timestampText = timesTampElement().getText();
    assertTrue(timestampText.contains("Last Update"));
  }

  public void checkThirdStatusColumn(String columnStatus) {
    Assert.assertEquals(thirdStatusColumnElement().getText(), columnStatus);
  }

  public void checkTooltipIsDisplayed() {
    String toolText = toolTipElement().getAttribute("title");
    assertEquals("Click to view all changes", toolText);
  }

  public void checkTypedProjectIsRemoved(String typedProject) {
    assertFalse(filterByProjectElement().getText().contains(typedProject));
  }

  public void checkTypedTaskIsRemoved(String typedTask) {
    assertFalse(filterByTaskElement().getText().contains(typedTask));
  }

  public void checkUpdatedDescription(String description) {
    taskDescriptionFieldElement().clickOnElement();

    waitCKEditorLoading();
    ElementFacade ckEditorFrameDescriptionElement = ckEditorFrameDescriptionElement();
    ckEditorFrameDescriptionElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameDescriptionElement);
    try {
      assertEquals(settaskDescriptionElement().getText(), description);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void checkUpdatedProject(String projectName, String description) {
    assertWebElementVisible(getProjectCard(projectName));
    assertWebElementVisible(getProjectCardDescription(description));
    assertWebElementVisible(alertMessageAfterProjectUpdateElement());
  }

  public void checkViewLinkAttachments() {
    assertWebElementVisible(viewAttachmentsLinkElement());
  }

  public void clearButtonInFilterByTaskIsNotVisible() {
    assertWebElementNotVisible(clearButtonInFilterByTaskElement());
  }

  public void clearButtonInFilterByTaskIsVisible() {
    assertWebElementVisible(clearButtonInFilterByTaskElement());
  }

  public void clearButtonIsNotVisible() {
    assertWebElementNotVisible(clearButtonInFilterByProjectElement());
  }

  public void clearButtonIsVisible() {
    assertWebElementVisible(clearButtonInFilterByProjectElement());
  }

  public void clickAddProjectButton() {
    addProjectOrTaskElement().clickOnElement();
  }

  public void clickAddTaskButton() {
    ElementFacade addTaskButton = findByXPathOrCSS(".tasksToolbar button.btn-primary");
    if (addTaskButton.isCurrentlyVisible() && addTaskButton.isVisibleAfterWaiting() && addTaskButton.isClickable()) {
      addTaskButton.clickOnElement();
    } else {
      addTaskInProjectButtonElement().clickOnElement();
    }
  }

  public void clickCancel() {
    cancelButtonElement().clickOnElement();
  }

  public void clickChangeLocation() {
    changeLocationLinkElement().clickOnElement();
  }

  public void clickDelete() {
    deleteButtonElement().clickOnElement();
  }

  public void clickDeleteProjectButton() {
    deleteProjectButtonElement().clickOnElement();
  }

  public void clickDocButton() {
    documentButtonElement().clickOnElement();
  }

  public void clickFilterButton() {
    filterButtonElement().clickOnElement();
    waitForDrawerToOpen();
  }

  public void clickOnAddAttachmentLink() {
    addAttachmentLinkElement().clickOnElement();
  }

  public void clickOnAddStatusAfterOptionOfTheFifthStatusColumn() {
    addStatusafteroptionElement().clickOnElement();
  }

  public void clickOnAddStatusBeforeOption() {
    addStatusBeforeoptionElement().clickOnElement();
  }

  public void clickOnAssigneeRadioButton() {
    assigneeRadioButtonElement().clickOnElement();
  }

  public void clickOnClearButton() {
    clearButtonInFilterByProjectElement().clickOnElement();
  }

  public void clickOnClearButtonInFilterByTask() {
    clearButtonInFilterByTaskElement().clickOnElement();
  }

  public void clickOnCommentReply(String comment) {
    ElementFacade taskCommentReplyBtn = getTaskCommentReplyBtn(comment);
    assertWebElementVisible(taskCommentReplyBtn);
    taskCommentReplyBtn.clickOnElement();
  }

  public void clickOnConfirmButton() {
    confirmButtonDrawerElement().clickOnElement();
  }

  public void clickOnDeleteStatusIcon() {
    deleteStatusIconElement().clickOnElement();
  }

  public void clickOnDeleteTaskOption() {
    deleteTaskOptionElement().clickOnElement();
  }

  public void clickOnEditProjectButton() {
    editProjectButtonElement().clickOnElement();
  }

  public void clickOnFifthColumnThreeDotsIcon() {
    fifthColumnThreeDotsIconElement().clickOnElement();
  }

  public void clickOnLastColumnThreeDotsIcon() {
    lastColumnThreeDotsIconElement().clickOnElement();
  }

  public void clickOnMoveStatusAfterIcon() {
    moveStatusAfterIconElement().clickOnElement();
  }

  public void clickOnMoveStatusBeforeIcon() {
    moveStatusBeforeIconElement().clickOnElement();
  }

  public void clickOnPlusButtonToAddTask() {
    plusButtonToAddTaskElement().clickOnElement();
  }

  public void clickOnPlusButtonToAddTaskOfTheSixthStatusColumn() {
    plusButtonToAddTaskOfTheSixthStatusColumnElement().clickOnElement();
  }

  public void clickOnProjectThreeDotsButton() {
    projectThreeDotsButtonElement().clickOnElement();
  }

  public void clickOnSaveButtonToAddTask() {
    saveButtonTaskElement().clickOnElement();
  }

  public void clickOnSaveButtonToAddTaskSpaceProject() {
    saveButtonTaskSpaceProjectElement().clickOnElement();
  }

  public void clickOnTaskThreeDotsOption() {

    taskThreeDotsOptionElement().clickOnElement();
  }

  public void clickOnTheNotificationThatMentioneFirstUserInATaskInProject(String message, String projectName) {
    ElementFacade firstNotificationContentElement = firstNotificationContentElement();
    firstNotificationContentElement.waitUntilVisible();
    Assert.assertTrue(firstNotificationContentElement.getText().contains(message));
    Assert.assertTrue(firstNotificationContentElement.getText().contains(projectName));
    firstNotificationContentElement.clickOnElement();
  }

  public void clickOnTheTimestamp() {
    timesTampElement().clickOnElement();
  }

  public void clickOnThreeDotsIcon() {
    threeDotsIconElement().clickOnElement();
  }

  public void clickOnUpDateButton() {
    updateButtonDescriptionElement().clickOnElement();
  }

  public void clickOnValidateStatusName() {
    String currentStatusName = statusFieldElement().getValue();
    validateStatusNameElement().clickOnElement();
    // Wait until column is added
    retryOnCondition(() -> getStatusColumn(currentStatusName).waitUntilVisible(),
                     () -> waitFor(2).seconds());
  }

  public void clickPlusIcon() {
    plusIconElement().clickOnElement();
  }

  public void clickPlusIconProject() {
    plusIconProjectElement().clickOnElement();
  }

  public void clickQuickAddTaskButton() {
    quickAddTaskInProjectButtonElement().clickOnElement();
  }

  public void clickSaveProjectButton() {
    saveButtonElement().clickOnElement();
  }

  public void clickStatusName(String statusColumn) {
    getStatusColumn(statusColumn).clickOnElement();
  }

  public void clickViewAttachmentLink() {
    assertWebElementVisible(viewAttachmentsLinkElement());
    viewAttachmentsLinkElement().clickOnElement();
  }

  public void cloneProject(String projectName) {
    assertWebElementVisible(getProjectCard(projectName));
    projectThreeDotsButtonElement().clickOnElement();
    cloneProjectButtonElement().clickOnElement();
    confirmationPopupCloneButtonElement().clickOnElement();
    assertWebElementNotVisible(confirmationPopupCloneButtonElement());

  }

  public void cloneProjectButtonIsDisplayed() {
    assertWebElementVisible(cloneProjectButtonElement());
  }

  public void clonetaskinspaceproject() {
    threeDotsIconInEditTaskElement().clickOnElement();
    cloneoptionElement().clickOnElement();
  }

  public void colorPaletteIsDisplayed() {
    assertWebElementVisible(colorPaletteElement());
  }

  public void commentButtonIsDisabled() {
    commentTaskButtonElement().isDisabledAfterWaiting();
  }

  public void commentsDrawerIsDisplayed() {
    assertWebElementVisible(commentsDrawerSectionElement());
  }

  public void commentTask(String comment) {
    waitCKEditorLoading();
    ElementFacade ckEditorFrameTaskElement = ckEditorFrameTaskElement();
    ckEditorFrameTaskElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTaskElement);
    try {
      TextBoxElementFacade taskCommentContentTextBoxElement = taskCommentContentTextBoxElement();
      taskCommentContentTextBoxElement.waitUntilVisible();
      taskCommentContentTextBoxElement.setTextValue(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    ElementFacade commentTaskButtonElement = commentTaskButtonElement();
    commentTaskButtonElement.waitUntilVisible();
    commentTaskButtonElement.clickOnElement();
    closeDrawerIfDisplayed();
  }

  public void commentTaskWithUser(String user, String comment) {
    getTaskCommentWithUser(user, comment);
  }

  public void completeTask() {
    markTaskCompletedElement().clickOnElement();
  }

  public void confirmDeleteStatusColumn() {
    ElementFacade confirmationPopupDeleteButtonElement = confirmationPopupDeleteButtonElement();
    confirmationPopupDeleteButtonElement.clickOnElement();
    assertWebElementNotVisible(confirmationPopupDeleteButtonElement);
  }

  public void confirmDeleteTaskFromTasksBord() {
    confirmationPopupDeleteButtonElement().clickOnElement();
  }

  public void confirmFilter() {
    confirmFilterButtonElement().clickOnElement();
  }

  public void confirmFilterButtonIsDisplayed() {
    assertWebElementVisible(confirmFilterButtonElement());
  }

  public void deleteCookies() {
    getDriver().manage().deleteAllCookies();
  }

  public void deleteProject(String projectName) {
    assertWebElementVisible(getProjectCard(projectName));
    projectThreeDotsButtonElement().clickOnElement();
    deleteProjectButtonElement().clickOnElement();
    confirmationPopupDeleteButtonElement().clickOnElement();
    assertWebElementNotVisible(confirmationPopupDeleteButtonElement());
  }

  public void deleteProjectButtonIsDisplayed() {
    assertWebElementVisible(deleteProjectButtonElement());
  }

  public void deleteTaskOptionIsDisplayed() {
    assertWebElementVisible(deleteTaskOptionElement());
  }

  public void editDescriptionForTask(String newDescription) {
    taskDescriptionFieldElement().clickOnElement();

    waitCKEditorLoading();
    ElementFacade switchToFrameTaskUserElement = switchToFrameTaskUserElement();
    switchToFrameTaskUserElement.waitUntilVisible();
    getDriver().switchTo().frame(switchToFrameTaskUserElement);
    try {
      TextBoxElementFacade taskDescriptionBodyFieldElement = taskDescriptionBodyFieldElement();
      taskDescriptionBodyFieldElement.waitUntilVisible();
      taskDescriptionBodyFieldElement.setTextValue(newDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    updateButtonDescriptionElement().clickOnElement();
    waitForLoading();
  }

  public void editProjectButtonIsDisplayed() {
    assertWebElementVisible(editProjectButtonElement());
  }

  public void editProjectName(String projectName) {
    projectThreeDotsButtonElement().clickOnElement();
    editProjectButtonElement().clickOnElement();
    projectTitleElement().setTextValue(projectName);
    saveButtonElement().clickOnElement();
  }

  public void editProjectNameWithDescription(String projectName, String newProjectName, String newDescription) {
    assertWebElementVisible(getProjectCard(projectName));
    projectThreeDotsButtonElement().clickOnElement();
    editProjectButtonElement().clickOnElement();
    projectTitleElement().setTextValue(newProjectName);

    waitCKEditorLoading();
    ElementFacade ckEditorFrameTaskElement = ckEditorFrameTaskElement();
    ckEditorFrameTaskElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTaskElement);
    try {
      TextBoxElementFacade projectDescriptionFieldElement = projectDescriptionFieldElement();
      projectDescriptionFieldElement.waitUntilVisible();
      projectDescriptionFieldElement.setTextValue(newDescription);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    saveButtonElement().clickOnElement();
  }

  public void editSpaceName(String spaceName) {
    spaceNameTitleElement().setTextValue(spaceName);
    updateNameSpaceButtonElement().clickOnElement();
  }

  public void editTaskDrawerIsDisplayed() {
    assertWebElementVisible(editTaskDrawerSectionElement());
  }

  public void enterDescriptionForTask(String description) {
    taskDescriptionFieldElement().clickOnElement();

    waitCKEditorLoading();
    ElementFacade switchToFrameTaskElement = switchToFrameTaskElement();
    switchToFrameTaskElement.waitUntilVisible();
    getDriver().switchTo().frame(switchToFrameTaskElement);
    try {
      TextBoxElementFacade taskDescriptionBodyFieldElement = taskDescriptionBodyFieldElement();
      taskDescriptionBodyFieldElement.waitUntilVisible();
      taskDescriptionBodyFieldElement.setTextValue(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void enterProjectDescriptionWithoutTheTitle(String description) {
    addProjectOrTaskElement().clickOnElement();

    waitCKEditorLoading();
    ElementFacade ckEditorFrameTaskElement = ckEditorFrameTaskElement();
    ckEditorFrameTaskElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTaskElement);
    try {
      TextBoxElementFacade projectDescriptionFieldElement = projectDescriptionFieldElement();
      projectDescriptionFieldElement.waitUntilVisible();
      projectDescriptionFieldElement.setTextValue(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void enterProjectTitleAndDescription(String projectName, String description) {
    addProjectOrTaskElement().clickOnElement();
    projectTitleElement().setTextValue(projectName);

    waitCKEditorLoading();
    ElementFacade ckEditorFrameTaskElement = ckEditorFrameTaskElement();
    ckEditorFrameTaskElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTaskElement);
    try {
      TextBoxElementFacade projectDescriptionFieldElement = projectDescriptionFieldElement();
      projectDescriptionFieldElement.waitUntilVisible();
      projectDescriptionFieldElement.setTextValue(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void enterStatusText(String status) {
    statusFieldElement().sendKeys(status);
  }

  public void enterTaskComment(String comment) {
    waitCKEditorLoading();
    ElementFacade ckEditorFrameTaskElement = ckEditorFrameTaskElement();
    ckEditorFrameTaskElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTaskElement);
    try {
      TextBoxElementFacade taskCommentContentTextBoxElement = taskCommentContentTextBoxElement();
      taskCommentContentTextBoxElement.waitUntilVisible();
      taskCommentContentTextBoxElement.setTextValue(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void enterTitleForTask(String title) {
    ElementFacade titleForTaskFieldElement = titleForTaskFieldElement();
    titleForTaskFieldElement.waitUntilVisible();
    titleForTaskFieldElement.sendKeys(title);
  }

  public void exitFromTheFirstProject() {
    backButtonProjectElement().clickOnElement();
  }

  public void goBack() {
    goBackIconElement().clickOnElement();
  }

  public void goToFilterTab() {
    filterTabElement().clickOnElement();
  }

  public void goToGroupAndSortTab() {
    groupAndSortTabElement().clickOnElement();
  }

  public void goToLabelsTab() {
    labelsTabElement().clickOnElement();
  }

  public void goToPLanView() {
    planViewElement().clickOnElement();
  }

  public void goToProjectDetailsList() {
    projectDetailsListButtonElement().clickOnElement();
  }

  public void goToProjectsTab() {
    goToTab(1);
  }

  public void goToTasksTab() {
    goToTab(2);
  }

  public void greenInformationIconIsDisplayed() {
    ElementFacade informationIconElement = informationIconElement();
    assertWebElementVisible(informationIconElement);
    Assert.assertEquals(informationIconElement.getCssValue("color"), "rgba(46, 181, 140, 1)");
  }

  public void hoverOnProjectManagerIcon() {
    projectCardUserFullNameElement().hover("//*[contains(@class, 'spaceAdminContainer')]//*[contains(@class, 'profile-popover')]");
  }

  public void hoverOnTaskName(String task) {
    taskNameInProjectDetails(task).hover();
  }

  public void hoverOnTheChangesTimestamp() {
    Actions actions = new Actions(getDriver());
    actions.moveToElement(timesTampElement()).perform();
  }

  public void isFilterDrawerTabDisplayed(String tab) {
    Assert.assertEquals(activeTabFilterDrawerElement().getText(), tab);
  }

  public void isLabelDisplayedInProjectDetails(String label, String times) {
    assertWebElementVisible(getDisplayedLabel(label, times));
  }

  public void isSearchedTaskDisplayed(String taskName) {
    Assert.assertEquals(taskNameElement().getValue(), taskName);
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
    markTaskCompletedOnTaskCardElement().clickOnElement();
  }

  public void markTaskAsCompletedInProjectDetails(String taskName) {
    getTaskToMarkAsCompleted(taskName).clickOnElement();
  }

  public void maxCharsCount1250InformationIsDisplayed() {
    assertWebElementVisible(maxCharsCountInfoElement());
  }

  public void maxCharsNumberMessageIsDisplayed() {
    commentsDrawerSectionElement().clickOnElement();

    waitCKEditorLoading();
    ElementFacade ckEditorFrameTaskElement = ckEditorFrameTaskElement();
    ckEditorFrameTaskElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTaskElement);
    try {
      assertWebElementVisible(commentTaskMaxCharsMsgElement());
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void more1250CharsInformationIsDisplayed() {
    assertWebElementVisible(more1250CharsCountInfoElement());
    Assert.assertEquals(more1250CharsCountInfoElement().getCssValue("color"), "rgba(188, 67, 67, 1)");
  }

  public void openFilterDrawer() {
    refreshPage();
    filterDrawerButtonElement().clickOnElement();
  }

  public void openProject(String project) {
    getProjectCard(project).clickOnElement();
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
    getTaskTitleInTasksTab(taskName).clickOnElement();
  }

  public void projectDrawerNotClosing() {
    assertTrue(findByXPathOrCSS(".v-navigation-drawer--open").isVisible());
  }

  public void projectIsDisplayedInTasksAppCenter(String projectName) {
    assertWebElementVisible(getProjectCard(projectName));
  }

  public void projectNameIsDisplayedInProjectDetails(String projectName) {
    assertWebElementVisible(projectNameInProjectDetails(projectName));
  }

  public void redInformationIconIsDisplayed() {
    assertWebElementVisible(informationIconElement());
    Assert.assertEquals(informationIconElement().getCssValue("color"), "rgba(188, 67, 67, 1)");
  }

  public void removeLabelToProject(String label) {
    // Labels are retrieved from Server, thus we should wait until it's loaded,
    // in addition, no loading effect is visible in project drawer
    retryOnCondition(() -> findByXPathOrCSS(".projectLabelsName .v-chip").waitUntilVisible());
    getRemoveLabelButton(label).clickOnElement();
  }

  public void replyTaskCommentButtonIsDisabled() {
    replyTaskCommentButtonElement().isDisabledAfterWaiting();
  }

  public void resetFilterButtonIsDisplayed() {
    assertWebElementVisible(resetFilterButtonElement());
  }

  public void returnToProjectsTab() {
    arrowBackButtonElement().clickOnElement();
  }

  public void saveAddingProject() {
    saveButtonElement().clickOnElement();
  }

  public void saveAddTaskButton() {
    saveButtonElement().clickOnElement();
  }

  public void saveQuickTask() {
    taskQuickNameFieldElement().sendKeys(Keys.ENTER);
  }

  public void searchTask(String taskName) {
    searchTaskNameElement().sendKeys(taskName);
  }

  public void selectFilterOption(String label) {
    getFilterOption(label).clickOnElement();
  }

  public void setInSearchProjectField(String project) {
    searchProjectInputElement().setTextValue(project);
    waitFor(1).seconds();
    waitForLoading();
  }

  public void setProjectTitle(String projectTitle) {
    projectTitleInputElement().setTextValue(projectTitle);
  }

  public void setQuickTaskName(String taskName) {
    taskQuickNameFieldElement().setTextValue(taskName);
  }

  public void setTaskCompletedInDrawer() {
    markTaskCompletedInDrawerElement().clickOnElement();
    closeDrawerIfDisplayed();
  }

  public void setTaskCompletedInDrawerWithoutClosingIt() {
    markTaskCompletedInDrawerElement().clickOnElement();
  }

  public void setTaskDescription(String description) {
    taskDescriptionFieldElement().clickOnElement();

    waitCKEditorLoading();
    ElementFacade ckEditorFrameDescriptionElement = ckEditorFrameDescriptionElement();
    ckEditorFrameDescriptionElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameDescriptionElement);
    try {
      settaskDescriptionElement().sendKeys(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void setTaskDueDateNextWeek() {
    taskDueDateElement().clickOnElement();
    taskDueDateNextWeekElement().clickOnElement();
  }

  public void setTaskDueDateToday() {
    taskDueDateElement().clickOnElement();
    taskDueDateTodayElement().clickOnElement();
  }

  public void setTaskDueDateTomorrow() {
    taskDueDateElement().clickOnElement();
    taskDueDateTomorrowElement().clickOnElement();
  }

  public void setTaskName(String taskName) {
    taskNameFieldElement().setTextValue(taskName);
  }

  public void setTaskPriority(String taskPriority) {
    assertWebElementVisible(taskPrioritySelectorElement());
    taskPrioritySelectorElement().clickOnElement();
    selectTaskPriority(taskPriority).clickOnElement();
  }

  public void setTaskStartDateToday() {
    taskStartDateElement().clickOnElement();
    taskStartDateTodayElement().clickOnElement();
  }

  public void setTaskStartDateTomorrow() {
    taskStartDateElement().clickOnElement();
    taskStartDateTomorrowElement().clickOnElement();
  }

  public void setTaskStatus(String taskStatus) {
    selectStatusSelectorElement().clickOnElement();
    selectTaskStatus(taskStatus).clickOnElement();
  }

  public void switchToTASKSTab() {
    backDrawerElement().clickOnElement();
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
    assertWebElementVisible(taskMarkedAsCompletedInDrawerElement());
  }

  public void taskNameAndLabelIsDisplayedInProjectDetails(String label, String taskName) {
    Assert.assertTrue(taskNameAndLabelAndNumberInProjectDetails(taskName).getText().contains(label));
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
    Assert.assertEquals(taskTooltipElement().getText(), task);
  }

  public void updateTaskDescription(String description) {
    taskDescriptionFieldElement().clickOnElement();

    waitCKEditorLoading();
    ElementFacade ckEditorFrameDescriptionElement = ckEditorFrameDescriptionElement();
    ckEditorFrameDescriptionElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameDescriptionElement);
    try {
      settaskDescriptionElement().sendKeys(" " + description);
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
    Assert.assertEquals(projectCardUserFullNameElement().getText(), name);
  }

  public void userFullNameIsNotDisplayedInProjectCard(String name) {
    Assert.assertNotEquals(projectCardUserFullNameElement().getText(), name);
  }

  public void verifyViewLinkAttachments() {
    assertWebElementNotVisible(viewAttachmentsLinkElement());
  }

  public void viewAllCommentsTaskButton() {
    ElementFacade viewAllCommentsTaskButtonElement = viewAllCommentsTaskButtonElement();
    viewAllCommentsTaskButtonElement.waitUntilVisible();
    viewAllCommentsTaskButtonElement.clickOnElement();
  }

  private ElementFacade activeTabFilterDrawerElement() {
    return findByXPathOrCSS("//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab--active') and @aria-selected='true']");
  }

  private ElementFacade addAttachmentLinkElement() {
    return findByXPathOrCSS("//div[@id='attachmentIntegration']//button[contains(@class,'v-btn v-btn--flat')]");
  }

  private TextBoxElementFacade addManagerBtnElement() {
    return findTextBoxByXPathOrCSS("//*[@class='editManager']//*[@class='editManager']//i[contains(@class,'uiIconProject')]");
  }

  private ElementFacade addNewCommentInTaskElement() {
    return findByXPathOrCSS("//*[@class='ViewAllCommentText']");
  }

  private ElementFacade addOtherCommentInTaskElement() {
    return findByXPathOrCSS("//button[contains(@class,'addCommentBtn')]");
  }

  private TextBoxElementFacade addParticipantBtnElement() {
    return findTextBoxByXPathOrCSS("//*[@class='editParticipant']//i[@class='fas fa-plus']");
  }

  private ElementFacade addProjectOrTaskElement() {
    return findByXPathOrCSS("//*[contains(@class, 'tasksToolbar')]//button[contains(@class, 'btn-primary')]");
  }

  private ElementFacade addStatusafteroptionElement() {
    return findByXPathOrCSS("(//*[contains(@class,'uiIcon uiIconRotateRight')])[2]");
  }

  private ElementFacade addStatusBeforeoptionElement() {
    return findByXPathOrCSS("(//*[contains(@class,'uiIconRotateLeft')])[1]");
  }

  private ElementFacade addTaskInProjectButtonElement() {
    return findByXPathOrCSS(".tasksViewBoardRowContainer .tasksViewHeader .uiIconSocSimplePlus");
  }

  private TextBoxElementFacade alertMessageAfterMarkTaskAsCompletedElement() {
    return findTextBoxByXPathOrCSS("//*[contains(text(),'Task successfully marked as archived')]");
  }

  private TextBoxElementFacade alertMessageAfterProjectCloneElement() {
    return findTextBoxByXPathOrCSS("//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully cloned')]");
  }

  private TextBoxElementFacade alertMessageAfterProjectCreationElement() {
    return findTextBoxByXPathOrCSS("//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully created')]");
  }

  private TextBoxElementFacade alertMessageAfterProjectDeletionElement() {
    return findTextBoxByXPathOrCSS("//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully deleted')]");
  }

  private TextBoxElementFacade alertMessageAfterProjectUpdateElement() {
    return findTextBoxByXPathOrCSS("//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Project successfully updated')]");
  }

  private TextBoxElementFacade alertMessageAfterStatusMovedElement() {
    return findTextBoxByXPathOrCSS("//*[@class='v-alert v-sheet theme--dark success']//*[@class='v-alert__content' and contains(text(),'Status successfully moved')]");
  }

  private ElementFacade arrowBackButtonElement() {
    return findByXPathOrCSS("//*[@class='uiIcon uiBackIcon']");
  }

  private ElementFacade assigneeRadioButtonElement() {
    return findByXPathOrCSS("//*[@class='v-label theme--light'and text()='Assignee']");
  }

  private ElementFacade backButtonProjectElement() {
    return findByXPathOrCSS("//*[@class='uiIcon uiBackIcon']");
  }

  private ElementFacade backDrawerElement() {
    return findByXPathOrCSS("//*[@class='uiIcon uiArrowBAckIcon']");
  }

  private TextBoxElementFacade cancelButtonElement() {
    return findTextBoxByXPathOrCSS("//*[@class='v-card__actions']//button[contains(@class,'btn ms-2')]");
  }

  private ElementFacade cancelFilterButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Cancel')][1]");
  }

  private ElementFacade changeLocationLinkElement() {
    return findByXPathOrCSS("//a[@title='Change location']");
  }

  private ElementFacade checkChangesDrawerElement() {
    return findByXPathOrCSS("//*[@class='ps-2' and text()='Changes']");
  }

  private ElementFacade checkEditTaskDrawerElement() {
    return findByXPathOrCSS("//*[contains(text(),'Edit task')]");
  }

  private ElementFacade ckEditorFrameDescriptionElement() {
    return findByXPathOrCSS("//*[@class='cke_wysiwyg_frame cke_reset']");
  }

  private ElementFacade ckEditorFrameTaskElement() {
    return findByXPathOrCSS("//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private ElementFacade ckEditorFrameTaskMentioningUserElement() {
    return findByXPathOrCSS("(//iframe[contains(@class,'cke_wysiwyg_frame')])[2]");
  }

  private TextBoxElementFacade clearButtonInFilterByProjectElement() {
    return findTextBoxByXPathOrCSS("//*[@id='ProjectListToolbar']//button[contains(@class,' mdi-close theme')]");
  }

  private TextBoxElementFacade clearButtonInFilterByTaskElement() {
    return findTextBoxByXPathOrCSS("//*[@id='TasksListToolbar']//button[contains(@class,' mdi-close theme')]");
  }

  private ElementFacade cloneoptionElement() {
    return findByXPathOrCSS("//*[contains (@class, 'uiIconCloneNode')]");
  }

  private ElementFacade cloneProjectButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiIconCloneNode ')]");
  }

  private ElementFacade colorPaletteElement() {
    return findByXPathOrCSS("//*[contains(@class,'projectColorPicker')]");
  }

  private ElementFacade commentsDrawerSectionElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-list-item__content drawerTitle')]//span[contains(text(),'Comments')]");
  }

  private ElementFacade commentTaskButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'newCommentEditor')]//button");
  }

  private TextBoxElementFacade commentTaskMaxCharsMsgElement() {
    return findTextBoxByXPathOrCSS(")]");
  }

  private ElementFacade confirmationPopupCloneButtonElement() {
    return findByXPathOrCSS("//*[@class='ignore-vuetify-classes btn btn-primary me-2']");
  }

  private ElementFacade confirmationPopupDeleteButtonElement() {
    return findByXPathOrCSS("//*[@class='ignore-vuetify-classes btn btn-primary me-2']");
  }

  private ElementFacade confirmButtonDrawerElement() {
    return findByXPathOrCSS("//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']");
  }

  private ElementFacade confirmFilterButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Confirm')]");
  }

  private ElementFacade deleteButtonElement() {
    return findByXPathOrCSS("//*[@class='v-card__actions']//button[contains(@class,'btn btn-primary')]");
  }

  private ElementFacade deleteProjectButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiIconTrash ')]");
  }

  private ElementFacade deleteStatusIconElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiIconDelete')]");
  }

  private ElementFacade deleteTaskOptionElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiIconTrash ')]");
  }

  private ElementFacade documentButtonElement() {
    return findByXPathOrCSS("//*[contains(@class ,'flex document-timeline-header ')]//button[contains(@class,'v-btn v-btn--flat')]");
  }

  private ElementFacade drawerTitleElement() {
    return findByXPathOrCSS("//span[contains(text(),'Select Folder')]");
  }

  private ElementFacade editProjectButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiIconEdit ')]");
  }

  private ElementFacade editTaskDrawerSectionElement() {
    return findByXPathOrCSS("//*[@class='drawerTitleAndProject d-flex']//span[contains(text(),'Edit task')]");
  }

  private ElementFacade fifthColumnThreeDotsIconElement() {
    return findByXPathOrCSS("(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[5]");
  }

  private ElementFacade filterButtonElement() {
    return findByXPathOrCSS("//button[contains(@class,'filterTasksSetting v-btn')]");
  }

  private TextBoxElementFacade filterByProjectElement() {
    return findTextBoxByXPathOrCSS("//input[@placeholder='Filter by project']");
  }

  private TextBoxElementFacade filterByTaskElement() {
    return findTextBoxByXPathOrCSS("//input[@placeholder='Filter by task']");
  }

  private ElementFacade filterDrawerButtonElement() {
    return findByXPathOrCSS("//button[contains(@class,'filterTasksSetting')]//span[contains(@class,'d-sm-inline')]");
  }

  private ElementFacade filterTabElement() {
    return findByXPathOrCSS("//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Filter')]");
  }

  private ElementFacade firstNotificationContentElement() {
    return findByXPathOrCSS("(//*[contains(@class,'drawerContent')]//*[@class='contentSmall'])[1]");
  }

  private ElementFacade firstStatusColumnElement() {
    return findByXPathOrCSS("(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[1]");
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

  private ElementFacade goBackIconElement() {
    return findByXPathOrCSS("//div[@class='drawerTitle']/button[@type='button']");
  }

  private void goToTab(int tabIndex) {
    ElementFacade tabLink =
                          findByXPathOrCSS(String.format("//*[contains(@class, 'tasksMenuParent')]//*[@role='tab'][%s]",
                                                         tabIndex));
    clickOnElement(tabLink);
    waitForLoading();
    waitFor(300).milliseconds(); // Wait for Tab switch
  }

  private ElementFacade groupAndSortTabElement() {
    return findByXPathOrCSS("//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Group and Sort')]");
  }

  private ElementFacade informationIconElement() {
    return findByXPathOrCSS("//*[@class='uiIconMessageLength']");
  }

  private TextBoxElementFacade inviteProjectManagerInputElement() {
    return findTextBoxByXPathOrCSS("//*[@class='editManager']//input[@content-class='identitySuggesterContent']");
  }

  private TextBoxElementFacade inviteProjectParticipantInputElement() {
    return findTextBoxByXPathOrCSS("//*[@class='editParticipant']//input[@content-class='identitySuggesterContent']");
  }

  private ElementFacade labelsTabElement() {
    return findByXPathOrCSS("//*[contains(@class,'filterTasksDrawer ')]//*[contains(@class,'v-tab') and contains(text(),'Labels')]");
  }

  private TextBoxElementFacade labelTaskElement() {
    return findTextBoxByXPathOrCSS("//*[@id='labelInput']");
  }

  private ElementFacade lastColumnThreeDotsIconElement() {
    return findByXPathOrCSS("(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[4]");
  }

  private ElementFacade lastStatusColumnElement() {
    return findByXPathOrCSS("(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[4]");
  }

  private ElementFacade markTaskCompletedElement() {
    return findByXPathOrCSS("//*[@class='tasksListItem']//*[@class='taskCheckBox']");
  }

  private ElementFacade markTaskCompletedInDrawerElement() {
    return findByXPathOrCSS("//button[@id='check_btn']");
  }

  private ElementFacade markTaskCompletedOnTaskCardElement() {
    return findByXPathOrCSS("//*[contains(@class,'taskViewCard')]//*[@class='taskCheckBox']");
  }

  private ElementFacade maxCharsCountInfoElement() {
    return findByXPathOrCSS("//*[@class='activityCharsCount' and contains(text(),'0 / 1250')]");
  }

  private ElementFacade more1250CharsCountInfoElement() {
    return findByXPathOrCSS("//*[@class='activityCharsCount tooManyChars']");
  }

  private ElementFacade moveStatusAfterIconElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiIconArrowRight ')]");
  }

  private ElementFacade moveStatusBeforeIconElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiIconArrowLeft ')]");
  }

  private ElementFacade openTask(String projectName) {
    return findByXPathOrCSS(
                            String.format("//span[contains(@class,'taskTitleEllipsis') and contains(text(),'%s')]", projectName));
  }

  private ElementFacade planViewElement() {
    return findByXPathOrCSS("//a[@class='taskTabGantt v-tab']");
  }

  private ElementFacade plusButtonToAddTaskElement() {
    return findByXPathOrCSS("(//*[@title='Add Task'])[1]");
  }

  private ElementFacade plusButtonToAddTaskOfTheSixthStatusColumnElement() {
    return findByXPathOrCSS("(//*[@title='Add Task'])[6]");
  }

  private ElementFacade plusIconElement() {
    return findByXPathOrCSS("(//div[@class='pe-0 v-list-item theme--light']//button[@type='button'])[7]");
  }

  private ElementFacade plusIconProjectElement() {
    return findByXPathOrCSS("(//div[contains(@class,'v-list-item__action drawerIcons')]//button)[7]");
  }

  private ElementFacade projectActiveBoardViewElement() {
    return findByXPathOrCSS("//*[@class='taskTabBoard v-tab v-tab--active']");
  }

  private ElementFacade projectCardUserFullNameElement() {
    return findByXPathOrCSS("(//*[contains(@class,'profile-popover')]//a[contains(@id,'userAvatar')]/following::div[contains(@class,'ms-2')])[2]");
  }

  private TextBoxElementFacade projectDescriptionFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private ElementFacade projectDetailsListButtonElement() {
    return findByXPathOrCSS("//*[@class='uiIcon uiIconList']");
  }

  private ElementFacade projectNameInProjectDetails(String projectName) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class, 'projectTasksDashboard')]",
                                          projectName));
  }

  private ElementFacade projectThreeDotsButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiIconVerticalDots')]");
  }

  private TextBoxElementFacade projectTitleElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'projectInputTitle')]");
  }

  private TextBoxElementFacade projectTitleInputElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'addProjectTitle ')]//input");
  }

  private ElementFacade quickAddTaskInProjectButtonElement() {
    return findByXPathOrCSS("//button[contains(@class, 'quickAddNewTaskButton')]");
  }

  private ElementFacade replyTaskCommentButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'editorContent commentEditorContainer')]//button");
  }

  private ElementFacade resetFilterButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'filterSortTasksDrawer')]//following::*[contains(text(),'Reset')]");
  }

  private ElementFacade saveButtonElement() {
    return findByXPathOrCSS("//*[@class='d-flex']//button[2]");
  }

  private ElementFacade saveButtonTaskElement() {
    return findByXPathOrCSS("(//*[@class='d-flex']//button[2])[2]");
  }

  private ElementFacade saveButtonTaskSpaceProjectElement() {
    return findByXPathOrCSS("(//*[@class='d-flex']//button[2])");
  }

  private TextBoxElementFacade searchProjectInputElement() {
    return findTextBoxByXPathOrCSS("//div[@id='projectBoardToolbar']//input");
  }

  private ElementFacade searchTaskNameElement() {
    return findByXPathOrCSS("//*[@id='TasksListToolbar']//*[@class='v-text-field__slot']//input");
  }

  private ElementFacade secondStatusColumnElement() {
    return findByXPathOrCSS("(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[2]");
  }

  private ElementFacade selectStatusSelectorElement() {
    return findByXPathOrCSS("//*[@role='button']//*[@class='v-input__icon v-input__icon--append']");
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

  private TextBoxElementFacade settaskDescriptionElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'cke_editable cke_editabl')]");
  }

  private TextBoxElementFacade spaceNameTitleElement() {
    return findTextBoxByXPathOrCSS("//*[@placeholder='Display name']");
  }

  private ElementFacade statusFieldElement() {
    return findByXPathOrCSS("//*[@placeholder='Enter a name for this status']");
  }

  private TextBoxElementFacade successMessageElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'drawerParent attachmentsListDrawer')]/following::*[@class='v-alert__content'][1]//span");
  }

  private ElementFacade switchToFrameTaskElement() {
    return findByXPathOrCSS("(//iframe[contains(@class,'cke_wysiwyg_frame')])[2]");
  }

  private ElementFacade switchToFrameTaskUserElement() {
    return findByXPathOrCSS("(//iframe[contains(@class,'cke_wysiwyg_frame')])");
  }

  private ElementFacade taskAssignLinkElement() {
    return findByXPathOrCSS("(//*[@class='taskAssignBtn mt-n1'])");
  }

  private ElementFacade taskAssignMeElement() {
    return findByXPathOrCSS("(//*[@class='ms-4'])[1]");
  }

  private TextBoxElementFacade taskAssignUserInputElement() {
    return findTextBoxByXPathOrCSS("(//div[@name='taskAssignee']//input)[1]");
  }

  private TextBoxElementFacade taskCommentContentTextBoxElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private TextBoxElementFacade taskDescriptionBodyFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

  private TextBoxElementFacade taskDescriptionFieldElement() {
    return findTextBoxByXPathOrCSS("//*[@id='taskDescriptionId']");
  }

  private TextBoxElementFacade taskDueDateElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@id,'DatePicker')])[2]//input");
  }

  private TextBoxElementFacade taskDueDateNextWeekElement() {
    return findTextBoxByXPathOrCSS("((//div[@class='v-picker__actions v-card__actions']//div[contains(@class,'d-flex flex-wrap')])[02]//button)[03]");
  }

  private TextBoxElementFacade taskDueDateTodayElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@class,'v-date-picker-table__current')])[2]");
  }

  private TextBoxElementFacade taskDueDateTomorrowElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@class,'v-date-picker-table__current')])[2]/following::td[1]");
  }

  private TextBoxElementFacade taskMarkedAsCompletedInDrawerElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'taskCompleted')]//textarea");
  }

  private ElementFacade taskNameAndLabelAndNumberInProjectDetails(String taskName) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'taskStatusName')]//*[@title='To Do']/following::*[@class='taskTitleEllipsis' and contains(text(),'%s')]/following::*[contains(@class,'taskLabels')]//span[@class='text-truncate'])[1]",
                                          taskName));
  }

  private ElementFacade taskNameElement() {
    return findByXPathOrCSS("//*[@id='task-Drawer']//*[@id='task-name']");
  }

  private TextBoxElementFacade taskNameFieldElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'taskTitleAndMark')]//textarea");
  }

  private ElementFacade taskNameInProjectDetails(String taskName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'taskTitle')]//*[@title = '%s']",
                                          taskName));
  }

  private ElementFacade taskPrioritySelectorElement() {
    return findByXPathOrCSS("//*[@class='v-input__control']//i[@class='v-icon notranslate mdi mdi-flag-variant theme--light nonePriorityColor']");
  }

  private TextBoxElementFacade taskQuickNameFieldElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class, 'task-name')]//input");
  }

  private TextBoxElementFacade taskStartDateElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@id,'DatePicker')])[1]//input");
  }

  private TextBoxElementFacade taskStartDateTodayElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@class,'v-date-picker-table__current')])[1]");
  }

  private TextBoxElementFacade taskStartDateTomorrowElement() {
    return findTextBoxByXPathOrCSS("(//*[contains(@class,'v-date-picker-table__current')])[1]/following::td[1]");
  }

  private ElementFacade taskThreeDotsOptionElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiThreeDotsIcon')]");
  }

  private ElementFacade taskTooltipElement() {
    return findByXPathOrCSS("#TasksManagementPortlet .taskCard .taskTitleId .taskTitle");
  }

  private ElementFacade textAssigneeElement() {
    return findByXPathOrCSS("//*[@class='nameGroup' and contains (text(), 'Unassigned')]");
  }

  private ElementFacade thirdStatusColumnElement() {
    return findByXPathOrCSS("(//*[contains(@id,'task-board')]//*[contains(@class,'statusName')])[3]");
  }

  private ElementFacade threeDotsIconElement() {
    return findByXPathOrCSS("(//*[@class='d-flex tasksViewHeaderLeft']/following::*[contains(@class,'uiIconVerticalDots')][1])[1]");
  }

  private ElementFacade threeDotsIconInEditTaskElement() {
    return findByXPathOrCSS("//*[contains(@class,'uiThreeDotsIcon')]");
  }

  private ElementFacade timesTampElement() {
    return findByXPathOrCSS("//*[@class='pe-2' and contains(text(),'Last Update')]");
  }

  private ElementFacade titleForTaskFieldElement() {
    return findByXPathOrCSS("//*[@placeholder='Enter a title for this task']");
  }

  private ElementFacade toolTipElement() {
    return findByXPathOrCSS("//*[@class='lastUpdatedTask pb-3']");
  }

  private ElementFacade updateButtonDescriptionElement() {
    return findByXPathOrCSS("//*[@id='saveDescriptionButton']");
  }

  private ElementFacade updateNameSpaceButtonElement() {
    return findByXPathOrCSS("//*[@class='btn btn-primary v-btn v-btn--contained theme--light v-size--default']");
  }

  private ElementFacade validateStatusNameElement() {
    return findByXPathOrCSS(" //*[contains(@class,'uiIcon40x40TickBlue')]");
  }

  private ElementFacade viewAllCommentsTaskButtonElement() {
    return findByXPathOrCSS("//*[@class='ViewAllCommentLabel']");
  }

  private ElementFacade viewAttachmentsLinkElement() {
    return findByXPathOrCSS("//div[@class='attachmentsList']//a[@class='viewAllAttachments primary--text font-weight-bold text-decoration-underline']");
  }
}
