package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {


    public WebDriver initDriver(String browser) {
        return DriverFactory.getDriver(browser);
    }

}
