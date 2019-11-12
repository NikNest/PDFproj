package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PDFcontentModifier {
    /**
     * adding blank page to document
     * @param document
     */
    public static void addPage(PDDocument document) {
        document.addPage(new PDPage());
    }

    /**
     * removing page pageNumber from file ! page's counting begins with 0(same as arrays)
     * @param document
     * @param pageNumber , page that will be removed
     */
    public static void removePage(PDDocument document, int pageNumber) {
        /*
        You can remove a page from the PDF document using the
        removePage() method of the PDDocument class. To this method,
        you need to pass the index of the page that is to be deleted.
        */
        document.removePage(pageNumber);
    }

}
