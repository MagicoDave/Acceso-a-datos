package DOM;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

public class Main {

    // Ejemplo Javi, varias formas de hacerlo comentadas
    public static void getDatos(Document doc) {
        NodeList peliculas = doc.getElementsByTagName("pelicula");

        for (int i = 0; i < peliculas.getLength(); i++) {
            Element peli = (Element) peliculas.item(i);
            NodeList titulos = peli.getElementsByTagName("titulo");

            System.out.println("*********************");

            if (titulos.getLength() > 0) {
                System.out.println("Título: " + titulos.item(0).getFirstChild().getNodeValue());
            }

            // NodeList nombre = peli.getElementsByTagName("nombre");
            // NodeList nombre = peli.getElementsByTagName("nombre");
            // for (int j = 0; j < nombre.getLength(); j++) {
            // System.out.println(nombre.item(j).getFirstChild().getNodeValue());
            // System.out.println(apellido.item(j).getFirstChild().getNodeValue());
            // }

            NodeList director = peli.getElementsByTagName("director");
            for (int j = 0; j < director.getLength(); j++) {

                System.out.println("Nombre: " + getDato(director.item(j), "nombre"));
                System.out.println("Apellido: " + getDato(director.item(j), "apellido"));

                // NodeList nombre = ((Element) director).getElementsByTagName("nombre");
                // NodeList apellido = ((Element) director).getElementsByTagName("apellido");

                // if (nombre.getLength() > 0){
                // System.out.println("Nombre: ");
                // }

                // if (apellido.getLength() > 0){
                // System.out.println("Apellido: ");
                // }
            }
        }
    }

    // Ejemplo Javi 2
    public static String getDato(Node nodo, String tag) {
        Element ele = (Element) nodo;
        NodeList datos = ele.getElementsByTagName(tag);
        if (datos.getLength() > 0) {
            return datos.item(0).getFirstChild().getNodeValue();
        }

        return null;
    }

    public static void prueba(Document doc) {
        Node raiz, pelicula, nodoAux, atributo;
        NodeList peliculas, datos;
        NamedNodeMap atributos;
        raiz = doc.getFirstChild();
        System.out.printf("O nodo visualizado e: %s%n", raiz.getNodeName());
        peliculas = raiz.getChildNodes();
        for (int i = 0; i < peliculas.getLength(); i++) {
            pelicula = peliculas.item(i);

            if (pelicula.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("---------------------------------------");
                datos = pelicula.getChildNodes();
                for (int j = 0; j < datos.getLength(); j++) {
                    nodoAux = datos.item(j);
                    if (nodoAux.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(nodoAux.getNodeName() + ":" + nodoAux.getFirstChild().getNodeValue());
                    }
                }
                if (pelicula.hasAttributes()) {
                    atributos = pelicula.getAttributes();
                    for (int k = 0; k < atributos.getLength(); k++) {
                        atributo = atributos.item(k);
                        System.out.printf("Atributo: %s con valor %s%n",
                                atributo.getNodeName(), atributo.getNodeValue());
                    }
                }
            }
        }

    }

    public static void grabaDOM(Document document, FileOutputStream ficheroSalida)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        DOMImplementationLS ls = (DOMImplementationLS) registry.getDOMImplementation("XML 3.0 LS 3.0");

        // Creamos un destino vacio
        LSOutput output = ls.createLSOutput();
        output.setEncoding("UTF-8");

        // Establecemos el fujo de salida
        output.setByteStream(ficheroSalida);
        // output.setByteStream(System.out);

        // Permite estribir un documento DOM en XML
        LSSerializer serializer = ls.createLSSerializer();

        // Establecemos propiedades del serializador
        serializer.setNewLine("\r\n");
        serializer.getDomConfig().setParameter("format-pretty-print", true);

        // Escribimos el documento ya sea en un fichero o en una cadena
        serializer.write(document, output);
        // String xmlCad=serializer.writeToString(document);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {

        //String rutaPeliculas = System.getProperty("user.home") + "/Documents/peliculas.xml";
        String rutaPeliculas = "Tema 2/peliculas.xml";

        Document doc = Ejer1.crearArbore(rutaPeliculas, true);

        // Ejer2.mostrarTitulos(doc);
        // getDatos(doc);
        // Ejer3.mostrarTituloAutorXenero(doc);
        // Ejer4.percorrerArbore(doc);
        // Ejer5.filtrarPorNumDirectores(doc, 1);
        // Ejer6.xeneros(doc);
        // Ejer7.engadirAtributo(doc, "Dune", "Puntuacion", "7");
        // Ejer8.engadirPelicula(doc, "Depredador", "John", "Tiernan", "1987", "Acción", "en");
        Ejer9.modificarDato(doc, "Matrix", "nombre", 1, "Lana");
        grabaDOM(doc, new FileOutputStream(rutaPeliculas));


    }
}