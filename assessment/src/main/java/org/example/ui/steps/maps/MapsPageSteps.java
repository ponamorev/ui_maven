package org.example.ui.steps.maps;

import io.qameta.allure.Step;
import org.example.ui.pages.maps.MapsPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MapsPageSteps extends BaseSteps {
    private final MapsPage page;

    public MapsPageSteps(WebDriver driver) {
        page = new MapsPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы Яндекс.Карты")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step("Проверить, что страница с Яндекс.Карты была загружена")
    public void checkPageHaveBeenLoaded() {
        String expectedPageTitle = "Яндекс.Карты — поиск мест и адресов, городской транспорт";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Карты не совпадает с ожидаемым");
    }

    @Step("Нажать кнопку 'Актуальное'")
    public void clickActualButton() {
        page.clickActualButton();
    }

    @Step("Нажать ссылку карты распространения коронавируса")
    public void clickCovidMapsLink() {
        page.clickCovidMapsLink();
    }
}
