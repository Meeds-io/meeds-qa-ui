package pages.page.factory.NewComposer;

import elements.BaseElementFacade;
import elements.TextBoxElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import pages.GenericPage;

public class RedactorRolePage extends GenericPage {

    @FindBy(
            xpath = "//button[@class='peopleMenuIcon d-block v-btn v-btn--flat v-btn--icon v-btn--round v-btn--text theme--light v-size--default']"
    )
    public static BaseElementFacade threeDotsMenu;

    @FindBy(xpath = "(//*[@class='v-list-item__title peopleActionItem'])[5]")
    public static BaseElementFacade setAsRedactorBtn;

    @FindBy(xpath = "(//*[@class='v-list-item__title peopleActionItem'])[4]")
    public static BaseElementFacade setAsManagerBtn;

    @FindBy(xpath = "//div[@class=\"drawer open\"]")
    private BaseElementFacade writeShortMessageDrawer;

    @FindBy(xpath = "//header[@id='peopleListToolbar']//input")
    private TextBoxElementFacade searchPeopleInput;

    private BaseElementFacade setRedactorUserButton(String user) {
        return findByXpath(String
                .format("//a[contains(@href,'%s')]//following::button[@class='peopleMenuIcon d-block v-btn v-btn--flat v-btn--icon v-btn--round v-btn--text theme--light v-size--default']",
                        user));
    }

    public void checkPostDrawer() {
        writeShortMessageDrawer.isVisibleAfterWaiting();

    }

    public void setRedactor() {

        setAsRedactorBtn.clickOnElement();
    }

    public void setAsSpaceManager() {

        setAsManagerBtn.clickOnElement();
    }

    public void ThreeDotsMenu() {
        threeDotsMenu.waitUntilVisible();
        threeDotsMenu.clickOnElement();
    }

}
