import framework.model.Account;
import framework.pages.PageLogin;
import framework.pages.PageMain;
import framework.pages.PageRegistration;
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

        pageRegistration.pageElementVerification();
        softAssert.assertAll();
    }
}
