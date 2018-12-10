package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogout {

    @FindBy(className = "logout")
    private WebElement LOC_LOGOUT;

    static final Logger testLogger = LogManager.getLogger(PageRegistration.class);

    public PageLogout(final WebDriver driver) {
        testLogger.info("Logout");
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        LOC_LOGOUT.click();
    }
}
