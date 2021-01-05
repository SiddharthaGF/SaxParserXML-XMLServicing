package main.java.xmlsaxparser_xmlservicing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CustomHandler extends DefaultHandler {

    private boolean bid = false;
    private boolean bfirstName = false;
    private boolean blastName = false;
    private boolean bemailId = false;

    private String id = ""; 
    private String firstName = "";
    private String lastName = "";
    private String emailId = "";

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("id")) {
            bid = true;
        }
        if (qName.equalsIgnoreCase("firstName")) {
            bfirstName = true;
        }
        if (qName.equalsIgnoreCase("lastName")) {
            blastName = true;
        }
        if (qName.equalsIgnoreCase("emailId")) {
            bemailId = true;
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (bid) {
            id = new String(ch, start, length);
            print("id: " + id);
            bid = false;
        }
        if (bfirstName) {
            firstName = new String(ch, start, length);
            print("Nombre: " + firstName);
            bfirstName = false;
        }
        if (blastName) {
            lastName = new String(ch, start, length);
            print("Apellido: " + lastName);
            blastName = false;
        }
        if (bemailId) {
            emailId = new String(ch, start, length);
            print("Apellido: " + emailId + "\n");
            bemailId = false;
        }
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

}

