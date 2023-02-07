/*
 * This file is part of the Meeds project (https://meeds.io/).
 * Copyright (C) 2020 - 2023 Meeds Association contact@meeds.io
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

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriverException;

public class IOMeedsTraceException extends RuntimeException {

  private static final long serialVersionUID = 2090796822546017069L;

  private boolean           initialized;                            // NOSONAR

  public IOMeedsTraceException() {
  }

  public IOMeedsTraceException(WebDriverException e) {
    super(e);
  }

  public IOMeedsTraceException(String msg) {
    super(msg);
  }

  @Override
  public StackTraceElement[] getStackTrace() {
    initStackTrace();
    return super.getStackTrace();
  }

  @Override
  public void printStackTrace(PrintStream s) {
    initStackTrace();
    super.printStackTrace(s);
  }

  @Override
  public void printStackTrace(PrintWriter s) {
    initStackTrace();
    super.printStackTrace(s);
  }

  private void initStackTrace() {
    if (initialized) {
      return;
    }
    initialized = true;
    StackTraceElement[] stackTrace = getStackTrace();
    List<StackTraceElement> meedsStackTrace = Arrays.stream(stackTrace)
                                                    .filter(trace -> StringUtils.contains(trace.getClassName(), "io.meeds"))
                                                    .collect(Collectors.toList()); // NOSONAR used for JDK11
    setStackTrace(meedsStackTrace.toArray(new StackTraceElement[meedsStackTrace.size()]));
  }
}
