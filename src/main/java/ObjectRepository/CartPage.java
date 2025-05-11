package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {


	@FindBy(xpath="//select[@id='CountryId']")
	private WebElement Country;
	 
	
	@FindBy(xpath ="//input[@id='termsofservice']")
	private WebElement termClick;
	 
	
	@FindBy(xpath ="//button[@id='checkout']")
	private WebElement checkoutButton;
	 
	@FindBy(xpath= "//title[text()='Demo Web Shop. Shopping Cart']")
    private WebElement title ;
	  
	@FindBy(xpath ="//a[@class='ico-logout']")
	private WebElement logoutButton ;

	
	

	public WebElement getLogoutButton() {
		return logoutButton;
	}


	public WebElement getAlertCross() {
		return AlertCross;
	}


	@FindBy(xpath ="//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	private WebElement AlertCross ;

	
	
	
	
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getTitle() {
		return title;
	}


	public WebElement getCountry() {
		return Country;
	}


	public WebElement getTermClick() {
		return termClick;
	}


	public WebElement getCheckoutButton() {
		return checkoutButton;
	}
	
	
}
