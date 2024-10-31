package by.onliner.pages.main;

import by.onliner.pages.login.LoginLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(By.xpath(MainLocator.SIGN_IN_BUTTON));
        signInButton.click();
    }
}
