package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


	@FindBy(id ="Email")
	private WebElement emailText;
	
	@FindBy(id="Password")
	private WebElement password;
	

	@FindBy(xpath="//input[@value='Log in']")
	private WebElement loginButton;
	
	@FindBy(xpath="//span[text()='Login was unsuccessful. Please correct the errors and try again.']")
	private WebElement validationMessage;
	


	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
  
	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getEmailText() {
		return emailText;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getValidationMessage() {
		return validationMessage;
	}
	
	
	


	
}
