import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        ExcelReader reader = new ExcelReader();
        String filePath = "src/Book1.xlsx";
        List<Customer> customers = reader.readExcelFile(filePath);
        System.out.println();

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}