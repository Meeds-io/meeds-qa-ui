package io.meeds.qa.ui.steps;

import java.util.ArrayList;

import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.Serenity;

public class GenericSteps {
  private GenericPage genericPage;

  public static void switchToTabByIndex(int index) {
    ArrayList<String> newTab = new ArrayList<String>(Serenity.getWebdriverManager().getCurrentDriver().getWindowHandles());
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().window(newTab.get(index));
  }

  public boolean inConfirmMessageDisplayed(String message) {
    return genericPage.inConfirmMessageDisplayed(message);
  }

  public boolean isButtonDisplayed(String button) {
    return genericPage.isButtonDisplayed(button);
  }

  public boolean isSuccessMessageDisplayed() {
    return genericPage.isSuccessMessageDisplayed();
  }

  public void clickConfirm() {
    genericPage.clickConfirm();
  }

  public void clickOkButton() {
    genericPage.clickOkButton();
  }

  public void waitInSeconds(int seconds) throws InterruptedException {
    genericPage.waitInSeconds(seconds);
  }
}
