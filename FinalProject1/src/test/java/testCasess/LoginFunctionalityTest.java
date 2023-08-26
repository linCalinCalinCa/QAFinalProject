package testCasess;

import pages.BasePage;
import pages.LoginFunctionalityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFunctionalityTest extends BasePage {
    private LoginFunctionalityPage loginFunctionalityTests;

    @BeforeClass
    public void setUp() {
        super.setUp();
        loginFunctionalityTests = new LoginFunctionalityPage(driver);
    }

    @BeforeMethod
    public void clearUsernameAndPassword(){
        driver.navigate().refresh();
    }

    @Test
    public void testWithFirstValidUsernameAndPassword() throws InterruptedException {
        loginFunctionalityTests.insertFirstValidUsername();
        loginFunctionalityTests.insertValidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        WebElement Logo = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div"));
        Assert.assertTrue(Logo.isDisplayed());
        loginFunctionalityTests.clickLogoutButton();
    }

    @Test
    public void testWithInvalidUsernameAndValidPassword() {
        loginFunctionalityTests.insertInvalidUsername();
        loginFunctionalityTests.insertValidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithFirstValidUsernameAndInvalidPassword() {
        loginFunctionalityTests.insertFirstValidUsername();
        loginFunctionalityTests.insertInvalidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithInvalidUsernameAndPassword() {
        loginFunctionalityTests.insertInvalidUsername();
        loginFunctionalityTests.insertInvalidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithNoUsernameAndNoPassword(){
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithNoUsernameAndValidPassword(){
        loginFunctionalityTests.insertValidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithNoUsernameAndInvalidPassword(){
        loginFunctionalityTests.insertInvalidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithFirstValidUsernameAndNoPassword(){
        loginFunctionalityTests.insertFirstValidUsername();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithInvalidUsernameAndNoPassword(){
        loginFunctionalityTests.insertInvalidUsername();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithSecondValidUsernameAndValidPassword()  {
        loginFunctionalityTests.insertSecondValidUsername();
        loginFunctionalityTests.insertValidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithSecondValidUsernameAndInvalidPassword()  {
        loginFunctionalityTests.insertSecondValidUsername();
        loginFunctionalityTests.insertInvalidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithSecondValidUsernameAndNoPassword(){
        loginFunctionalityTests.insertSecondValidUsername();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithThirdValidUsernameAndValidPassword() throws InterruptedException {
        loginFunctionalityTests.insertThirdValidUsername();
        loginFunctionalityTests.insertValidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        WebElement Logo = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div"));
        Assert.assertTrue(Logo.isDisplayed());
        loginFunctionalityTests.clickLogoutButton();
    }

    @Test
    public void testWithThirdValidUsernameAndInvalidPassword() {
        loginFunctionalityTests.insertThirdValidUsername();
        loginFunctionalityTests.insertInvalidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithThirdValidUsernameAndNoPassword(){
        loginFunctionalityTests.insertThirdValidUsername();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithFourthValidUsernameAndValidPassword() throws InterruptedException {
        loginFunctionalityTests.insertFourthValidUsername();
        loginFunctionalityTests.insertValidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        WebElement Logo = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div"));
        Assert.assertTrue(Logo.isDisplayed());
        loginFunctionalityTests.clickLogoutButton();
    }

    @Test
    public void testWithFourthValidUsernameAndInvalidPassword()  {
        loginFunctionalityTests.insertFourthValidUsername();
        loginFunctionalityTests.insertInvalidPassword();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithFourthValidUsernameAndNoPassword(){
        loginFunctionalityTests.insertFourthValidUsername();
        loginFunctionalityTests.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

}
