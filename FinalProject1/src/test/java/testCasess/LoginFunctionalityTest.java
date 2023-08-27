package testCasess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginFunctionalityPage;

public class LoginFunctionalityTest extends BasePage {
    public static final String LOGO_PATH = "/html/body/div/div/div/div[1]/div[1]/div[2]/div";
    public static final String ACTUAL_DISPLAYED_MESSAGE_PATH = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3";
    private LoginFunctionalityPage loginFunctionalityTest;

    @BeforeClass
    public void setUp() {
        super.setUp();
        loginFunctionalityTest = new LoginFunctionalityPage(driver);
    }

    @BeforeMethod
    public void clearUsernameAndPassword() {
        driver.navigate().refresh();
    }

    @Test
    public void testWithFirstValidUsernameAndPassword() throws InterruptedException {
        loginFunctionalityTest.insertFirstValidUsername();
        loginFunctionalityTest.insertValidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        WebElement Logo = driver.findElement(By.xpath(LOGO_PATH));
        Assert.assertTrue(Logo.isDisplayed());
        loginFunctionalityTest.clickLogoutButton();
    }

    @Test
    public void testWithInvalidUsernameAndValidPassword() {
        loginFunctionalityTest.insertInvalidUsername();
        loginFunctionalityTest.insertValidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithFirstValidUsernameAndInvalidPassword() {
        loginFunctionalityTest.insertFirstValidUsername();
        loginFunctionalityTest.insertInvalidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithInvalidUsernameAndPassword() {
        loginFunctionalityTest.insertInvalidUsername();
        loginFunctionalityTest.insertInvalidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithNoUsernameAndNoPassword() {
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithNoUsernameAndValidPassword() {
        loginFunctionalityTest.insertValidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithNoUsernameAndInvalidPassword() {
        loginFunctionalityTest.insertInvalidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithFirstValidUsernameAndNoPassword() {
        loginFunctionalityTest.insertFirstValidUsername();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithInvalidUsernameAndNoPassword() {
        loginFunctionalityTest.insertInvalidUsername();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithSecondValidUsernameAndValidPassword() {
        loginFunctionalityTest.insertSecondValidUsername();
        loginFunctionalityTest.insertValidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithSecondValidUsernameAndInvalidPassword() {
        loginFunctionalityTest.insertSecondValidUsername();
        loginFunctionalityTest.insertInvalidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithSecondValidUsernameAndNoPassword() {
        loginFunctionalityTest.insertSecondValidUsername();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithThirdValidUsernameAndValidPassword() throws InterruptedException {
        loginFunctionalityTest.insertThirdValidUsername();
        loginFunctionalityTest.insertValidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        WebElement Logo = driver.findElement(By.xpath(LOGO_PATH));
        Assert.assertTrue(Logo.isDisplayed());
        loginFunctionalityTest.clickLogoutButton();
    }

    @Test
    public void testWithThirdValidUsernameAndInvalidPassword() {
        loginFunctionalityTest.insertThirdValidUsername();
        loginFunctionalityTest.insertInvalidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithThirdValidUsernameAndNoPassword() {
        loginFunctionalityTest.insertThirdValidUsername();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithFourthValidUsernameAndValidPassword() throws InterruptedException {
        loginFunctionalityTest.insertFourthValidUsername();
        loginFunctionalityTest.insertValidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        WebElement Logo = driver.findElement(By.xpath(LOGO_PATH));
        Assert.assertTrue(Logo.isDisplayed());
        loginFunctionalityTest.clickLogoutButton();
    }

    @Test
    public void testWithFourthValidUsernameAndInvalidPassword() {
        loginFunctionalityTest.insertFourthValidUsername();
        loginFunctionalityTest.insertInvalidPassword();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }

    @Test
    public void testWithFourthValidUsernameAndNoPassword() {
        loginFunctionalityTest.insertFourthValidUsername();
        loginFunctionalityTest.clickOnTheLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
    }
}