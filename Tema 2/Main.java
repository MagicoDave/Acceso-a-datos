
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Main {

   //Ejemplo Javi, varias formas de hacerlo comentadas
    public static void getDatos(Document doc){
        NodeList peliculas = doc.getElementsByTagName("pelicula");

        for (int i = 0; i < peliculas.getLength(); i++) {
            Element peli = (Element) peliculas.item(i);
            NodeList titulos = peli.getElementsByTagName("titulo");

            System.out.println("*********************");

            if (titulos.getLength() >0){
                System.out.println("Título: " + titulos.item(0).getFirstChild().getNodeValue());
            }

            // NodeList nombre = peli.getElementsByTagName("nombre");
            // NodeList nombre = peli.getElementsByTagName("nombre");
            // for (int j = 0; j < nombre.getLength(); j++) {
            //     System.out.println(nombre.item(j).getFirstChild().getNodeValue());
            //     System.out.println(apellido.item(j).getFirstChild().getNodeValue());
            // }

            NodeList director = peli.getElementsByTagName("director");
            for (int j = 0; j < director.getLength(); j++) {

                System.out.println("Nombre: " + getDato(director.item(j), "nombre"));
                System.out.println("Apellido: " + getDato(director.item(j), "apellido"));

                // NodeList nombre = ((Element) director).getElementsByTagName("nombre");
                // NodeList apellido = ((Element) director).getElementsByTagName("apellido");

                // if (nombre.getLength() > 0){
                //     System.out.println("Nombre: ");
                // }

                // if (apellido.getLength() > 0){
                //     System.out.println("Apellido: ");
                // }
            }
        }
    }

    //Ejemplo Javi 2
    public static String getDato(Node nodo, String tag){
        Element ele = (Element) nodo;
        NodeList datos = ele.getElementsByTagName(tag);
        if (datos.getLength() > 0){
            return datos.item(0).getFirstChild().getNodeValue();
        }

        return null;
    }

    
    


    public static void main(String[] args) {
        
        String rutaPeliculas = System.getProperty("user.home") + "/Documents/peliculas.xml";

        Document doc = Ejer1.crearArbore(rutaPeliculas, true);

        // Ejer2.mostrarTitulos(doc);
        // getDatos(doc);
        // Ejer3.mostrarTituloAutorXenero(doc);
        //Ejer4.percorrerArbore(doc);
        Ejer5.filtrarPorNumDirectores(doc, 2);
        

    }
}