package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class MainMethod {
    private static String pathSimple = "D:\\KIT_Informatik\\1_Semester\\Programmieren"
            + "\\gitproj\\PDFproj\\docs\\SimpleTest.pdf";
    private static String pathBlank = "D:\\KIT_Informatik\\1_Semester\\Programmieren"
            + "\\gitproj\\PDFproj\\docs\\BlankTest.pdf";
    private static String pathIndex = "D:\\KIT_Informatik\\1_Semester\\Programmieren"
            + "\\gitproj\\PDFproj\\docs\\IndexTest.pdf";
    private static String pathGBIFolien = "D:\\KIT_Informatik\\1_Semester\\GBI\\Vorlesung Folien\\01-prolog-folien.pdf";
    private static PDDocument document;
    public static void main(String[] args) throws IOException {
        //read pdf document from path in document
        //PDFcreator.createBlankPage(pathBlank, 1);
        document = PDFreader.read(pathBlank);

        PDFtext textAdder = new PDFtext(document);

        textAdder.tabulate();
        textAdder.addText("First line");
        textAdder.nextLine();
        textAdder.addText("Second line");
        textAdder.nextLine();
        textAdder.nextLine();
        textAdder.addText("Last line");
        textAdder.previousLine();
        textAdder.tabulate();
        textAdder.addText("Third line");

        //save changes
        document.save(pathBlank);
        document.close();
    }
}
