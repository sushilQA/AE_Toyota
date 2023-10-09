package org.testing.Base;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties properties;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sushil.k\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\sushil.k\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
		this.driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://toyotadev.hsc.alertenterprisecloud.com/?IsAlertUser=true");
		Thread.sleep(6000);
		this.properties = LoadPropertiesFile.handlePropertyFile("../AE_Toyota/ObjectRepositery.properties");
		Thread.sleep(6000);

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
