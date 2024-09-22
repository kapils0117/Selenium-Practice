package eCommerceautomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandlingWithAnyMonthAndDate {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
//We need to select month n then date only in this class 	
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.path2usa.com/travel-companion/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,700)");
			Thread.sleep(2000);

//Clicks on date text field first
			driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
//Here we got multiple same locators for month but we need to select March or April then we need go with Parent child traverse so we will find Parent locator of March or April then its child 
		System.out.println(driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText());	
while(!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().contains("December"))
{
	driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
}

		//Now we need to find one common / generic locator which is common for all dates n highlight entire dates
			List<WebElement> dates = driver.findElements(By.xpath("//span[@tabindex=-1]"));
			int count = driver.findElements(By.xpath("//span[@tabindex=-1]")).size();		
			System.out.println(count);
			for (int i=0;i<count;i++) {
				String ss=driver.findElements(By.xpath("//span[@tabindex=-1]")).get(i).getText();
				//Thread.sleep(3000);
				if(ss.equalsIgnoreCase("22")) {
				//	Thread.sleep(2000);
					driver.findElements(By.xpath("//span[@tabindex=-1]")).get(i).click();
					break;
					
				}
				
				
				
			}
	

	}
}
