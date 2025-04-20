package com.SeleniumPractice.ex_04_Selenium_XpathAxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium17_Using_XpathAxes {

    @Test
    public void test_Selenium_XpathAxes() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/xpath/");

        List<WebElement> ancestors = driver.findElements(By.xpath("//div[@class='Mammal']/ancestor::div"));
        for (WebElement a : ancestors) {
            System.out.println(a.getText());
        }
    }
}
