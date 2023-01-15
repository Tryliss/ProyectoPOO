package gestorCelebraciones;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDFGenerator {

    private static final String FILE_NAME = "mesas.pdf";

    public static void generatePDF(ArrayList<Mesa> mesas) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDImageXObject pdImage = PDImageXObject.createFromFile("img/fondopdf.png",doc);
        PDPageContentStream content = new PDPageContentStream(doc, page);
        content.drawImage(pdImage, 0, -5);
        content.beginText();
        content.setFont(PDType1Font.COURIER_OBLIQUE, 30);
        content.setLeading(14.5f);
        content.newLineAtOffset(150, 760);
        content.showText("Lista de Comensales");
        content.newLineAtOffset(-50, -50);
     // Set the maximum number of lines per page
        int maxLinesPerPage = 35;

        // Keep track of the current line count
        int currentLineCount = 0;

        for (Mesa mesa : mesas) {
            // Check if the current line count is greater than the maximum
            if (currentLineCount > maxLinesPerPage) {
                // End the current page, create a new page and start a new content stream
                
                content.newLineAtOffset(250, 400);
                currentLineCount = 0;
            }
            content.setFont(PDType1Font.COURIER_OBLIQUE, 15);
            content.showText("Mesa: " + mesa.getLlaveMesa());
            content.newLine();
            content.setFont(PDType1Font.COURIER_OBLIQUE, 10);
            content.showText("Comensales: " + mesa.getComensalesMesa().size());
            content.newLine();
            for (Comensal comensal : mesa.getComensalesMesa()) {
                content.showText(Integer.toString(comensal.getIdentificador()) + ": " + comensal.getNombre() + " " + comensal.getApellidos());
                content.newLine();
                currentLineCount++;
            }
            content.newLine();
            currentLineCount += 2;
        }
        content.endText();
        content.close();
        doc.save(new File(FILE_NAME));
        doc.close();
    }
}

