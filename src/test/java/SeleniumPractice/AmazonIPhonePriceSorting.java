package SeleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonIPhonePriceSorting {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");

		WebElement search_Box=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search_Box.sendKeys("Iphone14");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

		List<WebElement> iPhone_Price=driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		System.out.println(iPhone_Price.size());
		for(int i=0;i<iPhone_Price.size();i++) {

			String list=iPhone_Price.get(i).getText();
			System.out.println(list);
			
			
			
		}


	}

}
