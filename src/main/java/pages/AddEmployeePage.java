package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddEmployeePage extends BasePage {
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By addEmployeeText = By.cssSelector("#content > div > div.head > h1");
    By saveNewEmployee = By.id("btnSave");
    By employeeId = By.xpath("//input[@id='employeeId']");
    By searchEmployeeButton = By.id("searchBtn");
    By searchIdField = By.id("empsearch_id");
    By idCheckbox = By.id("ohrmList_chkSelectAll");
    By validateUserId = By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a");
    By welcomeLink = By.id("welcome");
    By logoutButton = By.xpath("//a[.='Logout']");
    By loginCredentialsCheckbox = By.id("chkLogin");
    By createUsername = By.id("user_name");
    By createPassword = By.id("user_password");
    By confirmPassword = By.id("re_password");


    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public String validateAddEmployeePageText() {
        return driver.findElement(addEmployeeText).getText();
    }

    public void enterFirstName(String first) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys(first);
    }

    public void enterLastName(String last) {
        driver.findElement(lastName).sendKeys(last);
    }

    public void clickLoginCredentialsCheckbox() {
        driver.findElement(loginCredentialsCheckbox).click();
    }

    public void createNewUsername(String newUsername) {
        driver.findElement(createUsername).sendKeys(newUsername);
    }

    public void createNewPassword(String newPassword) {
        driver.findElement(createPassword).sendKeys(newPassword);
    }

    public void confirmNewPassword(String confirmNewPassword) {
        driver.findElement(confirmPassword).sendKeys(confirmNewPassword);
    }

    public String getEmployeeId() {
        return driver.findElement(employeeId).getAttribute("value");

    }

    public void clickSaveButton() {
        driver.findElement(saveNewEmployee).click();
    }


    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmployeeButton));
        driver.findElement(searchEmployeeButton).click();
    }

    public void clickIdCheckbox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(idCheckbox));
        driver.findElement(idCheckbox).click();
    }

    public String getUserIdText() {
        return driver.findElement(validateUserId).getText();
    }

    public void enterUserId(String id) {
        driver.findElement(searchIdField).sendKeys(id);
    }

    public void clickWelcomeLink() throws InterruptedException {
            Thread.sleep(1000);
            driver.findElement(welcomeLink).click();

        }

    public LoginPage clickLogout() throws InterruptedException {
            Thread.sleep(1000);
            driver.findElement(logoutButton).click();
            return new LoginPage(driver);

    }
}
