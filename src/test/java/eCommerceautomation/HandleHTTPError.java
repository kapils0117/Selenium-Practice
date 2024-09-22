package eCommerceautomation;

import java.lang.reflect.Proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleHTTPError {

	public static void main(String[] args) throws InterruptedException {
//To avoid http security related error we can use below code n methods n pass this method object in chrmebrowser as an arg
		// we can also add extension n plugin to chrome browser , we need to provide the path
		// can add proxy also aa a capability
		//options.addExtensions("path)
		//https://chromedriver.chromium.org/capabilities
		ChromeOptions options = new ChromeOptions();
	//	Proxy proxy = new Proxy();
		//block location popups for travel site by below code
		//options.setExperimentalOption("excludeSwitches",   
		//	     Arrays.asList("disable-popup-blocking"));
	//	proxy.setHttpProxy("myhttpproxy:3337");

	//	options.setCapability("proxy", proxy);
		//options.addExtensions(new File("/path/to/extension.crx"));
// by below code download any project file at some specific location
		//ChromeOptions options = new ChromeOptions();
		//Map<String, Object> prefs = new HashMap<String, Object>();
		//prefs.put("download.default_directory", "/directory/path");
		//options.setExperimentalOption("prefs", prefs);
		
		
		
		//options.setAcceptInsecureCerts(true);
		WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver(options);
			driver.get("https://expired.badssl.com/");
			driver.manage().window().maximize();

	System.out.println(driver.getTitle());
	}
}