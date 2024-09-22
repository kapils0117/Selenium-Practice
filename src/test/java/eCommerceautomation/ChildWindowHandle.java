package eCommerceautomation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
// To move to child window "getWindowHandle();
public class ChildWindowHandle {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
			driver.manage().window().maximize();
			driver.findElement(By.className("blinkingText")).click();
			Set<String> cw = driver.getWindowHandles();// we hav 2 windows now Parent n Child, so we will store all windows in Set collection
			Iterator<String> it=cw.iterator();
//First cursor will go to parent window and capture it ID and then next() method will go to child window n take it Id so we can capture multiple windows id by next method
			String parentWindowId = it.next();
			String childWindowId=it.next();// next method give us window ID
			//String thirdwindowId = it.next();
//Now if we want to switch to any window then we will use below statement
			driver.switchTo().window(childWindowId);
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
//On below line i applied toggle point n run in debug mode n then selected below line and right click n opened in WATCH option, then expression window is open there we can write our code line by line by clicking enter n it will display result below in box
		//driver.findElement(By.cssSelector("p.im-para.red")).getText();
		String emailID= driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		//we're in child window but now to enter in email id of parent we have to go to parent window by below command
		driver.switchTo().window(parentWindowId);
	//now get click in email text box of parent window
driver.findElement(By.id("username")).sendKeys(emailID);
}
}