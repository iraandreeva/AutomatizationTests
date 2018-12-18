package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagesShop {

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
    private WebElement LOC_WOMAN_PAGE;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    private WebElement LOC_SHORT_SLEEVE;

    public PagesShop(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static final Logger testLogger = LogManager.getLogger(PagesShop.class);

    public void putToCart() {
        testLogger.info("Go to the shop");
        LOC_WOMAN_PAGE.click();
        LOC_SHORT_SLEEVE.click();

    }



}
