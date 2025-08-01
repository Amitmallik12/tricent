package dashboard;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtitlity.BaseClass;
import GenericUtitlity.ListenerUtility;
import GenericUtitlity.WebDriverUtility;
import ObjectRepository.CreateFilter;


@Listeners(ListenerUtility.class)
public class CreateFilter_New extends BaseClass{
	
	@Test
	public void Create_filter() {
		cf = new CreateFilter(driver);
	
		WebElement filtername = wutil.waitForElementToBeVisible(driver, cf.getText_Field(), 10);
		filtername.sendKeys("GK ORDER");
		
		WebElement selectDate = wutil.waitForElementToBeClickable(driver, cf.getDate_field(), 10);
		selectDate.sendKeys("2025-08-31");
		
		
		
	}
	
	
	
	
	
	

}
