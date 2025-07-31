package dashboard;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import GenericUtitlity.BaseClass;
import ObjectRepository.BulkOrder;
import ObjectRepository.LoginPage;

public class Bulk_Order extends BaseClass {

	@Test
	public void bulk_order() {
		lp = new LoginPage(driver);
		bo = new BulkOrder(driver);
		
		

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

		bo.getCreatebulkorder_button().click();
		bo.getStorename_dropdown().click();
		bo.getStoreOptionOutsideKumudu().click();

		
		// Wait for the file input element to be present
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("file-upload")));

				
		String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "\\src\\test\\resources\\TestData\\cleaned_4_rows_only.csv";
         wutil.uploadFile(driver, bo.getUploadCsvInput(), filePath, 10);
		
		
     WebElement button= wutil.waitForElementToBeVisible(driver,bo.getCreateorder_button(),30);
		button.click();
	
	
    WebElement go_home= wutil.waitForElementToBeVisible(driver,bo.getGo_Home(),300);
		go_home.click();
	}
	

}

