import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exercicio_8 {
    
    public static void copiarArquivo (File ficheiro){
        
        String ficheiroSalida = System.getProperty("user.home") + "/Documents/pruebas/" + "copia" + ficheiro.getName();

        try (FileInputStream fin = new FileInputStream(ficheiro);
        FileOutputStream fout = new FileOutputStream(ficheiroSalida)) {
            int i;
            while ((i=fin.read()) != -1) {
                fout.write(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copiarArquivo (File ficheiro, int buffer){
        
        String ficheiroSalida = System.getProperty("user.home") + "/Documents/pruebas/" + "copia" + ficheiro.getName();

        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(ficheiro), buffer);
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(ficheiroSalida), buffer)) {
            int i;
            while ((i=bin.read()) != -1) {
                bout.write(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        File ficheiro = new File("C:\\Users\\David Casalderrey\\Documents\\pruebas\\instalador.exe");
        //copiarArquivo(ficheiro);
        copiarArquivo(ficheiro, 10000);
    }
}
