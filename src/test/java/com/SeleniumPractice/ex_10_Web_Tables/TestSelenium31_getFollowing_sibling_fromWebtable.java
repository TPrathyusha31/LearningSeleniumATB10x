package com.SeleniumPractice.ex_10_Web_Tables;

import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium31_getFollowing_sibling_fromWebtable {

    @Test
    public void test_webtables2() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable.html");

        waitHelpers.waitJVM(3000);

        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        int rows = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();

        int cols = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        for (int i = 2; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                String element_value = driver.findElement(By.xpath(dynamic_xpath)).getText();
                if (element_value.contains("Helen Bennett")) {
                    String country = driver.findElement(By.xpath(dynamic_xpath + "/following-sibling::td")).getText();
                    System.out.println("Helen Bennett country is -->" + country);
                }
            }

        }

        waitHelpers.waitJVM(3000);

        driver.quit();
    }
}