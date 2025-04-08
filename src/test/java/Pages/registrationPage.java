package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registrationPage {

    public static WebElement register(WebDriver driver) {

       WebElement element = driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a"));
       return element;
    }
}
