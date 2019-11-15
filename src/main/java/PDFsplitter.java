package main.java;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class PDFsplitter {
    private PDDocument document;
    private String[]  newPaths;
    PDFsplitter(PDDocument document) {
        this.document = document;
    }
    void split(String pathPagesSave) throws IOException {
        //The class named Splitter contains the methods to split the given
        //PDF document therefore, instantiate this class as shown below.
        Splitter splitter = new Splitter();
        //You can split the given document using the Split() method of the Splitter
        //class this class. This method accepts an object of the PDDocument class as a parameter.
        List<PDDocument> Pages = splitter.split(document);
        //The split() method splits each page of the given document as an
        //individual document and returns all these in the form of a list.

        //In order to traverse through the list of documents you
        //need to get an iterator object of the list
        Iterator<PDDocument> iterator = Pages.listIterator();
        int i = 1;
        newPaths = new String[Pages.size()];
        String substr1 = pathPagesSave.substring(0, pathPagesSave.length()-4);
        String substr2 = pathPagesSave.substring(pathPagesSave.length()-4);
        while(iterator.hasNext()) {
            PDDocument pd = iterator.next();
            newPaths[i-1] = substr1 + i + substr2;
            pd.save(substr1 + i++ + substr2);
            pd.close();
        }
    }
    String[] getNewPaths() {
        if (newPaths!=null)
            return newPaths;
        else
            return null;
    }
}
