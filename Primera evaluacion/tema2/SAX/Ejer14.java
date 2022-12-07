package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class Ejer14 extends DefaultHandler {

    String nome = "";
    String cad = "";
    int nivel = 0;
    //int numE

    private String tabular(int nivel) {
        String tabuladores = "";
        for (int i = 0; i < nivel; i++) {
            tabuladores += "\t";
        }
        return tabuladores;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Comezamos a ler o ficheiro");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Terminamos de ler o ficheiro");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        nome = qName;
        nivel++;
        System.out.print(tabular(nivel) + "<" + nome + ">");
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        nome = qName;
        if (cad.length() > 0){
            System.out.println("</" + nome + ">");
        } else {
            System.out.println(tabular(nivel) + "</" + nome + ">");
        }
        
        nivel--;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String cadena = new String(ch, start, length);
        cad = cadena.trim();
        if (!cadena.isBlank()){
            System.out.print(cadena);
        }else System.out.println();
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Aviso: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Error fatal: " + e.getMessage());
    }
}
