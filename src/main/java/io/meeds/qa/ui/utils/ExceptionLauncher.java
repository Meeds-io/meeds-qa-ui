package io.meeds.qa.ui.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class ExceptionLauncher {
  public static final Logger LOGGER = LoggerFactory.getLogger(ExceptionLauncher.class);

  private ExceptionLauncher() {
    // Utils class
  }

  public static final void throwSerenityExeption(Exception e, String errorMsg) {
    throw new SerenityManagedException(errorMsg, e);
  }
}
