package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignLeavePage extends BasePage{

    By employeeNameField = By.xpath("//input[@id='assignleave_txtEmployee_empName']");
    By leaveTypeDropdown = By.id("assignleave_txtLeaveType");
    By fromDateLeave = By.id("assignleave_txtFromDate");
    By toDateLeave = By.id("assignleave_txtToDate");
    By messageResult = By.xpath("//*[@id=\"leaveBalance_details_link\"]");
    By commentArea = By.xpath("//textarea[@id='assignleave_txtComment']");
    By assignButton = By.id("assignBtn");

    public AssignLeavePage(WebDriver driver){super(driver); }

    public void clickEmployeeNameField(String name){
        driver.findElement(employeeNameField).sendKeys(name);

    }
    public void clickLeaveTypeDropdown(String type){
        driver.findElement(leaveTypeDropdown).sendKeys(type);
    }
    public void enterStartDate(String startDate){
        driver.findElement(fromDateLeave).clear();
        driver.findElement(fromDateLeave).sendKeys(startDate);
    }
    public void enterToDate(String endDate) {
        driver.findElement(toDateLeave).clear();
        driver.findElement(toDateLeave).sendKeys(endDate);
    }
    public String leaveMessageResult(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageResult));
        return driver.findElement(messageResult).getText();
    }
    public void comment(String text) {
        driver.findElement(commentArea).sendKeys(text);
    }
    //public void
}
