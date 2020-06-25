package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage{

    private final By loginButton = By.id("btnLogin");
    private By headerText = By.xpath("//h1[.='Dashboard']");
    private By assignLeaveLink = By.xpath("//img[@src='/webres_5ebd1457b45137.49759927/orangehrmLeavePlugin/images/ApplyLeave.png']");
    private By leaveListLink = By.xpath("//img[@src='/webres_5ebd1457b45137.49759927/orangehrmLeavePlugin/images/MyLeave.png']");
    private By timesheetsLink = By.xpath("//img[@src='/webres_5ebd1457b45137.49759927/orangehrmTimePlugin/images/MyTimesheet.png']");
    private final By pimLink = By.id("menu_pim_viewPimModule");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }
    public AssignLeavePage clickAssignLeaveLink() {
        driver.findElement(assignLeaveLink).click();
        return new AssignLeavePage(driver);
    }
    public TimesheetsPage clickTimesheetsLink(){
        driver.findElement(timesheetsLink).click();
        return new TimesheetsPage(driver);
    }
    public LeaveListPage clickLeaveListLink(){
        driver.findElement(leaveListLink).click();
        return new LeaveListPage(driver);
    }
    public EmployeeInformationPage clickPIMLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimLink));
        driver.findElement(pimLink).click();
        return new EmployeeInformationPage(driver);
    }
}