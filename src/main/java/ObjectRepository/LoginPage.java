package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


	@FindBy(id =":r0:")
	private WebElement  mobilenumber;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	

	@FindBy(xpath = "//form//input[@type='tel' and @maxlength='1']")
    private List<WebElement> otpFields;

//	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement verify_submit ; 
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getMobilenumber() {
		return mobilenumber;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}


//   public WebElement getInput_otp() {
//		return input_otp;
//	}


public WebElement getVerify_submit() {
		return verify_submit;
	}


public List<WebElement> getOtpFields() {
    return otpFields;
}





	
}
