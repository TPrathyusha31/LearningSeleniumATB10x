package com.SeleniumPractice.ex_10_Web_Tables;

import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.List;

public class TestSelenium30_StaticWebTable_usingDynamic_xpath {

    @Test
    public  void test_webtable_static(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable.html");

        waitHelpers.waitJVM(3000);

       // example xpath for rwo2, col 1 = "//table[@id=\"customers\"]/tbody/tr[2]/td[1]"
        //Now to make it dynamic we divide it into 3 parts and consider row as i and col as j
        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part ="]/td[";
        String third_part ="]";

        //get the count of no of rows --> for that get the all the rows(tr) using findElements and do .size()
        int rows = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();

        //to get the no of columns --> take any one row and get columns in it
        int cols = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        //print the xpaths of all elements & also the elements of table using for loop
        for(int i = 2; i<=rows;i++){
            for(int j=1;j<=cols;j++){
                String dynamic_xpath = first_part+i+second_part+j+third_part;
                System.out.println(dynamic_xpath);
                String element_value = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(element_value);
            }
        }

        driver.quit();
    }
}
