import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.dao.ClientDAO;
import org.example.dao.TourDAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOIExcelWrite {

    private static final String FILE_NAME = "C:\\Users\\andre\\OneDrive\\Рабочий стол\\tmp.xlsx";

    public static void main(String[] args) {
TourDAO tourDAO = new TourDAO();
ClientDAO clientDAO = new ClientDAO();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object[][] datatypes = {
                {tourDAO.toString(tourDAO.findAll())}, {clientDAO.toString(clientDAO.findAll())}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
System.out.println(new TourDAO().findAll().toString());
        System.out.println("Done");
    }
}