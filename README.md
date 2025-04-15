# Report Portal Test Automation
Проект по автоматизации UI и API тестирования для демо-версии Report Portal.

Проект разделен на две части:
- **UI тесты** (с использованием Selenium WebDriver)
- **API тесты** (на базе RestAssured)

Все тесты сопровождаются отчётами через Allure.

## Стек технологий:

- Java 17+
- Maven
- Selenium WebDriver
- RestAssured
- JUnit 5
- Allure Reports
- WebDriverManager
- Page Object Model


## Что реализовано:

### UI тесты:
- Авторизация в системе (логин по логину и паролю)
- Добавление нового Widget типа "Task Progress"
- Проверка, что виджет отображается на Dashboard

### API тесты:
- Создание нового Dashboard (позитивный тест)
- Создание Dashboard с некорректными параметрами (негативный тест)


## Как запустить тесты:

### Подготовка:
Убедитесь, что у вас установлен Java (17 или выше), Maven и браузер Chrome.

### Запуск всех тестов:

```bash
mvn clean test
