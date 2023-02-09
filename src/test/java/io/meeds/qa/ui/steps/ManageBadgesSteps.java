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

import io.meeds.qa.ui.pages.ManageBadgesPage;

public class ManageBadgesSteps {

  private ManageBadgesPage manageBadgesPage;

  public void addBadge(String name, String description, String score, String icon, String domain) {
    manageBadgesPage.clickOnAddBadge();
    manageBadgesPage.fillForm(name, description, score, icon, domain);

  }

  public void clickOnDeleteBadge(String badgeName) {
    manageBadgesPage.clickOnDeleteBadge(badgeName);

  }

  public void clickOnEditBadge(String badgeName) {
    manageBadgesPage.clickOnEditBadge(badgeName);

  }

  public void confirmAdditionNewBadge() {
    manageBadgesPage.confirmAdditionNewBadge();

  }

  public void confirmDeletionBadge() {
    manageBadgesPage.confirmDeletionBadge();

  }

  public void confirmEditBadge() {
    manageBadgesPage.confirmEditBadge();

  }

  public void editBadgeDescription(String description) {
    manageBadgesPage.editBadgeDescription(description);

  }

  public void editBadgeDomain(String domain) {
    manageBadgesPage.editBadgeDomain(domain);

  }

  public void editBadgeName(String name) {
    manageBadgesPage.editBadgeName(name);

  }

  public void editBadgeScore(String score) {
    manageBadgesPage.editBadgeScore(score);

  }

  public void goToManageBadgesMenu() {
    manageBadgesPage.goToManageBadgesMenu();

  }

  public void insertBadgeNameInSearchField(String badgeName) {
    manageBadgesPage.insertBadgeNameInSearchField(badgeName);

  }

  public void isBadgeDisplayedWithEnabledStatus(String badgeName,
                                                String badgeDescription,
                                                String badgeScore,
                                                String badgeDomain) {
    manageBadgesPage.isBadgeDisplayedWithEnabledStatus(badgeName, badgeDescription, badgeScore, badgeDomain);

  }

  public void isBadgeNotDisplayedWithEnabledStatus(String badgeName,
                                                   String badgeDescription,
                                                   String badgeScore,
                                                   String badgeDomain) {
    manageBadgesPage.isBadgeNotDisplayedWithEnabledStatus(badgeName, badgeDescription, badgeScore, badgeDomain);

  }

  public void isSuccessAlertDisplayed(String message) {
    manageBadgesPage.isSuccessAlertDisplayed(message);

  }

}
