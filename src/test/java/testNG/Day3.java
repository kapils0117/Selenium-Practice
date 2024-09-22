package testNG;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class Day3 {

	
	@Parameters({"URL", "username", "password"}) 

	@Test (groups = {"Smoke"})
	public void m4carloan(String urrl, String key, String pass) {
		System.out.println("smoke fourth");
		System.out.println(urrl);
		System.out.println(key);
		System.out.println(pass);



	

	}
	@BeforeTest

	public void m5carloan() {
		System.out.println("I will run first");
	}
	@BeforeSuite

	public void m5carloanlogin() {
		System.out.println("before suite");// it will execute first before all test folder and their classes
	}
}

