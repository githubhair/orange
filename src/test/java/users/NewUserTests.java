package users;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeeInformationPage;
import pages.DashboardPage;
import pages.NewUserPage;

public class NewUserTests extends BaseTests {
    @Test
    public void getNewName() {
        //Generates a guid to be used for a new name
        NewUserPage newUserPage = new NewUserPage();
        String name = newUserPage.nameGenerator();

        //Select the PIM link
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickPIMLink();
    }
    @Test
    public void hoverAndClick() throws InterruptedException {
        EmployeeInformationPage addEmployee = new EmployeeInformationPage(driver);
        addEmployee.addUser();
        Assert.assertEquals(addEmployee.validateAddEmployeeText(), "Add Employee");

    }
}
//}

//        Enter First and last names.
//        addEmployee.enterFirstName(name);
//        addEmployee.enterLastName(name);

//    }
//    @Test
//     public void useName() {
//
//
//    }
//    @AfterTest
//    public void testCleanup(){