package com.SeleniumPractice.ex_02_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium14_PartialLinkText_locator {

    @Test
    public void test_PartialLinkText(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");
        //WebElement a_tag_partial_text = driver.findElement(By.partialLinkText("Start"));
       // WebElement a_tag_partial_text = driver.findElement(By.partialLinkText("a"));
      //  WebElement a_tag_partial_text = driver.findElement(By.partialLinkText("free"));
        WebElement a_tag_partial_text = driver.findElement(By.partialLinkText("free trial"));

        a_tag_partial_text.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
