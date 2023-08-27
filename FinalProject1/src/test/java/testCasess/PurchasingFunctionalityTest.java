package testCasess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PurchasingFunctionalityPage;


public class PurchasingFunctionalityTest extends BasePage {
    public static final String ACTUAL_DISPLAYED_MESSAGE_PATH = "/html/body/div/div/div/div[2]/div/form/div[1]/div[4]";
    private PurchasingFunctionalityPage purchasingFunctionalityTest;

    @BeforeClass
    public void setUp() {
        super.setUp();
        purchasingFunctionalityTest = new PurchasingFunctionalityPage(driver);
        purchasingFunctionalityTest.insertFirstValidUsername();
        purchasingFunctionalityTest.insertValidPassword();
        purchasingFunctionalityTest.clickOnTheLoginButton();
        purchasingFunctionalityTest.clickOnAddToCart();
        purchasingFunctionalityTest.clickOnTheShoppingCart();
        purchasingFunctionalityTest.clickOnCheckout();
    }

    @Test
    public void testWithAnValidFirstNameNoLastNameNoPostalCode() {
        purchasingFunctionalityTest.insertFirstName();
        purchasingFunctionalityTest.clickOnContinue();
        String expectedErrorMessage = "Error: Last Name is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
        driver.navigate().refresh();
    }

    @Test
    public void testWithAnValidFirstNameValidLastNameNoPostalCode() {
        purchasingFunctionalityTest.insertFirstName();
        purchasingFunctionalityTest.insertLastNme();
        purchasingFunctionalityTest.clickOnContinue();
        String expectedErrorMessage = "Error: Postal Code is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
        driver.navigate().refresh();
    }

    @Test
    public void testWithNoFirstNameValidLastNameNoPostalCode() {
        purchasingFunctionalityTest.insertLastNme();
        purchasingFunctionalityTest.clickOnContinue();
        String expectedErrorMessage = "Error: First Name is required";
        String actualErrorMessage = driver.findElement(By.xpath(ACTUAL_DISPLAYED_MESSAGE_PATH)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
        driver.navigate().refresh();
    }

    @Test
    public void testWithValidFirstNmeValidLastNameValidPostalCode() {
        purchasingFunctionalityTest.insertFirstName();
        purchasingFunctionalityTest.insertLastNme();
        purchasingFunctionalityTest.insertPostalCode();
        purchasingFunctionalityTest.clickOnContinue();
        WebElement checkoutOverview = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        Assert.assertTrue(checkoutOverview.isDisplayed());
        driver.navigate().back();
    }

    @Test
    public void testFinishingAnOrder() {
        purchasingFunctionalityTest.insertFirstName();
        purchasingFunctionalityTest.insertLastNme();
        purchasingFunctionalityTest.insertPostalCode();
        purchasingFunctionalityTest.clickOnContinue();
        purchasingFunctionalityTest.clickOnFinishButton();
        String expectedMessage = "Thank you for your order!";
        String actualMessage = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "thank you message is displayed");
        WebElement backhome = driver.findElement(By.id("back-to-products"));
        backhome.click();
        purchasingFunctionalityTest.clickOnTheShoppingCart();
        purchasingFunctionalityTest.clickOnCheckout();
    }
}
