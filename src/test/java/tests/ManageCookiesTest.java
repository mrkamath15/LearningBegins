package tests;

import base.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class ManageCookiesTest extends BaseTest {

    @Test(enabled = true, priority = 501)
    public void getCookiesTest() {
        driver.navigate().to("https://www.facebook.com/");
        System.out.println(driver.manage().getCookies());
        System.out.println(driver.manage().getCookieNamed("fr"));
        System.out.println("total Cookies: " + driver.manage().getCookies().size());
    }

    @Test(enabled = true, priority = 502)
    public void setCookiesTest() {
        driver.navigate().to("https://www.facebook.com/");
        Cookie cookie = new Cookie("Ambade", "Katho");
        driver.manage().addCookie(cookie);
        System.out.println(driver.manage().getCookies());
    }

    @Test(enabled = true, priority = 503)
    public void deleteCookies() {
        driver.navigate().to("https://www.facebook.com/");
        System.out.println("Cookie Count Before Delete : " + driver.manage().getCookies().size());
        driver.manage().deleteCookieNamed("fr");
        System.out.println("Cookie Count After Delete : " + driver.manage().getCookies().size());
        driver.manage().deleteAllCookies();
        System.out.println("Cookie Count After Delete All : " + driver.manage().getCookies().size());
    }
    
}
