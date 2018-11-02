package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic07_UserInteractions {
	WebDriver driver;
	Actions action;

	@BeforeClass
	public void beforeClass() {

		// driver = new FirefoxDriver();
		// chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Huong_Data\\Data\\Automating testing\\Software\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		action = new Actions(driver);

	}

	public void Tc01_HoverMouse() throws Exception {

		driver.get("http://www.myntra.com/");
		WebElement loginicon = driver.findElement(By.xpath("//div[@class='desktop-userIconsContainer']"));
		action.moveToElement(loginicon).perform();

		WebElement loginbutton = driver.findElement(By.xpath("//a[text()='login']"));
		action.click(loginbutton).perform();
		Thread.sleep(3000);

		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Login to Myntra']")).isDisplayed());
	}

	public void Tc02_ClickAndHold() throws Exception {

		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");

		// Click and hold from 1 to 4

		List<WebElement> numberList = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		System.out.println(numberList.size());
		action.keyDown(Keys.CONTROL).click(numberList.get(0)).click(numberList.get(6)).click(numberList.get(9)).keyUp(Keys.CONTROL).perform();

		// action.clickAndHold(numberList.get(0)).moveToElement(numberList.get(3)).release().perform();
		Thread.sleep(3000);

		List<WebElement> numberSelected = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));

		System.out.println(numberSelected.size());
		// Assert.assertEquals(numberSelected.size(), 4);

		// Click any item
		Assert.assertEquals(numberSelected.size(), 3);

	}

	public void Tc03_DoubleClick() throws Exception {

		driver.get("http://www.seleniumlearn.com/double-click");

		WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me!']"));
		action.doubleClick(doubleClickButton).perform();
		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "The Button was double-clicked.");

		Thread.sleep(3000);
		alert.accept();

	}

	public void Tc04_RightClick() throws Exception {

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		action.contextClick(rightClick).perform();

		// Thread.sleep(3000);
		// Verify Quit display and not hover mouse
		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') and not(contains(@class,'context-menu-hover'))]")).isDisplayed());

		// Hover mouse to Quit
		action.moveToElement(rightClick).perform();

		// Verify Quit visible and hover mouse
		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') and contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]")).isDisplayed());

		// Click vao Quit button
		action.click(rightClick).perform();

		// check alert display
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "clicked: quit");
		alert.accept();

	}

	@Test
	public void Tc05_DragAndDrop() throws Exception {

		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");

		WebElement Drag = driver.findElement(By.xpath("//div[@id='droptarget']"));
		WebElement Drop = driver.findElement(By.xpath("//div[@id='draggable']"));

		action.dragAndDrop(Drop, Drag).perform();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='droptarget' and contains(text(),\"You did great!\")]")).isDisplayed());
	}
	
	
	public void Tc06_DragAndDrop2() throws Exception {

		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");

		WebElement Drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement Drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		action.dragAndDrop(Drag, Drop).perform();
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='droppable']/p[text()='Dropped!']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
	}

}
