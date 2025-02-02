package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElement {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		WebElement ele=driver.findElement(By.xpath("//textarea[@name='q']"));
		Thread.sleep(2000);
		ele.sendKeys("om");
		
		driver.findElement(By.xpath("//a[text()='About']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		ele=driver.findElement(By.xpath("//textarea[@name='q']"));
		
		ele.sendKeys("om");
		System.out.println("done");
		
		
	}

}
