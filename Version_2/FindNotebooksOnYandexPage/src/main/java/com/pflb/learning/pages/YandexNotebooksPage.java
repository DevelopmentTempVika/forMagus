package com.pflb.learning.pages;

import com.jayway.jsonpath.JsonPath;
import com.pflb.learning.utils.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Класс описывает страницу, на которой задаются параметры поиска
 */
public class YandexNotebooksPage extends AbstractPage {

    /**
     * Заголовок на странице
     */
    public static final String titlePages = "Ноутбуки";

    /**
     * Цена от
     */
    @FindBy(xpath = ".//*[@id='glf-pricefrom-var']") //найти по xpath
    private WebElement priceStart;

    /**
     * Цена до
     */
    @FindBy(xpath = ".//*[@id='glf-priceto-var']") //найти по xpath
    private WebElement priceFinish;

    /**
     * Ноутбук, фирма HP
     */
    @FindBy(xpath = "html/body/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[4]/div[2]/div/div[1]/div[5]/a/span/label")
    private WebElement hpElement;

    /**
     * Ноутбук, фирма Lenovo
     */
    @FindBy(xpath = "html/body/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[4]/div[2]/div/div[1]/div[6]/a/span/label")
    private WebElement lenovoElement;

    @FindBy(xpath = "html/body/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[4]/div[2]/div/div[1]/div[4]/a/span/label")
    private WebElement dl;

    /**
     * Кнопка "Применить"
     */
    @FindBy(xpath = "html/body/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[32]/div[1]/button")
    private WebElement toApplyButton;

    /**
     * Проверка заголовка страницы
     */
    public void checkTitlePage() {
        WebElement realTitlePage = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[2]/h1")); //найдем элемент
        Assert.assertEquals(titlePages, realTitlePage.getText()); //проверим, что текст в найденном элементе совпадает с ожидаемым
    }

    /**
     * Заполнение поля
     * @param startPrice
     */
    public void choiceStartPriceNotebook(String startPrice){
        priceStart.click();
        this.priceStart.sendKeys(startPrice);
    }

    /**
     * Заполнение поля
     * @param finishPrice
     */
    public void choiceFinishPriceNotebook(String finishPrice){
        priceFinish.click();
        priceFinish.sendKeys(finishPrice);
    }

    /**
     * Выбор производителя
     */
    public void choiceManufacturer(){
        hpElement.click();
        lenovoElement.click();
    }

    /**
     * Нажать на кнопку "Применить"
     */
    public void pressedToApply(){
        toApplyButton.click();
    }

    /**
     * Колличество элментов в результате поиска
     * Данный метод временно не тестируется
     */
    public void countFindNotebooksOnPayge(){
        WebElement webElement = driver.findElement(By.cssSelector("div[class*='n-snippet-list n-snippet-list_type_vertical b-zone b-spy-init i-bem snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']"));
        String temp = webElement.getAttribute("data-bem");
        int countFindElements = JsonPath.read(temp, "$.b-zone.data.products.count");
        /**
         * Нужное число элментов на странице после поиска должно быть не более десяти
         * Проверям.
         */
        if (countFindElements > 10) {
            System.out.println("Число найденных элементов больше 10.Число найденных элементов: " + countFindElements);
        } else System.out.println(countFindElements);
    }

    /**
     * Показать список найденных по фильтру ноутбуков
     */
    //Метод еще в разработке
    /*public void showFirstElementInResult(){
        List<WebElement> videoElements = driver.findElements(By.cssSelector("div[class*='n-snippet-list n-snippet-list_type_vertical b-zone b-spy-init i-bem snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']"));
        System.out.println(videoElements.size());
        int numberElement = videoElements.size();
        for(WebElement state : videoElements){
            //System.out.println(state.getText());
            System.out.println("---" + state.getText() + "---");
        }
    }*/
}