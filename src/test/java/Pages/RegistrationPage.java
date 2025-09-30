package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegistrationPage extends SharedLogin {

    public void fillFields(WebDriver driver, WebDriverWait wait) {
        Random r = new Random();
        int randomNum = r.nextInt(1000);
        String username = "Eno" + randomNum;
        String password = "QWERTY" + randomNum;

        String[][] fields = {
                {"customer.firstName", "EN0"},
                {"customer.lastName", "IBAS"},
                {"customer.address.street", "LONDON STREET"},
                {"customer.address.city", "LONDON"},
                {"customer.address.state", "ENGLAND"},
                {"customer.address.zipCode", "EC3V000"},
                {"customer.phoneNumber", "02054547632"},
                {"customer.ssn", "000000"},
                {"customer.username", username},
                {"customer.password", password},
                {"repeatedPassword", password}
        };
        for (String[] field : fields) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(field[0]))).sendKeys(field[1]);
        }
    }

    public void submitRegistrationForm(WebDriver driver, WebDriverWait wait) {
        By registerButton = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }
}