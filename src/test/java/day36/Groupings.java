package day36;

import org.testng.annotations.Test;

public class Groupings {

	@Test(priority=1, groups= {"sanity", "regression"})
	void loginByEmail() {
		System.out.println("This is login by Email...");
	}
	
	@Test(priority=2, groups= {"sanity"})
	void loginByFacebook() {
		System.out.println("This is login by Facebook...");
	}
	
	@Test(priority=3, groups= {"sanity"})
	void loginByTwitter() {
		System.out.println("This is login by Twitter...");
	}
	
	@Test(priority=4, groups= {"sanity", "regression"})
	void signupByEmail() {
		System.out.println("This is signup by Email...");
	}
	
	@Test(priority=5, groups= {"regression"})
	void signupByFacebook() {
		System.out.println("This is signup by Facebook...");
	}
	
	@Test(priority=6, groups= {"regression"})
	void signupByTwitter() {
		System.out.println("This is signup by Twitter...");
	}
	
	@Test(priority=7, groups= {"sanity"})
	void paymentinDollar() {
		System.out.println("This is payment by dollar...");
	}
	
	@Test(priority=8, groups= {"sanity","regression"})
	void paymentinRupees() {
		System.out.println("This is payment by rupees...");
	}
	
	@Test(priority=9, groups= {"regression"})
	void paymentReturnByBank() {
		System.out.println("This is payment return by bank...");
	}
	
	
}
