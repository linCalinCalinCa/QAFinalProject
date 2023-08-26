package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SortingDropdownButtonPage extends BasePage {
    public SortingDropdownButtonPage(WebDriver driver) {
        super(driver);
    }

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

    By dropdownListButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span");
    public void clickOnTheDropdownListButton() {driver.findElement( dropdownListButton).click();}

    By firstItemInDropdownListButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[1]");
    public void clickOnTheFirstItemInDropdownListButton(){driver.findElement(firstItemInDropdownListButton).click();}

    By secondItemInDropdownListButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[2]");
    public void clickOnTheSecondItemInDropdownListButton() {driver.findElement(secondItemInDropdownListButton).click();}


    By thirdItemInDropdownListButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[3]");
    public void clickOnTheThirdItemInDropdownButton() {driver.findElement(thirdItemInDropdownListButton).click();}

    By fourthItemInDropdownListButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[4]");
    public void clickOnTheFourthItemInDropdownListButton() {driver.findElement(fourthItemInDropdownListButton).click();}






}
