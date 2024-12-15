package com.autotest.steps;


import io.cucumber.java.ru.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepsUserInterfaceTest {


    private WebDriver driver;

    @Дано("загружен драйвер")
    @Step("Загрузить драйвер для работы с браузером")
    public void загрузить_драйвер () {
        System.setProperty("webdriver.chromedriver.driver", "D:\\ibs-task\\cucumber\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @И("открыт сайт {string}")
    @Step("Открыть сайт: {string}")
    public void открыть_сайт(String string) {
        driver.get("http://localhost:8080/");
    }

    @И("страница полностью загружена")
    @Step("Дождаться полной загрузки страницы")
    public void загрузить_страницу () {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @И("окно браузера развернуто")
    @Step("Развернуть окно браузера на полный экран")
    public void развернуть_окно () {
        driver.manage().window().maximize();
    }

    @И("пользователь на вкладке \"Песочница\" в разделе \"Товары\"")
    @Step("Перейти в раздел \"Товары\" во вкладке \"Песочница\"")
    public void перейти_во_вкладку () {
        WebElement btnSandbox = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
        btnSandbox.click();

        WebElement btnGoods = driver.findElement(By.xpath("//a[@href='/food']"));
        btnGoods.click();
    }

    @Когда("пользователь нажимает на кнопку \"Добавить\"")
    @Step("Нажать на кнопку \"Добавить\"")
    public void нажать_кнопку_добавить () {
        WebElement btnAdd = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
        btnAdd.click();
    }

    @И("вводит в поле \"Наименование\" значение {string}")
    @Step("Ввести в поле \"Наименование\" значение: {string}")
    public void ввести_навзвание_товара (String name) {
        WebElement inputName = driver.findElement(By.xpath("//input[@id='name']"));
        inputName.sendKeys(name);
    }

    @И("выбирает тип товара \"Фрукт\"")
    @Step("Выбрать тип товара \"Фрукт\"")
    public void выбрать_тип_товара () {
        WebElement typeDropdown = driver.findElement(By.xpath("//select[@id='type']/..//option[@value='FRUIT']"));
        typeDropdown.click();
    }

    @И("выбирает тип товара \"Овощ\"")
    @Step("Выбрать тип товара \"Овощ\"")
    public void выбрать_тип_товара2 () {
        WebElement typeDropdown = driver.findElement(By.xpath("//select[@id='type']/..//option[@value='VEGETABLE']"));
        typeDropdown.click();
    }

    @И("ставит галочку \"Экзотический\", если {string} равно \"Да\"")
    @Step("Поставить галочку на чекбокс \"Экзотический\"")
    public void нажать_на_чекбокс(String condition) {
        WebElement exoticCheckbox = driver.findElement(By.xpath("//input[@id='exotic']"));
        exoticCheckbox.click();
        Assertions.assertTrue(exoticCheckbox.isSelected());
    }

    @И("нажимает на кнопку \"Сохранить\"")
    @Step("Нажать на кнопку \"Сохранить\"")
    public void сохранить_изменения () {
        WebElement saveButton = driver.findElement(By.xpath("//button[@id='save']"));
        saveButton.click();
    }

    @Тогда("добавленный товар отображается в таблице под номером {int}")
    @Step("Проверить, что товар отображается в таблице под номером: {int}")
    public void проверить_товар (int rowNumber) {
        WebElement rowTitle = driver.findElement(By.xpath(String.format("//tr[%d]/th[@scope='row']", rowNumber)));
        Assertions.assertEquals(Integer.toString(rowNumber), rowTitle.getText(), "Товар не был добавлен.");
    }

    @Когда("пользователь переходит во вкладку \"Песочница\" и выбирает \"Сброс данных\"")
    @Step("Перейти во вкладку \"Песочница\" и выбираем \"Сброс данных\"")
    public void сброс_данных () {
        WebElement btnSandbox = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
        btnSandbox.click();

        WebElement btnReset = driver.findElement(By.xpath("//a[@id='reset']"));
        btnReset.click();
    }

    @Тогда("данные сброшены, страница закрывается")
    @Step("Закрыть страницу")
    public void закрыть_страницу () {
        driver.close();
        driver.quit();
    }

}
