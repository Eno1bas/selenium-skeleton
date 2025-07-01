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
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Pages.HomePage;
import Pages.servicesPage;
import Pages.locationsPage;
import Pages.aboutUsPage;
import Pages.productsPage;

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
    void registrationTest() {
        HomePage homePage = new HomePage();
        RegistrationPage regPage = homePage.loadHomePage(driver).goToRegistrationPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        regPage.fillFields(driver, wait);
        regPage.submitRegistrationForm(driver, wait);
        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome Eno"));
    }

    @Test
    void servicePageTests() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        servicesPage.service(driver);
        assertTrue( driver.findElement(By.className("porttypename")).getText().contains("Bookstore"));
    }
}








