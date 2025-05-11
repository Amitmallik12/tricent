package ObjectRepository;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath ="//a[text()='Log in']")
	private WebElement loginClick;
	
	@FindBy(xpath ="//a[text()='New products']")
	private WebElement newProduct;
	 
    @FindBy(xpath ="//ul[@class='top-menu']//a[normalize-space()='Computers']")
	private WebElement ComputersH;
	 
	@FindBy(xpath ="//ul[@class='sublist firstLevel active']//a[normalize-space()='Accessories']")
	private WebElement Accessories;
	 
@FindBy(xpath="//span[@class='cart-label'][text()='Shopping cart']")
private WebElement ShoppingCart;
	
@FindBy(xpath ="//img[@alt='Tricentis Demo Web Shop']")
private WebElement icon;
	


	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getShoppingCart() {
	return ShoppingCart;
}

	public WebElement getIcon() {
		return icon;
	}


	public WebElement getloginClick() {
		return loginClick;
	}
	public WebElement getNewProduct() {
		return newProduct;
	}
	public WebElement getAccessories() {
		return Accessories;
	}

	public WebElement getComputersH() {
		return ComputersH;
	}

	
	 @FindBy(tagName = "a")
	    private List<WebElement> allLinks;

	    public void checkBrokenLinks() {
	        System.out.println("🔍 Checking " + allLinks.size() + " links...");

	        for (WebElement link : allLinks) {
	            String url = link.getAttribute("href");

	            if (url == null || url.isEmpty() || !url.startsWith("http")) {
	                continue;
	            }

	            try {
	                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
	                conn.setRequestMethod("HEAD");
	                conn.connect();
	                int respCode = conn.getResponseCode();

	                if (respCode >= 400) {
	                    System.out.println("❌ Broken link: " + url + " | Status: " + respCode);
	                } else {
	                    System.out.println("✅ Valid link: " + url + " | Status: " + respCode);
	                }

	            } catch (Exception e) {
	                System.out.println("⚠️ Error checking: " + url + " | Message: " + e.getMessage());
	            }
	        }

	

	    }


}
