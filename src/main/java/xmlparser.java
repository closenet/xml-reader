import java.io.*;
import java.util.*;

import com.sun.org.apache.xerces.internal.util.SAXLocatorWrapper;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
public class xmlparser {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, SAXParseException {
        String inputFile = "/Users/mal89/Workspace/xmljson-parsors/src/main/resources/demo.xml";


        SAXParserFactory df = SAXParserFactory.newInstance();
        SAXParser sap = df.newSAXParser();
        DefaultHandler handler = new DefaultHandler();
        sap.parse(inputFile, handler);

        XMLReader xmlReader = sap.getXMLReader();
        xmlReader.setContentHandler(new SAXLocalNameCount());
        xmlReader.parse(SAXLocalNameCount.convertToFileURL(inputFile));

         System.out.println(xmlReader);

    }



}




