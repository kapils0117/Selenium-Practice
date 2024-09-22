package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptAlertsHandling {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	String text="Kapil";
	int a =5;
	driver.findElement(By.id("name")).sendKeys(text);
	driver.findElement(By.id("alertbtn")).click();
	
	// To grab the alert text n validate use GETTEXT() method
		System.out.println(	driver.switchTo().alert().getText());
// To click on OK OR YES button we use ACCEPT()  method
	driver.switchTo().alert().accept();
	driver.findElement(By.id("confirmbtn")).click();
	System.out.println(	driver.switchTo().alert().getText());

	// To click on NO OR CANCEL button we use DISMISS()  method
	driver.switchTo().alert().dismiss();




	
}
}
