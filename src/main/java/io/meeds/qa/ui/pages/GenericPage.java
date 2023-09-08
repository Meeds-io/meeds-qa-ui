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
import static io.meeds.qa.ui.utils.Utils.switchToTabByIndex;
import static io.meeds.qa.ui.utils.Utils.waitForLoading;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;

public class GenericPage extends BasePageImpl {

  public GenericPage() {
    this(null);
  }

  public GenericPage(WebDriver driver) {
    super(driver);
    url = "genericPage";
  }

  public void switchPageLanguage(String lang) {
    String currentUrl = getDriver().getCurrentUrl();
    retryOnCondition(() -> {
      getDriver().navigate().to(currentUrl.replaceAll("/portal/(.*)$", "/portal"));
      waitForLoading();
      getDriver().navigate().to(getDriver().getCurrentUrl().replace("/portal", "/portal/" + lang));
      waitForLoading();
      getDriver().navigate().to(currentUrl);
      waitForLoading();
      pageLangBodyElement(lang).assertVisible();
    });
  }

  public void checkConfirmMessageIsDisplayed(String message) {
    ElementFacade confirmMessageElement = getDisplayedConfirmMessage();
    confirmMessageElement.assertVisible();
    assertThat(confirmMessageElement.getText()).contains(message);
  }

  public void checkMessageIsDisplayed(String message) {
    messageElement(message).assertVisible();
  }

  public void checkMessageIsNotDisplayed(String message) {
    messageElement(message).assertNotVisible();
  }

  public void checkMessageIsDisplayedInPage(String message) {
    messageElementInPage(message).assertVisible();
  }

  public void checkMessageIsNotDisplayedInPage(String message) {
    messageElementInPage(message).assertNotVisible();
  }

  public void checkDrawerDisplayed(String title) {
    findByXPathOrCSS(String.format("//*[contains(text(),'%s')]//ancestor-or-self::*[contains(@class, 'drawerTitle')]", title)).assertVisible();
  }

  public void clickConfirm() {
    clickToConfirmDialog();
    waitFor(200).milliseconds(); // Wait for animation until the home icon
                                 // changes its location
  }

  public void closeBrowserTab(int index) {
    switchToTabByIndex(getDriver(), index);
    getDriver().close();
    if (index > 0) {
      switchToTabByIndex(getDriver(), index - 1);
    }
  }

  public boolean containsContent(String content) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]", content)).isVisible();
  }

  public boolean isButtonDisplayed(String buttonName) {
    return getButton(buttonName).isVisible();
  }

  public void isPageOpened(String uriPart) {
    assertTrue(getDriver().getCurrentUrl().contains(uriPart));
  }

  public void checkSuccessMessageDisplayed() {
    findByXPathOrCSS("//*[contains(@class, 'v-alert')]//*[contains(@class, 'success')]").assertVisible();
  }

  public void checkSwitchButtonNotDisplayed(String buttonName) {
    findByXPathOrCSS(String.format("//*[contains(@class, 'v-input--switch')]/parent::*//*[contains(text(), '%s')]",
                                   buttonName)).assertNotVisible();
  }

  public void checkSwitchButtonDisplayed(String buttonName) {
    findByXPathOrCSS(String.format("//*[contains(@class, 'v-input--switch')]/parent::*//*[contains(text(), '%s')]",
                                   buttonName)).assertVisible();
  }

  public void enableSwitchButtonDisplayed(String buttonName) {
    findByXPathOrCSS(String.format("//*[contains(text(), '%s')]/parent::*//*[contains(@class, 'v-input--switch')]",
                                   buttonName)).click();
    waitFor(200).milliseconds();
  }

  public void checkTranslationButtonIsPrimary(int index) {
    assertThat(translationButton(index).hasClass("primary--text"))
                                                                  .as("Translation button should be primary")
                                                                  .isTrue();
  }

  public void checkTranslationButtonIsNotPrimary(int index) {
    assertThat(translationButton(index).hasClass("primary--text"))
                                                                  .as("Translation button should not be primary")
                                                                  .isFalse();
  }

  public void openTranslationsDrawer(int index) {
    translationButton(index).assertVisible();
    translationButton(index).click();
  }

  public void addTranslationValues(String fieldType, Map<String, String> valuesByLanguage) {
    valuesByLanguage.forEach((lang, label) -> {
      addTranslationButton().click();
      lastTranslationLanguageSelect().selectByValue(lang);
      if (StringUtils.equals(fieldType, "text") || StringUtils.equals(fieldType, "field")
          || StringUtils.equals(fieldType, "input")) {
        lastTranslationLanguageInput().setTextValue(label);
      } else if (StringUtils.equals(fieldType, "rich editor")) {
        lastTranslationDropdownButton().click();
        waitCKEditorLoading("//*[@id = 'translationDrawer']");
        translationCKEditor();
        retryOnCondition(() -> {
          ElementFacade ckEditorFrameKudos = translationCKEditor();
          ckEditorFrameKudos.waitUntilVisible();
          getDriver().switchTo().frame(ckEditorFrameKudos);
        }, () -> {
          getDriver().switchTo().defaultContent();
          waitFor(500).milliseconds(); // Kudos Iframe seems very slow
        });
        try {
          TextBoxElementFacade kudosFieldElement = translationCKEditorElement();
          kudosFieldElement.waitUntilVisible();
          kudosFieldElement.setTextValue(label);
        } finally {
          getDriver().switchTo().defaultContent();
        }
        getDriver().switchTo().defaultContent();
      } else {
        throw new IllegalStateException("Translation Field Type " + fieldType + " is not recognized");
      }
    });
  }

  public void sortTableByField(String fieldText) {
    tableHeaderElement(fieldText).click();
  }

  private ElementFacade getDisplayedConfirmMessage() {
    return findByXPathOrCSS(".v-snack--active .v-alert__content");
  }

  private ElementFacade messageElement(String message) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]", message));
  }

  private ElementFacade messageElementInPage(String message) {
    return findByXPathOrCSS(String.format("//*[@id = 'UIPage']//*[contains(text(), '%s') and not (@role)]", message));
  }

  private ElementFacade translationButton(int index) {
    return findByXPathOrCSS(String.format("(//button//*[contains(@class, 'fa-language')])[%s]",
                                          index));
  }

  private ElementFacade addTranslationButton() {
    return findByXPathOrCSS("//*[@id = 'translationDrawer']//button//*[contains(@class, 'fa-plus')]");
  }

  private ElementFacade lastTranslationLanguageSelect() {
    return findByXPathOrCSS("(//*[@id = 'translationDrawer']//select)[last()]");
  }

  private TextBoxElementFacade lastTranslationLanguageInput() {
    return findTextBoxByXPathOrCSS("(//*[@id = 'translationDrawer']//input)[last()]");
  }

  private ElementFacade lastTranslationDropdownButton() {
    return findByXPathOrCSS("(//*[@id = 'translationDrawer']//*[contains(@class, 'fa-chevron-down')])[last()]");
  }

  private ElementFacade translationCKEditor() {
    return findByXPathOrCSS("//*[@id = 'translationDrawer']//iframe[contains(@class,'cke_wysiwyg_frame')]");
  }

  private TextBoxElementFacade translationCKEditorElement() {
    return findTextBoxByXPathOrCSS("//body[contains(@class,'cke_editable')]");
  }

  private ElementFacade tableHeaderElement(String fieldText) {
    return findByXPathOrCSS(String.format("//*[contains(text(), '%s')]//ancestor-or-self::th", fieldText));
  }

  private ElementFacade pageLangBodyElement(String lang) {
    return findByXPathOrCSS(String.format("//html[@lang='%s']//body", lang));
  }

}
