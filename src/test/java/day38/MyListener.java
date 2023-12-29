package day38;

import org.testng.ITestContext;
import org.testng.ITestListener;
// import org.testng.TestListenerAdapter;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	public void onTestStart(ITestResult result) {
	    System.out.println("This will trigger upon on start...");
	  }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("This will trigger upon on test success...");
	  }
	
	public void onTestFailure(ITestResult result) {
		System.out.println("This will trigger upon on test failure...");
	  }
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("This will trigger upon on test skipped...");
	  }
	
	public void onFinish(ITestContext context) {
		System.out.println("This will trigger upon on finished...");
	  }
}
