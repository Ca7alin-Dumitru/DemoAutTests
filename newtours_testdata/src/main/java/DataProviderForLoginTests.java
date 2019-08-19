import io.qameta.allure.Step;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.regex.*;

public class DataProviderForLoginTests {

    @Step
    @DataProvider(name="loginValues")
    public static Object[][] getDataFromDataprovider(){
        /*File input = new File("Test.xlsx");*/
        String verifyInput;
        String REGEX = "%20";

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        verifyInput = classLoader.getResource("Login.xlsx").getFile();
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(verifyInput);
        verifyInput = m.replaceAll(" ");

        File input = new File(verifyInput);

        if(input.exists() && !input.isDirectory()) {
            String myArray[][] = new String[2][2];
            int i = 0;
            try {
                FileInputStream file = new FileInputStream(input);

                // Create Workbook instance holding reference to .xlsx file
                HSSFWorkbook workbook = new HSSFWorkbook(file);

                // Get first/desired sheet from the workbook
                HSSFSheet sheet = workbook.getSheetAt(0);

                // Iterate through each rows one by one
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    // For each row, iterate through all the columns
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int j = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        // Check the cell type and format accordingly
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                myArray[i][j] = Double.toString(cell.getNumericCellValue());
                                break;
                            case STRING:
                                myArray[i][j] = cell.getStringCellValue();
                                break;
                        }
                        j++;
                    }
                    i++;
                }
                file.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            return myArray;
        }else{
            input = new File(classLoader.getResource("newtours_testdata/src/main/resources/Login.xlsx").getFile());
            if(input.exists() && !input.isDirectory()) {
                System.out.println("Jenkins found the excel");
            }
        }


        return new Object[][]{
                { "", "" },
                { "User123", "Pass123" }
        };
    }
}
