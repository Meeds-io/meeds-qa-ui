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
package io.meeds.qa.ui.elements;

import static io.meeds.qa.ui.utils.Utils.retryOnCondition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.meeds.qa.ui.utils.ExceptionLauncher;
import net.serenitybdd.core.pages.WebElementFacade;

public class TextElementFacadeImpl extends ElementFacadeImpl implements TextElementFacade {

  static final Logger LOGGER = LoggerFactory.getLogger(TextElementFacadeImpl.class);

  public static TextElementFacadeImpl wrapWebElementFacadeInTextElement(final WebDriver driver,
                                                                        final WebElementFacade element,
                                                                        final ElementLocator locator,
                                                                        final String xPathOrCSSSelector,
                                                                        final long implicitTimeoutInMilliseconds,
                                                                        final long waitForTimeoutInMilliseconds) {
    return new TextElementFacadeImpl(driver,
                                     locator,
                                     xPathOrCSSSelector,
                                     element,
                                     implicitTimeoutInMilliseconds,
                                     waitForTimeoutInMilliseconds);
  }

  public TextElementFacadeImpl(WebDriver driver,
                               ElementLocator locator,
                               String xPathOrCSSSelector,
                               WebElement element,
                               long timeoutInMilliseconds,
                               long waitForTimeoutInMilliseconds) {
    super(driver, locator, xPathOrCSSSelector, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }

  public TextElementFacadeImpl(WebDriver driver,
                               ElementLocator locator,
                               WebElement element,
                               long timeoutInMilliseconds,
                               long waitForTimeoutInMilliseconds) {
    super(driver, locator, null, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }

  @Override
  public String getContent() {
    String textValue = null;
    try {
      waitUntilVisible();
      textValue = getText();
    } catch (Exception e) {
      ExceptionLauncher.throwSerenityExeption(e,
                                              String.format("Text can't be extracted from The element [%s]", this));
    }
    return textValue;

  }

  @Override
  public void sendKeys(CharSequence... value) {
    sendValueWithKeys(false, null, value);
  }

  public void sendValueWithKeys(boolean clear, Keys keys, CharSequence... value) {
    retryOnCondition(() -> {
      WebElement element = getElement();
      sendValueWithKeysOnElement(element, clear, keys, value);
    });
  }

  public void sendValueWithKeysOnElement(WebElement element, boolean clear, Keys keys, CharSequence... value) {
    if (clear) {
      element.clear();
    }
    element.sendKeys(value);
    if (keys != null) {
      element.sendKeys(keys);
    }
  }

  public void setTextValue(String value) {
    setTextValue(value, null);
  }

  public void setTextValue(String value, Keys keys) {
    try {
      sendValueWithKeys(true, keys, value);
    } catch (WebDriverException | IllegalArgumentException e) {
      ExceptionLauncher.throwSerenityExeption(e,
                                              String.format(
                                                            "The element [%s] is not visible. "
                                                                + "The new value [%s] cannot be entered.",
                                                            this,
                                                            value));
    }
  }

}
