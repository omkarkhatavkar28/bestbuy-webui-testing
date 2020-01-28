package common;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

    public synchronized static void moveToElementAndClick(WebElement element) {
        Actions action = new Actions(DriverManager.getDriver());
        try {
            action.moveToElement(element).click().build().perform();
        } catch (Exception error) {
            ((JavascriptExecutor) DriverManager.getDriver()).
                    executeScript("arguments[0].click();", element);
        }
    }

    public synchronized static void waitForElementToBeDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public synchronized static void waitForElementTextInvisible(String locator, String text) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(locator), text));
    }

    public synchronized static void waitForElementContainsText(String locator, String text) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(locator), text));
    }

    public synchronized static void selectFromDropDown(WebElement element, String value) {
        Select dropDownList = new Select(element);
        dropDownList.selectByVisibleText(value);
    }

    public synchronized static boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}