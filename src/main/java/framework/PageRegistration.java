package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageRegistration {


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
    public static Select select;

    public static void selectText(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }

    public PageRegistration(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static final Logger testLogger = LogManager.getLogger(PageRegistration.class);

    public void fillRegistrationForm(Account account) {

        testLogger.info("Fill registration form");
        LOC_RADIO_GENDER.click();
        LOC_FIRST_NAME.sendKeys(account.text);
        LOC_LAST_NAME.sendKeys(account.text);
        LOC_PASSWORD.sendKeys(account.pass);

        selectText(LOC_DAYS, account.day);
        selectText(LOC_MONTHS, account.month);
        selectText(LOC_YEARS, account.year);

        LOC_COMPANY.sendKeys(account.text);
        LOC_ADDRESS.sendKeys(account.text);
        LOC_CITY.sendKeys(account.text);

        selectText(LOC_STATE, account.state);
        LOC_POSTCODE.sendKeys(account.postcode);
        selectText(LOC_COUNTRY, account.country);

        LOC_PHONE.sendKeys(account.phone);
        LOC_ALIAS.sendKeys(account.text);
    }

    public void submitAccount() {
        testLogger.info("Submit account form");
        LOC_SUBMIT_ACCOUNT.click();
    }



}
