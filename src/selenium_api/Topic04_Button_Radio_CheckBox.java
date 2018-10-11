package selenium_api;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic04_Button_Radio_CheckBox {

	WebDriver driver;
	String CustomerID;
	String CustomerName, Gender, Birthday, Address, City, State, Pin, Mobile, Email, Pass;
	String editAddress, editCity, editState, editPin, editMobile, editEmail;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		// Access vao trang http://demo.guru99.com/v4
		driver.get("http://demo.guru99.com/v4");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		CustomerName = "Automation Testing";
		Gender = "female";
		Birthday = "2000-01-02";
		Address = "fhagkf";
		City = "ho chi minh";
		State = "tan binh";
		Pin = "238748";
		Mobile = "0931723687";
		Email = "autotest" + randomEmail() + "@gmail.com";
		Pass = "aqAtAda";
		
		editAddress = "Bach Dang Street";
		editCity = "HCM City";
		editState ="TanBinh Distrist";
		editPin ="632367";
		editMobile ="0912345687";
		editEmail = "editemailtest" + randomEmail() + "@gmail.com";

	}

	@Test(enabled = true)
	public void CreateNewCustomer() {

		// Step 02: Login with User = mngr155533 | Pass = aqAtAda
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr155533");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("aqAtAda");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		// Verify login thanh cong

		 Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());

		driver.findElement(By.xpath("//a[text()='New Customer']")).click();

		// Create new customer
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(CustomerName);
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.id("dob")).sendKeys(Birthday);
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(Address);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(State);
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(Pin);
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(Mobile);
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	// Verify create new customer success with message
	Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).isDisplayed());

		// get thong tin Customer ID
		CustomerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
		System.out.println("Customer ID = :" + CustomerID);

		// verify create new customer with above information

		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), CustomerName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), Gender);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), Birthday);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), Address);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), City);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), State);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), Pin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), Mobile);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), Email);

	}

	@Test(enabled = true)
	public void EditCustomer() {
		
		
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		
		// Verify edit customer edit page
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Edit Customer']")).isDisplayed());
		
		// Verify Customer Name và Address đúng với dữ liệu khi tạo mới New Customer
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value"), CustomerName);
		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name='addr']")).getText(), Address);
		
		// nhap moi tat ca cac field 		
		
		driver.findElement(By.xpath("//input[@name='city']")).clear();
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(editCity);
		
		driver.findElement(By.xpath("//input[@name='state']")).clear();
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(editState);
		
		driver.findElement(By.xpath("//input[@name='pinno']")).clear();
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(editPin);
		
		driver.findElement(By.xpath("//input[@name='telephoneno']")).clear();
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(editMobile);
		
		driver.findElement(By.xpath("//input[@name='emailid']")).clear();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(editEmail);
		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer details updated Successfully!!!']")).isDisplayed());
		
		//Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), editAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), editCity);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), editState);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), editPin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), editMobile);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), editEmail);

	}

	@AfterClass
	public void afterClass() {
	}

	public int randomEmail() {
		Random rand = new Random();
		int number = rand.nextInt(10000);
		return number;

	}

}
