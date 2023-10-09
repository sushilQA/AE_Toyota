package org.testing.Pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.utilities.RandomNumberGenerator;
import org.testing.utilities.ScreenShotCaptured;

public class Login {
	
	Properties properties;
	WebDriver driver;
	public Login(Properties properties, WebDriver driver)
	{
		this.properties = properties;
		this.driver = driver;
	}
	
	public void backendUerLogIn(String userName , String password) throws IOException
	{
		try {
			driver.findElement(By.xpath(properties.getProperty("UserName"))).sendKeys(userName);
			Thread.sleep(1000);
			driver.findElement(By.xpath(properties.getProperty("Password"))).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(By.xpath(properties.getProperty("LogIn"))).click();
			Thread.sleep(10000);

			}catch(Exception exception)
			{
				ScreenShotCaptured.takeScreenShot("../AE_Toyota/src/test/java/org/testing/ScreenShots/"+RandomNumberGenerator.randomNumber()+".png", driver);
				System.out.println("There is an Exception in Code :"+exception);
			}
	}

}
