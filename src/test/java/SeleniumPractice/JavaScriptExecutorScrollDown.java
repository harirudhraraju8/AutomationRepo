package SeleniumPractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorScrollDown {

	public static void main(String[] args) throws InterruptedException { 


		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
 
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;

		//1.scroll down page by pixel number
		//		js.executeScript("window.scrollBy(0,1500)", "");
		//		System.err.println(js.executeScript("return window.pageYOffset;"));

		//2.scroll the page till element is visible

		//		WebElement ele=driver.findElement(By.xpath("//strong[text()='Community poll']"));
		//		
		//		js.executeScript("arguments[0].scrollIntoView();", ele);
		//		System.err.println(js.executeScript("return window.pageYOffset;"));


		//3.scroll page till end of the page

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));

		Thread.sleep(1000);	
		
		//4. back  to position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

		System.out.println("done");
	}

}
