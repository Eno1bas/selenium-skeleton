package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends SharedLogin {
    private SharedNavigation navigation = new SharedNavigation();

    public SharedNavigation.AdminPage goToAdminPage(WebDriver driver) {
        return navigation.goToAdminPage(driver);
    }

    public SharedNavigation.ServicesPage goToServicePage(WebDriver driver) {
        return navigation.goToServicePage(driver);
    }

    public SharedNavigation.LocationsPage goToLocationPage(WebDriver driver) {
        return navigation.goToLocationPage(driver);
    }

    public SharedNavigation.ProductsPage goToProductPage(WebDriver driver) {
        return navigation.goToProductPage(driver);
    }
}