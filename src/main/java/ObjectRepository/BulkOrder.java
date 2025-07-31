package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BulkOrder {
	
	
	@FindBy(xpath ="//a[@href='/order']//div[contains(@style, 'border-radius: 50%')]")
	private WebElement  createorder_icon;
	

	@FindBy(xpath ="//div[text()='Create Bulk Order']")
	private WebElement  createbulkorder_button;
	

	@FindBy(id =":r1d:")
	 private WebElement  storename_dropdown;
	
	 @FindBy(xpath = "//li[contains(text(),'Outside KUMUDU')]") // Selectable option
	 private WebElement storeOptionOutsideKumudu;
	 


   @FindBy(xpath ="//label[@for='file-upload']")
	private WebElement upload_csv;
   
	
   @FindBy(id = "file-upload")
   private WebElement uploadCsvInput;
	

	@FindBy(id =":r1g:")
	private WebElement createorder_button;
	  
	
	@FindBy(xpath ="//button[@id=':r1n:']")
	private WebElement go_Home;






	public BulkOrder(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getCreateorder_icon() {
		return createorder_icon;
	}

	
	public WebElement getCreatebulkorder_button() {
		return createbulkorder_button;
	}

	public WebElement getStorename_dropdown() {
		return storename_dropdown;
	}


	public WebElement getUpload_csv() {
		return upload_csv;
	}
	
	public WebElement getStoreOptionOutsideKumudu() {
		return storeOptionOutsideKumudu;
	}
	
	  public WebElement getUploadCsvInput() {
	        return uploadCsvInput;
	    }
		
		public WebElement getCreateorder_button() {
			return createorder_button;
		}
		
		public WebElement getGo_Home() {
			return go_Home;
		}
		
		
}
