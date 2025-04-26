package com.SeleniumPractice.ex_08_Handling_SVG_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium28_SVGelements_example1 {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
      driver = new EdgeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.flipkart.com/search");
    }

    @Test
    public  void test_svg(){
        WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
        search.sendKeys("macmini");

    }

}
