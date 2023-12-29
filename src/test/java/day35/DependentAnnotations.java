package day35;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependentAnnotations {
	
	@Test(priority=1)
	void openApp() {
		Assert.assertTrue(true);
	}

	@Test(priority=2, dependsOnMethods= {"openApp"})
	void login() {
		Assert.assertTrue(true);
		
	}
	
	@Test(priority=3, dependsOnMethods= {"login"})
	void search() {
		Assert.assertTrue(false);
		
	}
	
	@Test(priority=4, dependsOnMethods= {"login", "search"})
	void advsearch() {
		Assert.assertTrue(true);
	}
	
	@Test(priority=5, dependsOnMethods= {"login"})
	void logout() {
		Assert.assertTrue(true);
	}
}
