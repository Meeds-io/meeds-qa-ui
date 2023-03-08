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
import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ButtonElementFacade;
import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class KudosPage extends GenericPage {

  private static final String ACTIVITY_KUDOS_DRAWER_SELECTOR =
                                                             "//*[@id='activityKudosDrawer' and contains(@class, 'v-navigation-drawer--open')]";

  public KudosPage(WebDriver driver) {
    super(driver);
  }

  public void addActivityKudosToSomeoneDifferent(String activity, String message, String user) {
    getKudosLink(activity).click();
    deleteUserFromKudosButtonElement().click();
    mentionInField(userKudosInputElement(), user, 5);
    sendKudosMessageFromOpenedDrawer(message);
  }

  public void addActivityKudos(String activity, String comment) {
    getKudosLink(activity).click();
    sendKudosMessageFromOpenedDrawer(comment);
  }

  public void checkKudosActivityVisible(String message) {
    getKudosActivityText(message).assertVisible();
  }

  public void checkKudosIconDisabled(String activityId) {
    getKudosLink(activityId).assertDisabled();
  }

  public void checkKudosSettings(String kudosNbr, String period) {

    assertTrue(kudosNumberElement().getTextValue().contains(kudosNbr));
    assertTrue(displayedPeriodTypeElement().getTextValue().contains(period));
  }

  public void clickEditKudos() {
    threedotsKudosCommentElement().click();
    editKudosCommentElement().click();
  }

  public void clickEditKudosFromReply() {
    threedotsKudosReplyCommentElement().click();
    editKudosCommentElement().click();
  }

  public void editKudos() {
    dotsMenuElement().click();
    editButtonElement().click();
  }

  public void cancelKudosActivity(String activity) {
    getCancelKudosActivityIcon(activity).click();
  }

  public void cancelKudosComment(String comment) {
    getCancelKudosCommentIcon(comment).click();
  }

  public void enterKudosNumber(String val) {
    TextBoxElementFacade kudosNumberElement = kudosNumberElement();
    kudosNumberElement.click();
    kudosNumberElement.clear();
    kudosNumberElement.setTextValue(val);
  }

  public void goToKudosMenu() {
    menuBtnElement().click();
    administrationIconElement().hover();
    addministrationMenuElement().click();
    kudosLinkElement().click();
  }

  public void saveChange() {
    saveBtnElement().click();
  }

  public void searchForUsersByName(String fullName) {
    searchUsersFieldElement().setTextValue(fullName);
  }

  public void selectType() {
    periodTypeElement().click();
    semesterPeriodElement().click();
  }

  public void sendKudosMessageFromOpenedDrawer(String kudosMessage) {
    waitForDrawerToOpen("#activityKudosDrawer", false);
    waitCKEditorLoading(ACTIVITY_KUDOS_DRAWER_SELECTOR);
    retryOnCondition(() -> {
      ElementFacade ckEditorFrameKudos = getCkEditorFrameKudos();
      ckEditorFrameKudos.waitUntilVisible();
      getDriver().switchTo().frame(ckEditorFrameKudos);
    }, () -> {
      getDriver().switchTo().defaultContent();
      waitFor(500).milliseconds(); // Kudos Iframe seems very slow
    });
    try {
      TextBoxElementFacade kudosFieldElement = kudosFieldElement();
      kudosFieldElement.waitUntilVisible();
      kudosFieldElement.setTextValue(kudosMessage);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    getDriver().switchTo().defaultContent();
    ElementFacade kudosButtonInDrawerElement = kudosButtonInDrawerElement();
    kudosButtonInDrawerElement.assertVisible();
    kudosButtonInDrawerElement.click();
    kudosButtonInDrawerElement.waitUntilNotVisible();
    refreshPage();
  }

  public void threeDotsMenuSendKudos() {
    ElementFacade sendKudosMenuElement = sendKudosMenuElement();
    sendKudosMenuElement.assertVisible();
    sendKudosMenuElement.click();
  }

  private ElementFacade addministrationMenuElement() {
    return findByXPathOrCSS("//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'fa fa-arrow')]");
  }

  private ElementFacade administrationIconElement() {
    return findByXPathOrCSS("//*[@id='AdministrationHamburgerNavigation']//*[contains(@class,'titleIcon')]");
  }

  private TextBoxElementFacade userKudosInputElement() {
    return findTextBoxByXPathOrCSS(".v-navigation-drawer--open .user-suggester input");
  }

  private ButtonElementFacade deleteUserFromKudosButtonElement() {
    return findButtonByXPathOrCSS(".v-navigation-drawer--open .user-suggester button");
  }

  private ElementFacade displayedPeriodTypeElement() {
    return findByXPathOrCSS("(//*[@class='v-select__selections'])[1]");
  }

  private TextBoxElementFacade dotsMenuElement() {
    return findTextBoxByXPathOrCSS("(//i[@class='v-icon notranslate icon-default-color fas fa-ellipsis-v theme--light'])[1]");
  }

  private ElementFacade editButtonElement() {
    return findByXPathOrCSS("//i[@class='v-icon notranslate dark-grey-color fa fa-edit theme--light']");
  }

  private ElementFacade editKudosCommentElement() {
    return findByXPathOrCSS("//*[@class='v-list-item__title pl-3' and contains(text(),'Edit')]");
  }

  private ElementFacade getCkEditorFrameKudos() {
    return findByXPathOrCSS(ACTIVITY_KUDOS_DRAWER_SELECTOR + "//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private ElementFacade getKudosActivityText(String message) {
    return findByXPathOrCSS(String.format("//div[contains(@class,'activity-detail')]//descendant::*[contains(text(),'%s')]",
                                          message));
  }

  private ElementFacade getKudosLink(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'activity-detail')]//child::button[contains(@id, 'KudosActivity')]",
                                          activity));
  }

  private ElementFacade kudosButtonInDrawerElement() {
    return findByXPathOrCSS("//*[@id = 'activityKudosDrawer']//*[contains(@class, 'drawerFooter')]//button[contains(@class, 'btn-primary')]");
  }

  private TextBoxElementFacade kudosFieldElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable')]");
  }

  private ElementFacade kudosLinkElement() {
    return findByXPathOrCSS("//a[@href='/portal/g/:platform:rewarding/rewardAdministration/kudosAdministration']");
  }

  private TextBoxElementFacade kudosNumberElement() {
    return findTextBoxByXPathOrCSS("//input[@name='kudosPerPeriod']");
  }

  private ElementFacade menuBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'HamburgerNavigationMenuLink')]");
  }

  private ElementFacade periodTypeElement() {
    return findByXPathOrCSS("//i[@class='v-icon notranslate mdi mdi-menu-down theme--light']");
  }

  private ElementFacade saveBtnElement() {
    return findByXPathOrCSS("//button[@class='btn btn-primary ignore-vuetify-classes mb-3']");
  }

  private TextBoxElementFacade searchUsersFieldElement() {
    return findTextBoxByXPathOrCSS("//header[@id='peopleListToolbar']//input");
  }

  private ElementFacade semesterPeriodElement() {
    return findByXPathOrCSS("//*[contains(text(),'Semester')]");
  }

  private ElementFacade sendKudosMenuElement() {
    return findByXPathOrCSS("//*[contains(@class, 'fa-award')]//ancestor::*[contains(@class, 'peopleActionItem')]");
  }

  private ElementFacade threedotsKudosCommentElement() {
    return findByXPathOrCSS("(//*[@class='flex-grow-1 flex-shrink-1 overflow-hidden']//*[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[2]");
  }

  private ElementFacade threedotsKudosReplyCommentElement() {
    return findByXPathOrCSS("(//*[@class='flex-grow-1 flex-shrink-1 overflow-hidden']//*[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[3]");
  }

  private ElementFacade getCancelKudosActivityIcon(String activity) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@id, 'activity-detail')]//*[contains(@class, 'menuable__content__active')]//*[contains(@class, 'undo')]",
            activity));
  }

  private ElementFacade getCancelKudosCommentIcon(String comment) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor::*[contains(@id, 'ActivityComm')]//*[contains(@class, 'menuable__content__active')]//*[contains(@class, 'undo')]",
            comment));
  }

}
