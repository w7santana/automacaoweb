package br.com.empresa.automacaoweb.manager;

import org.openqa.selenium.WebDriver;

import br.com.empresa.automacaoweb.pages.EmpresasPage;
import br.com.empresa.automacaoweb.pages.HomePage;
import br.com.empresa.automacaoweb.pages.VisualizarPage;

public class PageObjectManager {
	WebDriver driver;
	HomePage homePage;
	EmpresasPage empresasPage;
	VisualizarPage visualizarPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage(){
		 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public EmpresasPage getEmpresasPage(){
		return (empresasPage == null) ? empresasPage = new EmpresasPage(driver) : empresasPage;
	}
	
	public VisualizarPage getVisualizarPage(){
		return (visualizarPage == null) ? visualizarPage = new VisualizarPage(driver) : visualizarPage;
	}
	
	
}
