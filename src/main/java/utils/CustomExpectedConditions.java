package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedConditions{

	public ExpectedCondition<Boolean> urlToChange(String pageUrl) {
		return (webDriver) -> !webDriver.getCurrentUrl().matches(pageUrl);
	}
	
	public ExpectedCondition<Boolean> ajaxCallsToFinish() {
		return (webDriver) -> (boolean)((JavascriptExecutor)webDriver).executeScript("return jQuery.active == 0");
	}
}
