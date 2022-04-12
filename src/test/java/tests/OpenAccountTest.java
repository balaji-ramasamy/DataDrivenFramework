package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataProviderUtil;

import java.util.HashMap;

public class OpenAccountTest extends BaseTest {

    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "getAccountCreateData")
    public void openAccountTest(HashMap<String, String>data){
        click(By.cssSelector(OR.getProperty("bankManagerLoginBtn")));
        click(By.cssSelector(OR.getProperty("openAccountButton")));
        select(By.cssSelector(OR.getProperty("customerDropDown")), data.get("customerName"));
        select(By.cssSelector(OR.getProperty("currencyDropDown")),data.get("currency"));
        click(By.cssSelector(OR.getProperty("processButton")));
        Assert.assertTrue(alertText().contains("Account created successfully"), "alert is not displayed or alert contains incorrect message");
    }

}
