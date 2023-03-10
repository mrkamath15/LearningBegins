package tests;

import base.BaseTest;
import org.openqa.selenium.json.JsonInput;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.ExcelReader;

public class TestNGDataDriven extends BaseTest {


    @Test(enabled = true, priority = 1101)
    @Parameters("browser")
    public void paramTest(@Optional("Firefox") String browser) {
        System.out.println("Parameter : " + browser);
    }

    @DataProvider(name="TestData")
    public Object[][] testDataProvider() {
        return new Object[][] {{1,2},{3,4}};
    }

    @Test(enabled = true, priority = 1102, dataProvider = "TestData")
    public void testDataTest(int m, int n) {
        System.out.println(m + " => " + n);
    }

    @DataProvider(name="ExcelData")
    public Object[][] testWithExcelData() {
        return ExcelReader.getTestData();
    }

    @Test(enabled = true, priority = 1103, dataProvider = "ExcelData")
    public void excelTest(String subject, String marks) {
        System.out.println("Subject : " + subject + " , Marks : " + marks);
    }

    @Test(invocationCount = 2)
    public void invokeTwice() {
        System.out.println("Invocation Test");
    }

    @Test(groups = {"smoke"})
    public void smoke1() {
        System.out.println("Smoke 1");
    }

    @Test(groups = {"smoke"})
    public void smoke2() {
        System.out.println("Smoke 2");
    }

    @Test(groups = {"sanity"})
    public void sanity1() {
        System.out.println("Sanity 1");
    }

    @Test(groups = {"sanity"})
    public void sanity2() {
        System.out.println("Sanity 1");
    }

    @Test(groups = {"sanity", "smoke"})
    public void smokeAndSanity() {
        System.out.println("Smoke and Sanity");
    }

    @Test
    public void dependsOnMethod1() {
        System.out.println("dependsOnMethod1");
    }

    @Test(dependsOnMethods = "dependsOnMethod1")
    public void dependsOnMethod2() {
        System.out.println("dependsOnMethod2");
    }

    @Test(dependsOnMethods = "dependsOnMethod1", alwaysRun = true)
    public void dependsOnMethod3() {
        System.out.println("dependsOnMethod3");
    }

}
