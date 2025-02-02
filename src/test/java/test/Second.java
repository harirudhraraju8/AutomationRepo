package test;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Second {

	public static void main(String[] args) throws InterruptedException, SQLException {
 

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("disable-notifications");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");

		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		int val=3, val1=5;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//ul[@role='listbox']//li["+val+"]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//ul[@role='listbox']//li["+val1+"]")).click();
		System.out.println("Done");
		
		
		
		
		
//		Connection con=DriverManager.getConnection(null);
//		Statement stmt=con.createStatement();
//		
//		String query="Select*fromemp";
//		
//		ResultSet rs=stmt.executeQuery(query);
		
		
		
	}

}
