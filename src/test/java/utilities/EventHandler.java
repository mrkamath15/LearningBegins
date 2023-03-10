package utilities;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventHandler extends BaseTest implements ITestListener  {
    public ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    private static Logger logger = LogManager.getLogger();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED");
        logger.info("Test " + result.getName() + " started");
        extentTest = extentReports.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST SUCCESS");
        logger.info("Test " + result.getName() + " PASSED");
        String logText = "Test case " + result.getName() + " is passed";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.log(Status.PASS, m);
        captureScreenshot(result.getName());
        String screenshotForReport = Constants.SCREENSHOT_FOLDER_FOR_REPORTS + "/" + result.getName() + ".png";
        extentTest.info("Screenshot attached :", MediaEntityBuilder.createScreenCaptureFromPath(screenshotForReport).build());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName());
        logger.info("Test " + result.getName() + " FAILED");
        logger.error(result.getThrowable());
        String logText = "Test case " + result.getName() + " is failed";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTest.log(Status.FAIL, m);
        extentTest.info(result.getThrowable());
        captureScreenshot(result.getName());
        String screenshotForReport = Constants.SCREENSHOT_FOLDER_FOR_REPORTS + "/" + result.getName() + ".png";
        extentTest.info("Screenshot attached :", MediaEntityBuilder.createScreenCaptureFromPath(screenshotForReport).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED");
        logger.warn("Test " + result.getName() + " SKIPPED");
        String logText = "Test case " + result.getName() + " is skipped";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.AMBER);
        extentTest.log(Status.SKIP, m);
        captureScreenshot(result.getName());
        String screenshotForReport = Constants.SCREENSHOT_FOLDER_FOR_REPORTS + "/" + result.getName() + ".png";
        extentTest.info("Screenshot attached :", MediaEntityBuilder.createScreenCaptureFromPath(screenshotForReport).build());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("ON START");
        logger.info("Test suite started running");
        cleanUp();
        //Extent Reports
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
        String reportPath = Constants.REPORTS_PATH + File.separator + "Test_Report_" + format.format(new Date()) + ".html";
        extentSparkReporter = new ExtentSparkReporter(reportPath);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("Automation Test Report");
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        //Driver set up
        //System.setProperty("webdriver.chrome.driver", ".//src//test//resources//drivers//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test suite completed");
        System.out.println("ON FINISH");
        driver.quit();
        extentReports.flush();
    }


    public void cleanUp() {
        System.out.println("BEFORE SUITE");
        if (new File(Constants.SCREENSHOT_FOLDER).exists()) {
            System.out.println("FILE EXISTS");
            try {
                FileUtils.deleteDirectory(new File(Constants.SCREENSHOT_FOLDER));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("FILE NOT EXISTS");
            new File(Constants.SCREENSHOT_FOLDER).mkdir();
        }
    }

    public void captureScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String screenshotPath = Constants.SCREENSHOT_FOLDER + "//" + name + ".png";
        try {
            org.apache.commons.io.FileUtils.copyFile(srcFile, new File(screenshotPath));
            System.out.println("Screenshot CAPTURED");
        }
        catch (IOException e) {
            System.out.println("Screenshot FAILED");
            e.printStackTrace();
        }
    }
}
