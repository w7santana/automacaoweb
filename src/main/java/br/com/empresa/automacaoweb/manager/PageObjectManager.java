package br.com.empresa.automacaoweb.manager;

import org.openqa.selenium.WebDriver;

import br.com.empresa.automacaoweb.pages.HomePage;

public class PageObjectManager {
	WebDriver driver;
	HomePage homePage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage(){
		 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	
}
