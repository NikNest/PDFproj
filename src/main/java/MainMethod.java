package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainMethod {
    private static PDDocument document;
    //created just to try working with map
    //replaces simple initialization
    static Map<String, String> paths;
    MainMethod(){
       paths = new HashMap<String, String>();
       paths.put("pathGBIFolien", "D:\\KIT_Informatik\\1_Semester\\GBI\\" +
               "Vorlesung Folien\\01-prolog-folien.pdf");
       paths.put("pathPicPNG", "D:\\KIT_Informatik\\1_Semester\\Programmieren\\" +
               "gitproj\\PDFproj\\docs\\100x177pic.png");
       paths.put("pathBlank", "D:\\KIT_Informatik\\1_Semester\\Programmieren" +
               "\\gitproj\\PDFproj\\docs\\BlankTest.pdf");
       paths.put("pathRussian", "D:\\KIT_Informatik\\1_Semester\\Programmieren" +
               "\\gitproj\\PDFproj\\docs\\Russian.pdf");
       paths.put("pathGerman", "D:\\KIT_Informatik\\1_Semester\\Programmieren"
               + "\\gitproj\\PDFproj\\docs\\German.pdf");
    }

    public static void main(String[] args) throws IOException {
        //called to initiallize Map paths
        MainMethod temp = new MainMethod();

        //read pdf document from path in document
        PDFcreator.createBlankPage(paths.get("pathBlank"), 1);

        //recive reference on document
        PDFreader pdfFile = new PDFreader(paths.get("pathBlank"));
        document = pdfFile.load();

        PDFtext writer = new PDFtext(document);
        writer.addText("sos");

        //save changes
        document.save(paths.get("pathBlank"));
        document.close();
    }
}
