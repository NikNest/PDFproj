package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class PDFcreator {
    /**
     * create pdf file with numberOfPages blank pages
     * @param path , path to creatable file
     * @param numberOfPages , number of blank pages in new file
     * @throws IOException
     */
    public static void createBlankPage(String path, int numberOfPages) throws IOException {
        //create an empty document
        PDDocument document = new PDDocument();
        for(int i=0;i<numberOfPages;i++) {
            /*PDPage class represents a page in the PDF, you can
            create an empty page by instantiating this class*/
            PDPage blankPage = new PDPage();
            //adding page to the document
            document.addPage(blankPage);
        }
        //save document in location
        document.save(path);
        document.close();
    }
}
