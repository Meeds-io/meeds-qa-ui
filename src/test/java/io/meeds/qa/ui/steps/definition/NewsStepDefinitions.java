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
import io.meeds.qa.ui.steps.NewsSteps;
import net.thucydides.core.annotations.Steps;

public class NewsStepDefinitions {

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

}
