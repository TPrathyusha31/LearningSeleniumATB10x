package com.SeleniumPractice.ex_16_Selenium_Exceptions;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium48_TimeoutException extends TestCaseBoilerPlate {
    @Test
    public void test_timeOutexception() {
        driver.get("https://google.com");
        waitHelpers.waitJVM(3000);
        System.out.println("Start of the program");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@class ='AgLFyf']")));
            WebElement search_box1 = driver.findElement(By.xpath("//textarea[@class = 'gLFyf']")); //refind the search box element and then send the text
            search_box1.sendKeys("the testing academy");
        } catch (Exception e) {
            System.out.println("timeout exception");
        }

        System.out.println("End of the program");
    }
}
