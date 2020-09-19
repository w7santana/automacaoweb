package br.com.empresa.automacaoweb.steps;

import static br.com.empresa.automacaoweb.core.Driver.getDriver;
import static br.com.empresa.automacaoweb.core.Driver.killDriver;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.empresa.automacaoweb.Demo;
import br.com.empresa.automacaoweb.core.CoreActions;
import br.com.empresa.automacaoweb.manager.PageObjectManager;
import br.com.empresa.automacaoweb.pages.HomePage;
import br.com.empresa.automacaoweb.utility.Print;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Mas;
import io.cucumber.java.pt.Quando;

public class TestSteps extends CoreActions{
	
	private Logger logger;
	private PageObjectManager pageObjectManager;
	private HomePage homePage;
	
	@Before
	public void setup(Scenario cenario) {
		logger = LogManager.getLogger(Demo.class);
		logger.info("Iniciando cenário: "+cenario.getName());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		pageObjectManager = new PageObjectManager(getDriver());
		homePage = pageObjectManager.getHomePage();
	}
	
	@After
	public void tearDown(Scenario cenario) {
		logger.info("Encerrando cenário: "+cenario.getName());
//		Thread.sleep(5000);
		killDriver();
	}


	@Dado("que o usuário está na página inicial do site")
	public void que_o_usuário_está_na_página_inicial_do_site() {
		getDriver().get("https://elogieaki.com.br/");
		
	}

	
	@Quando("o usuario preenche email e senha inválidos")
	public void o_usuario_preenche_email_e_senha_inválidos() {
		homePage.getBtnLogin().click();
		clearAndWrite(homePage.getCampoEmail(), "email@teste.com");
		clearAndWrite(homePage.getCampoSenha(), "senha123");
		homePage.getBtnEntrar().click();
	}


	@Então("será aprensentada a mensagem {string}")
	public void será_aprensentada_a_mensagem(String string) {
	    fluentWait(homePage.getMsgEmailSenhaInvalidos());
		Print.captureScreenShot(getDriver());
		assertTrue("Elemento não visível", homePage.getMsgEmailSenhaInvalidos().isDisplayed());
	}

}
