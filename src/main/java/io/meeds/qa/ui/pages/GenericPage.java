package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.switchToTabByIndex;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;

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

  public void checkConfirmMessageIsDisplayed(String message) {
    getConfirmMessage(message).assertVisible();
  }

  public void checkDrawerDisplayed(String title) {
    assertTrue(findByXPathOrCSS(String.format("//*[contains(@class, 'drawerTitle') and contains(text(),'%s')]",
                                              title)).isVisible());
  }

  public void clickConfirm() {
    getButton("Confirm").click();
  }

  public void clickOkButton() {
    getOKButton("OK").click();
  }

  public void closeBrowserTab(int index) {
    switchToTabByIndex(getDriver(), index);
    getDriver().close();
    if (index > 0) {
      switchToTabByIndex(getDriver(), index - 1);
    }
  }

  public boolean containsContent(String content) {
    return findByXPathOrCSS(String.format("//*[contains(text(),'%s')]", content)).isVisible();
  }

  public boolean isButtonDisplayed(String buttonName) {
    return getButton(buttonName).isVisible();
  }

  public void isPageOpened(String uriPart) {
    assertTrue(getDriver().getCurrentUrl().contains(uriPart));
  }

  public boolean isSuccessMessageDisplayed() {
    return findByXPathOrCSS("//div[contains(@class,'alert-success')]").isVisible();
  }

  private ElementFacade getButton(String buttonName) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s')]", buttonName));
  }

  private ElementFacade getConfirmMessage(String message) {
    return findByXPathOrCSS(String.format("//span[contains(text(),\"%s\")]", message));
  }

  private ElementFacade getOKButton(String buttonName) {
    return findByXPathOrCSS(String.format("//button[contains(text(),'%s')]", buttonName));
  }

}
