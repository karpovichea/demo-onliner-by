package by.onliner.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final String EMPTY_LOGIN_ERROR_MESSAGE = "Укажите ник или e-mail";
    private final String EMPTY_PASSWORD_ERROR_MESSAGE = "Укажите пароль";
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='auth-form__line auth-form__line_condensed']//input[@type='text']")
    WebElement loginField;

    @FindBy(xpath = "//div[@class='auth-form__line auth-form__line_condensed']//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInButton;

    @FindBy(xpath = "//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']")
    WebElement loginErrorMessage;

    @FindBy(xpath = "(//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other'])[last()]")
    WebElement passwordErrorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getEmptyLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public String getEmptyPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public String getExpectedEmptyLoginErrorMessage() {
        return EMPTY_LOGIN_ERROR_MESSAGE;
    }

    public String getExpectedEmptyPasswordErrorMessage() {
        return EMPTY_PASSWORD_ERROR_MESSAGE;
    }
}
