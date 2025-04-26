package com.SeleniumPractice.ex_06_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium21_ExplicitWait {

    @Test
    public void  test_explicitwait(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/");

        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("admin@123");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("admin");

        WebElement signin = driver.findElement(By.id("js-login-btn"));
        signin.click();

        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));

        WebElement error = driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(error.getText());

        Assert.assertEquals(error.getText(),"Your email, password, IP address or location did not match");
        driver.quit();
    }

}
