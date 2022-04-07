package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class AddCustomerTest extends BaseTest {



    @Test(dataProvider = "getData")
    public void addCustomerByBankManagerTest(HashMap<String, String> data) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("bankManagerLoginBtn")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("addCustomerBtn")))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OR.getProperty("firstNameInputBox")))).sendKeys(data.get("firstName"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OR.getProperty("lastNameInputBox")))).sendKeys(data.get("lastName"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OR.getProperty("postCodeInputBox")))).sendKeys(data.get("postCode"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("addBtn")))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(data.get("alertText")),"alert message is incorrect");

    }


    @DataProvider
    public Object[] getData(){
        return excelReaderUtil.getData(config.getProperty("testDataSheetName")).toArray();
    }
}
