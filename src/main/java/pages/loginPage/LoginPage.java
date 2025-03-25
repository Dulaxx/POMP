package pages.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By userName = By.id("userName");
    private By password = By.id("password");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUserName(){
        System.out.println("DT need logic");
    }

    public void enterPassword(){
        System.out.println("DT logic1");
    }




}
