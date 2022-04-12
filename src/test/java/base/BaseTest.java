package base;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExcelReaderUtil;
import utils.ILogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

public class BaseTest implements ILogger {

    protected static WebDriver driver = null;
    protected static Properties config = new Properties();
    protected static Properties OR = new Properties();
    protected static WebDriverWait wait;

    @BeforeSuite
    public void setUp() {
        try {
            config.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties"));
            OR.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/OR.properties"));
            ExcelReaderUtil.loadExcel(System.getProperty("user.dir")+config.getProperty("excelFilePath"));

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }


    @BeforeMethod
    public void initializeDriver() {

        DriverManager driverManager = new DriverManager();
        driver = driverManager.initDriver(config.getProperty("browser"));
        driver.manage().window().maximize();
        log.info("navigating to URL: " + config.getProperty("url"));
        driver.get(config.getProperty("url"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(config.getProperty("explicit.wait"))));

    }

    @AfterMethod
    public void tearDown() {
        if (Objects.nonNull(driver))
            log.info("quitting the driver");
        driver.quit();
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void enter(By locator, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
    protected String alertText(){
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    protected boolean isDisplayed(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected void select(By locator, String value){
      Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
      select.selectByVisibleText(value);
    }
}
