package GenericUtitlity;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	
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
	


	public WebElement waitForElementToBeVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	
} 