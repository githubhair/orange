package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddUserSubPage extends BasePage{
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");


    public void enterFirstName(String first) {

        wait.until((ExpectedConditions.elementToBeClickable(firstName)));
        driver.findElement(firstName).sendKeys(first);
    }
    public void enterLastName(String last){
        wait.until(ExpectedConditions.elementToBeClickable(lastName));
        driver.findElement(lastName).sendKeys(last);
    }
}
