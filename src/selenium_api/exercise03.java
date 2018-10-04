package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class exercise03 {
	
	  WebDriver driver;
	
	
  @BeforeClass
  public void beforeClass() {
	
	 
	  }
  @Test
  public void CheckElementDisplay() {
	  
	  
	  // truy cap vao trang web
	  driver.get("http://daominhdam.890m.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  // Kiem tra cac phan tu hien thi tren trang: Email/Age(Under18)/ Education
	WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='mail']"));
		if(emailTextBox.isDisplayed()) {
			emailTextBox.sendKeys("Automation Testing");
		}
	 
	WebElement educationTextAre = driver.findElement(By.xpath("//textarea[@id='edu']"));
		if(educationTextAre.isDisplayed()) {
			educationTextAre.sendKeys("Automation Testing");
		}
	 
	WebElement ageRadioButton = driver.findElement(By.xpath("//input[@id='under_18']"));
		if(ageRadioButton.isDisplayed()) {
			ageRadioButton.clear();
		}
  }

  @Test
  public void CheckElementenableorDisable() {
  }
  @Test
  public void CheckElementSelected() {
  }

  @AfterClass
  public void afterClass() {
  }

}
