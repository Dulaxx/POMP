package login;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoginTest extends BaseTest {
    //private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @BeforeClass
    public void setUpClass(){
        super.setUpClass();
    }

    @Test(priority = 0, description = "Successful login")
    public void loginTest(){
        loginPage.enterUserName(dotenv.get("VALIDUSERNAME"));
        loginPage.enterPassword(dotenv.get("VALIDPASSWORD"));
        System.out.println("hmmm");
        System.out.println("System ENV USERNAME: " + System.getenv("USERNAME"));
        System.out.println("Dotenv USERNAME: " + dotenv.get("VALIDUSERNAME"));
        loginPage.clickLoginButton();
        loginPage.getLoggedInUserName();
    }



}
