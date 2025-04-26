package com.SeleniumPractice.ex_07_Handling_ChecknRadiobox_Selectbox_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium25_Handling_1stType_NormalJSAlert {
    @Test
    public  void test_1sttype_alert(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1st Type - Normal javascript alert with only "OK" option
        WebElement element  = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        //or                   = driver.findElement(By.xpath("//button[@onclick="jsAlert()"]));

        element.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert  = driver.switchTo().alert();
        alert.accept(); //to accept the alert i.e to click OK button

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"You successfully clicked an alert");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();



    }
}
