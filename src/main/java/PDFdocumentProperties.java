package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PDFdocumentProperties {
    private PDDocumentInformation documentProperties;

    /**
     * initialize PDDocumentInformation object(has info about document)
     * @param document
     */
    public PDFdocumentProperties(PDDocument document) {
        /*
            PDFBox provides a class called PDDocumentInformation and this class provides
            various methods. These methods can set various properties to the document and retrieve them.
        */
        documentProperties = document.getDocumentInformation();
    }

    public void setAuthor(String author) {
        documentProperties.setAuthor(author);
    }

    public void setTitle(String title) {
        documentProperties.setTitle(title);
    }

    public void setCreator(String creator) {
        documentProperties.setCreator(creator);
    }

    public void setSubject(String subject) {
        documentProperties.setSubject(subject);
    }

    /**
     * @param dateStr , yyyy.mm.dd
     */
    public void setCreationDate(String dateStr){
        try {
            //date from string to string array
            String[] dateDMY = dateStr.split("\\.");
            //wrong input checking
            if (dateDMY.length !=3) throw(new Exception());
            //creating date for pdfbox API method
            //-1 because GregorianCalendar interpreat 01.00.2000 as 1 jan
            Calendar date = new GregorianCalendar(Integer.parseInt(dateDMY[2]),
                    Integer.parseInt(dateDMY[1])-1, Integer.parseInt(dateDMY[0]));
            documentProperties.setCreationDate(date);
        }catch(Exception e){
        System.out.println("Wrong Date input(DD.MM.YYYY)");
        }
    }

    /**
     * @param dateStr , yyyy.mm.dd
     */
    public void setModificationDate(String dateStr){
        try {
            //date from string to string array
            String[] dateDMY = dateStr.split("\\.");
            //wrong input checking
            if (dateDMY.length !=3) throw(new Exception());
            //creating date for pdfbox API method
            //-1 because GregorianCalendar interpreat 01.00.2000 as 1 jan
            Calendar date = new GregorianCalendar(Integer.parseInt(dateDMY[2]),
                    Integer.parseInt(dateDMY[1])-1, Integer.parseInt(dateDMY[0]));
            documentProperties.setModificationDate(date);
        }catch(Exception e){
            System.out.println("Wrong Date input(DD.MM.YYYY)");
        }
    }

    public void setKeywords(String keywordsList) {
        documentProperties.setKeywords(keywordsList);
    }

    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    public String getAuthor() {
        return documentProperties.getAuthor();
    }

    public String getTitle() {
        return documentProperties.getTitle();
    }

    public String getCreator() {
        return documentProperties.getCreator();
    }

    public String getSubject() {
        return documentProperties.getSubject();
    }

    public String getCreationDate() {
        //calender performance sucks
        Calendar date = documentProperties.getCreationDate();
        //it helps somehow
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        if(date == null)
            return null;
        else
            return sdf.format(date.getTime());

    }

    public String getModificationDate(){
        //calender performance sucks
        Calendar date = documentProperties.getModificationDate();
        //it helps somehow
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        if(date == null)
            return null;
        else
            return sdf.format(date.getTime());
    }

    public String getKeywords() {
        return documentProperties.getKeywords();
    }

    /**
     * prints all properties of pdf in terminal
     */
    public void printAllProperties() {
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Creator: " + this.getCreator());
        System.out.println("Subject: " + this.getSubject());
        System.out.println("Creation date: " + this.getCreationDate());
        System.out.println("Modification date: " + this.getModificationDate());
        System.out.println("Keywords: " + this.getKeywords());
    }
    public void saveAllPropertiesAsFile(String path) throws IOException {
        PDDocument document = new PDDocument();
        //...
        document.save(path);
        document.close();
    }

}
