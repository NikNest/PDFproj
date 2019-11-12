package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

public class MainMethod {
    private static String pathSimple = "D:\\KIT_Informatik\\1_Semester\\Programmieren"
            + "\\gitproj\\PDFproj\\docs\\SimpleTest.pdf";
    private static String pathBlank = "D:\\KIT_Informatik\\1_Semester\\Programmieren"
            + "\\gitproj\\PDFproj\\docs\\BlankTest.pdf";
    private static String pathIndex = "D:\\KIT_Informatik\\1_Semester\\Programmieren"
            + "\\gitproj\\PDFproj\\docs\\IndexTest.pdf";
    private static PDDocument document;
    public static void main(String[] args) throws IOException {
        //read pdf document from path in document
        document = PDFreader.read(pathIndex);
        PDFcontentModifier.removePage(document, 2);
        document.save(pathIndex);
        document.close();
        PDFcreator.createBlankPage(pathBlank, 3);
    }
}
