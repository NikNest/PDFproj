package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

class PDFpicsInsert {
    private PDDocument document;
    //append or prepend
    private boolean append = true;
    //overwrite existing file or not
    private boolean overwrite = true;

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

    void insertPic(int pageIndex, int X, int Y, String pathPic) throws IOException {

        //Retrieving the page
        PDPage page = document.getPage(pageIndex);

        //Creating PDImageXObject object
        PDImageXObject pdImage = PDImageXObject.createFromFile(pathPic,document);

        //creating the PDPageContentStream object
        //PDPageContentStream contents = new PDPageContentStream(document, page);

        PDPageContentStream contents;
        if(overwrite) {
            contents = new PDPageContentStream(
                    document, page, PDPageContentStream.AppendMode.OVERWRITE, false);
            overwrite = false;
        } else if (append) {
            contents = new PDPageContentStream(
                    document, page, PDPageContentStream.AppendMode.APPEND, false);
        } else {
            contents = new PDPageContentStream(
                    document, page, PDPageContentStream.AppendMode.PREPEND, false);
        }



        //Draw an image at the x,y coordinates, with the default size of the image.
        contents.drawImage(pdImage, X, Y);
        //Closing the PDPageContentStream object
        contents.close();
    }

    void setAppend(boolean append) {
        this.append = append;
    }

    void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }
}
