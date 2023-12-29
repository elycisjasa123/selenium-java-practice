package day34;

import org.testng.annotations.Test;

public class MyFirstTest {
	

	@Test
	void zest1() {
		System.out.println("Testing 1");
	}
	
	@Test(priority=2)
	void test2() {
		System.out.println("Testing 2");
	}
	
	@Test(priority=1)
	void txest3() {
		System.out.println("Testing 1");
	}
}
