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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void registration() throws InterruptedException {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a")).click();

        Random r = new Random();
        int randomNum = r.nextInt(1000);

        String username = "Eno" + randomNum;
        String password = "QWERTY" + randomNum;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.firstName"))).sendKeys("EN0");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.lastName"))).sendKeys("IBAS");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.address.street"))).sendKeys("XXXXX");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.address.city"))).sendKeys("AAAAA");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.address.state"))).sendKeys("BBBBB");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.address.zipCode"))).sendKeys("CCCCC");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.phoneNumber"))).sendKeys("000000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.ssn"))).sendKeys("000000");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.username"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.password"))).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("repeatedPassword"))).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"))).click();



        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        driver.findElement(By.className("colspan")).click();

        WebElement logOutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Log Out']")));

        String pageTitle = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[8]/a")).getAttribute("Log Out");
        assertTrue(pageTitle.contains("Log Out"), "Registration failed, expected welcome message missing.");
    }



}
//
//    @Test
//    Void services()throws InterruptedException{
//        driver.get("https://parabank.parasoft.com/parabank/index.htm");
//        driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[1]/li[3]/a")).click();
//        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/table[2]/tbody/tr[2]/td[1]"));
//        new Actions(driver).scrollToElement(iframe).perform();
//        assertTrue(driver.getTitle());
//    }




