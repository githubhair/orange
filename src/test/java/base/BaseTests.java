package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.*;

import static org.testng.Assert.assertEquals;

public class BaseTests {
    private String userId;
    protected String randomlyGeneratedId;
    protected WebDriver driver;

    //Seeding Data - Logs in as Admin and creates employee
    @BeforeClass
    public void baseSetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        System.setProperty("webdriver.chrome.logfile", "resources/chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");

        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(925, 950));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("Admin");
        loginPage.setPassword("admin123");
        DashboardPage dashboard = loginPage.clickLoginButton();
        assertEquals(dashboard.getHeaderText(), "Dashboard");

        //Calls Name Generator to randomly create a guid to be used as user/password
        NewUserPage newUserPage = new NewUserPage();
        String guid = newUserPage.nameGenerator();
        randomlyGeneratedId = guid;

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
        addEmployeePage.createNewUsername(randomlyGeneratedId);
        addEmployeePage.createNewPassword(randomlyGeneratedId);
        addEmployeePage.confirmNewPassword(randomlyGeneratedId);
        addEmployeePage.clickSaveButton();

        AssignLeavePage assignLeave = new AssignLeavePage(driver);
        assignLeave.clickEntitlementsMenu();
        assignLeave.clickAddEntitlementsMenu();
        assignLeave.clickAddEntitilementItem();

        assignLeave.setEntitlementEmployeeNameField(randomlyGeneratedId);
        //assignLeave.clickLeaveTypeDropdown("Vacation US" + Keys.TAB);
        //assignLeave.setEntitlementType(randomlyGeneratedId + Keys.);
        // Types are:
        // Vacation US
        // FMLA US
        // Maternity US
        // Paternity US



//        assignLeave.clickAddEntitlementsMenu();

//        assignLeave.clickLeaveFirstLevelMenu();
//        assignLeave.clickAssignLeaveSubMenuButton();
//        assignLeave.clickEmployeeNameField(randomlyGeneratedId + Keys.ENTER);
//        assignLeave.clickLeaveTypeDropdown("Vacation US" + Keys.TAB);
//        assignLeave.enterStartDate("2020-07-01");
//        assignLeave.enterToDate("2021-07-01" + Keys.ENTER);
//        assignLeave.enterComment("This is a test");
//        dashboard.clickAssignLeaveLink();
    }
}
        //Logout
//        addEmployeePage.clickWelcomeLink();
//        addEmployeePage.clickLogout();

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }



