package framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagePersonalInfo {

    @FindBy(id = "firstname")
    private WebElement LOC_FIRST_NAME;
    @FindBy(id = "lastname")
    private WebElement LOC_LAST_NAME;
    @FindBy(id = "id_gender2")
    private WebElement LOC_RADIO_GENDER;
    @FindBy(id = "days")
    private WebElement LOC_DAYS;
    @FindBy(id = "months")
    private WebElement LOC_MONTHS;
    @FindBy(id = "years")
    private WebElement LOC_YEARS;
    @FindBy(id = "email")
    private WebElement LOC_EMAIL;
    @FindBy(className = "checked")
    private WebElement LOC_NEWSLETTER;
    @FindBy(id = "old_passwd")
    private WebElement LOC_OLD_PASS;
    @FindBy(css = "button.btn.btn-default.button.button-medium")
    private WebElement LOC_SAVE;
    @FindBy(partialLinkText = "Back to your account")
    private WebElement LOC_BACK_TO_ACC;
    @FindBy(id = "passwd")
    private WebElement LOC_NEW_PASS;
    @FindBy(id = "confirmation")
    private WebElement LOC_PASS_CONFIRM;

    public WebElement getLOC_RADIO_GENDER() {
        return LOC_RADIO_GENDER;
    }

    public String firstName;
    public String lastName;
    public String password;

    public PagePersonalInfo(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static final Logger testLogger = LogManager.getLogger(PagePersonalInfo.class);
    Account account = new Account();

    public void enterNewPersonalInfo(PagePersonalInfo page) {
        testLogger.info("Change first and last name");
        LOC_FIRST_NAME.clear();
        LOC_LAST_NAME.clear();
        LOC_FIRST_NAME.sendKeys(page.firstName);
        LOC_LAST_NAME.sendKeys(page.lastName);

    }

    public void changePass(PagePersonalInfo page) {
        testLogger.info("Change password");
        LOC_NEW_PASS.sendKeys(page.password);
        LOC_PASS_CONFIRM.sendKeys(page.password);
    }

    public void saveAndBack(String pass) {
        testLogger.info("Save personal information");
        LOC_OLD_PASS.sendKeys(pass);
        LOC_SAVE.click();
        LOC_BACK_TO_ACC.click();
    }

    public boolean isFirstName(Account account) {
        return getLOC_FIRST_NAME().getAttribute("value").equals(account.getText());
    }

    public boolean isLastName(Account account) {
        return getLOC_LAST_NAME().getAttribute("value").equals(account.getText());
    }

    public boolean isGender(WebDriver driver, Account account) {
        return getLOC_RADIO_GENDER().getAttribute("id").equals(new PageRegistration(driver).getLOC_RADIO_GENDER().getAttribute("id"));
    }

    public boolean isEmail(Account account) {
        return getLOC_EMAIL().getAttribute("value").equals(new LoginData().getEmail());
    }

    public boolean isCheckboxNewsletter(Account account) {
        return getLOC_NEWSLETTER().getAttribute("class").equals("checked");
    }

}
