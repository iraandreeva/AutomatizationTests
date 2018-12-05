import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public WebDriver driver;


    public TestBase(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeSuite
    public void beforeSuite() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\irina.andreeva\\IdeaProjects\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http:\\www.automationpractice.com");

    }


    @AfterSuite
    public void afterSuite() {
        driver.quit();
        driver = null;
        System.out.print("Test passed OK");
    }
}
