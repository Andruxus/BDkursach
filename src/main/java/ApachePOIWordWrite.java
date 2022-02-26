import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.dao.ClientDAO;
import org.example.dao.TourDAO;

import java.io.*;


public class ApachePOIWordWrite {

public static void main(String[] args){
    TourDAO tourDAO = new TourDAO();
    ClientDAO clientDAO = new ClientDAO();
    try {
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream( new File("C:\\Users\\andre\\OneDrive\\Рабочий стол\\tmp.docx"));
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(tourDAO.toString(tourDAO.findAll())+"\n");
        run.addBreak();
        run.setText(clientDAO.toString(clientDAO.findAll())+"\n");
        document.write(out);
        out.close();
        System.out.println("createdocument.docx written successully");
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
