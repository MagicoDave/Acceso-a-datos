import java.io.File;
import java.util.Scanner;

public class Exercicio_5 {
    
    public static void buscar(File ficheiro, String cadea) {

        int linea = 0;
        String currentLine;

        try (Scanner sc = new Scanner(ficheiro)) {
            while (sc.hasNextLine()){
                linea ++;
                currentLine = sc.nextLine();
                if (currentLine.contains(cadea)){
                    System.out.printf("Linea %d: %s\n", linea, currentLine);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        
        File ficheiro = new File("C:/Users/David Casalderrey/Documents/awdad.txt");
        buscar(ficheiro, "elit");
    }
}
