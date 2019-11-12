package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFcontentAnalyzer {
    /**
     * method named same as method of PDDocument class realizes the same funktion
     * @param document
     * @return number of pages of document
     */
    public static int getNumberOfPages(PDDocument document) {
        /*You can list the number of pages that exists in the
        PDF document using the getNumberOfPages() method as shown below.*/
        return document.getNumberOfPages();
    }
}
