package day35;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationBeforeClass {

	@BeforeClass
	void login() {
		System.out.println("This is login...");
	}
	
	@Test(priority=1)
	void search() {
		System.out.println("This is search...");
	}
	
	@Test(priority=2)
	void advancedSearch() {
		System.out.println("This is advancedSearch...");
	}
	
	@AfterClass
	void logout() {
		System.out.println("This is logout...");
		
	}
}
