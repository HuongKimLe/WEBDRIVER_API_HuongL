package selenium_api;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class exercise03 {
	
	  WebDriver driver;
	
	
  @BeforeClass
  public void beforeClass() {
	 // driver= new FirefoxDriver();	
	  System.setProperty("webdriver.chrome.driver", "C:\\\\Huong_Data\\\\Data\\\\Automating testing\\\\Software\\chromedriver.exe");
	  driver = new ChromeDriver();
	 
	  }
  @Test(enabled = false)
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
			ageRadioButton.click();
		}
  }

  @Test(enabled = false)
  public void CheckElementenableorEnable() {
	  
	  //Step 1: truy cap den trang http://daominhdam.890m.com/
	  
	  driver.get("http://daominhdam.890m.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  // Step 2: kiem tra cac phan tu enable tren trang: Email/ Age (Under 18)/ Education/ Job Role 01/ Interests (Development)/ Slider 01/ Button is enabled
	  // Email
	  WebElement emalTextBox2 = driver.findElement(By.xpath("//input[@id='mail']"));
	  isElementEnable(emalTextBox2);
	  //Age (Under 18)
	  WebElement ageRadioButton2 = driver.findElement(By.xpath("//input[@id='under_18']"));
	  isElementEnable(ageRadioButton2);
				
		// Education
		WebElement educationTextAre2 = driver.findElement(By.xpath("//textarea[@id='edu']"));
		isElementEnable(educationTextAre2);
		//Job Role 01
		
		WebElement Job1Select = driver.findElement(By.xpath("//select[@id='job1']"));
		isElementEnable(Job1Select);
	 
		//Interests (Development)
		WebElement Interestcheckbox = driver.findElement(By.xpath("//label[text()='Development' and @class ='light']"));
		isElementEnable(Interestcheckbox);
	  
		//
		WebElement Slide01Highlight = driver.findElement(By.xpath("//input[@id='slider-1']"));
		isElementEnable(Slide01Highlight);
		//
		WebElement ButtonisEnable = driver.findElement(By.xpath("//button[@id='button-enabled']"));
		isElementEnable(ButtonisEnable);
  }
	
  @Test(enabled = false)
public void CheckElementenableorDisable() {
	  
	  driver.get("http://daominhdam.890m.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
		
		// Kiểm tra các phần tử sau disable trên trang: Password / Age (Radiobutton is disabled)/ Biography/ 
		// Job Role 02/ Interests (Checkbox is disabled)/ Slider 02/ Button is disabled
		
		
		WebElement PassTextBox = driver.findElement(By.xpath("//input[@id='password']"));
		
		WebElement AgeRadioButtonDisable = driver.findElement(By.xpath("//input[@id='radio-disabled']"));
		
		WebElement BiographyTextAre = driver.findElement(By.xpath("//textarea[@id=\"bio\"]"));
		
		WebElement Job2Select = driver.findElement(By.xpath("//select[@id='job2']"));
		
		WebElement InterestcheckboxDisable = driver.findElement(By.xpath("//input[@id='radio-disabled']"));
		
		WebElement Slide02Highlight = driver.findElement(By.xpath("//input[@id='slider-2']"));
		
		WebElement ButtonisDisable = driver.findElement(By.xpath("//button[@id='button-disabled']"));
		
		isElementEnable(PassTextBox);
		isElementEnable(AgeRadioButtonDisable);
		isElementEnable(BiographyTextAre);
		isElementEnable(Job2Select);
		isElementEnable(InterestcheckboxDisable);
		isElementEnable(Slide02Highlight);
		isElementEnable(ButtonisDisable);
}
		
	  

@Test(enabled = true)
  public void CheckElementSelected() {
	  driver.get("https://daominhdam.github.io/basic-form/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  		WebElement ageRadioButton2 = driver.findElement(By.xpath("//input[@id='under_18']"));
	  		ageRadioButton2.click();
	  		
	  		//Interests (Development)
			WebElement Interestcheckbox = driver.findElement(By.xpath("//input[@value='interest_development']"));
			Interestcheckbox.click();
			//Assert.assertTrue(Interestcheckbox.isSelected());
												
			// Verify 
			isElementSelected(ageRadioButton2);
			isElementSelected(Interestcheckbox);			
			
	  
  }

  @AfterClass
  public void afterClass() {
	//  driver.quit();
  }
  
  public void isElementEnable(WebElement element) {
	  if (element.isEnabled()) {
		  System.out.println("Element is enabled");
	  } else {
		  System.out.println("Element is disabled");
	  }
  }
  
  public void isElementSelected(WebElement select) {
	  if(select.isSelected()) {
		  System.out.println("Element selected");
	  }else {
		  select.click();
	  }
  }
  
 }
