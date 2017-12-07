package com.pflb.learning.pages;

import com.pflb.learning.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by vika on 26.11.2017.
 */
public class YandexMarketPage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //Вкладка Компьтеры
    @FindBy(xpath = "html/body/div[1]/div[2]/noindex/ul/li[2]/a") //найти по xpath
    private WebElement computers;
    //Вкладка Ноутбуки
    @FindBy(xpath = "html/body/div[1]/div[4]/div[1]/div/div[1]/div/a[2]") //найти по xpath
    private WebElement notebooks;

    public YandexMarketPage() {
        super();
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    //Переходим на вкладку Компьютеры
    public YandexComputersPage goToComputers (){
        computers.click();
        return new YandexComputersPage();
    }

    //Переходим на вкладку Ноутбуки
    /*public YandexComputersPage goToNotebooks (){
        notebooks.click();
        return new YandexComputersPage();
    }*/
}