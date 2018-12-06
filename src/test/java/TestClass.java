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

    String baseURL = "http://automationpractice.com/index.php";

    private static By LOC_SIGN_IN = By.linkText("Sign in");
    private static By LOC_EMAIL_CREATE = By.id("email_create");
    private static By LOC_SUBMIT_CREATE = By.name("SubmitCreate");
    private static By LOC_RADIO_GENDER = By.id("id_gender2");
    private static By LOC_FIRST_NAME = By.id("customer_firstname");
    private static By LOC_LAST_NAME = By.id("customer_lastname");
    private static By LOC_PASSWORD = By.id("passwd");
    private static By LOC_DAYS = By.id("days");
    private static By LOC_MONTHS = By.id("months");
    private static By LOC_YEARS = By.id("years");
    private static By LOC_COMPANY = By.id("company");
    private static By LOC_ADDRESS = By.id("address1");
    private static By LOC_CITY = By.id("city");
    private static By LOC_STATE = By.id("id_state");
    private static By LOC_POSTCODE = By.id("postcode");
    private static By LOC_COUNTRY = By.id("id_country");
    private static By LOC_PHONE = By.id("phone_mobile");
    private static By LOC_ALIAS = By.id("alias");
    private static By LOC_SUBMIT_ACCOUNT = By.id("submitAccount");
    private static By LOC_LOGOUT = By.className("logout");



    private static String TEXT = "TextforTest";
    private static String VALUE_DAY = "1";
    private static String VALUE_MONTH = "2";
    private static String VALUE_YEAR = "2018";
    private static String POSTCODE = "13235";
    private static String VALUE_COUNTRY = "21";
    private static String VALUE_STATE = "1";
    private static String PHONE = "123456789";

    private static String EXPECTED_TITLE = "My account - My Store";
    private static String EXPECTED_SIGN = "Sign out";



        public WebDriver driver;

        private MailRandomizer mail = new MailRandomizer();

        @DataProvider(name = "accountDetails")
        public Object[][] accountDetails() {
                return new Object[][] {
                        {mail.getSaltString() + "@gmail.com", TEXT}
                };
        }


    @Test(dataProvider = "accountDetails")
    public void chromeRegistration(String email, String password) {


            System.setProperty("webdriver.chrome.driver", "C:\\Users\\irina.andreeva\\IdeaProjects\\Drivers\\chromedriver.exe");

            driver = new ChromeDriver();
            TestBase page = new TestBase(driver);

            driver.navigate().to(baseURL);

            page.click(LOC_SIGN_IN);
            page.setText(LOC_EMAIL_CREATE, email);
            page.click(LOC_SUBMIT_CREATE);

            page.waitFiveSec();
            page.click(LOC_RADIO_GENDER);
            page.setText(LOC_FIRST_NAME, TEXT);
            page.setText(LOC_LAST_NAME, TEXT);
            page.setText(LOC_PASSWORD, password);

            page.selectText(LOC_DAYS, VALUE_DAY);
            page.selectText(LOC_MONTHS, VALUE_MONTH);
            page.selectText(LOC_YEARS, VALUE_YEAR);

            page.setText(LOC_COMPANY, TEXT);
            page.setText(LOC_ADDRESS, TEXT);
            page.setText(LOC_CITY, TEXT);

            page.selectText(LOC_STATE, VALUE_STATE);
            page.setText(LOC_POSTCODE, POSTCODE);
            page.selectText(LOC_COUNTRY, VALUE_COUNTRY);

            page.setText(LOC_PHONE, PHONE);
            page.setText(LOC_ALIAS, TEXT);

            page.waitFiveSec();
            page.click(LOC_SUBMIT_ACCOUNT);

            page.waitFiveSec();
            page.checkLogin(driver.getTitle(), EXPECTED_TITLE);
            page.checkLogin(page.getText(LOC_LOGOUT), EXPECTED_SIGN);

            page.waitFiveSec();
            page.click(LOC_LOGOUT);

    }











}
