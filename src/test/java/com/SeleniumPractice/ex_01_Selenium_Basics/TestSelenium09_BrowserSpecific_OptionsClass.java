package com.SeleniumPractice.ex_01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium09_BrowserSpecific_OptionsClass {
    @Description("Options class")
    @Test
    public void test_options() {


        EdgeOptions edgeoptions = new EdgeOptions();
       // edgeoptions.addArguments("--window-size=1280,720"); // to open window in specified size
     //  edgeoptions.addArguments("--start-maximized"); //to open in maximized mode.
     //   edgeoptions.addArguments("--incognito"); //to oopen in incognit mode
        edgeoptions.addArguments("--headless"); //to oopen in headless mode

        WebDriver driver = new EdgeDriver(edgeoptions);
        driver.get("https://www.google.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}