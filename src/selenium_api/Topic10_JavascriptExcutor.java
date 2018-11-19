package selenium_api;

import org.testng.annotations.Test;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic10_JavascriptExcutor {
	WebDriver driver;
	JavascriptExecutor javascript;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		javascript = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void TC_01_JavaScriptExcutor() {

		driver.get("http://live.guru99.com/");

		// Step 02
		String domain = (String) executeForBrowser("return document.domain");
		Assert.assertEquals(domain, "live.guru99.com");

		// Step 03
		String URl = (String) executeForBrowser("return document.URL");
		Assert.assertEquals(URl, "http://live.guru99.com/");

		// Step 04
		WebElement MobilLink = driver.findElement(By.xpath("//a[text()='Mobile']"));
		clickToElementByJS(MobilLink);

		// Step 05 Add Samsung Galaxy in cart
		WebElement SamsungAddCart = driver.findElement(By.xpath("//h2[a[text()='Samsung Galaxy']]/following-sibling::div[@class='actions']//button"));
		clickToElementByJS(SamsungAddCart);

		// Step 06 verify step 5
		String verifyMessage = (String) executeForBrowser("return document.documentElement.innerText");
		Assert.assertTrue(verifyMessage.contains("Samsung Galaxy was added to your shopping cart."));

		// Step 07 open privacy policy
		WebElement privacyPage = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
		clickToElementByJS(privacyPage);
		// navigateToUrlByJS("http://live.guru99.com/index.php/privacy-policy-cookie-restriction-mode/");
		String policyTilte = (String) executeForBrowser("return document.title");
		Assert.assertEquals(policyTilte, "Privacy Policy");

		// Step 08 Scroll cuoi page
		scrollToBottomPage();

		// Step 09 Verify
		// WebElement verifydata =
		// driver.findElement(By.xpath("//th[text()='WISHLIST_CNT']/following-sibling::td"));
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='WISHLIST_CNT']/following-sibling::td")).isDisplayed());

		// Step 10 Navigate to new page http://demo.guru99.com/v4/
		navigateToUrlByJS("http://demo.guru99.com/v4/");

		String newdomain = (String) executeForBrowser("return document.domain");
		Assert.assertEquals(newdomain, "demo.guru99.com");
	}

	
	public void TC_02_RemoveAttribute() throws Exception {

		String firstname = "Automation";
		String lasttname = "testing";

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");

		WebElement iframeResult = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(iframeResult);
		
		WebElement firstNameTextbox = driver.findElement(By.xpath("//input[@name='fname']"));
		sendkeyToElementByJS(firstNameTextbox, firstname);

		WebElement lastNameTextbox = driver.findElement(By.xpath("//input[@name='lname']"));
		removeAttributeInDOM(lastNameTextbox, "disabled");
		Thread.sleep(3000);
		
		sendkeyToElementByJS(lastNameTextbox, lasttname);
		
		WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
		clickToElementByJS(submitButton);
				
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'fname=Automation&lname=testing')]")).isDisplayed());
		
		System.out.println("co ra dc toi day ko?");
		
		//driver.switchTo().defaultContent();
		

	}

	@Test
	public void TC_03_CreateAnAccountByJS() {
		
		String Firstname ="Auto";
		String Lastname ="Testing";
		String Email = "Auto" + randomEmail() + "@gmail.com";
		String Pass ="123456789";
		String ConfirmPass ="123456789";
		

		driver.get("http://live.guru99.com/");
		
		WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		clickToElementByJS(myAccountLink);

		WebElement createAccountButton = driver.findElement(By.xpath("//span[text()='Create an Account']"));
		clickToElementByJS(createAccountButton);
		
		WebElement firstNametextbox = driver.findElement(By.xpath("//input[@id='firstname']"));
		sendkeyToElementByJS(firstNametextbox, Firstname);
		
		WebElement lastNametextbox = driver.findElement(By.xpath("//input[@id='lastname']"));
		sendkeyToElementByJS(lastNametextbox, Lastname);
		
		WebElement emailButton = driver.findElement(By.xpath("//input[@id='email_address']"));
		sendkeyToElementByJS(emailButton, Email);
		
		WebElement PassButton = driver.findElement(By.xpath("//input[@id='password']"));
		sendkeyToElementByJS(PassButton, Pass);
		
		WebElement confirmPassButton = driver.findElement(By.xpath("//input[@id='confirmation']"));
		sendkeyToElementByJS(confirmPassButton, ConfirmPass);
		
		WebElement registerButton = driver.findElement(By.xpath("//button[@title='Register']"));
		clickToElementByJS(registerButton);
		
		String registerMessSucc = (String) executeForBrowser("return document.documentElement.innerText");
		Assert.assertTrue(registerMessSucc.contains("Thank you for registering with Main Website Store."));
		//Assert.assertEquals(registerMessSucc, "Thank you for registering with Main Website Store.");
		
		WebElement AccountButton = driver.findElement(By.xpath("//span[text()='Account']"));
		clickToElementByJS(AccountButton);
		WebElement logOutButton = driver.findElement(By.xpath("//a[text()='Log Out']"));
		clickToElementByJS(logOutButton);
		
		//Wait 5s
	    try {
	    	TimeUnit.SECONDS.sleep(10);
	    } catch (InterruptedException e) {
	    	// TODO Auto- generated catch block
	    	e.printStackTrace();
	    }
		
		String verifySuss = (String) executeForBrowser("return document.title");
		Assert.assertEquals(verifySuss, "Home page");
		System.out.println("toi day hok");
	}

	@AfterClass
	public void afterClass() {

		// driver.quit();

	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public Object executeForBrowser(String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object clickToElementByJS(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object sendkeyToElementByJS(WebElement element, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object removeAttributeInDOM(WebElement element, String attribute) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object navigateToUrlByJS(String url) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.location = '" + url + "'");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	public int randomEmail() {
		Random rand = new Random();
		int number = rand.nextInt(10000);
		return number;

	}
}
