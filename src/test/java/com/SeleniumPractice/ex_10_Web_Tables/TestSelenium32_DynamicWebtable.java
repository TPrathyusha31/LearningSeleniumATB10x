package com.SeleniumPractice.ex_10_Web_Tables;

import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium32_DynamicWebtable {

    @Test
    public void test_dynamicWebtable(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable1.html");
        waitHelpers.waitJVM(3000);
        //here for dynamic webtable we don't use dynamic_xpath rather we use a diff mechanism
        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']"));

       List<WebElement> rows = table.findElements(By.tagName("tr"));

       for(int i =0;i<rows.size();i++){
      List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
for(WebElement c : cols){
System.out.println(c.getText());
}
}driver.quit();
}
}