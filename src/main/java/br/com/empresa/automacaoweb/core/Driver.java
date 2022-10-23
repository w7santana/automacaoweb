package br.com.empresa.automacaoweb.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return (driver == null) ? createDriver() : driver;
	}

	private static WebDriver createDriver() {
		driver = WebDriverManager.chromedriver().create();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
