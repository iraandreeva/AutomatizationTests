package framework;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Data
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
    @FindBy(id = "uniform-newsletter")
    private WebElement LOC_NEWSLETTER;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div")
    private WebElement LOC_ERROR;
    @FindBy(partialLinkText = "firstname")
    private WebElement LOC_ERR_FIRST_NAME;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement LOC_EMAIl;

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
        LOC_PASSWORD.sendKeys(account.password);

        selectText(LOC_DAYS, account.day);
        selectText(LOC_MONTHS, account.month);
        selectText(LOC_YEARS, account.year);

        LOC_NEWSLETTER.click();

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

    public boolean isCorrectDataEntered() {
        if (LOC_ERROR.getText().contains("firstname is"))
            testLogger.info("Correct error. Firstname is null or invalid");
        if (LOC_ERROR.getText().contains("lastname is"))
            testLogger.info("Correct error. Lastname is null or invalid");
        if (LOC_ERROR.getText().contains("passwd is"))
            testLogger.info("Correct error. Pass is null");
        if (LOC_ERROR.getText().contains("address1 is"))
            testLogger.info("Correct error. Address is null");
        if (LOC_ERROR.getText().contains("city is"))
            testLogger.info("Correct error. City is null");
        if (LOC_ERROR.getText().contains("phone"))
            testLogger.info("Correct error. Phone is null or invalid");
        if (LOC_ERROR.getText().contains("Postal code"))
            testLogger.info("Correct error. Postcode is null or invalid");
        if (LOC_ERROR.getText().contains("State"))
            testLogger.info("Correct error. State is null");
        return (!LOC_ERROR.getText().contains("firstname is")) && (!LOC_ERROR.getText().contains("lastname is"))
                && (!LOC_ERROR.getText().contains("passwd is")) && (!LOC_ERROR.getText().contains("address1 is"))
                && (!LOC_ERROR.getText().contains("city is")) && (!LOC_ERROR.getText().contains("phone"))
                && (!LOC_ERROR.getText().contains("Postal code")) && (!LOC_ERROR.getText().contains("State"));
    }

    public boolean isPresenceFirstName() {
        try {
            LOC_FIRST_NAME.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("First Name is absent");
            return false;
        }

    }

    public boolean isPresenceLastName() {
        try {
            LOC_LAST_NAME.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("Last Name is absent");
            return false;
        }
    }

    public boolean isPresenceGender() {
        try {
            LOC_RADIO_GENDER.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("Gender is absent");
            return false;
        }
    }

    public boolean isPresenceEmail() {
        try {
            LOC_EMAIl.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("Email is absent");
            return false;
        }

    }

    public boolean isPresencePassword() {
        try {
            LOC_PASSWORD.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("Password is absent");
            return false;
        }
    }

    public boolean isPresenceDateBirth() {
        try {
            LOC_DAYS.click();
            LOC_MONTHS.click();
            LOC_YEARS.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("Date of birth is absent");
            return false;
        }
    }

    public boolean isPresenceNewsletter() {
        try {
            LOC_NEWSLETTER.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("Checkbox newsletter is absent");
            return false;
        }
    }

    public boolean isPresenceAddress() {
        try {
            LOC_ADDRESS.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("Address is absent");
            return false;
        }
    }

    public boolean isPresenceCity() {
        try {
            LOC_CITY.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("City is absent");
            return false;
        }

    }

    public boolean isPresenceState() {
        try {
            LOC_STATE.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("State is absent");
            return false;
        }
    }

    public boolean isPresenceZip() {
        try {
            LOC_POSTCODE.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("Postcode is absent");
            return false;
        }
    }

    public boolean isPresenceCountry() {
        try {
            LOC_COUNTRY.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("Country is absent");
            return false;
        }
    }

    public boolean isPresencePhone() {
        try {
            LOC_PHONE.click();
            return true;
        }
        catch (Exception e) {
            testLogger.info("Phone is absent");
            return false;
        }
    }
}
