package selenium_api;

import org.testng.annotations.Test;

import java.util.List;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic05_HandleCustomerDropdown {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);

		

	}

	@Test(enabled = false)
	public void TS02CustomerDropdown() throws Exception {
		// Access vao trang http://demo.guru99.com/v4
				driver.get("https://daominhdam.github.io/basic-form/index.html");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();

		// Step 01: truy cap vao trang
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String itemExpected = "19";

		// Step 02:
		// Click vao locator cua dropdowm
		driver.findElement(By.xpath("//span[@id='number-button']")).click();
		Thread.sleep(3000);
		// get locator cua tat ca cac items trong dropdown
		List<WebElement> allItems = driver.findElements(By.xpath("//ul[@id='number-menu']//li[@class='ui-menu-item']/div"));
		int itemnumber = allItems.size();
		System.out.println(itemnumber);

		//
		for (int i = 0; i < itemnumber; i++) {
			System.out.println(allItems.get(i).getText());
			if (allItems.get(i).getText().equals(itemExpected)) {
				allItems.get(i).click();
			}
		}
		Thread.sleep(3000);

		// Step 6: verify item dc chon thanh cong
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='" + itemExpected + "']")).isDisplayed());
	}

	@Test(enabled = false)
	public void TC_ShortCustomerDropdown() throws Exception {

		// Step 01: truy cap vao trang
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		selectItemCustomerDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//li[@class='ui-menu-item']/div", "10");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='10']")).isDisplayed());		
		
	}
	@Test(enabled = false)
	public void TC_ShortCustomerDropdown2() throws Exception {

		// Step 01: truy cap vao trang
		driver.get("https://material.angular.io/components/select/examples");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		selectItemCustomerDropdown("//mat-select[@placeholder='State']", "//mat-option/span", "Washington");
		Assert.assertTrue(driver.findElement(By.xpath("//mat-select[@placeholder='State']//span[text()='Washington']")).isDisplayed());		
		
	}

	@Test(enabled = true)
	public void TC_ShortCustomerDropdown3() throws Exception {

		// Step 01: truy cap vao trang
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//String colour = "Orange";

		selectItemCustomerDropdown("//span[@aria-labelledby='color_label']", "//ul[@id='color_listbox']/li", "Orange");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='cap-view']//span[@class='k-widget k-dropdown k-header']//span[contains(text(),'Orange')]")).isDisplayed());		
		
	}	
	
	@Test(enabled = false)
	public void TC_ShortCustomerDropdown4() throws Exception {

		// Step 01: truy cap vao trang
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//String colour = "Orange";

		selectItemCustomerDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']/li", "Third Option");
		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Third Option')]")).isDisplayed());		
		
	}

	public void selectItemCustomerDropdown(String parentLocator, String allItemLocator, String ExpectedValue) throws Exception {
		
		// scroll xuong nhung item phia duoi
		WebElement parentDropdown = driver.findElement(By.xpath(parentLocator));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", parentDropdown);
		Thread.sleep(2000);
				
				
		List<WebElement> allItems = driver.findElements(By.xpath(allItemLocator));
		int itemnumber = allItems.size();

		// Wait for all items visiable
		wait.until(ExpectedConditions.visibilityOfAllElements(allItems));

		// 3- duyet qua tung item trong list element - get text

		for (int i = 0; i < itemnumber; i++) {
			System.out.println(allItems.get(i).getText());
			if (allItems.get(i).getText().equals(ExpectedValue)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", allItems.get(i));
				Thread.sleep(2000);
				allItems.get(i).click();
				break;
			}
		}
	}
	
	

	@AfterClass
	public void afterClass() {
	}

}
