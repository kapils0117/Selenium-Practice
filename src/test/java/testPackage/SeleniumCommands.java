package testPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCommands {
//	1) get methods
//	2) conditional methods
//	3) Browser methods
//	4) Navigational methods
//	5) wait methods
//
//	get methods  - we can these methods through webdriver instance
//	----------
//	get(url)
//	getTitle()
//	getCurrentURL()
//	getPageSource()
//	getWindowHandle()- it returns String and return one id of only single window
//	getwindowHandles()- it returns  ids of only multiple windows, we use set here bcoz set doesnt allow duplicate values 
//
//	conditional commands - access these commands through WebElement not by driver instacce
//	----------------------
//	Returns true/false ( boolean values)
//
//	isDisplayed():returns true/false if element is present or not like if input box OR image OR any link is present or not
//	isEnabled()- return ture/false if element is enabled or disabled
//	isSelected()- RETURNS TRUE if checkbox, radio button and dropdowns is selected
//
//
//	browser methods
//	---------------
//	close() 
//	- close single browser window
//
//	quit()
	
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); //
	
	
	driver.manage().window().maximize();
	
	driver.navigate().to(("https://rahulshettyacademy.com/locatorspractice")); // accessing app url
	

	System.out.println(driver.getWindowHandle());
	String expectedTitle = driver.getTitle();
	
	System.out.println(expectedTitle);
	//driver.findElement(By.id("inputUsername")).sendKeys(name);
	driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
	Thread.sleep(3000);
	//isDisplayed() Method- checked sign in text is present or not
//	WebElement wb= driver.findElement(By.xpath("//form/h1"));
//	System.out.println(wb.isDisplayed());
	
	Boolean ds= driver.findElement(By.xpath("//form/h1")).isDisplayed();
	System.out.println(ds);
	//isEnables() Method- checked if text field is enable or not

	WebElement textbox= driver.findElement(By.id("inputUsername"));
	System.out.println(textbox.isEnabled());
	
	//isselected() Method- checked if checkbox, radio button, dropdown is selected or not
	
System.out.println("before checking checkbox");
WebElement enab=driver.findElement(By.xpath("//input[@id='chkboxOne']"));
System.out.println(enab.isSelected());//false

System.out.println("after checking checkbox");
driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
System.out.println(enab.isSelected());//true

}
}
