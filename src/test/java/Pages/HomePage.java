package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public HomePage loadHomePage(WebDriver driver) {
        driver.get("https://para.testar.org/parabank/index.htm");
        return new HomePage();
    }

    public RegistrationPage goToRegistrationPage(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a"));
        element.click();
        return new RegistrationPage();
    }

    public AdminPage goToAdminPage(WebDriver driver) {
        driver.findElement(By.linkText("Admin Page")).click();
        return new AdminPage();
    }

    public ServicesPage goToServicePage(WebDriver driver) {
        driver.findElement(By.linkText("Services")).click();
        return new ServicesPage();
    }

    public LocationsPage goToLocationPage(WebDriver driver) {
        driver.findElement(By.linkText("Locations")).click();
        return new LocationsPage();
    }

    public ProductsPage goToProductPage(WebDriver driver) {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[4]/a")).click();
        return new ProductsPage();
    }
}
