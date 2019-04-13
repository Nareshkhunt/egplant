package com.eggplant;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Eggplant {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.wikipedia.org/");

    }
    @Test
    public void searchFunctionality(){
        driver.findElement(By.id("searchInput")).sendKeys("schipperke");
        driver.findElement(By.cssSelector(".sprite.svg-search-icon")).click();
     WebElement img =driver.findElement(By.xpath("//img[@alt='Schipperke0001.jpg']"));
        if(img.isDisplayed()){
            System.out.println("log message: The schipperke dog page was found");
        }
        else {
            System.out.println("log message: The schipperke page was not found");
        }
    }
   @After
    public void tearDown(){
        driver.quit();
    }
}
