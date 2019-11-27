package br.com.empresa.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",  //Selecionar Feature
	    glue = "br.com.empresa.steps",   // Diretório dos Steps
		plugin = { "pretty", "html:target/report-html", "json:target/report.json"}, // formatação de relatório no console
		monochrome = true, 
		tags = "@funcionais",
		snippets = SnippetType.CAMELCASE, 
		dryRun= false,  // dryRum=true validação de passos, caso falta ele gera.
		strict = false
		)
public class RunnerFuncionalTest {

}
