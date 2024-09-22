package selenium4Features;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeWebElementScreenshot {
//We use this feature to validate if text is correctly entered into text field (webelement) 
public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();

	WebDriver driver = new ChromeDriver();
	driver.get("https://www.rahulshettyacademy.com/angularpractice/");
	driver.manage().window().maximize();
	//it will open a new tab
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
	WebElement wb=driver.findElement(By.cssSelector("input[name='name']"));
	wb.sendKeys(courses);
	//Screenshot taking code for specific locator(webelement)
	File file= wb.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File("logo.png"));
	
	
	
}


}


