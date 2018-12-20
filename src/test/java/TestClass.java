import framework.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestClass extends TestBase {

    private final Logger testLogger = LogManager.getLogger(TestClass.class);
    private static final String EXPECTED_TITLE = "My account - My Store";
    private SoftAssert softAssert = new SoftAssert();

    @DataProvider(name = "dataProviderAccount")
    private Object[][] dataProviderAccount() {
        return dataSetAccount.getDataAccount();
    }

    @Test(dataProvider = "dataProviderAccount")
    public void testRegistrationFormFromDataFile(Account account) {

        PageRegistration pageRegistration = new PageRegistration(driver);
        PageAccount pageAccount = new PageAccount(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageMain pageMain = new PageMain(driver);

        pageMain.clickSignIn();

        pageLogin.enterNewEmail();

        pageRegistration.fillRegistrationForm(account);
        pageRegistration.submitAccount();

        testLogger.info("Checking if title is the same as in account");
        Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE);

        pageAccount.logout();
        testLogger.info("Test passed");
    }

    @Test(dataProvider = "dataProviderAccount")
    public void testEquivalenceAccountPersonalData(Account account) {

        PagePersonalInfo pagePersonalInfo = new PagePersonalInfo(driver);
        PageAccount pageAccount = new PageAccount(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageMain pageMain = new PageMain(driver);

        pageMain.clickSignIn();
        pageLogin.signIn(PageLogin.mail, account.getPassword());
        pageAccount.clickPersonalInformation();

        testLogger.info("Catching equivalence of the account data");
        pagePersonalInfo.isDataEquals(account, driver);
        softAssert.assertAll();

        pageAccount.logout();
        testLogger.info("Test passed");
    }

    @Test(dataProvider = "dataProviderAccount")
    public void testEditNewPersonalInfo(Account account) {

        PagePersonalInfo pagePersonalInfo = new PagePersonalInfo(driver);
        PageAccount pageAccount = new PageAccount(driver);
        PageMain pageMain = new PageMain(driver);
        PageLogin pageLogin = new PageLogin(driver);

        pageMain.clickSignIn();
        pageLogin.signIn(PageLogin.mail, account.getPassword());
        pageAccount.clickPersonalInformation();

        testLogger.info("Entering new account data");
        pagePersonalInfo.enterNewPersonalInfo();
        pagePersonalInfo.changePass();
        pagePersonalInfo.saveAndBack(account.getPassword());

        pageAccount.logout();
        testLogger.info("Test passed");
    }

    @Test(dataProvider = "dataProviderAccount")
    public void testEquivalenceAddressInformation(Account account) {

        PageAccount pageAccount = new PageAccount(driver);
        PageMain pageMain = new PageMain(driver);
        PageAddress pageAddress = new PageAddress(driver);
        PageLogin pageLogin = new PageLogin(driver);

        pageMain.clickSignIn();
        pageLogin.signIn(PageLogin.mail, account.getPassword());
        pageAccount.clickMyAddresses();
        pageAddress.clickUpdate();

        testLogger.info("Catching equivalence of the address data");
        pageAddress.isAddressDataEquals(account);
        softAssert.assertAll();

        pageAccount.logout();
        testLogger.info("Test passed");
    }

    @Test(dataProvider = "dataProviderAccount")
    public void testEditAddress(Account account) {

        PageAccount pageAccount = new PageAccount(driver);
        PageMain pageMain = new PageMain(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageAddress pageAddress = new PageAddress(driver);

        pageMain.clickSignIn();
        pageLogin.signIn(PageLogin.mail, account.getPassword());
        pageAccount.clickMyAddresses();
        pageAddress.clickUpdate();

        testLogger.info("Entering new address data");
        pageAddress.changeAddressData();
        pageAddress.checkAddressChanging();
        softAssert.assertAll();

        pageAccount.logout();
        testLogger.info("Test passed");
    }

    @Test(dataProvider = "dataProviderAccount")
    public void testMakeOrder(Account account) {

        PagesShop pagesShop = new PagesShop(driver);
        PageOrder pageOrder = new PageOrder(driver);
        PageMain pageMain = new PageMain(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageAccount pageAccount = new PageAccount(driver);

        pageMain.clickSignIn();
        pageLogin.signIn(PageLogin.mail, account.getPassword());

        pagesShop.putToCart(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageOrder.makeOrder();

        pageAccount.clickAccount();
        pageAccount.clickOrders();

        pageOrder.isOrder();
        softAssert.assertAll();

        pageAccount.logout();
        testLogger.info("Test passed");
    }

    @Test(dataProvider = "dataProviderAccount")
    public void testDownload(Account account) {
        PagesShop pagesShop = new PagesShop(driver);
        PageOrder pageOrder = new PageOrder(driver);
        PageMain pageMain = new PageMain(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageAccount pageAccount = new PageAccount(driver);

        pageMain.clickSignIn();
        pageLogin.signIn(PageLogin.mail, account.getPassword());

        pageAccount.clickAccount();
        pageAccount.clickOrders();

        softAssert.assertTrue(pageOrder.downloadOrderInvoice(driver));
        softAssert.assertAll();

        pageAccount.logout();
        testLogger.info("Test passed");
    }
}
