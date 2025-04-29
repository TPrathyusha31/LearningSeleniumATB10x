package com.SeleniumPractice.ex_11_Actions_Class;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium35_KeyboardActions_Navigatingdropdown extends TestCaseBoilerPlate {

    @Test
    public void test_actions3(){
        driver.get("https://www.makemytrip.com/");

        waitHelpers.checkVisibility(driver,By.xpath("//span[@data-cy='closeModal']"),3000);

        WebElement close_btn = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        close_btn.click();

        WebElement from_location = driver.findElement(By.xpath("//input[@data-cy='fromCity']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(from_location).click().sendKeys(from_location,"HYD").build().perform();


        List<WebElement> auto_suggestionList = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));

        for(WebElement location : auto_suggestionList) {
            if (location.getText().contains("Hyderabad")) {
                location.click();
            }
        }

    }
}

