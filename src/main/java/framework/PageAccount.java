package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccount {

    @FindBy(className = "logout")
    private WebElement LOC_LOGOUT;
    @FindBy(className = "icon-user")
    private WebElement LOC_PERS_INFO;
    @FindBy(className = "icon-building")
    private WebElement LOC_ADDRESSES;

    static final Logger testLogger = LogManager.getLogger(PageRegistration.class);

    public PageAccount(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickPersonalInformation() {
        testLogger.info("Click to personal information");
        LOC_PERS_INFO.click();
    }

    public void logout() {
        testLogger.info("Logout");
        LOC_LOGOUT.click();
    }

    public void clickMyAddresses() {
        testLogger.info("Click to My addresses");
        LOC_ADDRESSES.click();
    }
}
