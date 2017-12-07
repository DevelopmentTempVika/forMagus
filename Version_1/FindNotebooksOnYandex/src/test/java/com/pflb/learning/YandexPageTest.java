package com.pflb.learning;

import com.pflb.learning.pages.YandexComputersPage;
import com.pflb.learning.pages.YandexMainPage;
import com.pflb.learning.pages.YandexMarketPage;
import com.pflb.learning.pages.YandexNotebooksPage;
import com.pflb.learning.utils.DriverManager;
import org.junit.AfterClass;
import org.junit.ComparisonFailure;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.NoSuchElementException;


/**
 * Created by vika on 24.11.2017.
 */
public class YandexPageTest {

    YandexMainPage yandexMainPage;
    YandexMarketPage yandexMarketPage;
    YandexComputersPage yandexComputersPage;
    YandexNotebooksPage yandexNotebooksPage;

    /**
     * Переход на вкладку Ноутбуки в разделе Маркет
     */
    @Step
    @Test
    public void successGoToNotebooks() throws Exception{
        yandexMainPage = new YandexMainPage();
        //yandexMainPage.goToMarket();

        try {
            yandexMarketPage = yandexMainPage.goToMarket();
        } catch (NullPointerException e) {
            System.out.println("Экзмепляр класса,который вызывает метод не проинициализирован");
        } catch (NoSuchElementException e) {
            System.out.println("Элмент с заданным селектором на странице не найден");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //yandexMarketPage.goToComputers();
        try {
            yandexComputersPage = yandexMarketPage.goToComputers();
        } catch (NullPointerException e) {
            System.out.println("Экзмепляр класса,который вызывает метод не проинициализирован");
        } catch (NoSuchElementException e) {
            System.out.println("NullPointerException: "+"Элемент с заданным селектором на странице не найден");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //yandexMainPage.goToNotebooks();
        try {
            yandexNotebooksPage = yandexComputersPage.goToNotebooks();
        } catch (NullPointerException e) {
            System.out.println("Экзмепляр класса,который вызывает метод не проинициализирован");
        } catch (NoSuchElementException e) {
            System.out.println("Элмент с заданным селектором на странице не найден");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            yandexNotebooksPage.checkTitlePage();
        } catch (ComparisonFailure e) {
            System.out.println("Неверный заголовок страницы ");
        }
        //Поставить начальную цену - Цена от
        yandexNotebooksPage.choiceStartPriceNotebook("0");
        //Поставить конечную цену - Цена до
        yandexNotebooksPage.choiceFinishPriceNotebook("30000");
        //Показать кол-во найденных элментов на странице
        yandexNotebooksPage.countFindNotebooksOnPayge();

    }

    @AfterClass //Аннотация Junit. Говорит, что метод должен запускаться каждый раз после всех тестов
    public static void tearDown() {
        DriverManager.getDriver().quit();
    }
}