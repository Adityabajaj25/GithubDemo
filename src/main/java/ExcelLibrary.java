import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelLibrary {
    XSSFWorkbook wb;
    XSSFSheet sheet;
    String excelPath;

    public ExcelLibrary(String filePath) throws Exception {
        excelPath = filePath;
        File file = new File(excelPath);
        FileInputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
    }


    public Object[][] readExcelData(String sheetName) {
        int index = wb.getSheetIndex(sheetName);
        if (index == -1) {
            return null;
        }

        sheet = wb.getSheetAt(index);
        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
                System.out.println(data[i][j]);
            }
        }

        return data;
    }
}
