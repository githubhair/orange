package leave;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AssignLeavePage;
import pages.DashboardPage;

public class AssignLeavePageTests extends BaseTests {

    @Test
    public void EnterData() {
        AssignLeavePage assignLeavePage = new AssignLeavePage(driver);
        //Assert.assertEquals(assignLeavePage.leaveMessageResult(), "Balance not sufficient");

        //Assert.assertEquals(assignLeavePage.leaveMessageResult(), "View details");

        //assignLeavePage.enterComment("This is a test");
    }
}


//        if (assignLeave.leaveMessageResult() == "Balance not sufficient") {
//            System.out.println("Insufficient vacation hours to cover the requested time off");
//        } else if ( assignLeave.leaveMessageResult() == "View details"){
//            System.out.print("Sufficient vacation time is available");