package day35;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSuite {

	@BeforeSuite
	void bs() {
		System.out.println("This is before suite from TestSuite class");
	}
	
	@AfterSuite
	void as() {
		System.out.println("This is after suite from TestSuite class");
	}
}
