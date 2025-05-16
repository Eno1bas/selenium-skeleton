package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public boolean goToAboutUsPage(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id='headerPanel']/ul[1]/li[2]/a")).click();
        String titleText = driver.findElement(By.className("title")).getText();
        return titleText.equals("ParaSoft Demo Website");
    }

    public RegistrationPage goToRegistrationPage(WebDriver driver) {
       WebElement element = driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a"));
       element.click();
       return new RegistrationPage();
    }

    public HomePage loadHomePage(WebDriver driver){
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        return new HomePage();
    }
}
