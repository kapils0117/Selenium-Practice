package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2EUiAutomation {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();
		//Clicks on checkbox
				
				driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
				Thread.sleep(2000);

		//click on date option
				driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
				Thread.sleep(2000);

				driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
			System.out.println("its Disabled");
			Assert.assertTrue(true);
		}
		else
		{
		Assert.assertTrue(false);
		
		}
		
		
		// Clicks on 4 adult
		driver.findElement(By.id("divpaxinfo")).click();
		//Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		Thread.sleep(2000);

		for (int i=1; i<4;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.cssSelector("input#ctl00_mainContent_btn_FindFlights")).click();
}
}