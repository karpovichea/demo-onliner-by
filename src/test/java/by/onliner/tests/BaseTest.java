package by.onliner.tests;

import by.onliner.pages.MainPage;
import by.onliner.pages.CookiePopup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://onliner.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        CookiePopup cookiePopup = new CookiePopup(driver);
        cookiePopup.acceptCookie();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignInButton();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
