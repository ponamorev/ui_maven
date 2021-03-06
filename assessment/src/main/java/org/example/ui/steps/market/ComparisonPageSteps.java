package org.example.ui.steps.market;

import io.qameta.allure.Step;
import org.example.ui.pages.market.ComparisonPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ComparisonPageSteps extends BaseSteps {
    private final ComparisonPage page;

    public ComparisonPageSteps(WebDriver driver) {
        page = new ComparisonPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы с результатами сравнения товаров")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Проверить, что {count}-й элемент из сравнения имеет название '{expectedProductName}'")
    public void checkComparableProductName(int count, String expectedProductName) {
        String actualProductName = page.getComparableProductName(count);
        Assertions.assertEquals(expectedProductName, actualProductName,
                "Название продукта не совпадает с ожидаемым");
    }

    @Step("Удалить {count}-й элемент из сравнения")
    public void deleteComparedProduct(int count) {
        page.clickDeleteComparisonProduct(count);
    }

    @Step("Проверить, что товары для сравнения отсутствуют и есть сообщение '{expectedMessage}'")
    public void checkEmptyComparisonListAndMessage(String expectedMessage) {
        Assertions.assertTrue(page.isComparisonProductsListStale(),
                "Список сравниваемых товаров не пустой");
        String actualMessage = page.getNoProductMessageText();
        Assertions.assertEquals(expectedMessage, actualMessage,
                "Сообщение об отсутствии товаров не совпадает с ожидаемым");
    }
}
