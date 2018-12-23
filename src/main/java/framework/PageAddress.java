package framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageAddress extends PartialPageAddress {

    @FindBy(partialLinkText = "Update")
    protected WebElement LOC_UPDATE;
    @FindBy(id = "firstname")
    protected WebElement LOC_FIRST_NAME;
    @FindBy(id = "lastname")
    protected WebElement LOC_LAST_NAME;
    @FindBy(id = "address1")
    protected WebElement LOC_ADDRESS;
    @FindBy(id = "city")
    protected WebElement LOC_CITY;
    @FindBy(id = "id_state")
    protected WebElement LOC_STATE;
    @FindBy(id = "postcode")
    protected WebElement LOC_POSTCODE;
    @FindBy(id = "id_country")
    protected WebElement LOC_COUNTRY;
    @FindBy(id = "phone_mobile")
    protected WebElement LOC_PHONE;
    @FindBy(css = "button[type='submit']")
    protected WebElement LOC_SAVE;
    @FindBy(id = "company")
    protected WebElement LOC_COMPANY;
    @FindBy(css = "div.alert.alert-danger")
    protected WebElement LOC_ALERT;

    public String text = "New text for test";
    public String phone = "987654321";
    public String postcode = "54321";
    public String state = "31";
    private WebDriver driver;

    SoftAssert softAssert = new SoftAssert();

    public PageAddress(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    static final Logger testLogger = LogManager.getLogger(PagePersonalInfo.class);

    public void clickUpdate() {
        LOC_UPDATE.click();
    }

    public void changeAddressData() {
        testLogger.info("Change address data");
        LOC_ADDRESS.clear();
        LOC_COMPANY.clear();
        LOC_CITY.clear();
        LOC_PHONE.clear();
        LOC_POSTCODE.clear();
        LOC_ADDRESS.sendKeys(text);
        LOC_COMPANY.sendKeys(text);
        LOC_CITY.sendKeys(text);
        LOC_PHONE.sendKeys(phone);
        LOC_POSTCODE.sendKeys(postcode);
        LOC_SAVE.click();
    }

    public void checkAddressChanging() {
        testLogger.info("Check, if changing is ok");
        softAssert.assertTrue(driver.getCurrentUrl().endsWith("controller=addresses"));
    }

    public void isAddressDataEquals(Account account) {
        softAssert.assertTrue(getLOC_LAST_NAME().getAttribute("value").equals(account.getText()));
        softAssert.assertTrue(getLOC_FIRST_NAME().getAttribute("value").equals(account.getText()));
        softAssert.assertTrue(getLOC_COMPANY().getAttribute("value").equals(account.getText()));
        softAssert.assertTrue(getLOC_ADDRESS().getAttribute("value").equals(account.getText()));
        softAssert.assertTrue(getLOC_CITY().getAttribute("value").equals(account.getText()));
        softAssert.assertTrue(getLOC_STATE().getAttribute("value").equals(account.getState()));
        softAssert.assertTrue(getLOC_POSTCODE().getAttribute("value").equals(account.getPostcode()));
        softAssert.assertTrue(getLOC_COUNTRY().getAttribute("value").equals(account.getCountry()));
        softAssert.assertTrue(getLOC_PHONE().getAttribute("value").equals(account.getPhone()));
    }


}
