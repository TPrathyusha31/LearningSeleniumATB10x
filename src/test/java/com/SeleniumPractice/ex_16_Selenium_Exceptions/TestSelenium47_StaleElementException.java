package com.SeleniumPractice.ex_16_Selenium_Exceptions;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSelenium47_StaleElementException extends TestCaseBoilerPlate {
    @Test
    public void test_StaleElementException() {
        driver.get("https://google.com");
        waitHelpers.waitJVM(3000);
        System.out.println("Start of the program");

        WebElement search_box = driver.findElement(By.xpath("//textarea[@class = 'gLFyf']"));
        driver.navigate().refresh();

        try {
            search_box.sendKeys("the testing academy");
        } catch (StaleElementReferenceException e) {
            WebElement search_box1 = driver.findElement(By.xpath("//textarea[@class = 'gLFyf']")); //refind the search box element and then send the text
            search_box1.sendKeys("the testing academy");
        }

        System.out.println("End of the program");

    }
}
