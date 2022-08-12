package io.meeds.qa.ui.steps;

import java.io.IOException;
import java.util.List;

import io.meeds.qa.ui.utils.galenBaseClass.GalenTestBase;
import net.thucydides.core.annotations.Steps;

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
