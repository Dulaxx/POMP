package pages.utils;

import base.BrowserWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertationUtils {
    private WebDriver driver;
    private BrowserWaits browserWaits;

    public AssertationUtils(WebDriver driver){
        this.driver =driver;
        this.browserWaits =new BrowserWaits(driver);
    }

    // Assert that two strings are equal
    public static void assertTextEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected, "❌ Assertion Failed: Text does not match!");
        System.out.println("✅ Assertion Passed: Text matches - " + actual);
    }

    // Assert that a web element's text is equal to expected
    public static void assertElementTextEquals(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, "❌ Assertion Failed: Element text mismatch!");
        System.out.println("✅ Assertion Passed: Element text matches - " + actualText);
    }

    // Assert that an element is displayed
    public static void assertElementIsDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "❌ Assertion Failed: Element is not displayed!");
        System.out.println("✅ Assertion Passed: Element is displayed.");
    }

    // Assert that an element is enabled
    public static void assertElementIsEnabled(WebElement element) {
        Assert.assertTrue(element.isEnabled(), "❌ Assertion Failed: Element is disabled!");
        System.out.println("✅ Assertion Passed: Element is enabled.");
    }

    // Assert that an element is selected (for checkboxes, radio buttons)
    public static void assertElementIsSelected(WebElement element) {
        Assert.assertTrue(element.isSelected(), "❌ Assertion Failed: Element is not selected!");
        System.out.println("✅ Assertion Passed: Element is selected.");
    }

    // Assert that two numbers are equal
    public static void assertNumbersEqual(int actual, int expected) {
        Assert.assertEquals(actual, expected, "❌ Assertion Failed: Numbers do not match!");
        System.out.println("✅ Assertion Passed: Numbers match - " + actual);
    }

    // Assert that a condition is true
    public static void assertConditionTrue(boolean condition, String message) {
        Assert.assertTrue(condition, "❌ Assertion Failed: " + message);
        System.out.println("✅ Assertion Passed: " + message);
    }

    // Assert that a condition is false
    public static void assertConditionFalse(boolean condition, String message) {
        Assert.assertFalse(condition, "❌ Assertion Failed: " + message);
        System.out.println("✅ Assertion Passed: " + message);
    }

    // Assert that an element contains a specific text
    public static void assertElementContainsText(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains(expectedText),
                "❌ Assertion Failed: Expected text '" + expectedText + "' not found in element!");
        System.out.println("✅ Assertion Passed: Element contains text - " + expectedText);
    }

    // Assert that a string contains another string
    public static void assertStringContains(String actual, String expectedSubstring) {
        Assert.assertTrue(actual.contains(expectedSubstring),
                "❌ Assertion Failed: String does not contain expected substring!");
        System.out.println("✅ Assertion Passed: String contains - " + expectedSubstring);
    }
}
