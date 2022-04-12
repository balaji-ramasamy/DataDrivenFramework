package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviderUtil;

import java.util.HashMap;
import java.util.List;

public class AddCustomerTest extends BaseTest {



    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "getCustomerCreateData", priority = 1)
    public void addCustomerByBankManagerTest(HashMap<String, String> data) throws InterruptedException {

        click(By.cssSelector(OR.getProperty("bankManagerLoginBtn")));
        click(By.cssSelector(OR.getProperty("addCustomerBtn")));
        enter(By.cssSelector(OR.getProperty("firstNameInputBox")), data.get("firstName"));
        enter(By.cssSelector(OR.getProperty("lastNameInputBox")), data.get("lastName"));
        enter(By.cssSelector(OR.getProperty("postCodeInputBox")), data.get("postCode"));
        click(By.cssSelector(OR.getProperty("addBtn")));
        Assert.assertTrue(alertText().contains(data.get("alertText")),"alert message is incorrect");

    }

}
