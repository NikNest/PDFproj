package main.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import java.io.IOException;

class PDFlocer {
    private PDDocument document;
    PDFlocer(PDDocument document) {
        this.document = document;
    }
void lock(String password) throws IOException {
    AccessPermission accessPermission = new AccessPermission();
    //Instantiate the StandardProtectionPolicy class by passing
    //the owner password, user password, and the AccessPermission object as shown below.
    StandardProtectionPolicy spp = new StandardProtectionPolicy("1234",password,accessPermission);
    //Set the encryption key length using the setEncryptionKeyLength() method as shown below.
    spp.setEncryptionKeyLength(128);
    //Set the permissions using the setPermissions() method of the
    //StandardProtectionPolicy class. This method accepts an AccessPermission object as a parameter.
    spp.setPermissions(accessPermission);
    document.protect(spp);
    }
}
