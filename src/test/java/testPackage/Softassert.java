package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Softassert {
public static void main(String[] args) {
	//Softassert : It will be used when we dont want to hold or stop execution if any condition is failed
     SoftAssert	softassert=new SoftAssert();
	String name= "kapil";
	String actualTitle="Rahul Shetty Academy - Login page";
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); //
	
	driver.manage().window().maximize();
	driver.navigate().to(("https://rahulshettyacademy.com/locatorspractice")); // accessing app url
	String expectedTitle = driver.getTitle();
	System.out.println(expectedTitle);
	
	//Hard Assert
	softassert.assertEquals(actualTitle, expectedTitle);
	
	driver.findElement(By.id("inputUsername")).sendKeys(name);
	driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
    driver.findElement(By.className("signInBtn")).click();
    
    try {
    	Thread.sleep(3000);
	} catch (Exception e) {
		
	}
    
    
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

}

