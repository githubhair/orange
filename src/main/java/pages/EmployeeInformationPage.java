package pages;

import org.openqa.selenium.*;

public class EmployeeInformationPage extends BasePage {
    By addButton = By.id("btnAdd");
    By hoverPim = By.id("menu_pim_viewPimModule");
    By employeeId = By.id("personal_txtEmployeeId");

    private WebElement selectAdd;

    public EmployeeInformationPage(WebDriver driver) {
        super(driver);
    }

    public void addUser() throws InterruptedException {

    }
    public AddEmployeePage clickAddEmployeeButton(){
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException ie) {}
        driver.findElement(addButton).click();
        return new AddEmployeePage(driver);

    }
}