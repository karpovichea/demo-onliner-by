package by.onliner.tests;

import by.onliner.pages.login.LoginMessage;
import by.onliner.pages.login.LoginPage;
import by.onliner.pages.main.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LoginTest {
    private static final String LOGIN = "Nick";
    private static final String PASSWORD = "123456";
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.get("https://onliner.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignInButton();

    }

    @Test
    @DisplayName("Тест: пустой логин и пароль")
    public void testSignInWithEmptyLoginAndPassword() {
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.EMPTY_LOGIN_FIELD, loginPage.getEmptyLoginErrorMessage(), "Неверный текст ошибки валидации для пустого логина");
        Assertions.assertEquals(LoginMessage.EMPTY_PASSWORD_FIELD, loginPage.getEmptyPasswordErrorMessage(), "Неверный текст ошибки валидации для пустого пароля");
    }

    @Test
    @DisplayName("Тест: пустой логин")
    public void testSignInWithEmptyLogin() {
        loginPage.enterPassword(PASSWORD);
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.EMPTY_LOGIN_FIELD, loginPage.getEmptyLoginErrorMessage(), "Неверный текст ошибки валидации для пустого логина");
    }

    @Test
    @DisplayName("Тест: пустой пароль")
    public void testSignInWithEmptyPassword() {
        loginPage.enterPassword(LOGIN);
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.EMPTY_PASSWORD_FIELD, loginPage.getEmptyPasswordErrorMessage(), "Неверный текст ошибки валидации для пустого пароля");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
