package HomePage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtitlity.BaseClass;
import GenericUtitlity.ListenerUtility;
import ObjectRepository.HomePage;


@Listeners(ListenerUtility.class)
public class LogoVerification  extends BaseClass{
	
	@Test
	  public void veriftlogin()
	  
	  { hp = new HomePage(driver);
	   WebElement icon = hp.getIcon();
	 
	   Assert.assertTrue(icon.isDisplayed(), "Icon is Displayed");
	   Assert.assertTrue(icon.isEnabled(), "Icon is enabled ");

	   hp.checkBrokenLinks();
		  
	  }
	
}
