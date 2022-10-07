import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class dom {

    public Document crearArbore(String ruta){
        Document doc=null;
        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            factoria.setIgnoringComments(true);
            DocumentBuilder builder = factoria.newDocumentBuilder();
            doc = builder.parse(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    public void mostrarTitulos(Document doc){
        NodeList titulos = doc.getElementsByTagName("titulo");
        for (int i = 0; i < titulos.getLength(); i++) {
            System.out.println(titulos.item(i).getFirstChild().getNodeValue());
        }
    }

    public void mostrarTituloAutorXenero(Document doc){
        
        NodeList peliculas = doc.getFirstChild().getChildNodes();
        NodeList datos;
        NamedNodeMap atributos;
        Node pelicula, titulo, nome, apelidos, xenero, atributo;
        
        
        for (int i = 0; i < peliculas.getLength(); i++) {

            System.out.println("********************");
            pelicula = peliculas.item(i);

            datos = ((Element) pelicula).getElementsByTagName("titulo");
            if (datos.getLength()>0){
                titulo = datos.item(0).getFirstChild();
            }
            datos = ((Element) pelicula).getElementsByTagName("director");
            if (datos.getLength()>0){
                nome = datos.item(0).getFirstChild();
                apelidos = datos.item(0).getLastChild();
            }
            if (pelicula.hasAttributes()){
                atributos = pelicula.getAttributes();
                for (int j = 0; j < atributos.getLength(); j++) {
                    atributo = atributos.item(j);
                    if (atributo.getNodeName() == "genero"){
                        xenero = atributo;
                    }
                }
            }

            System.out.printf("Título: %s\tDirector/a: %s %s\tXénero: %s", 
                titulo.getFirstChild().getNodeValue());
        }
    }


    public static void main(String[] args) {
        
        String rutaPeliculas = System.getProperty("user.home") + "/Documents/peliculas.xml";
        dom dom = new dom();

        Document doc = dom.crearArbore(rutaPeliculas);
        dom.mostrarTitulos(doc);
        

    }
}