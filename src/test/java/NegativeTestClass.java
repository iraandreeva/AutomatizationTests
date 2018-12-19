import framework.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTestClass extends TestBase{

    private SoftAssert softAssert = new SoftAssert();

    static final Logger testLogger = LogManager.getLogger(PageRegistration.class);

    @DataProvider(name = "dataProviderAccountIncorrect")
    private Object[][] dataProviderIncorrectAccount() {
        return dataSetIncorrect.getDataAccount();
    }

    @Test(dataProvider = "dataProviderAccountIncorrect")
    public void checkCorrectEmailRegistration(Account account) {
        PageLogin pageLogin = new PageLogin(driver);
        PageMain pageMain = new PageMain(driver);

        pageMain.clickSignIn();
        softAssert.assertFalse(pageLogin.isEmailCorrect());
        testLogger.info("Negative test passed!");
    }

    @Test(dataProvider = "dataProviderAccountIncorrect")
    public void checkRegistrationData(Account account) {
        PageLogin pageLogin = new PageLogin(driver);
        PageMain pageMain = new PageMain(driver);
        PageRegistration pageRegistration = new PageRegistration(driver);

        pageMain.clickSignIn();
        pageLogin.enterNewEmail();
        pageRegistration.fillRegistrationForm(account);
        pageRegistration.submitAccount();
        softAssert.assertFalse(pageRegistration.isCorrectDataEntered());

    }


}
