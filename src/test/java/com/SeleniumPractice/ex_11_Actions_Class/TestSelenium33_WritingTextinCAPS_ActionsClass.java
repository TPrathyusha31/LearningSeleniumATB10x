package com.SeleniumPractice.ex_11_Actions_Class;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium33_WritingTextinCAPS_ActionsClass extends  TestCaseBoilerPlate{

    @Test
    public void test_actions1(){
        driver.get("https://awesomeqa.com/practice.html");
        waitHelpers.waitJVM(3000);
        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions = new Actions(driver);
       // actions.keyDown(Keys.SHIFT).sendKeys(firstname,"the testing academy").keyUp(Keys.SHIFT).build().perform();
        actions.keyDown(firstname,Keys.SHIFT).sendKeys("the testing academy").keyUp(Keys.SHIFT).build().perform();

    }
}
