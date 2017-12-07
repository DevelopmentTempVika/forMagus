package com.pflb.learning.pages;

import com.pflb.learning.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.pflb.learning.utils.DriverManager.getDriver;

/**
 * Абстрактный класс, родитель всех Page'ей
 * Сделан для того, чтобы все Page'и наследовали конструктор и поле с драйвером
 */
abstract class AbstractPage {
    WebDriver driver;
    WebDriverWait wait;

    /**
     * Дефолтный конструктор. Тут сразу получаем драйвер для взаимодействия с ним
     * А так же инициализируем элементы на Page'ах, которые были заданы с помощью аннотаций @FindBy
     */
    AbstractPage() {
        PageFactory.initElements(getDriver(), this);
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }
}
