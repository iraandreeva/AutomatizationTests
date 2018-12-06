import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public Select select;


    public TestBase(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeSuite
    public void beforeSuite() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\irina.andreeva\\IdeaProjects\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.getCurrentUrl();

    }


    @AfterSuite
    public void afterSuite() {
        driver.quit();
        driver = null;
        System.out.print("Test passed OK");
    }

    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();

    }

    public void setText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    public String getText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    public void selectText(By elementLocation, String value) {
        select = new Select(driver.findElement(elementLocation));
        select.selectByValue(value);

    }

    public void waitFiveSec() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void checkLogin(String driver, String expectedTitle) {
        Assert.assertEquals(driver, expectedTitle);
    }
}
