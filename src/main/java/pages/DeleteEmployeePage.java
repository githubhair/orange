package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteEmployeePage extends BasePage {

    By deleteButton = By.xpath("//input[@id='btnDelete']");
    By confirmDeleteOk = By.id("dialogDeleteBtn");

    public DeleteEmployeePage(WebDriver driver) {
        super(driver);
    }


    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();

    }

    public void clickConfirmDeleteOk() {
        driver.findElement(confirmDeleteOk).click();
    }
}
