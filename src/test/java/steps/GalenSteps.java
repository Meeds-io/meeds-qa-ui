package steps;

import java.io.IOException;
import java.util.List;

import net.thucydides.core.annotations.Steps;
import utils.galenBaseClass.GalenTestBase;

public class GalenSteps extends GalenTestBase {

    @Steps
    GenericSteps genericSteps;

    public void checkPage(String template) throws IOException, InterruptedException {
        Thread.sleep(3000);
        checkLayout(template, null);

    }

    public List<String> getListOfFails() {
        return getFailedTestsList();
    }

}
