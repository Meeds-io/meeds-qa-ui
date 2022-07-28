package io.meeds.qa.ui.it;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = { "io.meeds.qa.ui.hook", "io.meeds.qa.ui.stepDefinitions" }
)
public class RunCucumberTest {}
