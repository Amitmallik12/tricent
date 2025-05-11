package HomePage;


	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

	import GenericUtitlity.BaseClass;
	import GenericUtitlity.Excel_Utility;
	import GenericUtitlity.ListenerUtility;
	import ObjectRepository.RegisterPage;

	@Listeners(ListenerUtility.class)
	public class RegisterTestValidation extends BaseClass {

	    @Test(dataProvider = "excelData", dataProviderClass = Excel_Utility.class)
	    public void loginTest(String username, String lastname, String email, String password, String reenterPassword) {
	        RegisterPage rp = new RegisterPage(driver);

	        rp.getRegisterLink().click();
	        rp.getFirstName().sendKeys(username);
	        rp.getLastName().sendKeys(lastname);
	        rp.getEmailField().sendKeys(email);
	        rp.getPassword().sendKeys(password);
	        rp.getRenterPassword().sendKeys(reenterPassword);
	        rp.getRegisterButton().click();
	   

	        
	        
	    WebElement passwordvalidation = wutil.waitForElementToBeVisible(driver, rp.getPasswordvalidationMessage(), 10);
	    
	    System.out.println("panakj"+passwordvalidation.getText());
	    Assert.assertEquals( passwordvalidation.getText(),"Password is required." , "password is matched");
	    
	        System.out.println("Username: " + username + "Lastname: " + lastname +"Email: " + email+ "Password: " + password);
	      
	    }
	}



