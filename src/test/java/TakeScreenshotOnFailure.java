import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TakeScreenshotOnFailure implements ITestListener {


    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((TestBase) currentClass).getDriver();

        if ( webDriver != null )
        {
            File f = ( (TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile( f, new File( "screenShot.jpg"  ) );
                byte[] fileContent = Files.readAllBytes( f.toPath() );
                saveScreenshot( fileContent );

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Attachment(value = "Page screenshot", type = "image/jpg")
    public byte[] saveScreenshot( byte[] screenShot ) {
        return screenShot;
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
