package eCommerceautomation;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HanldeAjaxMouseActions {
//How to MouseOver on object in Selenium
//Performing Mouse and keyboard interaction 
	//Context click on element and double click on element
//Drag n dropping the element
	
	//What are frames n how to identify frames in application
	//How to handle frames and best practices when working with frames application.
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.in");
			driver.manage().window().maximize();
			Actions a= new Actions(driver);
			WebElement move = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
			//a.moveToElement(move).build().perform();
			//RIGHT CLICK
			a.moveToElement(move).contextClick().build().perform();
			
			//Click on Search bar and enter text HELLO by below two ways
		 //driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("HELLO");
			//OR
		 a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
			
	//DOUBLE CLICK AND SELECT TEXT ON SEARCH , ABOVE COMMENETED OUT CODE IS SAME AS BELOW ONE, JUST ADDED DOBLE CLICK CODE BELOW
	//a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
}}