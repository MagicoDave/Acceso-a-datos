package SAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MainSAX extends ParserSAX{


    public static void getSax (String entradaXML) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ParserSAX parserSax = new ParserSAX();
        parser.parse(entradaXML, parserSax);
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        
        String entradaXML = System.getProperty("user.home") + "/Documents/peliculas.xml";
        getSax(entradaXML);
    }
    
}
