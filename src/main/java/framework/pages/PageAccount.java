package framework.pages;

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
    @FindBy(css = ".myaccount-link-list a[title='Addresses']")
    private WebElement LOC_ADDRESSES;
    @FindBy(css = "a[href$='controller=my-account'")
    private WebElement LOC_ACCOUNT;
    @FindBy(css = ".myaccount-link-list a[title='Orders']")
    private WebElement LOC_ORDERS;

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

    public void clickAccount() {
        testLogger.info("Go to personal area");
        LOC_ACCOUNT.click();
    }

    public void clickOrders() {
        testLogger.info("Click to orders history");
        LOC_ORDERS.click();
    }
}
