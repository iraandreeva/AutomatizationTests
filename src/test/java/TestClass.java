import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;

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




    @Test
    public void chromeRegistration() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\irina.andreeva\\IdeaProjects\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http:\\www.automationpractice.com");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("SubmitCreate")).click();
        //driver.quit();

    }







}
