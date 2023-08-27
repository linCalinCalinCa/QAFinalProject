package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerButtonFunctionalityPage extends BasePage {
    public BurgerButtonFunctionalityPage(WebDriver driver) {
        super(driver);
    }

    By burgerButton = By.id("react-burger-menu-btn");
    public void clickOnTheBurgerButton() {
        driver.findElement(burgerButton).click();
    }

    By firstItemInTheBurgerButtonMenu = By.id("inventory_sidebar_link");
    public void clickOnFirstItemInTheBurgerButtonMenu() {
        driver.findElement(firstItemInTheBurgerButtonMenu).click();
    }

    By secondItemInTheBurgerButtonMenu = By.id("about_sidebar_link");
    public void clickOnSecondItemInTheBurgerButtonMenu() {
        driver.findElement(secondItemInTheBurgerButtonMenu).click();
    }

    By thirdItemInTheBurgerButtonMenu = By.id("logout_sidebar_link");
    public void clickOnThirdItemInTheBurgerButtonMenu() {
        driver.findElement(thirdItemInTheBurgerButtonMenu).click();
    }

    By fourthItemInTheBurgerButtonMenu = By.id("reset_sidebar_link");
    public void clickOnFourthItemInTheBurgerButtonMenu() {
        driver.findElement(fourthItemInTheBurgerButtonMenu).click();
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


}
