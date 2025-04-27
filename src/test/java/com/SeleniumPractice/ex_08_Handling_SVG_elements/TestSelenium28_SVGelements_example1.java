package com.SeleniumPractice.ex_08_Handling_SVG_elements;

import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

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

        List<WebElement> svg = driver.findElements(By.xpath("//*[local-name()='svg']"));
        // for svg xpath can also be --> //*[name()='svg']
        svg.get(0).click();

        waitHelpers.waitJVM(5000);

        List<WebElement> titles = driver.findElements(By.xpath(" //div[contains(@data-id,'CPU')]/div/a[2]"));
        // "//a[@class='wjcEIp']" --> xpath to get all the result titles
        for(WebElement title : titles){
            System.out.println(title.getText());
        }
    }

    @AfterTest
    public void closeBrowser(){
        waitHelpers.waitJVM(3000);
        driver.quit();
    }

}
