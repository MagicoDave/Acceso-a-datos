import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejer4 {
    
    public static void percorrerArbore(Document doc){

        Element raiz = doc.getDocumentElement();
        debuxar(raiz);

    }

    public static void debuxar(Node nodo, int nivel){
        
        String tabuladores = "";
        for (int i = 0; i < nivel; i++) {
            tabuladores += "\t";
        }

        System.out.println(tabuladores + nodo.getNodeType() + " " + nodo.getNodeName());
        if (nodo.hasChildNodes()){
            NodeList fillos = nodo.getChildNodes();
            for (int i = 0; i < fillos.getLength(); i++) {
                debuxar(fillos.item(i), nivel + 1);
            }
        }
        
    }

    public static void debuxar(Node nodo){

        System.out.println(nodo.getNodeType() + " " + nodo.getNodeName());
        if (nodo.hasChildNodes()){
            NodeList fillos = nodo.getChildNodes();
            for (int i = 0; i < fillos.getLength(); i++) {
                debuxar(fillos.item(i), 1);
            }
        }
    }

    
}
