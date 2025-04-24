package com.SeleniumPractice.ex_06_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSelenium20_ImplicitWait {

    @Test
    public void test_implicitwait(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/");
    // Implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("admin@123");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("admin");

        WebElement signin = driver.findElement(By.id("js-login-btn"));
        signin.click();

        WebElement error_message = driver.findElement(By.className("notification-box-description"));

        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
                driver.quit();
    }
}
