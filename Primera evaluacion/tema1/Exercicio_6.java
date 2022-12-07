import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercicio_6 {
    
    public static void dividirLineas(File ficheiroEntrada, String ficheiroSalida, int numLineas) {

        try (Scanner sc = new Scanner(ficheiroEntrada)) {

            int cont = 1;

            while (sc.hasNextLine()){

                String salida = ficheiroSalida + "divisionLineas" + cont + ".txt";
                try (PrintWriter fw = new PrintWriter(new FileWriter(salida, false))) {
                    for (int i = 0; i < numLineas && sc.hasNextLine(); i++) {
                        fw.write(sc.nextLine() + "\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cont++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dividirCaracteres(File ficheiroEntrada, String ficheiroSalida, int numCaracteres) {
        
        try (FileReader fr = new FileReader(ficheiroEntrada);
        ) {
            
            int aux = 0;
            int cont = 1;
            int i;

            while ((i = fr.read()) != -1){

                String salida = ficheiroSalida + "divisionCaracteres" + cont + ".txt";
                try (FileWriter fw = new FileWriter(salida, true)) {
                    fw.write(i);
                    aux++;
                    if (aux == numCaracteres){
                        aux = 0;
                        cont++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unir(String ficheiroSalida, File ... ficheiros) {
            for (File ficheiro:ficheiros){
                try (Scanner sc = new Scanner(ficheiro);
                PrintWriter pw = new PrintWriter(new FileWriter(ficheiroSalida, true))) {
                    while (sc.hasNextLine()){
                        pw.write(sc.nextLine());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }

    public static void main(String[] args) {
        
        String documents = System.getProperty("user.home") + "/Documents/";
        File ficheiro = new File("C:/Users/David Casalderrey/Documents/awdad.txt");
        dividirLineas(ficheiro, documents, 4);
        //dividirCaracteres(ficheiro, documents, 10);

        // File test1 = new File("C:/Users/David Casalderrey/Documents/test1.txt");
        // File test2 = new File("C:/Users/David Casalderrey/Documents/test2.txt");
        // File test3 = new File("C:/Users/David Casalderrey/Documents/test3.txt");
        // File test4 = new File("C:/Users/David Casalderrey/Documents/test4.txt");
        // unir(documents + "testsunidos.txt", test1, test2, test3, test4);

    }
}
