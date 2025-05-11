package LoginPage;

import org.testng.annotations.Test;

import GenericUtitlity.BaseClass;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class looginPage extends BaseClass {
	
	
	@Test
	public void loginFiled() {
	
		
		hp = new HomePage(driver);
		// wutil.mouseHover(driver, hp.getloginClick());
	 hp.getloginClick().click();
	
	lp = new LoginPage(driver);
	lp.getEmailText().sendKeys(jutil.generateRandomEmail());
	lp.getPassword().sendKeys(jutil.generateRandomPassword());

	
	
	}

}
