package com.SeleniumPractice.ex_02_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium11_MiniProject1_VerifyErrormsg_invalidCreds {
    @Test
    public void test_invalidCredentials(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");
        WebElement username_field = driver.findElement(By.id("login-username"));
        username_field.sendKeys("admin@123");

        WebElement password_field = driver.findElement(By.name("password"));
        password_field.sendKeys("admin");

        WebElement submit_btn = driver.findElement(By.id("js-login-btn"));
        submit_btn.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");

        driver.quit();
    }
}
