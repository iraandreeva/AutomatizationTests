import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(className = "login")
    private WebElement LOC_SIGN_IN;
    @FindBy(id = "email_create")
    private WebElement LOC_EMAIL_CREATE;
    @FindBy(name = "SubmitCreate")
    private WebElement LOC_SUBMIT_CREATE;
    @FindBy(id = "id_gender2")
    private WebElement LOC_RADIO_GENDER;
    @FindBy(id = "customer_firstname")
    private WebElement LOC_FIRST_NAME;
    @FindBy(id = "customer_lastname")
    private WebElement LOC_LAST_NAME;
    @FindBy(id = "passwd")
    private WebElement LOC_PASSWORD;
    @FindBy(id = "days")
    private WebElement LOC_DAYS;
    @FindBy(id = "months")
    private WebElement LOC_MONTHS;
    @FindBy(id = "years")
    private WebElement LOC_YEARS;
    @FindBy(id = "company")
    private WebElement LOC_COMPANY;
    @FindBy(id = "address1")
    private WebElement LOC_ADDRESS;
    @FindBy(id = "city")
    private WebElement LOC_CITY;
    @FindBy(id = "id_state")
    private WebElement LOC_STATE;
    @FindBy(id = "postcode")
    private WebElement LOC_POSTCODE;
    @FindBy(id = "id_country")
    private WebElement LOC_COUNTRY;
    @FindBy(id = "phone_mobile")
    private WebElement LOC_PHONE;
    @FindBy(id = "alias")
    private WebElement LOC_ALIAS;
    @FindBy(id = "submitAccount")
    private WebElement LOC_SUBMIT_ACCOUNT;
    @FindBy(className = "logout")
    private WebElement LOC_LOGOUT;


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

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillAccount() {


        LOC_SIGN_IN.click();
        LOC_EMAIL_CREATE.sendKeys(mail.getSaltString() + "@gmail.com");
        LOC_SUBMIT_CREATE.click();

        waitFiveSec();
        LOC_RADIO_GENDER.click();
        LOC_FIRST_NAME.sendKeys(text);
        LOC_LAST_NAME.sendKeys(text);
        LOC_PASSWORD.sendKeys(pass);

        selectText(LOC_DAYS, day);
        selectText(LOC_MONTHS, month);
        selectText(LOC_YEARS, year);

        LOC_COMPANY.sendKeys(text);
        LOC_ADDRESS.sendKeys(text);
        LOC_CITY.sendKeys(text);

        selectText(LOC_STATE, state);
        LOC_POSTCODE.sendKeys(postcode);
        selectText(LOC_COUNTRY, country);

        LOC_PHONE.sendKeys(phone);
        LOC_ALIAS.sendKeys(text);

        waitFiveSec();
        LOC_SUBMIT_ACCOUNT.click();
        waitFiveSec();



    }


    public void checkCredentials(String expectedTitle) {
        Assert.assertEquals(LOC_LOGOUT.getText(), expectedTitle);
    }

    public void checkTitle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public void logout() {
        LOC_LOGOUT.click();
    }
}
