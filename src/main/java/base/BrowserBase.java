package base;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BrowserBase {
    protected WebDriver driver;
    protected Dotenv dotenv = Dotenv.configure().load();

    public WebDriver initializeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        Map<String, Object> prefs = new HashMap<>();
        Map<String, Object> contentSettings = new HashMap<>();
        contentSettings.put("popups", 2); // 2 blocks pop-ups
        prefs.put("profile", new HashMap<String, Object>() {{
            put("managed_default_content_settings", contentSettings);
        }});
        options.setExperimentalOption("prefs", prefs);

        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

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
