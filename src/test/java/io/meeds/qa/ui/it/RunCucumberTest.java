package io.meeds.qa.ui.it;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = {
        "pretty"
    },
    features = "classpath:features",
    glue = {
        "io.meeds.qa.ui.hook",
        "io.meeds.qa.ui.stepDefinitions"
    }
)
public class RunCucumberTest {}// NOSONAR Empty Class: cucumber engine will
                               // create test cases from feature files
