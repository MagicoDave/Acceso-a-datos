import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Exercicio_7 {
    
    public static void ordenarContar(File ficheiro, char operacion){
        
        String ficheiroSalida = System.getProperty("user.home") + "/Documents/" + operacion + "operacion.txt";
        String aux = "";
        char caracteres [];
        char caracteresInversos[];

        try (Scanner sc = new Scanner(ficheiro);
        PrintWriter pw = new PrintWriter(new FileWriter(ficheiroSalida, false))) {

            switch (operacion) {
                case 'n': //Contar liñas e palabras

                    int lineas = 0;
                    int numPalabras = 0;

                    while (sc.hasNextLine()) {

                        lineas++;
                        String palabras[] = sc.nextLine().split("\\s+");
                        numPalabras += palabras.length;
                    }

                    System.out.println("O ficheiro ten " + numPalabras + " palabras e " + lineas + " liñas");
                    break;
                case 'A': //Ordenar ascendente sensible ao caso

                    while (sc.hasNextLine()) {
                        aux += sc.nextLine();
                    }

                    caracteres = aux.toCharArray();
                    Arrays.sort(caracteres);
                    for (char caracter : caracteres){
                        pw.print(caracter);
                    }
                    break;
                case 'D': //Ordenar descendente sensible ao caso

                    while (sc.hasNextLine()) {
                        aux += sc.nextLine();
                    }

                    caracteres = aux.toCharArray();
                    Arrays.sort(caracteres);
                    caracteresInversos = new char[caracteres.length];
                    for (int i = 0; i < caracteres.length; i++) {
                        caracteresInversos[caracteres.length-i-1] = caracteres[i];
                    }
                    for (char caracter : caracteresInversos){
                        pw.print(caracter);
                    }
                    break;
                case 'a': //Ordenar ascendente NON sensible ao caso

                    while (sc.hasNextLine()) {
                        aux += sc.nextLine();
                    }

                    caracteres = aux.toCharArray();
                    
                    break;
                case 'd': //Ordenar descendente NON sensible ao caso

                    while (sc.hasNextLine()) {
                        aux += sc.nextLine();
                    }

                    caracteres = aux.toCharArray();
                    break;
                default:
                    System.out.println("Parámetro de operación no valido");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        File ficheiro = new File("C:/Users/David Casalderrey/Documents/awdad.txt");
        ordenarContar(ficheiro, 'A');

        //TODO Hay que ordenar lineas, no caracteres
    }
}
