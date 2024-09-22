package eCommerceautomation;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import org.testng.Assert;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Scroll by given code, firsct write n check this code on console
//document.querySelector('div[class=tableFixHead').scrollTop=5000")
//scrollTop=5000, it will scroll down
//scrollDown=5000, it will scroll up
//scrollLeft=5000, scroll left
//scrollRight=5000, scroll right
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

//Case : we hav one table on webpage n it has 4 columns name, city , position n count so we want to get all count 4th column value and sum all of them n then compare with total sum
public class ScrollWebPageAndTableScroll {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
//We need to select month n then date only in this class 	
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			//Thread.sleep(2000);
//below is jacascript scoll code, execute Script is a method take two or one argument.
//document.querySelector its a method used to scroll table data inside webpage, we can check in console like window.scrollBy(0, 600)
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,400)");
			jse.executeScript("document.querySelector('div[class=tableFixHead').scrollTop=5000");

// Case condition- there is only one table that has 4 columns, if we want to capture 4th or 3rd column data in a table then we may use 
//   //td[4], it will highlight 4th column values, td[3] : will highlight 3rd column value, via CSS selectr, td:nth-child(4)
//// Case condition- there are two tables n both has 3 columns, if we want to capture 3rd column data in a table then we have to use parent to child traverse
// CSS, [class = 'tableFixHead'] td:nth-child(3), TABLEFIXEDHEAD is a parent, td:nth is child OR .tableFixHead'] td:nth-child(3)		
	List<WebElement> values	=driver.findElements(By.cssSelector("[class='tableFixHead'] td:nth-child(4)"));
	int sum=0;

	for (int i=0; i<values.size();i++) {
	System.out.println(values.get(i).getText());
	//values we're getting are as a string so we need to convert from string to int by PARSEINT method
  int count = Integer.parseInt(values.get(i).getText());
  sum=sum+count;
	}
System.out.println(sum);
String s =driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
   int add = Integer.parseInt(s);
  Assert.assertEquals(sum, add);
  
  
	}}