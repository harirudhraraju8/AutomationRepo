package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedbusFromAndTo2 {

	public static void main(String[] args) throws InterruptedException {

		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");

		WebElement ele = driver.findElement(By.xpath("//input[@id='src']"));
		ele.clear();
		ele.click();
		ele.sendKeys("Mum");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']//parent::ul")).click();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		WebElement ele1 = driver.findElement(By.xpath("//input[@id='dest']"));
		ele1.clear();
		ele1.sendKeys("Pu");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='sc-iwsKbI jTMXri cursorPointing']/parent::ul")).click();
		System.out.println("done");
	}
}

