package DOM;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ejer7 {

    public static boolean engadirAtributo(Document doc, String nomePelicula, String nomeAtributo,
            String valorAtributo) {

        try {
            NodeList peliculas = doc.getElementsByTagName("pelicula");
            for (int i = 0; i < peliculas.getLength(); i++) {
                Element pelicula = (Element) peliculas.item(i);
                NodeList titulos = pelicula.getElementsByTagName("titulo");
                if (titulos.getLength() > 0) {
                    if (titulos.item(0).getFirstChild().getNodeValue() == nomePelicula) {
                        pelicula.setAttribute(nomeAtributo, valorAtributo);
                        System.out.println("Atributos engadidos");   
                    }
                }
            }
            return true;
        } catch (DOMException e) {
            e.printStackTrace();
            return false;
        }
        
    }

    public static boolean borrarAtributo(Document doc, String nomePelicula, String nomeAtributo) {

        try {
            NodeList peliculas = doc.getElementsByTagName("pelicula");
            for (int i = 0; i < peliculas.getLength(); i++) {
                Element pelicula = (Element) peliculas.item(i);
                NodeList titulos = pelicula.getElementsByTagName("titulo");
                if (titulos.getLength() > 0) {
                    if (titulos.item(0).getFirstChild().getNodeValue() == nomePelicula) {
                        if (pelicula.hasAttribute(nomeAtributo)){
                            pelicula.removeAttribute(nomeAtributo);
                        }
                    }
                }
            }
            return true;
        } catch (DOMException e) {
            e.printStackTrace();
            return false;
        }
    }
}
