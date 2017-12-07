package com.pflb.learning.pages;

import com.pflb.learning.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс описывает страницу Маркет
 */
public class YandexMarketPage extends AbstractPage {

    //Вкладка Компьтеры
    @FindBy(xpath = "html/body/div[1]/div[2]/noindex/ul/li[2]/a") //найти по xpath
    private WebElement computers;
    //Вкладка Ноутбуки
    @FindBy(xpath = "html/body/div[1]/div[4]/div[1]/div/div[1]/div/a[2]") //найти по xpath
    private WebElement notebooks;

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