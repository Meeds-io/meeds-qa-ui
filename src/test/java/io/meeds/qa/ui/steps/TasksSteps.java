package io.meeds.qa.ui.steps;

import java.util.Map;

import io.meeds.qa.ui.pages.page.factory.tasks.TasksPage;

public class TasksSteps {

  private static final String TASK_NAME_PARAM = "taskName";

  private TasksPage           tasksPage;

  public void addFourLabelToProject(String label1, String label2, String label3, String label4) {
    tasksPage.addFourLabelToProject(label1, label2, label3, label4);
  }

  public void addLabelToProject(String label) {
    tasksPage.addLabelToProject(label);
  }

  public void addLabelToTask(String label) {
    tasksPage.addLabelToTask(label);
  }

  public void addNewCommentInTask(String comment) {
    tasksPage.addNewCommentInTask();
    tasksPage.commentTask(comment);
  }

  public void addNewCommentInTaskWithMentioningTheFirstUserInTask(String comment, String user) {
    tasksPage.addNewCommentInTaskWithMentioningTheFirstUserInTask(comment, user);
  }

  public void addOtherCommentInTask(String comment) {
    tasksPage.addOtherCommentInTask();
    tasksPage.commentTask(comment);
  }

  public void addProject(String projectName) {
    tasksPage.addProject(projectName);
  }

  public void addProjectWithDescription(String projectName, String description) {
    tasksPage.addProjectWithDescription(projectName, description);
  }

  public void addProjectWithFirstCreatedUserAsManger(String projectName, String fullName) {
    tasksPage.addProjectWithFirstCreatedUserAsManger(projectName, fullName);
  }

  public void addProjectWithManager(String projectName, String fullName) {
    tasksPage.addProjectWithManager(projectName, fullName);
  }

  public void addProjectWithManagerAndParticipant(String projectName, String manager, String participant) {
    tasksPage.addProjectWithManagerAndParticipant(projectName, manager, participant);
  }

  public void addProjectWithParticipant(String projectName, String lastName) {
    tasksPage.addProjectWithParticipant(projectName, lastName);

  }

  public void addSecondUserToProject(String lastName) {
    tasksPage.addSecondUserToProject(lastName);
  }

  public void addSimpleTaskProject(Map<String, String> taskDetails) {
    tasksPage.clickQuickAddTaskButton();
    tasksPage.setQuickTaskName(taskDetails.get(TASK_NAME_PARAM));
    tasksPage.saveQuickTask();
  }

  public void addSixLabelToProject(String label1, String label2, String label3, String label4, String label5, String label6) {
    tasksPage.addSixLabelToProject(label1, label2, label3, label4, label5, label6);
  }

  public void addTaskInProject(Map<String, String> taskDetails) {
    tasksPage.clickAddTaskButton();
    tasksPage.setTaskName(taskDetails.get(TASK_NAME_PARAM));
    tasksPage.saveAddTaskButton();
  }

  public void addTaskWithLabelInProject(String label, Map<String, String> taskDetails) {
    tasksPage.clickAddTaskButton();
    tasksPage.setTaskName(taskDetails.get(TASK_NAME_PARAM));
    tasksPage.enterLabelTask(label);
    tasksPage.saveAddTaskButton();
  }

  public void assignTaskToMe() {
    tasksPage.assignTaskToMe();
  }

  public void assignTaskToUser(String user) {
    tasksPage.assignTaskToUser(user);
  }

  public void boardViewIsDisplayedByDefault() {
    tasksPage.boardViewIsDisplayedByDefault();
  }

  public void cancelFilterButtonIsDisplayed() {
    tasksPage.cancelFilterButtonIsDisplayed();
  }

  public void checkAlertMessageAfterDeleteTask() {
    tasksPage.checkAlertMessageAfterDeleteTask();
  }

  public void checkAlertMessageAfterMarkTaskAsCompleted() {
    tasksPage.checkAlertMessageAfterMarkTaskAsCompleted();
  }

  public void checkAlertMessageMoveStatusAfter() {
    tasksPage.checkAlertMessageMoveStatusAfter();
  }

  public void checkAttachmentDisplay(String attachmentName) {
    tasksPage.checkAttachmentDisplay(attachmentName);
  }

  public void checkClonedProject(String projectName) {

    tasksPage.checkClonedProject(projectName);
  }

  public void checkClonedTask(String taskName) {
    tasksPage.checkClonedTask(taskName);

  }

  public void checkDeletedProject(String projectName) {
    tasksPage.checkDeletedProject(projectName);
  }

  public void checkDeletedStatus(String statusColumn) {
    tasksPage.checkDeletedStatus(statusColumn);
  }

  public void checkDeletedTask(String taskName) {
    tasksPage.checkDeletedTaskIsNotDisplayed(taskName);
  }

  public void checkDescriptionDisplay(String description) {
    tasksPage.checkDescriptionDisplay(description);
  }

  public void checkDisplayOfFilterByProject() {
    tasksPage.checkDisplayOfFilterByProject();
  }

  public void checkDisplayOfFilterByTask() {
    tasksPage.checkDisplayOfFilterByTask();
  }

  public void checkDrawerDisplay() {
    tasksPage.checkDrawerDisplay();
  }

  public void checkEditedProject(String projectName, String description) {
    tasksPage.checkUpdatedProject(projectName, description);
  }

  public void checkFirstStatusColumn(String columnStatus) {
    tasksPage.checkFirstStatusColumn(columnStatus);
  }

  public void checkGroupingSelected(String groupingValue) {
    tasksPage.checkGroupingSelected(groupingValue);
  }

  public void checkLastStatusColumn(String columnStatus) {
    tasksPage.checkLastStatusColumn(columnStatus);

  }

  public void checkMessageSaveEmptyProject() {
    tasksPage.checkMessageEmptyProjectDisplay();
  }

  public void checkMoveStatusAfterIconIsNotDisplayed() {
    tasksPage.checkMoveStatusAfterIconIsNotDisplayed();
  }

  public void checkMoveStatusBeforeIconIsNotDisplayed() {
    tasksPage.checkMoveStatusBeforeIconIsNotDisplayed();
  }

  public void checkProjectIsCreated() {
    tasksPage.checkProjectIsCreated();
  }

  public void checkProjectIsDisplayed(String projectName) {
    tasksPage.checkProject(projectName);
  }

  public void checkProjectNameIsDisplayedInProjectCard(String projectName, String description) {
    tasksPage.checkProjectNameIsDisplayedInProjectCard(projectName, description);
  }

  public void checkProjectNotDisplayed(String projectName) {
    tasksPage.checkProjectNotDisplayed(projectName);
  }

  public void checkSecondStatusColumn(String columnStatus) {
    tasksPage.checkSecondStatusColumn(columnStatus);
  }

  public void checkSuccessMessage(String message) {
    tasksPage.checkSuccessMessage(message);
  }

  public void checkTaskPriority(String taskPriority) {
    tasksPage.checkTaskPriority(taskPriority);
  }

  public void checkTaskStatus(String taskStatus) {
    tasksPage.checkTaskStatus(taskStatus);
  }

  public void checkThatEditTaskDrawerIsDisplayed() {
    tasksPage.checkThatEditTaskDrawerIsDisplayed();
  }

  public void checkThatSecondLevelDrawerChangesIsOpened() {
    tasksPage.checkThatSecondLevelDrawerChangesIsOpened();
  }

  public void checkThatTasksAreGroupedByAssignee() {
    tasksPage.checkThatTasksAreGroupedByAssignee();
  }

  public void checkTheTimestampUpdate() {
    tasksPage.checkTheTimestampUpdate();
  }

  public void checkThirdStatusColumn(String columnStatus) {
    tasksPage.checkThirdStatusColumn(columnStatus);
  }

  public void checkTooltipIsDisplayed() {
    tasksPage.checkTooltipIsDisplayed();
  }

  public void checkTypedProjectIsRemoved(String typedProject) {
    tasksPage.checkTypedProjectIsRemoved(typedProject);
  }

  public void checkTypedTaskIsRemoved(String typedTask) {
    tasksPage.checkTypedTaskIsRemoved(typedTask);
  }

  public void checkUpdatedDescription(String Description) {
    tasksPage.checkUpdatedDescription(Description);
  }

  public void checkViewLinkAttachments() {
    tasksPage.checkViewLinkAttachments();
  }

  public void clearButtonInFilterByTaskIsNotVisible() {
    tasksPage.clearButtonInFilterByTaskIsNotVisible();
  }

  public void clearButtonInFilterByTaskIsVisible() {
    tasksPage.clearButtonInFilterByTaskIsVisible();
  }

  public void clearButtonIsNotVisible() {
    tasksPage.clearButtonIsNotVisible();
  }

  public void clearButtonIsVisible() {
    tasksPage.clearButtonIsVisible();
  }

  public void clickAddNewComment() {
    tasksPage.addNewCommentInTask();
  }

  public void clickAddProjectButton() {
    tasksPage.clickAddProjectButton();
  }

  public void clickChangeLocation() {
    tasksPage.clickChangeLocation();
  }

  public void clickDocButton() {
    tasksPage.clickDocButton();
  }

  public void clickFilterButton() {
    tasksPage.clickFilterButton();
  }

  public void clickOnAddStatusAfterOptionOfTheFifthStatusColumn() {
    tasksPage.clickOnAddStatusAfterOptionOfTheFifthStatusColumn();
  }

  public void clickOnAddStatusBeforeOption() {
    tasksPage.clickOnAddStatusBeforeOption();
  }

  public void clickOnAssigneeRadioButton() {
    tasksPage.clickOnAssigneeRadioButton();
  }

  public void clickOnClearButton() {
    tasksPage.clickOnClearButton();
  }

  public void clickOnClearButtonInFilterByTask() {
    tasksPage.clickOnClearButtonInFilterByTask();
  }

  public void clickOnCommentReply(String comment) {
    tasksPage.clickOnCommentReply(comment);
  }

  public void clickOnConfirmButton() {
    tasksPage.clickOnConfirmButton();
  }

  public void clickOnDeleteStatusIcon() {
    tasksPage.clickOnDeleteStatusIcon();
  }

  public void clickOnDeleteTaskOption() {
    tasksPage.clickOnDeleteTaskOption();
  }

  public void clickOnEditProjectButton() {
    tasksPage.clickOnEditProjectButton();

  }

  public void clickOnFifthColumnThreeDotsIcon() {
    tasksPage.clickOnFifthColumnThreeDotsIcon();
  }

  public void clickOnLastColumnThreeDotsIcon() {
    tasksPage.clickOnLastColumnThreeDotsIcon();
  }

  public void clickOnMoveStatusAfterIcon() {
    tasksPage.clickOnMoveStatusAfterIcon();
  }

  public void clickOnMoveStatusBeforeIcon() {
    tasksPage.clickOnMoveStatusBeforeIcon();
  }

  public void ClickOnPlusButtonToAddTask() {
    tasksPage.ClickOnPlusButtonToAddTask();
  }

  public void ClickOnPlusButtonToAddTaskOfTheSixthStatusColumn() {
    tasksPage.ClickOnPlusButtonToAddTaskOfTheSixthStatusColumn();
  }

  public void clickOnProjectThreeDotsButton() {
    tasksPage.clickOnProjectThreeDotsButton();
  }

  public void ClickOnSaveButtonToAddTask() {
    tasksPage.ClickOnSaveButtonToAddTask();
  }

  public void clickOnSaveButtonToAddTaskSpaceProject() {
    tasksPage.clickOnSaveButtonToAddTaskSpaceProject();
  }

  public void clickOnTaskThreeDotsOption() {
    tasksPage.clickOnTaskThreeDotsOption();
  }

  public void clickOnTheNotificationThatMentioneFirstUserInATaskInProject(String message, String ProjectName) {
    tasksPage.clickOnTheNotificationThatMentioneFirstUserInATaskInProject(message, ProjectName);
  }

  public void clickOnTheTimestamp() {
    tasksPage.clickOnTheTimestamp();
  }

  public void clickOnThreeDotsIcon() {
    tasksPage.clickOnThreeDotsIcon();
  }

  public void clickOnUpDateButton() {
    tasksPage.clickOnUpDateButton();
  }

  public void clickOnValidateStatusName() {
    tasksPage.clickOnValidateStatusName();
  }

  public void clickPlusIcon() {
    tasksPage.clickPlusIcon();
  }

  public void clickPlusIconProject() {
    tasksPage.clickPlusIconProject();
  }

  public void clickSaveProjectButton() {
    tasksPage.clickSaveProjectButton();
  }

  public void clickStatusName(String statusColumn) {
    tasksPage.clickStatusName(statusColumn);
  }

  public void clickViewAttachmentLink() {
    tasksPage.clickViewAttachmentLink();
  }

  public void cloneProject(String projectName) {
    tasksPage.cloneProject(projectName);
  }

  public void cloneProjectButtonIsDisplayed() {
    tasksPage.cloneProjectButtonIsDisplayed();
  }

  public void clonetaskinspaceproject() {
    tasksPage.clonetaskinspaceproject();
  }

  public void closeEditTaskDrawer() {
    tasksPage.closeEditTaskDrawer();
  }

  public void closeEditTaskDrawerSimpleProject() {
    tasksPage.closeEditTaskDrawerSimpleProject();
  }

  public void closeProjectDrawer() {
    tasksPage.closeProjectDrawer();
  }

  public void closeSortAndFilterDrawer() {
    tasksPage.closeSortAndFilterDrawer();
  }

  public void closetaskCommentsDrawer() {
    tasksPage.closeTaskCommentsDrawer();
  }

  public void closeTaskDrawer() {
    tasksPage.closeDrawer();
  }

  public void colorPaletteIsDisplayed() {
    tasksPage.colorPaletteIsDisplayed();
  }

  public void commentButtonIsDisabled() {
    tasksPage.commentButtonIsDisabled();
  }

  public void commentsDrawerIsDisplayed() {
    tasksPage.commentsDrawerIsDisplayed();
  }

  public void commentTaskWithUser(String user, String comment) {
    tasksPage.commentTaskWithUser(user, comment);
  }

  public void completeTask() {
    tasksPage.completeTask();
  }

  public void confirmDeleteStatusColumn() {
    tasksPage.confirmDeleteStatusColumn();
  }

  public void confirmDeleteTask() {
    tasksPage.confirmDeleteTaskFromTasksBord();
  }

  public void confirmFilter() {
    tasksPage.confirmFilter();
  }

  public void confirmFilterButtonIsDisplayed() {
    tasksPage.confirmFilterButtonIsDisplayed();
  }

  public void deleteCookies() {
    tasksPage.deleteCookies();
  }

  public void deleteProject(String projectName) {
    tasksPage.deleteProject(projectName);
  }

  public void deleteProjectButtonIsDisplayed() {
    tasksPage.deleteProjectButtonIsDisplayed();
  }

  public void deleteTaskOptionIsDisplayed() {
    tasksPage.deleteTaskOptionIsDisplayed();
  }

  public void editDescriptionForTask(String newDescription) {
    tasksPage.editDescriptionForTask(newDescription);
  }

  public void editProjectButtonIsDisplayed() {
    tasksPage.editProjectButtonIsDisplayed();
  }

  public void editProjectName(String projectName) {
    tasksPage.editProjectName(projectName);
  }

  public void editProjectNameWithDescription(String projectName, String newProjectName, String newDescription) {
    tasksPage.editProjectNameWithDescription(projectName, newProjectName, newDescription);
  }

  public void editSpaceName(String spaceName) {
    tasksPage.editSpaceName(spaceName);
  }

  public void editTaskDrawerIsDisplayed() {
    tasksPage.editTaskDrawerIsDisplayed();
  }

  public void enterDescriptionForTask(String description) {
    tasksPage.enterDescriptionForTask(description);
  }

  public void enterProjectDescriptionWithoutTheTitle(String description) {
    tasksPage.enterProjectDescriptionWithoutTheTitle(description);
  }

  public void enterProjectTitleAndDescription(String projectName, String description) {
    tasksPage.enterProjectTitleAndDescription(projectName, description);
  }

  public void enterStatusText(String status) {
    tasksPage.enterStatusText(status);
  }

  public void enterTaskComment(String comment) {
    tasksPage.enterTaskComment(comment);
  }

  public void enterTitleForTask(String title) {
    tasksPage.enterTitleForTask(title);
  }

  public void exitFromTheFirstProject() {
    tasksPage.exitFromTheFirstProject();
  }

  public void goBack() {
    tasksPage.goBack();
  }

  public void goToFilterTab() {
    tasksPage.goToFilterTab();
  }

  public void goToGroupAndSortTab() {
    tasksPage.goToGroupAndSortTab();
  }

  public void goToLabelsTab() {
    tasksPage.goToLabelsTab();
  }

  public void goToPLanView() {
    tasksPage.goToPLanView();
  }

  public void goToProjectDetailsList() {
    tasksPage.goToProjectDetailsList();
  }

  public void goToProjectsTab() {
    tasksPage.goToProjectsTab();
  }

  public void goToTasksTab() {
    tasksPage.goToTasksTab();
  }

  public void greenInformationIconIsDisplayed() {
    tasksPage.greenInformationIconIsDisplayed();
  }

  public void hoverOnProjectManagerIcon() {
    tasksPage.hoverOnProjectManagerIcon();
  }

  public void hoverOnTaskName(String task) {
    tasksPage.hoverOnTaskName(task);
  }

  public void hoverOnTheChangesTimestamp() {
    tasksPage.hoverOnTheChangesTimestamp();
  }

  public void isFilterDrawerTabDisplayed(String tab) {
    tasksPage.isFilterDrawerTabDisplayed(tab);
  }

  public void isLabelDisplayedInProjectDetails(String label, String times) {
    tasksPage.isLabelDisplayedInProjectDetails(label, times);
  }

  public void isSearchedTaskDisplayed(String taskName) {
    tasksPage.isSearchedTaskDisplayed(taskName);
  }

  public boolean isStatusEditModeDisplayed(String statusColumn) {
    return tasksPage.isStatusEditModeDisplayed(statusColumn);
  }

  public void labelIsDisplayedInProjectDrawer(String label) {
    tasksPage.labelIsDisplayedInProjectDrawer(label);
  }

  public void labelIsDisplayedInTaskDrawer(String label) {
    tasksPage.labelIsDisplayedInTaskDrawer(label);
  }

  public void labelIsNotDisplayedInProjectDrawer(String label) {
    tasksPage.labelIsNotDisplayedInProjectDrawer(label);
  }

  public void markTaskAsCompletedFromTaskCard() {
    tasksPage.markTaskAsCompletedFromTaskCard();
  }

  public void markTaskAsCompletedInProjectDetails(String taskName) {
    tasksPage.markTaskAsCompletedInProjectDetails(taskName);
  }

  public void maxCharsCount1250InformationIsDisplayed() {
    tasksPage.maxCharsCount1250InformationIsDisplayed();
  }

  public void maxCharsNumberMessageIsDisplayed() {
    tasksPage.maxCharsNumberMessageIsDisplayed();
  }

  public void more1250CharsInformationIsDisplayed() {
    tasksPage.more1250CharsInformationIsDisplayed();
  }

  public void openFilterDrawer() {
    tasksPage.openFilterDrawer();
  }

  public void openProject(String project) {
    tasksPage.openProject(project);
  }

  public void openTaskCard(String task) {
    tasksPage.openTaskCard(task);
  }

  public void openTaskCreated(String taskName) {
    tasksPage.openTaskDrawer(taskName);
  }

  public void openTaskInTasksTab(String taskName) {
    tasksPage.openTaskInTasksTab(taskName);
  }

  public void projectDrawerNotClosing() {
    tasksPage.projectDrawerNotClosing();
  }

  public void projectIsDisplayedInTasksAppCenter(String projectName) {
    tasksPage.projectIsDisplayedInTasksAppCenter(projectName);
  }

  public void projectNameIsDisplayedInProjectDetails(String projectName) {
    tasksPage.projectNameIsDisplayedInProjectDetails(projectName);
  }

  public void redInformationIconIsDisplayed() {
    tasksPage.redInformationIconIsDisplayed();
  }

  public void removeLabelToProject(String label) {
    tasksPage.removeLabelToProject(label);
  }

  public void replyTaskCommentButtonIsDisabled() {
    tasksPage.replyTaskCommentButtonIsDisabled();
  }

  public void resetFilterButtonIsDisplayed() {
    tasksPage.resetFilterButtonIsDisplayed();
  }

  public void returnToProjectsTab() {
    tasksPage.returnToProjectsTab();
  }

  public void saveAddingProject() {
    tasksPage.saveAddingProject();
  }

  public void searchTask(String taskName) {
    tasksPage.searchTask(taskName);
  }

  public void selectFilterOption(String label) {
    tasksPage.selectFilterOption(label);
  }

  public void setInSearchProjectField(String project) {
    tasksPage.setInSearchProjectField(project);
  }

  public void setProjectTitle(String projectTitle) {
    tasksPage.setProjectTitle(projectTitle);
  }

  public void setTaskCompletedInDrawer() {
    tasksPage.setTaskCompletedInDrawer();
  }

  public void setTaskCompletedInDrawerWithoutClosingIt() {
    tasksPage.setTaskCompletedInDrawerWithoutClosingIt();
  }

  public void setTaskDescription(String Description) {
    tasksPage.setTaskDescription(Description);
  }

  public void setTaskDueDateNextWeek() {
    tasksPage.setTaskDueDateNextWeek();
  }

  public void setTaskDueDateToday() {
    tasksPage.setTaskDueDateToday();
  }

  public void setTaskDueDateTomorrow() {
    tasksPage.setTaskDueDateTomorrow();
  }

  public void setTaskPriority(String taskPriority) {
    tasksPage.setTaskPriority(taskPriority);
  }

  public void setTasksStatus(String taskStatus) {
    tasksPage.setTaskStatus(taskStatus);
  }

  public void setTaskStartDateToday() {
    tasksPage.setTaskStartDateToday();
  }

  public void setTaskStartDateTomorrow() {
    tasksPage.setTaskStartDateTomorrow();
  }

  public void switchToTASKSTab() {
    tasksPage.switchToTASKSTab();
  }

  public void taskAlertIsDisplayed(String message) {
    tasksPage.taskAlertIsDisplayed(message);
  }

  public void taskIsDisplayedInProjectDetails(String taskName) {
    tasksPage.taskNameIsDisplayedInProjectDetails(taskName);
  }

  public void taskIsMarkedAndDisplayedInCompletedSection(String taskName) {
    tasksPage.taskIsMarkedAndDisplayedInCompletedSection(taskName);
  }

  public void taskIsNotDisplayedInProjectDetails(String taskName) {
    tasksPage.taskNameIsNotDisplayedInProjectDetails(taskName);
  }

  public void taskIsNotMarkedAndDisplayedInUncompletedSection(String taskName) {
    tasksPage.taskIsNotMarkedAndDisplayedInUncompletedSection(taskName);
  }

  public void taskMarkedAsCompletedIsDisplayedInDrawer() {
    tasksPage.taskMarkedAsCompletedIsDisplayedInDrawer();
  }

  public void taskNameAndLabelIsDisplayedInProjectDetails(String label, String taskName) {
    tasksPage.taskNameAndLabelIsDisplayedInProjectDetails(label, taskName);
  }

  public void taskNameIsDisplayedInDesiredColumn(String status, String taskName) {
    tasksPage.taskNameIsDisplayedInDesiredColumn(status, taskName);
  }

  public void taskNamePLanView(String taskName) {
    tasksPage.taskNamePLanView(taskName);
  }

  public void taskOrderInProjectDetails(String task, String number) {
    tasksPage.taskOrderInProjectDetails(task, number);
  }

  public void tasksNumberToDo(String tasksNumber) {
    tasksPage.tasksNumberToDo(tasksNumber);
  }

  public void taskTooltipIsDisplayed(String task) {
    tasksPage.taskTooltipIsDisplayed(task);
  }

  public void updateTaskDescription(String Description) {
    tasksPage.updateTaskDescription(Description);
  }

  public void userAvatarIsDisplayedInProjectCard(String userName) {
    tasksPage.userAvatarIsDisplayedInProjectCard(userName);
  }

  public void userAvatarIsNotDisplayedInProjectCard(String userName) {
    tasksPage.userAvatarIsNotDisplayedInProjectCard(userName);
  }

  public void userFullNameIsDisplayedInProjectCard(String name) {
    tasksPage.userFullNameIsDisplayedInProjectCard(name);
  }

  public void userFullNameIsNotDisplayedInProjectCard(String name) {
    tasksPage.userFullNameIsNotDisplayedInProjectCard(name);
  }

  public void verifyViewLinkAttachments() {
    tasksPage.verifyViewLinkAttachments();
  }

  public void viewAllCommentsTaskButton() {
    tasksPage.viewAllCommentsTaskButton();
  }
}
