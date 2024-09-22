package testPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAutoSuggestivedropdown {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
//handle autosuggestive dropdown using parent child css or xpath and store all dropdown first in list using findELEMENTS
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		Thread.sleep(2000);
		//Now will store all elements in list means all dropdown option which r shown upon typing 3 chars then they autosuggest
		List<WebElement> op=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		
		
		for (WebElement opd:op) {
			if(opd.getText().equalsIgnoreCase("india")){
				opd.click();
				break;
			}
		}
}
}
