package com.SeleniumPractice.ex_12_FileUploading;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSelenium38_FileUploading extends TestCaseBoilerPlate {

    @Test
    public void test_actions6() {
        driver.get("https://awesomeqa.com/selenium/upload.html");

        waitHelpers.waitJVM(3000);

        WebElement uploadfileinput = driver.findElement(By.id("fileToUpload"));

        String working_dir = System.getProperty("user.dir");
        System.out.println(working_dir);


        uploadfileinput.sendKeys(working_dir + "src/test/java/com/SeleniumPractice/ex_11_Actions_Class/testdata.txt");
        driver.findElement(By.name("submit")).click();
    }
}

