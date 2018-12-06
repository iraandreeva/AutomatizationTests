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
//class for storing account data;
//OK data provider to pass properly configured account to the test;
//base test class for common actions;
//logging (use log4j 2) ;
//property file to store the parameters required for the test.


public class TestClass {

    /*public TestClass (WebDriver driver) {

        super(driver);
    }*/



    private static By LOC_LOGOUT = By.className("logout");

    private static String EXPECTED_TITLE = "My account - My Store";
    private static String EXPECTED_SIGN = "Sign out";



        public WebDriver driver;


        private MailRandomizer mail = new MailRandomizer();

        @DataProvider(name = "accountDetails")
        public Object[][] accountDetails() {
                return new Object[][] {
                        {new Account()}
                };
        }


    @Test(dataProvider = "accountDetails")
    public void chromeRegistration(Account account) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\irina.andreeva\\IdeaProjects\\Drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        TestBase page = new TestBase(driver);

        account.init();
        account.fillAccount();


        page.waitFiveSec();
        //page.checkTitle(EXPECTED_TITLE);
        //account.checkCredentials(EXPECTED_SIGN);

        //page.waitFiveSec();
        //account.logout();


    }











}
