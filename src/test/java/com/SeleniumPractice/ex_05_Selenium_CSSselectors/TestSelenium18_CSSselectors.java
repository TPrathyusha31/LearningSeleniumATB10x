package com.SeleniumPractice.ex_05_Selenium_CSSselectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium18_CSSselectors {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");
    }

    @Test
    public void testMethod_withCSSselectors(){

        // # --> id | Syntax: tagName#id
        // .--> className | Syntax: tagName.className
        WebElement username_field = driver.findElement(By.cssSelector("input#login-username"));
        username_field.sendKeys("admin@123");

        // Xpath to CSS -->  just remove // and @ from xpath then it becomes CSS selector

       // Xpath: //input[@id="login-password"]   | CSS : input[id="login-password"] or just [id="login-password"]
        WebElement password = driver.findElement(By.cssSelector("input[id='login-password']"));
        password.sendKeys("admin");

        //WebElement signin = driver.findElement(By.cssSelector("button[id='js-login-btn']"));
        //to check for partial i.e similar to "contains" in xpath ---> instead of contain here we just use *
        //similarly for starts-with --> ^
        // and ends-with -->$

      WebElement signin = driver.findElement(By.cssSelector("button[id*='js-login']"));
          signin.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement errormessage = driver.findElement(By.cssSelector("div[class$='box-description']"));
        Assert.assertEquals(errormessage.getText(),"Your email, password, IP address or location did not match");

    }
    @AfterTest
    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
