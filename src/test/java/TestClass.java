import framework.*;
import lombok.ToString;
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

import static framework.PageLogin.mail;

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
            PageAccount logout = new PageAccount(driver);

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
        PageAccount logout = new PageAccount(driver);

        testLogger.info("Trying to register account");
        main.clickSignIn();

        login.enterNewEmail();

        regPage.fillRegistrationForm(account);
        regPage.submitAccount();

        testLogger.info("Checking if title is the same as in account");
        Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE);
        logout.logout();

        }

        @Test(dependsOnMethods = "testRegistrationFormJSON")
        public void testEquivalenceAccountPersonalData() throws Exception {
            PagePersonalInfo pagePersonalInfo = new PagePersonalInfo(driver);
            PageRegistration pageRegistration = new PageRegistration(driver);
            PageAccount logout = new PageAccount(driver);
            PageLogin pageLogin = new PageLogin(driver);
            ObjectMapper objectMapper = new ObjectMapper();
            //PageMain pageMain = new PageMain(driver);
            Account account = objectMapper.readValue(new File("src/test/data/data.json"), Account.class);

            //pageMain.clickSignIn();
            testLogger.info("Try to sign in");
            pageLogin.signIn(account.getPass());
            testLogger.info("Click to personal info");
            logout.clickPersonalInformation();

            SoftAssert softAssert = new SoftAssert();
            testLogger.info("Catching equivalence of the account data");
            softAssert.assertEquals(pagePersonalInfo.getLOC_FIRST_NAME().getAttribute("value"), account.getText());
            softAssert.assertEquals(pagePersonalInfo.getLOC_LAST_NAME().getAttribute("value"), account.getText());
            softAssert.assertEquals(pagePersonalInfo.getLOC_RADIO_GENDER().getAttribute("id"), pageRegistration.getLOC_RADIO_GENDER().getAttribute("id"));
            softAssert.assertEquals(pagePersonalInfo.getLOC_EMAIL().getAttribute("value"), mail);
            softAssert.assertEquals(pagePersonalInfo.getLOC_NEWSLETTER().getAttribute("class"), "checked");
            softAssert.assertAll();

        }

        @Test(dependsOnMethods = "testRegistrationFormJSON")
        public void testChangeAndVerifyNewPersonalInfo () throws Exception {

            PagePersonalInfo pagePersonalInfo = new PagePersonalInfo(driver);
            PageAccount logout = new PageAccount(driver);
            PageLogin pageLogin = new PageLogin(driver);
            ObjectMapper objectMapper = new ObjectMapper();
            Account account = objectMapper.readValue(new File("src/test/data/data.json"), Account.class);
            PagePersonalInfo personalInfo = objectMapper.readValue(new File("src/test/data/data_for_change.json"), PagePersonalInfo.class);

            testLogger.info("Try to sign in");
            pageLogin.signIn(account.getPass());
            testLogger.info("Click to personal info");
            logout.clickPersonalInformation();

            pagePersonalInfo.enterNewPersonalInfo(account.getPass(), personalInfo);

            SoftAssert softAssert = new SoftAssert();
            testLogger.info("Click to personal info");
            logout.clickPersonalInformation();
            softAssert.assertEquals(pagePersonalInfo.getLOC_FIRST_NAME().getAttribute("value"), personalInfo.getFirstName());
            softAssert.assertEquals(pagePersonalInfo.getLOC_LAST_NAME().getAttribute("value"), personalInfo.getLastName());
            softAssert.assertAll();


        }


}
