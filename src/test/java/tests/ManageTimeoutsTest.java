package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ManageTimeoutsTest extends BaseTest {

    @Test(enabled = true, priority = 601)
    public void sameWaitsElementFound() {
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        System.out.println(new Date());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));
        System.out.println(new Date());
    }

    @Test(enabled = true, priority = 602)
    public void sameWaitsElementNotFound() {
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        System.out.println(new Date());
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("testtt"))));
        }
        catch (Exception e) {
            System.out.println("Element NOT Found");
        }
        System.out.println(new Date());
    }

    @Test(enabled = true, priority = 603)
    public void moreImplicitWaitElementNotFound() {
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.out.println(new Date());
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("testtt"))));
        }
        catch (Exception e) {
            System.out.println("Element NOT Found");
        }
        System.out.println(new Date());
    }

    @Test(enabled = true, priority = 604)
    public void moreExplicitWaitElementNotFound() {
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        System.out.println(new Date());
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("testtt"))));
        }
        catch (Exception e) {
            System.out.println("Element NOT Found");
        }
        System.out.println(new Date());
    }

    @Test(enabled = true, priority = 605)
    public void pageLoadTimeoutTest() {
        try {
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            System.out.println(new Date());
            driver.navigate().to("https://scobleizer.blog/");
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(new Date());
    }

    @Test(enabled = true, priority = 606)
    public void explicitWaitAlertTimeout() {
        driver.navigate().to("https://www.facebook.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.pollingEvery(100, TimeUnit.MILLISECONDS);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = true, priority = 607)
    public void explicitWaitElementLocated() {
        driver.navigate().to("https://www.facebook.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.pollingEvery(100, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass")));
    }

    @Test(enabled = true, priority = 608)
    public void explicitWaitMissingElement() {
        driver.navigate().to("https://www.facebook.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("passw")));
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    //Element is present but hidden - so element will be located
    @Test(enabled = true, priority = 609)
    public void explicitWaitPresenceOfHiddenElement() {
        driver.navigate().to("https://www.facebook.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='jazoest']")));
    }

    //Element is present but hidden - So Exception
    @Test(enabled = true, priority = 610)
    public void explicitWaitVisibilityOfHiddenElementException() {
        driver.navigate().to("https://www.facebook.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='jazoest']")));
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = true, priority = 610)
    public void explicitWaitTitleContains() {
        driver.navigate().to("https://www.facebook.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("Facebook"));
    }
}
