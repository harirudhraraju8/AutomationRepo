package SeleniumPractice;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAddTocart {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");


		WebElement search_Box=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search_Box.sendKeys("Iphone14");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

		driver.findElement(By.xpath("(//span[text()='Apple iPhone 14 (128 GB) - Starlight'])[3]")).click();

		Set<String> sets=driver.getWindowHandles();

		ArrayList<String> ar=new ArrayList<>(sets);
		System.out.println(ar.get(0));
		System.out.println(ar.get(1)); 

		driver.switchTo().window((String)ar.get(1));

		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		System.out.println("Done");












	}

}
