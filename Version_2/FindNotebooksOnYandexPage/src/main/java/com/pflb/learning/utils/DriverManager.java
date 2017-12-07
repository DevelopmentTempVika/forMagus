package com.pflb.learning.utils;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//@DisplayName("DriverManager test")
public class DriverManager {
    WebDriverWait wait;
    private static WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void goToUrl(String url){
        driver.navigate().to(url);
    }

    public static void maximize() {
        driver.manage().window().maximize();
    }
}
