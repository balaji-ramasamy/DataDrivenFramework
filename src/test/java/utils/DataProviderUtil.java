package utils;

import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProviderUtil {

    private static Properties config = new Properties();

   static{
       try
       {
           config.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties"));
       }catch(IOException e){
           e.printStackTrace();
       }
   }


    @DataProvider
    public static Object[] getCustomerCreateData(){
        ExcelReaderUtil.loadSheet(config.getProperty("customerTestDataSheetName"));
        return ExcelReaderUtil.getData().toArray();
    }

    @DataProvider
    public static Object[] getAccountCreateData(){
        ExcelReaderUtil.loadSheet(config.getProperty("accountTestDataSheetName"));
        return ExcelReaderUtil.getData().toArray();
    }
}
