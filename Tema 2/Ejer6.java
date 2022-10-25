import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class Ejer6 {
    
    public static void xeneros(Document doc){
        
        ArrayList<String> listaXeneros = new ArrayList<String>();

        NodeList peliculas = doc.getElementsByTagName("pelicula");
        for (int i = 0; i < peliculas.getLength(); i++) {
            Element pelicula = (Element) peliculas.item(i);
            if (pelicula.hasAttributes()){
                NamedNodeMap atributos = pelicula.getAttributes();
                for (int j = 0; j < atributos.getLength(); j++) {
                    if (atributos.item(j).getNodeName() == "genero" && !listaXeneros.contains(atributos.item(j).getNodeValue())){
                        listaXeneros.add(atributos.item(j).getNodeValue());
                    }
                }
            }
            
        }

        System.out.println("Lista de xéneros:");
        for (String x : listaXeneros) {
            System.out.println(x);
        }
    }

}
