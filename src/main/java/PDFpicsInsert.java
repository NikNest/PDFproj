package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class PDFpicsInsert {
    private PDDocument document;

    /**
     * @param doc , document that will be edited
     * @throws IOException
     */
    PDFpicsInsert(PDDocument doc) throws IOException {
        document = doc;
    }

    /**
     * You can insert an image into a PDF document using
     * the createFromFile() and drawImage() methods of the
     * classes PDImageXObject and PDPageContentStream respectively.
     * @param pageIndex , index of page where the picture will be inserted
     * @param X , not the height of the picture
     * @param Y , not the width of the picture
     * @param pathPic , path to the picture
     * @throws IOException
     */

    public void insertPic(int pageIndex, int X, int Y, String pathPic) throws IOException {

        //Retrieving the page
        PDPage page = document.getPage(pageIndex);

        //Creating PDImageXObject object
        PDImageXObject pdImage = PDImageXObject.createFromFile(pathPic,document);

        //creating the PDPageContentStream object
        PDPageContentStream contents = new PDPageContentStream(document, page);

        //Draw an image at the x,y coordinates, with the default size of the image.
        contents.drawImage(pdImage, X, Y);

        //Closing the PDPageContentStream object
        contents.close();
    }


}
