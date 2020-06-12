package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import pages.DashboardPage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class BaseTests {

    protected WebDriver driver;

    @BeforeTest
    public void baseSetup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        System.setProperty("webdriver.chrome.logfile", "resources/chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");

        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(925, 950));
    }
    @BeforeTest
    public void testLoginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("Admin");
        loginPage.setPassword("admin123");
        DashboardPage dashboard = loginPage.clickLoginButton();
        assertEquals(dashboard.getHeaderText(), "Dashboard");
    }

//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }

}
