package com.pflb.learning.pages;

import org.openqa.selenium.support.PageFactory;
import static com.pflb.learning.utils.DriverManager.getDriver;

/**
 * Абстрактный класс, родитель всех Page'ей
 * Сделан для того, чтобы все Page'и наследовали конструктор и поле с драйвером
 */
abstract class AbstractPage {

    /**
     * Дефолтный конструктор. Тут сразу получаем драйвер для взаимодействия с ним
     * А так же инициализируем элементы на Page'ах, которые были заданы с помощью аннотаций @FindBy
     */
    AbstractPage() {
        PageFactory.initElements(getDriver(), this);
    }


}
