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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.WebElementFacade;

public class ButtonElementFacadeImpl extends ElementFacadeImpl implements ButtonElementFacade {

  static final Logger LOGGER = LoggerFactory.getLogger(ButtonElementFacadeImpl.class);

  @SuppressWarnings("unchecked")
  public static <T extends ButtonElementFacade> T wrapWebElementFacadeInButtonElement(final WebDriver driver,
                                                                                      final WebElementFacade element,
                                                                                      final ElementLocator locator,
                                                                                      final String xPathOrCSSSelector,
                                                                                      final long implicitTimeoutInMilliseconds,
                                                                                      final long waitForTimeoutInMilliseconds) {
    return (T) new ButtonElementFacadeImpl(driver,
                                           locator,
                                           xPathOrCSSSelector,
                                           element,
                                           implicitTimeoutInMilliseconds,
                                           waitForTimeoutInMilliseconds);
  }

  public ButtonElementFacadeImpl(WebDriver driver,
                                 ElementLocator locator,
                                 String xPathOrCSSSelector,
                                 WebElement element,
                                 long timeoutInMilliseconds,
                                 long waitForTimeoutInMilliseconds) {
    super(driver, locator, xPathOrCSSSelector, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }

  public ButtonElementFacadeImpl(WebDriver driver,
                                 ElementLocator locator,
                                 WebElement element,
                                 long timeoutInMilliseconds,
                                 long waitForTimeoutInMilliseconds) {
    super(driver, locator, null, element, timeoutInMilliseconds, waitForTimeoutInMilliseconds);
  }
}
