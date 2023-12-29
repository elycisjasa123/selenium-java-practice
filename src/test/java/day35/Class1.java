package day35;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {
	
	
	@BeforeTest
	void x() {
		System.out.println("This is before test from Class1");
	}

	@Test
	void def() {
		System.out.println("This is def from class1");
	}
	
	@AfterTest
	void n() {
		System.out.println("This is after test from Class1");
	}
}
