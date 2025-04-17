package com.SeleniumPractice.ex_02_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium12_task_March23_Verify_UpdatedURLChanges_afterLogin {

    @Test
    public void test_VerifyUpdatedURL() throws Exception{
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement make_appointment_CTA = driver.findElement(By.id("btn-make-appointment"));
        make_appointment_CTA.click();

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login_btn = driver.findElement(By.id("btn-login"));
        login_btn.click();


        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        driver.quit();
    }
}
