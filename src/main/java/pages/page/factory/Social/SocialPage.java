package pages.page.factory.Social;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.Serenity;
import pages.GenericPage;

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

  @FindBy(xpath = "//iframe[contains(@class,'cke_wysiwyg_frame')]")
  private BaseElementFacade          ckEditorFrameComment;

  @FindBy(xpath = "//body[contains(@class,'cke_editable_themed')]")
  private TextBoxElementFacade       commentField;

  @FindBy(xpath = "(//*[@id='activityCommentsDrawer']//*[@class='v-btn__content'])[3]")
  private BaseElementFacade          closeCommentsDrawer;

  @FindBy(xpath = "(//*[@class='v-list-item v-list-item--dense v-list-item--link theme--light']//*[@class='v-list-item__title pl-3'])[1]")
  public static BaseElementFacade    editButton;

  @FindBy(xpath = "(//i[@class='v-icon notranslate primary--text mdi mdi-dots-vertical theme--light'])[2]")
  public static BaseElementFacade    dotsMenu;

  @FindBy(xpath = "//button[@class='btn btn-primary ms-10 v-btn v-btn--contained theme--light v-size--default primary']")
  public static BaseElementFacade    updateButon;

  private BaseElementFacade getUserProfileButton(String user) {
    return findByXpath(String.format("//a[contains(@href,'%s')and contains(@class,'userFullname')]", user));
  }

  public void GoToPeopleMenu() {

    menuBtn.clickOnElement();
    peopleBtn.clickOnElement();

  }

  private BaseElementFacade getLikeCommentIcon(String activityComment) {
    return findByXpath(String.format("(//a[@id='CommentLink1']", activityComment));
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
    getUserProfileButton(user).isVisibleAfterWaiting();
  }

  public void editComment() {
    dotsMenu.clickOnElement();
    editButton.clickOnElement();

  }

  public void updateActivityComment(String comment) {

    ckEditorFrameComment.clickOnElement();
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameComment);
    commentField.waitUntilVisible();
    commentField.clear();
    commentField.setTextValue(comment);
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();

    updateButon.clickOnElement();
    closeCommentsDrawer.clickOnElement();
  }

  public void cancelUpdateActivityComment(String comment) {

    ckEditorFrameComment.clickOnElement();
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().frame(ckEditorFrameComment);
    commentField.waitUntilVisible();
    commentField.clear();
    commentField.setTextValue(comment);
    Serenity.getWebdriverManager().getCurrentDriver().switchTo().defaultContent();

    cancelBtn.clickOnElement();
    closeCommentsDrawer.clickOnElement();
  }

}
