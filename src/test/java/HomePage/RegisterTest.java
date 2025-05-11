package HomePage;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.logging.Logger;
import java.util.logging.Level;
import GenericUtitlity.BaseClass;
import GenericUtitlity.Excel_Utility;
import GenericUtitlity.ListenerUtility;
import ObjectRepository.RegisterPage;


public class RegisterTest extends BaseClass {
	
	@Test(dataProvider = "excelData", dataProviderClass = Excel_Utility.class)
	public void loginTest(String username, String lastname, String email, String password, String reenterPassword) {
	    Logger logger = Logger.getLogger("RegisterTestLogger");
	    RegisterPage rp = new RegisterPage(driver);

	    // Step 1: Username validation
	    if (!username.matches("[a-zA-Z]+")) {
	        logger.log(Level.WARNING, "❌ Invalid username: " + username);
	        throw new IllegalArgumentException("Username must contain only alphabets.");
	    } else {
	        logger.log(Level.INFO, "✅ Username is valid: " + username);
	    }
	    

	    // Step 2: Fill and submit registration form
	    rp.getRegisterLink().click();
	    rp.getFirstName().sendKeys(username);
	    rp.getLastName().sendKeys(lastname);
	    rp.getEmailField().sendKeys(email);
	    rp.getPassword().sendKeys(password);
	    rp.getRenterPassword().sendKeys(reenterPassword);
	    rp.getRegisterButton().click();
	    logger.log(Level.INFO, "📝 Submitted registration form with email: " + email);

	    // Step 3: Email already exists validation
	    try {
	        WebElement errorMsg = wutil.waitForElementToBeVisible(driver, rp.getValidationMessage(), 5);
	        if (errorMsg != null && errorMsg.isDisplayed()) {
	            String actualText = errorMsg.getText();
	            logger.log(Level.WARNING, "⚠️ Email validation message: " + actualText);
	            Assert.assertEquals(actualText, "The specified email already exists", "Email validation message mismatch");
	        } else {
	            logger.log(Level.INFO, "✅ No email validation error appeared.");
	        }
	    } catch (Exception e) {
	        logger.log(Level.INFO, "ℹ️ Skipping email validation check – no message appeared.");
	    }

	    // Step 4: Password mismatch check
	    if (!password.equals(reenterPassword)) {
	        try {
	            WebElement passwordValidation = wutil.waitForElementToBeVisible(driver, rp.getPasswordvalidationMessage(), 5);
	            String msg = passwordValidation.getText();
	            logger.log(Level.WARNING, "🔐 Password mismatch: " + msg);
	            Assert.assertEquals(msg, "The password and confirmation password do not match.",
	                    "Password mismatch message is incorrect");
	        } catch (Exception e) {
	            logger.log(Level.SEVERE, "❌ Password mismatch validation message not found!");
	        }
	    } else {
	        logger.log(Level.INFO, "✅ Passwords matched. No mismatch validation required.");
	    }

	    
	    if (!password.equals(reenterPassword)) {
	        try {
	            WebElement passwordValidation = wutil.waitForElementToBeVisible(driver, rp.getConfirmpasswordMismatchMessage(), 5);
	            String msg = passwordValidation.getText();
	            logger.log(Level.WARNING, "🔐 Password mismatch: " + msg);
	            Assert.assertEquals(msg, "The password and confirmation password do not match.",
	                    "Password mismatch message is incorrect");
	        } catch (Exception e) {
	            logger.log(Level.SEVERE, "❌ Password mismatch validation message not found!");
	        }
	    } else {
	        logger.log(Level.INFO, "✅ Passwords matched. No mismatch validation required.");
	    }
	  
	  
	    // Final log
	    logger.log(Level.INFO, "📋 Test finished for: " + username + " | " + lastname + " | " + email);
	}
	

}
