package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class aboutUsPage {

    public boolean goToAboutUsPage(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id='headerPanel']/ul[1]/li[2]/a")).click();
        String titleText = driver.findElement(By.className("title")).getText();
        return titleText.equals("ParaSoft Demo Website");
    }
}
