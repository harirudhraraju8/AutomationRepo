package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Icici {

	public static void main(String[] args) throws InterruptedException {


		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icicibank.com/");

		 int val=7;
   
		 
		WebElement ser=driver.findElement(By.xpath("//div[@class='menu-v3-inner']//following-sibling::nav/ul/li["+val+"]"));
		//WebElement ele=driver.findElement(By.xpath("//span[text()='Insurance']"));
		WebElement ele1=driver.findElement(By.xpath("//a[text()='View All Insurances']"));

		Actions act=new Actions(driver);
		act.moveToElement(ser).build().perform();
		Thread.sleep(5000);
		act.moveToElement(ele1).click().build().perform();
		System.out.println("Done");







	}

}
