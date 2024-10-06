import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        ExcelReader reader = new ExcelReader();
        String path = "src/Book1.xlsx";
        List<Customer> customers = reader.readExcelFile(path);
    }
}