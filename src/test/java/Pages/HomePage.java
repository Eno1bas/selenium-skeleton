package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {


    public void goToRegistrationPage(WebDriver driver) {

       WebElement element = driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a"));
       element.click();
    }
}
