 package GenericUtitlity;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extReport.createTest(result.getName());
        test.log(Status.PASS, "Test case passed: " + result.getName());
        Reporter.log("Test case PASSED: " + result.getName(), true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extReport.createTest(result.getName());  // ❗Initialize here too!
        test.log(Status.FAIL, "Test case FAILED: " + result.getName());
        test.log(Status.FAIL, result.getThrowable()); // log the stack trace

        TakesScreenshot ts = (TakesScreenshot) driver;
        String screenshot = ts.getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(screenshot, "Failure Screenshot");

        try {
            wutil.getScreenShot(driver); // optional file-based screenshot
        } catch (IOException e) {
            e.printStackTrace();
        }

        Reporter.log("Test case FAILED: " + result.getName(), true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extReport.createTest(result.getName()); // ❗Initialize here too!
        test.log(Status.SKIP, "Test case SKIPPED: " + result.getName());
        test.log(Status.SKIP, result.getThrowable());
        Reporter.log("Test case SKIPPED: " + result.getName(), true);
    }
}

















































/*
package GenericUtitlity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener {
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method 
		
	    test =extReport.createTest(result.getName());
	
		test.log(Status.PASS,"test case passed is :"+result.getName());
		Reporter.log("test scripted is passed ",true);
		
	}


	
	
//	@Override
//	public void onTestFailure(ITestResult result)   {
//		Reporter.log("test scripted is failed ",true);
//		
//		//test.log(Status.FAIL, "Test script is failed");
//	
//		String time = LocalDateTime.now().toString().replace(":", "-");
//		TakesScreenshot ts = (TakesScreenshot)driver ;	
//		File temp = ts.getScreenshotAs(OutputType.FILE);
//		File perm =  new File("./Screenshot/"+time+".png");
//		try {
//			FileHandler.copy(temp, perm);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
		
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test script is failed");
		TakesScreenshot ts=(TakesScreenshot) driver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		
		try {
			wutil.getScreenShot(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("test scripted is SKIPPED ",true);
	}

	
	
}

*/
