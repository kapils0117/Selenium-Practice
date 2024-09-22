package eCommerceautomation;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountAllWebpageLinkandFooterlinks {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//To count all links on given webpage we use TAGName locator and then provide "a" anchor where a means all hyperlinks
			System.out.println(driver.findElements(By.tagName("a")).size());
//Count all footer links we can create one webelement and then we can find one common locator for entire footer frame
			WebElement w = driver.findElement(By.id("gf-BIG"));// limiting webdriver scope
//Now again we can provie anchor "a"
//SIZE method we can only use with webelements not with webelement(we can use getsize() with webelement)
			System.out.println(w.findElements(By.tagName("a")).size());
// Requirement 3 is I want count of footer first column - td is the column locator & To do this we have to identify first locator for entire column on footer and then create parent to child xpath
	WebElement cl = w.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
	System.out.println(cl.findElements(By.tagName("a")).size());
//Requirement 4- Click on each link(right click) in the webpage and check if pages are working n opening
	// so we will do right click and verify title of all child windows n then we can close child windows
	List<WebElement> total = cl.findElements(By.tagName("a"));
	for(int i=1;i<total.size();i++) {
		String keyclick=Keys.chord(Keys.CONTROL,Keys.ENTER);
		total.get(i).sendKeys(keyclick);
		Thread.sleep(5000L);

//Requirement 5- now verify title if each child window

		Set<String> ss = driver.getWindowHandles();//4
	Iterator<String> it=ss.iterator();
	while(it.hasNext()) {
			driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());
		}
	}
	}}