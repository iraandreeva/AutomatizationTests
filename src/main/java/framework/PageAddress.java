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

    public String text;
    public String phone;
    public String postcode;
    public String state;

    public PageAddress(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static final Logger testLogger = LogManager.getLogger(PagePersonalInfo.class);

    public void clickUpdate() {
        LOC_UPDATE.click();
    }

    public void changeAddressDate(PageAddress page) {

        testLogger.info("Change address data");
        LOC_ADDRESS.clear();
        LOC_COMPANY.clear();
        LOC_CITY.clear();
        LOC_STATE.clear();
        LOC_PHONE.clear();
        LOC_POSTCODE.clear();
        LOC_ADDRESS.sendKeys(page.text);
        LOC_COMPANY.sendKeys(page.text);
        LOC_CITY.sendKeys(page.text);
        LOC_STATE.sendKeys(page.state);
        LOC_PHONE.sendKeys(page.phone);
        LOC_POSTCODE.sendKeys(page.postcode);
        LOC_SAVE.click();
    }





}
