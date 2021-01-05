package main.java.xmlsaxparser_xmlservicing;

import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SaxParser {

    private String url;

    public SaxParser(String url) {
        this.url = url;
    }

    public void parse() throws ParserConfigurationException, SAXException, MalformedURLException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        CustomHandler handler = new CustomHandler();
        URLConnection conn = new URL(url).openConnection(); 
        conn.addRequestProperty("Accept", "application/xml");
        InputStream inputStream = conn.getInputStream();
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        InputSource is = new InputSource(reader);
        is.setEncoding("UTF-8");
        saxParser.parse(is, handler);
    }
    
}
