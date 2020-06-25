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
    private String userId;
    private String usernamePasswordId;

    //Creates New Employee
    @Test
    public void getNewName() throws InterruptedException {
        //Generates a guid to be used for a new name
        NewUserPage newUserPage = new NewUserPage();
        String guid = newUserPage.nameGenerator();
        usernamePasswordId = guid;

        //Select the PIM link
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickPIMLink();

        EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(driver);

        //Wait, then click Add button
        AddEmployeePage addEmployeePage = employeeInformationPage.clickAddEmployeeButton();

        //Enter the first and last name fields
        addEmployeePage.enterFirstName(guid);
        addEmployeePage.enterLastName(guid);


        //String uniqueId = addEmployeePage.getEmployeeId();
        //System.out.print(uniqueId);
        //userId = uniqueId;

        //Creates credentialed user
        addEmployeePage.clickLoginCredentialsCheckbox();
        addEmployeePage.createNewUsername(usernamePasswordId);
        addEmployeePage.createNewPassword(usernamePasswordId);
        addEmployeePage.confirmNewPassword(usernamePasswordId);
        addEmployeePage.clickSaveButton();
        addEmployeePage.clickWelcomeLink();
        addEmployeePage.clickLogout();
    }

    //Validates the newly created user can login
        @Test
        public void ValidateEmployeeLogin() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsername(usernamePasswordId);
            loginPage.setPassword(usernamePasswordId);
            loginPage.clickLoginButton();
            DashboardPage dashboard = new DashboardPage(driver);
            assertEquals(dashboard.getHeaderText(), "Dashboard");

            EmployeeInformationPage employeeInformationPage = new EmployeeInformationPage(driver);
            AddEmployeePage addEmployeePage = employeeInformationPage.clickAddEmployeeButton();
            addEmployeePage.clickWelcomeLink();
            addEmployeePage.clickLogout();
        }

}

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
