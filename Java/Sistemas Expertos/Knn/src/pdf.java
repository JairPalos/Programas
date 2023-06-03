import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
 
class pdf {
 
    public static void main(String[] args) {
 
        try {
            File file = new File("hello_world.pdf");
            PdfWriter pdfWriter = new PdfWriter(file);
 
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
 
            Document document = new Document(pdfDocument);
 
            Paragraph paragraph = new Paragraph("Hello World");
 
            document.add(paragraph);
            document.close();
 
            pdfWriter.close();
 
            System.out.println("PDF creado");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}