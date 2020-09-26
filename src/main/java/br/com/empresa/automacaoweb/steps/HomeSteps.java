package br.com.empresa.automacaoweb.steps;

import static br.com.empresa.automacaoweb.core.Driver.getDriver;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.Logger;

import br.com.empresa.automacaoweb.core.CoreActions;
import br.com.empresa.automacaoweb.pages.HomePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class HomeSteps extends CoreActions{
	
	Logger logger;
	HomePage homePage;
	Context context;
	
	
	public HomeSteps(Context context) {
		this.context = context;
		homePage = this.context.getPageObjectManager().getHomePage();
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
//		Print.captureScreenShot(getDriver());
		assertTrue("Elemento não visível", homePage.getMsgEmailSenhaInvalidos().isDisplayed());
	}

}
