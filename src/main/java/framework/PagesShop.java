package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagesShop {

    @FindBy(className = "sf-with-ul")
    private WebElement LOC_WOMAN_PAGE;
    @FindBy(className = "left-block")
    private WebElement LOC_ITEM;
    @FindBy(css = "a.button.ajax_add_to_cart_button.btn.btn-default")
    private WebElement LOC_SHORT_SLEEVE;

    public PagesShop(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static final Logger testLogger = LogManager.getLogger(PagesShop.class);

    public void putToCart(WebDriver driver) {
        testLogger.info("Go to the shop");
            LOC_WOMAN_PAGE.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(LOC_ITEM).click();
        if (LOC_SHORT_SLEEVE.getText().contains("Shorts"))
            LOC_SHORT_SLEEVE.click();

    }



}
