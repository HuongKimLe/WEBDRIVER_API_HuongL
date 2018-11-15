package selenium_api;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic09_HandleWindown {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void TC_01_WindowID() {

		driver.get("https://daominhdam.github.io/basic-form/index.html");
		String parentID = driver.getWindowHandle();
		System.out.println("Parent ID : " + parentID);

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		switchToChildWindowID(parentID);

		String googleTile = driver.getTitle();
		Assert.assertEquals(googleTile, "Google");

		driver.close();
		driver.switchTo().window(parentID);

		String parentTitle = driver.getTitle();
		Assert.assertEquals(parentTitle, "SELENIUM WEBDRIVER FORM DEMO");

	}

	@Test
	public void TC_02_WindowTitle() {

		driver.get("http://www.hdfcbank.com/");

		/* STEP 02- CHECK and close popup notificetion */
		
		String parentTitle = driver.getWindowHandle();

		List<WebElement> popupNotification = driver.findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
		if (popupNotification.size() > 0) {
			driver.switchTo().frame(popupNotification.get(0));
			WebElement closebutton = driver.findElement(By.xpath("//div[@id='div-close']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", closebutton);

			System.out.println("Click on x successful");
			driver.switchTo().defaultContent();

		}

		/* Click on Agri link and switch to new tab */

		driver.findElement(By.xpath("//a[text()='Agri']")).click();
		switchToWindowByTitle("HDFC Bank Kisan Dhan Vikas e-Kendra");
		isTilteDisplay("HDFC Bank Kisan Dhan Vikas e-Kendra");

		driver.findElement(By.xpath("//a[div[p[text()='Account Details']]]")).click();
		switchToWindowByTitle("Welcome to HDFC Bank NetBanking");
		isTilteDisplay("Welcome to HDFC Bank NetBanking");

		WebElement footer = driver.findElement(By.xpath("//frame[@name='footer']"));
		driver.switchTo().frame(footer);

		driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
		;
		switchToWindowByTitle("HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
		isTilteDisplay("HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");

		driver.findElement(By.xpath("//a[text()='CSR']")).click();
		;
		switchToWindowByTitle("HDFC BANK - CSR - Homepage");
		isTilteDisplay("HDFC BANK - CSR - Homepage");

		
		closeAllWithoutParentWindows(parentTitle);
		isTilteDisplay("HDFC Bank: Personal Banking Services");
	}

	@AfterClass
	public void afterClass() {

		// driver.quit();

	}

	public void switchToChildWindowID(String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("All ID Window:" + allWindows);
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public boolean closeAllWithoutParentWindows(String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public boolean isTilteDisplay(String tilte) {
		String currentTilte = driver.getTitle();
		boolean checkTilte = currentTilte.equals(tilte);
		Assert.assertTrue(currentTilte.equals(tilte));
		return checkTilte;
	}

	public void switchToWindowByTitle(String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
                    driver.switchTo().window(runWindows);
                    String currentWin = driver.getTitle();
                    if (currentWin.equals(title)) {
                                break;
                    }
        }
}

}
