package com.SeleniumPractice.ex_06_Selenium_Waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium19_Thread_Sleep {

    @Test
    public void test_wait_thread(){
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(driver.getTitle(),"Login - VWO");

        driver.quit();
    }
}
