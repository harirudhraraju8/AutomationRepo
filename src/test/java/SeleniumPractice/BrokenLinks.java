package SeleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("disable-notifications");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (WebElement link : links) {
			String urls = link.getAttribute("href");
			if (urls == null || urls.isEmpty()) {
				System.out.println("url is not configured"); 
				continue;
			}

			URL url = new URL(urls);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();
			int rc = httpURLConnection.getResponseCode();
			if (rc >= 400) {
				System.out.println(urls + "is a broken link. Responce code  " + rc);
			} else {
				System.out.println(urls + "is a valid link. Responce code " + rc);
			}
		}
	}
}
