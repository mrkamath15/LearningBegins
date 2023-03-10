package tests;

import base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGLearnAnnotations extends BaseTest {

    @Test(enabled = true, priority = 1001)
    public void sampleTest() {
        System.out.println("TEST");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

}
