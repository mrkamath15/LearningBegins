package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.Constants;

import java.lang.reflect.Method;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void cleanUp() {
        System.out.println("BEFORE SUITE");
    }

    @BeforeTest
    public void driverSetUp() {
        System.out.println("BEFORE TEST");
    }

    @AfterTest
    public void quitDriver() {
        System.out.println("AFTER TEST");
    }

    @AfterMethod
    public void captureScreenshot(Method method) {
        System.out.println("AFTER METHOD");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BEFORE CLASS");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AFTER CLASS");
    }

    @BeforeMethod
    public void afterMethod() {
        System.out.println("BEFORE METHOD");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AFTER SUITE");
    }
}
