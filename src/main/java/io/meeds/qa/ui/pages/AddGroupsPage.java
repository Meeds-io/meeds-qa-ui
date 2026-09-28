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

import static io.meeds.qa.ui.utils.Utils.*;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class AddGroupsPage extends GenericPage {

  private String selectedGroup;

  public AddGroupsPage(WebDriver driver) {
    super(driver);
  }

  public void addMemberInGroup(String role, String member) {
    retryOnCondition(() -> addMember(role, member));
  }

  public void addMember(String role, String member) {
    closeAllDrawers();
    // A member is added from the menu of the group row
    groupMenuButton(selectedGroup).click();
    // The menu items can't be clicked until the menu has finished opening
    retryOnCondition(() -> groupMenuItem("Add member").click(), () -> waitFor(500).milliseconds(), 5);
    ElementFacade selectedRoleFieldElement = selectedRoleFieldElement();
    selectedRoleFieldElement.checkVisible();
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
    return findByXPathOrCSS(String.format("%s/ancestor::*[contains(concat(' ', normalize-space(@class), ' '), ' v-list-item ')][1]//i[contains(@class,'fa-caret-right')]/ancestor::button[1]",
                                          groupTitleXPath(group)));
  }

  public ElementFacade groupToSelect(String group) {
    return findByXPathOrCSS(groupTitleXPath(group));
  }

  private String groupTitleXPath(String group) {
    return String.format("//*[@id='GroupsManagement']//*[contains(@class,'v-list-item__title') and contains(text(),'%s')]", group);
  }

  public void openGroup(String group) {
    groupOpenBtn(group).click();
  }

  public void selectGroup(String group) {
    groupToSelect(group).click();
    selectedGroup = group;
  }

  private ElementFacade groupMenuButton(String group) {
    return findByXPathOrCSS(String.format("%s/ancestor::*[contains(concat(' ', normalize-space(@class), ' '), ' v-list-item ')][1]//i[contains(@class,'fa-ellipsis-v')]/ancestor::button[1]",
                                          groupTitleXPath(group)));
  }

  private ElementFacade groupMenuItem(String label) {
    return findByXPathOrCSS(String.format("//*[contains(@class,'menuable__content__active')]//*[contains(@class,'v-list-item') and normalize-space(.)='%s']",
                                          label));
  }

  private TextBoxElementFacade inviteMemberInputElement() {
    return findTextBoxByXPathOrCSS("//input[@id='membershipUserNameInput']");
  }

  private ElementFacade saveMemberAddedInGroupElement() {
    return findByXPathOrCSS("//*[@id='membershipFormDrawer' and contains(@class, 'v-navigation-drawer--open')]//button[contains(@class,'btn-primary')]");
  }

  private ElementFacade selectedRoleFieldElement() {
    return findByXPathOrCSS("//*[contains(@class,'membershipNameField')]//select");
  }

}
