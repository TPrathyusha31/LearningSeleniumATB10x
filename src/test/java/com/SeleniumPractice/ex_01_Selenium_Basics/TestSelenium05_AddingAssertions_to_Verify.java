package com.SeleniumPractice.ex_01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSelenium05_AddingAssertions_to_Verify {
    @Description("open url")
    @Test
    public void test_Selenium(){
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        Assert.assertEquals(driver.getTitle(),"Google");
        assertThat(driver.getCurrentUrl()).isNotBlank().isNotNull().isEqualTo("https://www.google.com/");
        driver.quit();
    }
}
