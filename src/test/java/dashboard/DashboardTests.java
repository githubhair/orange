package dashboard;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class DashboardTests extends BaseTests {

    @Test
    public void clickAssignLeave(){
        DashboardPage assignLeave = new DashboardPage(driver);
        assignLeave.clickAssignLeaveLink();
    }
    @Test
    public void clickLeaveList(){
        DashboardPage leaveList = new DashboardPage(driver);
        leaveList.clickLeaveListLink();
    }
    @Test
    public void clickTimesheets(){
        DashboardPage timesheets = new DashboardPage(driver);
        timesheets.clickTimesheetsLink();
    }

}
