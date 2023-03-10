package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int count = 0;
    int retryCount = 3;

    public boolean retry(ITestResult result) {
        if (count < retryCount) {
            count++;
            return true;
        }
        else {
            return false;
        }
    }
}
