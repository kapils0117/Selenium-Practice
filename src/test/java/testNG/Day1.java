package testNG;

import org.testng.annotations.Test;

public class Day1 {
	
	@Test
	public void m1() {
		System.out.println("first");
	}
@Test(groups = {"Smoke"})
	public void m2() {
		System.out.println(" smoke second");
	}
}
