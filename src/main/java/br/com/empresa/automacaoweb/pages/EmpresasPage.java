package br.com.empresa.automacaoweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class EmpresasPage {
	
	
	public EmpresasPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[.='Fast Shop']//following::button[contains(text(),'Ver elogios')]")
	private WebElement btnVerElogios;
	

}
