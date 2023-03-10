package tests;

import org.testng.annotations.Test;
import utilities.Constants;
import utilities.ExcelUtility;

public class ExcelTests {

    @Test
    public void excelTest() {
        ExcelUtility utility = new ExcelUtility(Constants.EXCEL_TEXT_DATA_PATH);
        System.out.println("Total Rows : " + utility.getRowCount("data"));
        System.out.println("Total Columns : " + utility.getColumnCount("data", 0));
        System.out.println("Cell Data : " + utility.getCellData("data", 0, 1));


        int rowCount = utility.getRowCount("data");
        int colCount = utility.getColumnCount("data", 0);

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.print(utility.getCellData("data", i, j) + "     ");
            }
            System.out.println();
        }
    }
}
