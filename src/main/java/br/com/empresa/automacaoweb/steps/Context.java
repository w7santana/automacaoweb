package br.com.empresa.automacaoweb.steps;

import static br.com.empresa.automacaoweb.core.Driver.getDriver;
import static br.com.empresa.automacaoweb.core.Driver.killDriver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;

import br.com.empresa.automacaoweb.Demo;
import br.com.empresa.automacaoweb.manager.PageObjectManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Getter;

/*
 * Nessa classe devemos instanciar todos os objetos usados no teste pelas classes de steps
 */

@Getter
public class Context {
	private PageObjectManager pageObjectManager;
	
	public Context() {
		this.pageObjectManager = new PageObjectManager(getDriver());
	}
	
	@Before
	public void setup(Scenario cenario) {
//		LogManager.getLogger(Demo.class).info("Iniciando cenário: "+cenario.getName());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown(Scenario cenario) {
//		LogManager.getLogger(Demo.class).info("Encerrando cenário: "+cenario.getName());
//		Thread.sleep(5000);
		killDriver();
	}
	
	

}
