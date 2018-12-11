package framework;

import lombok.Data;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class PageAccount {


    @FindBy(id = "id_gender2")
    private WebElement LOC_RADIO_GENDER;
    @FindBy(id = "customer_firstname")
    private WebElement LOC_FIRST_NAME;
    @FindBy(id = "customer_lastname")
    private WebElement LOC_LAST_NAME;
    @FindBy(id = "days")
    private WebElement LOC_DAYS;
    @FindBy(id = "months")
    private WebElement LOC_MONTHS;
    @FindBy(id = "years")
    private WebElement LOC_YEARS;

    static String valueGender;
    static String valueFirstName;
    static String valueLastName;
    static String valueDayB;
    static String valueMonthB;
    static String valueYearB;


    public PageAccount(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public PageAccount() {
        valueGender = LOC_RADIO_GENDER.getAttribute("value");
        valueFirstName = LOC_FIRST_NAME.getAttribute("value");
        valueLastName = LOC_LAST_NAME.getAttribute("value");
        valueDayB = LOC_DAYS.getAttribute("value");
        valueMonthB = LOC_MONTHS.getAttribute("value");
        valueYearB = LOC_YEARS.getAttribute("value");
    }

    static final Logger testLogger = LogManager.getLogger(PageAccount.class);


    @Override
    public String toString() {
        return "Gender = " + valueGender +
                "\nFirstName = " + valueFirstName +
                "\nLastName = " + valueLastName +
                "\nDay of Birth = " + valueDayB +
                "\nMonth of Birth = " + valueMonthB +
                "\nYear of Birth = " + valueYearB;
    }
}
