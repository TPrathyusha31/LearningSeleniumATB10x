package com.SeleniumPractice.ex_11_Actions_Class;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium36_Scrolling_usingPageUP_PageDOWN extends TestCaseBoilerPlate {

    @Test
    public void test_actions4(){
        driver.get("https://thetestingacademy.com/");

        waitHelpers.waitJVM(3000);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_UP).build().perform();
    }
}
