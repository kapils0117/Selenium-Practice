package testPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase3 {
	public static void main(String[] args) throws InterruptedException {

		// Invoking Chrome browser
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
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

		Thread.sleep(3000);
		// get error message text and display it (css selector classname)
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		// Third test case
		System.out.println(driver.findElement(By.linkText("Forgot your password?")));
		
		//Locate by link text
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Locate with any xpath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Kapil");
		
		
		//Problem : When multiple locators are found by Xpath and we want to select 2nd text box so provide 2nd index 
		//input[@placeholder=’ Username’’][2]
		Thread.sleep(4000);
		
		//Css selector with any attribute
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("1233");

		// Thread.sleep(3000);
		// driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");

	}

}

