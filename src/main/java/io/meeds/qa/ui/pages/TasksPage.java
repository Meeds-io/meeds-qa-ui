/*
 * This file is part of the Meeds project (https://meeds.io/).
 * 
 * Copyright (C) 2020 - 2023 Meeds Association contact@meeds.io
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.refreshPage;
import static io.meeds.qa.ui.utils.Utils.retryGetOnCondition;
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

public class TasksPage extends GenericPage {

  public TasksPage(WebDriver driver) {
    super(driver);
  }

  public void addFourLabelToProject(String label1, String label2, String label3, String label4) {
    labelTaskElement().sendKeys(label1 + Keys.ENTER + label2 + Keys.ENTER + label3 + Keys.ENTER + label4 + Keys.ENTER);
  }

  public void addLabel(String label) {
    TextBoxElementFacade labelTaskElement = labelTaskElement();
    labelTaskElement.waitUntilVisible();
    labelTaskElement.setTextValue(label);
    labelTaskElement.sendKeys(Keys.ENTER);
  }

  public void addLabelToTask(String label) {
    retryOnCondition(() -> {
      labelTaskElement().click();
      getAddLabelToTask(label).click();
    });
  }

  public void addNewCommentInTask() {
    addNewCommentInTaskElement().click();
  }

  public void addNewCommentInTaskWithMentioningTheFirstUserInTask(String comment, String user) {
    mentionUserInCKEditor(ckEditorFrameTaskMentioningUserElement(), taskCommentContentTextBoxElement(), comment, user, true);
    commentTaskButtonElement().click();
    closeDrawerIfDisplayed();
  }

  public void addOtherCommentInTask() {
    addOtherCommentInTaskElement().click();
  }

  public void addProject(String projectName) {
    addProjectOrTaskElement().click();
    projectTitleElement().setTextValue(projectName);
    saveButtonElement().click();
    waitForDrawerToClose();
  }

  public void addProjectManagerInput(String manager) {
    addManagerBtnElement().click();
    mentionInField(inviteProjectManagerInputElement(), manager, 5);
  }

  public void addProjectParticipantInput(String participant) {
    addParticipantBtnElement().click();
    mentionInField(inviteProjectParticipantInputElement(), participant, 5);
  }

  public void addProjectWithDescription(String projectName, String description) {
    addProjectOrTaskElement().click();
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

    saveButtonElement().click();
    waitForDrawerToClose();
  }

  public void addProjectWithFirstCreatedUserAsManger(String projectName, String fullName) {
    addProjectOrTaskElement().click();
    projectTitleElement().setTextValue(projectName);
    addProjectManagerInput(fullName);
    saveButtonElement().click();
    waitForDrawerToClose();
  }

  public void addProjectWithFirstUserAsParticipant(String projectName, String participant) {
    addProjectOrTaskElement().click();
    projectTitleElement().setTextValue(projectName);
    addProjectParticipantInput(participant);
    saveButtonElement().click();
    waitForDrawerToClose();
  }

  public void addProjectWithManager(String projectName, String fullName) {
    addProjectOrTaskElement().click();
    projectTitleElement().setTextValue(projectName);
    addManagerBtnElement().click();
    mentionInField(inviteProjectManagerInputElement(), fullName, 5);
    saveButtonElement().click();
    waitForDrawerToClose();
  }

  public void addProjectWithManagerAndParticipant(String projectName, String manager, String participant) {
    addProjectOrTaskElement().click();
    projectTitleElement().setTextValue(projectName);
    addProjectManagerInput(manager);
    addProjectParticipantInput(participant);
    saveButtonElement().click();
    waitForDrawerToClose();
  }

  public void addProjectWithParticipant(String projectName, String lastName) {
    addProjectOrTaskElement().click();
    projectTitleElement().setTextValue(projectName);
    addProjectParticipantInput(lastName);
    saveButtonElement().click();
    waitForDrawerToClose();
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
    taskAssignLinkElement().assertVisible();
    taskAssignLinkElement().click();
    taskAssignMeElement().click();
  }

  public void assignTaskToUser(String user) {
    taskAssignLinkElement().assertVisible();
    taskAssignLinkElement().click();
    mentionInField(taskAssignUserInputElement(), user, 5);
  }

  public void boardViewIsDisplayedByDefault() {
    projectActiveBoardViewElement().assertVisible();
  }

  public void cancelFilterButtonIsDisplayed() {
    cancelFilterButtonElement().assertVisible();
  }

  public void checkAlertMessageAfterDeleteTask() {
    findByXPathOrCSS("//*[contains(@class, 'v-alert')]//*[contains(text(),'Task successfully deleted')]").assertVisible();
  }

  public void checkAlertMessageAfterMarkTaskAsCompleted() {
    alertMessageAfterMarkTaskAsCompletedElement().assertVisible();
  }

  public void checkAlertMessageMoveStatusAfter() {
    alertMessageAfterStatusMovedElement().assertVisible();
  }

  public void checkAttachmentDisplay(String attachmentName) {
    getAttachmentName(attachmentName).assertNotVisible();
  }

  public void checkClonedProject(String projectName) {
    getProjectCard(projectName).assertVisible();
    alertMessageAfterProjectCloneElement().assertVisible();
  }

  public void checkClonedTask(String taskName) {
    getTaskTitle(taskName).assertVisible();
  }

  public void checkDeletedProject(String projectName) {
    getProjectCard(projectName).assertNotVisible();
    alertMessageAfterProjectDeletionElement().assertVisible();
  }

  public void checkDeletedStatus(String statusColumn) {
    getStatusColumn(statusColumn).assertNotVisible();
  }

  public void checkDeletedTaskIsNotDisplayed(String taskName) {
    getTaskName(taskName).assertNotVisible();
  }

  public void checkDescriptionDisplay(String description) {
    getDescriptionForTask(description).assertVisible();
  }

  public void checkDisplayOfFilterByProject() {
    filterByProjectElement().assertVisible();
  }

  public void checkDisplayOfFilterByTask() {
    filterByTaskElement().assertVisible();
  }

  public void checkDrawerDisplay() {
    drawerTitleElement().assertVisible();
  }

  public void checkFirstStatusColumn(String columnStatus) {
    assertEquals(firstStatusColumnElement().getText(), columnStatus);
  }

  public void checkGroupingSelected(String groupingValue) {
    assertTrue(findByXPathOrCSS(String.format("//*[contains(@class, 'v-navigation-drawer--open')]//input[@aria-checked='true' and @value='%s']//ancestor::*[contains(@class, 'v-radio')]",
                                              groupingValue)).isVisible());
  }

  public void checkLastStatusColumn(String columnStatus) {
    Assert.assertEquals(lastStatusColumnElement().getText(), columnStatus);
  }

  public void checkMessageEmptyProjectDisplay() {
    assertEquals(projectTitleElement().getText(), "");
  }

  public void checkMoveStatusAfterIconIsNotDisplayed() {
    moveStatusAfterIconElement().assertNotVisible();
  }

  public void checkMoveStatusBeforeIconIsNotDisplayed() {
    moveStatusBeforeIconElement().assertNotVisible();
  }

  public void checkProject(String projectName) {
    getProjectCard(projectName).assertVisible();
    alertMessageAfterProjectCreationElement().assertVisible();
  }

  public void checkProjectIsCreated() {
    alertMessageAfterProjectCreationElement().assertVisible();
  }

  public void checkProjectNameIsDisplayedInProjectCard(String projectName, String description) {
    getProjectCard(projectName).assertVisible();
    getProjectCardDescription(description).assertVisible();
  }

  public void checkProjectNotDisplayed(String projectName) {
    getProjectCard(projectName).assertNotVisible();
    alertMessageAfterProjectCreationElement().assertNotVisible();
  }

  public void checkSecondStatusColumn(String columnStatus) {
    assertEquals(secondStatusColumnElement().getText(), columnStatus);
  }

  public void checkSuccessMessage(String message) {
    assertTrue(successMessageElement().getText().contains(message));
  }

  public void checkTaskPriority(String taskPriority) {
    getTaskPriority(taskPriority).assertVisible();
  }

  public void checkTaskStatus(String taskStatus) {
    getTaskStatus(taskStatus).assertVisible();
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
    textAssigneeElement().assertVisible();
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
    clickOnTaskDescription();

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
    getProjectCard(projectName).assertVisible();
    getProjectCardDescription(description).assertVisible();
    alertMessageAfterProjectUpdateElement().assertVisible();
  }

  public void checkViewLinkAttachments() {
    viewAttachmentsLinkElement().assertVisible();
  }

  public void clearButtonInFilterByTaskIsNotVisible() {
    clearButtonInFilterByTaskElement().assertNotVisible();
  }

  public void clearButtonInFilterByTaskIsVisible() {
    clearButtonInFilterByTaskElement().assertVisible();
  }

  public void clearButtonIsNotVisible() {
    clearButtonInFilterByProjectElement().assertNotVisible();
  }

  public void clearButtonIsVisible() {
    clearButtonInFilterByProjectElement().assertVisible();
  }

  public void clickAddProjectButton() {
    addProjectOrTaskElement().click();
  }

  public void clickAddTaskButton() {
    ElementFacade addTaskButton = findByXPathOrCSS(".tasksToolbar button.btn-primary");
    if (addTaskButton.isCurrentlyVisible() && addTaskButton.isVisible() && addTaskButton.isClickable()) {
      addTaskButton.click();
    } else {
      addTaskInProjectButtonElement().click();
    }
  }

  public void clickCancel() {
    clickToCancelDialog();
  }

  public void clickChangeLocation() {
    changeLocationLinkElement().click();
  }

  public void clickDelete() {
    deleteButtonElement().click();
  }

  public void clickDeleteProjectButton() {
    deleteProjectButtonElement().click();
  }

  public void clickDocButton() {
    documentButtonElement().click();
  }

  public void clickFilterButton() {
    filterButtonElement().click();
    waitForDrawerToOpen();
  }

  public void clickOnAddAttachmentLink() {
    addAttachmentLinkElement().click();
  }

  public void clickOnAddStatusAfterOptionOfTheFifthStatusColumn() {
    addStatusafteroptionElement().click();
  }

  public void clickOnAddStatusBeforeOption() {
    addStatusBeforeoptionElement().click();
  }

  public void clickOnAssigneeRadioButton() {
    assigneeRadioButtonElement().click();
  }

  public void clickOnClearButton() {
    clearButtonInFilterByProjectElement().click();
  }

  public void clickOnClearButtonInFilterByTask() {
    clearButtonInFilterByTaskElement().click();
  }

  public void clickOnCommentReply(String comment) {
    ElementFacade taskCommentReplyBtn = getTaskCommentReplyBtn(comment);
    taskCommentReplyBtn.assertVisible();
    taskCommentReplyBtn.click();
  }

  public void clickOnConfirmButton() {
    confirmButtonDrawerElement().click();
  }

  public void clickOnDeleteStatusIcon() {
    deleteStatusIconElement().click();
  }

  public void clickOnDeleteTaskOption() {
    deleteTaskOptionElement().click();
  }

  public void clickOnEditProjectButton() {
    editProjectButtonElement().click();
    waitForDrawerToOpen();
  }

  public void clickOnFifthColumnThreeDotsIcon() {
    fifthColumnThreeDotsIconElement().click();
  }

  public void clickOnLastColumnThreeDotsIcon() {
    lastColumnThreeDotsIconElement().click();
  }

  public void clickOnMoveStatusAfterIcon() {
    moveStatusAfterIconElement().click();
  }

  public void clickOnMoveStatusBeforeIcon() {
    moveStatusBeforeIconElement().click();
  }

  public void clickOnPlusButtonToAddTask() {
    plusButtonToAddTaskElement().click();
  }

  public void clickOnPlusButtonToAddTaskOfTheSixthStatusColumn() {
    plusButtonToAddTaskOfTheSixthStatusColumnElement().click();
  }

  public void clickOnProjectThreeDotsButton() {
    projectThreeDotsButtonElement().click();
    editProjectButtonElement().waitUntilVisible();
  }

  public void clickOnSaveButtonToAddTask() {
    saveButtonTaskElement().click();
  }

  public void clickOnSaveButtonToAddTaskSpaceProject() {
    saveButtonTaskSpaceProjectElement().click();
  }

  public void clickOnTaskThreeDotsOption() {

    taskThreeDotsOptionElement().click();
  }

  public void clickOnTheNotificationThatMentioneThirdUserInATaskInProject(String message, String projectName) {
    ElementFacade firstNotificationContentElement = firstNotificationContentElement();
    firstNotificationContentElement.waitUntilVisible();
    Assert.assertTrue(firstNotificationContentElement.getText().contains(message));
    Assert.assertTrue(firstNotificationContentElement.getText().contains(projectName));
    firstNotificationContentElement.click();
  }

  public void clickOnTheTimestamp() {
    timesTampElement().click();
  }

  public void clickOnThreeDotsIcon() {
    threeDotsIconElement().click();
  }

  public void clickOnUpDateButton() {
    updateButtonDescriptionElement().click();
  }

  public void clickOnValidateStatusName() {
    String currentStatusName = statusFieldElement().getValue();
    validateStatusNameElement().click();
    // Wait until column is added
    retryGetOnCondition(() -> getStatusColumn(currentStatusName).waitUntilVisible(),
                     () -> waitFor(2).seconds());
  }

  public void clickPlusIcon() {
    plusIconElement().click();
  }

  public void clickPlusIconProject() {
    plusIconProjectElement().click();
  }

  public void clickQuickAddTaskButton() {
    quickAddTaskInProjectButtonElement().click();
  }

  public void clickSaveProjectButton() {
    saveButtonElement().click();
    waitForDrawerToClose();
  }

  public void clickStatusName(String statusColumn) {
    getStatusColumn(statusColumn).click();
  }

  public void clickViewAttachmentLink() {
    viewAttachmentsLinkElement().assertVisible();
    viewAttachmentsLinkElement().click();
  }

  public void cloneProject(String projectName) {
    getProjectCard(projectName).assertVisible();
    projectThreeDotsButtonElement().click();
    cloneProjectButtonElement().click();
    clickToConfirmDialog();
  }

  public void cloneProjectButtonIsDisplayed() {
    cloneProjectButtonElement().assertVisible();
  }

  public void clonetaskinspaceproject() {
    threeDotsIconInEditTaskElement().click();
    cloneoptionElement().click();
  }

  public void colorPaletteIsDisplayed() {
    colorPaletteElement().assertVisible();
  }

  public void commentButtonIsDisabled() {
    commentTaskButtonElement().waitUntilDisabled();
  }

  public void commentsDrawerIsDisplayed() {
    commentsDrawerSectionElement().assertVisible();
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
    commentTaskButtonElement.click();
    closeDrawerIfDisplayed();
  }

  public void commentTaskWithUser(String user, String comment) {
    getTaskCommentWithUser(user, comment);
  }

  public void completeTask() {
    markTaskCompletedElement().click();
  }

  public void confirmDeleteStatusColumn() {
    clickToConfirmDialog();
  }

  public void confirmDeleteTaskFromTasksBord() {
    clickToConfirmDialog();
  }

  public void confirmFilter() {
    confirmFilterButtonElement().click();
  }

  public void confirmFilterButtonIsDisplayed() {
    confirmFilterButtonElement().assertVisible();
  }

  public void deleteProject(String projectName) {
    getProjectCard(projectName).assertVisible();
    projectThreeDotsButtonElement().click();
    deleteProjectButtonElement().click();
    clickToConfirmDialog();
  }

  public void deleteProjectButtonIsDisplayed() {
    deleteProjectButtonElement().assertVisible();
  }

  public void deleteTaskOptionIsDisplayed() {
    deleteTaskOptionElement().assertVisible();
  }

  public void editDescriptionForTask(String newDescription) {
    clickOnTaskDescription();

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

    updateButtonDescriptionElement().click();
    waitForLoading();
  }

  public void editProjectButtonIsDisplayed() {
    editProjectButtonElement().assertVisible();
  }

  public void editProjectName(String projectName) {
    projectThreeDotsButtonElement().click();
    editProjectButtonElement().click();
    projectTitleElement().setTextValue(projectName);
    saveButtonElement().click();
  }

  public void editProjectNameWithDescription(String projectName, String newProjectName, String newDescription) {
    getProjectCard(projectName).assertVisible();
    projectThreeDotsButtonElement().click();
    editProjectButtonElement().click();
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

    saveButtonElement().click();
  }

  public void editSpaceName(String spaceName) {
    spaceNameTitleElement().setTextValue(spaceName);
    updateNameSpaceButtonElement().click();
  }

  public void editTaskDrawerIsDisplayed() {
    editTaskDrawerSectionElement().assertVisible();
  }

  public void enterDescriptionForTask(String description) {
    clickOnTaskDescription();

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
    addProjectOrTaskElement().click();

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
    addProjectOrTaskElement().click();
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
    backButtonProjectElement().click();
  }

  public void goBack() {
    goBackIconElement().click();
  }

  public void goToFilterTab() {
    filterTabElement().click();
  }

  public void goToGroupAndSortTab() {
    groupAndSortTabElement().click();
  }

  public void goToLabelsTab() {
    labelsTabElement().click();
  }

  public void goToPLanView() {
    planViewElement().click();
  }

  public void goToProjectDetailsList() {
    projectDetailsListButtonElement().click();
  }

  public void goToProjectsTab() {
    goToTab(1);
  }

  public void goToTasksTab() {
    goToTab(2);
  }

  public void greenInformationIconIsDisplayed() {
    ElementFacade informationIconElement = informationIconElement();
    informationIconElement.assertVisible();
    Assert.assertEquals(informationIconElement.getCssValue("color"), "rgba(46, 181, 140, 1)");
  }

  public void hoverOnProjectManagerIcon() {
    projectCardUserPopover().hover();
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
    getDisplayedLabel(label, times).assertVisible();
  }

  public void isSearchedTaskDisplayed(String taskName) {
    Assert.assertEquals(taskNameElement().getValue(), taskName);
  }

  public boolean isStatusEditModeDisplayed(String statusColumn) {
    return getStatusColumn(statusColumn).isNotVisible();
  }

  public void labelIsDisplayedInProjectDrawer(String label) {
    getLabelInEditProjectDrawer(label).assertVisible();
  }

  public void labelIsDisplayedInTaskDrawer(String label) {
    getLabelInEditTaskDrawer(label).assertVisible();
    getRemoveLabelTaskButton(label).assertNotVisible();
  }

  public void labelIsNotDisplayedInProjectDrawer(String label) {
    getLabelInEditProjectDrawer(label).assertNotVisible();
  }

  public void markTaskAsCompletedFromTaskCard() {
    markTaskCompletedOnTaskCardElement().click();
  }

  public void markTaskAsCompletedInProjectDetails(String taskName) {
    getTaskToMarkAsCompleted(taskName).click();
  }

  public void maxCharsCount1250InformationIsDisplayed() {
    maxCharsCountInfoElement().assertVisible();
  }

  public void maxCharsNumberMessageIsDisplayed() {
    commentsDrawerSectionElement().click();

    waitCKEditorLoading();
    ElementFacade ckEditorFrameTaskElement = ckEditorFrameTaskElement();
    ckEditorFrameTaskElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameTaskElement);
    try {
      commentTaskMaxCharsMsgElement().assertVisible();
    } finally {
      getDriver().switchTo().defaultContent();
    }

  }

  public void more1250CharsInformationIsDisplayed() {
    more1250CharsCountInfoElement().assertVisible();
    Assert.assertEquals(more1250CharsCountInfoElement().getCssValue("color"), "rgba(188, 67, 67, 1)");
  }

  public void openFilterDrawer() {
    refreshPage();
    filterDrawerButtonElement().click();
  }

  public void openProject(String project) {
    getProjectCard(project).click();
    filterButtonElement().assertVisible();
  }

  public void openTaskCard(String task) {
    closeDrawerIfDisplayed();
    openTask(task).click();
    waitForDrawerToOpen();
  }

  public void openTaskDrawer(String taskName) {
    closeDrawerIfDisplayed();
    getTaskName(taskName).click();
    waitForDrawerToOpen();
  }

  public void openTaskInTasksTab(String taskName) {
    getTaskTitleInTasksTab(taskName).click();
  }

  public void projectDrawerNotClosing() {
    assertTrue(findByXPathOrCSS(".v-navigation-drawer--open").isVisible());
  }

  public void projectIsDisplayedInTasksAppCenter(String projectName) {
    getProjectCard(projectName).assertVisible();
  }

  public void projectNameIsDisplayedInProjectDetails(String projectName) {
    projectNameInProjectDetails(projectName).assertVisible();
  }

  public void redInformationIconIsDisplayed() {
    informationIconElement().assertVisible();
    Assert.assertEquals(informationIconElement().getCssValue("color"), "rgba(188, 67, 67, 1)");
  }

  public void removeLabelToProject(String label) {
    // Labels are retrieved from Server, thus we should wait until it's loaded,
    // in addition, no loading effect is visible in project drawer
    retryGetOnCondition(() -> findByXPathOrCSS(".projectLabelsName .v-chip").waitUntilVisible());
    getRemoveLabelButton(label).click();
  }

  public void replyTaskCommentButtonIsDisabled() {
    replyTaskCommentButtonElement().waitUntilDisabled();
  }

  public void resetFilterButtonIsDisplayed() {
    resetFilterButtonElement().assertVisible();
  }

  public void returnToProjectsTab() {
    arrowBackButtonElement().click();
  }

  public void saveAddingProject() {
    saveButtonElement().click();
  }

  public void saveAddTaskButton() {
    saveButtonElement().click();
  }

  public void saveQuickTask() {
    taskQuickNameFieldElement().sendKeys(Keys.ENTER);
  }

  public void searchTask(String taskName) {
    searchTaskNameElement().sendKeys(taskName);
  }

  public void selectFilterOption(String label) {
    getFilterOption(label).click();
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
    markTaskCompletedInDrawerElement().click();
    closeDrawerIfDisplayed();
  }

  public void setTaskCompletedInDrawerWithoutClosingIt() {
    markTaskCompletedInDrawerElement().click();
  }

  public void setTaskDescription(String description) {
    clickOnTaskDescription();

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
    taskDueDateElement().click();
    taskDueDateNextWeekElement().click();
  }

  public void setTaskDueDateToday() {
    taskDueDateElement().click();
    taskDueDateTodayElement().click();
  }

  public void setTaskDueDateTomorrow() {
    taskDueDateElement().click();
    taskDueDateTomorrowElement().click();
  }

  public void setTaskName(String taskName) {
    taskNameFieldElement().setTextValue(taskName);
  }

  public void setTaskPriority(String taskPriority) {
    taskPrioritySelectorElement().assertVisible();
    taskPrioritySelectorElement().click();
    selectTaskPriority(taskPriority).click();
  }

  public void setTaskStartDateToday() {
    taskStartDateElement().click();
    taskStartDateTodayElement().click();
  }

  public void setTaskStartDateTomorrow() {
    taskStartDateElement().click();
    taskStartDateTomorrowElement().click();
  }

  public void setTaskStatus(String taskStatus) {
    selectStatusSelectorElement().click();
    selectTaskStatus(taskStatus).click();
  }

  public void switchToTASKSTab() {
    backDrawerElement().click();
  }

  public void taskAlertIsDisplayed(String message) {
    getTaskAlert(message).assertVisible();
  }

  public void taskIsMarkedAndDisplayedInCompletedSection(String taskName) {
    Assert.assertEquals(getCompletedTask(taskName).getText(), taskName);
  }

  public void taskIsNotMarkedAndDisplayedInUncompletedSection(String taskName) {
    Assert.assertEquals(getUncompletedTask(taskName).getText(), taskName);
  }

  public void taskMarkedAsCompletedIsDisplayedInDrawer() {
    taskMarkedAsCompletedInDrawerElement().assertVisible();
  }

  public void taskNameAndLabelIsDisplayedInProjectDetails(String label, String taskName) {
    Assert.assertTrue(taskNameAndLabelAndNumberInProjectDetails(taskName).getText().contains(label));
  }

  public void taskNameIsDisplayedInDesiredColumn(String status, String taskName) {
    Assert.assertTrue(getTaskStatusColumn(status).getText().contains(taskName));
  }

  public void taskNameIsDisplayedInProjectDetails(String taskName) {
    ElementFacade taskElement = taskNameInProjectDetails(taskName);
    taskElement.assertVisible();
    Assert.assertEquals(taskElement.getText(), taskName);
  }

  public void taskNameIsNotDisplayedInProjectDetails(String taskName) {
    ElementFacade taskElement = taskNameInProjectDetails(taskName);
    taskElement.assertNotVisible();
  }

  public void taskNamePLanView(String taskName) {
    getTaskNamePlanView(taskName).shouldBeVisible();
  }

  public void taskOrderInProjectDetails(String task, String number) {
    Assert.assertTrue(getTaskOrder(number).getTextContent().contains(task));
  }

  public void tasksNumberToDo(String tasksNumber) {
    getTasksNumberToDo(tasksNumber).assertVisible();
  }

  public void taskTooltipIsDisplayed(String task) {
    Assert.assertEquals(taskTooltipElement().getText(), task);
  }

  public void updateTaskDescription(String description) {
    clickOnTaskDescription();

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
    getProjectCardUserAvatar(userName).assertVisible();
  }

  public void userAvatarIsNotDisplayedInProjectCard(String userName) {
    getProjectCardUserAvatar(userName).assertNotVisible();
  }

  public void userFullNameIsDisplayedInProjectCard(String name) {
    Assert.assertEquals(projectCardUserFullNameElement().getText(), name);
  }

  public void userFullNameIsNotDisplayedInProjectCard(String name) {
    Assert.assertNotEquals(projectCardUserFullNameElement().getText(), name);
  }

  public void verifyViewLinkAttachments() {
    viewAttachmentsLinkElement().assertNotVisible();
  }

  public void viewAllCommentsTaskButton() {
    ElementFacade viewAllCommentsTaskButtonElement = viewAllCommentsTaskButtonElement();
    viewAllCommentsTaskButtonElement.waitUntilVisible();
    viewAllCommentsTaskButtonElement.click();
  }

  private void clickOnTaskDescription() {
    taskDescriptionFieldElement().click();
    waitFor(200).milliseconds();
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
    return findByXPathOrCSS("//*[@id = 'projectBoardToolbar']//*[contains(@class, 'tasksToolbar')]//button[contains(@class, 'btn-primary')]");
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
    return findByXPathOrCSS("//*[contains(@class,'menuable__content__active ')]//*[contains(@class,'uiIconEdit ')]");
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

  private ElementFacade projectCardUserPopover() {
    return findByXPathOrCSS("//*[contains(@class, 'spaceAdminContainer')]//*[contains(@class, 'profile-popover')]");
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
    return findByXPathOrCSS("//*[contains(@class, 'taskStatusNameEdit')]//*[contains(@class,'Tick')]");
  }

  private ElementFacade viewAllCommentsTaskButtonElement() {
    return findByXPathOrCSS("//*[@class='ViewAllCommentLabel']");
  }

  private ElementFacade viewAttachmentsLinkElement() {
    return findByXPathOrCSS("//div[@class='attachmentsList']//a[@class='viewAllAttachments primary--text font-weight-bold text-decoration-underline']");
  }
}
