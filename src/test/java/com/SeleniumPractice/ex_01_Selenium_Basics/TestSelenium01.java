package com.SeleniumPractice.ex_01_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {
    @Test
    public void test_VerifyVWOLogin(){
//Write code which will execute perform UI interaction
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
