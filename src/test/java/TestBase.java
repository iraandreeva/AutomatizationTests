import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Select select;
    public static TestBase page;


    public TestBase() {

    }

    //String baseURL = "http://automationpractice.com/index.php";
    private Properties property = new Properties();



    public TestBase(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String file = rootPath + "\\src\\main\\resources\\resources.properties";
        property.load(new FileInputStream(file));
        String baseURL = property.getProperty("source.baseURL");
        String driverChrome = property.getProperty("source.driverChrome");

        System.setProperty("webdriver.chrome.driver", driverChrome);
        driver = new ChromeDriver();
        page = new TestBase(driver);
        driver.navigate().to(baseURL);

    }


    @AfterSuite
    public void afterSuite() {
        driver.quit();
        driver = null;
        System.out.print("Test finished");
    }

    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();

    }

    public static void setText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    public static String getText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    public static void selectText(By elementLocation, String value) {
        select = new Select(driver.findElement(elementLocation));
        select.selectByValue(value);

    }

    public static void waitFiveSec() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}
