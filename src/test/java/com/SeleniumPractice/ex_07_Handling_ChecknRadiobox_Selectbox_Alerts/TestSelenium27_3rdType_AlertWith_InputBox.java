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
import java.util.AbstractList;

public class TestSelenium27_3rdType_AlertWith_InputBox {

    @Test
    public void test_3rdtype_alert(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement element = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        element.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
       // alert.accept();
        //alert.dismiss();
       alert.sendKeys("alert is accepted");
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));

       // Assert.assertEquals(result.getText(),"You entered:"); // if u directly click OK without entering text

        //Assert.assertEquals(result.getText(),"You entered: null"); //if u dismiss the alert

        Assert.assertEquals(result.getText(),"You entered: alert is accepted"); // if u enter the text and click OK

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
