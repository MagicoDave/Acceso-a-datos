package DOM;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ejer5 {
    
    public static void filtrarPorNumDirectores (Document doc, int n){

        NodeList peliculas = doc.getElementsByTagName("pelicula");
        for (int i = 0; i < peliculas.getLength(); i++) {
            Element pelicula = (Element) peliculas.item(i);
            NodeList directores = pelicula.getElementsByTagName("director");
            if (directores.getLength() > n){
                System.out.println("**************");
                System.out.println("Titulo: " + Main.getDato(pelicula, "titulo"));
                for (int j = 0; j < directores.getLength(); j++) {
                    System.out.println("Nombre: " + Main.getDato(directores.item(j), "nombre"));
                    System.out.println("Apellido: " + Main.getDato(directores.item(j), "apellido"));
                }
            }
        }
    }
}
