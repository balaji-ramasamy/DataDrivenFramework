package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginAsBankManager(){
        log.info("started loginAsBankManager test");
        click(By.cssSelector(OR.getProperty("bankManagerLoginBtn")));
        Assert.assertTrue(isDisplayed(By.cssSelector(OR.getProperty("addCustomerBtn"))), "Login Not Successful");
        log.info("successfully completed loginAsBankManager test");
    }
}
