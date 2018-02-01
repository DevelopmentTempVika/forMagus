package ru.spring.junit.temp4;

//import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Главная страница яндекса и переход в яндекс маркет
 */
public class YandexSearchPage extends AbstractPage {
    private WebDriverWait wait;
    private String URL = "http://yandex.ru";

    @FindBy(xpath = "//*[contains(@class, 'home-tabs__search')]")
    private List<WebElement> homeTabs;

    public YandexSearchPage(){
        wait = new WebDriverWait(driver, 10);
    }

    public void loadUrl(String address) {
        driver.navigate().to(URL);
    }

    /**
     * Загрузка главной страницы яндекса
     * @return этот объект
     */
    //@Step
    public YandexSearchPage load(){
        driver.navigate().to(URL);
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//")));

        return this;
    }

    /**
     * Перейти в маркет
     * @return этот объект
     */
    //@Step
    public YandexSearchPage goToMarket(){
        for (WebElement element : homeTabs){
            if (element.getText().equals("Маркет")) {
                element.click();
                break;
            }
        }

        return this;
    }
}