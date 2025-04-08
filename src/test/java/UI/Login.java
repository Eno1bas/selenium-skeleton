package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.Random;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Pages.registrationPage;

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
        registrationPage.register(driver).click();

        Random r = new Random();
        int randomNum = r.nextInt(1000);
        String username = "Eno" + randomNum, password = "QWERTY" + randomNum;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[][] fields = {
                {"customer.firstName", "EN0"},
                {"customer.lastName", "IBAS"},
                {"customer.address.street", "XXXXX"},
                {"customer.address.city", "AAAAA"},
                {"customer.address.state", "BBBBB"},
                {"customer.address.zipCode", "CCCCC"},
                {"customer.phoneNumber", "000000"},
                {"customer.ssn", "000000"},
                {"customer.username", username},
                {"customer.password", password},
                {"repeatedPassword", password}
        };

        for (String[] field : fields) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(field[0]))).sendKeys(field[1]);
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"))).click();

        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome Eno"));
    }
}

//    @Test
//    void registration() throws InterruptedException {
//        driver.get("https://parabank.parasoft.com/parabank/index.htm");
//        driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a")).click();
//
//        Random r = new Random();
//        int randomNum = r.nextInt(1000);
//
//        String username = "Eno" + randomNum;
//        String password = "QWERTY" + randomNum;
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.firstName"))).sendKeys("EN0");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.lastName"))).sendKeys("IBAS");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.address.street"))).sendKeys("XXXXX");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.address.city"))).sendKeys("AAAAA");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.address.state"))).sendKeys("BBBBB");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.address.zipCode"))).sendKeys("CCCCC");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.phoneNumber"))).sendKeys("000000");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.ssn"))).sendKeys("000000");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.username"))).sendKeys(username);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.password"))).sendKeys(password);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("repeatedPassword"))).sendKeys(password);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"))).click();
//
//
//        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome Eno"));
//    }
//}



