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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink2 {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icicibank.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());

		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);
			String urls = ele.getAttribute("href");
			
		
			if(urls==null|| urls.isEmpty()) {
				System.out.println("Not configured");
				continue;
			}

			URL url = new URL(urls);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			int rc = con.getResponseCode();
			if (rc >= 400) {
				System.out.println(urls + "is a broken link. Responce code " + rc);
			} else {
				System.out.println(urls + "is a valid link.Responce code " + rc);
			}
		}
	}
}
