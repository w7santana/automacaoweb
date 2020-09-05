package br.com.empresa.automacaoweb.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static br.com.empresa.automacaoweb.core.Driver.getDriver;
import static br.com.empresa.automacaoweb.core.Driver.killDriver;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;

import br.com.empresa.automacaoweb.core.CoreActions;
import br.com.empresa.automacaoweb.core.ExcelDataProvider;;

public class ClasseTeste extends CoreActions{
//	protected CoreActions corecAtions;
	
	@Rule
	public TestName nomeDoTeste = new TestName();
	
	@BeforeMethod
	public void inicializaTeste() {
		System.out.println("Executando before antes do teste: "+nomeDoTeste.getMethodName());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		getDriver().get("https://elogieaki.com.br/");
		
	}
	
	@AfterMethod
	public void encerraTeste() throws InterruptedException {
		System.out.println("Executando after após o teste: "+nomeDoTeste.toString());
		Thread.sleep(10000);
        killDriver();
	}
	
	
    @Test(dataProvider="nomeDataProvider", dataProviderClass = ExcelDataProvider.class, testName = "Login")
    public void primeiroTeste (String email, String senha) throws InterruptedException {
        getDriver().findElement(By.id("navbarDropdown")).click();
        
        clearAndWrite((By.id("exampleDropdownFormEmail2")), email);
        clearAndWrite((By.id("exampleDropdownFormPassword2")), senha);
        
        

        
    }
    

}
