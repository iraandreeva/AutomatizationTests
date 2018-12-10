package framework;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageMain {

    @FindBy(className = "login")
    private WebElement LOC_SIGN_IN;

    static final Logger testLogger = LogManager.getLogger(PageRegistration.class);

    public PageMain(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        testLogger.info("Click to SignIn");
        LOC_SIGN_IN.click();
    }

}
