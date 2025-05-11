package GenericUtitlity;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.Accessoriespage;
import ObjectRepository.CartPage;
import ObjectRepository.CheckOutPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.RegisterPage;

public class BaseClass {
	public static ExtentSparkReporter sparkReporter; // ui of the report
	public static ExtentReports extReport; // populaye common info of the report
	public static ExtentTest test; // creating test entry in thr report and upload status of test method
	public static WebDriver driver;

	public Excel_Utility eeutil = new Excel_Utility();
	public JavaUtility jutil = new JavaUtility();
	public FileUtility futil = new FileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public ExcelUtility eutil = new ExcelUtility();

	public Logger logger;

	public HomePage hp;
	public LoginPage lp;
	public Accessoriespage ap;
	public CartPage cp;
	public CheckOutPage cop;
	public RegisterPage rp;

	@BeforeSuite
	public void extentReport() {
		String time = LocalDateTime.now().toString().replace(":", "-");
		sparkReporter = new ExtentSparkReporter("./HTML_Report/" + time + ".html");

		extReport = new ExtentReports();
		extReport.attachReporter(sparkReporter);
	}

//	@BeforeClass
//	public void openBrowser() throws IOException {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get(futil.getReadDatafromProperty("url"));
//	}
//	
	
	@BeforeClass
    public void openBrowser() throws IOException {
        String browser = futil.getReadDatafromProperty("browser");
        String url = futil.getReadDatafromProperty("url");

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);
    }


	public void onTestFailure(ITestResult result) throws IOException {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

//	@AfterClass
//	public void closeBroswer()
//	{
//		driver.quit();
//	}

	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}

}