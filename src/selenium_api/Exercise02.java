package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Exercise02 {
	WebDriver  driver;
	String email;
	
 @BeforeClass
	  public void beforeClass() {
	 
	 driver = new FirefoxDriver();	 
	 
	  } 
/*
  @Test
  public void TC01_VerifyURLandTitle() {
	  
	  //truy cap vao trang web
	  driver.get("http://live.guru99.com");
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  // kiem tra title cua page
	  String checkTitle = driver.getTitle();
	  Assert.assertEquals(checkTitle, "Home page");
	  
	  // Click vao myaccount de toi trang dang nhap	  
	 // driver.findElement(By.tagName("//a[@title='My Account']")).click();
	 driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  
	  
	  // click len create an accout button de den trang dang ki tai khoan
	  driver.findElement(By.xpath("//a[@title='Create an Account']")).click();	  
	  driver.navigate().back();
	  
	  String PageLogin = driver.getCurrentUrl();
	  Assert.assertEquals(PageLogin, "http://live.guru99.com/index.php/customer/account/login/");	  
	  driver.navigate().forward();
	  
	  String getURL = driver.getCurrentUrl();
	  Assert.assertEquals(getURL, "http://live.guru99.com/index.php/customer/account/create/");
	  
			   
  }
  
  

 @Test
 public void TC02_LoginEmpty() {
	  
	  driver.get("http://live.guru99.com/");
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	 
	 String VerifyErrMessUser = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	 Assert.assertEquals(VerifyErrMessUser, "This is a required field." );
	 
	 String VerifyErrMessPass = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
	 Assert.assertEquals(VerifyErrMessPass, "This is a required field." );
 }
 
  @Test
  public void TC03_LoginInvalidEmail() {
	  driver.get("http://live.guru99.com/");	
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
		  
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  
	  String emailErroMess = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText();
	  Assert.assertEquals(emailErroMess, "Please enter a valid email address. For example johndoe@domain.com.");
		  
  }
 
  @Test
  public void TC04_LoginPasswordIncorrecr() {
	  	 
	  driver.get("http://live.guru99.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
	  
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  
	  String PassErrMes = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
	  Assert.assertEquals(PassErrMes, "Please enter 6 or more characters without leading or trailing spaces.");
	  
  }
 
  */
  
 public int randomData() {
	  Random random = new Random();
	  int number = random.nextInt(99999);
	  return number;
	  
 }
  @Test
  public void TC05_CreatenewAccout() {
	  	
	  driver.get("http://live.guru99.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  
	  driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	  
	  driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("LeHuong1");
	   
	  driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Huong1");
	  	  
	  driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Le1");
	
	  // Format: xxxx@xxx.com
	  String email = "selenium061" + randomData() + "@gmail.com";
	  //System.out.println(email);	  
	  driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
	  
	  	  
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234567890");
	  	  
	  driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("1234567890");
	  	  
	  driver.findElement(By.xpath("//button[@title='Register']")).click();
	  
	  // Verify successful message
	  String mess =  driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText();
	  Assert.assertEquals(mess, "Thank you for registering with Main Website Store.");
	  
	  // Log out
	  driver.findElement(By.xpath("//span[text()='Account' and @class='label']")).click();
	  driver.findElement(By.xpath("//a[@title='Log Out']")).click();
	  
	  // Step 08
	  //Wait 5s
	    try {
	    	TimeUnit.SECONDS.sleep(10);
	    } catch (InterruptedException e) {
	    	// TODO Auto- generated catch block
	    	e.printStackTrace();
	    }
	  
	    
	    // Verify navigative to Home Page
	  String checkTitle = driver.getTitle();
	  Assert.assertEquals(checkTitle, "Home page");
	  
  }

  @AfterClass
  public void afterClass() {
	 // driver.quit();
  }
  
  

}
