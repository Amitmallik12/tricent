package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	@FindBy(xpath="//select[@id='billing-address-select']")
	private WebElement billingAddress;
	
	
	
	


	@FindBy(xpath="//Select[@id='BillingNewAddress_CountryId']")
	private WebElement CountryDropDown;
	 
	

	public WebElement getCountryDropDown() {
		return CountryDropDown;
	}



	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	private WebElement CityAddress;
	 
	
	@FindBy(xpath ="//input[@id='BillingNewAddress_Address1']")
	private WebElement addressone;
	 
	
	@FindBy(xpath ="//input[@id='BillingNewAddress_ZipPostalCode']")
	private WebElement pincode;
	 
	@FindBy(xpath= "//input[@id='BillingNewAddress_PhoneNumber']")
    private WebElement Phonenumber ;
	  
	@FindBy(xpath= "//input[@onclick='Billing.save()']")
    private WebElement continueButton ;
	  
	

	public WebElement getContinueButton() {
		return continueButton;
	}



	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getCityAddress() {
		return CityAddress;
	}



	public WebElement getAddressone() {
		return addressone;
	}



	public WebElement getPincode() {
		return pincode;
	}



	public WebElement getPhonenumber() {
		return Phonenumber;
	}
	
	

	public WebElement getBillingAddress() {
		return billingAddress;
	}

	

}
