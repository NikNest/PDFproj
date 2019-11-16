package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

class PDFpagesExtracter {
    private PDDocument document;
    private PDDocument createdDocument;
    PDFpagesExtracter(PDDocument document) {
        createdDocument = new PDDocument();
        this.document = document;
    }
    void addPage(int pageIndex) {
        PDPage page = document.getPage(pageIndex);
        createdDocument.addPage(page);
    }
    void extractAddedPages(String path) throws IOException {
        createdDocument.save(path);
        createdDocument.close();
    }


}