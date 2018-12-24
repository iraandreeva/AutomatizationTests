package framework.pages;

import framework.model.Account;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

@Data
public class PageRegistration {

    @FindBy(id = "customer_firstname")
    private WebElement LOC_FIRST_NAME;
    @FindBy(id = "customer_lastname")
    private WebElement LOC_LAST_NAME;
    @FindBy(id = "passwd")
    private WebElement LOC_PASSWORD;
    @FindBy(id = "alias")
    private WebElement LOC_ALIAS;
    @FindBy(id = "submitAccount")
    private WebElement LOC_SUBMIT_ACCOUNT;
    @FindBy(css = ".alert.alert-danger")
    private WebElement LOC_ERROR;
    @FindBy(partialLinkText = "firstname")
    private WebElement LOC_ERR_FIRST_NAME;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement LOC_EMAIl;


    PageAddress pageAddress;
    PagePersonalInfo pagePersonalInfo;
    SoftAssert softAssert = new SoftAssert();

    public static Select select;

    public static void selectText(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }

    public PageRegistration(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        pageAddress = new PageAddress(driver);
        pagePersonalInfo = new PagePersonalInfo(driver);
    }

    static final Logger testLogger = LogManager.getLogger(PageRegistration.class);

    public void fillRegistrationForm(Account account) {

        testLogger.info("Fill registration form");
        pagePersonalInfo.LOC_RADIO_GENDER.click();
        LOC_FIRST_NAME.sendKeys(account.text);
        LOC_LAST_NAME.sendKeys(account.text);
        LOC_PASSWORD.sendKeys(account.password);

        selectText(pagePersonalInfo.LOC_DAYS, account.day);
        selectText(pagePersonalInfo.LOC_MONTHS, account.month);
        selectText(pagePersonalInfo.LOC_YEARS, account.year);

        pagePersonalInfo.LOC_NEWSLETTER.click();

        pageAddress.LOC_COMPANY.sendKeys(account.text);
        pageAddress.LOC_ADDRESS.sendKeys(account.text);
        pageAddress.LOC_CITY.sendKeys(account.text);

        selectText(pageAddress.LOC_STATE, account.state);
        pageAddress.LOC_POSTCODE.sendKeys(account.postcode);
        selectText(pageAddress.LOC_COUNTRY, account.country);

        pageAddress.LOC_PHONE.sendKeys(account.phone);
        LOC_ALIAS.sendKeys(account.text);
    }

    public void submitAccount() {
        testLogger.info("Submit account form");
        LOC_SUBMIT_ACCOUNT.click();
    }

    String[] registrationFields = new String[]{
        "firstname", "lastname", "passwd", "address1", "city", "phone", "Postal code", "State"
    };

    public boolean isCorrectDataEntered() {
        boolean hasError = false;
        for (String registrationField : registrationFields) {
            if(LOC_ERROR.getText().contains(registrationField)) {
                testLogger.info("Correct error. " + registrationField.toUpperCase() + " is null or invalid");
                hasError = true;
            }
        }
        return !hasError;
    }

    public void pageElementVerification() {
        testLogger.info("Page element verification");
            softAssert.assertTrue(LOC_FIRST_NAME.isDisplayed());
            softAssert.assertTrue(LOC_LAST_NAME.isDisplayed());
            softAssert.assertTrue(pagePersonalInfo.LOC_RADIO_GENDER.isDisplayed());
            softAssert.assertTrue(LOC_EMAIl.isDisplayed());
            softAssert.assertTrue(LOC_PASSWORD.isDisplayed());
            softAssert.assertTrue(pagePersonalInfo.LOC_NEWSLETTER.isDisplayed());
            softAssert.assertTrue(pageAddress.LOC_ADDRESS.isDisplayed());
            softAssert.assertTrue(pageAddress.LOC_CITY.isDisplayed());
            softAssert.assertTrue(pageAddress.LOC_POSTCODE.isDisplayed());
            softAssert.assertTrue(pageAddress.LOC_COUNTRY.isDisplayed());
            softAssert.assertTrue(pageAddress.LOC_PHONE.isDisplayed());
    }
}
