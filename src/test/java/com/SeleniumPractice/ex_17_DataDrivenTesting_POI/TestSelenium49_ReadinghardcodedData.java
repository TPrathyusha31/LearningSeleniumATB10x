package com.SeleniumPractice.ex_17_DataDrivenTesting_POI;

import com.SeleniumPractice.TestCaseBoilerPlate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSelenium49_ReadinghardcodedData {
WebDriver driver;
    @BeforeTest
    public  void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test(dataProvider = "getData")
    public void test_logindetails(String username,String password){
        System.out.println("Username --> "+username + " and " + "Password --> " +password);
    }

    @DataProvider
    public Object[][] getData(){
        return  new Object[][]{
         new Object[]{"admin@123","password1"},
         new Object[]{"admin1@123","password2"},
         new Object[]{"admin@2123","password3"}

    };
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
