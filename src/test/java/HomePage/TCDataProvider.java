package HomePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
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
public class TCDataProvider extends BaseClass {

	@Test(dataProvider = "loginData", dataProviderClass = ExcelUtility.class)
	public void logintest(String userName, String password) throws Exception, EncryptedDocumentException, IOException {
		hp = new HomePage(driver);
		wutil.mouseHover(driver, hp.getComputersH());
		hp.getAccessories().click();
		ap = new Accessoriespage(driver);
		wutil.dropDownbyVisibleText(ap.getSortBy(), "Price: High to Low");
		wutil.dropDownbyVisibleText(ap.getViewAs(), "List");
		wutil.multiple(ap.getViewAs());
		ap.getAddToCart().click();
		hp.getShoppingCart().click();

		cp = new CartPage(driver);
		wutil.dropDownbyVisibleText(cp.getCountry(), "India");
		cp.getTermClick().click();
		cp.getCheckoutButton().click();
		lp = new LoginPage(driver);
		lp.getEmailText().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login", "title displayed ");
      
		
		
		WebElement errorMsg =	wutil.waitForElementToBeVisible(driver, lp.getValidationMessage(), 20);
		Assert.assertEquals(errorMsg.getText(), "Login was unsuccessful. Please correct the errors and try again.", "Validation message match");


		cp.getCheckoutButton().click();
		cp.getAlertCross().click();
		cp.getTermClick().click();
		cp.getCheckoutButton().click();

		cop = new CheckOutPage(driver);
		wutil.dropDownbyVisibleText(cop.getCountryDropDown(), "India");
		cop.getCityAddress().sendKeys(jutil.generateRandomCityName());
		cop.getCityAddress().sendKeys(jutil.generateRandomAddress());
		cop.getPincode().sendKeys(jutil.generateRandomPincode());
		cop.getPhonenumber().sendKeys(jutil.generateRandomPhoneNumber());

		cop.getContinueButton().click();

	}

}
