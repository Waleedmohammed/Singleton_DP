package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverManager {

    private static volatile WebDriverManager driverInstance;
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private WebDriverManager() {

    }

    private void initDriver(String browser) {
        switch (browser) {
            case "chrome":
                threadLocalDriver.set(new ChromeDriver());
                break;
            case "firefox":
                threadLocalDriver.set(new FirefoxDriver());
                break;
            case "safari":
                threadLocalDriver.set(new SafariDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser " + browser);
        }
    }

    public static WebDriverManager getInstance(String browser) {
        if (driverInstance == null) {
            synchronized (WebDriverManager.class) {
                if (driverInstance == null) {
                    driverInstance = new WebDriverManager();
                }
            }
        }
        if (threadLocalDriver.get() == null) {
            driverInstance.initDriver(browser);
        }
        return driverInstance;
    }

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void quiteBrowser() {
        if (threadLocalDriver.get() != null) {
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        }
    }
}
