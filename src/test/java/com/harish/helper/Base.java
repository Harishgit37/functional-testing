package com.harish.helper;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	public String proPath= ".//src//test//resources//configfiles//property.properties";
	public String browser = "browser";
	public String browserName1 = "chrome";
	public String browserName2 = "firefox";
	public String browserName3 = "edge";
	public String ssPath = "screenshotpath";
	public String dPath = "demopath";
	public String udPath = "udPath" ;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public String url = "url";
	public ChromeOptions chromeOptions = new ChromeOptions();
	public FirefoxOptions firefoxOptions = new FirefoxOptions();
	public EdgeOptions edgeOptions = new EdgeOptions();
	public FileInputStream fileInputStream;
	
	
	public String getProperty(String name) throws IOException  {
		
	    this.fileInputStream = new FileInputStream(this.proPath);
		Properties pro = new Properties();
		pro.load(fileInputStream);
		return pro.getProperty(name);	
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		 String browser = this.getProperty(this.browser);
		 
		 if(browser.equals(browserName1)){
			 
	            driver = new ChromeDriver();
	            
	        }else if (browser.equals(browserName2)) {
	        	
	            driver = new FirefoxDriver();
	            
	        }else if (browser.equals(browserName3)){
	        	
	            driver = new EdgeDriver();
	        }
		 
	        driver.get(this.getProperty(this.url));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().window().maximize();

	}
	
	@AfterMethod
	public void tearDown(){
		
		//driver.quit();
	}
}
