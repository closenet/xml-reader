import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by mal89 on 15/01/2018.
 */
public class SAXLocalNameCount extends DefaultHandler {



    private Hashtable tags;

    public void startDocument() throws SAXException {
        tags = new Hashtable();
    }


    public void startElement(String namespaceURI,
                             String localName,
                             String qName,
                             Attributes atts)
            throws SAXException {

        String key = localName;
        Object value = tags.get(key);

        if (value == null) {
            tags.put(key, new Integer(1));
        }
        else {
            int count = ((Integer)value).intValue();
            count++;
            tags.put(key, new Integer(count));
        }
    }

    public void characters (char ch[], int start, int length)
            throws SAXException
    {

        System.out.println(ch);
    }

    public static String convertToFileURL(String filename) {
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file:" + path;
    }


    public void endDocument() throws SAXException {

    }




}
