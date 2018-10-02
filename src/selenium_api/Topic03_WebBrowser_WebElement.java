package selenium_api;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic03_WebBrowser_WebElement {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
	
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void TC_01_WebBrowserCommands() {
		
		/*BAT KI COMMAND NAO CO TIEN TO GET O DAU THI DEU PHAI TRA VE GIA TRI CHI CO DUY NHAT 1 COMMAND KO TRA VE GIA TRI LA (driver.get(Url)) */
		
		// Mo 1 duong link bất kì
		driver.get("https://ciiva.com/");
		
		// Tra ve duong link hien tai cua page do
		String HomePageURL = driver.getCurrentUrl();
		System.out.println(HomePageURL);
	
		// Muon kiem tra 1 element/ text nam trong page ma ko the locate
		
		String homePageSource = driver.getPageSource();
		Assert.assertTrue(homePageSource.contains("Your Dream was Never to Manage Parts"));
		System.out.println(homePageSource);
		
		// kiem tra dau vao/ dau ra co dung hay ko?
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Electronic Part Selection and BOM Management");
		
		// handle Windown/ popup. Dung de switch giua cac tab voi nhau
		driver.getWindowHandle();
		driver.getWindowHandles();
		
		// Wait cho element xuat hien trong 30s
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		// Wait cho page dc load thanh cong trong 30s
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		// Mo toan bo man hinh (F11)		
		driver.manage().window().fullscreen();
		
		//Mo rong cua so cua window
		driver.manage().window().maximize();
		
		driver.navigate().refresh();
		driver.navigate().forward();
		driver.navigate().back();	
		
		
		// handle alert se dc hoc sau
		driver.switchTo().alert();
		
		
	}
	@Test
	public void TC_021_WebElementCommands() {
	
		// Thao tac voi 1 element
		driver.findElement(By.xpath("//input[@id='LoginEmail']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='LoginEmail']")).clear();
		driver.findElement(By.xpath("//input[@id='LoginEmail']")).click();
	// => moi lan khai bao chi su dung dc 1 lan, neu muon sdung lai nhieu lan phai khai bao bien cho no
		
		WebElement element = driver.findElement(By.xpath("//input[@id='LoginEmail']"));
		
		// Xoa data trong textbox
		element.clear();
		
		// Nhap du lieu vao textbox
		element.sendKeys("");
		
		
		// Thao tac voi 1 list element
		driver.findElements(By.xpath("")).get(1);
		
		driver.findElement(By.xpath("//div[@class='form form-sign-in']")).findElement(By.xpath("//input[@id='LoginEmail']")).sendKeys("");
		driver.findElement(By.xpath("//div[@class='form form-sign-in']//input[@id='LoginEmail']")).sendKeys("");
				
		// get ra du lieu nam trong 1 attribute
		String SmartPartSearch = element.getAttribute("data-content");
		
		// font/ size/ color... check giao dien
		WebElement SmartPartSearchButton = driver.findElement(By.xpath("//input[@value='SmartParts Search']"));
		String SmartPartSearchButtonColour = element.getCssValue("background");
		// #3788d3 none repeat scroll 0 0
		
		// Lay ra vi tri cua element nam trong do phan giai man hinh
		element.getLocation();
		
		// lay ra chieu cao, chieu rong cua element.
		element.getSize();
		
		//
		WebElement FormEmailErrorMessage = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']"));
		String FormEmailErrorMessageText = FormEmailErrorMessage.getText();
		Assert.assertEquals(FormEmailErrorMessage, "This is a required field.");
		
		
		// Kiem tra 1 element co hien thi hay khong => cho tat ca cac loai element
		
		element.isDisplayed();
		// luon luon di chung voi ham assertTrue, assertFalse
		Assert.assertTrue(element.isDisplayed());
		
		// kiem tra 1 element co enable hay disable hay ko? => textbox/ textarea/ radiobutton/ dropdown
		Assert.assertTrue(element.isEnabled()); // element dc enable
		Assert.assertFalse(element.isEnabled()); // element bi disable
		
		
		
		// kiem tra 1 element co dc chon hay chua => checkbox/ radiobutton
		Assert.assertTrue(element.isSelected()); // element dc chon
		Assert.assertFalse(element.isSelected()); // element ko dc chon
		
		
		//tuong duong voi hanh dong enter trng 1 form
		element.submit();
	}

	
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
		
	}

}
