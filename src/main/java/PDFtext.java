package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class PDFtext {
    private PDDocument document;
    private PDPageContentStream contentStream;
    //page that will be modified(default: 0)
    private int pageNumber=0;
    //font of text(default: PDType1Font.COURIER)
    private PDType1Font font = PDType1Font.COURIER;
    //font size of text(default: 12)
    private int fontSize = 12;
    //offset of text(default: 25, 700)
    private int[] offset = {25, 700};
    //as default file content will be overwritten
    boolean append = false;

    public PDFtext(PDDocument document) {
        this.document = document;
    }

    //need to add function to enter text with /n that will be translated in the text with few lines

    //PREPAND - under old text
    //APPEND - over old text
    //OVERWRITE - write in a blank document(old content will be deleted)
    public void addText(String text) throws IOException {

        /*
        You can insert various kinds of data elements using the object
        of the class PDPageContentStream.

        You can get the required page in a document using the getPage() method.
        Retrieve the object of the required page by passing
        its index to this method as shown below.
        */

        //RAWRAWRAW

        PDPage page = document.getPage(pageNumber);
        if (append) {
            contentStream = new PDPageContentStream(
                    document, page, PDPageContentStream.AppendMode.APPEND, true);
        } else {
            contentStream = new PDPageContentStream(
                    document, page, PDPageContentStream.AppendMode.OVERWRITE, true);
            //in order to not overwrite the content with next lines
            append = true;
        }
        contentStream.beginText();
        contentStream.newLineAtOffset(offset[0], offset[1]);// X Y from the lower left corner
        contentStream.setFont(font,fontSize);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();

    }
    public void tabulate()
    {
        offset[0] += 25;
    }
    public void nextLine() {
        offset[1] -= 15;
        //tabulating removing
        offset[0] = 25;
    }
    public void previousLine() {
        offset[1] += 15;
        //tabulating removing
        offset[0] = 25;
    }
    /*
    as example rewrite the hall page without the last line
    public void overwritePreviousLine(String text) throws IOException {
        this.addText(text, false);
    }
    */

    public void setDefaltFontOffset(boolean append) {
        if (append) {}
        else {
            this.append = false;
        }
        font = PDType1Font.COURIER;
        offset[0]=25;
        offset[1]=700;

    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setFont(PDType1Font font) {
        this.font = font;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
