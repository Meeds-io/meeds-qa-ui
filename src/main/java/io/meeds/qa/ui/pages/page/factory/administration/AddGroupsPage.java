package io.meeds.qa.ui.pages.page.factory.administration;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;

public class AddGroupsPage extends GenericPage {
  @FindBy(xpath = "//*[contains(@class,'addNewMembershipButton')]")
  private BaseElementFacade    addMemberInGroupBtn;

  @FindBy(xpath = "//*[contains(@class,'drawerTitle') and contains(text(),'Add member in group')]")
  private BaseElementFacade    addMemberInGroupDrawerTitle;

  @FindBy(
      xpath = "//*[@id='membershipFormDrawer' and contains(@class, 'v-navigation-drawer--open')]//button[contains(@class,'mdi-close')]"
  )
  private BaseElementFacade    closeDrawerButton;

  @FindBy(xpath = "//input[@id='userNameInput']")
  private TextBoxElementFacade inviteMemberInput;

  @FindBy(
      xpath = "//*[@id='membershipFormDrawer' and contains(@class, 'v-navigation-drawer--open')]//button[contains(@class,'btn-primary')]"
  )
  private BaseElementFacade    saveMemberAddedInGroup;

  @FindBy(xpath = "//*[contains(@class,'membershipNameField')]//select")
  private BaseElementFacade    selectedRoleField;

  public AddGroupsPage(WebDriver driver) {
    super(driver);
  }

  @SwitchToWindow
  public void addMemberInGroup(String role, String member) {
    if (!addMemberInGroupBtn.isClickable() || !addMemberInGroupBtn.isVisible()) {
      refreshPage();
    }
    if (closeDrawerButton.isCurrentlyVisible()) {
      closeDrawerButton.clickOnElement();
      waitForDrawerToClose();
    }
    addMemberInGroupBtn.clickOnElement();
    selectedRoleField.selectByValue(role);
    selectedRoleField.clickOnElement();
    inviteMemberInput.setTextValue(member);
    BaseElementFacade progressBar = findByXPathOrCSS(".membershipUserField .identitySuggester .v-progress-linear");
    progressBar.waitUntilVisible();
    progressBar.waitUntilNotVisible();

    BaseElementFacade memberInDropDown = getSelectedMemberInDropDown(member);
    if (memberInDropDown.isCurrentlyVisible() || memberInDropDown.isVisibleAfterWaiting()) {
      memberInDropDown.waitUntilClickable();
      clickOnElement(memberInDropDown);
      addMemberInGroupDrawerTitle.clickOnElement();
      saveMemberAddedInGroup.clickOnElement();
    }
    if (closeDrawerButton.isCurrentlyVisible()) {
      closeDrawerButton.clickOnElement();
      waitForDrawerToClose();
    }
  }

  private BaseElementFacade getSelectedMemberInDropDown(String userName) {
    return findByXPathOrCSS(String.format(
                                          "//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                                          userName));
  }

  public BaseElementFacade groupOpenBtn(String group) {
    return findByXPathOrCSS(String
                                  .format("//*[@class='flex sm12 md4 flat']//*[@class='v-list-item__content']//*[contains(text(),'%s')]/preceding::i[@class='v-icon notranslate mdi mdi-menu-right theme--light'][1]",
                                          group));
  }

  public BaseElementFacade groupToSelect(String group) {
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

}
