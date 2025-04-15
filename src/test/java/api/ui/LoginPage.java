package api.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("login");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[contains(text(), 'Login']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Вход в Report Portal с использованием {username}")
    public DashboardPage login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }
}
