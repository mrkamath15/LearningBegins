package utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static Object[][] getTestData() {
        Object[][] data = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(Constants.EXCEL_TEXT_DATA_PATH);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int totalRows = sheet.getPhysicalNumberOfRows();
            System.out.println(totalRows);
            int totalColumns = sheet.getRow(0).getLastCellNum();
            data = new String[totalRows-1][totalColumns];
            System.out.println(totalColumns);
            for (int i = 1; i < totalRows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < totalColumns; j++) {
                    data[i-1][j] = row.getCell(j).getStringCellValue();
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
