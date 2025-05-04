package com.SeleniumPractice.ex_15_Relative_locators;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class TestSelenium43_toRightOf_method extends TestCaseBoilerPlate {

    @Test
    public void test_relativelocators_eg1(){
        driver.get("https://awesomeqa.com/practice.html");

        waitHelpers.waitJVM(3000);

        WebElement span_element  = driver.findElement(By.xpath("//span[text() = 'Years of Experience']"));

        driver.findElement(with(By.id("exp-0")).toRightOf(span_element)).click();
    }
}
