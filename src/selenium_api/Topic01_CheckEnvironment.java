package selenium_api;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic01_CheckEnvironment {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		// khoi tao data / pre- condition
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void TC_01_CheckBrowser() {
		// function for testcase
		driver.get("https://ciiva.com/");
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Electronic Part Selection and BOM Management");
	}


	@AfterClass
	public void afterClass() {
		// Clear data/ Quick browser
		driver.quit();
		
	}

}
