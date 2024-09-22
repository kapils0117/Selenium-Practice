package selenium4Features;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeMultipleTabWindows {
	public static void main(String[] args) {
//Case : navigates to https://www.rahulshettyacademy.com/angularpractice
//Fill the first name text field on first or parent window but copy the FIRST COURSE name from child window and then paste on parent window text field
//here we need to click on first course link only doesn't matter which course is this
//Second if we want to click on any specific course then capture text locator for the same course and click that
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		//it will open a new tab
	//driver.switchTo().newWindow(WindowType.TAB);
	//now i want to open new window
	driver.switchTo().newWindow(WindowType.WINDOW);

	Set<String> ss=driver.getWindowHandles();
	Iterator<String> it =ss.iterator();
	String parentwin= it.next();
	String childwin= it.next();
	
	//now we want to switch to child window
	driver.switchTo().window(childwin);
	//now launch below url
	driver.get("https://rahulshettyacademy.com");
	String courses=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
	//now again switch to parent window to enter copied text
	driver.switchTo().window(parentwin);
	driver.findElement(By.cssSelector("input[name='name']")).sendKeys(courses);
	}

}
