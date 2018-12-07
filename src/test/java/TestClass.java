import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//Implement following for your account registration page:

//page classes containing functionality for interacting with the page
//and verify data on it (use PageFactory pattern);
//OK class for storing account data;
//OK data provider to pass properly configured account to the test;
//OK base test class for common actions;
//OK logging (use log4j 2) ;
//property file to store the parameters required for the test.


public class TestClass extends TestBase{

    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger testLogger = LogManager.getLogger(TestClass.class);


    private static String EXPECTED_TITLE = "My account - My Store";
    private static String EXPECTED_SIGN = "Sign out";


        @DataProvider(name = "accountDetails")
        public Object[][] accountDetails() {
                return new Object[][] {
                        {new Account()}
                };
        }


    @Test(dataProvider = "accountDetails")
    public void chromeRegistration(Account account) {

            if(rootLogger.isDebugEnabled()) {
                rootLogger.debug("RootLogger");
                testLogger.debug("TestLogger");
            }

            try{
                testLogger.info("Trying to register account");
                account.fillAccount();
                testLogger.info("Checking if account is signed in");
                account.checkCredentials(EXPECTED_SIGN);
                testLogger.info("Checking if title is the same as in account");
                account.checkTitle(EXPECTED_TITLE);
                testLogger.info("Trying to logout");
                account.logout();
            }
        catch (Throwable e) {
            testLogger.error("Error message: " + e.getMessage());
            testLogger.fatal("Fatal error message: " + e.getMessage());
            testLogger.info("Test crashed");
        }
        finally {
            testLogger.info("Logger finished");
        }

    }











}
