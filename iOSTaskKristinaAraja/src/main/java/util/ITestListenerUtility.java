package util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerUtility extends ITestListenerUtilityMethods implements ITestListener {

    // This method will execute before starting of Test suite.
    public void onStart(ITestContext tr) {
    }

    // This method will execute, Once the Test suite is finished.
    public void onFinish(ITestContext tr) {
    }

    // This method will execute only when the test is pass.
    public void onTestSuccess(ITestResult tr) {
        captureScreenShot(tr, "pass");
    }

    // This method will execute only on the event of fail test.
    public void onTestFailure(ITestResult tr) {
        captureScreenShot(tr, "fail");
    }

    // This method will execute before the main test start (@Test)
    public void onTestStart(ITestResult tr) {
    }

    // This method will execute only if any of the main test(@Test) get skipped
    public void onTestSkipped(ITestResult tr) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
    }
}