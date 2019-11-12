package main.java;


import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class PDFreader {
    /**
     * read pdf file
     * @param path , of the pdf file
     * @return loaded document
     * @throws IOException
     */
    public static PDDocument read(String path) throws IOException {
        //Load an existing PDF document using the static method load() of the PDDocument class
        File file = new File(path);
        return PDDocument.load(file);
    }
}
