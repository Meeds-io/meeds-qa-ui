package utils.galenBaseClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.speclang2.pagespec.SectionFilter;
import com.galenframework.support.GalenJavaTestBase;

import net.serenitybdd.core.Serenity;

public class GalenTestBase extends GalenJavaTestBase {

  @Override
  public WebDriver createDriver(Object[] args) {
    WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
    return driver;
  }

  @Override
  public WebDriver getDriver() {
    WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
    return driver;
  }

  @Override
  public void checkLayout(String specPath, List<String> includedTags) throws IOException {
    checkLayout(specPath, new SectionFilter(includedTags, Collections.<String> emptyList()), new Properties(), null);
  }

  @Override
  public void checkLayout(String specPath,
                          SectionFilter sectionFilter,
                          Properties properties,
                          Map<String, Object> vars) throws IOException {
    String title = "Check layout " + specPath;
    LayoutReport layoutReport = Galen.checkLayout(getDriver(), specPath, sectionFilter, properties, vars);
    generateReport(layoutReport, title);
  }

  public void load(String uri) {
    Serenity.getWebdriverManager().getCurrentDriver().get(uri);
  }

  private void generateReport(LayoutReport layoutReport, String testTitle) throws IOException {
    List<GalenTestInfo> tests = new LinkedList<>();
    // consisting the information regarding the test
    String testCaseName = Serenity.sessionVariableCalled("templateName");
    GalenTestInfo test = GalenTestInfo.fromString(testCaseName);
    // Adding layout report to the test report
    test.getReport().layout(layoutReport, testTitle);
    tests.add(test);
    Serenity.setSessionVariable("tests").to(tests);
    // Exporting all test report to html
    new HtmlReportBuilder().build(tests, "target/site/serenity/galen-html-reports");
  }

  protected List<String> getFailedTestsList() {
    List<GalenTestInfo> testsResult = Serenity.sessionVariableCalled("tests");
    List<String> failedTests = new ArrayList<>();
    for (GalenTestInfo testResult : testsResult) {
      if (testResult.isFailed())
        failedTests.add(testResult.getName());
    }
    return failedTests;
  }

}
