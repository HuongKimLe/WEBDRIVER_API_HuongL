package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic02_XpathCSS {
	

	
	WebDriver driver;
	
	
	 @BeforeClass
	  public void beforeClass() {
		 driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }
	  
  @Test
  public void TC_02() {
	  driver.get("http://live.guru99.com");
	  driver.findElement(By.xpath("//head[@title='Home Page']")).isDisplayed();
	  
	  
	  
	  
		/* <input 
		id="email" 
		class="input-text required-entry validate-email validation-failed" 
		type="email" 
		title="Email Address" 
		value="" 
		name="login[username]" 
		spellcheck="false" 
		autocorrect="off" 
	  //ID
	//  driver.findElement(By.id("email")).sendKeys("");
	//  driver.findElement(By.name("login[username]")).sendKeys("");
	  
// 	  driver.findElement(By.cssSelector("button[name='send']")).isDisplayed();
	  
	//  driver.findElement(By.cssSelector("input[id='email']")).isDisplayed();
	  
	//  driver.findElement(By.xpath("//button[@id='send2']"));
	  
	//  driver.findElement(By.xpath("//h2[@text()='New Here?']"));
	  
	
	
	  
  }
 */

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
