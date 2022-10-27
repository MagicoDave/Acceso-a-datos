package DOM;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejer2 {
    
    public static void mostrarTitulos(Document doc){
        NodeList titulos = doc.getElementsByTagName("titulo");
        for (int i = 0; i < titulos.getLength(); i++) {
            System.out.println(titulos.item(i).getFirstChild().getNodeValue());
        }
    }
}
