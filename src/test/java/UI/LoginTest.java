package UI;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

//    @AfterEach
//    void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    void registrationTest() {
        RegistrationPage regPage = new HomePage().loadHomePage(driver).goToRegistrationPage(driver);
        regPage.fillFields(driver, wait);
        regPage.submitRegistrationForm(driver, wait);
        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome"));
    }

    @Test
    void servicePageTest() {
        new HomePage().loadHomePage(driver).goToServicePage(driver);
        assertTrue(driver.findElement(By.className("heading")).getText().contains("Bookstore "));
    }

    @Test
    void adminPageTest() {
        new HomePage().loadHomePage(driver).goToAdminPage(driver);
        assertTrue(driver.findElement(By.className("title")).getText().contains("Administration"));
    }

    @Test
    void locationPageTest() {
        new HomePage().loadHomePage(driver).goToLocationPage(driver);
        assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div[1]")).getText().contains("Deliver "));
    }

    @Test
    void productsPageTest() {
        new HomePage().loadHomePage(driver).goToProductPage(driver);
        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Parasoft Continuous "));
    }
}








