package dashboard;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericUtitlity.BaseClass;
import ObjectRepository.BulkOrder;
import ObjectRepository.LoginPage;
import ObjectRepository.NewOrderPage;

public class NeworderPage extends BaseClass {
	  
	   @Test 
	    public void loginFiled() {
	        lp = new LoginPage(driver);
	        bo = new BulkOrder(driver);
	        nop = new NewOrderPage(driver);

	        // Wait for mobile number input to be visible and enter mobile number
	        WebElement mobileField = wutil.waitForElementToBeVisible(driver, lp.getMobilenumber(), 10);
	        mobileField.sendKeys("9015106615");

	        // Wait for login button to be clickable (after number is entered)
	        WebElement loginBtn = wutil.waitForElementToBeClickable(driver, lp.getLoginButton(), 10);
	        loginBtn.click();
	        
	  
	        List<WebElement> otpBoxes = wutil.waitForElementsToBeVisible(driver, lp.getOtpFields(), 10);

	        // Your test OTP
	        String otp = "121212";

	        // Fill OTP one by one
	        for (int i = 0; i < otp.length(); i++) {
	            otpBoxes.get(i).sendKeys(String.valueOf(otp.charAt(i)));
	        }

	        // Click "Verify & Proceed"
	        lp.getVerify_submit().click();
	        
	        WebElement icon = wutil.waitForElementToBeVisible(driver, bo.getCreateorder_icon(), 100);
			icon.click();

	        
	         nop.enterOrderDeliveryDate("15-08-2025");
	        

}
	   }
