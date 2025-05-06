package com.SeleniumPractice.ex_15_Relative_locators;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class TestSelenium44_exampleusing_BelowMethod extends TestCaseBoilerPlate {
    @Test
    public void test_relativelocators_eg2(){
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        waitHelpers.waitJVM(3000);
        driver.switchTo().frame("result");
        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']")); // (or) //form[@id='form']/button
        submit.click();

        WebElement username = driver.findElement(By.id("username"));

        String error_text = driver.findElement(with(By.tagName("small")).below(username)).getText();
        System.out.println(error_text);
        Assert.assertEquals(error_text,"Username must be at least 3 characters");
    }
}
