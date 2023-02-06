package io.meeds.qa.ui.pages.page.factory.space;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

public class SpaceMembersPage extends GenericPage {

  public void checkPostDrawer() {
    assertWebElementVisible(writeShortMessageDrawerElement());
  }

  public void clickOnThreeDotsMenu() {
    threeDotsMenuElement().clickOnElement();
  }

  public void setAsSpaceManager() {
    setAsManagerBtnElement().clickOnElement();
  }

  public void setRedactor() {

    setAsRedactorBtnElement().clickOnElement();
  }

  private ElementFacade setAsManagerBtnElement() {
    return findByXPathOrCSS("(//*[@class='v-list-item__title peopleActionItem'])[4]");
  }

  private ElementFacade setAsRedactorBtnElement() {
    return findByXPathOrCSS("(//*[@class='v-list-item__title peopleActionItem'])[4]");
  }

  private ElementFacade threeDotsMenuElement() {
    return findByXPathOrCSS("//button[@class='peopleMenuIcon d-block v-btn v-btn--flat v-btn--icon v-btn--round v-btn--text theme--light v-size--default']");
  }

  private ElementFacade writeShortMessageDrawerElement() {
    return findByXPathOrCSS("//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'activityRichEditor')]");
  }

}
