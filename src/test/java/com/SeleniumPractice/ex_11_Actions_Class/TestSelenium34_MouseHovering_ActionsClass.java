package com.SeleniumPractice.ex_11_Actions_Class;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium34_MouseHovering_ActionsClass extends TestCaseBoilerPlate {

    @Test
    public void test_actions2(){
        driver.get("https://www.spicejet.com/");

        waitHelpers.waitJVM(3000);

        WebElement from = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(from).click().sendKeys("BLR").build().perform();
    }
}
