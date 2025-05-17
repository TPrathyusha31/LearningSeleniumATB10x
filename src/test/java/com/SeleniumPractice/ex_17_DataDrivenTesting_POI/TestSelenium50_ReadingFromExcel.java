package com.SeleniumPractice.ex_17_DataDrivenTesting_POI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSelenium50_ReadingFromExcel{
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test(dataProvider = "getData")
    public void test_login(String username, String password){
        System.out.println( username + " - " + password);

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
