package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginAsBankManager(){
        log.info("started loginAsBankManager test");
        driver.findElement(By.cssSelector(OR.getProperty("bankManagerLoginBtn"))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustomerBtn"))), "Login Not Successful");
        log.info("successfully completed loginAsBankManager test");
    }
}
