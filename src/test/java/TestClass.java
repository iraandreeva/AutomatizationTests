import framework.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

//Implement following for your account registration page:

//page classes containing functionality for interacting with the page
//and verify data on it (use PageFactory pattern);
//OK class for storing account data;
//OK data provider to pass properly configured account to the test;
//OK base test class for common actions;
//OK logging (use log4j 2) ;
//OK property file to store the parameters required for the test.


public class TestClass extends TestBase{

    static final Logger testLogger = LogManager.getLogger(TestClass.class);


    private static String EXPECTED_TITLE = "My account - My Store";

        @DataProvider(name = "accountDetails")
        public Object[][] accountDetails() {
                return new Object[][] {
                        {new Account()}

                };
        }

    @Test(dataProvider = "accountDetails")
    public void testRegistrationForm (Account account) {

            PageMain main = new PageMain(driver);
            PageRegistration regPage = new PageRegistration(driver);
            PageLogin login = new PageLogin(driver);
            PageLogout logout = new PageLogout(driver);

                testLogger.info("Trying to register account");
                main.clickSignIn();

                login.enterNewEmail();

                regPage.fillRegistrationForm(account);
                regPage.submitAccount();

                testLogger.info("Checking if title is the same as in account");
                Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE);

                logout.logout();
    }

    @Test
    public void testRegistrationFormJSON () throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
            Account account = objectMapper.readValue(new File("src/test/data/data.json"), Account.class);
        PageMain main = new PageMain(driver);
        PageRegistration regPage = new PageRegistration(driver);
        PageLogin login = new PageLogin(driver);
        PageLogout logout = new PageLogout(driver);

        testLogger.info("Trying to register account");
        main.clickSignIn();

        login.enterNewEmail();

        regPage.fillRegistrationForm(account);
        regPage.submitAccount();

        testLogger.info("Checking if title is the same as in account");
        Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE);

        //logout.logout();

        }

        @Test(dependsOnMethods = "testRegistrationFormJSON")
        public void testEquivalenceAccountPersonalData() {
            PageAccount pageAccount = new PageAccount(driver);
            PageLogout logout = new PageLogout(driver);

            logout.clickPersonalInformation();
            SoftAssert softAssert = new SoftAssert();
            //softAssert.assertEquals();
            System.out.println(pageAccount.toString());



        }


}
