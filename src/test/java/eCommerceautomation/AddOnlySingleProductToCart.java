package eCommerceautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddOnlySingleProductToCart {
public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	List<WebElement> prod=driver.findElements(By.cssSelector("h4.prducts-name"));

	for (int i=0; i<prod.size();i++) {
		//get(i)- used to get index value for 0,1,2 and so on
		String s=prod.get(i).getText();
		if(s.contains("Cucumber"))
				{
			driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		break;
				}
	}
}}
