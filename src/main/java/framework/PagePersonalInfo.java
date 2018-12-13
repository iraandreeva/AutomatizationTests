package framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagePersonalInfo {

    @FindBy(id = "id_gender2")
    private WebElement LOC_RADIO_GENDER;
    @FindBy(id = "firstname")
    private WebElement LOC_FIRST_NAME;
    @FindBy(id = "lastname")
    private WebElement LOC_LAST_NAME;
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


    public String firstName;
    public String lastName;
    public String password;

    public PagePersonalInfo(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static final Logger testLogger = LogManager.getLogger(PagePersonalInfo.class);

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

}
