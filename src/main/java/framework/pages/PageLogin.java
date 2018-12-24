package framework.pages;

import framework.util.MailRandomizer;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class PageLogin {

    private static final MailRandomizer email = new MailRandomizer();
    public static final String mail = email.getSaltString() + "@gmail.com";

    @FindBy(id = "email_create")
    private WebElement LOC_EMAIL_CREATE;
    @FindBy(name = "SubmitCreate")
    private WebElement LOC_SUBMIT_CREATE;
    @FindBy(id = "email")
    private WebElement LOC_EMAIL;
    @FindBy(id = "passwd")
    private WebElement LOC_PASSWORD;
    @FindBy(id = "SubmitLogin")
    private WebElement LOC_SUBMIT_LOGIN;
    @FindBy(xpath = "//*[@id=\"create_account_error\"]")
    private WebElement LOC_EMAIL_ERROR;


    static final Logger testLogger = LogManager.getLogger(PageRegistration.class);

    public PageLogin(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterNewEmail() {
        testLogger.info("Enter email to registration form");
        LOC_EMAIL_CREATE.sendKeys(mail);
        LOC_SUBMIT_CREATE.click();
    }

    public void signIn(String mail, String pass) {
        testLogger.info("Try to sign in");
        LOC_EMAIL.sendKeys(mail);
        LOC_PASSWORD.sendKeys(pass);
        LOC_SUBMIT_LOGIN.click();
    }

    public boolean isEmailCorrect() {
        LOC_EMAIL_CREATE.sendKeys(mail);
        LOC_SUBMIT_CREATE.click();
        if (LOC_EMAIL_CREATE == null) {
            testLogger.info("Correct error. Email is empty.");
            return false;

        } else if (!LOC_EMAIL_ERROR.isDisplayed()) {
            testLogger.info("Correct error. Email is wrong!");
            return false;
        }
        return true;
    }
}
