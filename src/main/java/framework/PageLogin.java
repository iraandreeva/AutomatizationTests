package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {

    private MailRandomizer mail = new MailRandomizer();

    @FindBy(id = "email_create")
    private WebElement LOC_EMAIL_CREATE;
    @FindBy(name = "SubmitCreate")
    private WebElement LOC_SUBMIT_CREATE;

    static final Logger testLogger = LogManager.getLogger(PageRegistration.class);

    public PageLogin(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterNewEmail() {

        testLogger.info("Enter email to registration form");
        LOC_EMAIL_CREATE.sendKeys(mail.getSaltString() + "@gmail.com");
        LOC_SUBMIT_CREATE.click();
    }
}
