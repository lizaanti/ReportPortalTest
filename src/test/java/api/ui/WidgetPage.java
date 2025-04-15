package api.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WidgetPage {
    private WebDriver driver;

    // Локаторы для выбора типа виджета и сохранения
    private By taskProgressWidgetOption = By.xpath("//div[text()='Task Progress']");
    private By saveWidgetButton = By.xpath("//button[contains(text(),'Save')]");

    public WidgetPage(WebDriver driver) {
    }

    @Step("Выбираем виджет 'Task Progress'")
    public WidgetPage selectTaskProgressWidget() {
        driver.findElement(taskProgressWidgetOption).click();
        return this;
    }

    @Step("Сохраняем виджет")
    public DashboardPage saveWidget() {
        driver.findElement(saveWidgetButton).click();
        return new DashboardPage(driver);
    }
}
