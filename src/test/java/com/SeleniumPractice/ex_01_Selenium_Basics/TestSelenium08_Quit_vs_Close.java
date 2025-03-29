package com.SeleniumPractice.ex_01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium08_Quit_vs_Close {
    @Description("Open URL")
    @Test
    public void test_Quit_and_close(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //close -  it will close only the current focused tab, not all the tabs
        driver.close();


        //quit - will close all the tabs of the browser
        //driver.quit();
    }
}
