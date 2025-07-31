package GenericUtitlity;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	   private static final Logger logger = LogManager.getLogger(WebDriverUtility.class);
	
	
	public void rightClick(WebDriver driver , WebElement element ) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
   public void doubleclick(WebDriver driver , WebElement element )
	{
		Actions act = new Actions (driver);
		act.doubleClick(element).perform();
	}

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void dropDownbyVisibleText(WebElement element , String text)
	{
		Select dp = new Select(element);
		dp.selectByVisibleText(text);
	}
	
	
	public void  multiple(WebElement element)
	{
		Select dp= new Select(element);
		dp.isMultiple();
	}

	
	public void getScreenShot (WebDriver driver )throws IOException
	{
		String time = LocalDateTime.now().toString().replace(":", "-");
		TakesScreenshot ts = (TakesScreenshot)driver ;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm =  new File("./Screenshot/"+time+".png");
		FileHandler.copy(temp, perm);
		
	}
//	 public void waitForElementToBePresent(WebDriver driver, WebElement element, int timeoutInSeconds) {
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//	        wait.until(ExpectedConditions.presenceOfElementLocated((driver1) -> element));
//	    }

	    public void uploadFile(WebDriver driver, WebElement fileInput, String filePath, int timeoutInSeconds) {
	        waitForElementToBeVisible(driver, fileInput, timeoutInSeconds);
	        fileInput.sendKeys(filePath);
	    }
	
    public WebElement waitForElementToBeVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebElement visibleElement = null;
        try {
            logger.info("⏳ Waiting for element to be visible: {}", element.toString());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("✅ Element is visible: {}", element.toString());
        } catch (TimeoutException e) {
            logger.error("❌ Element was not visible within {} seconds: {}", timeoutInSeconds, element.toString());
        }
        return visibleElement;
    }
    
    
    public WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebElement clickableElement = null;
        try {
            logger.info("⏳ Waiting for element to be clickable: {}", element.toString());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            logger.info("✅ Element is clickable: {}", element.toString());
        } catch (TimeoutException e) {
            logger.error("❌ Element was not clickable within {} seconds: {}", timeoutInSeconds, element.toString());
        }
        return clickableElement;
    }
	
	public void typeAndClearWithMouse(WebDriver driver, WebElement element, String text) {
	    Actions act = new Actions(driver);
	    act.moveToElement(element)
	       .click()
	       .sendKeys(text)
	       .doubleClick()
	       .sendKeys(Keys.BACK_SPACE)
	       .perform();
	}

	
	 // Accept the alert and return its text
    public String acceptAlertAndGetText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
    public List<WebElement> waitForElementsToBeVisible(WebDriver driver, List<WebElement> elements, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }
   
	
	
} 