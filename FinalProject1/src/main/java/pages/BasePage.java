package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;

import java.nio.file.Paths;

public class BasePage {
    protected WebDriver driver;
    public String baseURL = "https://www.saucedemo.com/";

    public BasePage() {

    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUp() {
        String driverPath = Paths.get("src/main", "resources/", "chromedriver.exe").toString();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}