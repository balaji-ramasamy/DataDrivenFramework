package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public final class ExtentReport {

    public static ExtentReports extentReport;
    public static void initReport() {
            extentReport = new ExtentReports();

            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +
                    "/extent-reports/" + System.currentTimeMillis() + "_index.html");

            extentReport.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setDocumentTitle("Projects - Data Driven Framwework");
            extentSparkReporter.config().setReportName("Test Automation Report");
            extentSparkReporter.config().setTheme(Theme.STANDARD);
    }

    public static void createTest(String testName){
     ExtentManager.setExtentTest(extentReport.createTest(testName));
    }

    public static void flushReport(){
        if(Objects.nonNull(extentReport))
         extentReport.flush();
    }
}
