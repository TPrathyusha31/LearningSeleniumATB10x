package com.SeleniumPractice.ex_17_DataDrivenTesting_POI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSelenium51_RealLoginexample_forDDT {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");
    }

    @Test(dataProvider = "getData")
    public void test_LoginVWO(String username, String password){
        System.out.println( username + " / " + password);

        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys(username);

        WebElement pass = driver.findElement(By.id("login-password"));
        pass.sendKeys(password);

        driver.findElement(By.xpath("//span[@data-qa='ezazsuguuy']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.xpath("//div[@data-qa='rixawilomi']"));
        Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");

    }

    @DataProvider
    public Object[][] getData(){
        return UtilExcel.getTestDataFromExcel("sheet1");
    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
