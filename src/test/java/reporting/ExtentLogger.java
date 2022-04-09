package reporting;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import utils.ScreenshotUtil;

public class ExtentLogger {


    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getScreenshotAsBASE64()).build());
    }

    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }

}
