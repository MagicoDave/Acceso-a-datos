import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

public class Exercicio_7 {
    
    public static void ordenarContar(File ficheiro, char operacion){
        
        String ficheiroSalida = System.getProperty("user.home") + "/Documents/" + operacion + "operacion.txt";

        

        try (Scanner sc = new Scanner(ficheiro);
        PrintWriter pw = new PrintWriter(new FileWriter(ficheiroSalida, false))) {
            
            if (operacion == 'n'){

                int lineas = 0;
                
                int numPalabras = 0;
                while (sc.hasNextLine()){
                    
                    lineas++;
                    String palabras[] =  sc.nextLine().split("\\s+");
                    numPalabras += palabras.length;
                }

                System.out.println("O ficheiro ten " + numPalabras + " palabras e " + lineas + " liñas");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        
        File ficheiro = new File("C:/Users/David Casalderrey/Documents/awdad.txt");
        ordenarContar(ficheiro, 'n');
    }
}
