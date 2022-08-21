package io.meeds.qa.ui.pages.page.factory.Social;

import static org.junit.Assert.assertTrue;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import io.meeds.qa.ui.utils.SwitchToWindow;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SocialPage extends GenericPage {
  @FindBy(xpath = "//a[@id='CommentLink1']")
  private BaseElementFacade          commentLink;

  @FindBy(xpath = "//select[contains(@class,'selectPeopleFilter')]")
  private static BaseElementFacade   filterByMyConnections;

  @FindBy(xpath = "//a[@class='HamburgerNavigationMenuLink']")
  public static BaseElementFacade    menuBtn;

  @FindBy(xpath = "//a[@class='v-list-item v-list-item--link theme--light UserPageLink']")
  public static BaseElementFacade    peopleBtn;

  @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
  public static TextBoxElementFacade filterTextBox;

  @FindBy(xpath = "//button[@class='btn ms-2 v-btn v-btn--contained theme--light v-size--default']")
  public static BaseElementFacade    cancelBtn;

  @FindBy(xpath = "//*[contains(@class, 'v-navigation-drawer--open')]//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade          ckEditorFrameComment;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade       commentField;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[@class='v-btn__content'])[3]")
  private BaseElementFacade          closeCommentsDrawer;

  @FindBy(
      xpath = "(//*[@class='v-list-item v-list-item--dense v-list-item--link theme--light']//*[@class='v-list-item__title pl-3'])[1]"
  )
  public static BaseElementFacade    editButton;

  @FindBy(xpath = "//i[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light']")
  public static BaseElementFacade    dotsMenu;

  @FindBy(xpath = "//button[@class='btn btn-primary ms-10 v-btn v-btn--contained theme--light v-size--default primary']")
  public static BaseElementFacade    updateButon;

  private BaseElementFacade getUserProfileButton(String user) {
    return findByXPathOrCSS(String.format("//a[contains(@href,'%s')and contains(@class,'userFullname')]", user));
  }

  public void GoToPeopleMenu() {

    menuBtn.clickOnElement();
    peopleBtn.clickOnElement();

  }

  private BaseElementFacade getLikeCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//a[@id='CommentLink1']", activityComment));
  }

  public void CommentActivity(String activity) {
    getLikeCommentIcon(activity).clickOnElement();
  }

  public void filterByMyConnections() {
    filterByMyConnections.waitUntilVisible();
    filterByMyConnections.clickOnElement();
    filterByMyConnections.selectByValue("connections");
  }

  public void insertNameContact(String contact) {
    filterTextBox.setTextValue(contact);

  }

  public void checkSearchedUserWellMatched(String user) {
    assertWebElementVisible(getUserProfileButton(user));
  }

  public void editComment() {
    dotsMenu.clickOnElement();
    editButton.clickOnElement();

  }

  @SwitchToWindow
  public void updateActivityComment(String comment) {
    waitCKEditorLoading();
    ckEditorFrameComment.clickOnElement();
    driver.switchTo().frame(ckEditorFrameComment);
    try {
      commentField.waitUntilVisible();
      commentField.clear();
      commentField.setTextValue(comment);
    } finally {
      driver.switchTo().defaultContent();
    }

    updateButon.clickOnElement();
    closeCommentsDrawer.clickOnElement();
  }

  @SwitchToWindow
  public void cancelUpdateActivityComment(String comment) {
    waitCKEditorLoading();
    ckEditorFrameComment.clickOnElement();
    driver.switchTo().frame(ckEditorFrameComment);
    try {
      commentField.waitUntilVisible();
      commentField.clear();
      commentField.setTextValue(comment);
    } finally {
      driver.switchTo().defaultContent();
    }
    cancelBtn.clickOnElement();
    closeCommentsDrawer.clickOnElement();
  }

}
