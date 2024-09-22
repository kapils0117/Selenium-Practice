package testNG;

import org.testng.annotations.Test;

public class TestNGAnnotations {

	@Test
	public void m6() {
		System.out.println("seventh");
	}
	@Test(groups = {"Smoke"})
	//@Test(groups = {"Smoke"}, dependsOnMethods = {"m2", "m4carloan"})// these two methods will run prior to m7
	public void m7() {
		System.out.println("smoke eight");
	}
	@Test
	public void login() {
		System.out.println("login nine");
	}

	
}
