import java.io.File;
import java.util.Scanner;

public class Exercicio_3 {

    public static void contar(File ficheiro, char caracter) {

        int c = 0;

        try (Scanner sc = new Scanner(ficheiro)) {
            while (sc.hasNext()) {
                for (char letra : sc.nextLine().toCharArray()) {
                    if (letra == caracter) {
                        c++;
                    }
                }
            }
            System.out.printf("\nNúmero de repeticiones del carácter '%c': %d", caracter, c);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        
        File ficheiro = new File("C:/Users/David Casalderrey/Documents/awdad.txt");
        contar(ficheiro, 'I');
    }
}
