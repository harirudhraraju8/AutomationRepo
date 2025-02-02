package dataproviders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest1 {

	WebDriver driver;

	@Test(dataProvider ="loginData", dataProviderClass = DataSupplier.class)
	public void login(String un, String pwd) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']/parent::span")).isDisplayed());
		Thread.sleep(5000);
		driver.quit();
	}

	
//	@DataProvider()
//	public Object[][] loginData() {
//		Object[][] data = new Object[2][2];
//
//		data[0][0] = "Admin";
//		data[0][1] = "admin123";
//
//		data[1][0] = "Admin";
//		data[1][1] = "test123";
//		
//		return data;
//	}

}
