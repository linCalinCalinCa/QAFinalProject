package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFunctionalityPage extends BasePage {
    public LoginFunctionalityPage(WebDriver driver) {
        super(driver);
    }

    By usernameBox = By.id("user-name");
    public void insertFirstValidUsername(){
        driver.findElement(usernameBox).sendKeys("standard_user");
    }
    public void insertSecondValidUsername(){
        driver.findElement(usernameBox).sendKeys("locked_out_user");
    }
    public void insertThirdValidUsername(){
        driver.findElement(usernameBox).sendKeys("problem_user");
    }
    public void insertFourthValidUsername(){
        driver.findElement(usernameBox).sendKeys("performance_glitch_user");
    }

    public void insertInvalidUsername(){

        driver.findElement(usernameBox).sendKeys("user007");
    }

    By passwordBox = By.id("password");
    public void insertValidPassword(){
        driver.findElement(passwordBox).sendKeys("secret_sauce");
    }
    public void insertInvalidPassword(){
        driver.findElement(passwordBox).sendKeys("notgoodman");
    }

    By loginButton = By.id("login-button");
    public void clickOnTheLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickLogoutButton() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(500);
        driver.findElement(By.id("logout_sidebar_link")).click();
    }









}

