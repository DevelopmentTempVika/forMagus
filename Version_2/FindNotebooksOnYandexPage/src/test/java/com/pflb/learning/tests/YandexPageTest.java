package com.pflb.learning.tests;

import com.pflb.learning.pages.YandexComputersPage;
import com.pflb.learning.pages.YandexMainPage;
import com.pflb.learning.pages.YandexMarketPage;
import com.pflb.learning.utils.DriverManager;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Title;


import java.util.NoSuchElementException;

/**
 * В данном классе тестируется страница Яндекс Маркет
 */
@DisplayName("Class YandexPageTest works with page Яндекс Маркет")
public class YandexPageTest {
    YandexMainPage yandexMainPage;
    YandexMarketPage yandexMarketPage;
    YandexComputersPage yandexComputersPage;

    /**
     * Тест-кейс №1:"Переход на вкладку Компьютеры в разделе Маркет на странице Яндекс"
     * @throws Exception
     */
    @Test
    @DisplayName("Go to Computers")
    @Description("Click link Market->Computers")
    @Severity(SeverityLevel.NORMAL)
    public void successGoToMarket() throws Exception {
        //Переходим на главную страницу Яндекс
        yandexMainPage = new YandexMainPage();
        try {
            //Переходим на вкладку Маркет
            yandexMarketPage = yandexMainPage.goToMarket();
        } catch (NullPointerException e) {
            System.out.println("Экзмепляр класса yandexMarketPage,который вызывает метод не проинициализирован");
        } catch (NoSuchElementException e) {
            System.out.println("Элмент с заданным селектором на странице не найден");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Переходи на вкладку Компьютеры
        try {
            yandexComputersPage = yandexMarketPage.goToComputers();
        } catch (NullPointerException e) {
            System.out.println("Экзмепляр класса,который вызывает метод не проинициализирован");
        } catch (NoSuchElementException e) {
            System.out.println("NullPointerException: "+"Элемент с заданным селектором на странице не найден");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass //Аннотация Junit. Говорит, что метод должен запускаться каждый раз после всех тестов
    public static void tearDown() {
        DriverManager.getDriver().quit();
    }
}