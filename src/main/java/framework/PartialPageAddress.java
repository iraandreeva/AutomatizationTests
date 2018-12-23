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
public class PartialPageAddress {

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

}
