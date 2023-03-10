package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class NavigationTest extends BaseTest {

    @Test(enabled = true, priority = 2)
    public void navigationTest() throws MalformedURLException, InterruptedException {
        driver.navigate().to(new URL("https://www.screener.in/"));
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
}
