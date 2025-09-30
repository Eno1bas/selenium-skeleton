package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SharedNavigation {

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
        driver.navigate().back();
        return new LocationsPage();
    }

    public ProductsPage goToProductPage(WebDriver driver) {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[4]/a")).click();
        driver.navigate().back();
        return new ProductsPage();
    }

    public class AdminPage {
    }

    public class ServicesPage {
    }

    public class LocationsPage {
    }

    public class ProductsPage {
    }
}