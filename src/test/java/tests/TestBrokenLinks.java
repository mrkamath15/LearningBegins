package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TestBrokenLinks extends BaseTest {

    @Test(enabled = true, priority = 801)
    public void brokenLinks() throws IOException {
        //String homePage = "http://www.zlti.com";
        String homePage = "http://www.webkul.com";
        driver.navigate().to(homePage);
        HttpsURLConnection huc;
        int responseCode;
        String url = "";
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (WebElement element : allLinks) {
            url = element.getAttribute("href");

            if (url == "" || url == null) {
                continue;
            }
            else {
                try {
                    huc = (HttpsURLConnection) (new URL(url).openConnection());
                    huc.setRequestMethod("HEAD");
                    huc.connect();
                    responseCode = huc.getResponseCode();

                    if (responseCode >= 400) {
                        System.out.println(url + " ==> " + responseCode + " ==> NOT OK");
                    }
                    else if (responseCode < 400) {
                        //System.out.println(url + " ==> " + responseCode + " ==> OK");
                    }
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
