package api.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    // Локатор для Widget, который будет добавляться
    private By widgetArea = By.id("widgetArea");
    private By addWidgetButton = By.id("addWidget");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход к добавлению нового виджета")
    public WidgetPage clickAddWidget() {
        driver.findElement(addWidgetButton).click();
        return new WidgetPage(driver);
    }

    @Step("Проверка, что Dashboard загружен")
    public boolean isPageLoaded() {
        return driver.findElement(widgetArea).isDisplayed();
    }
}
