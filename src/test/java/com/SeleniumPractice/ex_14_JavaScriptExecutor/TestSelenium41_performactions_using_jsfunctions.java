package com.SeleniumPractice.ex_14_JavaScriptExecutor;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSelenium41_performactions_using_jsfunctions extends TestCaseBoilerPlate {
    @Test
    public void test_js(){
        driver.get("https://selectorshub.com/xpath-practice-page/");
        waitHelpers.waitJVM(3000);
       //typecasting the driver
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement scroll_to_view = driver.findElement(By.linkText("DownLoad Link"));

        //scrolling to element
        js.executeScript("arguments[0].scrollIntoView(true);",scroll_to_view);

        //another way : js.executeScript("window.scrollBy(0,500);")

        //to get the url
        String url = js.executeScript("return document.URL;").toString();
        //to get the title
        String title = js.executeScript("return document.title;").toString();

        System.out.println(url);
        System.out.println(title);

    }
}
