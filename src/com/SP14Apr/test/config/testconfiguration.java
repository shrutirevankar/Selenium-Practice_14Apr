package com.SP14Apr.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SP14Apr.utils.DataHandlers;

public class testconfiguration {
	
	public static WebDriver getInstance()
	 {
		 WebDriver driver = null;
		 String browserType = DataHandlers.getDataFromPropertyFile("configuration","browser");
		 String url =DataHandlers.getDataFromPropertyFile("configuration", "url");
		 if (browserType.equalsIgnoreCase("Firefox"))
		 {
			 System.setProperty("Webdriver.Firefox.marionette","./browser.servers/geckodriver.exe");
			 driver = new FirefoxDriver();
			 
		 }
		 else if (browserType.equalsIgnoreCase("Chrome"))
			 
		 {
			System.setProperty("Webdriver.Chrome.driver","./browser.servers/chromedriver.exe");
			driver = new ChromeDriver();
			
		 }
		 else
		 {
			 System.err.println("Invalid browser type");
			 
		 }
		 //driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.get(url);
		 return driver;
		 
	 }

}
