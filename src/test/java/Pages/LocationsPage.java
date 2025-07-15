package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationsPage {

    public void goToLocationsPage(WebDriver driver){
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[5]/a")).click();
    }
}
