package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import java.io.IOException;
import java.util.Calendar;

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

    /**
     * This method is used to set the value for the property of the PDF document named Author.
     * @param author
     */
    public void setAuthor(String author){
        documentProperties.setAuthor(author);
    }

    /**
     * This method is used to set the value for the property of the PDF document named Title.
     * @param title
     */
    public void setTitle(String title){
        documentProperties.setTitle(title);
    }

    /**
     * This method is used to set the value for the property of the PDF document named Creator.
     * @param creator
     */
    public void setCreator(String creator){
        documentProperties.setCreator(creator);
    }

    /**
     * This method is used to set the value for the property of the PDF document named Subject.
     * @param subject
     */
    public void setSubject(String subject){
        documentProperties.setSubject(subject);
    }

    /**
     * This method is used to set the value for the property of the PDF document named CreationDate.
     * @param date
     */
    public void setCreationDate(Calendar date){
        documentProperties.setCreationDate(date);
    }

    /**
     * This method is used to set the value for the property of the PDF document named ModificationDate.
     * @param date
     */
    public void setModificationDate(Calendar date){
        documentProperties.setModificationDate(date);
    }

    /**
     * This method is used to set the value for the property of the PDF document named Keywords.
     * @param keywordsList
     */
    public void setKeywords(String keywordsList){
        documentProperties.setKeywords(keywordsList);
    }

    /**
     * This method is used to retrieve the value for the property of the PDF document named Author.
     */
    public String getAuthor(){
        return documentProperties.getAuthor();
    }

    /**
     * This method is used to retrieve the value for the property of the PDF document named Title.
     */
    public String getTitle(){
        return documentProperties.getTitle();
    }

    /**
     * This method is used to retrieve the value for the property of the PDF document named Creator.
     */
    public String setCreator(){
        return documentProperties.getCreator();
    }

    /**
     * This method is used to retrieve the value for the property of the PDF document named Subject.
     */
    public String getSubject(){
        return documentProperties.getSubject();
    }

    /**
     * This method is used to retrieve the value for the property of the PDF document named CreationDate.
     */
    public Calendar getCreationDate(){
        return documentProperties.getCreationDate();
    }

    /**
     * This method is used to retrieve the value for the property of the PDF document named ModificationDate.
     */
    public Calendar getModificationDate(){
        return documentProperties.getModificationDate();
    }

    /**
     * This method is used to retrieve the value for the property of the PDF document named Keywords.
     */
    public String getKeywords(){
        return documentProperties.getKeywords();
    }

    /**
     * prints all properties of
     */
    public void printAllProperties() {
        System.out.println("Author: " + documentProperties.getAuthor());
        System.out.println("Title: " + documentProperties.getTitle());
        System.out.println("Creator: " + documentProperties.getCreator());
        System.out.println("Subject: " + documentProperties.getSubject());
        System.out.println("Creation date: " + documentProperties.getCreationDate());
        System.out.println("Modification date: " + documentProperties.getModificationDate());
        System.out.println("Keywords: " + documentProperties.getKeywords());
    }
    public void saveAllPropertiesAsFile(String path) throws IOException {
        PDDocument document = new PDDocument();
        //...
        document.save(path);
        document.close();
    }

}
