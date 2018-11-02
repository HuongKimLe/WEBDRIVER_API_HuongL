package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class Topic07_Button_Radio_Checkbox_Alert {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
	//	driver = new FirefoxDriver();

		// Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Huong_Data\\Data\\Automating testing\\Software\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public void TS01_Button() throws Exception {

		// Step 01: Truy cap vao trang web
		driver.get("http://live.guru99.com/");
		Thread.sleep(2000);

		// Step 02:
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		clickElementByJavascript(myAccount);
		Thread.sleep(2000);

		// Step 03: check click vao link thanh cong

		WebElement loginForm = driver.findElement(By.xpath("//form[@id='login-form']"));
		Assert.assertTrue(isFormDisplayed(loginForm));

		// Step 04: Click vao button create an account

		WebElement createAccountButton = driver.findElement(By.xpath("//span[text()='Create an Account']"));
		clickElementByJavascript(createAccountButton);
		Thread.sleep(2000);

		// Step 05: kiem ttra click vao thanh cong

		WebElement createAccountForm = driver.findElement(By.xpath("//form[@id='form-validate']"));
		Assert.assertTrue(isFormDisplayed(createAccountForm));
	}
@Test
	public void TS02_CheckBox() throws Exception {

		// Step 01: Truy cap vao trang web
		driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
		Thread.sleep(2000);

		// Step 02: Click vao checkbox
		WebElement checkbox = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input"));
		clickElementByJavascript(checkbox);

		// Step 03: kiem tra checkbox da chon
		Assert.assertTrue(checkbox.isSelected());
		Thread.sleep(3000);

		// Step 04: Uncheck checkbox Dual-zone air conditioning
		if (checkbox.isSelected()) {
			clickElementByJavascript(checkbox);
		}
		Thread.sleep(3000);

		// Step 05: kiem tra da uncheck dc chua
		Assert.assertFalse(checkbox.isDisplayed());

	}

	
	public void TS03_RadioButton() throws Exception {

		// Step 01: Truy cap vao trang web
		driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
		Thread.sleep(2000);

		// Step 02: Click vao radio button 2.0 Petrol, 147kW
		WebElement radioButton = driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input"));
		clickElementByJavascript(radioButton);

		// Step 03: kiem tra da dc chon chua
		Assert.assertTrue(radioButton.isSelected());

		// Step 03: kiem tra radio da chon chua neu chua thi chon lai
		
		if(radioButton.isSelected()) {
			System.out.println("Da chon thanh cong");
		}else {
		radioButton.click();	
	}
		Thread.sleep(3000);	

	}
	
	public void TS04_Alert() throws Exception {

		// Step 01: Truy cap vao trang web
		driver.get("https://daominhdam.github.io/basic-form/");
		// Step02: click JS Alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alertJS = driver.switchTo().alert();
		String JSAlertMess = alertJS.getText();
		Assert.assertEquals(JSAlertMess, "I am a JS Alert");
		alertJS.accept();
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result' and text()='You clicked an alert successfully ']")).isDisplayed());
		Thread.sleep(4000);
		
		// Step 03: Click vao JS Confirm
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert alertJsConfirm = driver.switchTo().alert();
		String JSConfrimMess = alertJsConfirm.getText();
		Assert.assertEquals(JSConfrimMess, "I am a JS Confirm");
		alertJsConfirm.accept();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='result' and text()='You clicked: Ok']")).isDisplayed());
		Thread.sleep(4000);
		
		// Strep 04: Click vao JS Prompt
		String text = "ABC Test";
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alertJSPrompt = driver.switchTo().alert();
		
		String JSPromptMess = alertJSPrompt.getText();
		Assert.assertEquals(JSPromptMess, "I am a JS prompt");
		
		alertJSPrompt.sendKeys(text);		
		alertJSPrompt.accept();
		
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='result' and text()='You entered: "+ text +"']")).isDisplayed());
	}
	
	
	
	public void TS05_AuthenAlert() throws Exception {

		// Step 01: Truy cap vao trang web
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth/");
		
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Basic Auth']")).isDisplayed());
		

		
	}

	@AfterClass
	public void afterClass() {
	}

	public void clickElementByJavascript(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

	public boolean isFormDisplayed(WebElement element) {
		return element.isDisplayed();
	}

}
