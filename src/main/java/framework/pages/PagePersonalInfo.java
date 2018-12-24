package framework.pages;

import framework.model.Account;
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
@AllArgsConstructor
@NoArgsConstructor
public class PagePersonalInfo {

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
    @FindBy(id = "newsletter")
    protected WebElement LOC_NEWSLETTER;
    @FindBy(id = "old_passwd")
    protected WebElement LOC_PASSWORD;
    @FindBy(css = "button[type='submit']")
    protected WebElement LOC_SAVE;
    @FindBy(css = "a[href$='controller=my-account'")
    protected WebElement LOC_BACK_TO_ACC;
    @FindBy(id = "passwd")
    protected WebElement LOC_NEW_PASS;
    @FindBy(id = "confirmation")
    protected WebElement LOC_PASS_CONFIRM;

    SoftAssert softAssert = new SoftAssert();

    public WebElement getLOC_RADIO_GENDER() {
        return LOC_RADIO_GENDER;
    }

    public String firstName = "Loshpek";
    public String lastName = "Loshpek";
    public String password = "password";

    public PagePersonalInfo(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static final Logger testLogger = LogManager.getLogger(PagePersonalInfo.class);
    Account account = new Account();

    public void enterNewPersonalInfo() {
        testLogger.info("Change first and last name");
        LOC_FIRST_NAME.clear();
        LOC_LAST_NAME.clear();
        LOC_FIRST_NAME.sendKeys(firstName);
        LOC_LAST_NAME.sendKeys(lastName);
        account.text = firstName;

    }

    public void changePass() {
        testLogger.info("Change password");
        LOC_NEW_PASS.sendKeys(password);
        LOC_PASS_CONFIRM.sendKeys(password);
        account.password = password;
    }

    public void saveAndBack(String pass) {
        testLogger.info("Save personal information");
        LOC_PASSWORD.sendKeys(pass);
        LOC_SAVE.click();
        LOC_BACK_TO_ACC.click();
    }

    public void isDataEquals(Account account, WebDriver driver) {
        softAssert.assertTrue(getLOC_FIRST_NAME().getAttribute("value").equals(account.getText()));
        softAssert.assertTrue(getLOC_LAST_NAME().getAttribute("value").equals(account.getText()));
        //softAssert.assertTrue(getLOC_RADIO_GENDER().getAttribute("id").equals(new PageRegistration(driver).getLOC_RADIO_GENDER().getAttribute("id")));
        softAssert.assertTrue(getLOC_EMAIL().getAttribute("value").equals(PageLogin.mail));
        softAssert.assertTrue(getLOC_NEWSLETTER().getAttribute("class").equals("checked"));
    }
}
