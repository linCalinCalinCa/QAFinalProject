package testCasess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginFunctionalityPage;
import pages.ShoppingCartFunctionalityPage;

public class ShoppingCartFunctionalityTest extends BasePage {
    private ShoppingCartFunctionalityPage shoppingCartFunctionalityTest;

    @BeforeClass
    public void setUp() {
        super.setUp();
        shoppingCartFunctionalityTest = new ShoppingCartFunctionalityPage(driver);
        shoppingCartFunctionalityTest.insertFirstValidUsername();
        shoppingCartFunctionalityTest.insertValidPassword();
        shoppingCartFunctionalityTest.clickOnTheLoginButton();
    }

    @Test
    public void checkIfTheShoppingCartButtonIsDisplayed(){
        WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(shoppingCart.isDisplayed());
    }

    @Test
    public void checkTheFunctionalityOfTheShoppingCartButton(){
        shoppingCartFunctionalityTest.clickOnTheShoppingCart();
        WebElement yourCart = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        Assert.assertTrue(yourCart.isDisplayed());
        driver.navigate().back();
    }

    @Test
    public void checkTheFunctionalityOfTheShoppingCart(){
        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();
        shoppingCartFunctionalityTest.clickOnTheShoppingCart();
        WebElement firstItemInTheShoppingCart = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]"));
        Assert.assertTrue(firstItemInTheShoppingCart.isDisplayed());
        driver.navigate().back();
        WebElement removeProduct = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeProduct.click();
    }

    @Test
    public void checkTheFunctionalityOfContinueShoppingButtonFromCart(){
        shoppingCartFunctionalityTest.clickOnTheShoppingCart();
        shoppingCartFunctionalityTest.clickOnContinueShopping();
        WebElement products = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        Assert.assertTrue(products.isDisplayed());
    }

    @Test
    public void checkTheFunctionalityOfTheRemoveButtonFromCart(){
        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();
        shoppingCartFunctionalityTest.clickOnTheShoppingCart();
        shoppingCartFunctionalityTest.clickOnRemove();
        WebElement firstItemInTheShoppingCart = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]"));
        Assert.assertFalse(firstItemInTheShoppingCart.isDisplayed());
        driver.navigate().back();
    }

    @Test
    public void checkTheFunctionalityOfTheCheckoutButtonFromCart(){
        shoppingCartFunctionalityTest.clickOnTheShoppingCart();
        shoppingCartFunctionalityTest.clickOnCheckout();
        WebElement checkoutYourInformations  = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        Assert.assertTrue(checkoutYourInformations.isDisplayed());
        driver.navigate().back();
        driver.navigate().back();
    }

}
