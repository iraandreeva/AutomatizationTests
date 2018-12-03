import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(TestClassListener.class)
public class TestClass {

    @DataProvider(name = "Numbers")
    public static Object[][] dataProv() {
        return new Object[][]
        {{1 , 4}, {6, 1}, {3, 1}};
    }

    @Test(dataProvider = "Numbers", groups = "Group")
    public void testEquals(int n1, int n2) {

        Assert.assertEquals(n1, n2);

    }

    @Test(dependsOnMethods="testEquals", dataProvider = "Numbers", groups = "Group")
    public void testNotEquals(int n1, int n2) {

        Assert.assertNotEquals(n1, n2);

    }

    @DataProvider(name = "Boolean")
    public static Object[][] dataProvider() {
        return new Object[][]
                {{true}, {false}};
    }

    @Test(dataProvider = "Boolean")
    public void testTrue(boolean n) {

        Assert.assertTrue(n, "True");

    }

    @Test(dataProvider = "Boolean")
    public void testFalse(boolean n) {

        Assert.assertFalse(n, "False");

    }

    @Test
    public void testFail() {

        Assert.fail("Fail");

    }

    @Test
    @Parameters({ "num1", "num2" })
    public void testParametrized(int num1, int num2) {

        Assert.assertEquals(num1, num2);

    }

    @Test(dataProvider = "Numbers")
    public void testSoftAssert(int n1, int n2) {

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(n1, n2);

    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite method");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class method");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before Groups method");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("After Groups method");
    }



}
