package api.ui.tests;


import api.ui.DashboardPage;
import api.ui.LoginPage;
import api.ui.WidgetPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReportPortalUITest {
    private static WebDriver driver;
    private static DashboardPage dashboardPage;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.reportportal.io");
    }

    @Test
    @Order(1)
    @Description("Логин в Report Portal")
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login("default", "1q2w3e");
        Assertions.assertTrue(dashboardPage.isPageLoaded(), "Dashboard не загрузился корректно");
    }

    @Test
    @Order(2)
    @Description("Добавление нового виджета 'Task Progress'")
    public void testAddWidget() {
        WidgetPage widgetPage = dashboardPage.clickAddWidget();
        widgetPage.selectTaskProgressWidget();
        dashboardPage = widgetPage.saveWidget();
        
        Assertions.assertTrue(dashboardPage.isPageLoaded(), "Виджет не добавлен или Dashboard не отображается");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null)
            driver.quit();
    }
}