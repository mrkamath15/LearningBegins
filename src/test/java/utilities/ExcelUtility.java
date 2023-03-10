package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
    FileInputStream fileInputStream = null;
    XSSFWorkbook excelWorkbook;
    XSSFSheet excelSheet;

    public ExcelUtility(String filePath) {
        try {
            fileInputStream = new FileInputStream(filePath);
            excelWorkbook = new XSSFWorkbook(fileInputStream);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectSheet(String sheetName) {
        excelSheet = excelWorkbook.getSheet(sheetName);
    }

    public int getRowCount(String sheetName) {
        excelSheet = excelWorkbook.getSheet(sheetName);
        return excelSheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount(String sheetName, int rowNum) {
        excelSheet = excelWorkbook.getSheet(sheetName);
        Row row = excelSheet.getRow(rowNum);
        return row.getPhysicalNumberOfCells();
    }

    public String getCellData(String sheetName, int rowNum, int colNum) {
        excelSheet = excelWorkbook.getSheet(sheetName);
        Row row = excelSheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return cell.getStringCellValue();
    }
}
