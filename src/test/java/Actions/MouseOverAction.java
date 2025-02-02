package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverAction {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/en-gb?route=common/home");


		WebElement desktops=driver.findElement(By.xpath("//a[text()='Desktops']"));
		WebElement mac=driver.findElement(By.xpath("//a[text()='Mac (1)']"));

		Actions act=new Actions(driver);
		//MouseOver
		//act.moveToElement(desktops).moveToElement(mac).click().build().perform();
		act.moveToElement(desktops).moveToElement(mac).click().perform();



	}

}
