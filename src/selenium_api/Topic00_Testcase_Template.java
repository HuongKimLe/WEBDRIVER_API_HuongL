package selenium_api;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic00_Testcase_Template {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
	
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void TC_01_CheckBrowser() {
	
		driver.get("");
		
	}


	@AfterClass
	public void afterClass() {
		
		driver.quit();
		
	}

}
