package testPackage;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase7 {

	public static void main(String[] args) throws InterruptedException {

		String name= "kapil";
		String actualTitle="Rahul Shetty Academy - Login page";
         WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); //
		
		
		driver.manage().window().maximize();
		
		driver.navigate().to(("https://rahulshettyacademy.com/locatorspractice")); // accessing app url
		
	
		System.out.println(driver.getWindowHandle());
		String expectedTitle = driver.getTitle();
		
		System.out.println(expectedTitle);
		
		
		//Hard Assert
		Assert.assertEquals(actualTitle, expectedTitle);
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		Thread.sleep(3000);
		//isDisplayed() Method- checked sign in text is present or not
//		WebElement wb= driver.findElement(By.xpath("//form/h1"));
//		System.out.println(wb.isDisplayed());
		
		Boolean ds= driver.findElement(By.xpath("//form/h1")).isDisplayed();
		System.out.println(ds);
		//isEnables() Method- checked if text field is enable or not

		WebElement textbox= driver.findElement(By.id("inputUsername"));
		System.out.println(textbox.isEnabled());
		
		driver.findElement(By.id("visitUsTwo")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
//		for (String wind:windows)
//		{
//			System.out.println(wind);
//		}
		Iterator i = windows.iterator();
		while(i.hasNext()) {
			
			System.out.println(i.next());
			
		}
		

	   // driver.findElement(By.className("signInBtn")).click();
	    
	   
	    //Tag locator 
	    System.out.println(driver.findElement(By.tagName("p")).getText());
	    
	    //Hard Assertion : verify actual result is equal to expected result
	    Assert.assertEquals(driver.findElement(By.cssSelector("p[style*='color']")).getText(), "You are successfully logged in.");
	  //  Assert.assertEquals(driver.findElement(By.cssSelector("p[style*='color']")).getText(), "You are successfully logged in.");
	  
	    //Assertion to verify user name
		 // Assert.assertEquals(driver.findElement(By.cssSelector("div[class=\"login-container\"] h2")).getText(), "Hello" +name +",");
	    
	    //Logging out
	    driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	    
	    //Verified login page title after navigating to login page
	    System.out.println(driver.findElement(By.xpath("//h1[text()='Sign in']")).getText());
	    Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Sign in']")).getText(), "Sign in");
	    
	    //closing browser
	    //driver.close();
	       
	}
	
	//public String getPassword(WebDriver driver) {
		
		
		
		
		
		
		
		
		
		
		
	
}
