package UI;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
class Login {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    void registrationTest() {
        RegistrationPage regPage = new HomePage().loadHomePage(driver).goToRegistrationPage(driver);
        regPage.fillFields(driver, wait);
        regPage.submitRegistrationForm(driver, wait);
        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome Eno"));
    }

    @Test
    void servicePageTest() {
        new HomePage().loadHomePage(driver).goToServicePage(driver);
        assertTrue(driver.findElement(By.className("heading")).getText().contains("Bookstore"));
    }

    @Test
    void adminPageTest() {
        new HomePage().loadHomePage(driver).goToAdminPage(driver);
        assertTrue(driver.findElement(By.className("Title")).getText().contains("Administration"));
    }

    @Test
    void locationPageTest() {
        new HomePage().loadHomePage(driver).goToLocationPage(driver);
        assertTrue(driver.findElement(By.className("wysiwyg-content")).getText().contains("Safety & Security-Critical Testing"));
    }

    @Test
    void productsPage() {
        new HomePage().loadHomePage(driver).goToProductPage(driver);
        assertTrue(driver.findElement(By.className("cky-preference-title")).getText().contains("Customise Consent Preferences"));
    }
}








