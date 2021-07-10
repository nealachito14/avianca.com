package avianca.Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/Features/aviancaCom.feature",
		glue = "avianca.StepsDefinition",
		snippets = SnippetType.CAMELCASE,
		tags = "@searches"
		)

public class aviancaRunner {
	
}
