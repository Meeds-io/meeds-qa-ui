package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.GenericPage;

public class GenericSteps {
  private GenericPage genericPage;

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

  public boolean containsContent(String content) {
    return genericPage.containsContent(content);
  }

  public void waitInSeconds(int seconds) {
    genericPage.waitFor(seconds).seconds();
  }

  public void closeBrowserTab(int tabIndex) {
    genericPage.closeBrowserTab(tabIndex);
  }

  public void checkDrawerDisplayed(String title) {
    genericPage.checkDrawerDisplayed(title);
  }

  public String getCurrentUrl() {
    return genericPage.getCurrentUrl();
  }

}
