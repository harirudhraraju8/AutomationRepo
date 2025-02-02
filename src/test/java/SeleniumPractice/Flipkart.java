package SeleniumPractice;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

		WebElement search_Box = driver.findElement(By.name("q"));
		search_Box.sendKeys("iphone 15 pro max");
		search_Box.submit();

		String mainPage = driver.getWindowHandle();
		System.out.println("Main Page=" + mainPage);

		driver.findElement(By.xpath("//div[text()='Apple iPhone 15 Pro Max (White Titanium, 512 GB)']")).click();

		Set<String> allPages = driver.getWindowHandles();

		for (String page : allPages) {
			if (!page.equals(mainPage)) {
				driver.switchTo().window(page);
				break;
			}
			System.out.println(driver.getCurrentUrl());

			List<WebElement> products = driver.findElements(By.xpath("//div[@class='xFVion']//ul//li"));
			System.out.println(products.size());

//			for (WebElement product : products) {
//				System.out.println(product.getText());
//			}
		}

	}

}
