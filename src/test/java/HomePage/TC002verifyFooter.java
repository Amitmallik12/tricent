package HomePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtitlity.BaseClass;
import ObjectRepository.HomePage;

public class TC002verifyFooter extends BaseClass {

	@Test
	public void verifyFooter() {
	    hp = new HomePage(driver);
	    
	    // Scroll to the element using JavaScriptExecutor
	    WebElement footerElement = hp.getNewProduct();
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerElement);

	    // Add a slight delay if necessary to allow for scrolling animation
	    try {
	        Thread.sleep(500); // optional
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    String a = footerElement.getText();
	    Assert.assertEquals(a, "text value", "wrong text");
	}

}
