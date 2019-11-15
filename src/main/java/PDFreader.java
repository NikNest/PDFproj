package main.java;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFreader {
    private PDDocument document;
    private File file;
    private String path;
    //The PDFTextStripper class provides methods to retrieve text from a PDF document
    private PDFTextStripper pdfStripper;

    PDFreader(String path) throws IOException {
        this.path = path;
        file = new File(path);
        pdfStripper = new PDFTextStripper();
    }
    /**
     * load pdf file
     * @return loaded document
     * @throws IOException
     */
    PDDocument load() throws IOException {
        //Load an existing PDF document using the static method load() of the PDDocument class
        document = PDDocument.load(file);
        return PDDocument.load(file);
    }

    String read() throws IOException {
        return pdfStripper.getText(document);
    }
}
