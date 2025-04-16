package com.SeleniumPractice.ex_01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestSelenium03_Webdriver_hierarchy {
    public static void main(String[] args){
        // Webdriver hierarchy

        // SearchContext(I) -> (2) -> WebDriver(I)( 10) -> RemoteWebDriver(C) (15)
        //// -> ChromiumDriver(C) 25 -> EdgeDriver(C) (45)


        // SearchContext(I)
        // -> WebDriver(I)
        // -> RemoteWebDriver(C)
        // -> ChromiumDriver(C)
        // -> ChromeDriver(C) , EdgeDriver(C) , BraveBrowser (


        // SearchContext - Interface - findElement, and findElements - GGF
        // WebDriver - Interface - some incomplete functions - GF
        // RemoteWebDriver - Class- It also has some functions - F
        // ChromeDriver, FirefoxDriver, EdgeDriver, SafariDriver, InternetExplorerDriver  Class - S


        //SearchContext driver = new ChromeDriver();
//        SearchContext driver = new EdgeDriver();
//        SearchContext driver1 = new FirefoxDriver();
//        SearchContext driver2 = new InternetExplorerDriver();


//        WebDriver driver = new ChromeDriver();
//        RemoteWebDriver driver1 = new ChromeDriver();
//        ChromeDriver  driver2 = new ChromeDriver();

        //Case 1 :If we want to run our test only on chrome/edge
       // ChromeDriver  driver1 = new ChromeDriver();
       // EdgeDriver  driver2 = new EdgeDriver();

        //Case 2 : Ife we want to run in chrome and then change to edge
        //WebDriver driver = new ChromeDriver();
       // driver = new EdgeDriver();

        //Case 3 : if we want to run on multiple browsers,aws machines
       // RemoteWebDriver driver=new ChromeDriver();

    }
}
