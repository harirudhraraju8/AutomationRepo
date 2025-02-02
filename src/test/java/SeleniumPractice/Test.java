package SeleniumPractice;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		for(WebElement ele: links) {
			String urls=ele.getAttribute("href");
			
			if(urls==null || urls.isEmpty()) {
				System.out.println("Not configured");
				continue;
			}
			
			URL url=new URL(urls);
			HttpsURLConnection hc=(HttpsURLConnection) url.openConnection();
			
			
			hc.connect();
			int rc=hc.getResponseCode();
			
			if(rc>=400) {
				System.out.println(rc+" "+"is a roken"+urls);
			}else{
				System.out.println(rc+" "+"is not a broken"+urls);
			}
			
			
			
			
			
			
		}
	
		
		
		
		
		
		

	}

}
