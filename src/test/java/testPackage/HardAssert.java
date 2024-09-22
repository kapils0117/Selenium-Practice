package testPackage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssert {
public static void main(String[] args) {
//HardAssert : It will stop the execution once hard assertion condition is failed, we can use it aftr browsr launch code, after signing on login page
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	//driver.get("https://www.spicejet.com");
	driver.manage().window().maximize();
	driver.findElement(By.id("divpaxinfo")).click();
//Here below isselected method will return false bcoz checkbox is not checked so we can use assertFalse method to validate it. and if we use assertTrue then it will fail n stop the execution 
	Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());

	for (int i=1; i<4;i++) {
		driver.findElement(By.id("hrefIncAdt")).click();
	}
	driver.findElement(By.id("btnclosepaxoption")).click();
	Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
	
	System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
}
}
