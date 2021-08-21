package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {
    WebDriver driver;
//    public static LogLog4j log4j = new LogLog4j();

    public void editField(WebElement field, String value) {
        field.click();
        field.sendKeys(value);
    }

    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsArePresent(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsAreVisible(List<WebElement> listElements, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(listElements));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementTextIs(By locator, String text, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementTextIs(WebElement element, String text, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element,text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsInvisible(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementsBecome(By locator, int quantity, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.numberOfElementsToBe(locator,quantity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementsBecome(List<WebElement> listElements, int quantity, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.numberOfElementsToBe((By) listElements,quantity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilWindowsToBe(int quantity, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.numberOfWindowsToBe(quantity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAnotherHandle(String handleWindowFirst) {
        String res = "";
        for (String handle: driver.getWindowHandles()){
            if (!handle.equals(handleWindowFirst)) res= handle;
        }
        return res;
    }

    public void turnLandscape() {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void turnPortrait() {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void runBackground(int time) {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.runAppInBackground(Duration.ofSeconds(time));
    }

    protected void closeCurrentWindow() {
        driver.close();
    }

}



