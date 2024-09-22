package eCommerceautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFramesnDragnDrop {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

// To work on frames firstly we need to find frames on web page n then enter into frames, and we can use driver.switchTo.frame( by ID, OR by INDEX OR by WebElement)
// so frame ID is provided as a locator in DOM, if not then we have to locate with other elements 
//Also after completing on frames, we have to come out from it by one commane driver.switchTo().defaultContent();
		
//locate by index- firstly get count of total frames on webpage and if we want to go to 2nd frame so we can give 1st index as a value, n frame starts from 0th index.
//To find frame go to inspect element n Search iframe in DOM , also if you select any box on web app then at left i will be highlighted as a IFrame in browser tool.
		WebDriver driver = new ChromeDriver();

driver.get("https://jqueryui.com/droppable/");
//Find count of all frames on webapp by below command

System.out.println(driver.findElements(By.tagName("iframe")).size());	

			driver.manage().window().maximize();
			//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
// NOW use frame index based method n commented out above one, we hav total 1 index count for this web apge so we ll use 0 as index value
			driver.switchTo().frame(0);
			
			System.out.println(driver.findElement(By.id("draggable")).getText());
			//driver.findElement(By.id("draggable")).click();
			Actions a = new Actions(driver);
WebElement  source = driver.findElement(By.id("draggable"));
WebElement  target = driver.findElement(By.id("droppable"));
//source is which we want to ger n put into target
			a.dragAndDrop(source, target).build().perform();
			//Also after completing on frames, we have to come out from it by below command to perform other actions on webpage outside frame
driver.switchTo().defaultContent();
	}
			}
