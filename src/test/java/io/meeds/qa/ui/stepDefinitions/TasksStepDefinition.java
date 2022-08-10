package io.meeds.qa.ui.stepDefinitions;

import static io.meeds.qa.ui.stepDefinitions.ManageSpaceStepDefinitions.getRandomNumber;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.meeds.qa.ui.steps.HomeSteps;
import io.meeds.qa.ui.steps.ManageSpaceSteps;
import io.meeds.qa.ui.steps.TasksSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class TasksStepDefinition {
  @Steps
  HomeSteps        homeSteps;

  @Steps
  TasksSteps       tasksSteps;

  @Steps
  ManageSpaceSteps manageSpaceSteps;

  @Given("^The following task is created$")
  public void addTask(Map<String, String> userDetails) {
    tasksSteps.addTask(userDetails);
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

  @When("^I click on Status name '(.*)'$")
  public void clickStatusName(String statusColumn) {
    tasksSteps.clickStatusName(statusColumn);
  }

  @When("^I add this project '(.*)'$")
  public void addProject(String projectName) {
    tasksSteps.addProject(projectName);
  }

  @When("^Task tooltip is displayed '(.*)'$")
  public void taskTooltipIsDisplayed(String task) {
    tasksSteps.taskTooltipIsDisplayed(task);
  }

  @When("^I hover on task's title '(.*)'$")
  public void hoverOnTaskName(String task) {
    tasksSteps.hoverOnTaskName(task);
  }

  @When("^I edit this project title '(.*)'$")
  public void editProjectName(String projectName) {
    tasksSteps.editProjectName(projectName);
  }

  @Given("^The following task is created in the specific project$")
  public void addTaskInProject(Map<String, String> userDetails) {
    tasksSteps.addTaskInProject(userDetails);
  }

  @When("^I add this comment '(.*)' in task$")
  public void addNewCommentInTask(String comment) {
    tasksSteps.addNewCommentInTask(comment);
  }

  @When("^I enter a comment '(.*)' with mentioning the first user in task$")
  public void addNewCommentInTaskWithMentioningTheFirstUserInTask(String comment)  {
    String user = Serenity.sessionVariableCalled("firstUserName");
    tasksSteps.addNewCommentInTaskWithMentioningTheFirstUserInTask(comment, user);
  }

  @When("^I click on Add new comment button$")
  public void clickAddNewComment() {
    tasksSteps.clickAddNewComment();
  }

  @When("^I enter a comment with more than 1250 characters$")
  @And("^I enter a reply with more than 1250 characters$")
  public void enterCommentMore1250Chars() {
    String comment = StringUtils.repeat("tasks", 251);
    tasksSteps.enterTaskComment(comment);
  }

  @When("^I enter label '(.*)' in the project$")
  public void addLabelToProject(String label) {
    tasksSteps.addLabelToProject(label);
  }

  @When("^I click on Edit project button$")
  public void clickOnEditProjectButton() {
    tasksSteps.clickOnEditProjectButton();
    ;
  }

  @When("^Label '(.*)' is displayed in edit project drawer$")
  public void labelIsDisplayedInProjectDrawer(String label) {
    tasksSteps.labelIsDisplayedInProjectDrawer(label);
  }

  @When("^I enter four label '(.*)' '(.*)' '(.*)' '(.*)' in the project$")
  public void addFourLabelToProject(String label1, String label2, String label3, String label4) {
    tasksSteps.addFourLabelToProject(label1, label2, label3, label4);
  }

  @When("^Next to max chars number a green information icon is displayed$")
  public void greenInformationIconIsDisplayed() {
    tasksSteps.greenInformationIconIsDisplayed();
  }

  @When("^The max chars number has been exceeded and it is displayed in red$")
  public void more1250CharsInformationIsDisplayed() {
    tasksSteps.more1250CharsInformationIsDisplayed();
  }

  @When("^The max chars number is 1250$")
  public void maxCharsCount1250InformationIsDisplayed() {
    tasksSteps.maxCharsCount1250InformationIsDisplayed();
  }

  @When("^Comment button is disabled$")
  public void commentButtonIsDisabled() {
    tasksSteps.commentButtonIsDisabled();
  }

  @When("^Reply button is disabled$")
  public void replyTaskCommentButtonIsDisabled() {
    tasksSteps.replyTaskCommentButtonIsDisabled();
  }

  @When("^Message : Please don't exceed 1250 characters, is displayed$")
  public void maxCharsNumberMessageIsDisplayed() {
    tasksSteps.maxCharsNumberMessageIsDisplayed();
  }

  @Given("^The following task with label '(.*)' is created in the specific project$")
  public void addTaskWithLabelInProject(String label, Map<String, String> userDetails) {
    tasksSteps.addTaskWithLabelInProject(label, userDetails);
  }

  @When("^I add other comment '(.*)' in task$")
  public void addOtherCommentInTask(String comment) {
    tasksSteps.addOtherCommentInTask(comment);
  }

  @When("^The project name is displayed in project details$")
  public void projectNameIsDisplayedInProjectDetails() {
    String randomProjectName = Serenity.sessionVariableCalled("randomProjectName");
    tasksSteps.projectNameIsDisplayedInProjectDetails(randomProjectName);
  }

  @When("^Board view is displayed by default$")
  public void boardViewIsDisplayedByDefault() {
    tasksSteps.boardViewIsDisplayedByDefault();
  }

  @When("^Task label '(.*)' related to task name '(.*)' is displayed in project details$")
  public void taskNameAndLabelIsDisplayedInProjectDetails(String label, String taskName) {
    tasksSteps.taskNameAndLabelIsDisplayedInProjectDetails(label, taskName);
  }

  @When("^Task name '(.*)' is displayed in project details$")
  public void taskIsDisplayedInProjectDetails(String taskName) {
    tasksSteps.taskIsDisplayedInProjectDetails(taskName);
  }

  @When("^I go to project details list$")
  public void goToProjectDetailsList() {
    tasksSteps.goToProjectDetailsList();
  }

  @When("^In project details the task '(.*)' is displayed in '(.*)' place$")
  public void taskOrderInProjectDetails(String task, String number) {
    tasksSteps.taskOrderInProjectDetails(task, number);
  }

  @When("^The label '(.*)' is displayed '(.*)' times in project details$")
  @And("^In Section '(.*)', '(.*)' tasks are displayed$")
  @Then("^In Section '(.*)', '(.*)' task is displayed$")
  public void isLabelDisplayedInProjectDetails(String label, String times) {
    tasksSteps.isLabelDisplayedInProjectDetails(label, times);
  }

  @When("^I click on Confirm button$")
  public void confirmFilter() {
    tasksSteps.confirmFilter();
  }

  @When("^Confirm button is displayed in the Filter drawer$")
  public void confirmFilterButtonIsDisplayed() {
    tasksSteps.confirmFilterButtonIsDisplayed();
  }

  @When("^Cancel button is displayed in the Filter drawer$")
  public void cancelFilterButtonIsDisplayed() {
    tasksSteps.cancelFilterButtonIsDisplayed();
  }

  @When("^Reset button is displayed in the Filter drawer$")
  public void resetFilterButtonIsDisplayed() {
    tasksSteps.resetFilterButtonIsDisplayed();
  }

  @When("^I select '(.*)' from Sort By Filter section$")
  @And("^I select '(.*)' from Group By Filter section$")
  public void selectFilterOption(String label) {
    tasksSteps.selectFilterOption(label);
  }

  @When("^'(.*)' Tab is displayed$")
  public void isFilterDrawerTabDisplayed(String tab) {
    tasksSteps.isFilterDrawerTabDisplayed(tab);
  }

  @When("^I go to Labels Tab$")
  public void goToLabelsTab() {
    tasksSteps.goToLabelsTab();
  }

  @When("^I go to Filter Tab$")
  public void goToFilterTab() {
    tasksSteps.goToFilterTab();
  }

  @When("^I go to Group And Sort Tab$")
  public void goToGroupAndSortTab() {
    tasksSteps.goToGroupAndSortTab();
  }

  @When("^I open the Filter drawer$")
  public void openFilterDrawer() {
    tasksSteps.openFilterDrawer();
  }

  @When("^Alert '(.*)' is displayed$")
  public void taskAlertIsDisplayed(String message) {
    tasksSteps.taskAlertIsDisplayed(message);
  }

  @When("^Task name '(.*)' is not displayed in project details$")
  public void taskIsNotDisplayedInProjectDetails(String taskName) {
    tasksSteps.taskIsNotDisplayedInProjectDetails(taskName);
  }

  @Then("the project is created successfully and displayed on Tasks Space tab")
  public void checkProjectIsCreated() {
    tasksSteps.checkProjectIsCreated();
  }

  @Then("^Project '(.*)' is displayed in Tasks App Center$")
  @And("^Project '(.*)' is displayed in Tasks space$")
  public void projectIsDisplayedInTasksAppCenter(String projectName) {
    tasksSteps.projectIsDisplayedInTasksAppCenter(projectName);
  }

  @When("^I edit the old Space Name with a new random Space Name$")
  public void editSpaceName() {
    String randomSpaceName = "randomSpaceName" + getRandomNumber();
    setSessionVariable("randomSpaceName").to(randomSpaceName);
    tasksSteps.editSpaceName(randomSpaceName);
  }

  @When("^Next to max chars number a red information icon is displayed$")
  public void redInformationIconIsDisplayed() {
    tasksSteps.redInformationIconIsDisplayed();
  }

  @When("^Tasks number '(.*)' is displayed in the column To Do$")
  public void tasksNumberToDo(String tasksNumber) {
    tasksSteps.tasksNumberToDo(tasksNumber);
  }

  @When("^Task '(.*)' is marked as completed and displayed in Completed section$")
  public void taskIsMarkedAndDisplayedInCompletedSection(String taskName) {
    tasksSteps.taskIsMarkedAndDisplayedInCompletedSection(taskName);
  }

  @When("^Task '(.*)' is not marked as completed and displayed in Uncompleted section$")
  public void taskIsNotMarkedAndDisplayedInUncompletedSection(String taskName) {
    tasksSteps.taskIsNotMarkedAndDisplayedInUncompletedSection(taskName);
  }

  @When("^The task is marked as completed in task drawer$")
  public void taskMarkedAsCompletedIsDisplayedInDrawer() {
    tasksSteps.taskMarkedAsCompletedIsDisplayedInDrawer();
  }

  @When("^I close task comments drawer$")
  public void closetaskCommentsDrawer() {
    tasksSteps.closetaskCommentsDrawer();
  }

  @Then("^I close task drawer of cloned task$")
  @When("^I close task drawer$")
  public void closetaskDrawer() {
    tasksSteps.closetaskDrawer();
  }

  @When("^I view all task comments$")
  public void viewAllCommentsTaskButton() {
    tasksSteps.viewAllCommentsTaskButton();
  }

  @When("^I click on reply button related to comment '(.*)'$")
  public void clickOnCommentReply(String comment) {
    tasksSteps.clickOnCommentReply(comment);
  }

  @When("^I select '(.*)' tab$")
  public void goToTab(String tab) {
    tasksSteps.goToTab(tab);
  }

  @Then("^The searched task '(.*)' is displayed$")
  public void isSearchedTaskDisplayed(String taskName) {
    tasksSteps.isSearchedTaskDisplayed(taskName);
  }

  @When("^I search for the project '(.*)'$")
  public void setInSearchProjectField(String project) {
    tasksSteps.setInSearchProjectField(project);
  }

  @Given("^I create space project with user '(.*)'$")
  public void addNewRandomProjectWithUser(String user) {
    homeSteps.goToManageSpacesPage();
    String randomProjectName = "randomProjectName" + getRandomNumber();
    Serenity.setSessionVariable("randomProjectName").to(randomProjectName);
    manageSpaceSteps.addSpaceWithInviteUser(randomProjectName, user);
  }

  @Given("^I close the project drawer$")
  public void closeProjectDrawer() {
    tasksSteps.closeProjectDrawer();
  }

  @Given("^I create space project with the first user$")
  public void addNewRandomProjectWithFirstUser() {
    homeSteps.goToManageSpacesPage();
    String randomProjectName = "randomProjectName" + getRandomNumber();
    Serenity.setSessionVariable("randomProjectName").to(randomProjectName);
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    manageSpaceSteps.addSpaceWithInviteUser(randomProjectName, firstUserName);
  }

  @Given("^The project drawer is not closing$")
  public void projectDrawerNotClosing() {
    tasksSteps.projectDrawerNotClosing();
  }

  @Given("^I create space project$")
  public void addNewRandomProject() {
    homeSteps.goToManageSpacesPage();
    String randomProjectName = "randomProjectName" + getRandomNumber();
    Serenity.setSessionVariable("randomProjectName").to(randomProjectName);
    manageSpaceSteps.addSimpleSpace(randomProjectName);
  }

  @When("^I search for the created project$")
  public void setInSearchRandomProjectField() {
    String randomProjectName = Serenity.sessionVariableCalled("randomProjectName");
    tasksSteps.setInSearchProjectField(randomProjectName);
  }

  @When("^I edit the created project title$")
  public void editRandomProjectName() {
    String randomProjectName = Serenity.sessionVariableCalled("randomProjectName");
    tasksSteps.editProjectName(randomProjectName);
  }

  @When("^I search for the created space$")
  public void setInSearchRandomSpaceField() {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    tasksSteps.setInSearchProjectField(randomSpaceName);
  }

  @When("^I open the created project$")
  public void openRandomProject() {
    String randomProjectName = Serenity.sessionVariableCalled("randomProjectName");
    tasksSteps.openProject(randomProjectName);
  }

  @When("^I accept the invitation of the created space project$")
  public void acceptRandomSpaceProject() {
    String randomProjectName = Serenity.sessionVariableCalled("randomProjectName");
    homeSteps.acceptRandomSpaceInvitation(randomProjectName);
  }

  @When("^I open the project '(.*)'$")
  public void openProject(String project) {
    tasksSteps.openProject(project);
  }

  @And("^I open the task '(.*)'$")
  public void openTaskCard(String task) {
    tasksSteps.openTaskCard(task);
  }

  @When("^In Tasks tab, I open the task '(.*)'$")
  public void openTaskInTasksTab(String taskName) {
    tasksSteps.openTaskInTasksTab(taskName);
  }

  @When("^Edit task drawer is displayed$")
  public void editTaskDrawerIsDisplayed() {
    tasksSteps.editTaskDrawerIsDisplayed();
  }

  @When("^Comments drawer is displayed$")
  public void commentsDrawerIsDisplayed() {
    tasksSteps.commentsDrawerIsDisplayed();
  }

  @When("^'(.*)' with the task comment '(.*)' is displayed in task comments drawer$")
  public void commentTaskWithUser(String user, String comment) {
    tasksSteps.commentTaskWithUser(user, comment);
  }

  @When("^I mark the task as completed in task drawer$")
  public void setTaskCompletedInDrawer() {
    tasksSteps.setTaskCompletedInDrawer();
  }

  @When("^I mark the task as completed in task drawer without closing the drawer$")
  public void setTaskCompletedInDrawerWithoutClosingIt() {
    tasksSteps.setTaskCompletedInDrawerWithoutClosingIt();
  }

  @When("^First user with the task comment '(.*)' is displayed in task comments drawer$")
  public void commentTaskWithFirstUser(String comment) {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String fullName = firstUserFirstName + " " + firstUserLastName;

    tasksSteps.commentTaskWithUser(fullName, comment);
  }

  @When("^I mark the task '(.*)' as completed in project details$")
  public void markTaskAsCompletedInProjectDetails(String taskName) {
    tasksSteps.markTaskAsCompletedInProjectDetails(taskName);
  }

  @Then("^I mark the task as completed$")
  public void completeTask() {
    tasksSteps.completeTask();
  }

  @Then("^I start the search for Task '(.*)'$")
  public void searchTask(String taskName) {
    tasksSteps.searchTask(taskName);
  }

  @And("^I add a new project with a description$")
  public void addProjectWithDescription() {
    String projectName = "projectName" + getRandomNumber();
    Serenity.setSessionVariable("projectName").to(projectName);
    String description = "description" + getRandomNumber();
    Serenity.setSessionVariable("description").to(description);
    tasksSteps.addProjectWithDescription(projectName, description);
  }

  @And("^I enter the project title '(.*)' with a description '(.*)'$")
  public void enterProjectTitleAndDescription(String projectName, String description) {
    tasksSteps.enterProjectTitleAndDescription(projectName, description);
  }

  @And("^I enter the project description '(.*)' without a project title$")
  public void enterProjectDescriptionWithoutTheTitle(String description) {
    tasksSteps.enterProjectDescriptionWithoutTheTitle(description);
  }

  @And("I save the addition of the new project")
  public void saveAddingProject() {
    tasksSteps.saveAddingProject();
  }

  @And("^I add a new project$")
  public void addProject() {
    String projectName = "projectName" + getRandomNumber();
    Serenity.setSessionVariable("projectName").to(projectName);
    tasksSteps.addProject(projectName);
  }

  @Then("the project is created successfully and displayed on Projects tab")
  public void checkProjectIsDisplayed() {
    String projectName = Serenity.sessionVariableCalled("projectName");
    tasksSteps.checkProjectIsDisplayed(projectName);
  }

  @Then("^The project '(.*)' is not created successfully and not displayed in Projects tab$")
  public void checkProjectIsNotDisplayed(String projectName) {
    tasksSteps.checkProjectNotDisplayed(projectName);
  }

  @And("^I delete the added project$")
  public void deleteProject() {
    String projectName = Serenity.sessionVariableCalled("projectName");
    tasksSteps.deleteProject(projectName);
  }

  @When("^I click on three dots project button$")
  public void clickOnProjectThreeDotsButton() {
    tasksSteps.clickOnProjectThreeDotsButton();
  }

  @Then("^the project is deleted successfully from Projects tab$")
  public void checkDeletedProject() {
    String projectName = Serenity.sessionVariableCalled("projectName");
    tasksSteps.checkDeletedProject(projectName);
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

  @Then("^project is edited successfully$")
  public void checkProjectIsEdited() {
    String projectName = Serenity.sessionVariableCalled("newProjectName");
    String description = Serenity.sessionVariableCalled("newDescription");
    tasksSteps.checkEditedProject(projectName, description);
  }

  @Then("^Project name '(.*)' with description '(.*)' is displayed in Project Card$")
  public void checkProjectNameIsDisplayedInProjectCard(String projectName, String projectDescription) {
    tasksSteps.checkProjectNameIsDisplayedInProjectCard(projectName, projectDescription);
  }

  @Then("^First project name with description '(.*)' is displayed in Project Card$")
  public void checkRandomProjectNameIsDisplayedInProjectCard(String projectDescription) {
    String randomSpaceName = Serenity.sessionVariableCalled("randomSpaceName");
    tasksSteps.checkProjectNameIsDisplayedInProjectCard(randomSpaceName, projectDescription);
  }

  @Then("^I create the project '(.*)' with the participant '(.*)'$")
  public void addProjectWithParticipant(String projectName, String fullName) {
    tasksSteps.addProjectWithParticipant(projectName, fullName);

  }

  @Then("^I create the random project with the first created user as participant$")
  public void addRandomProjectWithRandomParticipant() {
    String randomProjectName = "randomProjectName" + getRandomNumber();
    Serenity.setSessionVariable("randomProjectName").to(randomProjectName);
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");

    String firstUserFullName = firstUserFirstName + " " + firstUserLastName;
    tasksSteps.addProjectWithParticipant(randomProjectName, firstUserFullName);
  }

  @When("^I Remove Label '(.*)' in edit project drawer$")
  public void removeLabelToProject(String label) {
    tasksSteps.removeLabelToProject(label);
  }

  @When("^Label '(.*)' is Not displayed in edit project drawer$")
  public void labelIsNotDisplayedInProjectDrawer(String label) {
    tasksSteps.labelIsNotDisplayedInProjectDrawer(label);
  }

  @When("^I add Label '(.*)' to task$")
  public void addLabelToTask(String label) {
    tasksSteps.addLabelToTask(label);
  }

  @When("^Label '(.*)' is displayed in edit task drawer and x icon is not displayed$")
  public void labelIsDisplayedInTaskDrawer(String label) {
    tasksSteps.labelIsDisplayedInTaskDrawer(label);
  }

  @When("^I enter six label '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' in the project$")
  public void addSixLabelToProject(String label1, String label2, String label3, String label4, String label5, String label6) {
    tasksSteps.addSixLabelToProject(label1, label2, label3, label4, label5, label6);
  }

  @Then("^I add second user as the participant in the project$")
  public void addSecondUserToProject() {
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");
    String secondUserFullName = secondUserFirstName + " " + secondUserLastName;
    tasksSteps.addSecondUserToProject(secondUserFullName);
  }

  @Then("^I create the project '(.*)' with the manager '(.*)'$")
  public void addProjectWithManager(String projectName, String fullName) {
    tasksSteps.addProjectWithManager(projectName, fullName);

  }

  @Then("^I create the project '(.*)' with the first created user as manager$")
  public void addProjectWithFirstCreatedUserAsMangerAndParticipant(String projectName) {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");
    String firstUserFullName = firstUserFirstName + " " + firstUserLastName;
    tasksSteps.addProjectWithFirstCreatedUserAsManger(projectName, firstUserFullName);
  }

  @Then("^I add the project '(.*)' with the manager '(.*)' and the participant '(.*)'$")
  public void addProjectWithAManagerAndParticipant(String projectName, String manager, String participant) {
    tasksSteps.addProjectWithManagerAndParticipant(projectName, manager, participant);
  }

  @Then("^I add the random project with first user as the manager and second user as the participant$")
  public void addProjectWithFirstUserAsManagerAndSecondUserAsParticipant() {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    String firstUserLastName = Serenity.sessionVariableCalled("firstUserLastName");
    String firstUserFullName = firstUserFirstName + " " + firstUserLastName;
    String secondUserFirstName = Serenity.sessionVariableCalled("secondUserFirstName");
    String secondUserLastName = Serenity.sessionVariableCalled("secondUserLastName");
    String secondUserFullName = secondUserFirstName + " " + secondUserLastName;
    String randomProjectName = "randomProjectName" + getRandomNumber();
    Serenity.setSessionVariable("randomProjectName").to(randomProjectName);
    tasksSteps.addProjectWithManagerAndParticipant(randomProjectName, firstUserFullName, secondUserFullName);
  }

  @Then("^Space manager '(.*)' is displayed in Project Card$")
  @And("^Project manager '(.*)' is displayed in Project Card$")
  public void userFullNameIsDisplayedInProjectCard(String name) {
    tasksSteps.userFullNameIsDisplayedInProjectCard(name);
  }

  @Then("^User avatar '(.*)' is displayed in Project Card$")
  public void userAvatarIsDisplayedInProjectCard(String userName) {
    tasksSteps.userAvatarIsDisplayedInProjectCard(userName);
  }

  @Then("^The random created project with description '(.*)' is displayed in Project Card$")
  public void checkCreatedTasksProjectNameIsDisplayedInProjectCard(String projectDescription) {
    String randomProjectName = Serenity.sessionVariableCalled("randomProjectName");
    tasksSteps.checkProjectNameIsDisplayedInProjectCard(randomProjectName, projectDescription);
  }

  @Then("^Avatar of the first created user is displayed in Project Card$")
  public void randomUserAvatarIsDisplayedInProjectCard() {
    String firstUserName = Serenity.sessionVariableCalled("firstUserName");
    tasksSteps.userAvatarIsDisplayedInProjectCard(firstUserName);
  }

  @Then("^Avatar of the second created user is not displayed in Project Card$")
  public void secondRandomUserAvatarIsDisplayedInProjectCard() {
    String secondUserName = Serenity.sessionVariableCalled("secondUserName");
    tasksSteps.userAvatarIsNotDisplayedInProjectCard(secondUserName);
  }

  @Then("^User avatar '(.*)' is not displayed in Project Card$")
  public void userAvatarIsNotDisplayedInProjectCard(String userName) {
    tasksSteps.userAvatarIsNotDisplayedInProjectCard(userName);
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

  @And("^I return to Projects tab$")
  public void returnToProjectsTab() {
    tasksSteps.returnToProjectsTab();
  }

  @And("^I clone the project$")
  public void cloneProject() {
    String randomProjectName = Serenity.sessionVariableCalled("randomProjectName");
    tasksSteps.cloneProject(randomProjectName);
  }

  @And("^Clone project button is displayed$")
  public void cloneProjectButtonIsDisplayed() {
    tasksSteps.cloneProjectButtonIsDisplayed();
  }

  @And("^Color Palette is displayed$")
  public void colorPaletteIsDisplayed() {
    tasksSteps.colorPaletteIsDisplayed();
  }

  @And("^Edit project button is displayed$")
  public void editProjectButtonIsDisplayed() {
    tasksSteps.editProjectButtonIsDisplayed();
  }

  @And("^Delete project button is displayed$")
  public void deleteProjectButtonIsDisplayed() {
    tasksSteps.deleteProjectButtonIsDisplayed();
  }

  @Then("^project is cloned successfully$")
  public void checkProjectIsCloned() {
    String randomProjectName = "Copy of " + Serenity.sessionVariableCalled("randomProjectName");
    tasksSteps.checkClonedProject(randomProjectName);
  }

  @And("^I open the cloned project$")
  public void openClonedProject() {
    String randomProjectName = "Copy of " + Serenity.sessionVariableCalled("randomProjectName");
    tasksSteps.openProject(randomProjectName);
  }

  @Then("^task '(.*)' is cloned successfully$")
  public void checkTaskIsCloned(String taskName) {
    tasksSteps.checkClonedTask(taskName);
  }

  @And("^I open the added project$")
  public void openProject() {
    String projectName = Serenity.sessionVariableCalled("projectName");
    tasksSteps.openProject(projectName);
  }

  @And("^I click on three dots icon of the first status column$")
  public void clickOnThreeDotsIcon() {
    tasksSteps.clickOnThreeDotsIcon();
  }

  @And("^I click on Add Status Before option$")
  public void clickOnAddStatusBeforeOption() {
    tasksSteps.clickOnAddStatusBeforeOption();
  }

  @When("^I Type a Status name '(.*)'$")
  public void enterStatusText(String status) {
    tasksSteps.enterStatusText(status);
  }

  @And("^I click on Validate Name$")
  public void clickOnValidateStatusName() {
    tasksSteps.clickOnValidateStatusName();
  }

  @And("^I click on plus Button To Add Task$")
  public void ClickOnPlusButtonToAddTask() {
    tasksSteps.ClickOnPlusButtonToAddTask();
  }

  @When("^I enter tile for task '(.*)'$")
  public void enterTileForTask(String title) {
    tasksSteps.enterTileForTask(title);
  }

  @When("^I enter Description for this task '(.*)'$")
  public void setTaskDescription(String Description) {
    tasksSteps.setTaskDescription(Description);
  }

  @And("^I click on save Button To Add Task in space project$")
  public void clickOnSaveButtonToAddTaskSpaceProject() {
    tasksSteps.clickOnSaveButtonToAddTaskSpaceProject();
  }

  @When("^I update task Description '(.*)'$")
  public void updateTaskDescription(String Description) {
    tasksSteps.updateTaskDescription(Description);
  }

  @When("^I click on update button$")
  public void clickOnUpDateButton() {
    tasksSteps.clickOnUpDateButton();
  }

  @When("^I clone Task in space project$")
  public void clonetaskinspaceproject() {
    tasksSteps.clonetaskinspaceproject();
  }

  @When("^The update description '(.*)' is displayed in origin task$")
  @Then("^The update description '(.*)' is displayed in cloned task$")
  public void checkUpdatedDescription(String Description) {
    tasksSteps.checkUpdatedDescription(Description);
  }

  @And("^I click on save Button To Add Task$")
  public void ClickOnSaveButtonToAddTask() {
    tasksSteps.ClickOnSaveButtonToAddTask();
  }

  @When("^In column status '(.*)' , Task name '(.*)' is displayed$")
  public void taskNameIsDisplayedInDesiredColumn(String status, String taskName) {
    tasksSteps.taskNameIsDisplayedInDesiredColumn(status, taskName);
  }

  @And("^I click on three dots icon of the fifth status column$")
  public void clickOnThreeDotsIconOfFifthColumn() {
    tasksSteps.clickOnFifthColumnThreeDotsIcon();
  }

  @And("^I click on Add Status After option of the fifth status column$")
  public void clickOnAddStatusAfterOptionOfTheFifthStatusColumn() {
    tasksSteps.clickOnAddStatusAfterOptionOfTheFifthStatusColumn();
  }

  @And("^I click on plus Button To Add Task of the sixth status column$")
  public void ClickOnPlusButtonToAddTaskOfTheSixthStatusColumn() {
    tasksSteps.ClickOnPlusButtonToAddTaskOfTheSixthStatusColumn();
  }

  @And("^I click on Delete option$")
  public void clickOnDeleteStatusIcon() {
    tasksSteps.clickOnDeleteStatusIcon();
  }

  @And("^I confirm the deletion message$")
  public void confirmDeleteStatusColumn() {
    tasksSteps.confirmDeleteStatusColumn();
  }

  @Then("^Status '(.*)' is deleted successfully$")

  public void checkDeletedStatus(String statusColumn) {
    tasksSteps.checkDeletedStatus(statusColumn);
  }

  @And("^I check that Move Status column before option is not displayed$")
  public void MoveStatusBeforeIconIsNotDisplayed() {
    tasksSteps.checkMoveStatusBeforeIconIsNotDisplayed();
  }

  @And("^I click on Move Status column after option$")
  public void clickOnMoveStatusAfterIcon() {
    tasksSteps.clickOnMoveStatusAfterIcon();
  }

  @Then("^An alert message Status column is moved successfully is displayed$")
  public void checkAlertMessageMoveStatusAfter() {
    tasksSteps.checkAlertMessageMoveStatusAfter();
  }

  @And("^Status column '(.*)' is moved to the second position$")
  @Then("^Status column '(.*)' is displayed in the second position$")
  public void checkSecondStatusColumn(String columnStatus) {
    tasksSteps.checkSecondStatusColumn(columnStatus);
  }

  @And("^Status column '(.*)' is moved to the first position$")
  @Then("^Status column '(.*)' is displayed in the first position$")
  public void checkFirstStatusColumn(String columnStatus) {
    tasksSteps.checkFirstStatusColumn(columnStatus);
  }

  @And("^I click on three dots icon of the last status column$")
  public void clickOnThreeDotsIconOfLastColumn() {
    tasksSteps.clickOnLastColumnThreeDotsIcon();
  }

  @And("^I check that Move Status column after option is not displayed$")
  public void MoveStatusAfterIconIsNotDisplayed() {
    tasksSteps.checkMoveStatusAfterIconIsNotDisplayed();
  }

  @And("^I click on Move Status column before option$")
  public void clickOnMoveStatusBeforeIcon() {
    tasksSteps.clickOnMoveStatusBeforeIcon();
  }

  @And("^Status column '(.*)' is moved to the third position$")
  @Then("^Status column '(.*)' is displayed in the third position$")
  public void checkThirdStatusColumn(String columnStatus) {
    tasksSteps.checkThirdStatusColumn(columnStatus);
  }

  @And("^Status column '(.*)' is moved to the last position$")
  @Then("^Status column '(.*)' is displayed in the last position$")
  public void checkLastStatusColumn(String columnStatus) {
    tasksSteps.checkLastStatusColumn(columnStatus);
  }

  @And("^I open the Upload document drawer$")
  public void openUploadDocDrawer() {
    tasksSteps.openUploadDocDrawer();

  }

  @Then("^The success message '(.*)' should be displayed$")
  public void checkSuccessMessage(String message) {
    tasksSteps.checkSuccessMessage(message);
  }

  @When("^I close the Upload Document drawer$")
  public void closeUploadDocDrawer() {
    tasksSteps.closeUploadDocDrawer();
  }

  @Then("^The label View all attachments is displayed$")
  public void checkViewLinkAttachments() {
    tasksSteps.checkViewLinkAttachments();
  }

  @When("^I click on document button$")
  public void clickDocButton() {
    tasksSteps.clickDocButton();
  }

  @When("^I close the Upload Document drawer of snapshot$")
  public void closeUploadDocDrawerSnapshot() {
    tasksSteps.closeUploadDocDrawerSnapshot();
  }

  @And("^I mark the task as completed from the task card$")
  public void markTaskAsCompletedFromTaskCard() {
    tasksSteps.markTaskAsCompletedFromTaskCard();
  }

  @Then("^An alert message Task successfully marked as completed is displayed$")
  public void checkAlertMessageAfterMarkTaskAsCompleted() {
    tasksSteps.checkAlertMessageAfterMarkTaskAsCompleted();
  }

  @And("^A clear button is displayed in the search field$")
  public void clearButtonIsVisible() {
    tasksSteps.clearButtonIsVisible();
  }

  @When("^I click on clear button$")
  public void clickOnClearButton() {
    tasksSteps.clickOnClearButton();
  }

  @Then("^The typed project '(.*)' is removed from the Filter by project field$")
  public void checkTypedProjectIsRemoved(String typedProject) {
    tasksSteps.checkTypedProjectIsRemoved(typedProject);
  }

  @Then("^The placeholder Filter by project should be displayed$")
  public void checkDisplayOfFilterByProject() {
    tasksSteps.checkDisplayOfFilterByProject();
  }

  @And("^The clear button is disappeared from the Filter by project field$")
  public void clearButtonIsNotVisible() {
    tasksSteps.clearButtonIsNotVisible();
  }

  @And("^The task is created in the specific project$")
  public void addTaskInSimpleProject(Map<String, String> userDetails) {
    tasksSteps.addTaskInSimpleProject(userDetails);
  }

  @When("^I close the Upload Document drawer of task in simple project$")
  public void closeUploadDocDrawerSimpleProject() {
    tasksSteps.closeUploadDocDrawerSimpleProject();
  }

  @When("^I open the created task '(.*)'$")
  public void openTaskCreated(String taskName) {
    tasksSteps.openTaskCreated(taskName);
  }

  @And("^I click on plus icon from attachments list drawer$")
  public void clickPlusIcon() {
    tasksSteps.clickPlusIcon();
  }

  @And("^I click on View all attachments link$")
  public void clickViewAttachmentLink() {
    tasksSteps.clickViewAttachmentLink();
  }

  @And("^I click on plus icon from attachments list drawer in simple project$")
  public void clickPlusIconProject() {
    tasksSteps.clickPlusIconProject();
  }

  @And("^A clear button is displayed in the Filter by task field$")
  public void clearButtonInFilterByTaskIsVisible() {
    tasksSteps.clearButtonInFilterByTaskIsVisible();
  }

  @When("^I click on clear button in the Filter by task field$")
  public void clickOnClearButtonInFilterByTask() {
    tasksSteps.clickOnClearButtonInFilterByTask();
  }

  @Then("^The placeholder Filter by task should be displayed$")
  public void checkDisplayOfFilterByTask() {
    tasksSteps.checkDisplayOfFilterByTask();
  }

  @Then("^The typed task '(.*)' is removed from Filter by task field$")
  public void checkTypedTaskIsRemoved(String typedTask) {
    tasksSteps.checkTypedTaskIsRemoved(typedTask);
  }

  @And("^The clear button is disappeared from Filter by task field$")
  public void clearButtonInFilterByTaskIsNotVisible() {
    tasksSteps.clearButtonInFilterByTaskIsNotVisible();
  }

  @When("^I click on three dots task option$")
  public void clickOnTaskThreeDotsOption() {
    tasksSteps.clickOnTaskThreeDotsOption();
  }

  @Then("^Delete task option is displayed$")
  public void deleteTaskOptionIsDisplayed() {
    tasksSteps.deleteTaskOptionIsDisplayed();
  }

  @When("^I click on task delete option$")
  public void clickOnDeleteTaskoption() {
    tasksSteps.clickOnDeleteTaskOption();
  }

  @And("^I confirm deletion Task message$")
  public void confirmDeleteTask() {
    tasksSteps.confirmDeleteTask();
  }

  @Then("^Task '(.*)' is deleted successfully$")
  public void checkDeletedTask(String taskName) {
    tasksSteps.checkDeletedTask(taskName);
  }

  @When("^I go back to edit task drawer$")
  public void goBack() {
    tasksSteps.goBack();
  }

  @Then("^The label View all attachments is not displayed$")
  public void verifyViewLinkAttachments() {
    tasksSteps.verifyViewLinkAttachments();
  }

  @When("^I click to add new project$")
  public void clickAddProjectButton() {
    tasksSteps.clickAddProjectButton();
  }

  @And("^I click on save project button$")
  public void clickSaveProjectButton() {
    tasksSteps.clickSaveProjectButton();
  }

  @Then("^Message Project Title is mandatory is displayed$")
  public void checkMessageSaveEmptyProject() {
    tasksSteps.checkMessageSaveEmptyProject();
  }

  @And("^An alert message Task successfully deleted is displayed$")
  public void checkAlertMessageAfterDeleteTask() {
    tasksSteps.checkAlertMessageAfterDeleteTask();
  }

  @Then("^The drawer Select Folder should be displayed$")
  public void checkDrawerDisplay() {
    tasksSteps.checkDrawerDisplay();
  }

  @And("^I close the edit task drawer$")
  public void closeEditTaskDrawer() {
    tasksSteps.closeEditTaskDrawer();
  }

  @And("^I close the edit drawer of task in simple project$")
  public void closeEditTaskDrawerSimpleProject() {
    tasksSteps.closeEditTaskDrawerSimpleProject();
  }

  @And("^I assign task to me$")
  public void assignTaskToMe() {
    tasksSteps.assignTaskToMe();
  }

  @And("^I set task due date TODAY$")
  public void setTaskDueDateToday() {
    tasksSteps.setTaskDueDateToday();
  }

  @Then("^Tasks widget is displayed$")
  public void tasksWidgetIsDisplayed() {
    tasksSteps.checkTaskWidget();
  }

  @Then("^Task '(.*)' is displayed from tasks widget$")
  public void checkTaskFromWidget(String taskName) {
    tasksSteps.checkTaskFromWidget(taskName);
  }

  @When("^I open '(.*)' from widget$")
  public void openTaskFromWidget(String taskName) {
    tasksSteps.openTaskFromWidget(taskName);
  }

  @And("^I set task priority to '(.*)'$")
  public void selectTaskPriority(String taskPriority) {
    tasksSteps.setTaskPriority(taskPriority);
  }

  @And("^I set task status to '(.*)'$")
  public void setTaskStatus(String taskStatus) {
    tasksSteps.setTasksStatus(taskStatus);
  }

  @And("^I set task due date TOMORROW$")
  public void setTaskDueDateTomorrow() {
    tasksSteps.setTaskDueDateTomorrow();
  }

  @Then("^Task status '(.*)' is modified successfully$")
  public void checkTaskCardStatus(String taskStatus) {
    tasksSteps.checkTaskStatus(taskStatus);
  }

  @And("^Task priority '(.*)' is modified successfully$")
  public void checkTaskPriority(String taskPriority) {
    tasksSteps.checkTaskPriority(taskPriority);
  }

  @And("^I assign task to the first user$")
  public void assignTaskToTheFirstUser() {
    String firstUserFirstName = Serenity.sessionVariableCalled("firstUserFirstName");
    tasksSteps.assignTaskToUser(firstUserFirstName);
  }

  @When("^I search for the created project '(.*)'$")
  public void setInSearchProjectNameField(String project) {
    tasksSteps.setInSearchProjectField(project);
  }

  @When("^The project '(.*)' is displayed in project details$")
  public void projectNameIsDisplayedInProjectDetails(String projectName) {
    tasksSteps.projectNameIsDisplayedInProjectDetails(projectName);
  }

  @And("^I set task start date TODAY$")
  public void setTaskStartDateToday() {
    tasksSteps.setTaskStartDateToday();
  }

  @And("^I set task start date TOMORROW$")
  public void setTaskStartDateTomorrow() {
    tasksSteps.setTaskStartDateTomorrow();
  }

  @And("^I set task due date Next week$")
  public void setTaskDueDateNextWeek() {
    tasksSteps.setTaskDueDateNextWeek();
  }

  @And("^I go to the PLAN view$")
  public void goToPLanView() {
    tasksSteps.goToPLanView();
  }

  @Then("^The task name '(.*)' should be displayed in PLAN view$")
  public void taskNamePLanView(String taskName) {
    tasksSteps.taskNamePLanView(taskName);
  }

  @When("^I click on the notification that mentione first user in a task in Project '(.*)' project$")
  public void clickOnTheNotificationThatMentioneFirstUserInATaskInProject(String ProjectName) {
    String message = "You have been mentioned in a task in" + " " + ProjectName + " " + "project";
    tasksSteps.clickOnTheNotificationThatMentioneFirstUserInATaskInProject(message, ProjectName);
  }

  @And("^I click on Filter button$")
  public void clickOnFilterButton() {
    tasksSteps.clickFilterButton();
  }

  @And("^I click on Assignee radio button$")
  public void clickOnAssigneeRadioButton() {
    tasksSteps.clickOnAssigneeRadioButton();
  }

  @And("^I click on Confirm filter button$")
  public void clickOnConfirmButton() {
    tasksSteps.clickOnConfirmButton();
  }

  @Then("^I exit from project$")
  public void exitFromTheFirstProject() {
    tasksSteps.exitFromTheFirstProject();
  }

  @Then("^I check that grouping is not applied$")
  public void checkRadioButtonNotSelected() {
    tasksSteps.checkRadioButtonNotSelected();
  }

  @And("^I close Sort And Filter drawer$")
  public void closeSortAndFilterDrawer() {
    tasksSteps.closeSortAndFilterDrawer();
  }

  @Then("^I check that grouping is still applied$")
  public void checkRadioButtonSelected() {
    tasksSteps.checkRadioButtonSelected();
  }

  @And("^I clear browsing data cache and cookies$")
  public void deleteCookies() {
    tasksSteps.deleteCookies();
  }

  @Then("^I check that tasks are grouped by Assignee$")
  public void checkThatTasksAreGroupedByAssignee() {
    tasksSteps.checkThatTasksAreGroupedByAssignee();
  }

  @When("^I enter description for task '(.*)'$")
  public void enterDescriptionForTask(String description) {
    tasksSteps.enterDescriptionForTask(description);
  }

  @When("^The description in the task '(.*)' is displayed$")
  @And("^The edit description in the task '(.*)' is displayed$")
  public void checkDescriptionDisplay(String description) {
    tasksSteps.checkDescriptionDisplay(description);
  }

  @And("^I edit description of the task '(.*)'$")
  public void editDescriptionForTask(String newDescription) {
    tasksSteps.editDescriptionForTask(newDescription);
  }

  @Then("^I check that Edit task drawer is displayed$")
  public void checkThatEditTaskDrawerIsDisplayed() {
    tasksSteps.checkThatEditTaskDrawerIsDisplayed();
  }

  @And("^I check the timestamp update just below Task title Last Update$")
  public void checkTheTimestampUpdate() {
    tasksSteps.checkTheTimestampUpdate();
  }

  @When("^I hover on the Changes timestamp$")
  public void hoverOnTheChangesTimestamp() {
    tasksSteps.hoverOnTheChangesTimestamp();
  }

  @Then("^I check a tooltip is displayed Click to view all changes$")
  public void checkTooltipIsDisplayed() {
    tasksSteps.checkTooltipIsDisplayed();
  }

  @When("^I click on the timestamp$")
  public void clickOnTheTimestamp() {
    tasksSteps.clickOnTheTimestamp();
  }

  @Then("^I check that a new second level drawer Changes is opened$")
  public void checkThatSecondLevelDrawerChangesIsOpened() {
    tasksSteps.checkThatSecondLevelDrawerChangesIsOpened();
  }

  @And("^I switch to TASKS tab$")
  public void switchToTASKSTab() {
    tasksSteps.switchToTASKSTab();
  }

  @When("^I hover on project manager icon$")
  public void hoverOnProjectManagerIcon() {
    tasksSteps.hoverOnProjectManagerIcon();
  }

  @When("I wait '{int}' seconds")
  public void waitInSeconds(int seconds) throws InterruptedException {
    tasksSteps.waitInSeconds(seconds);
  }
}
