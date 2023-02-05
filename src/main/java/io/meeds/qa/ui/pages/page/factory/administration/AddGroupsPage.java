package io.meeds.qa.ui.pages.page.factory.administration;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

public class AddGroupsPage extends GenericPage {
  public AddGroupsPage(WebDriver driver) {
    super(driver);
  }

  public void addMemberInGroup(String role, String member) {
    ElementFacade addMemberInGroupBtnElement = addMemberInGroupBtnElement();
    if (!addMemberInGroupBtnElement.isClickable() || !addMemberInGroupBtnElement.isVisible()) {
      refreshPage();
    }
    ElementFacade closeDrawerButtonElement = closeDrawerButtonElement();
    if (closeDrawerButtonElement.isCurrentlyVisible()) {
      closeDrawerButtonElement.clickOnElement();
      waitForDrawerToClose();
    }
    addMemberInGroupBtnElement.clickOnElement();
    ElementFacade selectedRoleFieldElement = selectedRoleFieldElement();
    selectedRoleFieldElement.selectByValue(role);
    selectedRoleFieldElement.clickOnElement();
    TextBoxElementFacade inviteMemberInputElement = inviteMemberInputElement();
    inviteMemberInputElement.setTextValue(member);
    boolean found = mentionInField(inviteMemberInputElement, member, 3);
    if (found) {
      ElementFacade saveMemberAddedInGroupElement = saveMemberAddedInGroupElement();
      try {
        saveMemberAddedInGroupElement.clickOnElement();
      } catch (Exception e) {
        findByXPathOrCSS("//*[contains(@class,'drawerTitle')]").clickOnElement();
        saveMemberAddedInGroupElement.clickOnElement();
      }
    }
    if (closeDrawerButtonElement.isCurrentlyVisible()) {
      closeDrawerButtonElement.clickOnElement();
    }
    waitForDrawerToClose();
  }

  public ElementFacade groupOpenBtn(String group) {
    return findByXPathOrCSS(String
                                  .format("//*[@class='flex sm12 md4 flat']//*[@class='v-list-item__content']//*[contains(text(),'%s')]/preceding::i[@class='v-icon notranslate mdi mdi-menu-right theme--light'][1]",
                                          group));
  }

  public ElementFacade groupToSelect(String group) {
    return findByXPathOrCSS(String
                                  .format("//*[@class='flex sm12 md4 flat']//*[@class='v-list-item__content']//*[contains(text(),'%s')]",
                                          group));
  }

  public void openGroup(String group) {
    groupOpenBtn(group).clickOnElement();
  }

  public void selectGroup(String group) {
    groupToSelect(group).clickOnElement();
  }

  private ElementFacade addMemberInGroupBtnElement() {
    return findByXPathOrCSS("//*[contains(@class,'addNewMembershipButton')]");
  }

  private ElementFacade closeDrawerButtonElement() {
    return findByXPathOrCSS("//*[@id='membershipFormDrawer' and contains(@class, 'v-navigation-drawer--open')]//button[contains(@class,'mdi-close')]");
  }

  private TextBoxElementFacade inviteMemberInputElement() {
    return findTextBoxByXPathOrCSS("//input[@id='userNameInput']");
  }

  private ElementFacade saveMemberAddedInGroupElement() {
    return findByXPathOrCSS("//*[@id='membershipFormDrawer' and contains(@class, 'v-navigation-drawer--open')]//button[contains(@class,'btn-primary')]");
  }

  private ElementFacade selectedRoleFieldElement() {
    return findByXPathOrCSS("//*[contains(@class,'membershipNameField')]//select");
  }

}
