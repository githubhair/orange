package leave;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AssignLeavePage;
import pages.DashboardPage;

public class AssignLeavePageTests extends BaseTests {

    @BeforeTest
    public void assignLeave() {
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickAssignLeaveLink();
    }
    @Test
    public void EnterData(){
        AssignLeavePage assignLeave = new AssignLeavePage(driver);
        assignLeave.clickEmployeeNameField("dave t roberts" + Keys.ENTER);
        assignLeave.clickLeaveTypeDropdown("Vacation US" + Keys.TAB);
        assignLeave.enterStartDate("2020-06-16");
        assignLeave.enterToDate( "2020-06-17" + Keys.ENTER);

        Assert.assertEquals(assignLeave.leaveMessageResult(),"Balance not sufficient");

        //Assert.assertEquals(assignLeave.leaveMessageResult(),"View details");

        assignLeave.comment("This is a test");


//        if (assignLeave.leaveMessageResult() == "Balance not sufficient") {
//            System.out.println("Insufficient vacation hours to cover the requested time off");
//        } else if ( assignLeave.leaveMessageResult() == "View details"){
//            System.out.print("Sufficient vacation time is available");
//        }





    }
}
