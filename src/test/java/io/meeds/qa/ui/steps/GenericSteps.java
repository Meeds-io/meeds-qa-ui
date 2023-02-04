package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.GenericPage;

public class GenericSteps {
  private GenericPage genericPage;

  public void checkDrawerDisplayed(String title) {
    genericPage.checkDrawerDisplayed(title);
  }

  public void clickConfirm() {
    genericPage.clickConfirm();
  }

  public void clickOkButton() {
    genericPage.clickOkButton();
  }

  public void closeBrowserTab(int tabIndex) {
    genericPage.closeBrowserTab(tabIndex);
  }

  public boolean containsContent(String content) {
    return genericPage.containsContent(content);
  }

  public String getCurrentUrl() {
    return genericPage.getCurrentUrl();
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

  public void waitInSeconds(int seconds) {
    genericPage.waitFor(seconds).seconds();
  }

  public void closeDrawerIfDisplayed() {
    genericPage.closeDrawerIfDisplayed();
  }

  public void closeAllDrawers() {
    genericPage.closeAllDrawers();
  }

}
