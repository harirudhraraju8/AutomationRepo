package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2 {
	
	public static void main(String[] args) throws InterruptedException {
		
//		ChromeOptions options = new ChromeOptions();
//
//		//Add chrome switch to disable notification - "**--disable-notifications**"
//		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
 
		
		driver.findElement(By.xpath("//input[@type='text']")).click();
		/*
		 * Actions act=new Actions(driver);
		 * Actions().sendKeys(Keys.ESCAPE).build().perform();
		 */	
		Thread.sleep(5000);
		
		System.out.println("done");
		
	}

}
