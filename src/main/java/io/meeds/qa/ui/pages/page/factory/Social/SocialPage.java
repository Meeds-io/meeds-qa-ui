package io.meeds.qa.ui.pages.page.factory.Social;

import io.meeds.qa.ui.elements.ElementFacade;
import io.meeds.qa.ui.elements.TextBoxElementFacade;
import io.meeds.qa.ui.pages.GenericPage;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SocialPage extends GenericPage {
  @FindBy(xpath = "//button[@class='btn ms-2 v-btn v-btn--contained theme--light v-size--default']")
  public static ElementFacade    cancelBtn;

  @FindBy(xpath = "//i[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light']")
  public static ElementFacade    dotsMenu;

  @FindBy(
      xpath = "(//*[@class='v-list-item v-list-item--dense v-list-item--link theme--light']//*[@class='v-list-item__title pl-3'])[1]"
  )
  public static ElementFacade    editButton;

  @FindBy(xpath = "//select[contains(@class,'selectPeopleFilter')]")
  private static ElementFacade   filterByMyConnections;

  @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
  public static TextBoxElementFacade filterTextBox;

  @FindBy(xpath = "//a[@class='HamburgerNavigationMenuLink']")
  public static ElementFacade    menuBtn;

  @FindBy(xpath = "//a[@class='v-list-item v-list-item--link theme--light UserPageLink']")
  public static ElementFacade    peopleBtn;

  @FindBy(xpath = "//button[@class='btn btn-primary ms-10 v-btn v-btn--contained theme--light v-size--default primary']")
  public static ElementFacade    updateButon;

  @FindBy(xpath = "//*[contains(@class, 'v-navigation-drawer--open')]//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private ElementFacade          ckEditorFrameComment;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[@class='v-btn__content'])[3]")
  private ElementFacade          closeCommentsDrawer;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade       commentField;

  @FindBy(xpath = "//a[@id='CommentLink1']")
  private ElementFacade          commentLink;

  public void cancelUpdateActivityComment(String comment) {
    waitCKEditorLoading();
    ckEditorFrameComment.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameComment);
    try {
      commentField.waitUntilVisible();
      commentField.clear();
      commentField.setTextValue(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }
    cancelBtn.clickOnElement();
    closeCommentsDrawer.clickOnElement();
  }

  public void checkSearchedUserWellMatched(String user) {
    assertWebElementVisible(getUserProfileButton(user));
  }

  public void CommentActivity(String activity) {
    getLikeCommentIcon(activity).clickOnElement();
  }

  public void editComment() {
    dotsMenu.clickOnElement();
    editButton.clickOnElement();

  }

  public void filterByMyConnections() {
    filterByMyConnections.waitUntilVisible();
    filterByMyConnections.clickOnElement();
    filterByMyConnections.selectByValue("connections");
  }

  private ElementFacade getLikeCommentIcon(String activityComment) {
    return findByXPathOrCSS(String.format("(//a[@id='CommentLink1']", activityComment));
  }

  private ElementFacade getUserProfileButton(String user) {
    return findByXPathOrCSS(String.format("//a[contains(@href,'%s')and contains(@class,'userFullname')]", user));
  }

  public void GoToPeopleMenu() {

    menuBtn.clickOnElement();
    peopleBtn.clickOnElement();

  }

  public void insertNameContact(String contact) {
    filterTextBox.setTextValue(contact);

  }

  public void updateActivityComment(String comment) {
    waitCKEditorLoading();
    ckEditorFrameComment.waitUntilVisible();
    getDriver().switchTo().frame(ckEditorFrameComment);
    try {
      commentField.waitUntilVisible();
      commentField.clear();
      commentField.setTextValue(comment);
    } finally {
      getDriver().switchTo().defaultContent();
    }

    updateButon.clickOnElement();
    closeCommentsDrawer.clickOnElement();
  }

}
