package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmployeeInformationPage extends BasePage {
    By addButton = By.xpath("//*[@id=\"btnAdd\"]");
    By hoverPim = By.id("menu_pim_viewPimModule");
    By addEmployeeText = By.cssSelector("#content > div > div.head > h1");
    //    By employeeListLink = By.id("menu_pim_addEmployee");
//    By ployToWait = By.xpath("//input[@id='empsearch_employee_name_empName']");
//    By searchButton = By.xpath("//*[@id=\"searchBtn\"]");
//    By resetButton = By.xpath("//input[@id='resetBtn']");
//    By addButtonTop = By.xpath("//a[@id='menu_pim_addEmployee']");
//    By reportsLink = By.xpath("//*[@id=\"menu_core_viewDefinedPredefinedReports\"]");
//    By hoverAddUser = By.xpath("//*[@id=\"menu_pim_addEmployee\"]");
    private WebElement selectAdd;

    public EmployeeInformationPage(WebDriver driver) {
        super(driver);
    }

    public void addUser() throws InterruptedException {
        selectAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        driver.findElement(addButton).click();
    }
//    public void timeWait(){
//        try {
//            Thread.sleep(50000);
//            driver.findElement(addButton).click();;
//        } catch (InterruptedException ie) {
//        }
//
//    }

    public String validateAddEmployeeText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addEmployeeText));
        return driver.findElement(addEmployeeText).getText();
    }
}


//        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"btnAdd\"]"));
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        Actions action = new Actions(driver);
//        action.moveToElement(addButton).perform();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(ployToWait)).sendKeys();
//        return new AddEmployee(driver);
//    }
//    public void clickAddButton() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton)).sendKeys();