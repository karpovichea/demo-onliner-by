package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLogin(String login) {
        WebElement loginField = driver.findElement(By.xpath(LoginLocator.LOGIN_FIELD));
        loginField.sendKeys(login);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath(LoginLocator.PASSWORD_FIELD));
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(By.xpath(LoginLocator.SIGN_IN_BUTTON));
        signInButton.click();
    }

    public String getEmptyLoginErrorMessage() {
        WebElement textMessage = driver.findElement(By.xpath(LoginLocator.EMPTY_LOGIN_ERROR_MESSAGE));
        return textMessage.getText();
    }

    public String getEmptyPasswordErrorMessage() {
        WebElement textMessage = driver.findElement(By.xpath(LoginLocator.EMPTY_PASSWORD_ERROR_MESSAGE));
        return textMessage.getText();
    }
}
