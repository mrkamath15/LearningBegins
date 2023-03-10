package tests;

import base.BaseTest;
import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavascriptTests extends BaseTest {


    @Test(enabled = true, priority =1000)
    public void clickJS() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        WebElement button = driver.findElement(By.xpath("//a[contains(text(), 'Create new')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", button);
        Thread.sleep(2000);
    }

    @Test(enabled = true, priority = 1001)
    public void alertInJS() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Hello! Am a alert!!')");
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test(enabled = true, priority = 1002)
    public void getTitleDomainUrlJS() {
        driver.navigate().to("https://www.facebook.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Title :3 " + js.executeScript("return document.title"));
        System.out.println("Domain : " + js.executeScript("return document.domain"));
        System.out.println("URL : " + js.executeScript("return document.URL"));
    }

    @Test(enabled = true, priority = 1003)
    public void newUrlLoadJS() throws InterruptedException{
        driver.navigate().to("https://www.facebook.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://www.google.com'");
        Thread.sleep(2000);
    }

    @Test(enabled = true, priority = 1003)
    public void pageRefreshJS() throws InterruptedException{
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0)");
        Thread.sleep(2000);
    }

    @Test(enabled = true, priority = 1004)
    public void scrollToByJS() throws InterruptedException {
        driver.navigate().to("https://www.selenium.dev/");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0, 900)");
        Thread.sleep(3000);
    }

    @Test(enabled = true, priority = 1005)
    public void scrollIntoViewJS() throws InterruptedException {
        driver.navigate().to("https://www.selenium.dev/");
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//h2[text()='News']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(3000);
    }

    @Test(enabled = true, priority = 1006)
    public void scrollToBottomJS() throws InterruptedException {
        driver.navigate().to("https://www.selenium.dev/");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
    }

    @Test(enabled = true, priority = 1006)
    public void setTextJS() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('pass').value='Hello123'");
        Thread.sleep(3000);
    }
}
