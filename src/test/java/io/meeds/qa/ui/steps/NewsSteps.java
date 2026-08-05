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
package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.NewsPage;

public class NewsSteps {

  private NewsPage newsPage;

  public void checkWriteArticleLinkDisplayed() {
    newsPage.checkWriteArticleLinkDisplayed();
  }

  public void clickWriteArticle() {
    newsPage.clickWriteArticle();
  }

  public void checkArticleEditorOpened() {
    newsPage.checkArticleEditorOpened();
  }

  public void enterArticleTitleAndContent(String title, String content) {
    newsPage.enterArticleTitleAndContent(title, content);
  }

  public void checkArticleDraftSaved() {
    newsPage.checkArticleDraftSaved();
  }

  public void addArticle(String title, String content) {
    newsPage.addArticle(title, content);
  }

  public void closeArticleEditorTab() {
    newsPage.closeArticleEditorTab();
  }

  public void returnToFirstWindow() {
    newsPage.returnToFirstWindow();
  }

  public void checkArticleInStream(String title) {
    newsPage.checkArticleInStream(title);
  }

  public void clickArticleTitleInStream(String title) {
    newsPage.clickArticleTitleInStream(title);
  }

  public void checkArticleContentDisplayed(String title, String content) {
    newsPage.checkArticleContentDisplayed(title, content);
  }

  public void openEditArticleViaThreeDots() {
    newsPage.openEditArticleViaThreeDots();
  }

  public void checkModifyArticlePageDisplayed() {
    newsPage.checkModifyArticlePageDisplayed();
  }

  public void checkArticleUpdateButtonDisabled() {
    newsPage.checkArticleUpdateButtonDisabled();
  }

  public void modifyArticle(String title, String content) {
    newsPage.modifyArticle(title, content);
  }

  public void clickShareArticle() {
    newsPage.clickShareArticle();
  }

  public void chooseSpaceToShare(String spaceName) {
    newsPage.chooseSpaceToShare(spaceName);
  }

  public void checkShareButtonEnabled() {
    newsPage.checkShareButtonEnabled();
  }

  public void shareArticleWithSpaceAndDescription(String spaceName, String description) {
    newsPage.shareArticleWithSpaceAndDescription(spaceName, description);
  }

  public void checkShareAlertMessage(String message) {
    newsPage.checkShareAlertMessage(message);
  }

  public void goToNewsPage() {
    newsPage.goToNewsPage();
  }

  public void searchArticle(String title) {
    newsPage.searchArticle(title);
  }

  public void clearSearchArticle() {
    newsPage.clearSearchArticle();
  }

  public void filterNewsByType(String newsType) {
    newsPage.filterNewsByType(newsType);
  }

  public void checkSearchedArticleDisplayed(String title) {
    newsPage.checkSearchedArticleDisplayed(title);
  }

  public void checkNoArticleFound() {
    newsPage.checkNoArticleFound();
  }

}
