package com.SeleniumPractice.ex_14_JavaScriptExecutor;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSelenium42_HandleShadowDOM_using_jsexecutor extends TestCaseBoilerPlate {

    @Test
    public void test_js_shadowDOM(){
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement div_to_scroll = driver.findElement(By.linkText("DownLoad Link"));
        // Shadow DOM -> js.executeCode
        waitHelpers.waitJVM(3000);

        WebElement inputboxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"#pizza\");");
        inputboxPizza.sendKeys("farmhouse");






    }
}
