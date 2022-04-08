package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ILogger;

public final class DriverFactory implements ILogger {

    public static WebDriver getDriver(String driverName){
        WebDriver driver=null;
        if (driverName.toLowerCase().equalsIgnoreCase("chrome")) {
            log.info("initiating chrome driver");
            WebDriverManager.chromedriver().setup();
            log.info("launching chrome browser");
            driver =  new ChromeDriver();
        }
        if (driverName.toLowerCase().equalsIgnoreCase("firefox")) {
            log.info("initiating firefox driver");
            WebDriverManager.firefoxdriver().setup();
            log.info("launching firefox browser");
            driver =  new FirefoxDriver();
        }
       return driver;
    }
}
