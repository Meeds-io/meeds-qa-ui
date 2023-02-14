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

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class AddGroupsPage extends GenericPage {
  public AddGroupsPage(WebDriver driver) {
    super(driver);
  }

  public void addMemberInGroup(String role, String member) {
    ElementFacade addMemberInGroupBtnElement = addMemberInGroupBtnElement();
    if (!addMemberInGroupBtnElement.isClickable() || !addMemberInGroupBtnElement.isVisible()) {
      refreshPage();
    }
    closeAllDrawers();
    addMemberInGroupBtnElement.click();
    ElementFacade selectedRoleFieldElement = selectedRoleFieldElement();
    selectedRoleFieldElement.selectByValue(role);
    selectedRoleFieldElement.click();
    TextBoxElementFacade inviteMemberInputElement = inviteMemberInputElement();
    inviteMemberInputElement.setTextValue(member);
    boolean found = mentionInField(inviteMemberInputElement, member, 3);
    if (found) {
      ElementFacade saveMemberAddedInGroupElement = saveMemberAddedInGroupElement();
      try {
        saveMemberAddedInGroupElement.click();
      } catch (Exception e) {
        findByXPathOrCSS("//*[contains(@class,'drawerTitle')]").click();
        saveMemberAddedInGroupElement.click();
      }
    }
    closeAllDrawers();
    waitForDrawerToClose();
  }

  public ElementFacade groupOpenBtn(String group) {
    return findByXPathOrCSS(String
                                  .format("//*[@class='flex sm12 md4 flat']//*[@class='v-list-item__content']//*[contains(text(),'%s')]/preceding::i[@class='v-icon notranslate mdi mdi-menu-right theme--light'][1]",
                                          group));
  }

  public ElementFacade groupToSelect(String group) {
    return findByXPathOrCSS(String
                                  .format("//*[@class='flex sm12 md4 flat']//*[@class='v-list-item__content']//*[contains(text(),'%s')]",
                                          group));
  }

  public void openGroup(String group) {
    groupOpenBtn(group).click();
  }

  public void selectGroup(String group) {
    groupToSelect(group).click();
  }

  private ElementFacade addMemberInGroupBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'addNewMembershipButton')]");
  }

  private TextBoxElementFacade inviteMemberInputElement() {
    return findTextBoxByXPathOrCSS("//input[@id='userNameInput']");
  }

  private ElementFacade saveMemberAddedInGroupElement() {
    return findByXPathOrCSS("//*[@id='membershipFormDrawer' and contains(@class, 'v-navigation-drawer--open')]//button[contains(@class,'btn-primary')]");
  }

  private ElementFacade selectedRoleFieldElement() {
    return findByXPathOrCSS("//*[contains(@class,'membershipNameField')]//select");
  }

}
