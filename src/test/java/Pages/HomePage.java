package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public RegistrationPage goToRegistrationPage(WebDriver driver) {
       WebElement element = driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a"));
       element.click();
       return new RegistrationPage();
    }

    public HomePage loadHomePage(WebDriver driver){
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        return new HomePage();
    }

    public AdminPage takeMeToAdminPage(WebDriver driver){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[6]/a")).click();
        return new AdminPage();
    }


    public ServicesPage takeMeToServicePage(WebDriver driver){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[3]/a")).click();
        return null;
    }
}
