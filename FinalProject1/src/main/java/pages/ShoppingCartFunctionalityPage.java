package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartFunctionalityPage extends BasePage{
    public ShoppingCartFunctionalityPage(WebDriver driver) {super(driver);}

    By usernameBox = By.id("user-name");
    public void insertFirstValidUsername(){
        driver.findElement(usernameBox).sendKeys("standard_user");
    }

    By passwordBox = By.id("password");
    public void insertValidPassword(){
        driver.findElement(passwordBox).sendKeys("secret_sauce");}

    By loginButton = By.id("login-button");
    public void clickOnTheLoginButton(){
        driver.findElement(loginButton).click();
    }

    By shoppingCart = By.id("shopping_cart_container");
    public void clickOnTheShoppingCart(){driver.findElement(shoppingCart).click();}

    By continueShopping = By.id("continue-shopping");
    public void clickOnContinueShopping(){driver.findElement(continueShopping).click();}

    By remove = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/button");
    public void clickOnRemove(){driver.findElement(remove).click();}

    By checkout = By.id("checkout");
    public void clickOnCheckout(){driver.findElement(checkout).click();}






}
