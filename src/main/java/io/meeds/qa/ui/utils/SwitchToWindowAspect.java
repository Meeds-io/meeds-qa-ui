/**
 * This file is part of the Meeds project (https://meeds.io/).
 * Copyright (C) 2022 Meeds Association
 * contact@meeds.io
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
package io.meeds.qa.ui.utils;

import static io.meeds.qa.ui.utils.Utils.releaseCurrentWindow;
import static io.meeds.qa.ui.utils.Utils.switchToCurrentWindow;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.openqa.selenium.WebDriver;

@Aspect
public class SwitchToWindowAspect {

  @Around("execution(* *(..)) && @annotation(io.meeds.qa.ui.utils.SwitchToWindow)")
  public Object around(ProceedingJoinPoint point) throws Throwable {
    Object object = point.getThis();
    WebDriver driver = getDriver(object);
    String reason = object.getClass().getSimpleName() + "." + point.getSignature().getName();
    switchToCurrentWindow(driver, object, reason);
    try {
      return point.proceed();
    } finally {
      releaseCurrentWindow(driver, object, reason);
    }
  }

  private WebDriver getDriver(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    Method driverMethod = object.getClass().getMethod("getDriver");
    WebDriver driver = (WebDriver) driverMethod.invoke(object);
    return driver;
  }

}
