package pages.page.factory.administration;

import org.openqa.selenium.WebDriver;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class AddGroupsPage extends GenericPage {
  public AddGroupsPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[contains(@class,'addNewMembershipButton')]")
  private BaseElementFacade    addMemberInGroupBtn;

  @FindBy(xpath = "//*[contains(@class,'drawerTitle') and contains(text(),'Add member in group')]")
  private BaseElementFacade    addMemberInGroupDrawerTitle;

  @FindBy(xpath = "//*[@class='d-flex']//button[contains(@class,'btn-primary')]")
  private BaseElementFacade    saveMemberAddedInGroup;

  @FindBy(xpath = "//input[@id='userNameInput']")
  private TextBoxElementFacade inviteMemberInput;

  @FindBy(xpath = "//*[contains(@class,'membershipNameField')]//select")
  private BaseElementFacade    selectedRoleField;

  private BaseElementFacade getSelectedMemberInDropDown(String userName) {
    return findByXpath(String.format(
                                     "//div[contains(@class,'identitySuggestionMenuItemText') and contains(text(),'%s')]",
                                     userName));
  }

  public BaseElementFacade groupOpenBtn(String group) {
    return findByXpath(String
                             .format("//*[@class='flex sm12 md4 flat']//*[@class='v-list-item__content']//*[contains(text(),'%s')]/preceding::i[@class='v-icon notranslate mdi mdi-menu-right theme--light'][1]",
                                     group));
  }

  public BaseElementFacade groupToSelect(String group) {
    return findByXpath(String
                             .format("//*[@class='flex sm12 md4 flat']//*[@class='v-list-item__content']//*[contains(text(),'%s')]",
                                     group));
  }

  public void openGroup(String group) {
    groupOpenBtn(group).clickOnElement();
  }

  public void selectGroup(String group) {
    groupToSelect(group).clickOnElement();
  }

  public void addMemberInGroup(String role, String member) {
    addMemberInGroupBtn.clickOnElement();
    selectedRoleField.selectByVisibleText(role);
    inviteMemberInput.setTextValue(member);
    getSelectedMemberInDropDown(member).clickOnElement();
    addMemberInGroupDrawerTitle.clickOnElement();
    saveMemberAddedInGroup.clickOnElement();
  }

}
