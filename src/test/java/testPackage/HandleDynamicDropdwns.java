package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDynamicDropdwns {
//Options which are loaded when user perform actions are dynamic dropdown
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(2000);
//PROVIDED SECOND INDEX bocz there are two same values in FROM and TO dropdowns
		//driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
// OR instead of providing 2nd index above we can use "Parent-Child relationship locator to Identify the objects Uniquely"
//so first we will locate entire parent(From or TO date entire window) and then its child
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();

		
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dp=new Select(dropdown);
		
	}
	
	
	
}
