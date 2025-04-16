package com.SeleniumPractice.ex_01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium10_AddingExtensions_to_Browser {

    @Description("Adding extensions by options class")
    @Test
    public void test_addExtensionsUsingOptionsclass(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addExtensions(new File(""));

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.youtube.com/watch?v=GOiT1lxmEdI&list=RDGOiT1lxmEdI&start_radio=1");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
         driver.quit();
    }
}
