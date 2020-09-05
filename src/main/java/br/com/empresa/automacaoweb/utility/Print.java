package br.com.empresa.automacaoweb.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Print {
	public static void captureScreenShot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(".\\Evidencias\\"
					+ System.currentTimeMillis() + ".png"));
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
