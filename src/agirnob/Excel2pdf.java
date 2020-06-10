package agirnob;


import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Excel2pdf {
    public static void deneme() throws Exception {
        try {


        String file = System.getProperty("user.home");
        file += "/x.xlsx";
        Workbook workbook = new Workbook(file);


        String file2= System.getProperty("user.home");
        file2+="/pdfCıktı.pdf";
        workbook.save(file2, SaveFormat.PDF);

        // Print message
        System.out.println("Excel to PDF conversion performed successfully.");}
        catch (Exception e){
            System.out.println(e);
        }


    }
}