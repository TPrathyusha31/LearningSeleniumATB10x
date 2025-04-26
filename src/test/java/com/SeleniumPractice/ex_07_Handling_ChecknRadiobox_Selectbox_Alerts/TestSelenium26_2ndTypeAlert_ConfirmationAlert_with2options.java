package com.SeleniumPractice.ex_07_Handling_ChecknRadiobox_Selectbox_Alerts;

import com.beust.ah.A;
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

public class TestSelenium26_2ndTypeAlert_ConfirmationAlert_with2options {

    @Test
    public void test_2ndtype_alert(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement element = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        element.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        //alert.accept();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        //Assert.assertEquals(result.getText(),"You clicked: Ok"); // if we accept the alert
        Assert.assertEquals(result.getText(),"You clicked: Cancel"); //--> if we dismiss the alert

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();



    }
}
