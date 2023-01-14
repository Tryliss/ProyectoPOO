package gestorCelebraciones;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFGenerator {

    private static final String FILE_NAME = "mesas.pdf";

    public static void generatePDF(ArrayList<Mesa> mesas) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);

        PDPageContentStream content = new PDPageContentStream(doc, page);
        
        content.beginText();
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.setLeading(14.5f);
        content.newLineAtOffset(25, 700);

        for (Mesa mesa : mesas) {
            content.showText("Mesa: " + mesa.getLlaveMesa());
            content.newLine();
            content.showText("Comensales: " + mesa.getComensalesMesa().size());
            content.newLine();
            for (Comensal comensal : mesa.getComensalesMesa()) {
                content.showText(comensal.getIdentificador() + ": " + comensal.getNombre() + " " + comensal.getApellidos());
                content.newLine();
            }
            content.newLine();
        }
        content.endText();
        content.close();
        doc.save(new File(FILE_NAME));
        doc.close();
    }
}

