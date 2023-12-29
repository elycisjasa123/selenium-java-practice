package day35;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertion {
	
	//@Test
	void test_hard_assertion() {
		System.out.println("testing...");
		System.out.println("testing...");
		System.out.println("testing...");
		System.out.println("testing...");
		System.out.println("testing...");
		
		Assert.assertEquals(1, 2);
		
		System.out.println("hard assertion...");
	}
	
	@Test
	void test_soft_assertion() {
		System.out.println("testing...");
		System.out.println("testing...");
		System.out.println("testing...");
		System.out.println("testing...");
		System.out.println("testing...");
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(1, 2);
		
		System.out.println("soft assertion...");
		
		sa.assertAll();
	}

}
