package DOM;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class Ejer8 {
    
    public static boolean engadirPelicula(Document doc, String titulo, String nome, String apelido, String estrea, String xenero, String version){
        try {

            //Crear nodo pelicula, engadir atributos
            Element nodoPelicula = doc.createElement("pelicula");
            nodoPelicula.setAttribute("genero", xenero);
            nodoPelicula.setAttribute("año", estrea);
            nodoPelicula.setAttribute("idioma", version);
            nodoPelicula.appendChild(doc.createTextNode("\n"));

            //Crear nodo titulo e engadilo a pelicula
            Element nodoTitulo = doc.createElement("titulo");
            Text textnodoTitulo = doc.createTextNode(titulo);
            nodoTitulo.appendChild(textnodoTitulo);
            nodoPelicula.appendChild(nodoTitulo);
            nodoPelicula.appendChild(doc.createTextNode("\n"));

            //Crear nodo director e engadilo a pelicula
            Element nodoDirector = doc.createElement("director");
            Element nodoNome = doc.createElement("nombre");
            Text textnodoNome = doc.createTextNode(nome);
            nodoNome.appendChild(textnodoNome);
            Element nodoApelido = doc.createElement("apellido");
            Text textnodoApelido = doc.createTextNode(apelido);
            nodoApelido.appendChild(textnodoApelido);
            nodoDirector.appendChild(nodoNome);
            nodoDirector.appendChild(nodoApelido);
            nodoPelicula.appendChild(nodoDirector);
            nodoPelicula.appendChild(doc.createTextNode("\n"));

            //Engadir a pelicula a filmoteca
            Node raiz = doc.getFirstChild();
            raiz.appendChild(nodoPelicula);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
