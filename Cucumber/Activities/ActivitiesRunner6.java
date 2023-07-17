package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        tags = "@SimpleAlert",
        plugin = {"pretty", "html: test-reports", "json: src/reports/json-report.json"},
        monochrome = true
)

public class ActivitiesRunner6 {
    //This is intentionally blank
}
