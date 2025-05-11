package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accessoriespage {
	
	
	@FindBy(xpath="//select[@id='products-orderby']")
	private WebElement sortBy;
	 
	
	@FindBy(xpath ="//ul[@class='sublist firstLevel active']//a[normalize-space()='Accessories']")
	private WebElement display;
	 
	
	@FindBy(xpath ="//select[@id='products-viewmode']")
	private WebElement viewAs;
	 

	@FindBy(xpath ="//div[@data-productid='66']//input[@class='button-2 product-box-add-to-cart-button']")
	private WebElement addToCart;
	 
	
	
	public Accessoriespage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getSortBy() {
		return sortBy;
	}

	public WebElement getDisplay() {
		return display;
	}

	public WebElement getViewAs() {
		return viewAs;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}


}
