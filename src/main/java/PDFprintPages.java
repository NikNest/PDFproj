package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PDFprintPages {
    PDDocument document;

    PDFprintPages(PDDocument document) {
        this.document = document;
    }

    void prtScn(String pathImage) throws IOException {
        //The class named PDFRenderer renders a PDF document into an AWT BufferedImage.
        PDFRenderer renderer = new PDFRenderer(document);
        //You can render the image in a particular page using the method renderImage()
        //of the Renderer class, to this method you need to pass the index
        //of the page where you have the image that is to be rendered.
        BufferedImage image = renderer.renderImage(0);
        //You can write the image rendered in the previous step to a file using the write() method.
        ImageIO.write(image, "JPEG", new File(pathImage));
    }
}