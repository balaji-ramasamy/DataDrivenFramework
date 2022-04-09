package utils;

import base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public final class ScreenshotUtil extends BaseTest {

    public ScreenshotUtil() {

    }

    public static File getScreenshot(String destFileName) {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("Screenprints/"+destFileName+System.currentTimeMillis()+".png");
        try{
            FileHandler.copy(srcFile, destFile );

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return destFile;
    }

    public static String getScreenshotAsBASE64() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }
}
