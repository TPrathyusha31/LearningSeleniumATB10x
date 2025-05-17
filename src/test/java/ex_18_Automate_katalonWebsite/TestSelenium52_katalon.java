package ex_18_Automate_katalonWebsite;

import com.SeleniumPractice.ex_09_waitHelpers.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium52_katalon {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        waitHelpers.waitJVM(3000);
    }

    @Test
    public void test(){
        driver.findElement(By.id("btn-make-appointment")).click();

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");

       WebElement dropdown =  driver.findElement(By.id("combo_facility"));

        Select select = new Select(dropdown);
        select.selectByIndex(1);

        WebElement checkbox = driver.findElement(By.name("hospital_readmission"));
        checkbox.click();

        WebElement radiobutton = driver.findElement(By.id("radio_program_medicare"));
        radiobutton.click();

        WebElement calendar = driver.findElement(By.id("txt_visit_date"));
        calendar.sendKeys("16/12/2024");

        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.sendKeys("Health checkUp");

        waitHelpers.waitJVM(4000);

        driver.findElement(By.id("btn-book-appointment")).click();

        String PageHeader = driver.findElement(By.xpath("//h2[text() ='Appointment Confirmation']")).getText();
        Assert.assertEquals(PageHeader,"Appointment Confirmation");
    }

    @AfterTest
    public  void closeBrowser(){
       waitHelpers.waitJVM(3000);
        driver.quit();
    }

}
