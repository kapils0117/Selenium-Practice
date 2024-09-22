package testPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {

		// Invoking Chrome browser
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); //
		// applicable globally
		driver.manage().window().maximize();
		driver.navigate().to(("https://rahulshettyacademy.com/locatorspractice")); // accessing app url
		String s = driver.getTitle();
		System.out.println(s);

		// enter user name
		driver.findElement(By.id("inputUsername")).sendKeys("kapils0117@gmail.com");
		// enter password in text box
		driver.findElement(By.name("inputPassword")).sendKeys("admin@123");
		// click on signin button
		driver.findElement(By.className("signInBtn")).click();

	}
}