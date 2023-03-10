package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectTest extends BaseTest {

    @Test(enabled = true, priority = 701)
    public void selectFromDropdown() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        Select selectDate = new Select(driver.findElement(By.id("day")));
        selectDate.selectByVisibleText("15");
        Thread.sleep(2000);
        selectDate.selectByValue("11");
        Thread.sleep(2000);
        selectDate.selectByIndex(4);
        Thread.sleep(2000);
    }

    @Test(enabled = true, priority = 702)
    public void getAllOptionsFromSelect() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        Select selectDate = new Select(driver.findElement(By.id("day")));
        List<WebElement> options = selectDate.getOptions();

        for (WebElement element : options) {
            System.out.println(element.getText());
        }
    }

    @Test(enabled = true, priority = 703)
    public void multiSelect() throws InterruptedException{
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        driver.switchTo().frame("iframeResult");
        Select select = new Select(driver.findElement(By.id("cars")));
        System.out.println("Is Multiple: " + select.isMultiple());
        select.selectByVisibleText("Volvo");
        //driver.findElement(By.id("cars")).sendKeys(Keys.CONTROL);
        select.selectByVisibleText("Audi");
        Thread.sleep(3000);
    }

    @Test(enabled = true, priority = 704)
    public void getSelectedOptions() throws InterruptedException{
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        driver.switchTo().frame("iframeResult");
        Select select = new Select(driver.findElement(By.id("cars")));
        System.out.println("Is Multiple: " + select.isMultiple());
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Audi");
        Thread.sleep(3000);
        System.out.println("First Selected Option: " + select.getFirstSelectedOption().getText());

        List<WebElement> allSelectedOptions = select.getAllSelectedOptions();

        System.out.println("All selected Options:");
        for (WebElement element : allSelectedOptions) {
            System.out.println(element.getText());
        }

    }

    @Test(enabled = true, priority = 705)
    public void deselect() throws InterruptedException{
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        driver.switchTo().frame("iframeResult");
        Select select = new Select(driver.findElement(By.id("cars")));
        System.out.println("Is Multiple: " + select.isMultiple());
        select.selectByVisibleText("Volvo");
        //driver.findElement(By.id("cars")).sendKeys(Keys.CONTROL);
        select.selectByVisibleText("Audi");
        Thread.sleep(3000);
        select.deselectAll();
        Thread.sleep(3000);
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Audi");
        Thread.sleep(3000);
        select.deselectByVisibleText("Audi");
        Thread.sleep(3000);
    }


}
