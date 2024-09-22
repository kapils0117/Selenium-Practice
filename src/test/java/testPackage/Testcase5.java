package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase5 {

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
		//System.out.println(driver.findElement(By.linkText("Forgot your password?")));
		
		//Locate by link text
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Thread.sleep(3000);

		System.out.println(driver.findElement(By.xpath("//form/h2")).getText());
		//Locate with any xpath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Kapil");
		
		
		//Problem : When multiple locators are found by Xpath and we want to select 2nd text box so provide 2nd index 
		//input[@placeholder=’ Username’’][2]
		//Thread.sleep(2000);
		
		//Css selector with any attribute
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("1234343433");
		//Thread.sleep(2000);
		
		//Clear Command: clear text box data and insert another set of data in text field
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Rahul Shetty");
		//driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("12345");

		//Locate phone no using XPATH by parent to child with only Tags but without using attribute
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8099999988");
		
		//driver.findElement(By.className("reset-pwd-btn")).click();
		//OR   by css selector ->tagname.classname
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		//Locate phone no using CSS Selector by parent to child with only Tags but without using attribute
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
    // Thread.sleep(3000);
		// driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");

	}

}
