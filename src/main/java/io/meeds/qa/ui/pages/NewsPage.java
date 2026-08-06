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
import static io.meeds.qa.ui.utils.Utils.switchToTabByIndex;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class NewsPage extends GenericPage {

  private static final String WRITE_AN_ARTICLE_BUTTON_TEXT = "Write an Article";

  public NewsPage(WebDriver driver) {
    super(driver);
  }

  public void checkWriteArticleLinkDisplayed() {
    writeArticleLinkElement().assertVisible();
  }

  public void clickWriteArticle() {
    clickOnElement(writeArticleLinkElement());
    // The article editor opens in a new browser tab.
    switchToTabByIndex(getDriver(), 1);
    waitForLoading();
  }

  public void checkArticleEditorOpened() {
    articleTitleFieldElement().assertVisible();
    articlePublishButtonElement().assertVisible();
  }

  public void enterArticleTitleAndContent(String title, String content) {
    articleTitleFieldElement().setTextValue(title);
    ElementFacade frame = articleContentFrameElement();
    frame.waitUntilVisible();
    getDriver().switchTo().frame(frame);
    try {
      articleContentBodyElement().sendKeys(content);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  public void checkArticleDraftSaved() {
    articleDraftSavedElement().assertVisible();
  }

  // --- Publish (article editor is in tab 1; publishing needs the post-drawer
  // footer button, then we return to the space stream in tab 0). ---

  public void addArticle(String title, String content) {
    enterArticleTitleAndContent(title, content);
    publishArticle();
  }

  public void publishArticle() {
    ElementFacade articlePublishButtonElement = articlePublishButtonElement();
    articlePublishButtonElement.assertEnabled();
    articlePublishButtonElement.click();
    ElementFacade postDrawerButtonElement = postDrawerButtonElement();
    postDrawerButtonElement.assertEnabled();
    postDrawerButtonElement.click();
    closeArticleEditorTab();
    waitForLoading();
  }

  public void closeArticleEditorTab() {
    closeExtraWindows();
    refreshPage();
  }

  public void returnToFirstWindow() {
    switchToTabByIndex(getDriver(), 0);
    refreshPage();
    waitForLoading();
  }

  // --- Stream ---

  public void checkArticleInStream(String title) {
    articleTitleInStreamElement(title).assertVisible();
  }

  public void clickArticleTitleInStream(String title) {
    articleTitleInStreamElement(title).click();
    waitForLoading();
  }

  public void checkArticleContentDisplayed(String title, String content) {
    articleDetailsTitleElement(title).assertVisible();
    articleDetailsBodyElement(content).assertVisible();
  }

  // --- Edit via 3-dots ---

  public void openEditArticleViaThreeDots() {
    articleThreeDotsButtonElement().click();
    articleEditMenuItemElement().click();
    switchToTabByIndex(getDriver(), 1);
    waitForLoading();
  }

  public void checkModifyArticlePageDisplayed() {
    articleTitleFieldElement().assertVisible();
  }

  public void checkArticleUpdateButtonDisabled() {
    articlePublishButtonElement().assertDisabled();
  }

  public void modifyArticle(String title, String content) {
    articleTitleFieldElement().setTextValue(title);
    ElementFacade frame = articleContentFrameElement();
    getDriver().switchTo().frame(frame);
    try {
      articleContentBodyElement().setTextValue(content);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    ElementFacade articlePublishButtonElement = articlePublishButtonElement();
    articlePublishButtonElement.assertVisible();
    articlePublishButtonElement.assertEnabled();
    waitFor(200).milliseconds();
    articlePublishButtonElement.click();
    ElementFacade postDrawerButtonElement = postDrawerButtonElement();
    if (postDrawerButtonElement.isVisible()) {
      postDrawerButtonElement.click();
    }
  }

  // --- Share ---

  public void clickShareArticle() {
    articleShareButtonElement().click();
    waitForLoading();
  }

  public void chooseSpaceToShare(String spaceName) {
    mentionInField(shareSpaceInputElement(), spaceName, 3);
    shareSpaceSuggestionElement(spaceName).click();
  }

  public void checkShareButtonEnabled() {
    shareConfirmButtonElement().assertVisible();
  }

  public void shareArticleWithSpaceAndDescription(String spaceName, String description) {
    chooseSpaceToShare(spaceName);
    addDescription(description);
    shareConfirmButtonElement().click();
  }

  public void checkShareAlertMessage(String message) {
    checkConfirmMessageIsDisplayed(message);
  }

  // --- News page search ---

  public void goToNewsPage() {
    goToPage("/portal/dw/news");
  }

  public void searchArticle(String title) {
    newsSearchInputElement().setTextValue(title);
    waitForLoading();
  }

  public void clearSearchArticle() {
    newsSearchInputElement().clear();
    waitForLoading();
  }

  public void filterNewsByType(String newsType) {
    newsTypeSelectElement().selectByVisibleText(newsType);
    waitForLoading();
  }

  public void checkSearchedArticleDisplayed(String title) {
    newsListArticleElement(title).assertVisible();
  }

  public void checkNoArticleFound() {
    noArticleFoundElement().assertVisible();
  }

  private void addDescription(String description) {
    waitDrawerCKEditorLoading();
    ElementFacade ckEditorIFrameElement = ckEditorFrameElement();
    ckEditorIFrameElement.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorIFrameElement);
    try {
      TextBoxElementFacade fieldElement = ckEditorFieldElement();
      fieldElement.waitUntilVisible();
      fieldElement.setTextValue(description);
    } finally {
      getDriver().switchTo().defaultContent();
    }
  }

  private ElementFacade writeArticleLinkElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(text(),'%s')]".formatted(WRITE_AN_ARTICLE_BUTTON_TEXT));
  }

  private TextBoxElementFacade articleTitleFieldElement() {
    return findTextBoxByXPathOrCSS("//*[@id='notesTitle']");
  }

  private ElementFacade articlePublishButtonElement() {
    return findByXPathOrCSS("#notesUpdateAndPost");
  }

  private ElementFacade articleContentFrameElement() {
    return findByXPathOrCSS("//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private TextBoxElementFacade articleContentBodyElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'notesContent')]");
  }

  private ElementFacade articleDraftSavedElement() {
    return findByXPathOrCSS("//*[contains(@class,'draftSavingStatus') and contains(text(),'Draft saved')]");
  }

  private ElementFacade postDrawerButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//button[contains(@class,'primary')]");
  }

  private ElementFacade articleTitleInStreamElement(String title) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor::*[contains(@class,'activity-thumbnail-box')]",
                                          title));
  }

  private ElementFacade articleDetailsTitleElement(String title) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'newsDetails')]//p[contains(@class,'articleTitle')]//*[contains(text(),'%s')]",
                                          title));
  }

  private ElementFacade articleDetailsBodyElement(String content) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'newsDetails')]//div[contains(@class,'extended-rich-content')]//*[contains(text(),'%s')]",
                                          content));
  }

  private ElementFacade articleThreeDotsButtonElement() {
    return findByXPathOrCSS("//div[@id='newsDetails']//div[contains(@class,'newsDetailsTopBar')]//button[not(contains(@class,'go-back-button'))]");
  }

  private ElementFacade articleEditMenuItemElement() {
    return findByXPathOrCSS("//div[contains(@class,'newsActionMenuItems')]//*[normalize-space(text())='Edit']");
  }

  private ElementFacade articleShareButtonElement() {
    return findByXPathOrCSS("//*[contains(@id,'ShareActivity')]//i");
  }

  private TextBoxElementFacade shareSpaceInputElement() {
    return findTextBoxByXPathOrCSS("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(@class,'space-suggester')]//input[@type='text']");
  }

  private ElementFacade shareSpaceSuggestionElement(String spaceName) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'v-navigation-drawer--open')]//*[contains(@class,'identitySuggesterItem')]//*[contains(text(),'%s')]",
                                          spaceName));
  }

  private ElementFacade shareConfirmButtonElement() {
    return findByXPathOrCSS("//*[contains(@class,'drawerFooter')]//span[contains(text(),'Share')]");
  }

  private TextBoxElementFacade newsSearchInputElement() {
    return findTextBoxByXPathOrCSS("//input[@placeholder='Search in News']");
  }

  private ElementFacade newsTypeSelectElement() {
    return findByXPathOrCSS("//select[option[contains(text(),'Drafts')]]");
  }

  private ElementFacade newsListArticleElement(String title) {
    return findByXPathOrCSS(String.format("//*[@id='newsListItems']//*[contains(text(),'%s')]", title));
  }

  private ElementFacade noArticleFoundElement() {
    return findByXPathOrCSS("//*[contains(@class,'iconNotFound')]");
  }

  private ElementFacade ckEditorFrameElement() {
    return findByXPathOrCSS(".v-navigation-drawer--open iframe.cke_wysiwyg_frame");
  }

  private TextBoxElementFacade ckEditorFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable_themed')]");
  }

}
