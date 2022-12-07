package DOM;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejer3 {
    
    public static void mostrarTituloAutorXenero(Document doc){
        
        NodeList peliculas = doc.getElementsByTagName("pelicula");
        
        for (int i = 0; i < peliculas.getLength(); i++) {

            System.out.println("********************");
            Element pelicula = (Element) peliculas.item(i);

            NodeList datos = ((Element) pelicula).getElementsByTagName("titulo");
            if (datos.getLength()>0){
                Element titulo = (Element) datos.item(0);
                System.out.println("Título: " + titulo.getFirstChild().getNodeValue());
            }
            datos = ((Element) pelicula).getElementsByTagName("director");
            for (int j = 0; j < datos.getLength(); j++) {
                System.out.println("Nombre: " + Main.getDato(datos.item(j), "nombre"));
                System.out.println("Apellido: " + Main.getDato(datos.item(j), "apellido"));
            }
            if (pelicula.hasAttributes()){
                NamedNodeMap atributos = pelicula.getAttributes();
                for (int j = 0; j < atributos.getLength(); j++) {
                    Node atributo = atributos.item(j);
                    if (atributo.getNodeName() == "genero"){
                        System.out.println("Género: " + atributo.getNodeValue());
                    }
                }
            }

        }
    }
}
