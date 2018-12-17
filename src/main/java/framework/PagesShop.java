package framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagesShop {

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
    private WebElement LOC_WOMAN_PAGE;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    private WebElement LOC_SHORT_SLEEVE;
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

    public void makeOrder() {
        LOC_WOMAN_PAGE.click();
        LOC_SHORT_SLEEVE.click();
        LOC_CHECKOUT1.click();
        LOC_CHECKOUT2.click();
        LOC_CHECKOUT3.click();
        LOC_TERMS.click();
        LOC_CHECKOUT4.click();
        LOC_BANK.click();
        LOC_COMFIRM.click();
        LOC_ORDERS.click();

    }



}
