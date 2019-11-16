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
    private int pageIndex =0;
    //font of text(default: PDType1Font.COURIER)
    private PDType1Font font = PDType1Font.COURIER;
    //font size of text(default: 12)
    private int fontSize = 12;
    //offset of text(default: 25, 700)
    private int[] offset = {25, 700};
    //as default file content will be overwritten
    private boolean append = false;

    PDFtext(PDDocument document) {
        this.document = document;
    }

    //need to add function to enter text with /n that will be translated in the text with few lines

    //PREPAND - under old text
    //APPEND - over old text
    //OVERWRITE - write in a blank document(old content will be deleted)
    void addText(String text) throws IOException {

        /*
        You can insert various kinds of data elements using the object
        of the class PDPageContentStream.

        You can get the required page in a document using the getPage() method.
        Retrieve the object of the required page by passing
        its index to this method as shown below.
        */
        PDPage page = document.getPage(pageIndex);
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
        //works only for default method newline()
        contentStream.setLeading(15f);
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
    //contentStream.newLine();  standart method, meby use it?
    void nextLine() throws IOException {
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

    public void setAppend(boolean append) {
        this.append = append;
    }

    public void setDefaltFontOffset(boolean append) {
        font = PDType1Font.COURIER;
        offset[0]=25;
        offset[1]=700;

    }

    void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    void setFont(PDType1Font font) {
        this.font = font;
    }

    void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    void setOffset(int x, int y){
        offset[0]= x;
        offset[1]= y;
    }
}
