package GenericUtitlity;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int maxRetryCount = 2; // Retry failed test 2 times max

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("🔁 Retrying test: " + result.getName() + " | Attempt: " + retryCount);
            return true;
        }
        return false;
    }{

}
}