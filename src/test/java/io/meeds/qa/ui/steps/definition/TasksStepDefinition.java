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
package io.meeds.qa.ui.steps.definition;

import static io.meeds.qa.ui.utils.Utils.getRandomNumber;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.LoginSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;
import io.meeds.qa.ui.steps.TasksSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class TasksStepDefinition {

  @Steps
  private HomeSteps        homeSteps;

  @Steps
  private LoginSteps       loginSteps;

  @Steps
  private ManageSpaceSteps manageSpaceSteps;

  @Steps
  private TasksSteps       tasksSteps;

  @When("^I accept the invitation of the created space project$")
  public void acceptRandomSpaceProject() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    homeSteps.acceptRandomSpaceInvitation(randomSpaceName);
  }

  @When("^I enter four label '(.*)' '(.*)' '(.*)' '(.*)' in the project$")
  public void addFourLabelToProject(String label1, String label2, String label3, String label4) {
    tasksSteps.addFourLabelToProject(label1, label2, label3, label4);
  }

  @When("^I enter label '(.*)' in the project$")
  public void addLabelToProject(String label) {
    tasksSteps.addLabelToProject(label);
  }

  @When("^I add Label '(.*)' to task$")
  public void addLabelToTask(String label) {
    tasksSteps.addLabelToTask(label);
  }

  @When("^I add this comment '(.*)' in task$")
  public void addNewCommentInTask(String comment) {
    tasksSteps.addNewCommentInTask(comment);
  }

  @When("^I enter a comment '(.*)' with mentioning the '(.*)' user in task$")
  public void addNewCommentInTaskWithMentioningTheFirstUserInTask(String comment, String userSuffix) {
    String user = Serenity.sessionVariableCalled(userSuffix + "UserName");
    tasksSteps.addNewCommentInTaskWithMentioningTheFirstUserInTask(comment, user);
  }

  @Given("^I create space project with the first user$")
  public void addNewRandomProjectWithFirstUser() {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    Serenity.setSessionVariable("randomSpaceName").to(randomSpaceName);
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    manageSpaceSteps.addSpaceWithInviteUser(randomSpaceName, firstUserName);
  }

  @Given("^I create space project with user '(.*)'$")
  public void addNewRandomProjectWithUser(String user) {
    homeSteps.goToManageSpacesPage();
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    Serenity.setSessionVariable("randomSpaceName").to(randomSpaceName);
    manageSpaceSteps.addSpaceWithInviteUser(randomSpaceName, user);
  }

  @When("^I add other comment '(.*)' in task$")
  public void addOtherCommentInTask(String comment) {
    tasksSteps.addOtherCommentInTask(comment);
  }

  @And("^I add a new project$")
  public void addProject() {
    String projectName = "projectName" + getRandomNumber();
    Serenity.setSessionVariable("projectName").to(projectName);
    tasksSteps.addProject(projectName);
  }

  @When("^I create the project '(.*)'$")
  public void addProject(String projectName) {
    tasksSteps.addProject(projectName);
  }

  @Then("^I add the project '(.*)' with the manager '(.*)' and the participant '(.*)'$")
  public void addProjectWithAManagerAndParticipant(String projectName, String manager, String participant) {
    tasksSteps.addProjectWithManagerAndParticipant(projectName, manager, participant);
  }

  @And("^I add a new project with a description$")
  public void addProjectWithDescription() {
    String projectName = "projectName" + getRandomNumber();
    Serenity.setSessionVariable("projectName").to(projectName);
    String description = "description" + getRandomNumber();
    Serenity.setSessionVariable("description").to(description);
    tasksSteps.addProjectWithDescription(projectName, description);
  }

  @Then("^I create the project '(.*)' with the '(.*)' created user as manager$")
  public void addProjectWithFirstCreatedUserAsMangerAndParticipant(String projectName, String userSuffix) {
    String firstName = Serenity.sessionVariableCalled(userSuffix + "UserFirstName");
    String lastName = Serenity.sessionVariableCalled(userSuffix + "UserLastName");
    String fullName = firstName + " " + lastName;
    tasksSteps.addProjectWithFirstCreatedUserAsManger(projectName, fullName);
  }

  @Then("^I add the random project with first user as the manager and second user as the participant$")
  public void addProjectWithFirstUserAsManagerAndSecondUserAsParticipant() {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");
    String firstUserFullName = firstUserFirstName + " " + firstUserLastName;
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");
    String secondUserFullName = secondUserFirstName + " " + secondUserLastName;
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    Serenity.setSessionVariable("randomSpaceName").to(randomSpaceName);
    tasksSteps.addProjectWithManagerAndParticipant(randomSpaceName, firstUserFullName, secondUserFullName);
  }

  @Then("^I add the random project with first user as the participant$")
  public void addProjectWithFirstUserAsParticipant() {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");
    String firstUserFullName = firstUserFirstName + " " + firstUserLastName;
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    Serenity.setSessionVariable("randomSpaceName").to(randomSpaceName);
    tasksSteps.addProjectWithFirstUserAsParticipant(randomSpaceName, firstUserFullName);
  }

  @Then("^I create the project '(.*)' with the manager '(.*)'$")
  public void addProjectWithManager(String projectName, String fullName) {
    tasksSteps.addProjectWithManager(projectName, fullName);

  }

  @Then("^I create the random project with the (.*) created user as participant$")
  public void addRandomProjectWithRandomParticipant(String userPrefix) {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    if (StringUtils.isBlank(randomSpaceName)) {
      randomSpaceName = "randomSpaceName" + getRandomNumber();
      Serenity.setSessionVariable("randomSpaceName").to(randomSpaceName);
    }
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");

    tasksSteps.addProjectWithParticipant(randomSpaceName, userLastName);
  }

  @Then("^I add (.*) user as the participant in the project$")
  public void addSecondUserToProject(String userPrefix) {
    String userLastName = Serenity.sessionVariableCalled(userPrefix + "UserLastName");
    tasksSteps.addSecondUserToProject(userLastName);
  }

  @When("^I enter six label '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' in the project$")
  public void addSixLabelToProject(String label1, String label2, String label3, String label4, String label5, String label6) {
    tasksSteps.addSixLabelToProject(label1, label2, label3, label4, label5, label6);
  }

  @Given("I create the following task in selected project")
  @And("I create the following task")
  public void addTaskInProject(Map<String, String> taskDetails) {
    tasksSteps.addTaskInProject(taskDetails);
  }

  @And("I create a random quick task in the random project")
  public void addTaskInSimpleProject(Map<String, String> userDetails) {
    tasksSteps.addSimpleTaskProject(userDetails);
  }

  @Given("^The following task with label '(.*)' is created in the specific project$")
  public void addTaskWithLabelInProject(String label, Map<String, String> userDetails) {
    tasksSteps.addTaskWithLabelInProject(label, userDetails);
  }

  @And("^I assign task to me$")
  public void assignTaskToMe() {
    tasksSteps.assignTaskToMe();
  }

  @And("^I assign task to the first user$")
  public void assignTaskToTheFirstUser() {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    tasksSteps.assignTaskToUser(firstUserFirstName);
  }

  @When("^Board view is displayed by default$")
  public void boardViewIsDisplayedByDefault() {
    tasksSteps.boardViewIsDisplayedByDefault();
  }

  @When("^Cancel button is displayed in the Filter drawer$")
  public void cancelFilterButtonIsDisplayed() {
    tasksSteps.cancelFilterButtonIsDisplayed();
  }

  @And("^An alert message Task successfully deleted is displayed$")
  public void checkAlertMessageAfterDeleteTask() {
    tasksSteps.checkAlertMessageAfterDeleteTask();
  }

  @Then("An alert message Task successfully marked as archived is displayed")
  public void checkAlertMessageAfterMarkTaskAsCompleted() {
    tasksSteps.checkAlertMessageAfterMarkTaskAsCompleted();
  }

  @Then("^An alert message Status column is moved successfully is displayed$")
  public void checkAlertMessageMoveStatusAfter() {
    tasksSteps.checkAlertMessageMoveStatusAfter();
  }

  @Then("^The random created project with description '(.*)' is displayed in Project Card$")
  public void checkCreatedTasksProjectNameIsDisplayedInProjectCard(String projectDescription) {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    tasksSteps.checkProjectNameIsDisplayedInProjectCard(randomSpaceName, projectDescription);
  }

  @Then("^the project is deleted successfully from Projects tab$")
  public void checkDeletedProject() {
    String projectName = Serenity.sessionVariableCalled("projectName");
    tasksSteps.checkDeletedProject(projectName);
  }

  @Then("^Status '(.*)' is deleted successfully$")
  public void checkDeletedStatus(String statusColumn) {
    tasksSteps.checkDeletedStatus(statusColumn);
  }

  @Then("^Task '(.*)' is deleted successfully$")
  public void checkDeletedTask(String taskName) {
    tasksSteps.checkDeletedTask(taskName);
  }

  @When("^The description in the task '(.*)' is displayed$")
  @And("^The edit description in the task '(.*)' is displayed$")
  public void checkDescriptionDisplay(String description) {
    tasksSteps.checkDescriptionDisplay(description);
  }

  @Then("^The placeholder Filter by project should be displayed$")
  public void checkDisplayOfFilterByProject() {
    tasksSteps.checkDisplayOfFilterByProject();
  }

  @Then("^The placeholder Filter by task should be displayed$")
  public void checkDisplayOfFilterByTask() {
    tasksSteps.checkDisplayOfFilterByTask();
  }

  @Then("^The drawer Select Folder should be displayed$")
  public void checkDrawerDisplay() {
    tasksSteps.checkDrawerDisplay();
  }

  @And("^Status column '(.*)' is moved to the first position$")
  @Then("^Status column '(.*)' is displayed in the first position$")
  public void checkFirstStatusColumn(String columnStatus) {
    tasksSteps.checkFirstStatusColumn(columnStatus);
  }

  @Then("^I check that grouping '(.*)' is selected$")
  public void checkGroupingSelected(String groupingValue) {
    tasksSteps.checkGroupingSelected(groupingValue);
  }

  @And("^Status column '(.*)' is moved to the last position$")
  @Then("^Status column '(.*)' is displayed in the last position$")
  public void checkLastStatusColumn(String columnStatus) {
    tasksSteps.checkLastStatusColumn(columnStatus);
  }

  @Then("^Message Project Title is mandatory is displayed$")
  public void checkMessageSaveEmptyProject() {
    tasksSteps.checkMessageSaveEmptyProject();
  }

  @Then("^project is cloned successfully$")
  public void checkProjectIsCloned() {
    String randomSpaceName = "Copy of " + Serenity.sessionVariableCalled("randomSpaceName");
    tasksSteps.checkClonedProject(randomSpaceName);
  }

  @Then("the project is created successfully and displayed on Tasks Space tab")
  public void checkProjectIsCreated() {
    tasksSteps.checkProjectIsCreated();
  }

  @Then("the project is created successfully and displayed on Projects tab")
  public void checkProjectIsDisplayed() {
    String projectName = Serenity.sessionVariableCalled("projectName");
    tasksSteps.checkProjectIsDisplayed(projectName);
  }

  @Then("^project is edited successfully$")
  public void checkProjectIsEdited() {
    String projectName = Serenity.sessionVariableCalled("newProjectName");
    String description = Serenity.sessionVariableCalled("newDescription");
    tasksSteps.checkEditedProject(projectName, description);
  }

  @Then("^The project '(.*)' is not created successfully and not displayed in Projects tab$")
  public void checkProjectIsNotDisplayed(String projectName) {
    tasksSteps.checkProjectNotDisplayed(projectName);
  }

  @Then("^Project name '(.*)' with description '(.*)' is displayed in Project Card$")
  public void checkProjectNameIsDisplayedInProjectCard(String projectName, String projectDescription) {
    tasksSteps.checkProjectNameIsDisplayedInProjectCard(projectName, projectDescription);
  }

  @And("^Status column '(.*)' is moved to the second position$")
  @Then("^Status column '(.*)' is displayed in the second position$")
  public void checkSecondStatusColumn(String columnStatus) {
    tasksSteps.checkSecondStatusColumn(columnStatus);
  }

  @Then("^The success message '(.*)' should be displayed$")
  public void checkSuccessMessage(String message) {
    tasksSteps.checkSuccessMessage(message);
  }

  @Then("^Task status '(.*)' is modified successfully$")
  public void checkTaskCardStatus(String taskStatus) {
    tasksSteps.checkTaskStatus(taskStatus);
  }

  @Then("^task '(.*)' is cloned successfully$")
  public void checkTaskIsCloned(String taskName) {
    tasksSteps.checkClonedTask(taskName);
  }

  @And("^Task priority '(.*)' is modified successfully$")
  public void checkTaskPriority(String taskPriority) {
    tasksSteps.checkTaskPriority(taskPriority);
  }

  @Then("^I check that Edit task drawer is displayed$")
  public void checkThatEditTaskDrawerIsDisplayed() {
    tasksSteps.checkThatEditTaskDrawerIsDisplayed();
  }

  @Then("^I check that a new second level drawer Changes is opened$")
  public void checkThatSecondLevelDrawerChangesIsOpened() {
    tasksSteps.checkThatSecondLevelDrawerChangesIsOpened();
  }

  @Then("^I check that tasks are grouped by Assignee$")
  public void checkThatTasksAreGroupedByAssignee() {
    tasksSteps.checkThatTasksAreGroupedByAssignee();
  }

  @And("^I check the timestamp update just below Task title Last Update$")
  public void checkTheTimestampUpdate() {
    tasksSteps.checkTheTimestampUpdate();
  }

  @And("^Status column '(.*)' is moved to the third position$")
  @Then("^Status column '(.*)' is displayed in the third position$")
  public void checkThirdStatusColumn(String columnStatus) {
    tasksSteps.checkThirdStatusColumn(columnStatus);
  }

  @Then("^I check a tooltip is displayed Click to view all changes$")
  public void checkTooltipIsDisplayed() {
    tasksSteps.checkTooltipIsDisplayed();
  }

  @Then("^The typed project '(.*)' is removed from the Filter by project field$")
  public void checkTypedProjectIsRemoved(String typedProject) {
    tasksSteps.checkTypedProjectIsRemoved(typedProject);
  }

  @Then("^The typed task '(.*)' is removed from Filter by task field$")
  public void checkTypedTaskIsRemoved(String typedTask) {
    tasksSteps.checkTypedTaskIsRemoved(typedTask);
  }

  @When("^The update description '(.*)' is displayed in origin task$")
  @Then("^The update description '(.*)' is displayed in cloned task$")
  public void checkUpdatedDescription(String description) {
    tasksSteps.checkUpdatedDescription(description);
  }

  @Then("^The label View all attachments is displayed$")
  public void checkViewLinkAttachments() {
    tasksSteps.checkViewLinkAttachments();
  }

  @And("^The clear button is disappeared from Filter by task field$")
  public void clearButtonInFilterByTaskIsNotVisible() {
    tasksSteps.clearButtonInFilterByTaskIsNotVisible();
  }

  @And("^A clear button is displayed in the Filter by task field$")
  public void clearButtonInFilterByTaskIsVisible() {
    tasksSteps.clearButtonInFilterByTaskIsVisible();
  }

  @And("^The clear button is disappeared from the Filter by project field$")
  public void clearButtonIsNotVisible() {
    tasksSteps.clearButtonIsNotVisible();
  }

  @And("^A clear button is displayed in the search field$")
  public void clearButtonIsVisible() {
    tasksSteps.clearButtonIsVisible();
  }

  @When("^I click on Add new comment button$")
  public void clickAddNewComment() {
    tasksSteps.clickAddNewComment();
  }

  @When("^I click to add new project$")
  public void clickAddProjectButton() {
    tasksSteps.clickAddProjectButton();
  }

  @When("^I click on (add project|add tasks) button$")
  public void clickAddProjectButton(String buttonName) {
    tasksSteps.clickAddProjectButton();
  }

  @When("^I click on cancel to not confirm project deletion$")
  public void clickCancel() {
    tasksSteps.clickCancel();
  }

  @When("^I click on delete to confirm project deletion$")
  public void clickDelete() {
    tasksSteps.clickDelete();
  }

  @When("^I click on delete project button$")
  public void clickDeleteProjectButton() {
    tasksSteps.clickDeleteProjectButton();
  }

  @When("^I click on document button$")
  public void clickDocButton() {
    tasksSteps.clickDocButton();
  }

  @And("^I click on Add Status After option of the fifth status column$")
  public void clickOnAddStatusAfterOptionOfTheFifthStatusColumn() {
    tasksSteps.clickOnAddStatusAfterOptionOfTheFifthStatusColumn();
  }

  @And("^I click on Add Status Before option$")
  public void clickOnAddStatusBeforeOption() {
    tasksSteps.clickOnAddStatusBeforeOption();
  }

  @And("^I click on Assignee radio button$")
  public void clickOnAssigneeRadioButton() {
    tasksSteps.clickOnAssigneeRadioButton();
  }

  @When("^I click on clear button$")
  public void clickOnClearButton() {
    tasksSteps.clickOnClearButton();
  }

  @When("^I click on clear button in the Filter by task field$")
  public void clickOnClearButtonInFilterByTask() {
    tasksSteps.clickOnClearButtonInFilterByTask();
  }

  @When("^I click on reply button related to comment '(.*)'$")
  public void clickOnCommentReply(String comment) {
    tasksSteps.clickOnCommentReply(comment);
  }

  @And("^I click on Confirm filter button$")
  public void clickOnConfirmButton() {
    tasksSteps.clickOnConfirmButton();
  }

  @And("^I click on Delete option$")
  public void clickOnDeleteStatusIcon() {
    tasksSteps.clickOnDeleteStatusIcon();
  }

  @When("^I click on task delete option$")
  public void clickOnDeleteTaskoption() {
    tasksSteps.clickOnDeleteTaskOption();
  }

  @When("^I click on Edit project button$")
  public void clickOnEditProjectButton() {
    tasksSteps.clickOnEditProjectButton();

  }

  @And("^I click on Filter button$")
  public void clickOnFilterButton() {
    tasksSteps.clickFilterButton();
  }

  @And("^I click on Move Status column after option$")
  public void clickOnMoveStatusAfterIcon() {
    tasksSteps.clickOnMoveStatusAfterIcon();
  }

  @And("^I click on Move Status column before option$")
  public void clickOnMoveStatusBeforeIcon() {
    tasksSteps.clickOnMoveStatusBeforeIcon();
  }

  @And("^I click on plus Button To Add Task$")
  public void clickOnPlusButtonToAddTask() {
    tasksSteps.clickOnPlusButtonToAddTask();
  }

  @And("^I click on plus Button To Add Task of the sixth status column$")
  public void clickOnPlusButtonToAddTaskOfTheSixthStatusColumn() {
    tasksSteps.clickOnPlusButtonToAddTaskOfTheSixthStatusColumn();
  }

  @When("^I click on three dots project button$")
  public void clickOnProjectThreeDotsButton() {
    tasksSteps.clickOnProjectThreeDotsButton();
  }

  @And("^I click on save Button To Add Task$")
  public void clickOnSaveButtonToAddTask() {
    tasksSteps.clickOnSaveButtonToAddTask();
  }

  @And("^I click on save Button To Add Task in space project$")
  public void clickOnSaveButtonToAddTaskSpaceProject() {
    tasksSteps.clickOnSaveButtonToAddTaskSpaceProject();
  }

  @When("^I click on three dots task option$")
  public void clickOnTaskThreeDotsOption() {
    tasksSteps.clickOnTaskThreeDotsOption();
  }

  @When("^I click on the notification that mention third user in a task in Project '(.*)' project$")
  public void clickOnTheNotificationThatMentioneFirstUserInATaskInProject(String projectName) {
    String message = "You have been mentioned in a task in" + " " + projectName + " " + "project";
    tasksSteps.clickOnTheNotificationThatMentionThirdUserInATaskInProject(message, projectName);
  }

  @When("^I click on the timestamp$")
  public void clickOnTheTimestamp() {
    tasksSteps.clickOnTheTimestamp();
  }

  @And("^I click on three dots icon of the first status column$")
  public void clickOnThreeDotsIcon() {
    tasksSteps.clickOnThreeDotsIcon();
  }

  @And("^I click on three dots icon of the fifth status column$")
  public void clickOnThreeDotsIconOfFifthColumn() {
    tasksSteps.clickOnFifthColumnThreeDotsIcon();
  }

  @And("^I click on three dots icon of the last status column$")
  public void clickOnThreeDotsIconOfLastColumn() {
    tasksSteps.clickOnLastColumnThreeDotsIcon();
  }

  @When("^I click on update button$")
  public void clickOnUpDateButton() {
    tasksSteps.clickOnUpDateButton();
  }

  @And("^I click on Validate Name$")
  public void clickOnValidateStatusName() {
    tasksSteps.clickOnValidateStatusName();
  }

  @And("^I click on plus icon from attachments list drawer$")
  public void clickPlusIcon() {
    tasksSteps.clickPlusIcon();
  }

  @And("^I click on plus icon from attachments list drawer in simple project$")
  public void clickPlusIconProject() {
    tasksSteps.clickPlusIconProject();
  }

  @And("I click on save project button")
  public void clickSaveProjectButton() {
    tasksSteps.clickSaveProjectButton();
  }

  @When("^I click on Status name '(.*)'$")
  public void clickStatusName(String statusColumn) {
    tasksSteps.clickStatusName(statusColumn);
  }

  @And("^I click on View all attachments link$")
  public void clickViewAttachmentLink() {
    tasksSteps.clickViewAttachmentLink();
  }

  @And("^I clone the project$")
  public void cloneProject() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    tasksSteps.cloneProject(randomSpaceName);
  }

  @And("^Clone project button is displayed$")
  public void cloneProjectButtonIsDisplayed() {
    tasksSteps.cloneProjectButtonIsDisplayed();
  }

  @When("^I clone Task in space project$")
  public void clonetaskinspaceproject() {
    tasksSteps.clonetaskinspaceproject();
  }

  @And("^Color Palette is displayed$")
  public void colorPaletteIsDisplayed() {
    tasksSteps.colorPaletteIsDisplayed();
  }

  @When("^Comment button is disabled$")
  public void commentButtonIsDisabled() {
    tasksSteps.commentButtonIsDisabled();
  }

  @When("^Comments drawer is displayed$")
  public void commentsDrawerIsDisplayed() {
    tasksSteps.commentsDrawerIsDisplayed();
  }

  @When("^(.*) user with the task comment '(.*)' is displayed in task comments drawer$")
  public void commentTaskWithRandomUser(String suffix, String comment) {
    String firstName = Serenity.sessionVariableCalled(suffix.toLowerCase() + "UserFirstName");
    String lastName = Serenity.sessionVariableCalled(suffix.toLowerCase() + "UserLastName");

    String fullName = firstName + " " + lastName;

    tasksSteps.commentTaskWithUser(fullName, comment);
  }

  @Then("^I mark the task as completed$")
  public void completeTask() {
    tasksSteps.completeTask();
  }

  @And("^I confirm the deletion message$")
  public void confirmDeleteStatusColumn() {
    tasksSteps.confirmDeleteStatusColumn();
  }

  @And("^I confirm deletion Task message$")
  public void confirmDeleteTask() {
    tasksSteps.confirmDeleteTask();
  }

  @When("^I click on Confirm button$")
  public void confirmFilter() {
    tasksSteps.confirmFilter();
  }

  @When("^Confirm button is displayed in the Filter drawer$")
  public void confirmFilterButtonIsDisplayed() {
    tasksSteps.confirmFilterButtonIsDisplayed();
  }

  @And("^I clear browsing data cache and cookies$")
  public void deleteCookies() {
    loginSteps.deleteCookies();
  }

  @And("^I delete the added project$")
  public void deleteProject() {
    String projectName = Serenity.sessionVariableCalled("projectName");
    tasksSteps.deleteProject(projectName);
  }

  @And("^Delete project button is displayed$")
  public void deleteProjectButtonIsDisplayed() {
    tasksSteps.deleteProjectButtonIsDisplayed();
  }

  @Then("^Delete task option is displayed$")
  public void deleteTaskOptionIsDisplayed() {
    tasksSteps.deleteTaskOptionIsDisplayed();
  }

  @And("^I edit description of the task '(.*)'$")
  public void editDescriptionForTask(String newDescription) {
    tasksSteps.editDescriptionForTask(newDescription);
  }

  @And("^Edit project button is displayed$")
  public void editProjectButtonIsDisplayed() {
    tasksSteps.editProjectButtonIsDisplayed();
  }

  @When("^I edit this project title '(.*)'$")
  public void editProjectName(String projectName) {
    tasksSteps.editProjectName(projectName);
  }

  @And("^I edit project name and description of added project$")
  public void editProjectNameWithDescription() {
    String projectName = Serenity.sessionVariableCalled("projectName");
    String newProjectName = "projectName" + getRandomNumber();
    String newDescription = "projectDescription" + getRandomNumber();
    Serenity.setSessionVariable("newProjectName").to(newProjectName);
    Serenity.setSessionVariable("newDescription").to(newDescription);
    tasksSteps.editProjectNameWithDescription(projectName, newProjectName, newDescription);
  }

  @When("^I edit the created project title$")
  public void editRandomProjectName() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    tasksSteps.editProjectName(randomSpaceName);
  }

  @When("^I edit the old Space Name with a new random Space Name$")
  public void editSpaceName() {
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    setSessionVariable("randomSpaceName").to(randomSpaceName);
    tasksSteps.editSpaceName(randomSpaceName);
  }

  @When("^Edit task drawer is displayed$")
  public void editTaskDrawerIsDisplayed() {
    tasksSteps.editTaskDrawerIsDisplayed();
  }

  @When("^I enter a comment with more than 1250 characters$")
  @And("^I enter a reply with more than 1250 characters$")
  public void enterCommentMore1250Chars() {
    String comment = StringUtils.repeat("tasks", 251);
    tasksSteps.enterTaskComment(comment);
  }

  @When("^I enter description for task '(.*)'$")
  public void enterDescriptionForTask(String description) {
    tasksSteps.enterDescriptionForTask(description);
  }

  @And("^I enter the project description '(.*)' without a project title$")
  public void enterProjectDescriptionWithoutTheTitle(String description) {
    tasksSteps.enterProjectDescriptionWithoutTheTitle(description);
  }

  @And("^I enter the project title '(.*)' with a description '(.*)'$")
  public void enterProjectTitleAndDescription(String projectName, String description) {
    tasksSteps.enterProjectTitleAndDescription(projectName, description);
  }

  @When("^I Type a Status name '(.*)'$")
  public void enterStatusText(String status) {
    tasksSteps.enterStatusText(status);
  }

  @When("^I enter title for task '(.*)'$")
  public void enterTitleForTask(String title) {
    tasksSteps.enterTitleForTask(title);
  }

  @Then("^I exit from project$")
  public void exitFromTheFirstProject() {
    tasksSteps.exitFromTheFirstProject();
  }

  @Then("^Avatar of the first created user is not displayed in Project Card$")
  public void firstRandomUserAvatarIsDisplayedInProjectCard() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    tasksSteps.userAvatarIsNotDisplayedInProjectCard(firstUserName);
  }

  @When("^I go back to edit task drawer$")
  public void goBack() {
    tasksSteps.goBack();
  }

  @When("^I go to Filter Tab$")
  public void goToFilterTab() {
    tasksSteps.goToFilterTab();
  }

  @When("^I go to Group And Sort Tab$")
  public void goToGroupAndSortTab() {
    tasksSteps.goToGroupAndSortTab();
  }

  @When("^I go to Labels Tab$")
  public void goToLabelsTab() {
    tasksSteps.goToLabelsTab();
  }

  @And("^I go to the PLAN view$")
  public void goToPLanView() {
    tasksSteps.goToPLanView();
  }

  @When("^I go to project details list$")
  public void goToProjectDetailsList() {
    tasksSteps.goToProjectDetailsList();
  }

  @When("I select projects tab")
  public void goToProjectsTab() {
    tasksSteps.goToProjectsTab();
  }

  @When("I select tasks tab")
  public void goToTasksTab() {
    tasksSteps.goToTasksTab();
  }

  @When("^Next to max chars number a green information icon is displayed$")
  public void greenInformationIconIsDisplayed() {
    tasksSteps.greenInformationIconIsDisplayed();
  }

  @When("^I hover on project manager icon$")
  public void hoverOnProjectManagerIcon() {
    tasksSteps.hoverOnProjectManagerIcon();
  }

  @When("^I hover on task's title '(.*)'$")
  public void hoverOnTaskName(String task) {
    tasksSteps.hoverOnTaskName(task);
  }

  @When("^I hover on the Changes timestamp$")
  public void hoverOnTheChangesTimestamp() {
    tasksSteps.hoverOnTheChangesTimestamp();
  }

  @When("^'(.*)' Tab is displayed$")
  public void isFilterDrawerTabDisplayed(String tab) {
    tasksSteps.isFilterDrawerTabDisplayed(tab);
  }

  @When("^The label '(.*)' is displayed '(.*)' times in project details$")
  @And("^In Section '(.*)', '(.*)' tasks are displayed$")
  @Then("^In Section '(.*)', '(.*)' task is displayed$")
  public void isLabelDisplayedInProjectDetails(String label, String times) {
    tasksSteps.isLabelDisplayedInProjectDetails(label, times);
  }

  @Then("^The searched task '(.*)' is displayed$")
  public void isSearchedTaskDisplayed(String taskName) {
    tasksSteps.isSearchedTaskDisplayed(taskName);
  }

  @When("^Status name '(.*)' Edit mode is opened successfully$")
  public void isStatusEditModeDisplayed(String statusColumn) {
    assertThat(tasksSteps.isStatusEditModeDisplayed(statusColumn)).as("Status edit mode is opened successfully")
                                                                  .isTrue();
  }

  @When("^Status name '(.*)' Edit mode is not opened successfully$")
  public void isStatusEditModeNotDisplayed(String statusColumn) {
    assertThat(tasksSteps.isStatusEditModeDisplayed(statusColumn)).as("Status edit mode is opened successfully")
                                                                  .isFalse();
  }

  @When("^Label '(.*)' is displayed in edit project drawer$")
  public void labelIsDisplayedInProjectDrawer(String label) {
    tasksSteps.labelIsDisplayedInProjectDrawer(label);
  }

  @When("^Label '(.*)' is displayed in edit task drawer and x icon is not displayed$")
  public void labelIsDisplayedInTaskDrawer(String label) {
    tasksSteps.labelIsDisplayedInTaskDrawer(label);
  }

  @When("^Label '(.*)' is Not displayed in edit project drawer$")
  public void labelIsNotDisplayedInProjectDrawer(String label) {
    tasksSteps.labelIsNotDisplayedInProjectDrawer(label);
  }

  @And("^I mark the task as completed from the task card$")
  public void markTaskAsCompletedFromTaskCard() {
    tasksSteps.markTaskAsCompletedFromTaskCard();
  }

  @When("^I mark the task '(.*)' as completed in project details$")
  public void markTaskAsCompletedInProjectDetails(String taskName) {
    tasksSteps.markTaskAsCompletedInProjectDetails(taskName);
  }

  @When("^The max chars number is 1250$")
  public void maxCharsCount1250InformationIsDisplayed() {
    tasksSteps.maxCharsCount1250InformationIsDisplayed();
  }

  @When("^Message : Please don't exceed 1250 characters, is displayed$")
  public void maxCharsNumberMessageIsDisplayed() {
    tasksSteps.maxCharsNumberMessageIsDisplayed();
  }

  @When("^The max chars number has been exceeded and it is displayed in red$")
  public void more1250CharsInformationIsDisplayed() {
    tasksSteps.more1250CharsInformationIsDisplayed();
  }

  @And("^I check that Move Status column after option is not displayed$")
  public void moveStatusAfterIconIsNotDisplayed() {
    tasksSteps.checkMoveStatusAfterIconIsNotDisplayed();
  }

  @And("^I check that Move Status column before option is not displayed$")
  public void moveStatusBeforeIconIsNotDisplayed() {
    tasksSteps.checkMoveStatusBeforeIconIsNotDisplayed();
  }

  @And("^I open the cloned project$")
  public void openClonedProject() {
    String randomSpaceName = "Copy of " + Serenity.sessionVariableCalled("randomSpaceName");
    tasksSteps.openProject(randomSpaceName);
  }

  @When("^I open the Filter drawer$")
  public void openFilterDrawer() {
    tasksSteps.openFilterDrawer();
  }

  @And("^I open the added project$")
  public void openProject() {
    String projectName = Serenity.sessionVariableCalled("projectName");
    tasksSteps.openProject(projectName);
  }

  @When("^I open the project '(.*)'$")
  public void openProject(String project) {
    tasksSteps.openProject(project);
  }

  @When("^I open the created project$")
  public void openRandomProject() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    tasksSteps.openProject(randomSpaceName);
  }

  @And("^I open the task '(.*)'$")
  public void openTaskCard(String task) {
    tasksSteps.openTaskCard(task);
  }

  @When("^I open the created task '(.*)'$")
  public void openTaskCreated(String taskName) {
    tasksSteps.openTaskCreated(taskName);
  }

  @When("^In Tasks tab, I open the task '(.*)'$")
  public void openTaskInTasksTab(String taskName) {
    tasksSteps.openTaskInTasksTab(taskName);
  }

  @Given("^The project drawer is not closing$")
  public void projectDrawerNotClosing() {
    tasksSteps.projectDrawerNotClosing();
  }

  @Then("^Project '(.*)' is displayed in Tasks App Center$")
  @And("^Project '(.*)' is displayed in Tasks space$")
  public void projectIsDisplayedInTasksAppCenter(String projectName) {
    tasksSteps.projectIsDisplayedInTasksAppCenter(projectName);
  }

  @When("The project name is displayed in project details")
  public void projectNameIsDisplayedInProjectDetails() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    tasksSteps.projectNameIsDisplayedInProjectDetails(randomSpaceName);
  }

  @When("^The project '(.*)' is displayed in project details$")
  public void projectNameIsDisplayedInProjectDetails(String projectName) {
    tasksSteps.projectNameIsDisplayedInProjectDetails(projectName);
  }

  @When("The created project name is displayed in project details")
  public void randomProjectNameIsDisplayedInProjectDetails() {
    String randomProjectName = Serenity.sessionVariableCalled("projectName");
    tasksSteps.projectNameIsDisplayedInProjectDetails(randomProjectName);
  }

  @Then("^Avatar of the first created user is displayed in Project Card$")
  public void randomUserAvatarIsDisplayedInProjectCard() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    tasksSteps.userAvatarIsDisplayedInProjectCard(firstUserName);
  }

  @When("^Next to max chars number a red information icon is displayed$")
  public void redInformationIconIsDisplayed() {
    tasksSteps.redInformationIconIsDisplayed();
  }

  @When("^I Remove Label '(.*)' in edit project drawer$")
  public void removeLabelToProject(String label) {
    tasksSteps.removeLabelToProject(label);
  }

  @When("^Reply button is disabled$")
  public void replyTaskCommentButtonIsDisabled() {
    tasksSteps.replyTaskCommentButtonIsDisabled();
  }

  @When("^Reset button is displayed in the Filter drawer$")
  public void resetFilterButtonIsDisplayed() {
    tasksSteps.resetFilterButtonIsDisplayed();
  }

  @And("^I return to Projects tab$")
  public void returnToProjectsTab() {
    tasksSteps.returnToProjectsTab();
  }

  @And("I save the addition of the new project")
  public void saveAddingProject() {
    tasksSteps.saveAddingProject();
  }

  @Then("^I start the search for Task '(.*)'$")
  public void searchTask(String taskName) {
    tasksSteps.searchTask(taskName);
  }

  @Then("^Avatar of the second created user is not displayed in Project Card$")
  public void secondRandomUserAvatarIsDisplayedInProjectCard() {
    String secondUserName = Serenity.sessionVariableCalled("secondUserName");
    tasksSteps.userAvatarIsNotDisplayedInProjectCard(secondUserName);
  }

  @When("^I select '(.*)' from Sort By Filter section$")
  @And("^I select '(.*)' from Group By Filter section$")
  public void selectFilterOption(String label) {
    tasksSteps.selectFilterOption(label);
  }

  @And("^I set task priority to '(.*)'$")
  public void selectTaskPriority(String taskPriority) {
    tasksSteps.setTaskPriority(taskPriority);
  }

  @When("^I search for the project '(.*)'$")
  public void setInSearchProjectField(String project) {
    tasksSteps.setInSearchProjectField(project);
  }

  @When("^I search for the created project '(.*)'$")
  public void setInSearchProjectNameField(String project) {
    tasksSteps.setInSearchProjectField(project);
  }

  @When("^I search for the created project$")
  public void setInSearchRandomProjectField() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    tasksSteps.setInSearchProjectField(randomSpaceName);
  }

  @When("^I enter the project name '(.*)'$")
  public void setProjectTitle(String projectTitle) {
    tasksSteps.setProjectTitle(projectTitle);
  }

  @When("^I mark the task as completed in task drawer$")
  public void setTaskCompletedInDrawer() {
    tasksSteps.setTaskCompletedInDrawer();
  }

  @When("^I mark the task as completed in task drawer without closing the drawer$")
  public void setTaskCompletedInDrawerWithoutClosingIt() {
    tasksSteps.setTaskCompletedInDrawerWithoutClosingIt();
  }

  @When("^I enter Description for this task '(.*)'$")
  public void setTaskDescription(String description) {
    tasksSteps.setTaskDescription(description);
  }

  @And("^I set task due date Next week$")
  public void setTaskDueDateNextWeek() {
    tasksSteps.setTaskDueDateNextWeek();
  }

  @And("^I set task due date TODAY$")
  public void setTaskDueDateToday() {
    tasksSteps.setTaskDueDateToday();
  }

  @And("^I set task due date TOMORROW$")
  public void setTaskDueDateTomorrow() {
    tasksSteps.setTaskDueDateTomorrow();
  }

  @And("^I set task start date TODAY$")
  public void setTaskStartDateToday() {
    tasksSteps.setTaskStartDateToday();
  }

  @And("^I set task start date TOMORROW$")
  public void setTaskStartDateTomorrow() {
    tasksSteps.setTaskStartDateTomorrow();
  }

  @And("^I set task status to '(.*)'$")
  public void setTaskStatus(String taskStatus) {
    tasksSteps.setTasksStatus(taskStatus);
  }

  @And("^I switch to TASKS tab$")
  public void switchToTASKSTab() {
    tasksSteps.switchToTASKSTab();
  }

  @When("^Alert '(.*)' is displayed$")
  public void taskAlertIsDisplayed(String message) {
    tasksSteps.taskAlertIsDisplayed(message);
  }

  @When("^Task name '(.*)' is displayed in project details$")
  public void taskIsDisplayedInProjectDetails(String taskName) {
    tasksSteps.taskIsDisplayedInProjectDetails(taskName);
  }

  @When("^Task '(.*)' is marked as completed and displayed in Completed section$")
  public void taskIsMarkedAndDisplayedInCompletedSection(String taskName) {
    tasksSteps.taskIsMarkedAndDisplayedInCompletedSection(taskName);
  }

  @When("^Task name '(.*)' is not displayed in project details$")
  public void taskIsNotDisplayedInProjectDetails(String taskName) {
    tasksSteps.taskIsNotDisplayedInProjectDetails(taskName);
  }

  @When("^Task '(.*)' is not marked as completed and displayed in Uncompleted section$")
  public void taskIsNotMarkedAndDisplayedInUncompletedSection(String taskName) {
    tasksSteps.taskIsNotMarkedAndDisplayedInUncompletedSection(taskName);
  }

  @When("^The task is marked as completed in task drawer$")
  public void taskMarkedAsCompletedIsDisplayedInDrawer() {
    tasksSteps.taskMarkedAsCompletedIsDisplayedInDrawer();
  }

  @When("^Task label '(.*)' related to task name '(.*)' is displayed in project details$")
  public void taskNameAndLabelIsDisplayedInProjectDetails(String label, String taskName) {
    tasksSteps.taskNameAndLabelIsDisplayedInProjectDetails(label, taskName);
  }

  @When("^In column status '(.*)' , Task name '(.*)' is displayed$")
  public void taskNameIsDisplayedInDesiredColumn(String status, String taskName) {
    tasksSteps.taskNameIsDisplayedInDesiredColumn(status, taskName);
  }

  @Then("^The task name '(.*)' should be displayed in PLAN view$")
  public void taskNamePLanView(String taskName) {
    tasksSteps.taskNamePLanView(taskName);
  }

  @When("^In project details the task '(.*)' is displayed in '(.*)' place$")
  public void taskOrderInProjectDetails(String task, String number) {
    tasksSteps.taskOrderInProjectDetails(task, number);
  }

  @When("^Tasks number '(.*)' is displayed in the column To Do$")
  public void tasksNumberToDo(String tasksNumber) {
    tasksSteps.tasksNumberToDo(tasksNumber);
  }

  @When("^Task tooltip is displayed '(.*)'$")
  public void taskTooltipIsDisplayed(String task) {
    tasksSteps.taskTooltipIsDisplayed(task);
  }

  @When("^I update task Description '(.*)'$")
  public void updateTaskDescription(String description) {
    tasksSteps.updateTaskDescription(description);
  }

  @Then("^User avatar '(.*)' is displayed in Project Card$")
  public void userAvatarIsDisplayedInProjectCard(String userName) {
    tasksSteps.userAvatarIsDisplayedInProjectCard(userName);
  }

  @Then("^User avatar '(.*)' is not displayed in Project Card$")
  public void userAvatarIsNotDisplayedInProjectCard(String userName) {
    tasksSteps.userAvatarIsNotDisplayedInProjectCard(userName);
  }

  @Then("^Space manager '(.*)' is displayed in Project Card$")
  @And("^Project manager '(.*)' is displayed in Project Card$")
  public void userFullNameIsDisplayedInProjectCard(String name) {
    tasksSteps.userFullNameIsDisplayedInProjectCard(name);
  }

  @Then("^Space member '(.*)' is not displayed in Project Card$")
  @And("^Project participant '(.*)' is not displayed in Project Card$")
  public void userFullNameIsNotDisplayedInProjectCard(String name) {
    tasksSteps.userFullNameIsNotDisplayedInProjectCard(name);
  }

  @Then("^First Space member is not displayed in Project Card$")
  @And("^First Project participant is not displayed in Project Card$")
  public void userFullRandomNameIsNotDisplayedInProjectCard() {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String fullName = firstUserFirstName + " " + firstUserLastName;
    tasksSteps.userFullNameIsNotDisplayedInProjectCard(fullName);
  }

  @Then("^The label View all attachments is not displayed$")
  public void verifyViewLinkAttachments() {
    tasksSteps.verifyViewLinkAttachments();
  }

  @When("^I view all task comments$")
  public void viewAllCommentsTaskButton() {
    tasksSteps.viewAllCommentsTaskButton();
  }
}
