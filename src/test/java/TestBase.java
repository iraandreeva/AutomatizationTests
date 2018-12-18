import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import java.util.HashMap;
import java.util.Properties;
import org.testng.ITestContext;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    public static TestBase page;


    public TestBase() {

    }

    private Properties property = new Properties();
    public DataSet dataSetAccount;
    public DataSet dataSetIncorrect;

    public TestBase(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeSuite
    public void beforeSuite(ITestContext testContext) {

        try {
            FileInputStream file = new FileInputStream("src/main/resources/resources.properties");
        property.load(file);}
        catch (Exception e) {
            e.printStackTrace();
        }
        String baseURL = property.getProperty("source.baseURL");
        String driverChrome = property.getProperty("source.driverChrome");

        System.setProperty("webdriver.chrome.driver", driverChrome);
        driver = new ChromeDriver();
        page = new TestBase(driver);
        driver.navigate().to(baseURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        dataSetAccount = new DataSet();
        dataSetIncorrect = new DataSet();

        HashMap<String,String> parameters = new HashMap<>( testContext.getCurrentXmlTest().getAllParameters());
        dataSetAccount.processDataFileAccount( parameters.get( "dataFileAccount") );
//        dataSetIncorrect.processDataFileAccount( parameters.get( "dataFileAccountIncorrect") );

    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
        driver = null;
        System.out.print("Test finished");
    }

}
