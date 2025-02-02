package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");


		WebElement button=driver.findElement(By.xpath("//span[text()='right click me']"));

		Actions act=new Actions(driver);
		//right click
		act.contextClick(button).build().perform();
		System.out.println("Right click done");

		//click pn copy
		driver.findElement(By.xpath("//span[text()='Copy']")).click();


		Thread.sleep(5000);
		//close the alert box
		driver.switchTo().alert().accept();


	}
}