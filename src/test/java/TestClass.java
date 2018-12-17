import framework.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

import static framework.PageLogin.mail;


public class TestClass extends TestBase {

    private final Logger testLogger = LogManager.getLogger(TestClass.class);
    private static final String EXPECTED_TITLE = "My account - My Store";
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void testRegisterAccount() throws IOException {

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
        testLogger.info("Test passed");

    }

    @DataProvider
    private Object[][] dataProviderAccount(){
        return dataSetAccount.getDataAccount();
    }

    @Test( dataProvider = "dataProviderAccount" )
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
//контекст тест нг
    //дата пулл

    @DataProvider(name = "dataProviderLogin")
    private Object[][] dataProviderLogin(){
        return new Object[][]
                {
                        {dataSetAccount.getDataAccount(), dataSetLogin.getDataLogin()}
                };
    }

    //If you have changed the user data, you need to register new user.
    @Test(dataProvider = "dataProviderLogin")
    public void testEquivalenceAccountPersonalData(Account account, LoginData login) {

        PagePersonalInfo pagePersonalInfo = new PagePersonalInfo(driver);
        PageAccount pageAccount = new PageAccount(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageMain pageMain = new PageMain(driver);

            pageMain.clickSignIn();
            pageLogin.signIn(login.getEmail(), login.getPassword());
            pageAccount.clickPersonalInformation();

            testLogger.info("Catching equivalence of the account data");
            softAssert.assertTrue(pagePersonalInfo.isFirstName(account));
            softAssert.assertTrue(pagePersonalInfo.isLastName(account));
            softAssert.assertTrue(pagePersonalInfo.isGender(driver, account));
            softAssert.assertTrue(pagePersonalInfo.isEmail(account));
            softAssert.assertTrue(pagePersonalInfo.isCheckboxNewsletter(account));
            softAssert.assertAll();

        pageAccount.logout();
        testLogger.info("Test passed");
    }

    @DataProvider(name = "dataProviderPersonal")
    private Object[][] dataProviderPersonal(){
        return new Object[][]
                {
                        {dataSetAccount.getDataAccount(), dataSetLogin.getDataLogin(), dataSetLogin.getDataLogin()}
                };
    }

    @Test
    public void testEditNewPersonalInfo(LoginData login, PagePersonalInfo personalInfo, Account account) {

        PagePersonalInfo pagePersonalInfo = new PagePersonalInfo(driver);
        PageAccount pageAccount = new PageAccount(driver);
        PageMain pageMain = new PageMain(driver);
        PageLogin pageLogin = new PageLogin(driver);


            pageMain.clickSignIn();
            pageLogin.signIn(login.getEmail(), login.getPassword());
            pageAccount.clickPersonalInformation();

            testLogger.info("Entering new account data");
            pagePersonalInfo.enterNewPersonalInfo(personalInfo);
            pagePersonalInfo.changePass(personalInfo);
            pagePersonalInfo.saveAndBack(account.getPass());

            pageAccount.clickPersonalInformation();

            //objectMapper.writeValue(new File("src/test/data/account.json"), new LoginData(personalInfo.getPassword()));

        pageAccount.logout();
        testLogger.info("Test passed");
    }

    @Test
    public void testEquivalenceAddressInformation() {

        PageAccount pageAccount = new PageAccount(driver);
        PageMain pageMain = new PageMain(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageAddress pageAddress = new PageAddress(driver);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Account account = objectMapper.readValue(new File("src/test/data/data.json"), Account.class);
            LoginData login = objectMapper.readValue(new File("src/test/data/account.json"), LoginData.class);

            pageMain.clickSignIn();
            pageLogin.signIn(login.getEmail(), login.getPassword());
            pageAccount.clickMyAddresses();
            pageAddress.clickUpdate();

            testLogger.info("Catching equivalence of the address data");
            softAssert.assertTrue(pageAddress.isFirstName(account));
            softAssert.assertTrue(pageAddress.isLastName(account));
            softAssert.assertTrue(pageAddress.isCompany(account));
            softAssert.assertTrue(pageAddress.isAddress(account));
            softAssert.assertTrue(pageAddress.isCity(account));
            softAssert.assertTrue(pageAddress.isState(account));
            softAssert.assertTrue(pageAddress.isPostcode(account));
            softAssert.assertTrue(pageAddress.isCountry(account));
            softAssert.assertTrue(pageAddress.isPhone(account));
            softAssert.assertAll();
        }
        catch (Exception e) {
            e.getStackTrace();
        }

        pageAccount.logout();
        testLogger.info("Test passed");
    }

    @Test
    public void testEditAddress() {

        PageAccount pageAccount = new PageAccount(driver);
        PageMain pageMain = new PageMain(driver);
        PageLogin pageLogin = new PageLogin(driver);
        PageAddress pageAddress = new PageAddress(driver);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            LoginData login = objectMapper.readValue(new File("src/test/data/account.json"), LoginData.class);
            PageAddress address = objectMapper.readValue(new File("src/test/data/address_for_change"), PageAddress.class);

            pageMain.clickSignIn();
            pageLogin.signIn(login.getEmail(), login.getPassword());
            pageAccount.clickMyAddresses();
            pageAddress.clickUpdate();

            testLogger.info("Entering new address data");
            pageAddress.changeAddressDate(address);
            testLogger.info("Catching equivalence of the address data");
            softAssert.assertEquals(pageAddress.getLOC_COMPANY().getAttribute("value"), pageAddress.getText());
            softAssert.assertEquals(pageAddress.getLOC_ADDRESS().getAttribute("value"), pageAddress.getText());
            softAssert.assertEquals(pageAddress.getLOC_CITY().getAttribute("value"), pageAddress.getText());
            softAssert.assertEquals(pageAddress.getLOC_STATE().getAttribute("value"), pageAddress.getState());
            softAssert.assertEquals(pageAddress.getLOC_POSTCODE().getAttribute("value"), pageAddress.getPostcode());
            softAssert.assertEquals(pageAddress.getLOC_PHONE().getAttribute("value"), pageAddress.getPhone());
            softAssert.assertAll();
        }
        catch (Exception e) {
            e.getStackTrace();
        }

        pageAccount.logout();
        testLogger.info("Test passed");
    }


}
