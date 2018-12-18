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
    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a")
    private WebElement LOC_ACCOUNT;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/ul/li[1]/a/i")
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
