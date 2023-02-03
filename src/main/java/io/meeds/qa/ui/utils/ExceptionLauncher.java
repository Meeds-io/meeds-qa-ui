package io.meeds.qa.ui.utils;

import java.lang.System.Logger.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class ExceptionLauncher {
  public static final Logger LOGGER = LoggerFactory.getLogger(ExceptionLauncher.class);

  public static final void throwSerenityExeption(Exception e, String errorMsg) {
    throw new SerenityManagedException(errorMsg, e);
  }

  public static final void displayMessageInStandardOutput(String message, Object... parameters) {
    if (parameters != null) {
      for (Object param : parameters) {
        message = message.replaceFirst("\\{\\}",
                                       param instanceof Exception ? ((Exception) param).getMessage()
                                                                  : String.valueOf(param));
      }
      System.getLogger("ExceptionLauncher").log(Level.INFO, message);
    } else {
      System.getLogger("ExceptionLauncher").log(Level.INFO, message);
    }
  }

  private ExceptionLauncher() {
    // Utils class
  }
}
