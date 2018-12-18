package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageOrder {

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")
    private WebElement LOC_CHECKOUT1;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")
    private WebElement LOC_CHECKOUT2;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")
    private WebElement LOC_CHECKOUT3;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")
    private WebElement LOC_CHECKOUT4;
    @FindBy(xpath = "//*[@id=\"cgv\"]")
    private WebElement LOC_TERMS;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a")
    private WebElement LOC_BANK;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")
    private WebElement LOC_COMFIRM;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/p/a")
    private WebElement LOC_ORDERS;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/table/tbody/tr/td[1]/a")
    private WebElement LOC_FIRST_ORDER;

    public PageOrder(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static final Logger testLogger = LogManager.getLogger(PageOrder.class);

    public void makeOrder() {
        testLogger.info("Make and confirm the order");
        LOC_CHECKOUT1.click();
        LOC_CHECKOUT2.click();
        LOC_CHECKOUT3.click();
        LOC_TERMS.click();
        LOC_CHECKOUT4.click();
        LOC_BANK.click();
        LOC_COMFIRM.click();
        LOC_ORDERS.click();
    }

    public boolean isOrder() {
        testLogger.info("Check if order is placed here");
        return Assert.isNonEmpty(LOC_FIRST_ORDER);
    }


}
