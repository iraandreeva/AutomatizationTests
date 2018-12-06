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
import org.testng.reporters.jq.TestPanel;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Account {

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


    private String text;
    private String day;
    private String month;
    private String year;
    private String postcode;
    private String country;
    private String state;
    private String phone;
    private String pass;

    public WebDriver driver;
    public TestBase page;

    private MailRandomizer mail = new MailRandomizer();



    String baseURL = "http://automationpractice.com/index.php";

    public Account() {
        text = "TextforTest";
        day = "1";
        month = "2";
        year = "2018";
        postcode = "13235";
        country = "21";
        state = "1";
        phone = "123456789";
        pass = "password";
    }

    public void init() {
        driver = new ChromeDriver();
        page = new TestBase(driver);
        driver.navigate().to(baseURL);
    }

    public void fillAccount() {

        page.click(LOC_SIGN_IN);
        page.setText(LOC_EMAIL_CREATE, mail.getSaltString() + "@gmail.com");
        page.click(LOC_SUBMIT_CREATE);

        page.waitFiveSec();
        page.click(LOC_RADIO_GENDER);
        page.setText(LOC_FIRST_NAME, text);
        page.setText(LOC_LAST_NAME, text);
        page.setText(LOC_PASSWORD, pass);

        page.selectText(LOC_DAYS, day);
        page.selectText(LOC_MONTHS, month);
        page.selectText(LOC_YEARS, year);

        page.setText(LOC_COMPANY, text);
        page.setText(LOC_ADDRESS, text);
        page.setText(LOC_CITY, text);

        page.selectText(LOC_STATE, state);
        page.setText(LOC_POSTCODE, postcode);
        page.selectText(LOC_COUNTRY, country);

        page.setText(LOC_PHONE, phone);
        page.setText(LOC_ALIAS, text);

        page.waitFiveSec();
        page.click(LOC_SUBMIT_ACCOUNT);
        page.click(LOC_LOGOUT);

        Assert.assertEquals(page.getText(LOC_LOGOUT), "My account - My Store");
    }


    public void checkCredentials(String expectedTitle) {

    }

    public void logout() {
        page.click(LOC_LOGOUT);
    }
}
