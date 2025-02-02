package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorSendKeysAndClick {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys("God");
		
		WebElement inputBox=driver.findElement(By.xpath("//input[@id='name']"));
		
		
		//passing the text into text field - alternative of sendkeys(). 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value', 'God')", inputBox);
		
		//cliking -alternative way
		WebElement radiobbtn=driver.findElement(By.xpath("//input[@id='male']"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()",radiobbtn);
		

	}

}
