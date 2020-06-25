package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By usernameField = By.xpath("//input[@id='txtUsername']");
    private final By passwordField = By.xpath("//input[@id='txtPassword']");
    private final By loginButton = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }
    public void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }
}


//public class LoginPage {
//
//    private WebDriver driver;
//    private By usernameField = By.id("username");
//    private By passwordField = By.id("password");
//    private By loginButton = By.cssSelector("#login button");
//
//    public LoginPage(WebDriver driver){
//        this.driver = driver;
//    }
//
//    public void setUsername(String username){
//        driver.findElement(usernameField).sendKeys(username);
//    }
//
//    public void setPassword(String password){
//        driver.findElement(passwordField).sendKeys(password);
//    }
//
//    public SecureAreaPage clickLoginButton(){
//        driver.findElement(loginButton).click();
//        return new SecureAreaPage(driver);
//


//
//    @Test
//    public void testSuccessfulLogin(){
//        LoginPage loginPage =  homePage.clickFormAuthentication();
//        loginPage.setUsername("tomsmith");
//        loginPage.setPassword("SuperSecretPassword!");
//        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
//        assertTrue(secureAreaPage.getAlertText()
//                        .contains("You logged into a secure area!"),
//                "Alert text is incorrect");
//    }
//}



