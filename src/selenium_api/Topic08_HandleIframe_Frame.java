package selenium_api;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic08_HandleIframe_Frame {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		// khoi tao data / pre- condition
		driver = new FirefoxDriver();
		// Khoi tao Chrome
//		
//		System.setProperty("webdriver.chrome.driver", "C:\\\\Huong_Data\\\\Data\\\\Automating testing\\\\Software\\\\chromedriver.exe");
//		driver = new ChromeDriver();
//		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void TC_01_Iframe() {
		
		driver.get("http://www.hdfcbank.com/");
		
		/*----------------------Step 02--------------------*/
		
		System.out.println("Step 02");
		List <WebElement> popupNotification = driver.findElements(By.xpath("//iframe[id='vizury-notification-template']"));
		System.out.println("List elements popup:" + popupNotification.size());	
		
		 if (popupNotification.size()> 0) {
			driver.switchTo().frame(popupNotification.get(0));
			WebElement closebutton = driver.findElement(By.xpath("//div[@id='div-close']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", closebutton);
			
			System.out.println("Click on x successful");
			driver.switchTo().defaultContent();
		 }
		 /*----------------------Step 03--------------------*/
		 
		 System.out.println("Step 03");
		 	
		 WebElement flipbannerwrap = driver.findElement(By.xpath("//div[@class='flipBannerWrap']//iframe"));
		 driver.switchTo().frame(flipbannerwrap);
		 
		 Assert.assertTrue(driver.findElement(By.xpath("//span[@id='messageText' and contains(text(),'What are you looking for?')]")).isDisplayed());
		 driver.switchTo().defaultContent();
		 
		 /*----------------------Step 04--------------------*/
		 
		 System.out.println("Go to Step 04");
		 WebElement slidingBanner = driver.findElement(By.xpath("//div[@class='slidingbanners']//iframe"));
		 driver.switchTo().frame(slidingBanner);
		 List <WebElement> bannerImageList = driver.findElements(By.xpath("//div[@id='productcontainer']//img"));		 
		 Assert.assertEquals(bannerImageList.size(), 6);
		 driver.switchTo().defaultContent();
		 
		 /*----------------------Step 05--------------------*/
		 
		 System.out.println("Go to Step 05");
		 
		 List <WebElement> FlipBannerList = driver.findElements(By.xpath("//div[@class='flipBanner']//img[@class='front icon at-element-click-tracking']"));
		 Assert.assertEquals(FlipBannerList.size(), 8);
		
		
	}


	@AfterClass
	public void afterClass() {
		// Clear data/ Quick browser
	//	driver.quit();
		
	}

}
