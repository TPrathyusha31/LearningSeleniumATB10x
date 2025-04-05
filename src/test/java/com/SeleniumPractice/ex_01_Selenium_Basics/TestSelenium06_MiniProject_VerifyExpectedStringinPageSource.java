package com.SeleniumPractice.ex_01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium06_MiniProject_VerifyExpectedStringinPageSource {
    @Description("Open URL")
    @Test
            public void test_Selenium() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        String pagesource = driver.getPageSource();
        if(pagesource.contains("CURA Healthcare Service")){
            Assert.assertTrue(true);
            System.out.println("CURA Healthcare Service");
        }else {
            throw new Exception("CURA Healthcare Service is not available");
        }
        driver.quit();
    }
}
