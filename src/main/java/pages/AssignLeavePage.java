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
    By leaveFirstLevelMenu = By.xpath("//b[.='Leave']");
    By assignLeaveButton = By.id("menu_leave_assignLeave");
    By entitlementsMenu = By.xpath("//b[.='Leave']");
    By addEntitlementsMenu = By.id("menu_leave_Entitlements");
    By entitlementItem = By.xpath("//a[@id='menu_leave_addLeaveEntitlement']");
    By addEmployeeNameEntitlement = By.id("entitlements_employee_empName");
    By entitlementType = By.id("entitlements_leave_type");
    By entitlementPeriod = By.id("period");
    By entitlementBulkAssignCheckbox = By.id("entitlements_filters_bulk_assign");
    By entitlementHours = By.id("entitlements[entitlement]");

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
    public void enterComment(String text) {
        driver.findElement(commentArea).sendKeys(text);
    }
    public void clickEntitlementsMenu() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(entitlementsMenu).click();
    }
    public void clickAddEntitlementsMenu() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(addEntitlementsMenu).click();
    }
    public void clickAddEntitilementItem() {
        driver.findElement(entitlementItem).click();
    }
    public void clickBulkEntitlementCheckBox(){
        driver.findElement(entitlementBulkAssignCheckbox);

    }
    public void setBulkEntitlementHours(String hours){
        driver.findElement(entitlementHours).sendKeys(hours);
    }

    public String leaveMessageResult(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageResult));
        return driver.findElement(messageResult).getText();
    }
}
