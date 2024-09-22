package testPackage;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIAutomatnEnd2E {
public static void main(String[] args) throws InterruptedException {
// In flight site we'll select any checkbox then round trip , then to n from dates
WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	//driver.get("https://www.spicejet.com");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	driver.findElement(By.xpath("//a[@value='MAA']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();
	driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
	Thread.sleep(2000);

	driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	//driver.findElement(By.className(".ui-state-default.ui-state-highlight")).click();
	
// HANDLE element when it is enabled n disabled , so store or capture it locator which changes evrytime n then apply if condition or logic
	
	System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
		System.out.println("its enabled");
		Assert.assertTrue(true);
	}
	else
	{
	Assert.assertTrue(false);
	}
	//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
}
}
