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

//Implement following for your account registration page:

//page classes containing functionality for interacting with the page
//and verify data on it (use PageFactory pattern);
//class for storing account data;
//data provider to pass properly configured account to the test;
//base test class for common actions;
//logging (use log4j 2) ;
//property file to store the parameters required for the test.


public class TestClass extends TestBase {

    public TestClass (WebDriver driver) {

        super(driver);
    }


    private MailRandomizer mail = new MailRandomizer();


    @Test
    public void chromeRegistration() {

            String email = mail.getSaltString() + "@gmail.com";

            driver.findElement(By.linkText("Sign in")).click();

            driver.findElement(By.id("email_create")).sendKeys(email);
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











}
