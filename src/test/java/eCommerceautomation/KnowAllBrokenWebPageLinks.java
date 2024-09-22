package eCommerceautomation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class KnowAllBrokenWebPageLinks {
public static void main(String[] args) throws MalformedURLException, IOException {
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
//Step1 - get all url's tied with the links using selenium n then apply java methods which get u the status code
	//Step2- apply If condition, If status code >400 then url is not working means its broken url
	
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	/*
//we're calling OpenConnection method & its present inside URL class, thats y we're creating object n calling openconnection methods with object.method name 
//And return type of OpenConnecion method is HttpURLconnection
//We're calling the webpage http url using HEAD request method
	//Connect() mthod will make call or connection to the urls we are checking if they are broken or not
	//Check for only one broken link n capture it"s locator
	String url = driver.findElement(By.xpath("//a[contains(@href, 'brokenlink')]")).getAttribute("href");
// //li[@class='gf-li’]/a, li is tag name, class is attribute / a is actual tag name, we captured common locator for all links first and then its child

	HttpsURLConnection conn = (HttpsURLConnection)new URL(url).openConnection();
	conn.setRequestMethod("HEAD");
			conn.connect();
	int respcode= conn.getResponseCode();
	System.out.println(respcode); */
	
	//Validate for all links altogether
  List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
  SoftAssert sf=new SoftAssert();
  for(WebElement link:links) {
	  String url =link.getAttribute("href");
	  HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respcode= conn.getResponseCode();
		System.out.println(respcode);
		//respcode<400=condition false, n we gave assertTrue, false +true=false n condition failed
		sf.assertTrue(respcode<400, link.getText() + "broken link with" + respcode);
		
		
  }
	
	sf.assertAll();
	
	
}
}
