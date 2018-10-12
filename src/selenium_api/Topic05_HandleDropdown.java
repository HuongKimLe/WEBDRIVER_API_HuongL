package selenium_api;

import org.testng.annotations.BeforeClass;





import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic05_HandleDropdown {

	WebDriver driver;
	

	@BeforeClass
	public void beforeClass() {
		
		driver = new FirefoxDriver();
		
		// Access vao trang http://demo.guru99.com/v4
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
		
	
	}

	public void TS01DropdownList() {
		
		//Step 01
		Select select = new Select(driver.findElement(By.xpath("//select[@id='job1']")));
		
		//Step 02 - Kiểm tra dropdown Job Role 01 không hỗ trợ thuộc tính multi-select
		Assert.assertFalse(select.isMultiple());
		
		//Step 03 - Chọn giá trị Automation Tester trong dropdown bằng phương thức selectVisible
		select.selectByVisibleText("Automation Tester");
		
		//Step 04 - Kiểm tra giá trị đã được chọn thành công
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Automation Tester");
		
		//Step 05 - Chọn giá trị Manual Tester trong dropdown bằng phương thức selectValue
		select.selectByValue("manual");
		
		//Step 06 - Kiểm tra giá trị đã được chọn thành công
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Manual Tester");
		
		//Step 07 - Chọn giá trị Mobile Tester trong dropdown bằng phương thức selectIndex		
		select.selectByIndex(3);
		
		//Step 08 - Kiểm tra giá trị đã được chọn thành công
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Mobile Teste");
		
		//Step 09 - Kiểm tra dropdown có đủ 5 giá trị
		select.getAllSelectedOptions();
		Assert.assertEquals(select.getAllSelectedOptions(), 5);
		
		
	}
    public void TS02CustomerDropdown() {
		
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
