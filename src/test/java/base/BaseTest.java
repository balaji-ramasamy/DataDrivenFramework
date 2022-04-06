package base;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver = null;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;


    @BeforeSuite
    public void setUp(){
        if(driver == null){
            try{
                config.load(new FileInputStream(System.getProperty("user.dir")+"src/test/resources/config/config.properties"));
                OR.load(new FileInputStream(System.getProperty("user.dir")+"src/test/resources/config/OR.properties"));
            }
            catch (IOException e){
                e.printStackTrace();
                System.exit(0);
            }

        }
    }

    @AfterSuite
    public void tearDown(){

    }
}
