package com.SeleniumPractice.ex_11_Actions_Class;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium37_DragAndDrop_ActionsClass extends TestCaseBoilerPlate {

    @Test
    public void test_actions5(){
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        waitHelpers.waitJVM(3000);

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement destination = driver.findElement(By.id("column-b"));


        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,destination).build().perform();

        WebElement dest = driver.findElement(By.id("column-b"));

        Assert.assertEquals(dest.getText(),"A");

    }

}
