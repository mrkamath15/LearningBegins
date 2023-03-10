package tests;

import base.BaseTest;
import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchToTest extends BaseTest {

    @Test(enabled = true, priority = 301)
    public void alertTest() throws InterruptedException {
        driver.get("https://www.google.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('This is a alert')");
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("alert('This is a alert')");
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();

    }

    @Test(enabled = true, priority = 302)
    public void switchToFrameByName() {
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    @Test(enabled = true, priority = 303)
    public void switchToFrameByIndex() {
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        driver.switchTo().frame(1);
        //System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    @Test(enabled = true, priority = 304)
    public void switchToFrameByWebElement() {
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        //System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    @Test(enabled = true, priority = 305)
    public void switchToFrameInsideAFrame() {
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        driver.switchTo().frame("iframeResult");
        System.out.println("Parent Frame: " + driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().frame(0);
        System.out.println("Child Frame: " + driver.findElement(By.xpath("//*[@class='fa fa-logo']")).isDisplayed());
    }

    @Test(enabled = true, priority = 305)
    public void switchToParentFrame() {
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        driver.switchTo().frame("iframeResult");
        System.out.println("Parent Frame: " + driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().frame(0);
        System.out.println("Child Frame: " + driver.findElement(By.xpath("//*[@class='fa fa-logo']")).isDisplayed());
        driver.switchTo().parentFrame();
        System.out.println("Back To Parent Frame: " + driver.findElement(By.tagName("h1")).getText());
    }

    @Test(enabled = true, priority = 305)
    public void switchToDefaultContentFromFrame() {
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        driver.switchTo().frame("iframeResult");
        System.out.println("Parent Frame: " + driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().defaultContent();
        System.out.println("Back To Default Content: " + driver.findElement(By.id("runbtn")).getText());
    }


    @Test(enabled = true, priority = 305)
    public void switchFromChildFrameToParentFrameThenToDefaultContent() {
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        driver.switchTo().frame("iframeResult");
        System.out.println("Parent Frame: " + driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().frame(0);
        System.out.println("Child Frame: " + driver.findElement(By.xpath("//*[@class='fa fa-logo']")).isDisplayed());
        driver.switchTo().parentFrame();
        System.out.println("Back To Parent Frame: " + driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().defaultContent();
        System.out.println("Back To Default Content: " + driver.findElement(By.id("runbtn")).getText());
    }

    @Test(enabled = true, priority = 306)
    public void switchToWindow() throws InterruptedException{
        driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        System.out.println(driver.getWindowHandles());
        String parentWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//*[text()='Try it']")).click();
        System.out.println(driver.getWindowHandles());
        for (String handle : driver.getWindowHandles()) {
            if (! handle.equalsIgnoreCase(parentWindowHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Child Window: " + driver.getTitle());
                Thread.sleep(3000);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowHandle);
        System.out.println("Parent Window: " + driver.getTitle());
        Thread.sleep(3000);
    }

    @Test(enabled = true, priority = 307)
    public void activeElementSwitchTest() throws InterruptedException{
        driver.navigate().to("https://www.google.com");
        WebElement activeElement = driver.switchTo().activeElement();
        System.out.println(activeElement.getAttribute("title"));
        driver.navigate().to("https://www.facebook.com/");
        driver.switchTo().activeElement().sendKeys("HELLO");
        System.out.println(driver.switchTo().activeElement().getAttribute("placeholder"));
        Thread.sleep(2000);
    }



    @Test(enabled = true, priority = 302)
    public void windowTest() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
        Thread.sleep(3000);
    }


    public void testToFail() {
        Assert.assertFalse(true);
    }
}
