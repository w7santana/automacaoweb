package br.com.empresa.automacaoweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter //Anotação do lombok que gera getters automaticamente
public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "navbarDropdown")
	private WebElement btnLogin;
	
	@FindBy(id = "exampleDropdownFormEmail2")
	private WebElement campoEmail;
	
	@FindBy(id = "exampleDropdownFormPassword2")
	private WebElement campoSenha;
	

}
