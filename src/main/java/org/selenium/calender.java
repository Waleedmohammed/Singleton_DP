package org.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.pagefactory.ByAll;

public class calender {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.get("https://www.redbus.in/");

        driver.findElement(By.xpath("//div[@class='labelCalendarContainer']")).click();

        Thread.sleep(2000);


    }
}
