package base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserWaits {
    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserWaits(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Wait for element to be clickable
    public WebElement waitForElementToBeClickable(By locator){
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e){
            System.err.println("Timeout: Element not clickable " + locator);
            throw e;
        }
    }

    // Wait for element to be visible with exception handling
    public WebElement waitForElementToBeVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.err.println("Timeout: Element not visible: " + locator);
            throw e;
        }
    }

    // Wait for element to be present in DOM with exception handling
    public WebElement waitForElementToBePresent(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.err.println("Timeout: Element not present in DOM: " + locator);
            throw e;
        }
    }

    // Wait for element to be invisible
    public boolean waitForElementToBeInvisible(By locator) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.err.println("Timeout: Element did not disappear: " + locator);
            return false; // Return false instead of failing the test
        }
    }

    // Wait for text to be present in element
    public boolean waitForTextToBePresent(By locator, String text) {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        } catch (TimeoutException e) {
            System.err.println("Timeout: Text not present in element: " + locator);
            return false;
        }
    }
}
