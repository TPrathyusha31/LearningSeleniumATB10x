package com.SeleniumPractice.ex_01_Selenium_Basics;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium02 {
    @Test
    public void test_Selenium02(){
        //open the driver
        EdgeDriver driver = new EdgeDriver();
        //new EdgeDriver(); --> POST request --> create new session

        //get the URL
        driver.get("https://app.vwo.com");

        //Assert the URL - validations
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}
