package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productsPage {

    public static void product(WebDriver driver){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[3]/a")).click();
    }
}
