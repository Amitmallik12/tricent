package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrderPage {
	
	

	//@FindBy(id =":r4:")
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1pk1fka' and @id=':r4:']")
	private WebElement inputOrderDeliveryDate;
	

	public NewOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	  public void enterOrderDeliveryDate(String date) {
	        inputOrderDeliveryDate.clear();       // clear the field first (optional)
	        inputOrderDeliveryDate.sendKeys(date); // date in yyyy-mm-dd format
	    }




}
