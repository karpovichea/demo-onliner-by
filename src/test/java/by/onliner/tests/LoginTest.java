package by.onliner.tests;

import by.onliner.pages.login.LoginMessage;
import by.onliner.pages.login.LoginPage;
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
        loginPage.enterLogin(LOGIN);
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.EMPTY_PASSWORD_FIELD, loginPage.getEmptyPasswordErrorMessage(), "Неверный текст ошибки валидации для пустого пароля");
    }
}
