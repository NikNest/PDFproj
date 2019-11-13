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
    private static String pathGBIFolien = "D:\\KIT_Informatik\\1_Semester\\GBI\\Vorlesung Folien\\01-prolog-folien.pdf";
    private static PDDocument document;
    public static void main(String[] args) throws IOException {
        //read pdf document from path in document
        PDFcreator.createBlankPage(pathBlank, 2);
        document = PDFreader.read(pathGBIFolien);
        PDFdocumentProperties info = new PDFdocumentProperties(document);
        info.printAllProperties();
        //save changes
        document.save(pathGBIFolien);
        document.close();
    }
}
