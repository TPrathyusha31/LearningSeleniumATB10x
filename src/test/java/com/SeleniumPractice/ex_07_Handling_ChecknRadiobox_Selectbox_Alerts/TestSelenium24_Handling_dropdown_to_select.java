package com.SeleniumPractice.ex_07_Handling_ChecknRadiobox_Selectbox_Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestSelenium24_Handling_dropdown_to_select {

    @Test
    public void test_Select_from_dropdown(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement element_select = driver.findElement(By.id("dropdown"));
        Select select = new Select(element_select);

        //select.selectByValue("1");
       // select.selectByIndex(1);
        select.selectByVisibleText("Option 1");
        driver.quit();

    }

}
