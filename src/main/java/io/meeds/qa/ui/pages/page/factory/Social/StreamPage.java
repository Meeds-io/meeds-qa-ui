package io.meeds.qa.ui.pages.page.factory.Social;

import org.openqa.selenium.WebDriver;

import io.meeds.qa.ui.elements.BaseElementFacade;
import io.meeds.qa.ui.pages.GenericPage;

public class StreamPage extends GenericPage {
  public StreamPage(WebDriver driver) {
    super(driver);
  }

  private BaseElementFacade getSpaceNameActivity(String spaceName) {
    return findByXPathOrCSS(String.format("//div[@class='profile-popover space-avatar-wrapper']//a[contains(@href,'%s')]",
                                          spaceName));
  }

  private BaseElementFacade getUserNameActivity(String user) {
    return findByXPathOrCSS(String.format("(//*[contains(@class,'activity-head v-list-item v-list-item--dense theme--light py-2 ps-4 pe-1')]/div/a[contains(@href,'%s')])[1]",
                                          user));
  }

  public void hoverSpaceName(String spaceName) {
    getSpaceNameActivity(spaceName.toLowerCase())
                                                 .hover(String.format("//*[@class='profile-popover space-avatar-wrapper']//a[contains(@id,'spaceAvatar') and contains(@href,'%s')]//*[contains(@class,'primary--text')]",
                                                                      spaceName.toLowerCase()));
  }

  public void hoveruserName(String user) {
    getUserNameActivity(user)
                             .hover(String.format("(//*[contains(@class,'activity-head v-list-item v-list-item--dense theme--light py-2 ps-4 pe-1')]/div/a[contains(@href,'%s')])[1]",
                                                  user));
  }
}
