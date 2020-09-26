package br.com.empresa.automacaoweb.core;

import static br.com.empresa.automacaoweb.core.Driver.getDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreActions {
	protected JavascriptExecutor jse;
	protected Actions action;
	

	public WebElement fluentlyWaitUntilClickable(WebElement element, int timeoutInSeconds,
			Integer pollingInSeconds) {
		return (new FluentWait<WebDriver>(getDriver())) //
				.withTimeout(Duration.ofSeconds(timeoutInSeconds)) //
				.pollingEvery(Duration.ofSeconds(pollingInSeconds)) //
				.ignoring(StaleElementReferenceException.class) //
				.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Aguarda um tempo predefinido antes de executar uma ação.
	 * Futuramente será substituído por um Smart Wait.
	 */
	public void jseWait() {
		jse = (JavascriptExecutor) getDriver();
		jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
	}
	
	/**
	 * Rola a página para baixo utilizando o JavascriptExecutor.
	 */
	public void scrollDown() {
		jse = (JavascriptExecutor) getDriver();
		jse.executeScript("scrollBy(0,200)", "");
	}
	
	/**
	 * Clica no elemento passado como par�metro.
	 * @param WebElement elemento
	 */
	public void jseClick(WebElement elemento) {
		jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", elemento);
	}
	
	/**
	 * Cria um FluentWait com timeout de 10 segundos e tentativas a cada 1 segundo ignorando as exceções NoSuchElementException e StaleElementReferenceException. 
	 * @param WebElement pelo qual deve ser aguardada sua visibilidade.
	 * @return o elemento uma vez que já esteja visível.
	 */
	public WebElement fluentWait(WebElement elemento)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(6))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		return wait.until(ExpectedConditions.visibilityOf(elemento));
	}
	
	public WebElement wait(WebElement elemento)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		return wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}
	
	
	public void sleep(int miliseconds) throws InterruptedException {
		Thread.sleep(miliseconds);
	}
	
	/**
	 * Simula ação da tecla Page Down do teclado rolando a tela para baixo.
	 */
	public void pageDown() {
		action = new Actions(getDriver());
		action.sendKeys(Keys.PAGE_DOWN);
	}
	
	public void clearAndWrite(WebElement webElement, String texto) {
		webElement.clear();
		webElement.sendKeys(texto);
	}
	
	Function<WebDriver, Boolean> funca = new Function<WebDriver, Boolean>()
	{
		public Boolean apply(WebDriver arg0) {
			return null;
		}
	};
	
	
	Function<WebDriver, Boolean> funcao = new Function<WebDriver, Boolean>()
	 {
	 public Boolean apply(WebDriver driver) {
	 WebElement element = driver.findElement(By.id("colorVar"));
	 String color = element.getAttribute("color");
	 
	 System.out.println("The color if the button is " + color);
	 
	 if(color.equals("red"))
	 {
	 return true;
	 }
	 return false;
	 }
	 };
	 

}
