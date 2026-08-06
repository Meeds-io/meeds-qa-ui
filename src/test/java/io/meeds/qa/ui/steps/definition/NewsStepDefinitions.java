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

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;

import io.meeds.qa.ui.steps.NewsSteps;
import net.thucydides.core.annotations.Steps;

public class NewsStepDefinitions {

  private static final String RANDOM_SPACE_NAME = "RandomSpaceName";

  @Steps
  private NewsSteps newsSteps;

  @Then("^The write an article link is displayed in the composer$")
  public void checkWriteArticleLinkDisplayed() {
    newsSteps.checkWriteArticleLinkDisplayed();
  }

  @When("^I click on write an article$")
  public void clickWriteArticle() {
    newsSteps.clickWriteArticle();
  }

  @Then("^The article editor is opened$")
  public void checkArticleEditorOpened() {
    newsSteps.checkArticleEditorOpened();
  }

  @When("^I enter the article title '(.*)' and content '(.*)'$")
  public void enterArticleTitleAndContent(String title, String content) {
    newsSteps.enterArticleTitleAndContent(title, content);
  }

  @Then("^The article draft is saved$")
  public void checkArticleDraftSaved() {
    newsSteps.checkArticleDraftSaved();
  }

  @When("^I add an article titled '(.*)' with content '(.*)'$")
  public void addArticle(String title, String content) {
    newsSteps.addArticle(title, content);
  }

  @When("^I close the article editor tab$")
  public void closeArticleEditorTab() {
    newsSteps.closeArticleEditorTab();
  }

  @When("^I return to the first window$")
  public void returnToFirstWindow() {
    newsSteps.returnToFirstWindow();
  }

  @Then("^The article '(.*)' is displayed in the space activity stream$")
  public void checkArticleInStream(String title) {
    newsSteps.checkArticleInStream(title);
  }

  @When("^I click on the article title '(.*)' in the activity stream$")
  public void clickArticleTitleInStream(String title) {
    newsSteps.clickArticleTitleInStream(title);
  }

  @Then("^The article '(.*)' is displayed with the content '(.*)'$")
  public void checkArticleContentDisplayed(String title, String content) {
    newsSteps.checkArticleContentDisplayed(title, content);
  }

  @When("^I open the edit article form via the three dots menu$")
  public void openEditArticleViaThreeDots() {
    newsSteps.openEditArticleViaThreeDots();
  }

  @Then("^The modify article page is displayed$")
  public void checkModifyArticlePageDisplayed() {
    newsSteps.checkModifyArticlePageDisplayed();
  }

  @Then("^The article update button is disabled$")
  public void checkArticleUpdateButtonDisabled() {
    newsSteps.checkArticleUpdateButtonDisabled();
  }

  @When("^I modify the article title '(.*)' with content '(.*)'$")
  public void modifyArticle(String title, String content) {
    newsSteps.modifyArticle(title, content);
  }

  @When("^I click on share article$")
  public void clickShareArticle() {
    newsSteps.clickShareArticle();
  }

  @When("^I choose the '(.*)' space to share the article$")
  public void chooseSpaceToShare(String spacePrefix) {
    String randomSpaceName = sessionVariableCalled(spacePrefix + RANDOM_SPACE_NAME);
    newsSteps.chooseSpaceToShare(randomSpaceName);
  }

  @Then("^The share button is enabled$")
  public void checkShareButtonEnabled() {
    newsSteps.checkShareButtonEnabled();
  }

  @When("^I share the article with the '(.*)' space and the description '(.*)'$")
  public void shareArticleWithSpaceAndDescription(String spacePrefix, String description) {
    String randomSpaceName = sessionVariableCalled(spacePrefix + RANDOM_SPACE_NAME);
    newsSteps.shareArticleWithSpaceAndDescription(randomSpaceName, description);
  }

  @Then("^The share confirmation message '(.*)' is displayed$")
  public void checkShareAlertMessage(String message) {
    newsSteps.checkShareAlertMessage(message);
  }

  @When("^I go to the news page$")
  public void goToNewsPage() {
    newsSteps.goToNewsPage();
  }

  @When("^I search for the article '(.*)'$")
  public void searchArticle(String title) {
    newsSteps.searchArticle(title);
  }

  @When("^I clear the article search input$")
  public void clearSearchArticle() {
    newsSteps.clearSearchArticle();
  }

  @When("^I filter news by '(.*)'$")
  public void filterNewsByType(String newsType) {
    newsSteps.filterNewsByType(newsType);
  }

  @Then("^The searched article '(.*)' is displayed$")
  public void checkSearchedArticleDisplayed(String title) {
    newsSteps.checkSearchedArticleDisplayed(title);
  }

  @Then("^No article is found$")
  public void checkNoArticleFound() {
    newsSteps.checkNoArticleFound();
  }

}
