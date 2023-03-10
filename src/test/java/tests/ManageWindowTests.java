package tests;

import base.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

public class ManageWindowTests extends BaseTest {

    @Test(enabled = true, priority = 401)
    public void maximiseAndFullSizeTest() throws InterruptedException{
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
    }

    @Test(enabled = true, priority = 402)
    public void manageWindowSize() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        System.out.println("Original Window Size; " + driver.manage().window().getSize());
        Dimension screenSize = driver.manage().window().getSize();
        driver.manage().window().setSize(new Dimension(500, 400));
        System.out.println("Updated Window Size; " + driver.manage().window().getSize());
        Thread.sleep(2000);
        driver.manage().window().setSize(screenSize);
        Thread.sleep(2000);
    }

    @Test(enabled = true, priority = 403)
    public void manageWindowPosition() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        System.out.println("Default position: " + driver.manage().window().getPosition());
        Point defaultPosition = driver.manage().window().getPosition();
        Thread.sleep(2000);
        driver.manage().window().setPosition(new Point(200, 200));
        System.out.println("Updated position: " + driver.manage().window().getPosition());
        Thread.sleep(2000);
        driver.manage().window().setPosition(defaultPosition);
        System.out.println("Default position: " + driver.manage().window().getPosition());
        Thread.sleep(2000);
    }
}
