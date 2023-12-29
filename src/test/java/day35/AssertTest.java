package day35;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {

	@Test
	void test() {
		// Assert.assertTrue(true); // Passed
		// Assert.assertTrue(false); //Failed
		
		int a = 10;
		int b = 10;
		
		//Assert.assertEquals(a>b, true, "10 is less than 20");
		
		//Assert.assertNotEquals(a, b);
		
		if(false) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}
}

