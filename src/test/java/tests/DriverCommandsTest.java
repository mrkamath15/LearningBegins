package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverCommandsTest extends BaseTest {

    @Test(enabled = true, priority = 1)
    public void driverCommandTest() {
        driver.get("https://www.google.com");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page URL: " + driver.getCurrentUrl());
        System.out.println("Window Handle: " + driver.getWindowHandle());
        System.out.println("Windows Handles: " + driver.getWindowHandles());
    }




    public void explicitWaitTest() throws MalformedURLException {
        driver.navigate().to(new URL("https://www.screener.in/"));
        driver.findElement(By.xpath("//div[@class='home-search']//input[@placeholder='Search for a company']")).sendKeys("Adani");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='home-search']//ul[@class='dropdown-content visible']")));
        driver.findElement(By.xpath("//div[@class='home-search']//ul[@class='dropdown-content visible']/li[text()='Adani Power Ltd']")).click();
    }
}
