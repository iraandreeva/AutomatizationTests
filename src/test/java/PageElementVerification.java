import framework.Account;
import framework.PageLogin;
import framework.PageMain;
import framework.PageRegistration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PageElementVerification extends TestBase{

    private SoftAssert softAssert = new SoftAssert();

    static final Logger testLogger = LogManager.getLogger(PageRegistration.class);

    @DataProvider(name = "dataProviderAccount")
    private Object[][] dataProviderAccount() {
        return dataSetAccount.getDataAccount();
    }

    @Test(dataProvider = "dataProviderAccount")
    public void registrationPageElementVerification(Account account) {
        PageRegistration pageRegistration = new PageRegistration(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageMain pageMain = new PageMain(driver);

        pageMain.clickSignIn();
        pageLogin.enterNewEmail();

        softAssert.assertTrue(pageRegistration.isPresenceFirstName());
        softAssert.assertTrue(pageRegistration.isPresenceLastName());
        softAssert.assertTrue(pageRegistration.isPresenceGender());
        softAssert.assertTrue(pageRegistration.isPresencePassword());
        softAssert.assertTrue(pageRegistration.isPresenceEmail());
        softAssert.assertTrue(pageRegistration.isPresenceDateBirth());
        softAssert.assertTrue(pageRegistration.isPresenceNewsletter());
        softAssert.assertTrue(pageRegistration.isPresenceAddress());
        softAssert.assertTrue(pageRegistration.isPresenceCity());
        softAssert.assertTrue(pageRegistration.isPresenceZip());
        softAssert.assertTrue(pageRegistration.isPresencePhone());
        softAssert.assertTrue(pageRegistration.isPresenceState());
        softAssert.assertAll();
    }
}
