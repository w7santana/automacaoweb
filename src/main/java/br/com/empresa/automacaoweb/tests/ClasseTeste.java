package br.com.empresa.automacaoweb.tests;

import static br.com.empresa.automacaoweb.core.Driver.getDriver;
import static br.com.empresa.automacaoweb.core.Driver.killDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sun.xml.internal.bind.v2.runtime.Name;

import br.com.empresa.automacaoweb.Demo;
import br.com.empresa.automacaoweb.core.CoreActions;
import br.com.empresa.automacaoweb.core.ExcelDataProvider;
import br.com.empresa.automacaoweb.listeners.TestNGListeners;
import br.com.empresa.automacaoweb.manager.PageObjectManager;
import br.com.empresa.automacaoweb.pages.HomePage;
import sun.util.logging.resources.logging;

@Listeners(TestNGListeners.class)
public class ClasseTeste extends CoreActions {
	PageObjectManager pageObjectManager;
	HomePage homePage;
	private Logger logger;

	@BeforeMethod
	public void inicializaTeste() {
		logger = LogManager.getLogger(Demo.class);
		logger.info("Executando @BeforeMethod!");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		getDriver().get("https://elogieaki.com.br/");
		getDriver().get("https://demoqa.com/dynamic-properties");
		pageObjectManager = new PageObjectManager(getDriver());
		homePage = pageObjectManager.getHomePage();

	}

	@AfterMethod
	public void encerraTeste() throws InterruptedException {
		logger.info("Executando @AfterMethod!");
//		Thread.sleep(5000);
		killDriver();
	}

	@Test(dataProvider = "nomeDataProvider", dataProviderClass = ExcelDataProvider.class, testName = "Login", enabled = false)
	public void primeiroTeste(String email, String senha) throws InterruptedException {
		homePage.getBtnLogin().click();

		clearAndWrite(homePage.getCampoEmail(), email);
		clearAndWrite(homePage.getCampoSenha(), senha);

	}

	@Test(enabled = false)
	public void testaFWait() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getDriver());
		wait.pollingEvery(Duration.ofMillis(250));
		wait.withTimeout(Duration.ofSeconds(6));
		wait.ignoring(NullPointerException.class);

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver arg0) {
				WebElement element = arg0.findElement(By.id("colorChange"));
				String color = element.getCssValue("color");
//						getAttribute("color");
				System.out.println("The color of the button is " + color);
				if (color.equals("rgba(220, 53, 69, 1)")) {
					return true;
				}
				return false;
			}
		};
		wait.until(function);

	}

}
