package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedbusFromAndTo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");

		WebElement ele = driver.findElement(By.xpath("//input[@id='src']"));
		ele.click();
		ele.sendKeys("Mum");

		List<WebElement> from = driver.findElements(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']"));
		System.out.println(from.size());
		for (int i = 0; i < from.size(); i++) {
			System.out.println(from.get(i).getText());
			Thread.sleep(5000);
			if (from.get(i).getText().contains("Mumbai")) {
				from.get(i).click();
				break;
			}
		}

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		WebElement ele1 = driver.findElement(By.xpath("//input[@id='dest']"));
		ele1.clear();
		ele1.sendKeys("Pu");

		List<WebElement> to = driver.findElements(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']"));
		System.out.println(to.size());
		for (int i = 0; i < to.size(); i++) {
			System.out.println(to.get(i).getText());
			Thread.sleep(5000);

			if (to.get(i).getText().contains("Pune")) {
				to.get(i).click();
				break;
			}
		}
	}
}
