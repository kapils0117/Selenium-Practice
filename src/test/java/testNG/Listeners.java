package testNG;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//ITestListner is an interface which implements TestNg Listner
//So here we have some unimplemenetd methods, if any of the test case is failed then onTestFailure method will be run
//and when test case is passed then onTestPaased method code will execute so this way we can use these Listeners methods.
public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("I am passed case");
	}

	@Override
	public void onTestFailure(ITestResult result) {
//Test is failed but we want to know which test case is failed so we can use .getname method
		System.out.println("I have been failed case" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
