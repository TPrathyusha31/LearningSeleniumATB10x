package com.SeleniumPractice.ex_13_Handling_Windows;

import com.SeleniumPractice.TestCaseBoilerPlate;
import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class TestSelenium40_Iframes extends TestCaseBoilerPlate {

    @Test
    public void test_iframes(){

        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");

        waitHelpers.waitJVM(3000);

        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);

        List<WebElement> heatmaps_list = driver.findElements(By.xpath("//li[@id='js-heatmap-thumbnail']"));
        //  heatmaps_list.get(1).click(); ( or) use actions class

        Actions actions = new Actions(driver);
        actions.moveToElement(heatmaps_list.get(1)).click().build().perform();

        waitHelpers.waitJVM(10000);

        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles){
            if(!handle.equalsIgnoreCase(parentHandle)){
                driver.switchTo().window(handle);
                driver.switchTo().frame("heatmap-iframe");
                driver.findElement(By.xpath("//div[@data-qa='liqokuxuba']")).click();
            }
        }


        }


}
