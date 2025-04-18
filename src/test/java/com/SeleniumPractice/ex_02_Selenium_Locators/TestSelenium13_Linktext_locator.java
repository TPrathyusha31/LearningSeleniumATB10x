package com.SeleniumPractice.ex_02_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium13_Linktext_locator {

    @Test
    public void test_lintext_locator(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");
        WebElement a_tag_full_match = driver.findElement(By.linkText("Start a free trial"));
        a_tag_full_match.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
