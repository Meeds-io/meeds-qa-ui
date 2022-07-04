package steps;

import net.serenitybdd.core.Serenity;
import pages.GenericPage;

import java.util.ArrayList;

public class GenericSteps {
private GenericPage genericPage;
    public static void switchToTabByIndex(int index){
        ArrayList<String> newTab = new ArrayList<String>(Serenity.getWebdriverManager().getCurrentDriver().getWindowHandles());
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().window(newTab.get(index));
    }
    public boolean inConfirmMessageDisplayed(String message){
        return genericPage.inConfirmMessageDisplayed(message);
    }
    public boolean isButtonDisplayed(String button){
        return genericPage.isButtonDisplayed(button);
    }
    public boolean isSuccessMessageDisplayed(){
        return genericPage.isSuccessMessageDisplayed();
    }

    public void clickConfirm(){
        genericPage.clickConfirm();
    }

    public void clickOkButton(){
        genericPage.clickOkButton();
    }
}
