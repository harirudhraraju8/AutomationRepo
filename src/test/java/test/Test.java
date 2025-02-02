package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icicibank.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (WebElement link : links) {

			String urls = link.getAttribute("href");

			if (urls == null || urls.isEmpty()) {
				System.out.println("url is not configured");
				continue;
			}
			try {
				URL url = new URL(urls);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setConnectTimeout(3000);
				con.connect();
				int rc = con.getResponseCode();

				if (rc >= 400) {
					System.out.println(urls + "  	is a broken link. Responce code is : " + rc);
				} else {
					System.out.println(urls + " is a vaid link. Responce code is : " + rc);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
