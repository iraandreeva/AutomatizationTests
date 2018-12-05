import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHome extends TestBase {

    public PageHome (WebDriver driver) {

        super(driver);
    }

    public static String baseURL = "http:\\www.automationpractice.com";

    public static PageHome open(WebDriver driver) {

        driver.navigate().to(baseURL);
        return new PageHome(driver);

    }

    public String getTitle(){

        return driver.getTitle();

    }


    public void findSignUpPage (By elementLocation) {
        //elementLocation = By.linkText("Sign in");
        driver.findElement(elementLocation).click();

    }


    public void enterEmail(By elementLocation, String text) {
        //elementLocation = By.id("email_create");
        driver.findElement(elementLocation).sendKeys(text);
    }

    public void createAccount(By elementLocation) {
        //elementLocation = By.name("SumbitCreate");
        driver.findElement(elementLocation).click();
    }

}
