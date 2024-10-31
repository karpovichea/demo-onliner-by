package by.onliner.tests;

import by.onliner.pages.main.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36");

        driver = new ChromeDriver(options);
        driver.get("https://onliner.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignInButton();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
