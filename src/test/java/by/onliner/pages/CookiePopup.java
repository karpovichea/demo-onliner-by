package by.onliner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiePopup {
    private WebDriver driver;
    private final String ACCEPT_COOKIE_BUTTON = "submit-button";

    public CookiePopup(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement acceptCookieButton = driver.findElement(By.id(ACCEPT_COOKIE_BUTTON));
        acceptCookieButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ACCEPT_COOKIE_BUTTON)));
    }
}
