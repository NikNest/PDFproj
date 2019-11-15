package main.java;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

class PDFmerge {
    static void merge(String createdFilePath, String[] filesToBeMergedPaths) throws IOException {
        //You can merge multiple PDF documents into a single PDF
        //document using the class named PDFMergerUtility class,
        //this class provides methods to merge two or more PDF
        //documents in to a single PDF document.
        PDFMergerUtility PDFmerger = new PDFMergerUtility();
        //Set the destination files using the setDestinationFileName() method as shown below.
        PDFmerger.setDestinationFileName(createdFilePath);
        //Set the source files using the addSource() method
        for(int i = 0;i < filesToBeMergedPaths.length;i++)
        PDFmerger.addSource(filesToBeMergedPaths[i]);
        //read javadoc
        PDFmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }
}
