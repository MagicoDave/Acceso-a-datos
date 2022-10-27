package DOM;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Ejer1 {
    
    public static Document crearArbore(String ruta, boolean ignorarComentarios){
        Document doc=null;
        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            factoria.setIgnoringComments(ignorarComentarios);
            DocumentBuilder builder = factoria.newDocumentBuilder();
            doc = builder.parse(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }
    
}
