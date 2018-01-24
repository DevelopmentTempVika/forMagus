package ru.temp;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.temp.helpers.DriverManager;
import ru.temp.pages.YandexSearchPage;
import ru.temp.pages.market.YandexMarketPage;
import ru.temp.pages.market.YandexMarketTabletsPage;

import static org.hamcrest.CoreMatchers.is;

public class Test {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private BrowserManagement browserManagement;
    private YandexSearchPage yandexSearchPage;
    private YandexMarketPage yandexMarketPage;
    private YandexMarketTabletsPage yandexMarketTabletsPage = new YandexMarketTabletsPage();

    @Rule
    public ErrorCollector collector = new ErrorCollector();


    @Before
    public void setUp(){
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @After
    public void tearDown() {
        DriverManager.getDriver().quit();
    }

    @org.junit.Test
    public void test1(){
        browserManagement = new BrowserManagement();
        browserManagement.windowMaximize();

        yandexSearchPage = new YandexSearchPage();
        yandexSearchPage.load();
        yandexSearchPage.goToMarket();

        yandexMarketPage = new YandexMarketPage();
        yandexMarketPage.goToCategory("Компьютеры").goToTheSubcategory("Планшеты");


        yandexMarketTabletsPage.goToAllFilters().setPrice(20000, 25000)
                .showAllCompany()
                .setCompany("DELL")
                .setCompany("Acer")
                .submitFilters();
        // проверка на количество элементов
        //collector.checkThat(yandexMarketTabletsPage.amountOfElements(), is(10));
    }

    /*@org.junit.Test
    public void test2(){
        String expected = yandexMarketTabletsPage.getNameElement(0);
        yandexMarketTabletsPage.search(expected);
        String actual = yandexMarketTabletsPage.getNameElement(0);

        collector.checkThat(expected, is(actual));
    }*/
}