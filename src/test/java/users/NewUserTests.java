package users;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;

public class NewUserTests extends BaseTests {

    //Validates Employee login
    @Test
    public void ValidateEmployeeLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(randomlyGeneratedId);
        loginPage.setPassword(randomlyGeneratedId);
        loginPage.clickLoginButton();

    }
}
//            DashboardPage dashboard = new DashboardPage(driver);
//            assertEquals(dashboard.getHeaderText(), "Dashboard");

//            AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
//            addEmployeePage.clickWelcomeLink();
//            addEmployeePage.clickLogout();


//    @AfterTest
//    public void testCleanup() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.setUsername("Admin");
//        loginPage.setPassword("admin123");
//        DashboardPage dashboard = loginPage.clickLoginButton();
//        dashboard.clickPIMLink();
//        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
//        addEmployeePage.clickSearchButton();
//        addEmployeePage.enterUserId(usernamePasswordId);
//        addEmployeePage.clickIdCheckbox();
//        DeleteEmployeePage deleteEmployeePage = new DeleteEmployeePage(driver);
//        deleteEmployeePage.clickDeleteButton();
//        deleteEmployeePage.clickConfirmDeleteOk();
//
//        dashboard.clickPIMLink();
//        addEmployeePage.clickWelcomeLink();
//        addEmployeePage.clickLogout();
//    }
//}
