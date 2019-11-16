package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.awt.*;
import java.io.IOException;

public class PDFfigure {
    private PDDocument document;
    PDFfigure(PDDocument document){
        this.document = document;
    }
    void addRectangle(int pageIndex) throws IOException {
        PDPage page = document.getPage(pageIndex);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setNonStrokingColor(Color.DARK_GRAY);
        contentStream.addRect(200, 650, 100, 100);
        //The fill() method of the PDPageContentStream class
        //fills the path between the specified dimensions with the required color
        contentStream.fill();
        contentStream.close();
    }
}
