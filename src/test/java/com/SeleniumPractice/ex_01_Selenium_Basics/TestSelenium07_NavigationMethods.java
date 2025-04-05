package com.SeleniumPractice.ex_01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium07_NavigationMethods {
    @Description("Open url")
    @Test
    public void test_Navigation_methods(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");

        driver.navigate().to("https://bing.com");
        driver.navigate().refresh();
        driver.navigate().back();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().refresh();
        driver.navigate().forward();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();


    }
}
