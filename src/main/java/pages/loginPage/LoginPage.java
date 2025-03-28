package pages.loginPage;

import base.BrowserWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.ActionHelper;
import pages.utils.AssertationUtils;

public class LoginPage {
    private WebDriver driver;
    private BrowserWaits browserWaits;
    private AssertationUtils assertationUtils;
    private ActionHelper actionHelper;

    private By userName = By.id("userName");
    private By password = By.id("password");
    private By loginButton = By.id("id=\"login\"");
    private By verifyUserName = By.id("id=\"userName-value\"");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.browserWaits = new BrowserWaits(driver);
        this.assertationUtils = new AssertationUtils(driver);
        this.actionHelper = new ActionHelper(driver);
    }

    public void enterUserName(String username) {
        WebElement userInput = browserWaits.waitForElementToBeVisible(userName);
        AssertationUtils.assertElementIsDisplayed(userInput);
        actionHelper.waitAndSendKeys(userName, username);
        System.out.println("✅ Username entered: " + username);
    }

    public void enterPassword(String paswd){
        WebElement userInput = browserWaits.waitForElementToBeVisible(password);
        userInput.sendKeys(paswd);
        AssertationUtils.assertElementIsDisplayed(userInput);
        System.out.println("DT logic1");
    }

    public void clickLoginButton(){
        browserWaits.waitForElementToBeVisible(loginButton);
        actionHelper.scrollAndClick(loginButton);
        actionHelper.forceClick(loginButton);
    }

    public String getLoggedInUserName(){
        return actionHelper.waitAndGetText(verifyUserName);
    }




}
