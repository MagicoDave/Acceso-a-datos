import java.io.File;

/**
 * Prueba
 */
public class Exercicio_2 {

    public static void infoDirectorio(File directorio) {
        
        if (directorio.isDirectory()){
            for (File ficheiro:directorio.listFiles()){
                System.out.printf("%s\n", ficheiro.getAbsolutePath());
                if (ficheiro.isDirectory()){
                    infoDirectorio(ficheiro);
                }
            }
        }
    }

    public static void main(String[] args) {
        
        File ficheiro = new File("C:/Users/David Casalderrey/Documents/Acceso a Datos");
        infoDirectorio(ficheiro);
    }


}