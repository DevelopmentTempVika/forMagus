package ru.spring.temp3.pages.market;


//import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.spring.temp3.pages.AbstractPage;

import java.util.List;

/**
 * Главная страница яндекс маркета.
 * Реализован переход к указанной категории и подкатегории
 */
public class YandexMarketPage extends AbstractPage {
    private WebDriverWait wait;

    @FindBy(xpath = "//*[contains(@class, 'catalog-menu__list-item')]")
    private List<WebElement> subcategoryItems;


    public YandexMarketPage(){
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Выбрать категорию
     * @param category имя категории
     * @return этот объект
     */
    //@Step
    public YandexMarketPage goToCategory(String category){
        WebElement element = driver.findElement(By.xpath("//*/a[text()='" + category + "']"));
        element.click();

        return this;
    }

    /**
     * Выбрать подкатегорию
     * @param subcategory имя подкатегории
     * @return этот объект
     */
    //@Step
    public YandexMarketPage goToTheSubcategory(String subcategory){
        for (WebElement element : subcategoryItems){
            if (element.getText().equals(subcategory)) {
                element.click();
                break;
            }
        }

        return this;
    }
}
