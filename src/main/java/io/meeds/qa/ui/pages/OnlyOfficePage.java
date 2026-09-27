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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;

public class OnlyOfficePage extends GenericPage {

  /**
   * Records the URLs the page asks to open in a new tab, by window.open or by a
   * target=_blank link, instead of opening them: loading the OnlyOffice editor
   * in the shared browser can leave chromedriver unresponsive until the grid
   * drops the session.
   */
  private static final String RECORD_NEW_TAB_URLS_SCRIPT = """
      if (!window.qaNewTabUrls) {
        window.qaNewTabUrls = [];
        window.open = function(url) {
          const entry = { url: String(url || '') };
          window.qaNewTabUrls.push(entry);
          const location = {
            get href() { return entry.url; },
            set href(value) { entry.url = String(value); },
            assign(value) { entry.url = String(value); },
            replace(value) { entry.url = String(value); },
          };
          return {
            closed: false,
            opener: null,
            focus() {},
            close() {},
            get location() { return location; },
            set location(value) { entry.url = String(value); },
            document: { write() {}, close() {} },
          };
        };
        document.addEventListener('click', function(event) {
          const link = event.target && event.target.closest && event.target.closest('a[target="_blank"]');
          if (link) {
            window.qaNewTabUrls.push({ url: link.href });
            event.preventDefault();
          }
        }, true);
      }
      """;

  private static final String ONLINE_EDITOR_URL_PART = "oeditor";

  private static final String VIEW_MODE_URL_PART     = "mode=view";

  public OnlyOfficePage(WebDriver driver) {
    super(driver);
  }

  public void attachFileToActivity(String fileName) {
    attachFileButtonElement().click();
    waitForDrawerToOpen(".attachmentsAppDrawer", true);
    waitFor(1).seconds();
    attachImageToFileInput(attachDrawerFileInputElement(), fileName);
    waitForLoading();
    // The upload can outlast the default wait of the confirmation message
    retryOnCondition(() -> checkConfirmMessageIsDisplayed("File list successfully updated"),
                     () -> waitFor(1).seconds(),
                     10);
    clickDrawerButton("Done");
  }

  public void openDocumentPreview(String fileName) {
    ElementFacade preview = documentPreviewElement(fileName);
    retryOnCondition(preview::checkVisible,
                     () -> waitFor(1).seconds(),
                     5);
    ((JavascriptExecutor) getDriver()).executeScript(RECORD_NEW_TAB_URLS_SCRIPT);
    preview.hover();
    preview.click();
    waitForLoading();
  }

  public void checkOnlineEditorRequested() {
    retryOnCondition(() -> assertTrue("The online editor wasn't requested for editing in a new tab, requested URLs: "
        + getRequestedNewTabUrls(), getRequestedNewTabUrls().stream().anyMatch(this::isEditorUrl)),
                     () -> waitFor(1).seconds(),
                     5);
  }

  /**
   * Opening the preview of an editable document opens the online editor in a
   * new tab; any other type is at most opened in the OnlyOffice viewer.
   */
  public void checkOnlineEditorNotRequested() {
    waitFor(3).seconds();
    List<String> requestedUrls = getRequestedNewTabUrls();
    assertFalse("The online editor was requested for editing in a new tab: " + requestedUrls,
                requestedUrls.stream().anyMatch(this::isEditorUrl));
  }

  private boolean isEditorUrl(String url) {
    return url.contains(ONLINE_EDITOR_URL_PART) && !url.contains(VIEW_MODE_URL_PART);
  }

  @SuppressWarnings("unchecked")
  private List<String> getRequestedNewTabUrls() {
    return (List<String>) ((JavascriptExecutor) getDriver()).executeScript("return (window.qaNewTabUrls || []).map(entry => entry.url);");
  }

  private ElementFacade attachFileButtonElement() {
    return findByXPathOrCSS("//*[@class='cke_button_icon cke_button__attachfile_icon']/parent::a");
  }

  private ElementFacade attachDrawerFileInputElement() {
    return findByXPathOrCSS("//*[contains(@class,'attachmentsAppDrawer')]//input[@type='file']");
  }

  private ElementFacade documentPreviewElement(String fileName) {
    return findByXPathOrCSS(String.format("//*[contains(@alt,'%s') or contains(text(),'%s')]//ancestor::*[contains(@id,'PreviewAttachment')]",
                                          fileName,
                                          fileName));
  }

}
