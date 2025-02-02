package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");

		System.out.println(driver.findElements(By.tagName("frame")).size());

		//frame1
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("God");
		System.out.println("Done 1st frame");

		driver.switchTo().defaultContent();// go back to main page


		//frame2

		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));

		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Shiva");
		System.out.println("Done 2st frame");

		driver.switchTo().defaultContent();
	}


}
