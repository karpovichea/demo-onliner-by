package by.onliner.tests;

import by.onliner.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    private static final String LOGIN = "Nick";
    private static final String PASSWORD = "123456";
    private LoginPage loginPage;

    @BeforeEach
    void setUpLoginTests() {
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Тест: пустой логин и пароль")
    public void testSignInWithEmptyLoginAndPassword() {

        loginPage.clickSignInButton();

        Assertions.assertEquals(loginPage.getExpectedEmptyLoginErrorMessage(), loginPage.getEmptyLoginErrorMessage(), "Неверный текст ошибки валидации для пустого логина");
        Assertions.assertEquals(loginPage.getExpectedEmptyPasswordErrorMessage(), loginPage.getEmptyPasswordErrorMessage(), "Неверный текст ошибки валидации для пустого пароля");
    }

    @Test
    @DisplayName("Тест: пустой логин")
    public void testSignInWithEmptyLogin() {
        loginPage
                .enterPassword(PASSWORD)
                .clickSignInButton();

        Assertions.assertEquals(loginPage.getExpectedEmptyLoginErrorMessage(), loginPage.getEmptyLoginErrorMessage(), "Неверный текст ошибки валидации для пустого логина");
    }

    @Test
    @DisplayName("Тест: пустой пароль")
    public void testSignInWithEmptyPassword() {
        loginPage
                .enterLogin(LOGIN)
                .clickSignInButton();

        Assertions.assertEquals(loginPage.getExpectedEmptyPasswordErrorMessage(), loginPage.getEmptyPasswordErrorMessage(), "Неверный текст ошибки валидации для пустого пароля");
    }
}
