package com.SeleniumPractice.ex_08_Handling_SVG_elements;

import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium29_SVGelements_example2 {

    @Test
    public void test_svgMAP()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        waitHelpers.waitJVM(3000);

        List<WebElement> states = driver.findElements(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"][7]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"path\"]"));
        for(WebElement state : states){
            System.out.println(state.getDomAttribute("aria-label"));
            if(state.getDomAttribute("aria-label").contains("Tripura")){
                state.click();
            }
        }

        waitHelpers.waitJVM(5000);
        driver.quit();
    }
}
