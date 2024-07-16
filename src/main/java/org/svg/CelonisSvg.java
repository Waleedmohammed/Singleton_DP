package org.svg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CelonisSvg {

    static WebDriver driver;

    static By emailTxtBox = By.id("username");

    static By passwordTxtBox = By.id("password");

    static By singInBtn = By.xpath("//button[@cetestinguid='ce-login-form-signIn-button']/span[@class='btn-text']");

    static By myTab = By.xpath("//*[local-name()='ems-cloud-header']//*[name()='ems-app-switcher-link']//a[@href='/process-workspace/ui']");

    static By explorationTitle = By.xpath("//*[local-name()='ce-tile' and @data-testid='exploration-tile']");

    static By svgbar = By.xpath("//*[local-name()='svg']//*[name()='g' and @class='chart-body']//*[name()='g' and @class='mark-layers']//*[name()='g' and @class='bar']");

    public static void main(String[] args) throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        driver.get("https://id.celonis.cloud/user/ui/login");

        Thread.sleep(2000);
        driver.findElement(emailTxtBox).sendKeys("*******");
        driver.findElement(passwordTxtBox).sendKeys("*********");
        driver.findElement(singInBtn).click();

        Thread.sleep(15000);

        driver.findElement(myTab).click();

        Thread.sleep(2000);

        driver.findElement(explorationTitle).click();

        Thread.sleep(8000);

        List<WebElement> allBars = driver.findElements(svgbar);
        System.out.println(allBars.size());


    }
}
