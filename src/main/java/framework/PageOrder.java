package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageOrder {

    @FindBy(css = "a.btn.btn-default.button.button-medium")
    private WebElement LOC_CHECKOUT1;
    @FindBy(css = "a.button.btn.btn-default.standard-checkout.button-medium")
    private WebElement LOC_CHECKOUT2;
    @FindBy(css = "button.button.btn.btn-default.button-medium")
    private WebElement LOC_CHECKOUT3;
    @FindBy(css = "button.button.btn.btn-default.standard-checkout.button-medium")
    private WebElement LOC_CHECKOUT4;
    @FindBy(xpath = "//*[@id=\"cgv\"]")
    private WebElement LOC_TERMS;
    @FindBy(className = "bankwire")
    private WebElement LOC_BANK;
    @FindBy(css = "button.button.btn.btn-default.button-medium")
    private WebElement LOC_COMFIRM;
    @FindBy(css = "a.button-exclusive.btn.btn-default")
    private WebElement LOC_ORDERS;
    @FindBy(className = "first_item ")
    private WebElement LOC_FIRST_ORDER;

    public PageOrder(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static final Logger testLogger = LogManager.getLogger(PageOrder.class);

    public void makeOrder() {
        testLogger.info("Make and confirm the order");
        if (LOC_CHECKOUT1.getText().contains("Proceed"))
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
