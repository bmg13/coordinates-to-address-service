package coordinateService.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "json:target/cucumber.json" }, features = "src/test/resources/features", plugin = "pretty", tags = {"@CTAS"})
public class CtasSetTest {
}
