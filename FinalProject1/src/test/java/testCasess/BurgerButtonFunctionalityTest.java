package testCasess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BurgerButtonFunctionalityPage;


public class BurgerButtonFunctionalityTest extends BasePage {
    private BurgerButtonFunctionalityPage burgerButtonFunctionalityTest;

    @BeforeClass
    public void setUp() {
        super.setUp();
        burgerButtonFunctionalityTest = new BurgerButtonFunctionalityPage(driver);
        burgerButtonFunctionalityTest.insertFirstValidUsername();
        burgerButtonFunctionalityTest.insertValidPassword();
        burgerButtonFunctionalityTest.clickOnTheLoginButton();
    }

    @BeforeMethod
    public void goToHomePage() {
        driver.navigate().refresh();
    }

    @Test
    public void checkIfTheBurgerButtonIsDisplayed() {
        WebElement burgerButton = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(burgerButton.isDisplayed());
    }

    @Test
    public void checkTheFunctionalityOfTheBurgerButton() throws InterruptedException {
        burgerButtonFunctionalityTest.clickOnTheBurgerButton();
        Thread.sleep(500);
        WebElement firstItemOnTheBurgerButtonMenu = driver.findElement(By.id("inventory_sidebar_link"));
        Assert.assertTrue(firstItemOnTheBurgerButtonMenu.isDisplayed());
        WebElement secondItemOnTheBurgerButtonMenu = driver.findElement(By.id("about_sidebar_link"));
        Assert.assertTrue(secondItemOnTheBurgerButtonMenu.isDisplayed());
        WebElement thirdItemInTheBurgerButtonMenu = driver.findElement(By.id("logout_sidebar_link"));
        Assert.assertTrue(thirdItemInTheBurgerButtonMenu.isDisplayed());
        WebElement fourthItemInTheBurgerButtonMenu = driver.findElement(By.id("reset_sidebar_link"));
        Assert.assertTrue(fourthItemInTheBurgerButtonMenu.isDisplayed());
    }

    @Test
    public void checkTheFunctionalityOfTheFirstItemInTheBurgerButtonMenu() throws InterruptedException {
        burgerButtonFunctionalityTest.clickOnTheBurgerButton();
        Thread.sleep(500);
        burgerButtonFunctionalityTest.clickOnFirstItemInTheBurgerButtonMenu();
        WebElement firstProduct = driver.findElement(By.id("item_4_title_link"));
        Assert.assertTrue(firstProduct.isDisplayed());
        WebElement lastProduct = driver.findElement(By.id("item_3_title_link"));
        Assert.assertTrue(lastProduct.isDisplayed());
    }

    @Test
    public void checkTheFunctionalityOfTheSecondItemInTheBurgerButtonMenu() throws InterruptedException {
        burgerButtonFunctionalityTest.clickOnTheBurgerButton();
        Thread.sleep(500);
        burgerButtonFunctionalityTest.clickOnSecondItemInTheBurgerButtonMenu();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe("https://saucelabs.com/"));
        if (driver.getCurrentUrl().equals("https://saucelabs.com/")) {
            System.out.println("Redirect successful.");
        } else {
            System.out.println("Redirect failed.");
        }
        driver.navigate().back();
    }


    @Test
    public void checkTheFunctionalityOfTheThirdItemInTheBurgerButtonMenu() throws InterruptedException {
        burgerButtonFunctionalityTest.clickOnTheBurgerButton();
        Thread.sleep(500);
        burgerButtonFunctionalityTest.clickOnThirdItemInTheBurgerButtonMenu();
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @Test
    public void checkTheFunctionalityOfTheFourthItemInTheBurgerButtonMenu() throws InterruptedException {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        burgerButtonFunctionalityTest.clickOnTheBurgerButton();
        Thread.sleep(500);
        burgerButtonFunctionalityTest.clickOnFourthItemInTheBurgerButtonMenu();
        driver.navigate().refresh();
        Thread.sleep(500);
        addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        String addToCartButtonText = addToCartButton.getText();
        if (addToCartButtonText.equals("Add to cart")) {
            System.out.println("Fourth item in the burger button menu is working");
        } else {
            System.out.println("Fourth item in the burger button menu is not working");
        }
    }
}
