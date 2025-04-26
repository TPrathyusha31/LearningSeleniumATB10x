package com.SeleniumPractice.ex_06_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium22_FluentWait {

    @Test
    public  void  test_fluentwait(){
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

        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(6)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        WebElement error = driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(error.getText());

        Assert.assertEquals(error.getText(),"Your email, password, IP address or location did not match");
        driver.quit();
    }
}
