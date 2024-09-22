package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBoxes {
public static void main(String[] args) throws InterruptedException {
	//Validate if checkbox is checked or not by IsSelected() method, will return true or false
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
//Count the number of check boxes for this, capture any common locator (present in all checkboxes) by which all checkboxes are highlighting
System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
}
}
