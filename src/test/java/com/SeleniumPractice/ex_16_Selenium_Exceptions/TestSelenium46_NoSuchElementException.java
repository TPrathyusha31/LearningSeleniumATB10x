package com.SeleniumPractice.ex_16_Selenium_Exceptions;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class TestSelenium46_NoSuchElementException extends TestCaseBoilerPlate {

    @Test
    public  void test_NosuchElementException(){
        driver.get("https://app.vwo.com");

        waitHelpers.waitJVM(3000);

        System.out.println("Start of the program");
        try {
            driver.findElement(By.id("Pramod"));    //we don't have any element with id as Pramod --> so handle this we surround it by a try/catch block
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }
        System.out.println("End of the program");

    }
}
