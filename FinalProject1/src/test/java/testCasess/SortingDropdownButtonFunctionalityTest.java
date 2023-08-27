package testCasess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SortingDropdownButtonPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingDropdownButtonFunctionalityTest extends BasePage {
    private SortingDropdownButtonPage sortingDropdownButtonFunctionalityTest;

    @BeforeClass
    public void setUp() {
        super.setUp();
        sortingDropdownButtonFunctionalityTest = new SortingDropdownButtonPage(driver);
        sortingDropdownButtonFunctionalityTest.insertFirstValidUsername();
        sortingDropdownButtonFunctionalityTest.insertValidPassword();
        sortingDropdownButtonFunctionalityTest.clickOnTheLoginButton();
    }

    @Test
    public void testSortingAZ() {
        //website-u este deja sortat de la A la Z
        sortingDropdownButtonFunctionalityTest.clickOnTheDropdownListButton();
        sortingDropdownButtonFunctionalityTest.clickOnTheSecondItemInDropdownListButton();
        sortingDropdownButtonFunctionalityTest.clickOnTheFirstItemInDropdownListButton();

        List<WebElement> childs = driver.findElements(By.cssSelector(".inventory_list .inventory_item"));
        List<String> originalInventoryNameList = new ArrayList<>();
        for (int i = 0; i < childs.size(); i++) {
            String inventoryName = childs.get(i).findElement(By.cssSelector(".inventory_item_name")).getText();
            originalInventoryNameList.add(inventoryName);
        }
        List<String> sortedInventoryNameList = new ArrayList<>(originalInventoryNameList);
        Collections.sort(sortedInventoryNameList);
        Assert.assertEquals(sortedInventoryNameList, originalInventoryNameList);
    }

    @Test
    public void testSortingZA() {
        sortingDropdownButtonFunctionalityTest.clickOnTheDropdownListButton();
        sortingDropdownButtonFunctionalityTest.clickOnTheSecondItemInDropdownListButton();

        List<WebElement> childs = driver.findElements(By.cssSelector(".inventory_list .inventory_item"));
        List<String> originalInventoryNameList = new ArrayList<>();

        for (int i = 0; i < childs.size(); i++) {
            String inventoryName = childs.get(i).findElement(By.cssSelector(".inventory_item_name")).getText();
            originalInventoryNameList.add(inventoryName);

        }
        List<String> sortedInventoryNameList = new ArrayList<>(originalInventoryNameList);
        Collections.sort(originalInventoryNameList, Collections.reverseOrder());
        Assert.assertEquals(sortedInventoryNameList, originalInventoryNameList);
    }

    @Test
    public void testSortingLowToHigh() {
        sortingDropdownButtonFunctionalityTest.clickOnTheDropdownListButton();
        sortingDropdownButtonFunctionalityTest.clickOnTheThirdItemInDropdownButton();

        List<WebElement> childs = driver.findElements(By.cssSelector(".inventory_list .inventory_item"));
        List<Double> originalInventoryPriceList = new ArrayList<>();

        for (int i = 0; i < childs.size(); i++) {
            String inventoryPrice = childs.get(i).findElement(By.cssSelector(".inventory_item_price")).getText();
            double priceValue = Double.parseDouble(inventoryPrice.replace("$", ""));
            originalInventoryPriceList.add(priceValue);
        }

        List<Double> sortedInventoryPriceList = new ArrayList<>(originalInventoryPriceList);
        Collections.sort(sortedInventoryPriceList);

        Assert.assertEquals(sortedInventoryPriceList, originalInventoryPriceList);
    }

    @Test
    public void testSortingHighToLow() {
        sortingDropdownButtonFunctionalityTest.clickOnTheDropdownListButton();
        sortingDropdownButtonFunctionalityTest.clickOnTheFourthItemInDropdownListButton();

        List<WebElement> childs = driver.findElements(By.cssSelector(".inventory_list .inventory_item"));
        List<Double> originalInventoryPriceList = new ArrayList<>();

        for (int i = 0; i < childs.size(); i++) {
            String inventoryPrice = childs.get(i).findElement(By.cssSelector(".inventory_item_price")).getText();
            double priceValue = Double.parseDouble(inventoryPrice.replace("$", ""));
            originalInventoryPriceList.add(priceValue);
        }

        List<Double> sortedInventoryPriceList = new ArrayList<>(originalInventoryPriceList);
        Collections.sort(originalInventoryPriceList, Collections.reverseOrder());

        Assert.assertEquals(sortedInventoryPriceList, originalInventoryPriceList);
    }
}
