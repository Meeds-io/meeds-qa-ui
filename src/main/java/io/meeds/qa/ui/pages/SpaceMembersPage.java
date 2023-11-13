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

import io.meeds.qa.ui.elements.ElementFacade;

public class SpaceMembersPage extends GenericPage {

  public void checkPostDrawer() {
    waitCKEditorLoading();
    writeShortMessageDrawerElement().assertVisible();
  }

  public void clickOnThreeDotsMenu() {
    retryOnCondition(() -> {
      if (isMenuDisplayed()) {
        closeMenu();
      }
      retryOnCondition(() -> {
        threeDotsButton().click();
        waitMenuToDisplay();
      });
    });
  }

  public void setAsSpaceManager() {
    setAsManagerBtnElement().click();
    managerIcon().assertVisible();
  }

  public void setRedactor() {
    retryOnCondition(setAsRedactorBtnElement()::click, this::clickOnThreeDotsMenu);
  }

  private ElementFacade managerIcon() {
    return findByXPathOrCSS("//*[contains(@class, 'peopleInfoIcon')]//*[contains(@class, 'mdi-account-cog')]");
  }

  private ElementFacade setAsManagerBtnElement() {
    return findByXPathOrCSS("//*[contains(@class, 'uiIconMemberAdmin')]//ancestor::*[contains(@class, 'peopleActionItem')]");
  }

  private ElementFacade setAsRedactorBtnElement() {
    return findByXPathOrCSS("//*[contains(@class, 'uiIconEditMembership')]//ancestor::*[contains(@class, 'peopleActionItem')]");
  }

  private ElementFacade threeDotsButton() {
    return findByXPathOrCSS("//*[contains(@class, 'peopleCardItem')]//button[contains(@class, 'peopleMenuIcon')]");
  }

  private ElementFacade writeShortMessageDrawerElement() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'activityRichEditor')]");
  }

}
