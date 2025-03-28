package pages.loginPage;

import base.BrowserWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private BrowserWaits browserWaits;

    private By userName = By.id("userName");
    private By password = By.id("password");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.browserWaits = new BrowserWaits(driver);
    }

    public void enterUserName(String username){
        WebElement userInput = browserWaits.waitForElementToBeVisible(userName);
        userInput.sendKeys(username);
        System.out.println("DT need logic");
    }

    public void enterPassword(String paswd){
        WebElement userInput = browserWaits.waitForElementToBeVisible(password);
        userInput.sendKeys(paswd);
        System.out.println("DT logic1");
    }




}
