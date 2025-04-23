package com.SeleniumPractice.ex_04_Selenium_XpathAxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium17_Using_XpathAxes {


    WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/xpath/");
    }

    @Test
    public void test_Selenium_XpathAxes() {

        List<WebElement> ancestors = driver.findElements(By.xpath("//div[@class='Mammal']/ancestor::div"));
        for (WebElement a : ancestors) {
            System.out.println(a.getText());
        }

        System.out.println("----------------------------------------------");

        WebElement following_sibling = driver.findElement(By.xpath("//div[@class='Mammal']/following-sibling::div"));
        System.out.println(following_sibling.getText());

        System.out.println("----------------------------------------------");

        WebElement preceding_sibling = driver.findElement(By.xpath("//div[@class='Mammal']/preceding-sibling::div"));
        System.out.println(preceding_sibling.getText());

        System.out.println("----------------------------------------------");

        List<WebElement> descendants = driver.findElements(By.xpath("//div[@class='Mammal']/descendant::div"));
        for (WebElement d : descendants) {
            System.out.println(d.getText());
        }

        System.out.println("----------------------------------------------");

        List<WebElement> children = driver.findElements(By.xpath("//div[@class='Mammal']/child::div"));
            for (WebElement c : children) {
                System.out.println(c.getText());
            }


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
