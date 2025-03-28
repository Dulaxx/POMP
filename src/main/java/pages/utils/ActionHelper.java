package pages.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions actions;

    public ActionHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default 10s timeout
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    // Wait and Click
    public void waitAndClick(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("Clicked on element: " + locator);
        } catch (Exception e) {
            System.err.println("Failed to click on element: " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    // JavaScript Click (For elements that Selenium can't click)
    public void jsClick(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            js.executeScript("arguments[0].click();", element);
            System.out.println("JS Click performed on: " + locator);
        } catch (Exception e) {
            System.err.println("Failed JS Click on: " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    // Force Click (Using JavaScript if normal click fails)
    public void forceClick(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            try {
                element.click(); // Try normal click
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", element); // Fall back to JS click
                System.out.println("Force Click (JS) performed on: " + locator);
            }
        } catch (Exception e) {
            System.err.println("Failed Force Click on: " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    // Scroll to Element and Click
    public void scrollAndClick(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
            System.out.println("Scrolled and clicked on: " + locator);
        } catch (Exception e) {
            System.err.println("Failed to scroll and click: " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    // Wait and Send Keys
    public void waitAndSendKeys(By locator, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear(); // Ensure the input field is cleared before entering text
            element.sendKeys(text);
            System.out.println("Sent keys to: " + locator + " - Value: " + text);
        } catch (Exception e) {
            System.err.println("Failed to send keys to: " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    // Wait and get text of string
    public String waitAndGetText(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            String text = element.getText();
            System.out.println("Extracted text from : " + locator + " - Value: " + text);
            return text;
        } catch (Exception e) {
            System.err.println("Failed to obtained the text : " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    // Actions Click (Useful for hovering elements)
    public void actionsClick(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            actions.moveToElement(element).click().perform();
            System.out.println("Actions Click performed on: " + locator);
        } catch (Exception e) {
            System.err.println("Failed Actions Click on: " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    // Hover Over Element
    public void hoverOverElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            actions.moveToElement(element).perform();
            System.out.println("Hovered over element: " + locator);
        } catch (Exception e) {
            System.err.println("Failed to hover over element: " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    // Clear Input Field (Ensures input field is empty)
    public void clearInputField(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
            element.sendKeys(Keys.BACK_SPACE); // Clear input
            System.out.println("Cleared input field: " + locator);
        } catch (Exception e) {
            System.err.println("Failed to clear input field: " + locator + " - " + e.getMessage());
            throw e;
        }
    }


}
