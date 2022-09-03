package utilities;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import pojos.Registrant;
import pojos.TestItem;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PDFGenerator {



    public static void pdfGenerator(String header, String fileName){

        Document document = new Document();
        String pdf_path = fileName;
        String pdf_title = header;
        List<String> headers = new ArrayList<String>();
        headers.add("Applicant");
        headers.add("SSN");
        headers.add("Country");
        headers.add("State");
        headers.add("Zip code");

        try{

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdf_path));

            document.open();

            document.add(new Paragraph(pdf_title));

            PdfPTable table = new PdfPTable(5);

            table.setWidthPercentage(110);
            table.setSpacingBefore(12);
            table.setSpacingAfter(12);
            float [] colWidth = {2,2,2,2,2};
            table.setWidths(colWidth);

            for (int i=0; i<headers.size();i++){
                PdfPCell cellHeader = new PdfPCell(new Paragraph("    "+headers.get(i)));
                table.addCell(cellHeader);

            }



            document.add(table);

            document.close();

            writer.close();

        }

        catch(Exception e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        pdfGenerator("MEDUNNA PROJECT", "deneme.pdf");
    }







    public static void pdfGeneratorRowsAndCellsWithList(String header, List <TestItem> list, String fileName){

        Document document = new Document();
        String pdf_path = fileName;
        String pdf_title = header;
        //String logo_path = "src/test/resources/testdata/MedunnaLogo.jpg";

        List<String> headers1 = new ArrayList<String>();
        headers1.add("Applicant");
        headers1.add("SSN");
        headers1.add("Country");
        headers1.add("State");





        try{

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdf_path));

            document.open();

            document.add(new Paragraph("                                     "+pdf_title));

            PdfPTable table = new PdfPTable(headers1.size());
            table.setWidthPercentage(110);
            table.setSpacingBefore(25);
            table.setSpacingAfter(25);
            float [] colWidth = {2,2,2,2};
            table.setWidths(colWidth);



            for(int i=0;i<headers1.size();i++) {

                PdfPCell cell1 = new PdfPCell(new Phrase(headers1.get(i)));
                table.addCell(cell1);

            }

            table.setHeaderRows(list.size());

            for(int i=0;i<list.size();i++ ) {

                table.addCell(list.get(i).getName());
                table.addCell(list.get(i).getDescription());
                table.addCell(list.get(i).getDefaultValMin());
                table.addCell(list.get(i).getDefaultValMax());

            }
            document.add(table);

            //document.add(Image.getInstance(logo_path));
            document.close();

            writer.close();

        }

        catch(Exception e){
            e.printStackTrace();
        }


    }

}