package com.SeleniumPractice.ex_15_Relative_locators;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class TestSelenium45 extends TestCaseBoilerPlate {

    @Test
    public  void test_relativelocators_eg3(){
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");

        waitHelpers.waitJVM(3000);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        search.sendKeys("India"+ Keys.ENTER);

        waitHelpers.waitJVM(3000);

        List<WebElement> search_results = driver.findElements(By.xpath("//a[contains(@class,'location grid')]/div/p"));
        for(WebElement location : search_results){
            String rank = driver.findElement(with(By.tagName("p")).toLeftOf(location)).getText();
            String AQI = driver.findElement(with(By.tagName("span")).toRightOf(location)).getText();
            System.out.println(rank + "  |  " + location.getText() + "  |  " + AQI);
        }
    }
}
