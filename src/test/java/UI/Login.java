package UI;

import Pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Pages.HomePage;

@Nested
class Login {
    WebDriver driver;

    @BeforeEach
    void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        StringBuffer a = new StringBuffer();
    }

    @Test
    void aboutUs() {
        HomePage homePage = new HomePage().loadHomePage(driver);
        boolean isOnAboutUsPage = homePage.goToAboutUsPage(driver);
        assertTrue(isOnAboutUsPage);
        driver.quit();
    }


    @Test
    void registrationTest() {
        HomePage homePage = new HomePage();
        RegistrationPage regPage = homePage.loadHomePage(driver).goToRegistrationPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        regPage.fillFields(driver, wait);
        regPage.submitRegistrationForm(driver, wait);

        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome Eno"));
    }
}




