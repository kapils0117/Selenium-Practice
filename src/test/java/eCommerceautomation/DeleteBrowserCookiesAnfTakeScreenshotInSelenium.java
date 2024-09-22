package eCommerceautomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//https://chromedriver.chromium.org/capabilities
public class DeleteBrowserCookiesAnfTakeScreenshotInSelenium {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
			//First delete cookie and then launch any web app url
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();
			//delete any specific cookie from session
			//driver.manage().deleteCookieNamed("abcd");
			
			driver.get("https://rahulshettyacademy.com/seleniumPractise/");
			 File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//getscreenshotas is a method, We're using file to save screenshot, we are casting driver into Takesscreenshot
			 FileUtils.copyFile(sourceFile, new File("C:\\Users\\KSHARM23\\Documents\\Knox Meeting\\testscreenshot.png"));
			 
//FileUtils is a method to copy a a file from File src object to our machine
	            // Define the destination path for the screenshot}

	
	}}