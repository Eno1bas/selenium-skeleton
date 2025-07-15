package UI;

import Pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Pages.HomePage;
import Pages.*;

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
    void servicePageTest() {
        HomePage homePage = new HomePage();
        ServicesPage servPage = homePage.loadHomePage(driver).takeMeToServicePage(driver);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        servPage.goToServicePage(driver);
        assertTrue( driver.findElement(By.className("porttypename")).getText().contains("Bookstore"));
    }

    @Test
    void adminPageTest(){
        HomePage homePage = new HomePage();
        AdminPage abPage = homePage.loadHomePage(driver).takeMeToAdminPage(driver);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
       abPage.goToAdminPage(driver);
        assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/table/tbody/tr/td[1]/h3")).getText().contains("Database"));
    }
}








