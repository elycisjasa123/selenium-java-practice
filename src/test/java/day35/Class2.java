package day35;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class2 {
	
	@BeforeTest
	void m() {
		System.out.println("This is before test from Class2...");
	}
	
	@Test
	void abc() {
		System.out.println("This is abc from class2");
	}

	@AfterTest
	void h() {
		System.out.println("This is after test from Class2...");
	}
}
