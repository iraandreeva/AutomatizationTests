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


public class TestClass extends TestBase {

    static final Logger testLogger = LogManager.getLogger(TestClass.class);
    private static String EXPECTED_TITLE = "My account - My Store";


    @Test
    public void testRegistrationFormJSON() throws IOException {

        PageRegistration pageRegistration = new PageRegistration(driver);
        PageAccount pageAccount = new PageAccount(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageMain pageMain = new PageMain(driver);
        ObjectMapper objectMapper = new ObjectMapper();

        Account account = objectMapper.readValue(new File("src/test/data/data.json"), Account.class);

        pageMain.clickSignIn();

        pageLogin.enterNewEmail();

        pageRegistration.fillRegistrationForm(account);
        pageRegistration.submitAccount();

        testLogger.info("Checking if title is the same as in account");
        Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE);

        objectMapper.writeValue(new File("src/test/data/account.json"), new LoginData(mail, account.getPass()));

        pageAccount.logout();

    }

    @Test
    public void testEquivalenceAccountPersonalData() {

        PagePersonalInfo pagePersonalInfo = new PagePersonalInfo(driver);
        PageRegistration pageRegistration = new PageRegistration(driver);
        PageAccount pageAccount = new PageAccount(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageMain pageMain = new PageMain(driver);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            LoginData login = objectMapper.readValue(new File("src/test/data/account.json"), LoginData.class);
            Account acc = objectMapper.readValue(new File("src/test/data/data.json"), Account.class);

            pageMain.clickSignIn();
            pageLogin.signIn(login.getEmail(), login.getPassword());
            pageAccount.clickPersonalInformation();

            SoftAssert softAssert = new SoftAssert();
            testLogger.info("Catching equivalence of the account data");
            softAssert.assertEquals(pagePersonalInfo.getLOC_FIRST_NAME().getAttribute("value"), acc.getText());
            softAssert.assertEquals(pagePersonalInfo.getLOC_LAST_NAME().getAttribute("value"), acc.getText());
            softAssert.assertEquals(pagePersonalInfo.getLOC_RADIO_GENDER().getAttribute("id"), pageRegistration.getLOC_RADIO_GENDER().getAttribute("id"));
            softAssert.assertEquals(pagePersonalInfo.getLOC_EMAIL().getAttribute("value"), login.getEmail());
            softAssert.assertEquals(pagePersonalInfo.getLOC_NEWSLETTER().getAttribute("class"), "checked");
            softAssert.assertAll();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Test(dependsOnMethods = "testRegistrationFormJSON")
    public void testChangeAndVerifyNewPersonalInfo() {

        PagePersonalInfo pagePersonalInfo = new PagePersonalInfo(driver);
        PageRegistration pageRegistration = new PageRegistration(driver);
        PageAccount pageAccount = new PageAccount(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageMain pageMain = new PageMain(driver);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Account account = objectMapper.readValue(new File("src/test/data/data.json"), Account.class);
            PagePersonalInfo personalInfo = objectMapper.readValue(new File("src/test/data/data_for_change.json"), PagePersonalInfo.class);

            testLogger.info("Try to sign in");
            //pageLogin.signIn(account.getPass());
            testLogger.info("Click to personal info");
            pageAccount.clickPersonalInformation();

            pagePersonalInfo.enterNewPersonalInfo(personalInfo);
            pagePersonalInfo.changePass(personalInfo);
            pagePersonalInfo.saveAndBack(account.getPass());

            SoftAssert softAssert = new SoftAssert();

            pageAccount.clickPersonalInformation();
            softAssert.assertEquals(pagePersonalInfo.getLOC_FIRST_NAME().getAttribute("value"), personalInfo.getFirstName());
            softAssert.assertEquals(pagePersonalInfo.getLOC_LAST_NAME().getAttribute("value"), personalInfo.getLastName());
            softAssert.assertAll();

            objectMapper.writeValue(new File("src/test/data/account.json"), new LoginData(mail, personalInfo.getPassword()));

        }
        catch (Exception e) {
            e.getStackTrace();
        }

    }


}
