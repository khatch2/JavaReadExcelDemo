import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public List<Customer> readExcelFile(String filePath) {
        List<Customer> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) { // Skippar första raden (rubrikerna)
                    continue;
                }

                // Läs data från varje cell i raden och skapa ett Customer-objekt
                int customerID = (int) row.getCell(0).getNumericCellValue();
                String firstName = row.getCell(1).getStringCellValue();
                String lastName = row.getCell(2).getStringCellValue();
                String phoneNumber = row.getCell(3).getStringCellValue();
                String address = row.getCell(4).getStringCellValue();
                String payingCustomer = row.getCell(5).getStringCellValue();
                String doNotContact = row.getCell(6).getStringCellValue();

                Customer customer = new Customer(customerID, firstName, lastName,
                        phoneNumber, address, payingCustomer,
                        doNotContact);
                dataList.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }
}
