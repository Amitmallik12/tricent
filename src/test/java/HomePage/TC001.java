package HomePage;


import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GenericUtitlity.BaseClass;
import GenericUtitlity.ListenerUtility;
import GenericUtitlity.MyRetry;
import ObjectRepository.HomePage;
import freemarker.log.Logger;
@Listeners(ListenerUtility.class)
public class TC001 extends BaseClass {
	
	
	@Test(retryAnalyzer = MyRetry.class) 
	public void clickonRegister()
	{
  	hp = new HomePage(driver);
		// wutil.mouseHover(driver, hp.getloginClick());
	 hp.getloginClick().click();
	
	String ab = driver.getCurrentUrl();
	System.out.println(ab);
		Assert.assertEquals(driver.getCurrentUrl(),"https://demowebshop.tricentis.com/login");
	
		driver.navigate().back();
		Assert.assertEquals("Demo Web Shp",driver.getTitle(), "title match");
   driver.navigate().forward();
  
		

	}
	
	
	

}
