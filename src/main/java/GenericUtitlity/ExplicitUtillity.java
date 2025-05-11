package GenericUtitlity;

import java.time.Duration;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitUtillity {
	
	
	public WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement waitForPresenceOfElement(WebDriver driver, By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public Alert waitForAlertToBePresent(WebDriver driver, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.alertIsPresent());
	}

	public boolean waitForTitleToBe(WebDriver driver, String expectedTitle, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.titleIs(expectedTitle));
	}
	
	public boolean waitForUrlToContain(WebDriver driver, String partialUrl, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.urlContains(partialUrl));
	}

	public boolean waitForTextToBePresent(WebDriver driver, By locator, String text, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	
	public boolean waitForElementToBeInvisible(WebDriver driver, By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitForFrameAndSwitchToIt(WebDriver driver, By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public boolean waitForNumberOfWindowsToBe(WebDriver driver, int numberOfWindows, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
	}

}
