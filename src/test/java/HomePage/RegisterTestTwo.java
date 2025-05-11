package HomePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import GenericUtitlity.BaseClass;
import GenericUtitlity.ExcelUtility;
import ObjectRepository.RegisterPage;

public class RegisterTestTwo  extends BaseClass{

	  
	@Test(dataProvider = "loginDataa", dataProviderClass = ExcelUtility.class)
	    public void loginTest(String a , int c , int b ) throws EncryptedDocumentException, IOException {
		
			 
	        RegisterPage rp = new RegisterPage(driver);

	        rp.getRegisterLink().click();
	        rp.getFirstName().sendKeys(eutil.getexcelSheet("Gota", 0, 1));
	             rp.getRegisterButton().click();

	       // System.out.println("Username: " + username + "Lastname: " + lastname +"Email: " + email+ "Password: " + password);
	   

}}

