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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

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
    void aboutUs() throws InterruptedException {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[1]/li[2]/a")).click();
        assertTrue(driver.findElement(By.className("title")).getText().equals("ParaSoft Demo Website"));
        driver.quit();
    }


    @Test
    void logIn() throws InterruptedException {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys("EN0");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("QWERTY");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        assertTrue(driver.findElement(By.className("smallText")).getText().contains("Eno Ibas"));
    }

    @Test
    void registration() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        HomePage homePage = new HomePage();
        homePage.goToRegistrationPage(driver);

        RegistrationPage regPage = new RegistrationPage();
        regPage.fillFields(driver, wait);
        regPage.submitRegistrationForm(driver, wait);

        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome Eno"));
    }
}




