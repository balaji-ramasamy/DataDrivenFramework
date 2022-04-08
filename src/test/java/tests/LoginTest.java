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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("bankManagerLoginBtn")))).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("addCustomerBtn"))));
        Assert.assertTrue(element.isDisplayed(), "Login Not Successful");
        Assert.fail();
        log.info("successfully completed loginAsBankManager test");
    }
}
