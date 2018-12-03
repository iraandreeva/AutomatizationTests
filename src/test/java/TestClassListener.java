import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestClassListener implements ITestListener {



    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart is invoked");
    }

    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("onTestSuccess is invoked");
    }

    public void onTestFailure(ITestResult iTestResult) {

        System.out.println("onTestFailure is invoked");
    }

    public void onTestSkipped(ITestResult iTestResult) {

        System.out.println("onTestSkipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

        System.out.println("onTestFailedButWithinSuccessPercentage is invoked");
    }

    public void onStart(ITestContext iTestContext) {

        System.out.println("onStart is invoked");
    }

    public void onFinish(ITestContext iTestContext) {

        System.out.println("onFinish is invoked");
    }

}
