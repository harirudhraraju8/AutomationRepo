package calenders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderTest {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();

		new WebDriverWait(driver, 5)
		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-datepicker-div")));

		String monthYearValue=driver.findElement(By.className("ui-datepicker-title")).getText();

		System.out.println(monthYearValue); //January 2025
		String	month=monthYearValue.split(" ")[0].trim();
		String	year=monthYearValue.split(" ")[1].trim();

		while(!(month.equals("June") && year.equals("2026"))) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthYearValue=driver.findElement(By.className("ui-datepicker-title")).getText();

			System.out.println(monthYearValue); //January 2025
			month=monthYearValue.split(" ")[0].trim();
			year=monthYearValue.split(" ")[1].trim();
		}
		driver.findElement(By.xpath("//a[text()='23']")).click();
	}
}