
package LoginData;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Excel {
    public static void main(String [] args){
        Workbook wb = getWorkbook("E:\\Xunit\\src\\test\\java\\LoginData\\bug.xlsx");
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(0);
        String value = getcell(row.getCell(0));
        System.out.println(value);

    }

    public static Workbook getWorkbook(String filePath) {
        Workbook wb = null;
        try {
            if (filePath.endsWith(".xls")) {
                File file = new File(filePath);
                FileInputStream is = new FileInputStream(file);
                wb = new HSSFWorkbook(is);
                return wb;
            }
        } catch (IOException e) {
            System.out.println(111);
            e.printStackTrace();
        }
        return wb;
    }

    public static String getcell(Cell cell){
        String value="";
        switch (cell.getCellTypeEnum()) {
            case STRING:
                value = String.valueOf(cell.getStringCellValue());
                System.out.println(value);
                return value;
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    value = simpleDateFormat.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                    return value;
                } else {
                    value = String.valueOf(cell.getNumericCellValue());
                    return value;
                }
            case FORMULA:
                value = String.valueOf(cell.getCellFormula());
                return value;
            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                return value;
            case BLANK:
                return value;
            case ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                return value;
            default:
                return value;
        }
    }

}
