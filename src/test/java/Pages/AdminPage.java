package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    public AdminPage goToAdminPage(WebDriver driver){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[6]/a")).click();
        return new AdminPage();
    }
}
