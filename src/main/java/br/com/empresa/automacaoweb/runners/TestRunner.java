package br.com.empresa.automacaoweb.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
	features = "classpath:features",
	glue = "br.com.empresa.automacaoweb.steps",
	dryRun = false,
	monochrome = true,
	plugin = "pretty",
	snippets = SnippetType.UNDERSCORE,
	tags = "@LoginEmailSenhaInvalidos"
		
		
)


public class TestRunner extends AbstractTestNGCucumberTests {

}
