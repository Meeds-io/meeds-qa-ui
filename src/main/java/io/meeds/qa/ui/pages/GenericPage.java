package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.switchToTabByIndex;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.BaseElementFacade;

public class GenericPage extends BasePageImpl {

  public static final String UPLOAD_DIRECTORY_PATH = System.getProperty("user.dir") + File.separator + "src"
      + File.separator + "test" + File.separator + "resources" + File.separator + "DataFiles" + File.separator;

  public GenericPage() {
    this(null);
  }

  public GenericPage(WebDriver driver) {
    super(driver);
    url = "genericPage";
  }

  public void checkDrawerDisplayed(String title) {
    assertTrue(findByXPathOrCSS(String.format("//*[contains(@class, 'drawerTitle') and contains(text(),'%s')]",
                                              title)).isVisibleAfterWaiting());
  }

  public void clickConfirm() {
    getButton("Confirm").clickOnElement();
  }

  public void clickOkButton() {
    getOKButton("OK").clickOnElement();
  }

  public void closeBrowserTab(int index) {
    switchToTabByIndex(getDriver(), index);
    getDriver().close();
    if (index > 0) {
      switchToTabByIndex(getDriver(), index - 1);
    }
  }

  public boolean containsContent(String content) {
    WebElement element = getDriver().findElement(By.xpath(String.format("//*[contains(text(),'%s')]",
                                                                        content)));
    return element != null && element.isDisplayed();
  }

  private BaseElementFacade getButton(String buttonName) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s')]", buttonName));
  }

  private BaseElementFacade getConfirmMessage(String message) {
    return findByXPathOrCSS(String.format("//span[contains(text(),\"%s\")]", message));
  }

  private BaseElementFacade getOKButton(String buttonName) {
    return findByXPathOrCSS(String.format("//button[contains(text(),'%s')]", buttonName));
  }

  public boolean inConfirmMessageDisplayed(String message) {
    return getConfirmMessage(message).isVisibleAfterWaiting();
  }

  public boolean isButtonDisplayed(String buttonName) {
    return getButton(buttonName).isVisibleAfterWaiting();
  }

  public boolean isSuccessMessageDisplayed() {
    return findByXPathOrCSS("//div[contains(@class,'alert-success')]").isVisibleAfterWaiting();
  }

}
