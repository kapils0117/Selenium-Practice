package eCommerceautomation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.domstorage.model.Item;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitAddToCartInsideMethod {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			 String[] Products = {"Cucumber", "Brocolli","Beetroot"}; 
			driver.get("https://rahulshettyacademy.com/seleniumPractise/");
			driver.manage().window().maximize();
			//Thread.sleep(2000);
			//Whatever products we want to click we are declaring in an array, we can also take list but that will take more memory
	          itmes(driver, Products);
	driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	//Thread.sleep(2000);

	driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
	driver.findElement(By.xpath("//button[text()='Apply']")).click();
	System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	
	}
			 
			public static void itmes(WebDriver driver, String[] Products ) {
				List<WebElement> prod=driver.findElements(By.cssSelector("h4.product-name"));

				for (int i=0; i<prod.size();i++) {
					//get(i)- used to get index value for 0,1,2 and so on
					String[] name=prod.get(i).getText().split("-");
					String actualname = name[0].trim();
	//Convert above arr into arraylist for bett search n compare
	//Also we need to use split n trim method to compare prod name to out array list products bcoz actual prod name is Cucumber - 1
	//With arraylist break statement can not be used
	//Check name u extracted from loop is present in array list or not
	//NOTE: WE shouldn't locate the element by button text which changes frequently like ADD TO CART 
					List itemsneeded =Arrays.asList(Products);
					int j=0;
	//It will work as break
					if(itemsneeded.contains(actualname))
					{
						j++;
		//click on add to cart button
		//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
	// we hav to add 3 product so after that we have to come out from loop, we can also use array length method instead of providing hard coded value as 3	
		//if(j==3)
		if(j==Products.length)
		{
						break;
					}
							}
				}
			}
			 
			
		}



