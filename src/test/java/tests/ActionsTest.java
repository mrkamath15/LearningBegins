package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTest {

    @Test(enabled = true, priority = 900)
    public void moveToElement() throws InterruptedException{
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement forgotPassword = driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
        Action builder = actions.moveToElement(forgotPassword).build();
        builder.perform();
        Thread.sleep(2000);
    }

    @Test(enabled = true, priority = 901)
    public void clicks() throws InterruptedException{
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("email"));
        Action builder = actions.click(element).sendKeys("HelloWorld").doubleClick().contextClick().build();
        builder.perform();
        Thread.sleep(2000);
    }

    @Test(enabled = true, priority = 902)
    public void dragAndDrop() throws InterruptedException {
        driver.navigate().to("https://demo.guru99.com/test/drag_drop.html");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement src = driver.findElement(By.id("credit2"));
        WebElement dest = driver.findElement(By.id("bank"));
        Action builder = actions.dragAndDrop(src, dest).build();
        builder.perform();
        Thread.sleep(2000);
    }

    @Test(enabled = true, priority = 903)
    public void clickAndHold() throws InterruptedException {
        driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_onmousedown");
        Thread.sleep(2000);
        driver.switchTo().frame("iframeResult");
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.id("myP"))).build().perform();
        Thread.sleep(2000);
    }

}
