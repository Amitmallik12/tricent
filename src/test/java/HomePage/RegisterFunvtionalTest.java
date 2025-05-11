package HomePage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import GenericUtitlity.BaseClass;
import GenericUtitlity.ExcelUtility;
import GenericUtitlity.Excel_Utility;
import GenericUtitlity.ListenerUtility;
import ObjectRepository.RegisterPage;



public class RegisterFunvtionalTest  extends BaseClass{
	
	 Logger log = LogManager.getLogger(RegisterTest.class);
	 
//	 @Test(dataProvider = "excelData", dataProviderClass = Excel_Utility.class)
//	 public void TextField(String username) {
//	     RegisterPage rp = new RegisterPage(driver);
//	     rp.getRegisterLink().click();
//
//	     // Step 1: Validate that input contains only alphabets
//	     if (!username.matches("[a-zA-Z]+")) {
//	         Assert.fail("Input validation failed: only alphabetic characters are allowed. Found: " + username);
//	     }
//
//	     // Step 2: If valid, proceed to enter the input
//	     rp.getFirstName().sendKeys(username);
//	     
//	 } 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @Test(dataProvider = "excelData", dataProviderClass = Excel_Utility.class)
	 public void TextFiel(String username) {
	     RegisterPage rp = new RegisterPage(driver);
	     rp.getRegisterLink().click();

	     // Step 1: Strict validation using utility method
	     String validatedInput = jutil.getValidatedAlphabetString(username); // will throw if invalid

	     // Step 2: Proceed only if valid
	     rp.getFirstName().sendKeys(validatedInput);
	 }

}
	 
	
	 
	 

