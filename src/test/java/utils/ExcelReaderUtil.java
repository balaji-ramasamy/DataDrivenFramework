package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ExcelReaderUtil{
    private XSSFWorkbook workbook = null;
    private List<HashMap<String, String>> dataList = new ArrayList<>();

    public ExcelReaderUtil(String filePath){

        try (FileInputStream fis = new FileInputStream(filePath)) {
            workbook  = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<HashMap<String, String>> getData(String sheetName) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            for(int i=1; i<=rowCount;i++){
                HashMap<String, String> map = new HashMap<>();
                for (int j = 0; j < colCount; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                dataList.add(map);
            }
            return dataList;
    }
}
