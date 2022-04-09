package reporting;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    public static void setExtentTest(ExtentTest extTest) {
        extentTest.set(extTest);
    }

    public static void unload(){
        extentTest.remove();
    }

}
