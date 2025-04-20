package com.SeleniumPractice.ex_03_Selenium_Xpaths;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Watchable;

public class TestSelenium16_MiniProject3_Verifythe_CurrentURL {

    @Description("Verify that clicking on submit, URL changes to appointment URL")
    @Test
    public void test_xpath_using_text_and_contains(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement MakeAppointment_btn = driver.findElement(By.xpath("//a[text()='Make Appointment']"));
        MakeAppointment_btn.click();

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement Login_btn = driver.findElement(By.xpath("//button[text()='Login']"));
        Login_btn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        driver.quit();
    }
}
