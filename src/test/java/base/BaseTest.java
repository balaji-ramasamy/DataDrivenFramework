package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver = null;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = LogManager.getLogger();


    @BeforeSuite
    public void setUp(){
        if(driver == null){
            try{
                config.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties"));
                OR.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/OR.properties"));

            }
            catch (IOException e){
                e.printStackTrace();
                System.exit(0);
            }

        }

        if(config.getProperty("browser").toLowerCase().equalsIgnoreCase("chrome")) {
            log.info("initiating chrome driver");
            WebDriverManager.chromedriver().setup();
            log.info("launching chrome browser");
            driver = new ChromeDriver();
        }
        if(config.getProperty("browser").toLowerCase().equalsIgnoreCase("firefox")) {
            log.info("initiating firefox driver");
            WebDriverManager.firefoxdriver().setup();
            log.info("launching firefox browser");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        log.info("navigating to URL: "+config.getProperty("url"));
        driver.get(config.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(config.getProperty("implicit.wait"))));
    }

    @AfterSuite
    public void tearDown(){
        if(Objects.nonNull(driver))
            log.info("quitting the driver");
        driver.quit();
    }

    protected boolean isElementPresent(By locator){
        try{
            driver.findElement(locator);
            return true;
        }
        catch(NoSuchElementException e){
            log.error(e.getMessage());
            return false;
        }
    }
}
