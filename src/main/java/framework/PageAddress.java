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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageAddress {

    @FindBy(partialLinkText = "Update")
    private WebElement LOC_UPDATE;
    @FindBy(id = "firstname")
    private WebElement LOC_FIRST_NAME;
    @FindBy(id = "lastname")
    private WebElement LOC_LAST_NAME;
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
    @FindBy(partialLinkText = "Save")
    private WebElement LOC_SAVE;
    @FindBy(id = "company")
    private WebElement LOC_COMPANY;

    public String text = "New text for test";
    public String phone = "987654321";
    public String postcode = "54321";
    public String state = "31";

    public PageAddress(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static final Logger testLogger = LogManager.getLogger(PagePersonalInfo.class);

    public void clickUpdate() {
        LOC_UPDATE.click();
    }

    public void changeAddressDate() {

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

    public boolean isLastName(Account account) {
        return getLOC_LAST_NAME().getAttribute("value").equals(account.getText());
    }

    public boolean isFirstName(Account account) {
        return getLOC_FIRST_NAME().getAttribute("value").equals(account.getText());
    }

    public boolean isCompany(Account account) {
        return getLOC_COMPANY().getAttribute("value").equals(account.getText());
    }

    public boolean isAddress(Account account) {
        return getLOC_ADDRESS().getAttribute("value").equals(account.getText());
    }

    public boolean isCity(Account account) {
        return getLOC_CITY().getAttribute("value").equals(account.getText());
    }

    public boolean isState(Account account) {
        return getLOC_STATE().getAttribute("value").equals(account.getState());
    }

    public boolean isPostcode(Account account) {
        return getLOC_POSTCODE().getAttribute("value").equals(account.getPostcode());
    }

    public boolean isCountry(Account account) {
        return getLOC_COUNTRY().getAttribute("value").equals(account.getCountry());
    }

    public boolean isPhone(Account account) {
        return getLOC_PHONE().getAttribute("value").equals(account.getPhone());
    }


}
