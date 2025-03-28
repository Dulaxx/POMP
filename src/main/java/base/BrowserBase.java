package base;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

public class BrowserBase {
    protected WebDriver driver;
    protected Dotenv dotenv = Dotenv.configure().load();

    public WebDriver initializeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
        return this.driver;
    }

    @AfterSuite
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
