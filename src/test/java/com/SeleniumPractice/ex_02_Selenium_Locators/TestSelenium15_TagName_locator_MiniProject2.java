package com.SeleniumPractice.ex_02_Selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class TestSelenium15_TagName_locator_MiniProject2 {

    @Owner("Prathyusha")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that error message comes with invalid email")
    @Test
    public void test_TagName(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");

        WebElement a_tag_partialText = driver.findElement(By.partialLinkText("a"));
        a_tag_partialText.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("abc");

        WebElement checkbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox.click();

        List<WebElement> create_button = driver.findElements(By.tagName("button"));
        create_button.get(0).click();

        List<WebElement> error_msg = driver.findElements(By.className("invalid-reason"));
       Assert.assertEquals(error_msg.get(0).getText(),"The email address you entered is incorrect.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
