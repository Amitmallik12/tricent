package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateFilter {
	
	
	@FindBy(xpath = "//a[@href='/filter']")
	private WebElement  filter_button;
	
	@FindBy(xpath = "//button[normalize-space()='Create Filter']")
	private WebElement CreateFilter_Button;
	
	@FindBy(xpath = "//input[@id=':r3v:']")
	private WebElement Text_Field;
	
	@FindBy(xpath = "//input[@id=':r40:']")
	private WebElement Date_field;
	
	@FindBy(xpath ="//button[@id=':r41:']")
	private WebElement create_filter_button;

	public WebElement getFilter_button() {
		return filter_button;
	}

	public WebElement getCreateFilter_Button() {
		return CreateFilter_Button;
	}

	public WebElement getText_Field() {
		return Text_Field;
	}

	public WebElement getDate_field() {
		return date_field;
	}

	public WebElement getCreate_filter_button() {
		return create_filter_button;
	}

	private WebElement date_field;
	
	public CreateFilter(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}



