package io.meeds.qa.ui.pages.page.factory.NewComposer;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class RedactorRolePage extends GenericPage {

  @FindBy(xpath = "(//*[@class='v-list-item__title peopleActionItem'])[4]")
  public static ElementFacade setAsManagerBtn;

  @FindBy(xpath = "(//*[@class='v-list-item__title peopleActionItem'])[4]")
  public static ElementFacade setAsRedactorBtn;

  @FindBy(
      xpath = "//button[@class='peopleMenuIcon d-block v-btn v-btn--flat v-btn--icon v-btn--round v-btn--text theme--light v-size--default']"
  )
  public static ElementFacade threeDotsMenu;

  @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
  private TextBoxElementFacade    searchPeopleInput;

  @FindBy(xpath = "//*[contains(@class, 'v-navigation-drawer--open')]//*[contains(@class, 'activityRichEditor')]")
  private ElementFacade       writeShortMessageDrawer;

  public void checkPostDrawer() {
    assertWebElementVisible(writeShortMessageDrawer);
  }

  public void setAsSpaceManager() {

    setAsManagerBtn.clickOnElement();
  }

  public void setRedactor() {

    setAsRedactorBtn.clickOnElement();
  }

  public void ThreeDotsMenu() {
    threeDotsMenu.waitUntilVisible();
    threeDotsMenu.clickOnElement();
  }

}
