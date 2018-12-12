package framework;

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
    public static final String mail = email.getSaltString() + "@gmail.com";;


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


    static final Logger testLogger = LogManager.getLogger(PageRegistration.class);

    public PageLogin(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterNewEmail() {
        testLogger.info("Enter email to registration form");
        LOC_EMAIL_CREATE.sendKeys(mail);
        LOC_SUBMIT_CREATE.click();
    }

    public void signIn(String pass) {
        LOC_EMAIL.sendKeys(mail);
        LOC_PASSWORD.sendKeys(pass);
        LOC_SUBMIT_LOGIN.click();
    }
}
