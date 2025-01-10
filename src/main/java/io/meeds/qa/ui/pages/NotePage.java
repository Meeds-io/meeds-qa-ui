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

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.utils.Utils;

import net.serenitybdd.core.Serenity;

public class NotePage extends GenericPage {

  public NotePage(WebDriver driver) {
    super(driver);
  }

  public void editNote() {
    retryOnCondition(() -> {
      editNoteButton().checkVisible();
      editNoteButton().click();
    }, Utils::refreshPage);
    String windowHandle = getDriver().getWindowHandle();
    Serenity.setSessionVariable("windowHandle").to(windowHandle);
    Set<String> windowHandles = getDriver().getWindowHandles();
    assertTrue(String.format("Can't find Notes editor Browser Tab: tabs length: %s", windowHandles.size()),
               windowHandles.stream()
                            .anyMatch(id -> {
                              getDriver().switchTo().window(id);
                              return editNoteButton().isNotVisible();
                            }));
    waitForLoading();
  }

  @SuppressWarnings("unchecked")
  public void checkNotesEditorDisplayedInFullPageWindow() {
    ElementFacade notesEditorElement = notesEditorElement();
    notesEditorElement.assertVisible();
    assertEquals(0, notesEditorElement.getLocation().getX());
    assertEquals(0, notesEditorElement.getLocation().getY());
    JavascriptExecutor driver = (JavascriptExecutor) getDriver();
    List<Long> windowDimensions = (List<Long>) driver.executeScript("return [window.innerWidth, window.innerHeight];");
    assertEquals(windowDimensions.get(0).intValue(), notesEditorElement.getRect().getWidth());
    assertEquals(windowDimensions.get(1).intValue(), notesEditorElement.getRect().getHeight());
  }

  public ElementFacade editNoteButton() {
    return findByXPathOrCSS("//*[contains(@class, 'notes-application-header')]//i[contains(@class, 'edit-note')]//ancestor::button");
  }

  public ElementFacade notesEditorElement() {
    return findByXPathOrCSS("#notesEditor");
  }

}
