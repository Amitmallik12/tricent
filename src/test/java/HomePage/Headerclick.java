package HomePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtitlity.BaseClass;
import GenericUtitlity.ListenerUtility;
import ObjectRepository.Accessoriespage;
import ObjectRepository.CartPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;


@Listeners(ListenerUtility.class)
public class Headerclick extends BaseClass {


	@Test
	public void headerclick () throws EncryptedDocumentException, IOException
	{
		hp= new HomePage(driver);
     wutil.mouseHover(driver, hp.getComputersH());
     hp.getAccessories().click();
     ap= new Accessoriespage(driver);
wutil.dropDownbyVisibleText(ap.getSortBy(),"Price: High to Low");		
wutil.dropDownbyVisibleText(ap.getViewAs(),"List");	
wutil.multiple(ap.getViewAs());
ap.getAddToCart().click();
hp.getShoppingCart().click();

cp = new  CartPage(driver);
wutil.dropDownbyVisibleText(cp.getCountry(), "India");
cp.getTermClick().click();
cp.getCheckoutButton().click();  
lp = new LoginPage(driver);
lp.getEmailText().sendKeys(eutil.getexcelSheet("Dota", 1, 0));
lp.getPassword().sendKeys(eutil.getexcelSheet("Dota", 1, 1));
lp.getLoginButton().click();
//Assert.assertEquals("Demo Web Shop. Shopping Cart" , cp.getTitle(), "title displayed ");
Assert.assertEquals("Demo Web Shop. Shopping Cart",driver.getTitle(), "ok");
 WebElement string = cp.getTitle();	

System.out.println("ok:" +string);
System.out.println("pankaj");
}

}