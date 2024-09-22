package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;


public class Day2 {
// we can also define paramter annotation at test level in testng.xml file and it will be applied only on those classes which are part of those test section
	@Parameters({"URL"}) 
	@Test
	public void l3(String urlname) {
		System.out.println("smoke third");
		System.out.println(urlname);

	}
	@AfterSuite
	public void m4() {
		System.out.println("after suite");
	}
	
	@AfterMethod
	public void m22() {
		System.out.println("after method");
	}

	@BeforeClass
	public void m20() {
		System.out.println("before class");
	}
	@AfterClass
	public void m29() {
		System.out.println("after class");
	}

	@BeforeMethod
	public void m09() {
		System.out.println("before method");
	}
	
	
	
	@Test(dataProvider = "getdata")//We have to run this test case with test data set provided inside getdata methods, we have to iterate with each test set creds.
	public void m90(String username, String password) {
		Assert.assertTrue(false);
		System.out.println("smoke ninety");
		System.out.println(username);
		System.out.println(password);


	}
	
	@DataProvider
	public Object[][] getdata() {
	Object[][] data = new Object[3][2];	
// here[3] means total number of combination of test data OR rows
//here[2] means total number of values like 1. username, 2. passwrd, so here we hav two values OR columns
//1st data set	
	data[0][0]="firstusername";
	data[0][1]="firstpsswrd";
//2nd data set
	data[1][0]="secondusername";
	data[1][1]="secondpsswrd";
//3rd data set
	data[2][0]="thirdusrname";
	data[2][1]="thirdpsswrd";
     return data;
	
	}
	
}


