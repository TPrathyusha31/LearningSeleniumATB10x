package com.SeleniumPractice.ex_13_Handling_Windows;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class TestSelenium39_SwitchToNewlyOpenedWindow extends TestCaseBoilerPlate {

    @Test
    public  void test_switchToWindow(){

        driver.get("https://the-internet.herokuapp.com/windows");

        waitHelpers.waitJVM(3000);

        String parent = driver.getWindowHandle();
        System.out.println(parent);

        WebElement window_link = driver.findElement(By.linkText("Click Here"));
        window_link.click();

        Set<String> windowhandles = driver.getWindowHandles();
        for(String handle : windowhandles){
            driver.switchTo().window(handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Testcase Passed!");
            }
            driver.switchTo().window(parent);
        }


    }

}
