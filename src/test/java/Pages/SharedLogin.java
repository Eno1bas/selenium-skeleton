package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SharedLogin {

    public HomePage loadHomePage(WebDriver driver) {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        return new HomePage();
    }

    public RegistrationPage goToRegistrationPage(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a"));
        element.click();
        return new RegistrationPage();
    }
}
