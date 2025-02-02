package calenders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderTest2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.redbus.in/");

		driver.findElement(By.id("onwardCal")).click();

		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//div[@class='DatePicker__MainBlock-sc-1kf43k8-1 hHKFiR']")));

		String monthYearValue = driver
				.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]")).getText();

		System.out.println(monthYearValue); // January 2025
		String month = monthYearValue.split(" ")[0].trim();
		String year = monthYearValue.split(" ")[1].trim();

		while (!(month.equals("Feb") && year.equals("2025"))) {
			driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][3]")).click();
			monthYearValue = driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][3]"))
					.getText();

			System.out.println(monthYearValue); // January 2025
			month = monthYearValue.split(" ")[0].trim();
			year = monthYearValue.split(" ")[1].trim();
		}
		driver.findElement(By.xpath("//span[text()='19']")).click();
	}
}