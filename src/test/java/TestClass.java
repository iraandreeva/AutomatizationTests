import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//Implement an automated test using TestNG + Selenium for new account registration on http://automationpractice.com

//Test scenario:

// Navigate to the target automationpractice.com;
//Open registration form;
//Fill all fields in the form with the valid data;
//Click 'Register';
//Verify that new account is successfully created.
//Additional requirements:

//Target browser: Chrome
//The test should be stable and may be executed multiple times without any false failures.


public class TestClass {

    private static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\irina.andreeva\\IdeaProjects\\Drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http:\\www.automationpractice.com");

    }

    @Test
    public void chromeRegistration() {

            String mail = getSaltString() + "@gmail.com";

            driver.findElement(By.linkText("Sign in")).click();

            driver.findElement(By.id("email_create")).sendKeys(mail);
            driver.findElement(By.name("SubmitCreate")).click();

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.id("id_gender2")).click();
            driver.findElement(By.id("customer_firstname")).sendKeys("FirstName");
            driver.findElement(By.id("customer_lastname")).sendKeys("LastName");
            driver.findElement(By.id("passwd")).sendKeys("123456");

            WebElement d = driver.findElement(By.id("days"));
            Select select = new Select(d);
            select.selectByValue("1");

            d = driver.findElement(By.id("months"));
            select = new Select(d);
            select.selectByValue("1");

            d = driver.findElement(By.id("years"));
            select = new Select(d);
            select.selectByValue("2018");


            driver.findElement(By.id("company")).sendKeys("Company");
            driver.findElement(By.id("address1")).sendKeys("AddressAdreessAddreeesss");
            driver.findElement(By.id("city")).sendKeys("CityName");

            d = ((ChromeDriver) driver).findElementById("id_state");
            select = new Select(d);
            select.selectByValue("1");

            ((ChromeDriver) driver).findElementById("postcode").sendKeys("13235");

            d = ((ChromeDriver) driver).findElementById("id_country");
            select = new Select(d);
            select.selectByValue("21");

            ((ChromeDriver) driver).findElementById("phone_mobile").sendKeys("123456789");

            ((ChromeDriver) driver).findElementById("alias").sendKeys("Address");

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            ((ChromeDriver) driver).findElementById("submitAccount").click();


            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            Assert.assertEquals(driver.getTitle(), "My account - My Store");
            String element = driver.findElement(By.className("logout")).getText();
            Assert.assertEquals(element, "Sign out");


            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            ((ChromeDriver) driver).findElementByClassName("logout").click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
        System.out.print("Test passed OK");
    }


    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }








}
