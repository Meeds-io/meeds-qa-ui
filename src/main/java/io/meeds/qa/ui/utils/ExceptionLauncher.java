package io.meeds.qa.ui.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class ExceptionLauncher {
  static final Logger  LOGGER = LoggerFactory.getLogger(ExceptionLauncher.class);

  public void throwSerenityExeption(Exception e, String errorMsg) {
    LOGGER.error(errorMsg);
    throw (new SerenityManagedException(errorMsg, e));
  }
}
