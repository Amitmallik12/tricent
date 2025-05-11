package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement RegisterLink;

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastName;

	public WebElement getLastName() {
		return lastName;
	}

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement EmailField;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement Password;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement renterPassword;

	@FindBy(xpath = "//input[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//li[text()='The specified email already exists']")
	private WebElement validationMessage;

	@FindBy(xpath = "//span[@for='Password']")
	private WebElement passwordvalidationMessage;

	@FindBy(xpath = "//span[@for='ConfirmPassword']")
	private WebElement confirmpasswordMismatchMessage;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getConfirmpasswordMismatchMessage() {
		return confirmpasswordMismatchMessage;
	}

	public WebElement getPasswordvalidationMessage() {
		return passwordvalidationMessage;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getEmailField() {
		return EmailField;
	}

	public WebElement getValidationMessage() {
		return validationMessage;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getRenterPassword() {
		return renterPassword;
	}

	public WebElement getRegisterLink() {
		return RegisterLink;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

}
