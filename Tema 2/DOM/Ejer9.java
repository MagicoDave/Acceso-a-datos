package DOM;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ejer9 {

    public static boolean modificarDato (Document doc, String nomePelicula, String dato, int numDato, String valor){

        try {
            NodeList peliculas = doc.getElementsByTagName("pelicula");
            for (int i = 0; i < peliculas.getLength(); i++) {
                Element pelicula = (Element) peliculas.item(i);
                NodeList titulos = pelicula.getElementsByTagName("titulo");
                if (titulos.getLength() > 0) {
                    if (titulos.item(0).getFirstChild().getNodeValue().equals(nomePelicula)) {
                        NodeList datos = null;
                        if (dato.equals("titulo")){
                            datos = pelicula.getElementsByTagName(dato);
                        } else if (dato.equals("nombre") || dato.equals("apellido")){
                            NodeList director = pelicula.getElementsByTagName("director");
                            datos = ((Element) director.item(numDato)).getElementsByTagName(dato);
                        }
                        if (datos.getLength() > 0){
                            datos.item(0).getFirstChild().setNodeValue(valor);
                        }    
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
