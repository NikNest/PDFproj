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
    private static String pathPic = "D:\\KIT_Informatik\\1_Semester\\Programmieren\\"
            + "gitproj\\PDFproj\\docs\\smallpic.png";
    private static String pathPicSmall = "D:\\KIT_Informatik\\1_Semester\\Programmieren"
            + "\\gitproj\\PDFproj\\docs\\100x177pic.png";
    private static PDDocument document;
    public static void main(String[] args) throws IOException {
        //read pdf document from path in document
        PDFcreator.createBlankPage(pathBlank, 1);

        //recive reference on document
        PDFreader pdfFile = new PDFreader(pathBlank);
        document = pdfFile.load();


        //save changes
        document.save(pathBlank);
        document.close();
    }
}
