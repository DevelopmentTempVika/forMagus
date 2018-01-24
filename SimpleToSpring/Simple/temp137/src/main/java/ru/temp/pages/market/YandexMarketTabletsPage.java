package ru.temp.pages.market;

///import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.temp.pages.AbstractPage;

import java.util.List;

import static ru.temp.helpers.DriverManager.getDriver;

/**
 * Страница с элементами подкатегории. Проверена на планшетах, однако должна работать во всех подкатегориях, но это не точно)
 */
public class YandexMarketTabletsPage extends AbstractPage {
    private WebDriverWait wait;

    @FindBy(xpath = "//*[contains(@class, 'n-filter-panel-aside__content')]//*[contains(@class, 'link_js_inited')]")
    private WebElement goToAllFilters;

    @FindBy(xpath = "//*[contains(@id, 'glf-pricefrom-var')]")
    private WebElement priceFrom;

    @FindBy(xpath = "//*[contains(@id, 'glf-priceto-var')]")
    private WebElement priceTo;

    @FindBy(xpath = "//*[text()='Показать подходящие']/..")
    private WebElement submit;

    private List<WebElement> products;

    public YandexMarketTabletsPage(){
        wait = new WebDriverWait(driver, 10);
    }

    /**
     *  Перейти ко всем фильтрам(расширенный поиск)
     * @return этот объект
     */
    ///@Step
    public YandexMarketTabletsPage goToAllFilters(){
        goToAllFilters.click();

        return this;
    }

    /**
     *  Устанавливает диапазон цен в рублях.
     *  Вызывать после goToAllFilters()
     * @param from от
     * @param to до
     * @return этот объект
     */
    ///@Step
    public YandexMarketTabletsPage setPrice(int from, int to){
        priceFrom.sendKeys(Integer.toString(from));
        priceTo.sendKeys(Integer.toString(to));

        return this;
    }

    /**
     * Выбрать компанию
     * Вызывать после goToAllFilters() и showAllCompany()
     * @param company название компании
     * @return этот объект
     */
    ///@Step
    public YandexMarketTabletsPage setCompany(String company){
        WebElement searchInput = driver.findElement(By.xpath("//*/span[text()='Производитель']/../../..//input[contains(@class, 'input__control')]"));
        searchInput.clear();
        searchInput.sendKeys(company);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/label[text()='" + company + "']/../span")));
        WebElement element = driver.findElement(By.xpath("//*/label[text()='" + company + "']/../span"));
        element.click();

        return this;
    }

    /**
     * Показать весь список компаний.
     * Вызывать после goToAllFilters()
     * @return этот объект
     */
    ///@Step
    public YandexMarketTabletsPage showAllCompany(){
        WebElement elementShowAllCompany = driver.findElement(By.xpath("//*/button/span[text()='Показать всё']/.."));
        elementShowAllCompany.click();
        waitForJSandJQueryToLoad();

        return this;
    }

    /**
     * Принять настройки фильтрации
     * Вызывать после goToAllFilters()
     * @return этот объект
     */
    public YandexMarketTabletsPage submitFilters(){
        submit.click();

        return this;
    }

    /**
     * Вызывать до goToAllFilters() или после submitFilters()
     * @return количество товаров на странице
     */
    public int amountOfElements(){
        products = driver.findElements(By.className("n-snippet-card2__title"));

        return products.size();
    }

    /**
     * @param index индекс элемента. Нумерация начинается с 0
     * @return возвращает наименование товара
     */
    public String getNameElement(int index){
        List<WebElement> elements = driver.findElements(By.xpath("//*/div[@class='n-snippet-card2__title']/a"));

        return elements.get(index).getText();
    }

    /**
     * Выполняет поиск товаров с заданным наименованием
     * @param name наименование товара
     * @return этот объект
     */
    public YandexMarketTabletsPage search(String name){
        WebElement searchField = driver.findElement(By.id("header-search"));
        searchField.sendKeys(name);
        WebElement submit = driver.findElement(By.cssSelector(".search2__button button"));
        submit.click();

        return this;
    }

    /**
     * Ожидание (wait) выполнения ajax
     */
    private void waitForJSandJQueryToLoad() {

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)getDriver()).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)getDriver()).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        wait.until(jQueryLoad);
        wait.until(jsLoad);
    }
}