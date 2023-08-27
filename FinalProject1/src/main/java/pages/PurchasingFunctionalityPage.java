package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasingFunctionalityPage extends BasePage {
    public PurchasingFunctionalityPage(WebDriver driver) {
        super(driver);
    }

    By usernameBox = By.id("user-name");
    public void insertFirstValidUsername() {
        driver.findElement(usernameBox).sendKeys("standard_user");
    }

    By passwordBox = By.id("password");
    public void insertValidPassword() {
        driver.findElement(passwordBox).sendKeys("secret_sauce");
    }

    By loginButton = By.id("login-button");
    public void clickOnTheLoginButton() {
        driver.findElement(loginButton).click();
    }

    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    public void clickOnAddToCart() {
        driver.findElement(addToCart).click();
    }

    By shoppingCart = By.id("shopping_cart_container");
    public void clickOnTheShoppingCart() {
        driver.findElement(shoppingCart).click();
    }

    By checkout = By.id("checkout");
    public void clickOnCheckout() {
        driver.findElement(checkout).click();
    }

    By continuue = By.id("continue");
    public void clickOnContinue() {
        driver.findElement(continuue).click();
    }

    By firstNameBox = By.id("first-name");
    public void insertFirstName() {
        driver.findElement(firstNameBox).sendKeys("UserFirstNme");
    }

    By lastNme = By.id("last-name");
    public void insertLastNme() {
        driver.findElement(lastNme).sendKeys("UserLastName");
    }

    By postalCode = By.id("postal-code");
    public void insertPostalCode() {
        driver.findElement(postalCode).sendKeys("121212");
    }

    By finish = By.id("finish");
    public void clickOnFinishButton() {
        driver.findElement(finish).click();
    }
}
