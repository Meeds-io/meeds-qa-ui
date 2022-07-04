package utils;

import net.serenitybdd.core.exceptions.SerenityManagedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionLauncher {
	static final Logger LOGGER = LogManager.getLogger();

	public void throwSerenityExeption(Exception e, String errorMsg) {
		LOGGER.error(errorMsg);
		throw (new SerenityManagedException(errorMsg, e));
	}
}
