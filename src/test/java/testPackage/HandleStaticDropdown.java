package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleStaticDropdown {
//site: https://rahulshettyacademy.com/dropdownsPractise/
	//static dropdown- which are static
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	//driver.get("https://www.spicejet.com");
	driver.manage().window().maximize();
	WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	Select dp=new Select(dropdown);
	//Select by Index, select by visible text, select by value(attribute and it can be same as visible text)
	dp.selectByIndex(3);
	System.out.println(dp.getFirstSelectedOption().getText());
	dp.selectByValue("INR");
	System.out.println(dp.getFirstSelectedOption().getText());
	
	driver.findElement(By.id("divpaxinfo")).click();
	Thread.sleep(3000);
	//CLICK MULTIPLE TIMES ON SAME BUTTON USING WHILE LOOP OR FOR LOOP 
//	int i=1;
//	while(i<3) {
//		driver.findElement(By.id("hrefIncAdt")).click();
//		i++;
//	}
	for (int i=1; i<4;i++) {
		driver.findElement(By.id("hrefIncAdt")).click();
	}
	driver.findElement(By.id("btnclosepaxoption")).click();
	System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); 
	
	}
}
