package com.pflb.learning.pages;

import com.pflb.learning.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by vika on 27.11.2017.
 */
public class YandexComputersPage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Заголово на странице
    public static final String titleComputerEquipment = "Компьютерная техника";
    @FindBy(xpath = "html/body/div[1]/div[3]/div/div/div/h1")
    private WebElement realTitleComputerEquipment;

    //Раздел Ноутбуки
    @FindBy(xpath = "html/body/div[1]/div[4]/div[1]/div/div[1]/div/a[2]") //найти по xpath
    private WebElement notebooks;

    public YandexComputersPage() {
        super();
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    public YandexNotebooksPage goToNotebooks() {
        notebooks.click();
        return new YandexNotebooksPage();
    }
}