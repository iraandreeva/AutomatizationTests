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
public class PartialPagePersonalInfo {

    @FindBy(id = "firstname")
    protected WebElement LOC_FIRST_NAME;
    @FindBy(id = "lastname")
    protected WebElement LOC_LAST_NAME;
    @FindBy(id = "id_gender2")
    protected WebElement LOC_RADIO_GENDER;
    @FindBy(id = "days")
    protected WebElement LOC_DAYS;
    @FindBy(id = "months")
    protected WebElement LOC_MONTHS;
    @FindBy(id = "years")
    protected WebElement LOC_YEARS;
    @FindBy(id = "email")
    protected WebElement LOC_EMAIL;
    @FindBy(className = "checked")
    protected WebElement LOC_NEWSLETTER;
    @FindBy(id = "old_passwd")
    protected WebElement LOC_OLD_PASS;
    @FindBy(css = "button[type='submit']")
    protected WebElement LOC_SAVE;
    @FindBy(css = "a[href$='controller=my-account'")
    protected WebElement LOC_BACK_TO_ACC;
    @FindBy(id = "passwd")
    protected WebElement LOC_NEW_PASS;
    @FindBy(id = "confirmation")
    protected WebElement LOC_PASS_CONFIRM;

}
