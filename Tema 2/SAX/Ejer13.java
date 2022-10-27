package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ejer13 extends DefaultHandler{
    
    boolean esTitulo = false;

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        this.esTitulo = qName.equals("titulo");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (esTitulo) {
            String titulo = new String(ch, start, length);
            System.out.println(titulo);
            esTitulo = false;
        }
    }
}
