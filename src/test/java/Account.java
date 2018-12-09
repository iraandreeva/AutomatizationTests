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

public class Account extends TestBase{

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


    private MailRandomizer mail = new MailRandomizer();






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


    public void fillAccount() {


        click(LOC_SIGN_IN);
        setText(LOC_EMAIL_CREATE, mail.getSaltString() + "@gmail.com");
        click(LOC_SUBMIT_CREATE);

        waitFiveSec();
        click(LOC_RADIO_GENDER);
        setText(LOC_FIRST_NAME, text);
        setText(LOC_LAST_NAME, text);
        setText(LOC_PASSWORD, pass);

        selectText(LOC_DAYS, day);
        selectText(LOC_MONTHS, month);
        selectText(LOC_YEARS, year);

        setText(LOC_COMPANY, text);
        setText(LOC_ADDRESS, text);
        setText(LOC_CITY, text);

        selectText(LOC_STATE, state);
        setText(LOC_POSTCODE, postcode);
        selectText(LOC_COUNTRY, country);

        setText(LOC_PHONE, phone);
        setText(LOC_ALIAS, text);

        waitFiveSec();
        click(LOC_SUBMIT_ACCOUNT);
        waitFiveSec();



    }


    public void checkCredentials(String expectedTitle) {
        Assert.assertEquals(getText(LOC_LOGOUT), ("Sign out"));
    }

    public void checkTitle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public void logout() {
        click(LOC_LOGOUT);
    }
}
