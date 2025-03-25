package base;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.loginPage.LoginPage;

public abstract class BaseTest extends BrowserBase {
    protected static WebDriver driver;
    protected LoginPage loginPage;
    protected Dotenv dotenv = Dotenv.configure().load();
    private static boolean isSuiteLoginPerformed = false;

    @BeforeSuite
    @Parameters({"browser"})
    public void suiteSetUp(@Optional("chrome") String browser){
        if (driver == null){
            driver = initializeDriver();
            loginPage = new LoginPage(driver);

            String baseURL = dotenv.get("STAGEURL");
            driver.get(baseURL);
            //loginPage.performLogin(dotenv.get("VALIDEMAIL"),dotenv.get("VALIDPASSWORD"));
            isSuiteLoginPerformed = true;

        }
    }

    @AfterSuite
    public void tearDownSuite(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @BeforeClass
    public void setUpClass() {
        if (isSuiteLoginPerformed && driver != null) {
            loginPage = new LoginPage(driver);
        } else {
            driver = initializeDriver();
            loginPage = new LoginPage(driver);

            String baseURL = dotenv.get("STAGEURL");
            driver.get(baseURL);
            //loginPage.performLogin(dotenv.get("VALIDEMAIL"),dotenv.get("VALIDPASSWORD"));
            isSuiteLoginPerformed = true;

            isSuiteLoginPerformed = true;
        }
    }

}
