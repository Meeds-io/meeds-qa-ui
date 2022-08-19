package io.meeds.qa.ui.pages;

import static io.meeds.qa.ui.utils.Utils.switchToTabByIndex;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.meeds.qa.ui.elements.BaseElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class GenericPage extends BasePageImpl {

  public GenericPage() {
    this(null);
  }

  public GenericPage(WebDriver driver) {
    super(driver);
    url = "genericPage";
  }

  @FindBy(xpath = "//div[contains(@class,'alert-success')]")
  private BaseElementFacade  successMessagePopup;

  public static final String UPLOAD_DIRECTORY_PATH = System.getProperty("user.dir") + File.separator + "src"
      + File.separator + "test" + File.separator + "resources" + File.separator + "DataFiles" + File.separator;

  private BaseElementFacade getConfirmMessage(String message) {
    return findByXPathOrCSS(String.format("//span[contains(text(),\"%s\")]", message));
  }

  private BaseElementFacade getButton(String buttonName) {
    return findByXPathOrCSS(String.format("//a[contains(text(),'%s')]", buttonName));
  }

  private BaseElementFacade getOKButton(String buttonName) {
    return findByXPathOrCSS(String.format("//button[contains(text(),'%s')]", buttonName));
  }

  public void checkDrawerDisplayed(String title) {
    assertTrue(findByXPathOrCSS(String.format("//*[contains(@class, 'drawerTitle') and contains(text(),'%s')]",
                                              title)).isVisibleAfterWaiting());
  }

  public boolean inConfirmMessageDisplayed(String message) {
    return getConfirmMessage(message).isVisibleAfterWaiting();
  }

  public boolean isButtonDisplayed(String buttonName) {
    return getButton(buttonName).isVisibleAfterWaiting();
  }

  public boolean isSuccessMessageDisplayed() {
    return successMessagePopup.isVisibleAfterWaiting();
  }

  public void clickConfirm() {
    getButton("Confirm").clickOnElement();
  }

  public void clickOkButton() {
    getOKButton("OK").clickOnElement();
  }

  public boolean containsContent(String content) {
    WebElement element = getDriver().findElement(By.xpath(String.format("//*[contains(text(),'%s')]",
                                                                        content)));
    return element != null && element.isDisplayed();
  }

  public void closeBrowserTab(int index) {
    switchToTabByIndex(driver, index);
    driver.close();
    if (index > 0) {
      switchToTabByIndex(driver, index - 1);
    }
  }

}
