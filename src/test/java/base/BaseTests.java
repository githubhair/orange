package base;

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
        loginPage.setUsername("danadmin");
        loginPage.setPassword("password1");
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

        //Logout
        addEmployeePage.clickWelcomeLink();
        addEmployeePage.clickLogout();
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }

}
