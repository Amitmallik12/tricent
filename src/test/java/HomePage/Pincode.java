package HomePage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtitlity.BaseClass;
import GenericUtitlity.ExcelUtility;
import GenericUtitlity.ListenerUtility;
import ObjectRepository.Accessoriespage;
import ObjectRepository.CartPage;
import ObjectRepository.CheckOutPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

@Listeners(ListenerUtility.class)
public class Pincode extends BaseClass {

	@Test
	public void logintest() throws Exception, EncryptedDocumentException, IOException {

		hp = new HomePage(driver);
		hp.getloginClick().click();
		lp = new LoginPage(driver);

		lp.getEmailText().sendKeys("mn093@gmail.com");
		lp.getPassword().sendKeys("pankaj@123P");
		lp.getLoginButton().click();
		hp.getShoppingCart().click();
		cp = new CartPage(driver);
		cp.getTermClick().click();
		cp.getCheckoutButton().click();
		cop = new CheckOutPage(driver);
		wutil.dropDownbyVisibleText(cop.getBillingAddress(), "New Address");

		cop.getPincode().clear();
		cop.getPincode().sendKeys("");
		String value = cop.getPincode().getAttribute("value");
		assertTrue(value.isEmpty(), "Pincode field should be empty");

		cop.getPincode().clear();
		cop.getPincode().sendKeys("1234567");
		String valueone = cop.getPincode().getAttribute("value");
		System.out.println(valueone);
		assertFalse(value.matches("^\\d{6}$"), "Long pincode should not be accepted: actual value = " + value);

		// assertNotEquals(6, value.length(), "Long pincode should not be accepted");

	}

}
